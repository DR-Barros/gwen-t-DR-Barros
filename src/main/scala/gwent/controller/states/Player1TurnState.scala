package cl.uchile.dcc
package gwent.controller.states
import scala.io.StdIn

/** Estado que representa el turno del jugador 1 
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class Player1TurnState extends AbstractState {
  /** acción que realiza el juego */
  def handle(): Unit = {
    val b = c.get.board.get
    c.get.view.showBoard(b.getSecW(), b.getSec1C(), b.getSec1S(), b.getSec1D(), b.getSec2C(), b.getSec2S(), b.getSec2D())
    val n: Int = c.get.p1.get.handSize()
    if (n == 0){
      playCardsP2()
    } else {
      val input = c.get.view.playerTurn()
      if (input == "jugar") {
        playCardP1()
      } else {
        playCardsP2()
      }
    }
  }
  /** cambia el estado a PlayCardP1 */
  override def playCardP1(): Unit = changeState(new PlayCardP1State())
  /** cambia el estado a PlayCardsP2 */
  override def playCardsP2(): Unit = changeState(new PlayCardsP2State())
  /** Indica que el estado actual es Player1Turn */
  override def isPlayer1Turn(): Boolean = true
}