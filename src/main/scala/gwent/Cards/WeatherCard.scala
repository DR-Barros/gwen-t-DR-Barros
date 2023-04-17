package cl.uchile.dcc
package gwent.Cards

import gwent.Cards.Card

class WeatherCard(private val name: String) extends Card {
  def getName(): String = {
    return name
  }

  def getCardType(): String = {
    return "Weather"
  }
}
