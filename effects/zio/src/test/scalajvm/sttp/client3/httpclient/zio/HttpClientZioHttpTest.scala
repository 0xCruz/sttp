package sttp.client3.httpclient.zio

import sttp.client3._
import sttp.client3.impl.zio.ZioTestBase
import sttp.client3.testing.{ConvertToFuture, HttpTest}
import zio.Task

class HttpClientZioHttpTest extends HttpTest[Task] with ZioTestBase {
  override val backend: Backend[Task] =
    unsafeRunSyncOrThrow(HttpClientZioBackend())
  override implicit val convertToFuture: ConvertToFuture[Task] = convertZioTaskToFuture

  override def supportsHostHeaderOverride = false
}
