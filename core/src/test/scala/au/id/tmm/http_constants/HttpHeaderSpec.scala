package au.id.tmm.http_constants

import org.scalatest.FlatSpec

class HttpHeaderSpec extends FlatSpec {

  "an http header" can "be constructed" in {
    assert(HttpHeader("Authorization") === HttpHeader.Authorization)
  }

}
