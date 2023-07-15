package cl.uchile.dcc
package gwent.controller.states

/** Estado que representa que el jugador 1 juega cartas
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class PlayCardsP1State extends AbstractState {
  /** acción que realiza el juego */
  def handle(): Unit = {
    
  }
  /** cambia el estado a FinishRound */
  override def finishRound(): Unit = changeState(new FinishRoundState())
  /** cambia el estado a FinishRound */
  override def isPlayCardsP1(): Boolean = true
}