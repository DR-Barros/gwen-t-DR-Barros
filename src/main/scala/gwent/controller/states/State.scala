package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

trait State {
  def setController(controller: GameController): Unit
  protected def changeState(state: State): Unit
  def handle(): Unit
  def start(): Unit
  def roundInit(): Unit
  def player1Turn(): Unit
  def player2Turn(): Unit
  def playCardP1(): Unit
  def playCardP2(): Unit
  def playCardsP1(): Unit
  def playCardsP2(): Unit
  def finishRound(): Unit
  def nextRound(): Unit
  def finishGame(): Unit
  def isStart(): Boolean
  def isRoundInit(): Boolean
  def isPlayer1Turn(): Boolean
  def isPlayer2Turn(): Boolean
  def isPlayCardP1(): Boolean
  def isPlayCardP2(): Boolean
  def isPlayCardsP1(): Boolean
  def isPlayCardsP2(): Boolean
  def isFinishRound(): Boolean
  def isNextRound(): Boolean
  def isFinishGame(): Boolean
}
