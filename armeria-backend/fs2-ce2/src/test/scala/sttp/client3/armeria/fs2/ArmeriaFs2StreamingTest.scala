package sttp.client3.armeria.fs2

import cats.effect.IO
import sttp.capabilities.fs2.Fs2Streams
import sttp.client3.StreamBackend
import sttp.client3.impl.fs2.Fs2StreamingTest

class ArmeriaFs2StreamingTest extends Fs2StreamingTest {
  override val backend: StreamBackend[IO, Fs2Streams[IO]] =
    ArmeriaFs2Backend()

  override protected def supportsStreamingMultipartParts: Boolean = false
}
