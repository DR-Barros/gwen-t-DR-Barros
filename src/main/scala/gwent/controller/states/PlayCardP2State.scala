package cl.uchile.dcc
package gwent.controller.states

class PlayCardP2State extends AbstractState {
  def handle(): Unit = {}

  override def player1Turn(): Unit = changeState(new Player1TurnState())

  override def isPlayCardP2(): Boolean = true
}
