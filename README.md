# slf4s

Simple Logging Facade for Scala

# Features
* Logger methods that support lazy evaluation of messages;
* Logger methods that have the @inline hint;
* A Logging Mixin for conveniently obtaining a Logger; and
* A LoggerFactory that is ClassTag aware.

# Installation
### Build.scala
```scala
      libraryDependencies ++= Seq(
        "org.slf4s" %% "slf4s-api" % "1.7.5",
        "ch.qos.logback" % "logback-classic" % "1.1.0"
      )
```

> You don't have to use [logback](http://logback.qos.ch/), any [slf4j](http://www.slf4j.org/) compatible framework will do.

# Usage
### Logging Mixin (trait)
```scala
package org.slf4s

import org.scalatest.WordSpec

class LoggingExampleSpec extends WordSpec with Logging {
  "The Logging trait should be easy to use" in {
    val importantValue = 10
    log.debug(s"importantValue: $importantValue")
    val importantThrowable = new Throwable
    log.debug(s"importantValue: $importantValue", importantThrowable)
  }
}
```

### Logger Factory (object)
``` scala
package org.slf4s

import org.scalatest.WordSpec

class LoggerFactoryExampleSpec extends WordSpec {
  "The LoggerFactory should be familiar" in {
    val log = LoggerFactory.getLogger[LoggerFactoryExampleSpec]
    val importantValue = 10
    log.debug(s"importantValue: $importantValue")
    val importantThrowable = new Throwable
    log.debug(s"importantValue: $importantValue", importantThrowable)
  }
}
```
