package cl.uchile.dcc
package gwent.Cards

import gwent.Board.Section

trait Card {
  def getName(): String

  def getCardType(): String
  
  def assignZone(sec: Section, wheather: Array[Card]): Unit
}
