package cl.uchile.dcc
package gwent.cards

import gwent.cards.Card

import java.util.Objects

/** Clase abstracta de cartas Unidad
 * 
 * Las cartas de unidad que van a implementar esta clase abstracta son siegeCard, CorpCard y DistanceCard.
 * Las cartas de unidad tienen en comun tener un nombre, un tipo y fuerza.
 * 
 * @param name nombre de la carta
 * @param strength fuerza de la carta
 *                 
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.1                  
 */
abstract class UnitCard(private val name: String, private val strength: Int) extends Card with Equals {
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
