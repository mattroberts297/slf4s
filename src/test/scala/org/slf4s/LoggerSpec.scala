package org.slf4s

import org.scalatest.{WordSpec, Matchers}
import org.mockito.Mockito._
import org.slf4j.{Logger => Underlying, Marker => UnderlyingMarker}

class LoggerSpec extends WordSpec with Matchers {

  trait Mocks {
    val underlyingMarker = mock(classOf[UnderlyingMarker])
    val marker = mock(classOf[Marker])
    val mockLogger = mock(classOf[Underlying])
    val logger = Logger(mockLogger)
  }

  val msg = "testing testing"
  val t = new Throwable

  "The Logger.trace method" when {
    "trace is enabled" should {
      "invoke the underlying trace method" in new Mocks {
        // Arrange.
        when(mockLogger.isTraceEnabled).thenReturn(true)
        when(marker.underlying).thenReturn(underlyingMarker)
        // Act.
        logger.trace(marker, msg)
        logger.trace(marker, msg, t)
        logger.trace(msg)
        logger.trace(msg, t)
        // Assert.
        verify(mockLogger).trace(underlyingMarker, msg)
        verify(mockLogger).trace(underlyingMarker, msg, t)
        verify(mockLogger).trace(msg)
        verify(mockLogger).trace(msg, t)
        verify(marker, times(2)).underlying
      }
    }

    "trace is disabled" should {
      "not invoke the underlying trace method" in new Mocks {
        // Arrange.
        when(mockLogger.isTraceEnabled).thenReturn(false)
        when(marker.underlying).thenReturn(underlyingMarker)
        // Act.
        logger.trace(marker, msg)
        logger.trace(marker, msg, t)
        logger.trace(msg)
        logger.trace(msg, t)
        // Assert.
        verify(mockLogger, never()).trace(underlyingMarker, msg)
        verify(mockLogger, never()).trace(underlyingMarker, msg, t)
        verify(mockLogger, never()).trace(msg)
        verify(mockLogger, never()).trace(msg, t)
        verify(marker, never()).underlying
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
