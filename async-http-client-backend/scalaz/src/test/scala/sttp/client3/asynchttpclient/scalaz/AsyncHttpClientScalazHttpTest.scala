package sttp.client3.asynchttpclient.scalaz

import scalaz.concurrent.Task
import sttp.client3.Backend
import sttp.client3.impl.scalaz.convertScalazTaskToFuture
import sttp.client3.testing.{ConvertToFuture, HttpTest}

class AsyncHttpClientScalazHttpTest extends HttpTest[Task] {

  override val backend: Backend[Task] = AsyncHttpClientScalazBackend().unsafePerformSync
  override implicit val convertToFuture: ConvertToFuture[Task] = convertScalazTaskToFuture

  override def throwsExceptionOnUnsupportedEncoding = false

  override def supportsCancellation: Boolean = false
  override def timeoutToNone[T](t: Task[T], timeoutMillis: Int): Task[Option[T]] = t.map(Some(_))
  override def supportsAutoDecompressionDisabling = false
}
