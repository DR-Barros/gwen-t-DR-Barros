package cl.uchile.dcc
package gwent.controller.states

class FinishGameState extends AbstractState {
  def handle(): Unit = {}
  override def start(): Unit = changeState(new StartState())
  override def isFinishGame(): Boolean = true
}
