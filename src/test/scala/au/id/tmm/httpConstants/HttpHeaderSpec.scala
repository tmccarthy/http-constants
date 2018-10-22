package au.id.tmm.httpConstants

import org.scalatest.FlatSpec

class HttpHeaderSpec extends FlatSpec {

  "an http header" can "be constructed" in {
    assert(HttpHeader("Authorization") === HttpHeader.Authorization)
  }

}
