package cl.uchile.dcc
package gwent.Board

import gwent.Cards.Card

trait Section {
  def assignZoneC(card: Card): Unit 
  def assignZoneD(card: Card): Unit 
  def assignZoneS(card: Card): Unit
  def getZoneC(): Array[Card] 
  def getZoneD(): Array[Card] 
  def getZoneS(): Array[Card] 
}
