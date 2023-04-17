package cl.uchile.dcc
package gwent.Cards

import java.util.Objects

/** Clase de carta tipo cuerpo a cuerpo
 * 
 * Las cartas  cuerpo a cuerpo, tiene un tipo fijo que indica su tipo, ademas de un nombre y fuerza que los identifica
 *
 * @param name nombre de la carta
 * @param strength fuerza de la carta
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0 
 */
class CorpCard(private val name: String, private  val strength: Int) extends UnitCard(name, strength) with Equals {
  /**Devuelve el tipo de la carta
   * 
   * @return "Corp"
   */
  override def getCardType(): String = {
    return "Corp"
  }

  /**
   * Comprobar si el objeto es de la mima clase que el objeto actual
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CorpCard]

  /**
   * Evalua si son iguales
   */
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val other = obj.asInstanceOf[CorpCard]
      return (this eq other) || (this.getName() == other.getName() && this.getStrength() == other.getStrength())
    } else {
      return false
    }
  }

  /**
   * hashcode
   */
  override def hashCode(): Int = Objects.hash(classOf[CorpCard], name, strength)
}
