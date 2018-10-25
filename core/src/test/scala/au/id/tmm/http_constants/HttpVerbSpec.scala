package au.id.tmm.http_constants

import au.id.tmm.http_constants.HttpVerb._
import org.scalatest.FlatSpec

class HttpVerbSpec extends FlatSpec {

  behavior of "the fromString lookup"

  it should "fail to lookup an invalid verb string" in {
    assert(HttpVerb.fromString("invalid") === None)
  }

  def testLookup(verbAsString: String, expectedVerb: HttpVerb): Unit = {
    val verbStringUppercase = verbAsString.toUpperCase
    val verbStringLowercase = verbAsString.toLowerCase
    val verbStringCapitalised = verbStringLowercase.capitalize

    it should s"""lookup $expectedVerb for "$verbStringUppercase"""" in {
      assert(HttpVerb.fromString(verbStringUppercase) === Some(expectedVerb))
    }

    it should s"""lookup $expectedVerb for "$verbStringLowercase"""" in {
      assert(HttpVerb.fromString(verbStringLowercase) === Some(expectedVerb))
    }

    it should s"""lookup $expectedVerb for "$verbStringCapitalised"""" in {
      assert(HttpVerb.fromString(verbStringCapitalised) === Some(expectedVerb))
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
