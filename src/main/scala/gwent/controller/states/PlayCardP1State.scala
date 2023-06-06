package cl.uchile.dcc
package gwent.controller.states

class PlayCardP1State extends AbstractState {
  def handle(): Unit = {}

  override def player2Turn(): Unit = changeState(new Player2TurnState())

  override def isPlayCardP1(): Boolean = true
}
