package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

import cl.uchile.dcc.gwent.exception.StateError

/** Clase abstracta de los estados
 *
 *
 * Define los métodos por defecto para los estados, estos seran modificados por los estados que la implementen
 * según necesidad.
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
abstract class AbstractState extends State {
  /** Game controller
   *
   * Representa el controlador del juego
   */
  protected var c: Option[GameController] = None

  /** Asigna el game controller al estado
   *
   * @param controller el game controller
   */
  def setController(controller: GameController): Unit = {
    c = Some(controller)
  }

  /** Cambia el estado en que se encuentra el controlador del juego
   *
   * @param state el estado nuevo al cual se va a cambiar
   */
  protected def changeState(state: State): Unit = {
    if(c.isDefined)
      c.get.setState(state)
  }

  /** Lanza la excepción señalando que no es posible esa transición */
  private def error() = throw new StateError("Wrong State")

  /** es llamada por el gamecontroller y por defecto llama a error */
  def start(): Unit = error()

  /** es llamada por el gamecontroller y por defecto llama a error */
  def roundInit(): Unit = error()

  /** es llamada por el gamecontroller y por defecto llama a error */
  def player1Turn(): Unit = error()

  /** es llamada por el gamecontroller y por defecto llama a error */
  def player2Turn(): Unit = error()

  /** es llamada por el gamecontroller y por defecto llama a error */
  def playCardP1(): Unit = error()

  /** es llamada por el gamecontroller y por defecto llama a error */
  def playCardP2(): Unit = error()

  /** es llamada por el gamecontroller y por defecto llama a error */
  def playCardsP1(): Unit = error()

  /** es llamada por el gamecontroller y por defecto llama a error */
  def playCardsP2(): Unit = error()

  /** es llamada por el gamecontroller y por defecto llama a error */
  def finishRound(): Unit = error()

  /** es llamada por el gamecontroller y por defecto llama a error */
  def nextRound(): Unit = error()

  /** es llamada por el gamecontroller y por defecto llama a error */
  def finishGame(): Unit = error()

  /** Indica si el estado actual es Start */
  def isStart(): Boolean = false

  /** Indica si el estado actual es RoundInit */
  def isRoundInit(): Boolean = false

  /** Indica si el estado actual es Player1Turn */
  def isPlayer1Turn(): Boolean = false

  /** Indica si el estado actual es Player2Turn */
  def isPlayer2Turn(): Boolean = false

  /** Indica si el estado actual es PlayCardP1 */
  def isPlayCardP1(): Boolean = false

  /** Indica si el estado actual es PlayCardP2 */
  def isPlayCardP2(): Boolean = false

  /** Indica si el estado actual es PlayCardsP1 */
  def isPlayCardsP1(): Boolean = false

  /** Indica si el estado actual es PlayCardsP2 */
  def isPlayCardsP2(): Boolean = false

  /** Indica si el estado actual es FinishRound */
  def isFinishRound(): Boolean = false

  /** Indica si el estado actual es NextRound */
  def isNextRound(): Boolean = false

  /** Indica si el estado actual es FinishGame */
  def isFinishGame(): Boolean = false
}
