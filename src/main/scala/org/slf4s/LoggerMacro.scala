package org.slf4s

import scala.reflect.macros.Context

private object LoggerMacro {
  def trace(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    log("isTraceEnabled", "trace")(c)(msg)
  }

  def traceT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    logT("isTraceEnabled", "trace")(c)(msg, t)
  }

  def debug(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    log("isDebugEnabled", "debug")(c)(msg)
  }

  def debugT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    logT("isDebugEnabled", "debug")(c)(msg, t)
  }

  def info(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    log("isInfoEnabled", "info")(c)(msg)
  }

  def infoT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    logT("isInfoEnabled", "info")(c)(msg, t)
  }

  def warn(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    log("isWarnEnabled", "warn")(c)(msg)
  }

  def warnT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    logT("isWarnEnabled", "warn")(c)(msg, t)
  }

  def error(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    log("isErrorEnabled", "error")(c)(msg)
  }

  def errorT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    logT("isErrorEnabled", "error")(c)(msg, t)
  }

  private def log[C <: Context {type PrefixType = Logger}]
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

  private def logT[C <: Context {type PrefixType = Logger}]
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
