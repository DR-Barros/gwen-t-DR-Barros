package cl.uchile.dcc
package gwent.Board

import gwent.Cards.Card

class BoardSection {
  private var zoneC: Array[Card] = new Array[Card](25)
  private var countC: Int = 0
  private var zoneD: Array[Card] = new Array[Card](25)
  private var countD: Int = 0
  private var zoneS: Array[Card] = new Array[Card](25)
  private var countS: Int = 0

  def assignZoneC(card: Card): Unit = {
    val size: Int = zoneC.length
    zoneC(countC) = card
    countC += 1
  }

  def assignZoneD(card: Card): Unit = {
    val size: Int = zoneD.length
    zoneD(countD) = card
    countD += 1
  }

  def assignZoneS(card: Card): Unit = {
    val size:Int = zoneS.length
    zoneS(countS) = card
    countD += 1
  }

  def showZoneC(): Array[Card] = {
    return zoneC
  }

  def showZoneD(): Array[Card] = {
    return zoneC
  }

  def showZoneS(): Array[Card] = {
    return zoneC
  }
}
