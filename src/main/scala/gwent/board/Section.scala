package cl.uchile.dcc
package gwent.board

import gwent.cards.UnitCard

import scala.collection.mutable.ArrayBuffer

trait Section {
  def assignZoneC(card: UnitCard): Unit
  def assignZoneD(card: UnitCard): Unit
  def assignZoneS(card: UnitCard): Unit
  def getStrength(): Int
  def getZoneC(): ArrayBuffer[UnitCard]
  def getZoneD(): ArrayBuffer[UnitCard]
  def getZoneS(): ArrayBuffer[UnitCard]
  def clean(): Unit
  def bondC(card: UnitCard): Unit
  def bondD(card: UnitCard): Unit
  def bondS(card: UnitCard): Unit
  def moralC(): Unit
  def moralD(): Unit
  def moralS(): Unit
  def clear(): Unit
  def fog(): Unit
  def frost(): Unit
  def rain(): Unit
}
