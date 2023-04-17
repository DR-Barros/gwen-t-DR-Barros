package cl.uchile.dcc
package gwent.Cards

import gwent.Cards.Card

import scala.collection.mutable.ListBuffer

/**Una clase que representa una mano de cartas
 *
 * Una mano de cartas se define como un conjunto de cartas. Ademas,
 * una mano tiene las acciones añadir cartas y jugar cartas
 *
 * @constructor crea una lista que contenga al conjunto de cartas
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class CardsHand {
  /** Lista de cartas
   *
   * Esta variable guarda el conjunto de cartas de la mano
   */
  private var cards: ListBuffer [Card] = ListBuffer [Card]()

  /** Calcula el tamaño de la mano
   *
   * Calcula cuantas cartas estan guardadas en la variable cards y lo devuelve como el tamaño de la mano
   *
   * @return el tamaño de la mano
   */
  def handSize(): Int = {
    return cards.size
  }

  /** Añade una carta a la mano
   *
   * Recibe una carta y se la añade a cards para añadirla a la mano
   *
   * @param card recibe una carta
   */
  def addCards(card: Card): Unit = {
    if (card.getCardType() != "Empty" && handSize() < 10){
      cards += card
    }
  }

  /** Juega una carta de la mano
   *
   * recibe un numero que indica el indice de la carta a jugar, se extrae la carta de la mano,
   * se elimina la carta de la mano y luego se devuelve la carta jugada
   *
   * @param n el numero de la carta que se va a jugar
   * @return la carta jugada
   */
  def playCard(n: Int): Card = {
    val card = cards(n)
    cards -= card
    return card
  }
}
