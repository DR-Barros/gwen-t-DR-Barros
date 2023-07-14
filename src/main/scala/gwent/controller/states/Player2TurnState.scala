package cl.uchile.dcc
package gwent.controller.states

/** Estado que representa el turno del jugador 2
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class Player2TurnState extends AbstractState {
  /** acción que realiza el juego */
  def handle(): Unit = {}
  /** cambia el estado a PlayCardP2 */
  override def playCardP2(): Unit = changeState(new PlayCardP2State())
  /** cambia el estado a PlayCardsP1 */
  override def playCardsP1(): Unit = changeState(new PlayCardsP1State())
  /** Indica que el estado actual es Player2Turn */
  override def isPlayer2Turn(): Boolean = true
}

