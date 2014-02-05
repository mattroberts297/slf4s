package org.slf4s

import org.slf4j.{LoggerFactory => JLoggerFactory}
import scala.reflect.ClassTag

object LoggerFactory {
  def getLogger[A: ClassTag]: Logger = Logger(JLoggerFactory.getLogger(implicitly[ClassTag[A]].runtimeClass))
  def getLogger(name: String): Logger = Logger(JLoggerFactory.getLogger(name))
  def getLogger(clazz: Class[_]): Logger = Logger(JLoggerFactory.getLogger(clazz))
}
