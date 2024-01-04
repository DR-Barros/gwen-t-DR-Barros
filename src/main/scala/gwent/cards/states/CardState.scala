package cl.uchile.dcc
package gwent.cards.states

import gwent.cards.UnitCard

trait CardState {
  def setCard(card: UnitCard): Unit
  protected def changeState(state: CardState): Unit
  def clear(): Unit
  def fog(): Unit
  def frost(): Unit
  def rain(): Unit
  def isClear(): Boolean
  def isFog(): Boolean
  def isFrost(): Boolean
  def isRain(): Boolean
}
