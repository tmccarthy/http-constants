package au.id.tmm.http_constants.circe

import au.id.tmm.http_constants.{HttpHeader, HttpMethod, HttpResponseCode}
import io.circe.Json
import org.scalatest.FlatSpec

class DecodersSpec extends FlatSpec {

  "the http header decoder" should "decode a header" in {
    assert(Json.fromString("Accept").as[HttpHeader] === Right(HttpHeader.Accept))
  }

  "the http response code decoder" should "decode a response code" in {
    assert(Json.fromInt(200).as[HttpResponseCode] === Right(HttpResponseCode.OK))
  }

  it should "fail to decode an invalid http response" in {
    assert(
      Json.fromInt(-1).as[HttpResponseCode].left.map(_.message) === Left("-1 is an unrecognised http response code"))
  }

  "the http method decoder" should "decode an http method" in {
    assert(Json.fromString("GET").as[HttpMethod] === Right(HttpMethod.GET))
  }

  it should "decode a lowercase http method" in {
    assert(Json.fromString("get").as[HttpMethod] === Right(HttpMethod.GET))
  }

  it should "fail to decode an invalid http method" in {
    assert(
      Json.fromString("invalid").as[HttpMethod].left.map(_.message) === Left("invalid is an unrecognised http method"))
  }

}
