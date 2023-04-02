package cl.uchile.dcc
package gwent

class WeatherCard(private val name: String) extends Card {
  private val cardType: String = "Weather"

  def getName(): String = {
    return name
  }

  def getCardType(): String = {
    return cardType
  }
}
