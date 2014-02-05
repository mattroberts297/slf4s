package org.slf4s

import org.slf4j.{Logger => JLogger}

case class Logger(private val log: JLogger) {
  @inline def trace(msg: => String): Unit = if (log.isTraceEnabled) log.trace(msg)
  @inline def trace(msg: => String, t: => Throwable): Unit = if (log.isTraceEnabled) log.trace(msg, t)
  @inline def debug(msg: => String): Unit = if (log.isDebugEnabled) log.debug(msg)
  @inline def debug(msg: => String, t: => Throwable): Unit = if (log.isDebugEnabled) log.debug(msg, t)
  @inline def info(msg: => String): Unit = if (log.isInfoEnabled) log.info(msg)
  @inline def info(msg: => String, t: => Throwable): Unit = if (log.isInfoEnabled) log.info(msg, t)
  @inline def warn(msg: => String): Unit = if (log.isWarnEnabled) log.warn(msg)
  @inline def warn(msg: => String, t: => Throwable): Unit = if (log.isWarnEnabled) log.warn(msg, t)
  @inline def error(msg: => String): Unit = if (log.isErrorEnabled) log.error(msg)
  @inline def error(msg: => String, t: => Throwable): Unit = if (log.isErrorEnabled) log.error(msg, t)
}
