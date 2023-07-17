package cl.uchile.dcc
package gwent.factories
import gwent.cards.{Card, WeatherCard}

import scala.util.Random

/** Clase Fabrica de cartas de clima
 *
 * Esta clase contiene el método para crear cartas de clima para poder ser usadas para crear mazos
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class WeatherCardFactory extends AbstractWeatherCardFactory {
  /** Listado de nombre para cartas de clima */
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

  /** Crea las cartas de forma random
   *
   * @return una carta de clima
   */
  def create(): Card = {
    val r = new Random()
    return new WeatherCard(nombres(r.nextInt(14)), effect(r.nextInt(4)))
  }
}
