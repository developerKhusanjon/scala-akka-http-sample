package dev.khusanjon

import routes.AthleteInfoRoute

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http

import scala.concurrent.ExecutionContext
import scala.io.StdIn

object Starter {
  implicit val system: ActorSystem[_] = ActorSystem(Behaviors.empty, "ScalaAkkaHttpSample")
  // needed for the future map/flatmap in the end and future in fetchItem and saveOrder
  implicit val executionContext: ExecutionContext = system.executionContext

  def main(args: Array[String]): Unit = {
    val route = AthleteInfoRoute.route
    val bindingFuture = Http().newServerAt("localhost", 8084).bind(route)
    println(s"Server online at http://localhost:8084/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}
