package cl.uchile.dcc
package gwent.board

import gwent.cards.{CorpCard, DistanceCard, SiegeCard}

import scala.collection.mutable.ArrayBuffer

trait Section {
  def assignZoneC(card: CorpCard): Unit
  def assignZoneD(card: DistanceCard): Unit
  def assignZoneS(card: SiegeCard): Unit
  def getStrength(): Int
  def getZoneC(): ArrayBuffer[CorpCard]
  def getZoneD(): ArrayBuffer[DistanceCard]
  def getZoneS(): ArrayBuffer[SiegeCard]
  def clean(): Unit
  def bondC(card: CorpCard): Unit
  def bondD(card: DistanceCard): Unit
  def bondS(card: SiegeCard): Unit
  def moralC(): Unit
  def moralD(): Unit
  def moralS(): Unit
  def clear(): Unit
  def fog(): Unit
  def frost(): Unit
  def rain(): Unit
}
