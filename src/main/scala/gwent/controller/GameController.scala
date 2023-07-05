package cl.uchile.dcc
package gwent.controller

import gwent.players.{Player, UserPlayer}

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.controller.states.*
import cl.uchile.dcc.gwent.observer.ISubject

/** Clase game controller
 *
 * Se encarga de manejar el flujo de la partida
 *
 * @constructor crea las variables donde se guardaran los jugadores, tablero e inicializa los estados
 * 
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.1
 */
class GameController extends Controller{
  var p1: Option[Player] = None
  var p2: Option[Player] = None
  var board: Option[Board] = None
  var isFinish: Boolean = false
  private var state: State = new StartState()
  state.setController(this)

  def setState(aState: State): Unit = {
    state = aState
    state.setController(this)
  }

  def loose(o: ISubject): Unit = {
    var n = o.asInstanceOf[UserPlayer].getName()
    isFinish = true
    println(s"$n perdio")
  }

  def handleState(): Unit = state.handle()

  def start(): Unit = state.start()

  def roundInit(): Unit = state.roundInit()

  def player1Turn(): Unit = state.player1Turn()

  def player2Turn(): Unit = state.player2Turn()

  def playCardP1(): Unit = state.playCardP1()

  def playCardP2(): Unit = state.playCardP2()

  def player1FinalTurn(): Unit = state.player1FinalTurn()

  def player2FinalTurn(): Unit = state.player2FinalTurn()

  def playCardsP1(): Unit = state.playCardsP1()

  def playCardsP2(): Unit = state.playCardsP2()

  def finishRound(): Unit = state.finishRound()

  def nextRound(): Unit = state.nextRound()

  def finishGame(): Unit = state.finishGame()

  def isStart(): Boolean = state.isStart()

  def isRoundInit(): Boolean = state.isRoundInit()

  def isPlayer1Turn(): Boolean = state.isPlayer1Turn()

  def isPlayer2Turn(): Boolean = state.isPlayer2Turn()

  def isPlayCardP1(): Boolean = state.isPlayCardP1()

  def isPlayCardP2(): Boolean = state.isPlayCardP2()

  def isPlayer1FinalTurn(): Boolean = state.isPlayer1FinalTurn()

  def isPlayer2FinalTurn(): Boolean = state.isPlayer2FinalTurn()

  def isPlayCardsP1(): Boolean = state.isPlayCardsP1()

  def isPlayCardsP2(): Boolean = state.isPlayCardsP2()

  def isFinishRound(): Boolean = state.isFinishRound()

  def isNextRound(): Boolean = state.isNextRound()

  def isFinishGame(): Boolean = state.isFinishGame()
}
