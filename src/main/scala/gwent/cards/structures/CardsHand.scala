package cl.uchile.dcc
package gwent.cards.structures

import gwent.cards.{Card, UnitCard, WeatherCard}
import gwent.exception.{HandDontHaveCard, HandIsFull}

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

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
  private var cards: ArrayBuffer[Card] = new ArrayBuffer[Card]()


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
   * Si la mano ya esta llena lanza la excepcion HandIsFull
   *
   * @param card recibe una carta
   *
   * @throws HandIsFull si es que la mano esta llena
   */
  def addCards(card: Card): Unit = {
    if (handSize() < 10){
      cards += card
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
      cards -= card
      return card
    }
    throw new HandDontHaveCard("La mano no contiene  la carta solicitada")
  }

  /** entrega la fuerza sumada de las cartas en la mano
   *
   * @return la fuerza que hay en la mano
   */
  def getStrength(): Int = {
    var result: Int = 0
    cards.foreach(card => if (card.isInstanceOf[UnitCard]) result+= card.asInstanceOf[UnitCard].getStrength())
    return result
  }

  /** Devuelve si hay cartas de clima en la mano
   *
   * @return el numero de la carta de una de las cartas de clima, si no hay devuelve -1
   */
  def hasWeatherCard(): Int = {
    for (i <- 0 to handSize()){
      if(cards(i).isInstanceOf[WeatherCard])
        return i
    }
    return -1
  }

  /** Devuelve si hay cartas de unidad en la mano
   *
   * @return el numero de la carta de una de las cartas de unidad, si no hay devuelve -1
   */
  def hasUnitCard(): Int = {
    for (i <- 0 to handSize()) {
      if (cards(i).isInstanceOf[UnitCard])
        return i
    }
    return -1
  }
}
