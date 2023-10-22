package dev.khusanjon
package actors

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors
import components.{DataLoader, MessageSender}
import domains.Models.Athlete

object InfoDeskBot { helper: DataLoader with MessageSender =>
  trait Command
  final case object Initiate extends Command
  final case class GetAthlete(identity: String, replyTo: ActorRef[Respond]) extends Command
  final case class GetAllAthletes(replyTo: ActorRef[Respond]) extends Command

  trait Respond
  final case class Response(athlete: Athlete) extends Respond
  final case class AllAthletesResponse(users: List[Athlete]) extends Respond

  def apply(max: Int): Behavior[Command] = bot(0, max)

  private def bot(requestCount: Int, maxReq: Int): Behavior[Command] =
    Behaviors.receive { (context, message) =>
      message match {
        case Initiate =>
          context.log.info(s"${context.self.path.name} is initialized in ${context.self.path.address} address")
          helper.sendMessage(s"${context.self.path.name} is initialized.")
        case GetAthlete(id, sendBack) =>
          context.log.info(s"${context.self.path.name} received request info for $id from ${sendBack.path.name}")
          sendBack ! Response(helper.getAnAthlete(id))
        case GetAllAthletes(sendBack) =>
          context.log.info(s"${context.self.path.name} received request info for all athletes from ${sendBack.path.name}")
          sendBack ! AllAthletesResponse(helper.getAllAthletes)
      }

      Behaviors.same
    }
}
