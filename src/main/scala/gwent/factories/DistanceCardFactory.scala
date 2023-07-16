package cl.uchile.dcc
package gwent.factories

import gwent.cards.{Card, DistanceCard}
import scala.util.Random

class DistanceCardFactory extends AbstractUnitCardFactory {
  private val nombres: Array[String] = Array(
    "Leia", 
    "Han Solo",
    "Boba Fett",
    "Jango Fett",
    "Cad Bane",
    "Din Djarin",
    "Zuckuss",
    "Poe Dameron",
    "Finn", 
    "Chewbacca",
    "Jar Jar Binks",
    "Lando Calrissian",
    "Cody", 
    "Cincos",
    "Stormtropper",
    "Droideka",
    "Droide de Batalla B2"
  )
  def create(): Card = {
    val r = new Random()
    return new DistanceCard(nombres(r.nextInt(17)), r.nextInt(21), effect(r.nextInt(4)))
  }
}
