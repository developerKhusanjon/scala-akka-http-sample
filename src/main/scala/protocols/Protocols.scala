package dev.khusanjon
package protocols

import domains.Models.Athlete

import actors.InfoDeskBot.{AllAthletesResponse, Response}
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

trait Protocols extends DefaultJsonProtocol {
  implicit val UserFormat: RootJsonFormat[Athlete] = jsonFormat7(Athlete)
  implicit val ResponseFormat: RootJsonFormat[Response] = jsonFormat1(Response)
  implicit val AllUsersResponseFormat: RootJsonFormat[AllAthletesResponse] = jsonFormat1(AllAthletesResponse)
}