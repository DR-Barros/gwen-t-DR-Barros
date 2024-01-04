package cl.uchile.dcc
package gwent.factories
import gwent.cards.{Card, CorpCard}

import scala.util.Random

/** Clase Fabrica de cartas cuerpo a cuerpo
 * 
 * Esta clase contiene el método para crear cartas cuerpo a cuerpo para poder ser usadas para crear mazos
 * 
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class CorpCardFactory extends AbstractUnitCardFactory {
  /** Listado de nombre para cartas cuerpo a cuerpo */
  private val nombres: Array[String] = Array(
    "Anakin Skywalker",
    "Obi-Wan Kenobi",
    "Qui-Gon Jinn",
    "Palpatine",
    "Doku",
    "Darth Maul",
    "Ahsoka Tano",
    "Yoda",
    "Mace Windu",
    "Plo Koon",
    "Even Piell",
    "Kit Fisto",
    "Luminara Undull",
    "Asajj Ventress",
    "Kanan Jarrus",
    "Ezra Bridger",
    "Luke Skywalker",
    "Kylo Ren",
    "Rey",
    "General Grievous"
  )

  /** Crea las cartas de forma random
   * 
   * @return una carta de ataque cuerpo a cuerpo
   */
  def create(): Card = {
    val r = new Random()
    return new CorpCard(nombres(r.nextInt(20)),r.nextInt(21), effect(r.nextInt(4)))
  }
}
