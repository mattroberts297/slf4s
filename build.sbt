lazy val slf4s = (project in file(".")).settings(
  organization := "org.slf4s",
  name := "slf4s-api",
  scalaVersion := "2.12.1",
  scalacOptions := Seq("-unchecked", "-deprecation", "-language:experimental.macros"),
  version := "1.7.25",
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVersion.value,
    "org.slf4j" % "slf4j-api" % version.value,
    "org.scalatest" %% "scalatest" % "3.0.1" % "test",
    "org.mockito" % "mockito-core" % "2.7.22" % "test",
    "ch.qos.logback" % "logback-classic" % "1.2.3" % "test"
  ),

  pgpPassphrase := Option(env("PGP_PASSPHRASE")).map(_.toCharArray),
  pgpSecretRing := file("local.secret.asc"),
  pgpPublicRing := file("local.public.asc"),

  credentials += Credentials(
    "Sonatype Nexus Repository Manager",
    "oss.sonatype.org",
    "mattroberts297",
    env("SONATYPE_PASSWORD")
  ),

  publishMavenStyle := true,
  publishArtifact in Test := false,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },

  makePomConfiguration ~= {
    _.copy(configurations = Some(Seq(Compile, Runtime, Optional)))
  },
  pomIncludeRepository := {
    _: sbt.MavenRepository => false
  },

  licenses := Seq("MIT" -> url("https://github.com/mattroberts297/slf4s/blob/master/LICENSE")),
  homepage := Some(url("http://slf4s.org/")),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/mattroberts297/slf4s"),
      "scm:git@github.com:mattroberts297/slf4s.git"
    )
  ),
  developers := List(
    Developer(
      id    = "mattroberts297",
      name  = "Matt Roberts",
      email = "mail@mattroberts.io",
      url   = url("https://mattroberts.io")
    )
  )
)

def env(name: String): String = System.getenv().get(name)
