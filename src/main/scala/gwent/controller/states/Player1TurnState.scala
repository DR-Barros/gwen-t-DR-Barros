package cl.uchile.dcc
package gwent.controller.states

class Player1TurnState extends AbstractState {
  def handle(): Unit = {}
  override def playCardP1(): Unit = changeState(new PlayCardP1State())
  override def player2FinalTurn(): Unit = changeState(new Player2FinalTurnState())
  override def isPlayer1Turn(): Boolean = true
}