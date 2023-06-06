package cl.uchile.dcc
package gwent.controller.states

class NextRoundState extends AbstractState {
  def handle(): Unit = {}

  override def roundInit(): Unit = changeState(new RoundInitState())
  override def isNextRound(): Boolean = true
}
