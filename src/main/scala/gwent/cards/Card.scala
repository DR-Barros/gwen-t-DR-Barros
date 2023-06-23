package cl.uchile.dcc
package gwent.cards

import gwent.board.{Board, Section}

trait Card {
  def getName(): String

  def getCardType(): String
  
  def assignZone(sec: Section, wheather: Array[WeatherCard]): Unit
  
  def apply(board: Board, boardSection: Section): Unit

}
