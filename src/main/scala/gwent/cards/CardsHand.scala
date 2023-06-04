package cl.uchile.dcc
package gwent.cards

import gwent.cards.Card

import cl.uchile.dcc.gwent.exception.{HandDontHaveCard, HandIsFull}

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
 * @version 1.0.2
 */
class CardsHand {
  /** Lista de cartas
   *
   * Esta variable guarda el conjunto de cartas de la mano en un array
   */
  private var cards: Array[Card] = new Array[Card](10)

  /** Cantidad de cartas en la mano
   *
   * Esta variable guarda cuantas cartas hay en la mano
   */
  private var cant: Int = 0

  /** Calcula el tamaño de la mano
   *
   * Calcula cuantas cartas estan guardadas en la variable cards y lo devuelve como el tamaño de la mano
   *
   * @return el tamaño de la mano
   */
  def handSize(): Int = {
    return cant
  }

  /** Añade una carta a la mano
   *
   * Recibe una carta y se la añade a cards para añadirla a la mano
   * Si la mano ya esta llena lanza la excepcion HandIsFull
   *
   * @param card recibe una carta
   *
   * @throws HandIsFull si es que la mano esta llena
   */
  def addCards(card: Card): Unit = {
    if (handSize() < 10){
      cards(cant) = card
      cant += 1
    } else{
      throw new HandIsFull("la mano esta llena, no puede agregar mas cartas")
    }
  }

  /** Juega una carta de la mano
   *
   * recibe un numero que indica el indice de la carta a jugar, se extrae la carta de la mano,
   * se elimina la carta de la mano y luego se devuelve la carta jugada
   * Si la carta solicitada no esta en la carta se lanza una excepcion de tipo HandDontHaveCard
   *
   * @param n el numero de la carta que se va a jugar
   *          
   * @throws HandDontHaveCard cuando no hay carta en el indice entregado         
   *          
   * @return la carta jugada
   */
  def playCard(n: Int): Card = {
    if (n < handSize() && n>=0){
      val card = cards(n)
      cant -= 1
      for (i <- n until cant) {
        cards(i) = cards(i + 1)
      }
      return card
    }
    throw new HandDontHaveCard("La mano no contiene  la carta solicitada")
  }
}