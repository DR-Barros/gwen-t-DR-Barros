package cl.uchile.dcc
package gwent.players

import gwent.cards.Card
import cl.uchile.dcc.gwent.cards.structures.Deck

trait Player {
  def getName(): String
  def getGems(): Int
  def loseGems(): Unit
  def handSize(): Int
  def handStrength(): Int
  def stealCard(): Unit
  def playCard(n: Int): Card
}
