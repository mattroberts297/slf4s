package org.slf4s

import org.scalatest.WordSpec

class ExampleSpec extends WordSpec with Logging {
  "Logging should be easy" in {
    val importantValue = 10
    log.debug(s"importantValue: $importantValue")
    val importantThrowable = new Throwable
    log.debug(s"importantValue: $importantValue", importantThrowable)
  }

  "Loggers should be nameable" in {
    val myAwesomeLogger = LoggerFactory.getLogger("my.awesome.logger")
    myAwesomeLogger.debug("ace")
  }
}
