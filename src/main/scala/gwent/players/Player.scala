package cl.uchile.dcc
package gwent.players

import gwent.cards.Card

import cl.uchile.dcc.gwent.cards.structures.Deck
import cl.uchile.dcc.gwent.observer.Observer

import scala.collection.mutable.ArrayBuffer

trait Player {
  def getName(): String
  def getGems(): Int
  def loseGems(): Unit
  def handSize(): Int
  def getHand(): ArrayBuffer[Card]
  def handStrength(): Int
  def handHasWeatherCard(): Int
  def handHasUnitCard(): Int
  def stealCard(): Unit
  def playCard(n: Int): Card
  def registerObserver(o: Observer): Unit
  def notifyObservers(response: Any): Unit
}
