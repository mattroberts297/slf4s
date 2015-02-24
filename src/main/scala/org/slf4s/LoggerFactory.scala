package org.slf4s

import org.slf4j.{LoggerFactory => Underlying}
import scala.reflect.Manifest

object LoggerFactory {
  def apply[A: Manifest]: Logger = getLogger[A]
  def apply(name: String): Logger = getLogger(name)
  def apply(clazz: Class[_]): Logger = getLogger(clazz)
  def getLogger[A: Manifest]: Logger = Logger(Underlying.getLogger(implicitly[Manifest[A]].erasure))
  def getLogger(name: String): Logger = Logger(Underlying.getLogger(name))
  def getLogger(clazz: Class[_]): Logger = Logger(Underlying.getLogger(clazz))
}
