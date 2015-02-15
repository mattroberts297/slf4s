package org.slf4s

import org.scalatest.{WordSpec, Matchers}

class MarkerFactorySpec extends WordSpec with Matchers {
  "The MarkerFactory" when {
    "apply(name: String) is invoked" should {
      "return a Marker" in {
        val logger = MarkerFactory("foo")
        logger shouldBe a [Marker]
      }
    }

    "getMarker(name: String) is invoked" should {
      "return a Marker" in {
        val logger = MarkerFactory.getMarker("foo")
        logger shouldBe a [Marker]
      }
    }
  }
}
