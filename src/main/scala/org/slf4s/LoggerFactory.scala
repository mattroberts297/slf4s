package org.slf4s

import org.slf4j.{LoggerFactory => JLoggerFactory}
import scala.reflect.Manifest

object LoggerFactory {
  def getLogger[A: Manifest]: Logger = Logger(JLoggerFactory.getLogger(implicitly[Manifest[A]].erasure))
  def getLogger(name: String): Logger = Logger(JLoggerFactory.getLogger(name))
  def getLogger(clazz: Class[_]): Logger = Logger(JLoggerFactory.getLogger(clazz))
}
