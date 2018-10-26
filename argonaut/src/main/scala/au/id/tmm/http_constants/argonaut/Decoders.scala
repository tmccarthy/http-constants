package au.id.tmm.http_constants.argonaut

import argonaut._
import au.id.tmm.http_constants.{HttpHeader, HttpMethod, HttpResponseCode}

object Decoders {

  implicit val httpHeaderDecoder: DecodeJson[HttpHeader] = Argonaut.jdecode1(HttpHeader.apply)

  implicit val httpResponseCodeDecoder: DecodeJson[HttpResponseCode] =
    flatteningDecoder(HttpResponseCode.fromCode, "http response code")

  implicit val httpMethodDecoder: DecodeJson[HttpMethod] =
    flatteningDecoder(HttpMethod.fromString, "http method")

  private def flatteningDecoder[A: DecodeJson, B](parser: A => Option[B], description: String): DecodeJson[B] =
    cursor => cursor.as[A].flatMap(rawValue => parser(rawValue) match {
      case Some(value) => DecodeResult.ok(value)
      case None => DecodeResult.fail(s"$rawValue is an unrecognised $description", cursor.history)
    })

}
