package au.id.tmm.httpConstants

import org.scalatest.FlatSpec
import au.id.tmm.httpConstants.HttpResponseCode._

class HttpResponseCodeSpec extends FlatSpec {

  behavior of "the fromCode lookup"

  it should "fail to lookup an invalid code" in {
    assert(HttpResponseCode.fromCode(0) === None)
  }

  private def testCodeLookup(code: Int, expectedCode: HttpResponseCode): Unit = {
    it should s"lookup $expectedCode for $code" in {
      assert(HttpResponseCode.fromCode(code) === Some(expectedCode))
    }
  }

  testCodeLookup(100, Continue)
  testCodeLookup(101, SwitchingProtocol)
  testCodeLookup(102, Processing)
  testCodeLookup(200, OK)
  testCodeLookup(201, Created)
  testCodeLookup(202, Accepted)
  testCodeLookup(203, NonAuthoritativeInformation)
  testCodeLookup(204, NoContent)
  testCodeLookup(205, ResetContent)
  testCodeLookup(206, PartialContent)
  testCodeLookup(207, MultiStatus207)
  testCodeLookup(208, MultiStatus208)
  testCodeLookup(226, ImUsed)
  testCodeLookup(300, MultipleChoice)
  testCodeLookup(301, MovedPermanently)
  testCodeLookup(302, Found)
  testCodeLookup(303, SeeOther)
  testCodeLookup(304, NotModified)
  testCodeLookup(305, UseProxy)
  testCodeLookup(306, `306`)
  testCodeLookup(307, TemporaryRedirect)
  testCodeLookup(308, PermanentRedirect)
  testCodeLookup(400, BadRequest)
  testCodeLookup(401, Unauthorized)
  testCodeLookup(402, PaymentRequired)
  testCodeLookup(403, Forbidden)
  testCodeLookup(404, NotFound)
  testCodeLookup(405, MethodNotAllowed)
  testCodeLookup(406, NotAcceptable)
  testCodeLookup(407, ProxyAuthenticationRequired)
  testCodeLookup(408, RequestTimeout)
  testCodeLookup(409, Conflict)
  testCodeLookup(410, Gone)
  testCodeLookup(411, LengthRequired)
  testCodeLookup(412, PreconditionFailed)
  testCodeLookup(413, PayloadTooLarge)
  testCodeLookup(414, URITooLong)
  testCodeLookup(415, UnsupportedMediaType)
  testCodeLookup(416, RequestedRangeNotSatisfiable)
  testCodeLookup(417, ExpectationFailed)
  testCodeLookup(418, ImATeapot)
  testCodeLookup(421, MisdirectedRequest)
  testCodeLookup(422, UnprocessableEntity)
  testCodeLookup(423, Locked)
  testCodeLookup(424, FailedDependency)
  testCodeLookup(425, TooEarly)
  testCodeLookup(426, UpgradeRequired)
  testCodeLookup(428, PreconditionRequired)
  testCodeLookup(429, TooManyRequests)
  testCodeLookup(431, RequestHeaderFieldsTooLarge)
  testCodeLookup(451, UnavailableForLegalReasons)
  testCodeLookup(500, InternalServerError)
  testCodeLookup(501, NotImplemented)
  testCodeLookup(502, BadGateway)
  testCodeLookup(503, ServiceUnavailable)
  testCodeLookup(504, GatewayTimeout)
  testCodeLookup(505, HTTPVersionNotSupported)
  testCodeLookup(506, VariantAlsoNegotiates)
  testCodeLookup(507, InsufficientStorage)
  testCodeLookup(508, LoopDetected)
  testCodeLookup(510, NotExtended)
  testCodeLookup(511, NetworkAuthenticationRequired)

}
