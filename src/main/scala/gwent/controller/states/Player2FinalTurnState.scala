package cl.uchile.dcc
package gwent.controller.states

class Player2FinalTurnState extends AbstractState {
  def handle(): Unit = {}

  override def playCardsP2(): Unit = changeState(new PlayCardP2State())

  override def finishRound(): Unit = changeState(new FinishRoundState())

  override def isPlayer2FinalTurn(): Boolean = true
}