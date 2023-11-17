package dev.khusanjon
package routes

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

object AthleteInfoRoute {
  val route: Route =
    (path("get-all-athletes") & get){
      complete()
    }

  pathPrefix("users") {
    concat(
      pathEnd {
        concat(
          get {
            complete(getUsers())
          },
          post {
            entity(as[User]) { user =>
              onSuccess(createUser(user)) { performed =>
                complete((StatusCodes.Created, performed))
              }
            }
          })
      }
}
