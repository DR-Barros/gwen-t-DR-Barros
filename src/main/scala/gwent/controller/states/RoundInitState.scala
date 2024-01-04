package cl.uchile.dcc
package gwent.controller.states
import scala.util.Random

/** Estado que representa el inicio de ronda
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class RoundInitState extends AbstractState {
  /** acción que realiza el juego */
  def handle(): Unit = {
    var n: Int = Random.nextInt(2)
    if (n == 0){
      player1Turn()
    } else {
      player2Turn()
    }
  }
  /** cambia el estado a Player1Turn */
  override def player1Turn(): Unit = changeState(new Player1TurnState())
  /** cambia el estado a Player2Turn */
  override def player2Turn(): Unit = changeState(new Player2TurnState())
  /** Indica que el estado actual es RoundInit */
  override def isRoundInit(): Boolean = true
}
