package org.slf4s

import org.slf4j.{LoggerFactory => UnderlyingFactory}
import scala.reflect.ClassTag

object LoggerFactory {
  def getLogger[A: ClassTag]: Logger = Logger(UnderlyingFactory.getLogger(implicitly[ClassTag[A]].runtimeClass))
  def getLogger(name: String): Logger = Logger(UnderlyingFactory.getLogger(name))
  def getLogger(clazz: Class[_]): Logger = Logger(UnderlyingFactory.getLogger(clazz))
}
