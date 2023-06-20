package cl.uchile.dcc
package gwent.controller.states

class PlayCardsP2State extends AbstractState {
  def handle(): Unit = {}

  override def player1FinalTurn(): Unit = changeState(new Player1FinalTurnState)
  override def playCardsP2(): Unit = changeState(new PlayCardsP2State())
  override def isPlayCardsP2(): Boolean = true
}
