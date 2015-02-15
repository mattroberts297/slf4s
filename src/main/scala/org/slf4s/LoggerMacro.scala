package org.slf4s

import scala.reflect.macros.Context

private object LoggerMacro {
  def traceMS(c: Context { type PrefixType = Logger })
             (marker: c.Expr[Marker], msg: c.Expr[String]): c.Expr[Unit] = {
    logMS("isTraceEnabled", "trace")(c)(marker, msg)
  }

  def traceMST(c: Context { type PrefixType = Logger })
             (marker: c.Expr[Marker], msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    logMST("isTraceEnabled", "trace")(c)(marker, msg, t)
  }

  def traceS(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    logS("isTraceEnabled", "trace")(c)(msg)
  }

  def traceST(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    logST("isTraceEnabled", "trace")(c)(msg, t)
  }

  def debug(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    logS("isDebugEnabled", "debug")(c)(msg)
  }

  def debugT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    logST("isDebugEnabled", "debug")(c)(msg, t)
  }

  def info(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    logS("isInfoEnabled", "info")(c)(msg)
  }

  def infoT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    logST("isInfoEnabled", "info")(c)(msg, t)
  }

  def warn(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    logS("isWarnEnabled", "warn")(c)(msg)
  }

  def warnT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    logST("isWarnEnabled", "warn")(c)(msg, t)
  }

  def error(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    logS("isErrorEnabled", "error")(c)(msg)
  }

  def errorT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    logST("isErrorEnabled", "error")(c)(msg, t)
  }

  private def logMS[C <: Context {type PrefixType = Logger}]
      (isEnabledMethodName: String, logMethodName: String)
      (c: Context)
      (marker: c.Expr[Marker], msg: c.Expr[String]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](If(
      Apply(Select(Select(c.prefix.tree, newTermName("underlying")), newTermName(isEnabledMethodName)), List()),
      Apply(
        Select(Select(c.prefix.tree, newTermName("underlying")), newTermName(logMethodName)),
        List(Select(marker.tree, newTermName("underlying")), msg.tree)
      ),
      Literal(Constant(()))
    ))
  }

  private def logMST[C <: Context {type PrefixType = Logger}]
      (isEnabledMethodName: String, logMethodName: String)
      (c: Context)
      (marker: c.Expr[Marker], msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](If(
      Apply(Select(Select(c.prefix.tree, newTermName("underlying")), newTermName(isEnabledMethodName)), List()),
      Apply(
        Select(Select(c.prefix.tree, newTermName("underlying")), newTermName(logMethodName)),
        List(Select(marker.tree, newTermName("underlying")), msg.tree, t.tree)
      ),
      Literal(Constant(()))
    ))
  }

  private def logS[C <: Context {type PrefixType = Logger}]
      (isEnabledMethodName: String, logMethodName: String)
      (c: Context)
      (msg: c.Expr[String]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](If(
      Apply(Select(Select(c.prefix.tree, newTermName("underlying")), newTermName(isEnabledMethodName)), List()),
      Apply(Select(Select(c.prefix.tree, newTermName("underlying")), newTermName(logMethodName)), List(msg.tree)),
      Literal(Constant(()))
    ))
  }

  private def logST[C <: Context {type PrefixType = Logger}]
      (isEnabledMethodName: String, logMethodName: String)
      (c: Context)
      (msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](If(
      Apply(Select(Select(c.prefix.tree, newTermName("underlying")), newTermName(isEnabledMethodName)), List()),
      Apply(
        Select(Select(c.prefix.tree, newTermName("underlying")), newTermName(logMethodName)),
        List(msg.tree, t.tree)
      ),
      Literal(Constant(()))
    ))
  }
}
