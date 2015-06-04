[![Build Status](https://travis-ci.org/mattroberts297/slf4s.png?branch=2.9)](https://travis-ci.org/mattroberts297/slf4s)

# About
A Simple Logging Facade for Scala (SLF4S) built on top of SLF4J.

# Features
* Call by macro expansion in Scala 2.10 and 2.11;
* Call by name in Scala 2.9;
* A Logging Mixin for conveniently obtaining a Logger; and
* A LoggerFactory that is ClassTag aware.

The use of macros means that calls to `log.debug` become `if (log.isDebugEnabled) log.debug` at compile time.

# Installation
### Build.scala
```scala
libraryDependencies ++= Seq(
  "org.slf4s" %% "slf4s-api" % "1.7.12",
  "ch.qos.logback" % "logback-classic" % "1.1.2"
)
```

> You don't have to use [logback](http://logback.qos.ch/), any [slf4j](http://www.slf4j.org/) compatible framework will do.

# Usage
### Logging Trait
The `Logging` trait provides a `protected val log` to your class, so it'll be available in the local scope, but won't pollute your interface. You can also reference it via a self type if you're using the cake pattern.
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
The `LoggerFactory` gives you great flexibility and behaves much like the [slf4j](http://www.slf4j.org/) LoggerFactory. You probably only need to use this if you wish to log as a class other than the one in scope.
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

### String Interpolation
Scala 2.10.0 offers a new mechanism to create strings from your data: [String Interpolation](http://docs.scala-lang.org/overviews/core/string-interpolation.html). This allows you to to embed variable references and expressions directly in processed string literals.

``` scala
package org.slf4s

import org.scalatest.WordSpec

class StringInterpolatorExampleSpec extends WordSpec with Logging {
  
  "String interpolation should work" in {
    val name = "James"
    val height = 1.9d
    log.debug(s"Hello, $name")  // Hello, James
    log.debug(s"1 + 1 = ${1 + 1}") // 1 + 1 = 2
    log.debug(f"$name%s is $height%2.2f meters tall")  // James is 1.90 meters tall
    log.debug(raw"a\nb") // New line is preserved
  }
}
```

# Documentation
For those who prefer not to use an IDE, I've made the [ScalaDoc](http://slf4s.org/api/1.7.12/) available online.

> The library is very small, but there are a few methods not mentioned above.
