package cl.uchile.dcc
package gwent.Cards

import gwent.Cards.Card
/** Clase de carta vacia
 *
 * Son un tipo de cartas especial usadas para mostrar que Deck o CardsHand esta vacio
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0 
 */
class emptyCard extends Card {
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
}
