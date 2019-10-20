package au.id.tmm.http_constants.circe

import au.id.tmm.http_constants.{HttpHeader, HttpMethod, HttpResponseCode}
import io.circe.Decoder

trait Decoders {

  implicit val httpHeaderDecoder: Decoder[HttpHeader] = Decoder.decodeString.map(HttpHeader.apply)

  implicit val httpResponseCodeDecoder: Decoder[HttpResponseCode] =
    flatteningDecoder(HttpResponseCode.fromCode, "http response code")

  implicit val httpMethodDecoder: Decoder[HttpMethod] =
    flatteningDecoder(HttpMethod.fromString, "http method")

  private def flatteningDecoder[A : Decoder, B](parser: A => Option[B], description: String): Decoder[B] =
    Decoder[A].emap { rawValue =>
      parser.apply(rawValue).toRight(s"$rawValue is an unrecognised $description")
    }

}

object Decoders extends Decoders
