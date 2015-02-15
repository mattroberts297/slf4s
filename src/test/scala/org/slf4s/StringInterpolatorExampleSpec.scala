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
