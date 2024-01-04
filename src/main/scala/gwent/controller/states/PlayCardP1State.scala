package cl.uchile.dcc
package gwent.controller.states

import scala.io.StdIn

/** Estado que representa que el jugador 1 juega UNA carta
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class PlayCardP1State extends AbstractState {
  /** acción que realiza el juego */
  def handle(): Unit = {
    c.get.view.showHand(c.get.p1.get.getHand())
    var input: Int = c.get.view.selectCard(c.get.p1.get.handSize())
    c.get.board.get.playCardSec1(c.get.p1.get, input)
    player2Turn()
  }
  /** cambia el estado actual a player2Turn */
  override def player2Turn(): Unit = changeState(new Player2TurnState())
  /** Indica que el estado actual es PlayCardP1 */
  override def isPlayCardP1(): Boolean = true
}
