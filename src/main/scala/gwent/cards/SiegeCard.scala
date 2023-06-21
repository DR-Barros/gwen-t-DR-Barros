package cl.uchile.dcc
package gwent.cards

import cl.uchile.dcc.gwent.board.Section
import cl.uchile.dcc.gwent.cards.effects.UnitEffect

import java.util.Objects

/** Clase de carta tipo asedio
 *
 * Las cartas de asedio, tiene un tipo fijo, ademas de un nombre y fuerza que los identifica
 *
 * @param name nombre de la carta
 * @param strength fuerza de la carta
 * @param effect el efecto de la carta                
 *                 
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.3
 */
class SiegeCard (private val name: String, private  var strength: Int, private val effect: UnitEffect) extends UnitCard(name, strength, effect)  {
  def getCardType(): String = {
    return "Siege"
  }

  /** Asigna la carta en la fila de asedio de la sección entregada
   *
   * @param sec es la seccion del tablero a la cual hay que asignar la carta
   * @param wheather corresponde a la seccion de clima
   */
  def assignZone(sec: Section, wheather: Array[Card]): Unit = {
    sec.assignZoneS(this)
  }

  /**
   * Comprobar si el objeto es de la mima clase que el objeto actual
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[SiegeCard]

  /**
   * Evalua si son iguales
   */
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val other = obj.asInstanceOf[SiegeCard]
      return (this eq other) || (this.getName() == other.getName() && this.getStrength() == other.getStrength())
    } else {
      return false
    }
  }

  /**
   * hashcode
   */
  override def hashCode(): Int = Objects.hash(classOf[SiegeCard], name, strength)
}
