package org.slf4s

import org.slf4j.{Logger => Underlying}

case class Logger(val underlying: Underlying) {
  def trace(msg: String): Unit = macro LoggerMacro.trace
  def trace(msg: String, t: Throwable): Unit = macro LoggerMacro.traceT
  def debug(msg: String): Unit = macro LoggerMacro.debug
  def debug(msg: String, t: Throwable): Unit = macro LoggerMacro.debugT
  def info(msg: String): Unit = macro LoggerMacro.info
  def info(msg: String, t: Throwable): Unit = macro LoggerMacro.infoT
  def warn(msg: String): Unit = macro LoggerMacro.warn
  def warn(msg: String, t: Throwable): Unit = macro LoggerMacro.warnT
  def error(msg: String): Unit = macro LoggerMacro.error
  def error(msg: String, t: Throwable): Unit = macro LoggerMacro.errorT
}
