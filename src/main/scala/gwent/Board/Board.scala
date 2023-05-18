package cl.uchile.dcc
package gwent.Board
import gwent.Cards.Card

import gwent.Players.Player

class Board{
  private val sec1: BoardSection = new BoardSection
  private val sec2: BoardSection = new BoardSection
  private val weatherSec: Array[Card] = new Array[Card](1)

  def playCardSec1(player: Player, n: Int): Unit = {
    val card = player.playCard(n)
    card.assignZone(sec1, weatherSec)
  }
  def playCardSec2(player: Player, n: Int): Unit = {
    val card = player.playCard(n)
    card.assignZone(sec2, weatherSec)
  }
  def getSec1C(): Array[Card] = {
    return sec1.getZoneC()
  }

  def getSec1D(): Array[Card] = {
    sec1.getZoneD()
  }

  def getSec1S(): Array[Card] = {
    sec1.getZoneS()
  }

  def getSec2C(): Array[Card] = {
    sec2.getZoneC()
  }

  def getSec2D(): Array[Card] = {
    sec2.getZoneD()
  }

  def getSec2S(): Array[Card] = {
    sec2.getZoneS()
  }
  def getSecW():Array[Card] = {
    return weatherSec
  }
}
