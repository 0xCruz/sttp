package sttp.client3.impl.cats

import cats.effect.IO
import sttp.client3.Backend
import sttp.client3.testing.AbstractFetchHttpTest

import scala.concurrent.ExecutionContext
import scala.scalajs.concurrent.JSExecutionContext.Implicits

class FetchCatsHttpTest extends AbstractFetchHttpTest[IO, Any] with CatsTestBase {
  implicit override def executionContext: ExecutionContext = Implicits.queue

  override val backend: Backend[IO] = FetchCatsBackend()

  override protected def supportsCustomMultipartContentType = false

  override def timeoutToNone[T](t: IO[T], timeoutMillis: Int): IO[Option[T]] =
    super[CatsTestBase].timeoutToNone(t, timeoutMillis)
}
