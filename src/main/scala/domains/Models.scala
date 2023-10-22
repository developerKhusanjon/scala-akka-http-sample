package dev.khusanjon
package domains

object Models {
  case class Athlete(identification: String, name: String, position: String,
                     nation: String, height: Double, weight: Double, age: Int)
}
