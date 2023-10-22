package dev.khusanjon
package routes

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

object AthleteInfoRoute {
  val route: Route =
    (path("get-all-athletes") & get){
      complete()
    }
}
