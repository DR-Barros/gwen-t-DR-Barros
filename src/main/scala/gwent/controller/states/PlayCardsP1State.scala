package cl.uchile.dcc
package gwent.controller.states

class PlayCardsP1State extends AbstractState {
  def handle(): Unit = {}

  override def playCardsP1(): Unit = changeState(new PlayCardsP1State())
  override def player2FinalTurn(): Unit = changeState(new Player2FinalTurnState())
  override def isPlayCardsP1(): Boolean = true
}