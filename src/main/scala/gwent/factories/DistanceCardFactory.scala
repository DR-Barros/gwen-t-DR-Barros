package cl.uchile.dcc
package gwent.factories

import gwent.cards.{Card, DistanceCard}
import scala.util.Random

/** Clase Fabrica de cartas de ataque a distancia
 *
 * Esta clase contiene el método para crear cartas de ataque a distancia para poder ser usadas para crear mazos
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class DistanceCardFactory extends AbstractUnitCardFactory {
  /** Listado de nombre para cartas de ataque a distancia */
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

  /** Crea las cartas de forma random
   *
   * @return una carta de ataque a distancia
   */
  def create(): Card = {
    val r = new Random()
    return new DistanceCard(nombres(r.nextInt(17)), r.nextInt(21), effect(r.nextInt(4)))
  }
}
