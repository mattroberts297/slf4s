package org.slf4s

import org.scalatest.{WordSpec, Matchers}

class LoggerFactorySpec extends WordSpec with Matchers {
  "The LoggerFactory" when {
    "apply[A: Manifest] is invoked" should {
      "return a Logger" in {
        val logger = LoggerFactory[LoggerFactorySpec]
        logger shouldBe a [Logger]
      }
    }

    "apply(name: String) is invoked" should {
      "return a Logger" in {
        val logger = LoggerFactory("foo")
        logger shouldBe a [Logger]
      }
    }

    "apply(clazz: Class[_]) is invoked" should {
      "return a Logger" in {
        val logger = LoggerFactory(classOf[LoggerFactorySpec])
        logger shouldBe a [Logger]
      }
    }


    "getLogger[A: Manifest] is invoked" should {
      "return a Logger" in {
        val logger = LoggerFactory.getLogger[LoggerFactorySpec]
        logger shouldBe a [Logger]
      }
    }

    "getLogger(name: String) is invoked" should {
      "return a Logger" in {
        val logger = LoggerFactory.getLogger("foo")
        logger shouldBe a [Logger]
      }
    }

    "getLogger(clazz: Class[_]) is invoked" should {
      "return a Logger" in {
        val logger = LoggerFactory.getLogger(classOf[LoggerFactorySpec])
        logger shouldBe a [Logger]
      }
    }
  }
}
