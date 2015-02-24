package org.slf4s

import org.slf4j.{LoggerFactory => Underlying}
import scala.reflect.ClassTag

object LoggerFactory {
  def apply[A: ClassTag]: Logger = getLogger[A]
  def apply(name: String): Logger = getLogger(name)
  def apply(clazz: Class[_]): Logger = getLogger(clazz)
  def getLogger[A: ClassTag]: Logger = Logger(Underlying.getLogger(implicitly[ClassTag[A]].runtimeClass))
  def getLogger(name: String): Logger = Logger(Underlying.getLogger(name))
  def getLogger(clazz: Class[_]): Logger = Logger(Underlying.getLogger(clazz))
}
