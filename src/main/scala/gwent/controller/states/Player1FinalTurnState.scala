package cl.uchile.dcc
package gwent.controller.states

class Player1FinalTurnState extends AbstractState {
  def handle(): Unit = {}

  override def playCardsP1(): Unit = changeState(new PlayCardP1State())

  override def finishRound(): Unit = changeState(new FinishRoundState())
  override def isPlayer1FinalTurn(): Boolean = true
}
