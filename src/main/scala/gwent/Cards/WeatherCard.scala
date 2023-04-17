package cl.uchile.dcc
package gwent.Cards

import gwent.Cards.Card

import java.util.Objects

/** Clase de carta tipo clima
 *
 * Las cartas de clima tienen un tipo y un nombre que las identifica
 *
 * @param name nombre
 */
class WeatherCard(private val name: String) extends Card with Equals {
  /** Devuelve el nombre de la carta
   *
   * @return nombre
   */
  def getName(): String = {
    return name
  }

  /** Devuelve el tipo de la carta
   *
   * @return "Weather"
   */
  def getCardType(): String = {
    return "Weather"
  }

  /**
   * Comprobar si el objeto es de la mima clase que el objeto actual
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherCard]

  /**
   * Evalua si son iguales
   */
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val other = obj.asInstanceOf[WeatherCard]
      return (this eq other) || (this.getName() == other.getName() )
    } else {
      return false
    }
  }

  /**
   * hashcode
   */
  override def hashCode(): Int = Objects.hash(classOf[WeatherCard], name)
}
