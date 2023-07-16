package cl.uchile.dcc
package gwent.factories
import gwent.cards.{Card, WeatherCard}

import scala.util.Random

class WeatherCardFactory extends AbstractWeatherCardFactory {
  private val nombres: Array[String] = Array(
    "Alderan",
    "Aldahani",
    "Ahch-To",
    "Dagobah",
    "Kamino",
    "Jedha",
    "Mon Cala",
    "Hoth",
    "ilum",
    "Mygeeto",
    "Bespin",
    "Yavin",
    "Narkina 5",
    "Niamos",
    "Rodia",
    "Ryloth",
    "Scarif",
    "Shili"
  )
  def create(): Card = {
    val r = new Random()
    return new WeatherCard(nombres(r.nextInt(14)), effect(r.nextInt(4)))
  }
}
