package org.slf4s

import org.scalatest.{Matchers, WordSpec}
import org.mockito.Mockito._
import org.slf4j.{Marker => Underlying}

class MarkerSpec extends WordSpec with Matchers with Logging {
  trait Context {
    val mockUnderlying = mock(classOf[Underlying])
    val marker = Marker(mockUnderlying)
    val anotherMarkerName = "foo"
    val anotherMarker = MarkerFactory(anotherMarkerName)
  }

  case object StubIterator extends java.util.Iterator[Underlying] {
    override def hasNext: Boolean = false
    override def next(): Underlying = ???
    override def remove(): Unit = ???
  }

  "A Marker instance" when {
    "add(marker: Marker) is invoked" should {
      "call the underlying implementation" in new Context {
        marker.add(anotherMarker)
        verify(mockUnderlying).add(anotherMarker.underlying)
      }
    }

    "contains(marker: Marker) is invoked" should {
      "call the underlying implementation" in new Context {
        when(mockUnderlying.contains(anotherMarker.underlying)).thenReturn(true)
        marker.contains(anotherMarker)
        verify(mockUnderlying).contains(anotherMarker.underlying)
      }
    }

    "contains(string: String) is invoked" should {
      "call the underlying implementation" in new Context {
        when(mockUnderlying.contains(anotherMarkerName)).thenReturn(true)
        marker.contains(anotherMarkerName)
        verify(mockUnderlying).contains(anotherMarkerName)
      }
    }

    "remove(marker: Marker) is invoked" should {
      "call the underlying implementation" in new Context {
        marker.remove(anotherMarker)
        verify(mockUnderlying).remove(anotherMarker.underlying)
      }
    }

    "name is invoked" should {
      "call the underlying implementation" in new Context {
        when(mockUnderlying.getName).thenReturn(anotherMarkerName)
        marker.name should be (anotherMarkerName)
        verify(mockUnderlying).getName()
      }
    }

    "hasReferences is invoked" should {
      "call the underlying implementation" in new Context {
        when(mockUnderlying.hasReferences).thenReturn(true)
        marker.hasReferences should be (true)
        verify(mockUnderlying).hasReferences()
      }
    }

    "references is invoked" should {
      "call the underlying implementation" in new Context {
        when(mockUnderlying.iterator()).thenReturn(StubIterator)
        marker.references shouldBe a [Iterator[_]]
        verify(mockUnderlying).iterator()
      }
    }

    "+=(marker: Marker) is invoked" should {
      "call the underlying implementation" in new Context {
        marker.+=(anotherMarker)
        verify(mockUnderlying).add(anotherMarker.underlying)
      }
    }

    "-=(marker: Marker) is invoked" should {
      "call the underlying implementation" in new Context {
        marker.-=(anotherMarker)
        verify(mockUnderlying).remove(anotherMarker.underlying)
      }
    }
  }
}
