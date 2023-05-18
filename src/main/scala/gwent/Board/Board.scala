package cl.uchile.dcc
package gwent.Board
import gwent.Cards.Card

import gwent.Players.Player

class Board{
  private val sec1: BoardSection = new BoardSection
  private val sec2: BoardSection = new BoardSection
  private val wheatherSec: Array[Card] = new Array[Card](1)

  def playCardSec1(player: Player, n: Int): Unit = {
    val card = player.playCard(n)
    card.assignZone(sec1, wheatherSec)
  }

  def playCardSec2(player: Player, n: Int): Unit = {
    val card = player.playCard(n)
    card.assignZone(sec2, wheatherSec)
  }
}
