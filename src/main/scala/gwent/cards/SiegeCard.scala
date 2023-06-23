package cl.uchile.dcc
package gwent.cards

import cl.uchile.dcc.gwent.board.Section
import cl.uchile.dcc.gwent.cards.effects.UnitEffect

import java.util.Objects
import scala.collection.mutable.ArrayBuffer

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
class SiegeCard (private val name: String, private  var strength: Int, private val effect: UnitEffect) extends AbstractUnitCard(name, strength, effect)  {
  def getCardType(): String = {
    return "Siege"
  }

  /** Asigna la carta en la fila de asedio de la sección entregada
   *
   * @param sec es la seccion del tablero a la cual hay que asignar la carta
   * @param wheather corresponde a la seccion de clima
   */
  def assignZone(sec: Section, wheather: Array[WeatherCard]): Unit = {
    sec.assignZoneS(this)
  }

  /** Una carta de asedio al aplicar vinculo aumenta la fuerza de las cartas en su fila si hay una carta con su nombre */
  def bond(boardSection: Section): Unit = {
    val fila: ArrayBuffer[UnitCard] = boardSection.getZoneS()
    var name: Boolean = false
    fila.foreach(card => if (card.getName() == getName()) {
      name = true
    })
    if (name) {
      this.moreStrength()
      boardSection.bondS(this)
    }
  }

  /** Una carta de asedio al aplicar moral aumenta la fuerza de las cartas en su fila */
  def moral(boardSection: Section): Unit = {
    boardSection.moralS()
  }

  /** Una carta de asedio no puede pasar al estado escarcha */
  override def frost(): Unit = clear()

  /** Una carta de asedio no puede pasar al estado niebla */
  override def fog(): Unit = clear()

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
