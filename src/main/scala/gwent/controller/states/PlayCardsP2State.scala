package cl.uchile.dcc
package gwent.controller.states

/** Estado que representa que el jugador 2 juega cartas
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class PlayCardsP2State extends AbstractState {
  /** acción que realiza el juego */
  def handle(): Unit = {}
  /** cambia el estado a PlayCardsP2 */
  override def playCardsP2(): Unit = changeState(new PlayCardsP2State())
  /** cambia el estado a FinishRound */
  override def finishRound(): Unit = changeState(new FinishRoundState())
  /** cambia el estado a FinishRound */
  override def isPlayCardsP2(): Boolean = true
}
