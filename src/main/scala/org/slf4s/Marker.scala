package org.slf4s

import org.slf4j.{Marker => Underlying}
import scala.collection.JavaConversions._

class Marker(val underlying: Underlying) {
  def add(marker: Marker): Unit = underlying.add(marker.underlying)
  def contains(marker: Marker): Unit = underlying.contains(marker.underlying)
  def contains(string: String): Unit = underlying.contains(string)
  def remove(marker: Marker): Unit = underlying.remove(marker.underlying)
  def name: String = underlying.getName
  def hasReferences: Boolean = underlying.hasReferences
  def references: Iterator[Marker] = underlying.iterator().map(new Marker(_))

  def +=(marker: Marker): Unit = add(marker)
  def -=(marker: Marker): Unit = remove(marker)

  override def equals(obj: Any): Boolean = underlying.equals(obj)
  override def hashCode(): Int = underlying.hashCode()
}

object Marker {
  def apply(underlying: Underlying): Marker = new Marker(underlying)
}
