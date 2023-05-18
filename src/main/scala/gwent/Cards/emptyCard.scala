package cl.uchile.dcc
package gwent.Cards

import gwent.Cards.Card

import cl.uchile.dcc.gwent.Board.BoardSection

import java.util.Objects
/** Clase de carta vacia
 *
 * Son un tipo de cartas especial usadas para mostrar que Deck o CardsHand esta vacio
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0 
 */
class emptyCard extends Card with Equals {
  /**Devuelve el nombre de la carta
   * 
   * @return "empty"
   */
  def getName(): String = {
    return "empty"
  }

  /**Devuelve el tipo de carta
   *
   * @return "empty"
   */
  def getCardType(): String = {
    return "empty"
  }

  def assignZone(sec: BoardSection, wheather: Array[Card]): Unit = {
    return 
  }

  /**
   * Comprobar si el objeto es de la mima clase que el objeto actual
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[emptyCard]

  /**
   * Evalua si son iguales
   */
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val other = obj.asInstanceOf[emptyCard]
      return (this eq other) || (this.getName() == other.getName() && this.getCardType() == other.getCardType())
    } else {
      return false
    }
  }

  /**
   * hashcode
   */
  override def hashCode(): Int = Objects.hash(classOf[emptyCard])
}
