package dev.khusanjon
package components

import domains.Models.{Athlete}

class DataLoader {
  private val khusanjon = Athlete("26031999", "Khusanjon Tuychiboev", position = "Boxer", nation = "Uzbek", 1.78, 74, 24)
  private val khabib = Athlete("20091988", "Khabib Nurmugamedov", position = "Former UFC fighter", nation = "Russian", 1.78, 70, 35)
  private val mesut = Athlete("15101988", "Mesut O`zil", position = "Footballer", nation = "Turk", 1.8, 68, 35)

  private val athletesMap = Map(khusanjon.identification -> khusanjon,
                                khabib.identification -> khabib, mesut.identification -> mesut)
  private val athletes = List(khusanjon, khabib, mesut)

  def getAnAthlete(identification: String): Athlete = athletesMap(identification)

  def getAllAthletes: List[Athlete] = athletes
}
