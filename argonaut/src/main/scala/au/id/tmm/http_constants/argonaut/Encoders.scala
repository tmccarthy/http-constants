package au.id.tmm.http_constants.argonaut

import argonaut.Argonaut._
import argonaut.EncodeJson
import au.id.tmm.http_constants.{HttpHeader, HttpResponseCode, HttpVerb}

object Encoders {

  implicit val httpHeaderEncoder: EncodeJson[HttpHeader] =
    httpHeader => httpHeader.asString.asJson

  implicit val httpResponseCodeEncoder: EncodeJson[HttpResponseCode] =
    httpResponseCode => httpResponseCode.code.asJson

  implicit val httpVerbEncoder: EncodeJson[HttpVerb] =
    httpVerb => httpVerb.asString.asJson

}
