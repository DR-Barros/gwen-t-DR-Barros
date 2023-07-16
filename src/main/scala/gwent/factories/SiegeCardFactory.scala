package cl.uchile.dcc
package gwent.factories

import gwent.cards.{Card, SiegeCard}

import scala.util.Random

class SiegeCardFactory extends AbstractUnitCardFactory {
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
  def create(): Card = {
    val r = new Random()
    return new SiegeCard(nombres(r.nextInt(14)), r.nextInt(21), effect(r.nextInt(4)))
  }
}
