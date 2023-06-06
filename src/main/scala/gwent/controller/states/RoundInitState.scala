package cl.uchile.dcc
package gwent.controller.states

class RoundInitState extends AbstractState {
  def handle(): Unit = {}

  override def player1Turn(): Unit = changeState(new Player1TurnState())

  override def player2Turn(): Unit = changeState(new Player2TurnState())

  override def isRoundInit(): Boolean = true
}
