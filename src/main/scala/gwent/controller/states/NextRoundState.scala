package cl.uchile.dcc
package gwent.controller.states

/** Estado que representa la proxima ronda
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class NextRoundState extends AbstractState {
  /** acción que realiza el juego */
  def handle(): Unit = {
    c.get.board.get.clean()
    for(i <- 0 to 3){
      c.get.p1.get.stealCard()
      c.get.p2.get.stealCard()
    }
    roundInit()
  }
  /** cambia el estado a RoundInit */
  override def roundInit(): Unit = changeState(new RoundInitState())
  /** Indica que el estado actual es NextRound */
  override def isNextRound(): Boolean = true
}
