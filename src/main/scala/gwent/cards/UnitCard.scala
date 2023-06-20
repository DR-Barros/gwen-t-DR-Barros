package cl.uchile.dcc
package gwent.cards

import gwent.cards.Card

import cl.uchile.dcc.gwent.board.{Board, BoardSection}
import cl.uchile.dcc.gwent.cards.effects.{Effect, UnitEffect}

import java.util.Objects

/** Clase abstracta de cartas Unidad
 * 
 * Las cartas de unidad que van a implementar esta clase abstracta son siegeCard, CorpCard y DistanceCard.
 * Las cartas de unidad tienen en comun tener un nombre, un tipo y fuerza.
 * 
 * @param name nombre de la carta
 * @param strength fuerza de la carta
 * @param effect el efecto de la carta                
 *                 
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.2                  
 */
abstract class UnitCard(private val name: String, private val strength: Int, private val effect: UnitEffect) extends Card with Equals {
  /**Devuelve el nombre de la carta
   * 
   * @return nombre
   */
  def getName(): String = {
    return name
  }

  /**Devuelve la fuerza de la carta
   * 
   * @return fuerza
   */
  def getStrength(): Int = {
    return  strength
  }

  /** Le entrega la responsabilidad a la carta de aplicar el efecto
   *
   * @param board        tablero del juego
   * @param boardSection seccion donde juega el jugador que uso la carta
   */
  def apply(board: Board, boardSection: BoardSection): Unit = {
    effect.apply(boardSection, this)
  }

  /**
   * Comprobar si el objeto es de la mima clase que el objeto actual
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[UnitCard]

  /**
   * Evalua si son iguales
   */
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val other = obj.asInstanceOf[UnitCard]
      return (this eq other) || (this.getName() == other.getName() && this.getStrength() == other.getStrength())
    } else {
      return false
    }
  }

  /**
   * hashcode
   */
  override def hashCode(): Int = Objects.hash(classOf[UnitCard], name, strength)
}
