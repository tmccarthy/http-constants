package au.id.tmm.http_constants.circe

import au.id.tmm.http_constants.{HttpHeader, HttpMethod, HttpResponseCode}
import io.circe.Encoder
import io.circe.syntax.EncoderOps

trait Encoders {

  implicit val httpHeaderEncoder: Encoder[HttpHeader] =
    httpHeader => httpHeader.asString.asJson

  implicit val httpResponseCodeEncoder: Encoder[HttpResponseCode] =
    httpResponseCode => httpResponseCode.code.asJson

  implicit val httpMethodEncoder: Encoder[HttpMethod] =
    httpMethod => httpMethod.asString.asJson

}

object Encoders extends Encoders
