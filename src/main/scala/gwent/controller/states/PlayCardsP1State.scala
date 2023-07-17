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
      var input: String = c.get.view.playerTurn()
      if (input == "jugar"){
        var inputCard: Int = c.get.view.selectCard(c.get.p1.get.handSize())
        c.get.p1.get.playCard(inputCard)
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