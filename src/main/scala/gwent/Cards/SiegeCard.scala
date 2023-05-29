package cl.uchile.dcc
package gwent.Cards

import cl.uchile.dcc.gwent.Board.Section

import java.util.Objects

/** Clase de carta tipo asedio
 *
 * Las cartas de asedio, tiene un tipo fijo, ademas de un nombre y fuerza que los identifica
 *
 * @param name nombre de la carta
 * @param strength fuerza de la carta
 *                 
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.2
 */
class SiegeCard (private val name: String, private  val strength: Int) extends UnitCard(name, strength)  {
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
      return super.equals(other)
    } else {
      return false
    }
  }

  /**
   * hashcode
   */
  override def hashCode(): Int = Objects.hash(classOf[SiegeCard], name, strength)
}
