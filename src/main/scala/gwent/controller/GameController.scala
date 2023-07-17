package cl.uchile.dcc
package gwent.controller

import gwent.players.{Player, UserPlayer}

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.controller.states.*
import cl.uchile.dcc.gwent.observer.{ISubject, Observer}
import cl.uchile.dcc.gwent.view.View

import scala.collection.mutable.ArrayBuffer

/** Clase game controller
 *
 * Se encarga de manejar el flujo de la partida
 *
 * @constructor crea las variables donde se guardaran los jugadores, tablero e inicializa los estados
 * 
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.2
 */
class GameController extends Controller{
  /** Vista del juego
   * 
   * maneja la interfaz "visual" del juego y los inputs
   */
  val view = new View
  /** El jugador 1
   *
   * esta variable guarda una instancia de UserPlayer que representa al jugador 1
   */
  var p1: Option[Player] = None
  /** El jugador 2
   *
   * esta variable guarda una instancia de UserPlayer que representa al jugador 2
   */
  var p2: Option[Player] = None
  /** Tablero del juego
   * 
   * esta variable guarda una instancia de Board que representa el tablero del juego
   */
  var board: Option[Board] = None
  var observers: ArrayBuffer[Observer] = new ArrayBuffer[Observer]
  /** Indica si la partida termino */
  private var isFinish: Boolean = false
  /** Estado del juego
   * 
   * esta variable guarda el estado actual en que se encuentra la partida
   */
  private var state: State = new StartState()
  state.setController(this)

  /** Actualiza el estado en el que se encuentra
   *
   * @param aState
   */
  def setState(aState: State): Unit = {
    state = aState
    state.setController(this)
  }

  /** devuelve si el juego termino */
  def getIsFinish(): Boolean = return isFinish

  /** establece que el juego no termino */
  def resetGame(): Unit = isFinish = false

  /**Inidca el jugador que perdio la partida
   * 
   * @param o el jugador que perdio la partida
   */
  def loose(o: ISubject): Unit = {
    var n = o.asInstanceOf[UserPlayer].getName()
    isFinish = true
    println(s"$n perdio")
  }

  /** Llama al handle del estado en que se encuentra*/
  def handleState(): Unit = state.handle()

  /** indica al estado que debe cambiar a start */
  def start(): Unit = state.start()

  /** indica al estado que debe cambiar a roundInit */
  def roundInit(): Unit = state.roundInit()

  /** indica al estado que debe cambiar a player1Turn */
  def player1Turn(): Unit = state.player1Turn()

  /** indica al estado que debe cambiar a player2Turn */
  def player2Turn(): Unit = state.player2Turn()

  /** indica al estado que debe cambiar a playCardP1 */
  def playCardP1(): Unit = state.playCardP1()

  /** indica al estado que debe cambiar a playCardP2 */
  def playCardP2(): Unit = state.playCardP2()

  /** indica al estado que debe cambiar a playCardsP1 */
  def playCardsP1(): Unit = state.playCardsP1()

  /** indica al estado que debe cambiar a playCardsP2 */
  def playCardsP2(): Unit = state.playCardsP2()

  /** indica al estado que debe cambiar a finishRound */
  def finishRound(): Unit = state.finishRound()

  /** indica al estado que debe cambiar a nextRound */
  def nextRound(): Unit = state.nextRound()

  /** indica al estado que debe cambiar a finishGame */
  def finishGame(): Unit = state.finishGame()

  /** indica si el estado actual es Start */
  def isStart(): Boolean = state.isStart()

  /** indica si el estado actual es RoundInit */
  def isRoundInit(): Boolean = state.isRoundInit()

  /** indica si el estado actual es Player1Turn */
  def isPlayer1Turn(): Boolean = state.isPlayer1Turn()

  /** indica si el estado actual es Player2Turn */
  def isPlayer2Turn(): Boolean = state.isPlayer2Turn()

  /** indica si el estado actual es PlayCardP1 */
  def isPlayCardP1(): Boolean = state.isPlayCardP1()

  /** indica si el estado actual es PlayCardP2 */
  def isPlayCardP2(): Boolean = state.isPlayCardP2()

  /** indica si el estado actual es PlayCardsP1 */
  def isPlayCardsP1(): Boolean = state.isPlayCardsP1()

  /** indica si el estado actual es PlayCardsP2 */
  def isPlayCardsP2(): Boolean = state.isPlayCardsP2()

  /** indica si el estado actual es FinishRound */
  def isFinishRound(): Boolean = state.isFinishRound()

  /** indica si el estado actual es NextRound */
  def isNextRound(): Boolean = state.isNextRound()

  /** indica si el estado actual es FinishGame */
  def isFinishGame(): Boolean = state.isFinishGame()
}
