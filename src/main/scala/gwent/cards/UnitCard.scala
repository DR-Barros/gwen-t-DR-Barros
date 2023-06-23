package cl.uchile.dcc
package gwent.cards

import gwent.cards.states.CardState

import cl.uchile.dcc.gwent.board.Section

trait UnitCard extends  Card {
  def getStrength(): Int
  def moreStrength(): Unit
  def bond(boardSection: Section): Unit
  def moral(boardSection: Section): Unit
  def setState(cState: CardState): Unit
  def clear(): Unit
  def fog(): Unit
  def frost(): Unit
  def rain(): Unit
  def isClear(): Boolean
  def isFog(): Boolean
  def isFrost(): Boolean
  def isRain(): Boolean
}
