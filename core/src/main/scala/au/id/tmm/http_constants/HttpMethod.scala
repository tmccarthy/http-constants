package au.id.tmm.http_constants

sealed trait HttpMethod {
  val asString: String
}

object HttpMethod {

  case object GET     extends HttpMethod { override val asString = "GET" }
  case object HEAD    extends HttpMethod { override val asString = "HEAD" }
  case object POST    extends HttpMethod { override val asString = "POST" }
  case object PUT     extends HttpMethod { override val asString = "PUT" }
  case object DELETE  extends HttpMethod { override val asString = "DELETE" }
  case object CONNECT extends HttpMethod { override val asString = "CONNECT" }
  case object OPTIONS extends HttpMethod { override val asString = "OPTIONS" }
  case object TRACE   extends HttpMethod { override val asString = "TRACE" }
  case object PATCH   extends HttpMethod { override val asString = "PATCH" }

  def fromString(methodAsString: String): Option[HttpMethod] = methodAsString.toUpperCase match {
    case GET.asString     => Some(GET)
    case HEAD.asString    => Some(HEAD)
    case POST.asString    => Some(POST)
    case PUT.asString     => Some(PUT)
    case DELETE.asString  => Some(DELETE)
    case CONNECT.asString => Some(CONNECT)
    case OPTIONS.asString => Some(OPTIONS)
    case TRACE.asString   => Some(TRACE)
    case PATCH.asString   => Some(PATCH)
    case _                => None
  }

}
