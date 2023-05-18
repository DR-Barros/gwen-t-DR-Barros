package cl.uchile.dcc
package gwent.Cards

import gwent.Board.BoardSection

trait Card {
  def getName(): String

  def getCardType(): String
  
  def assignZone(sec: BoardSection, wheather: Array[Card]): Unit
}
