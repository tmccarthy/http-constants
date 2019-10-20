package au.id.tmm.http_constants.circe

import au.id.tmm.http_constants.{HttpHeader, HttpMethod, HttpResponseCode}
import io.circe.Json
import io.circe.syntax.EncoderOps
import org.scalatest.FlatSpec

class EncodersSpec extends FlatSpec {

  "the http header encoder" should "encode an http header" in {
    assert(HttpHeader.Age.asJson === Json.fromString("Age"))
  }

  it should "encode a custom http header" in {
    assert(HttpHeader("X-Custom-Header").asJson === Json.fromString("X-Custom-Header"))
  }

  "the http response code encoder" should "encode an http response code" in {
    val responseCode: HttpResponseCode = HttpResponseCode.FailedDependency

    assert(responseCode.asJson === Json.fromInt(424))
  }

  "the http method encoder" should "encode an http method" in {
    val httpMethod: HttpMethod = HttpMethod.GET

    assert(httpMethod.asJson === Json.fromString("GET"))
  }

}
