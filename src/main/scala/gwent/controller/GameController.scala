package cl.uchile.dcc
package gwent.controller

import gwent.players.Player

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.controller.states.State


class GameController extends Controller{
  private var p1: Player = _
  private var p2: Player = _
  private var board: Board = _
  private var state: State = startState()
  state.setController(this)

  def setState(aState: State): Unit = {
    state = aState
    state.setController(this)
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

  def restartGame(): Unit = state.restartGame()

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

  def isRestartGame(): Boolean = state.isRestartGame()
}
