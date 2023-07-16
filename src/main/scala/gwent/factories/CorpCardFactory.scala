package cl.uchile.dcc
package gwent.factories
import gwent.cards.{Card, CorpCard}

import scala.util.Random

class CorpCardFactory extends AbstractUnitCardFactory {
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
  def create(): Card = {
    val r = new Random()
    return new CorpCard(nombres(r.nextInt(20)),r.nextInt(21), effect(r.nextInt(4)))
  }
}
