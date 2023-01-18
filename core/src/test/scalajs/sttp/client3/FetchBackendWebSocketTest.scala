package sttp.client3

import sttp.client3.testing.ConvertToFuture
import sttp.client3.testing.websocket.WebSocketTest
import sttp.monad.{FutureMonad, MonadError}

import scala.concurrent.{ExecutionContext, Future}
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

class FetchBackendWebSocketTest extends WebSocketTest[Future] {

  implicit override def executionContext: ExecutionContext = queue
  override def throwsWhenNotAWebSocket: Boolean = true

  override val backend: WebSocketBackend[Future] = FetchBackend()
  override implicit val convertToFuture: ConvertToFuture[Future] = ConvertToFuture.future

  override implicit def monad: MonadError[Future] = new FutureMonad()
}
