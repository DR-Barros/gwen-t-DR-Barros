package cl.uchile.dcc
package gwent.Cards

import cl.uchile.dcc.gwent.Board.BoardSection

import java.util.Objects

/** Clase de carta tipo cuerpo a cuerpo
 * 
 * Las cartas  cuerpo a cuerpo, tiene un tipo fijo, ademas de un nombre y fuerza que los identifica
 *
 * @param name nombre de la carta
 * @param strength fuerza de la carta
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.2 
 */
class CorpCard(private val name: String, private  val strength: Int) extends UnitCard(name, strength){
  /**Devuelve el tipo de la carta
   * 
   * @return "Corp"
   */
  def getCardType(): String = {
    return "Corp"
  }

  /** Asigna la carta en la fila cuerpo a cuerpo de la seccion entregada
   * 
   * @param sec es la seccion del tablero a la cual hay que asignar la carta
   * @param wheather corresponde a la seccion de clima
   */
  def assignZone(sec: BoardSection, wheather: Array[Card]): Unit = {
    sec.assignZoneC(this)
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
      return super.equals(other)
    } else {
      return false
    }
  }

  /**
   * hashcode
   */
  override def hashCode(): Int = Objects.hash(classOf[CorpCard], name, strength)
}
