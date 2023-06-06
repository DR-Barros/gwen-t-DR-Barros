package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.Controller

import cl.uchile.dcc.gwent.exception.StateError

abstract class AbstractState extends State {
  private var c: Option[Controller] = None
  def setController(controller: Controller): Unit = {
    c = Some(controller)
  }

  protected def changeState(state: State): Unit = {
    if(c.isDefined)
      c.get.setState(state)
  }

  private def error() = throw new StateError("Wrong State")

  def start(): Unit = error()

  def roundInit(): Unit = error()

  def player1Turn(): Unit = error()

  def player2Turn(): Unit = error()

  def playCardP1(): Unit = error()

  def playCardP2(): Unit = error()

  def player1FinalTurn(): Unit = error()

  def player2FinalTurn(): Unit = error()

  def playCardsP1(): Unit = error()

  def playCardsP2(): Unit = error()

  def finishRound(): Unit = error()

  def nextRound(): Unit = error()

  def finishGame(): Unit = error()

  def restartGame(): Unit = error()

  def isStart(): Boolean = false

  def isRoundInit(): Boolean = false

  def isPlayer1Turn(): Boolean = false

  def isPlayer2Turn(): Boolean = false

  def isPlayCardP1(): Boolean = false

  def isPlayCardP2(): Boolean = false

  def isPlayer1FinalTurn(): Boolean = false

  def isPlayer2FinalTurn(): Boolean = false

  def isPlayCardsP1(): Boolean = false

  def isPlayCardsP2(): Boolean = false

  def isFinishRound(): Boolean = false

  def isNextRound(): Boolean = false

  def isFinishGame(): Boolean = false

  def isRestartGame(): Boolean = false
}
