package cl.uchile.dcc
package gwent.cards

import gwent.cards.Card

import cl.uchile.dcc.gwent.board.{Board, Section}
import cl.uchile.dcc.gwent.cards.effects.{Effect, UnitEffect}
import cl.uchile.dcc.gwent.cards.states.{CardState, ClearState}

import java.util.Objects

/** Clase abstracta de cartas Unidad
 * 
 * Las cartas de unidad que van a implementar esta clase abstracta son siegeCard, CorpCard y DistanceCard.
 * Las cartas de unidad tienen en comun tener un nombre, un tipo y fuerza.
 * 
 * @param name nombre de la carta
 * @param strength fuerza de la carta
 * @param effect el efecto de la carta                
 *                 
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.2                  
 */
abstract class AbstractUnitCard(private val name: String, private var strength: Int, private val effect: UnitEffect) extends UnitCard with Equals {
  /** el estado de clima que afecta a la carta */
  private var state: CardState = new ClearState()
  state.setCard(this)

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
    if (isClear()){
      return  strength
    } else {
      return 1
    }
  }

  /** Entrega la información a imprimir de la carta
   * 
   * @return un string con lo que deberia imprimir la carta
   */
   def print(): String = {
     val ret: String = getName() + " Fuerza: " + getStrength() + " Efecto: " + effect.getName()
     return ret
   }

  /** Aumenta en uno la fuerza de la carta
   */
  def moreStrength(): Unit = {
    strength += 1
  }

  /** Le entrega la responsabilidad a la carta de aplicar el efecto
   *
   * @param board        tablero del juego
   * @param boardSection seccion donde juega el jugador que uso la carta
   */
  def apply(board: Board, boardSection: Section): Unit = {
    effect.apply(boardSection, this)
  }

  /** Cambia el estado de clima que afecta a la carta
   *
   * @param cState estado al cual se va a cambiar
   */
  def setState(cState: CardState): Unit = {
    state = cState
    state.setCard(this)
  }

  /** Cambia al estado despejado
   */
  def clear(): Unit = state.clear()

  /** Cambia al estado Niebla
   */
  def fog(): Unit = state.fog()

  /** Cambia al estado escarcha
   */
  def frost(): Unit = state.frost()

  /** Cambia al estado lluvia
   */
  def rain(): Unit = state.rain()

  /** Devuelve true o false según si esta en el estado despejado
   *
   * @return true or false
   */
  def isClear(): Boolean = state.isClear()

  /** Devuelve true o false según si esta en el estado niebla
   *
   * @return true or false
   */
  def isFog(): Boolean = state.isFog()

  /** Devuelve true o false según si esta en el estado escarcha
   *
   * @return true or false
   */
  def isFrost(): Boolean = state.isFrost()

  /** Devuelve true o false según si esta en el estado lluvia
   *
   * @return true or false
   */
  def isRain(): Boolean = state.isRain()
}
