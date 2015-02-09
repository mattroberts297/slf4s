package org.slf4s

import scala.reflect.macros.Context

private object LoggerMacro {
  def trace(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](If(
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("isTraceEnabled")), List()), 
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("trace")), List(msg.tree)), 
      Literal(Constant(()))
    ))
  }

  def traceT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](If(
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("isTraceEnabled")), List()), 
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("trace")), List(msg.tree, t.tree)), 
      Literal(Constant(()))
    ))
  }

  def debug(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](If(
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("isDebugEnabled")), List()), 
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("debug")), List(msg.tree)), 
      Literal(Constant(()))
    ))
  }

  def debugT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](If(
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("isDebugEnabled")), List()), 
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("debug")), List(msg.tree, t.tree)), 
      Literal(Constant(()))
    ))
  }

  def info(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](If(
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("isInfoEnabled")), List()), 
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("info")), List(msg.tree)), 
      Literal(Constant(()))
    ))
  }

  def infoT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](If(
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("isInfoEnabled")), List()), 
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("info")), List(msg.tree, t.tree)), 
      Literal(Constant(()))
    ))
  }

  def warn(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](If(
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("isWarnEnabled")), List()), 
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("warn")), List(msg.tree)), 
      Literal(Constant(()))
    ))
  }

  def warnT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](If(
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("isWarnEnabled")), List()), 
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("warn")), List(msg.tree, t.tree)), 
      Literal(Constant(()))
    ))
  }

  def error(c: Context { type PrefixType = Logger })(msg: c.Expr[String]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](If(
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("isErrorEnabled")), List()), 
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("error")), List(msg.tree)), 
      Literal(Constant(()))
    ))
  }

  def errorT(c: Context { type PrefixType = Logger })(msg: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](If(
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("isErrorEnabled")), List()), 
      Apply(Select(Select(c.prefix.tree, "underlying"), newTermName("error")), List(msg.tree, t.tree)), 
      Literal(Constant(()))
    ))
  }
}
