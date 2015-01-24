package org.slf4s

import org.scalatest.WordSpec

class LoggerFactoryExampleSpec extends WordSpec {
  "The LoggerFactory should be familiar" in {
    val log = LoggerFactory.getLogger[LoggerFactoryExampleSpec]
    val importantValue = 10
    log.debug("importantValue: %d".format(importantValue))
    val importantThrowable = new Throwable
    log.debug("importantThrowable", importantThrowable)
  }
}
