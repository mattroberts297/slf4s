import sbt._
import Keys._

object Slf4sBuild extends Build {
  lazy val slf4s = Project("sl4s-api", file(".")) settings(
    organization := "org.slf4s",
    name := "slf4s-api",
    scalaVersion := "2.10.4",
    scalacOptions := Seq("-language:experimental.macros"),
    version := "1.7.10",
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { _ => false },
    makePomConfiguration ~= { _.copy(configurations = Some(Seq(Compile, Runtime, Optional))) },
    licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
    homepage := Some(url("http://slf4s.org/")),
    scmInfo := Some(ScmInfo(url("https://github.com/mattroberts297/slf4s"), "https://github.com/mattroberts297/slf4s", None)),
    pomExtra := (
      <developers>
        <developer>
          <id>mattroberts297</id>
          <name>Matt Roberts</name>
          <email>mattroberts297@gmail.com</email>
          <url>http://mattro.be/rts/</url>
        </developer>
      </developers>
    ),
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
       Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    },
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % "2.10.4",
      "org.slf4j" % "slf4j-api" % "1.7.10",
      "org.scalatest" %% "scalatest" % "2.2.4" % "test",
      "org.mockito" % "mockito-all" % "1.10.19" % "test"
    )
  )
}
