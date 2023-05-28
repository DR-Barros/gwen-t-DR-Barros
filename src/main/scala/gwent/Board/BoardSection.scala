package cl.uchile.dcc
package gwent.Board

import gwent.Cards.Card

class BoardSection {
  private var zoneC: Array[Card] = new Array[Card](6)
  private var countC: Int = 0
  private var zoneD: Array[Card] = new Array[Card](6)
  private var countD: Int = 0
  private var zoneS: Array[Card] = new Array[Card](6)
  private var countS: Int = 0

  def assignZoneC(card: Card): Unit = {
    zoneC(countC) = card
    countC += 1
  }

  def assignZoneD(card: Card): Unit = {
    zoneD(countD) = card
    countD += 1
  }

  def assignZoneS(card: Card): Unit = {
    zoneS(countS) = card
    countD += 1
  }

  def getZoneC(): Array[Card] = {
    return zoneC
  }

  def getZoneD(): Array[Card] = {
    return zoneD
  }

  def getZoneS(): Array[Card] = {
    return zoneS
  }
}
