package org.slf4s

import org.scalatest.{ShouldMatchers, WordSpec}
import org.mockito.Mockito._
import org.slf4j.{Logger => Underlying}

class LoggerSpec extends WordSpec with ShouldMatchers {

  trait Mocks {
    val mockLogger = mock(classOf[Underlying])
    val logger = Logger(mockLogger)
  }

  val msg = "testing testing"
  val t = new Throwable

  "The Logger.trace method" when {
    "trace is enabled" should {
      "invoke the underlying trace method" in new Mocks {
        when(mockLogger.isTraceEnabled).thenReturn(true)
        logger.trace(msg)
        logger.trace(msg, t)
        verify(mockLogger).trace(msg)
        verify(mockLogger).trace(msg, t)
      }
    }

    "trace is disabled" should {
      "not invoke the underlying trace method" in new Mocks {
        when(mockLogger.isTraceEnabled).thenReturn(false)
        logger.trace(msg)
        logger.trace(msg, t)
        verify(mockLogger, never()).trace(msg)
        verify(mockLogger, never()).trace(msg, t)
      }
    }
  }

  "The Logger.debug method" when {
    "debug is enabled" should {
      "invoke the underlying debug method" in new Mocks {
        when(mockLogger.isDebugEnabled).thenReturn(true)
        logger.debug(msg)
        logger.debug(msg, t)
        verify(mockLogger).debug(msg)
        verify(mockLogger).debug(msg, t)
      }
    }

    "debug is disabled" should {
      "not invoke the underlying debug method" in new Mocks {
        when(mockLogger.isDebugEnabled).thenReturn(false)
        logger.debug(msg)
        logger.debug(msg, t)
        verify(mockLogger, never()).debug(msg)
        verify(mockLogger, never()).debug(msg, t)
      }
    }
  }

  "The Logger.info method" when {
    "info is enabled" should {
      "invoke the underlying info method" in new Mocks {
        when(mockLogger.isInfoEnabled).thenReturn(true)
        logger.info(msg)
        logger.info(msg, t)
        verify(mockLogger).info(msg)
        verify(mockLogger).info(msg, t)
      }
    }

    "info is disabled" should {
      "not invoke the underlying info method" in new Mocks {
        when(mockLogger.isInfoEnabled).thenReturn(false)
        logger.info(msg)
        logger.info(msg, t)
        verify(mockLogger, never()).info(msg)
        verify(mockLogger, never()).info(msg, t)
      }
    }
  }

  "The Logger.warn method" when {
    "warn is enabled" should {
      "invoke the underlying warn method" in new Mocks {
        when(mockLogger.isWarnEnabled).thenReturn(true)
        logger.warn(msg)
        logger.warn(msg, t)
        verify(mockLogger).warn(msg)
        verify(mockLogger).warn(msg, t)
      }
    }

    "warn is disabled" should {
      "not invoke the underlying warn method" in new Mocks {
        when(mockLogger.isWarnEnabled).thenReturn(false)
        logger.warn(msg)
        logger.warn(msg, t)
        verify(mockLogger, never()).warn(msg)
        verify(mockLogger, never()).warn(msg, t)
      }
    }
  }

  "The Logger.error method" when {
    "error is enabled" should {
      "invoke the underlying error method" in new Mocks {
        when(mockLogger.isErrorEnabled).thenReturn(true)
        logger.error(msg)
        logger.error(msg, t)
        verify(mockLogger).error(msg)
        verify(mockLogger).error(msg, t)
      }
    }

    "error is disabled" should {
      "not invoke the underlying error method" in new Mocks {
        when(mockLogger.isErrorEnabled).thenReturn(false)
        logger.error(msg)
        logger.error(msg, t)
        verify(mockLogger, never()).error(msg)
        verify(mockLogger, never()).error(msg, t)
      }
    }
  }
}
