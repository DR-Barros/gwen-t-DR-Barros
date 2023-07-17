package cl.uchile.dcc
package gwent.factories

import gwent.cards.{Card, SiegeCard}

import scala.util.Random

/** Clase Fabrica de cartas de asedio
 *
 * Esta clase contiene el método para crear cartas de asedio para poder ser usadas para crear mazos
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class SiegeCardFactory extends AbstractUnitCardFactory {
  /** Listado de nombre para cartas de asedio */
  private val nombres: Array[String] = Array(
    "At AT",
    "At ST",
    "At TE",
    "Estrella de la Muerte",
    "Halcón milenario",
    "X Wings",
    "Y Wings",
    "Caza Tie",
    "Interceptor Tie",
    "Caza Delta 7",
    "Esclavo I",
    "Destructor Estela",
    "Razor Crest",
    "Caza estelar N-1"
  )

  /** Crea las cartas de forma random
   *
   * @return una carta de asedio
   */
  def create(): Card = {
    val r = new Random()
    return new SiegeCard(nombres(r.nextInt(14)), r.nextInt(21), effect(r.nextInt(4)))
  }
}
