package cl.uchile.dcc
package gwent.Cards

import gwent.Cards.Card

class UnitCard(private val name: String, private val strength: Int) extends Card {
  private val cardType: String = "Unit"
  def getName(): String = {
    return name
  }
  def getCardType(): String = {
    return  cardType
  }
  def getStrength(): Int = {
    return  strength
  }
}
