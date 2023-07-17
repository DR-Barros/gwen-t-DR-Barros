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
  def handle(): Unit = {
    val S1 = c.get.board.get.getSec1Strength()
    val S2 = c.get.board.get.getSec2Strength() + c.get.p2.get.handStrength()
    if (S2 >= S1) {
      var n: Int = c.get.p2.get.handHasUnitCard()
      if (n >=0){
        c.get.view.cpuPlay()
        c.get.board.get.playCardSec2(c.get.p2.get, n+1)
      } else {
        c.get.view.cpuPass()
        finishRound()
      }
    } else {
      var n: Int = c.get.p2.get.handHasWeatherCard()
      if (n>=0){
        c.get.view.cpuPlay()
        c.get.board.get.playCardSec2(c.get.p2.get, n+1)
      } else {
        c.get.view.cpuPass()
        finishRound()
      }
    }
  }
  /** cambia el estado a FinishRound */
  override def finishRound(): Unit = changeState(new FinishRoundState())
  /** cambia el estado a FinishRound */
  override def isPlayCardsP2(): Boolean = true
}
