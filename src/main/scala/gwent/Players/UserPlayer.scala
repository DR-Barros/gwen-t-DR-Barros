package cl.uchile.dcc
package gwent.Players

import gwent.Cards.{Card, CardsHand, Deck, emptyCard}
import gwent.Players.Player
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
 * @version 1.0.2
 */
class UserPlayer (private  val name: String, private val zone: Int, private var deck: Deck) extends Player with Equals {
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

  /**
   * Devuelve el nombre del jugador.
   */
  def getName(): String = {
    return name
  }

  /**
   * Devuelve la zona del tablero del jugador.
   */
  def getZone(): Int = {
    return zone
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
    if (handSize() < 10){
      val card = deck.stealCard()
      if (card.getName() != "empty") {
        cardHand.addCards(card)
      }
    }
  }

  /**
   * Realiza la acción de jugar una carta de la mano.
   */
  def playCard(n: Int): Card = {
    var hS = handSize()
    if (hS > 0 && n < hS){
      return cardHand.playCard(n)
    } else if (hS > 0){
      return cardHand.playCard(hS -1)
    } else {
      return  new emptyCard
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
       return (this eq other) || (this.getName() == other.getName() && this.getZone() == other.getZone())
    } else {
      return false
    }
  }

  /**
   * hashcode
   */
  override def hashCode(): Int = Objects.hash(classOf[UserPlayer], name, zone)
}
