package cl.uchile.dcc
package gwent.controller.states

class Player2TurnState extends AbstractState {
  def handle(): Unit = {}

  override def playCardP2(): Unit = changeState(new PlayCardP2State())

  override def player1FinalTurn(): Unit = changeState(new Player1FinalTurnState())

  override def isPlayer2Turn(): Boolean = true
}

