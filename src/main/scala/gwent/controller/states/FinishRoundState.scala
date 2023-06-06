package cl.uchile.dcc
package gwent.controller.states

class FinishRoundState extends AbstractState {
  def handle(): Unit = {}

  override def nextRound(): Unit = changeState(new FinishGameState())
  override def finishGame(): Unit = changeState(new FinishGameState())
  override def isFinishRound(): Boolean = true
}
