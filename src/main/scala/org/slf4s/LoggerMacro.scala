package org.slf4s

import scala.reflect.macros.blackbox.Context

private object LoggerMacro {
  def trace(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isTraceEnabled) $underlying.trace($msg)"
  }

  def traceT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isTraceEnabled) $underlying.trace($msg, $t)"
  }

  def debug(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isDebugEnabled) $underlying.debug($msg)"
  }

  def debugT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isDebugEnabled) $underlying.debug($msg, $t)"
  }

  def info(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isInfoEnabled) $underlying.info($msg)"
  }

  def infoT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isInfoEnabled) $underlying.info($msg, $t)"
  }

  def warn(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isWarnEnabled) $underlying.warn($msg)"
  }

  def warnT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isWarnEnabled) $underlying.warn($msg, $t)"
  }

  def error(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isErrorEnabled) $underlying.error($msg)"
  }

  def errorT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isErrorEnabled) $underlying.error($msg, $t)"
  }
}
