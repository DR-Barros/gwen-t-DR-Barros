package cl.uchile.dcc
package gwent.players

import gwent.cards.{Card, Deck}

trait Player {
  def getName(): String
  def getGems(): Int
  def loseGems(): Unit
  def handSize(): Int
  def stealCard(): Unit
  def playCard(n: Int): Card
}
