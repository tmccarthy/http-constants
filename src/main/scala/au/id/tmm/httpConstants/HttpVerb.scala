package au.id.tmm.httpConstants

sealed trait HttpVerb

object HttpVerb {

  case object GET extends HttpVerb
  case object HEAD extends HttpVerb
  case object POST extends HttpVerb
  case object PUT extends HttpVerb
  case object DELETE extends HttpVerb
  case object CONNECT extends HttpVerb
  case object OPTIONS extends HttpVerb
  case object TRACE extends HttpVerb
  case object PATCH extends HttpVerb

}
