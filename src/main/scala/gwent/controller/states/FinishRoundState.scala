package cl.uchile.dcc
package gwent.controller.states

/** Estado que representa el final de una ronda
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class FinishRoundState extends AbstractState {
  /** acción que realiza el juego */
  def handle(): Unit = {}
  /** cambia el estado a NextRound */
  override def nextRound(): Unit = changeState(new NextRoundState())
  /** cambia el estado a FinishGame */
  override def finishGame(): Unit = changeState(new FinishGameState())
  /** Indica que el estado actual es FinishRound */
  override def isFinishRound(): Boolean = true
}
