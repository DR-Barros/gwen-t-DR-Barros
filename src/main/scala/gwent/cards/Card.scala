package cl.uchile.dcc
package gwent.cards

import gwent.board.Section

trait Card {
  def getName(): String

  def getCardType(): String
  
  def assignZone(sec: Section, wheather: Array[Card]): Unit
}
