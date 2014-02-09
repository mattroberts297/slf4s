package org.slf4s

import org.slf4j.{Logger => JLogger}

case class Logger(private val log: JLogger) {
  def trace(msg: => String): Unit = if (log.isTraceEnabled) log.trace(msg)
  def trace(msg: => String, t: => Throwable): Unit = if (log.isTraceEnabled) log.trace(msg, t)
  def debug(msg: => String): Unit = if (log.isDebugEnabled) log.debug(msg)
  def debug(msg: => String, t: => Throwable): Unit = if (log.isDebugEnabled) log.debug(msg, t)
  def info(msg: => String): Unit = if (log.isInfoEnabled) log.info(msg)
  def info(msg: => String, t: => Throwable): Unit = if (log.isInfoEnabled) log.info(msg, t)
  def warn(msg: => String): Unit = if (log.isWarnEnabled) log.warn(msg)
  def warn(msg: => String, t: => Throwable): Unit = if (log.isWarnEnabled) log.warn(msg, t)
  def error(msg: => String): Unit = if (log.isErrorEnabled) log.error(msg)
  def error(msg: => String, t: => Throwable): Unit = if (log.isErrorEnabled) log.error(msg, t)
}
