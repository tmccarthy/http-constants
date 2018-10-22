package au.id.tmm.httpConstants

sealed trait HttpVerb {
  val asString: String
}

object HttpVerb {

  case object GET     extends HttpVerb { override val asString = "GET" }
  case object HEAD    extends HttpVerb { override val asString = "HEAD" }
  case object POST    extends HttpVerb { override val asString = "POST" }
  case object PUT     extends HttpVerb { override val asString = "PUT" }
  case object DELETE  extends HttpVerb { override val asString = "DELETE" }
  case object CONNECT extends HttpVerb { override val asString = "CONNECT" }
  case object OPTIONS extends HttpVerb { override val asString = "OPTIONS" }
  case object TRACE   extends HttpVerb { override val asString = "TRACE" }
  case object PATCH   extends HttpVerb { override val asString = "PATCH" }

  def fromString(verbAsString: String): Option[HttpVerb] = verbAsString.toUpperCase match {
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
