package cl.uchile.dcc
package gwent.Cards

import gwent.Cards.Card

abstract class UnitCard(private val name: String, private val strength: Int) extends Card {
  def getName(): String = {
    return name
  }
  def getCardType(): String = {
    return  "Unit"
  }
  def getStrength(): Int = {
    return  strength
  }
}
