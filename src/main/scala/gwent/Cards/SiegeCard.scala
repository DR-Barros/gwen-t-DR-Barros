package cl.uchile.dcc
package gwent.Cards

import java.util.Objects

/** Clase de carta tipo cuerpo a cuerpo
 *
 * @param name nombre de la carta
 * @param strength fuerza de la carta
 */
class SiegeCard (private val name: String, private  val strength: Int) extends UnitCard(name, strength) with Equals {
  override def getCardType(): String = {
    return "Siege"
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
