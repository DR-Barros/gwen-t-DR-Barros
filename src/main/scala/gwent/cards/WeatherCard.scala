package cl.uchile.dcc
package gwent.cards

import cl.uchile.dcc.gwent.board.{Board, BoardSection, Section}
import cl.uchile.dcc.gwent.cards.effects.WeatherEffect

import java.util.Objects

/** Clase de carta tipo clima
 *
 * Las cartas de clima tienen un tipo y un nombre que las identifica
 *
 * @param name nombre
 * @param effect el efecto de la carta
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.3
 */
class WeatherCard(private val name: String, private val effect: WeatherEffect) extends Card with Equals {
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
  def assignZone(sec: Section, wheather: Array[Card]): Unit = {
    wheather(0) = this
  }

  /** Devuelve el tipo de la carta
   *
   * @return "Weather"
   */
  def getCardType(): String = {
    return "Weather"
  }

  /** Le entrega la responsabilidad a la carta de aplicar el efecto
   *
   * @param board tablero del juego
   * @param boardSection seccion donde juega el jugador que uso la carta
   */
  def apply(board: Board, boardSection: BoardSection): Unit = {
    effect.apply(board)
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
