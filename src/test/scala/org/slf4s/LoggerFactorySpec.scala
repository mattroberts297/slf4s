package org.slf4s

import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers

class LoggerFactorySpec extends WordSpec with ShouldMatchers {
  "The LoggerFactory" when {
    "apply[A: Manifest] is invoked" should {
      "return a Logger" in {
        val logger = LoggerFactory[LoggerFactorySpec]
        logger.isInstanceOf[Logger] should be (true)
      }
    }

    "apply(name: String) is invoked" should {
      "return a Logger" in {
        val logger = LoggerFactory("foo")
        logger.isInstanceOf[Logger] should be (true)
      }
    }

    "apply(clazz: Class[_]) is invoked" should {
      "return a Logger" in {
        val logger = LoggerFactory(classOf[LoggerFactorySpec])
        logger.isInstanceOf[Logger] should be (true)
      }
    }


    "getLogger[A: Manifest] is invoked" should {
      "return a Logger" in {
        val logger = LoggerFactory.getLogger[LoggerFactorySpec]
        logger.isInstanceOf[Logger] should be (true)
      }
    }

    "getLogger(name: String) is invoked" should {
      "return a Logger" in {
        val logger = LoggerFactory.getLogger("foo")
        logger.isInstanceOf[Logger] should be (true)
      }
    }

    "getLogger(clazz: Class[_]) is invoked" should {
      "return a Logger" in {
        val logger = LoggerFactory.getLogger(classOf[LoggerFactorySpec])
        logger.isInstanceOf[Logger] should be (true)
      }
    }
  }
}
