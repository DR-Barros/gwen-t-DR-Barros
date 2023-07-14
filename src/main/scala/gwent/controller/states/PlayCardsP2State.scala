package cl.uchile.dcc
package gwent.controller.states

class PlayCardsP2State extends AbstractState {
  def handle(): Unit = {}

  override def finishRound(): Unit = changeState(new FinishRoundState())
  override def playCardsP2(): Unit = changeState(new PlayCardsP2State())
  override def isPlayCardsP2(): Boolean = true
}
