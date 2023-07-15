package cl.uchile.dcc
package gwent.controller.states

import scala.io.StdIn

/** Estado que representa el fin del juego 
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class FinishGameState extends AbstractState {
  /** acción que realiza el juego */
  def handle(): Unit = {
    println("Quieres jugar una nueva partida: (si/no)")
    var input: String = StdIn.readLine().toLowerCase()
    if (input == "si"){
      start()
    }
  }
  /** cambia el estado a Start */
  override def start(): Unit = changeState(new StartState())
  /** Indica que el estado actual es FinishGame */
  override def isFinishGame(): Boolean = true
}
