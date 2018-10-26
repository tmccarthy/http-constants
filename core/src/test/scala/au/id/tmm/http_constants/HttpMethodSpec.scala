package au.id.tmm.http_constants

import au.id.tmm.http_constants.HttpMethod._
import org.scalatest.FlatSpec

class HttpMethodSpec extends FlatSpec {

  behavior of "the fromString lookup"

  it should "fail to lookup an invalid method string" in {
    assert(HttpMethod.fromString("invalid") === None)
  }

  def testLookup(methodAsString: String, expectedMethod: HttpMethod): Unit = {
    val methodStringUppercase = methodAsString.toUpperCase
    val methodStringLowercase = methodAsString.toLowerCase
    val methodStringCapitalised = methodStringLowercase.capitalize

    it should s"""lookup $expectedMethod for "$methodStringUppercase"""" in {
      assert(HttpMethod.fromString(methodStringUppercase) === Some(expectedMethod))
    }

    it should s"""lookup $expectedMethod for "$methodStringLowercase"""" in {
      assert(HttpMethod.fromString(methodStringLowercase) === Some(expectedMethod))
    }

    it should s"""lookup $expectedMethod for "$methodStringCapitalised"""" in {
      assert(HttpMethod.fromString(methodStringCapitalised) === Some(expectedMethod))
    }
  }

  testLookup("GET", GET)
  testLookup("HEAD", HEAD)
  testLookup("POST", POST)
  testLookup("PUT", PUT)
  testLookup("DELETE", DELETE)
  testLookup("CONNECT", CONNECT)
  testLookup("OPTIONS", OPTIONS)
  testLookup("TRACE", TRACE)
  testLookup("PATCH", PATCH)

}
