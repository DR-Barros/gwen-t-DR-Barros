package cl.uchile.dcc
package gwent.Players

import gwent.Cards.{Card, Deck}

trait Player {
  def getName(): String
  def getGems(): Int
  def loseGems(): Unit
  def handSize(): Int
  def stealCard(): Unit
  def playCard(n: Int): Card
}
