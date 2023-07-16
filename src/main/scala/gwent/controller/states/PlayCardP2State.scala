package cl.uchile.dcc
package gwent.controller.states

/** Estado que representa que el jugador 2 juega UNA carta
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class PlayCardP2State extends AbstractState {
  /** acción que realiza el juego */
  def handle(): Unit = {
    val S1 = c.get.board.get.getSec1Strength()
    val S2 = c.get.board.get.getSec2Strength() + c.get.p2.get.handStrength()
    if(S2 >= S1){
      var n: Int = c.get.p2.get.handHasUnitCard()
      c.get.board.get.playCardSec2(c.get.p2.get, n)
    } else {
      var n: Int = c.get.p2.get.handHasWeatherCard()
      c.get.board.get.playCardSec2(c.get.p2.get, n)
    }
  }
  /** cambia el estado a Player1Turn */
  override def player1Turn(): Unit = changeState(new Player1TurnState())
  /** Indica que el estado actual es PlayCardP2 */
  override def isPlayCardP2(): Boolean = true
}
