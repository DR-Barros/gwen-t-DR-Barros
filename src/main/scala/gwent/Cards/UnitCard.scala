package cl.uchile.dcc
package gwent.Cards

import gwent.Cards.Card

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
 * @version 1.0.0                  
 */
abstract class UnitCard(private val name: String, private val strength: Int) extends Card {
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
}
