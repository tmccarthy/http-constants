package au.id.tmm.http_constants.argonaut

import argonaut.Argonaut._
import argonaut.DecodeResult
import au.id.tmm.http_constants.argonaut.Decoders._
import au.id.tmm.http_constants.{HttpHeader, HttpMethod, HttpResponseCode}
import org.scalatest.FlatSpec

class DecodersSpec extends FlatSpec {

  "the http header decoder" should "decode a header" in {
    assert(jString("Accept").as[HttpHeader] === DecodeResult.ok(HttpHeader.Accept))
  }

  "the http response code decoder" should "decode a response code" in {
    assert(jNumber(200).as[HttpResponseCode] === DecodeResult.ok(HttpResponseCode.OK))
  }

  it should "fail to decode an invalid http response" in {
    assert(jNumber(-1).as[HttpResponseCode].failure.map(_._1) === Some("-1 is an unrecognised http response code"))
  }

  "the http method decoder" should "decode an http method" in {
    assert(jString("GET").as[HttpMethod] === DecodeResult.ok(HttpMethod.GET))
  }

  it should "decode a lowercase http method" in {
    assert(jString("get").as[HttpMethod] === DecodeResult.ok(HttpMethod.GET))
  }

  it should "fail to decode an invalid http method" in {
    assert(jString("invalid").as[HttpMethod].message === Some("invalid is an unrecognised http method"))
  }

}
