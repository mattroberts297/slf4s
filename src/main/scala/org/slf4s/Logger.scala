package org.slf4s

import org.slf4j.{Logger => Underlying}

class Logger(val underlying: Underlying) {
  def trace(msg: => String): Unit = if (underlying.isTraceEnabled) underlying.trace(msg)
  def trace(msg: => String, t: => Throwable): Unit = if (underlying.isTraceEnabled) underlying.trace(msg, t)
  def debug(msg: => String): Unit = if (underlying.isDebugEnabled) underlying.debug(msg)
  def debug(msg: => String, t: => Throwable): Unit = if (underlying.isDebugEnabled) underlying.debug(msg, t)
  def info(msg: => String): Unit = if (underlying.isInfoEnabled) underlying.info(msg)
  def info(msg: => String, t: => Throwable): Unit = if (underlying.isInfoEnabled) underlying.info(msg, t)
  def warn(msg: => String): Unit = if (underlying.isWarnEnabled) underlying.warn(msg)
  def warn(msg: => String, t: => Throwable): Unit = if (underlying.isWarnEnabled) underlying.warn(msg, t)
  def error(msg: => String): Unit = if (underlying.isErrorEnabled) underlying.error(msg)
  def error(msg: => String, t: => Throwable): Unit = if (underlying.isErrorEnabled) underlying.error(msg, t)
}

object Logger {
  def apply(underlying: Underlying): Logger = new Logger(underlying)
}
