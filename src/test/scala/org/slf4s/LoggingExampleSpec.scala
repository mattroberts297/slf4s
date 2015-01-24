package org.slf4s

import org.scalatest.WordSpec

class LoggingExampleSpec extends WordSpec with Logging {
  "The Logging trait should be easy to use" in {
    val importantValue = 10
    log.debug("importantValue: %d".format(importantValue))
    val importantThrowable = new Throwable
    log.debug("importantThrowable", importantThrowable)
  }
}
