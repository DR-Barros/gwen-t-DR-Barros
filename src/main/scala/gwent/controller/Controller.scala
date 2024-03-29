package cl.uchile.dcc
package gwent.controller

import gwent.controller.states.State

import cl.uchile.dcc.gwent.observer.ISubject

trait Controller {
  def setState(aState: State): Unit
  def getIsFinish(): Boolean
  def resetGame(): Unit
  def loose(o: ISubject): Unit
  def handleState(): Unit
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
