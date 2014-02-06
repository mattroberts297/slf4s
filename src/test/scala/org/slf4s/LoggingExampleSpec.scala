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
