package cl.uchile.dcc
package gwent.controller.states

class StartState extends AbstractState {
  def handle(): Unit = {}

  override def roundInit(): Unit = changeState(new RoundInit())
  override def isStart(): Boolean = true
}
