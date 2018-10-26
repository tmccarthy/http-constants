package au.id.tmm.http_constants.argonaut

import argonaut.Argonaut._
import au.id.tmm.http_constants.argonaut.Encoders._
import au.id.tmm.http_constants.{HttpHeader, HttpMethod, HttpResponseCode}
import org.scalatest.FlatSpec

class EncodersSpec extends FlatSpec {

  "the http header encoder" should "encode an http header" in {
    assert(HttpHeader.Age.asJson === jString("Age"))
  }

  it should "encode a custom http header" in {
    assert(HttpHeader("X-Custom-Header").asJson === jString("X-Custom-Header"))
  }

  "the http response code encoder" should "encode an http response code" in {
    val responseCode: HttpResponseCode = HttpResponseCode.FailedDependency

    assert(responseCode.asJson === jNumber(424))
  }

  "the http method encoder" should "encode an http method" in {
    val httpMethod: HttpMethod = HttpMethod.GET

    assert(httpMethod.asJson === jString("GET"))
  }

}
