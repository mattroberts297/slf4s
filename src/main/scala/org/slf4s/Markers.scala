package org.slf4s

trait Markers {
  def marker(s: String): Marker = MarkerFactory(s)
}
