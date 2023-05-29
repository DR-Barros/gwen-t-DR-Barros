package cl.uchile.dcc
package gwent.Cards

import gwent.Cards.Card

import cl.uchile.dcc.gwent.Board.BoardSection

import java.util.Objects

/** Clase de carta tipo clima
 *
 * Las cartas de clima tienen un tipo y un nombre que las identifica
 *
 * @param name nombre
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.2             
 */
class WeatherCard(private val name: String) extends Card with Equals {
  /** Devuelve el nombre de la carta
   *
   * @return nombre
   */
  def getName(): String = {
    return name
  }

  /** Asigna la carta en la seccion de clima
   * 
   * @param sec es la seccion del tablero a la cual hay que asignar la carta
   * @param wheather corresponde a la seccion de clima
   */
  def assignZone(sec: BoardSection, wheather: Array[Card]): Unit = {
    wheather(0) = this
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
