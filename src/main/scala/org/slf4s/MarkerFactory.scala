package org.slf4s

import org.slf4j.{MarkerFactory => Underlying}

object MarkerFactory {
  def apply(name: String): Marker = getMarker(name)
  def getMarker(name: String): Marker = new Marker(Underlying.getMarker(name))
}
