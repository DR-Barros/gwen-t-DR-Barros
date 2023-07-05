package cl.uchile.dcc
package gwent.players

import gwent.cards.Card
import gwent.players.Player
import cl.uchile.dcc.gwent.cards.structures.{CardsHand, Deck}

import cl.uchile.dcc.gwent.observer.{ISubject, Observer}

import java.util.Objects
import scala.collection.mutable.ListBuffer

/** clase que representa un jugador.
 *  Un jugador es cad uno de los participantes en una partida, estos tienen
 *  Nombre, Seccion en tablero, contador de gemas y mano de cartas.
 *  Ademas de las acciones jugar y robar cartas.
 * @param name indica el nombre del jugador.
 * @param zone indica la seccion del tablero
 *
 * @constructor crea un nuevo jugador con las especificaciones dadas ademas de un
 * contador de gemas que inicia en uno y una mano de cartas vacia
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.4
 */
class UserPlayer (private  val name: String, private var deck: Deck) extends Player with Equals with ISubject{
  /** Contador de gemas.
   *
   * Esta variable lleva la cuenta de cuantas gemas le quedan al jugador, se inicia en 2.
   */
  private var gems: Int = 2;

  /** Mano de Cartas.
   *
   * Esta variable es Una mano de cartas y por lo tanto instancia la clase CardsHand.
   */
  private var cardHand: CardsHand = new CardsHand

  /** Observers
   *
   * esta variable guarda en un list buffer todos los observers del jugador
   */
  private var observers: ListBuffer[Observer] = ListBuffer()

  /**
   * Devuelve el nombre del jugador.
   */
  def getName(): String = {
    return name
  }


  /**
   * Devuelve la cantidad de gemas que le quedan al jugador.
   */
  def getGems(): Int = {
    return gems
  }

  /**
   * Si es que al jugador le quedan gemas, reduce la cantidad en una.
   */
  def loseGems(): Unit = {
    if (gems >0){
      gems -= 1
      if (gems == 0){
        notifyObservers("Perdio")
      }
    }
  }

  /**
   * Devuelve la cantidad de cartas que el jugador tiene en la mano del jugador.
   */
  def handSize(): Int = {
    return cardHand.handSize()
  }

  /**
   * Realiza la acción de robar una carta del mazo.
   */
  def stealCard(): Unit = {
    val card = deck.stealCard()
    cardHand.addCards(card)
  }

  /**
   * Realiza la acción de jugar una carta de la mano.
   */
  def playCard(n: Int): Card = {
    var hS = handSize()
    return cardHand.playCard(n-1)
  }

  /** Añade observers a el jugador
   *
   * @param o observer a agregar
   */
  def registerObserver(o: Observer): Unit = observers += o

  def notifyObservers(response: Any): Unit = {
    for(o<-observers){
      o.update(this, response)
    }
  }

  /**
   * Comprobar si el objeto es de la mima clase que el objeto actual
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[UserPlayer]

  /**
   * Evalua si son iguales
   */
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)){
      val other = obj.asInstanceOf[UserPlayer]
       return (this eq other) || (this.getName() == other.getName())
    } else {
      return false
    }
  }
  /**
   * Hashcode
   */
  override def hashCode(): Int = Objects.hash(classOf[UserPlayer], name)
}
