package cl.uchile.dcc
package gwent.controller.states

import scala.io.StdIn

/** Estado que representa que el jugador 1 juega cartas
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class PlayCardsP1State extends AbstractState {
  /** acción que realiza el juego */
  def handle(): Unit = {
    if (c.get.p1.get.handSize() > 0){
      println("Quieres jugar cartas? (si/no)")
      var input: String = StdIn.readLine()
      if (input == "si"){
        println("Elije que carta jugar")
        var input: Int = StdIn.readLine().toInt
        c.get.p1.get.playCard(input)
      } else {
        finishRound()
      }
    } else{
      finishRound()
    }
  }
  /** cambia el estado a FinishRound */
  override def finishRound(): Unit = changeState(new FinishRoundState())
  /** cambia el estado a FinishRound */
  override def isPlayCardsP1(): Boolean = true
}