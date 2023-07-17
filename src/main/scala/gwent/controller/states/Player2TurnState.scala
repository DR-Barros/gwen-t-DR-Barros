package cl.uchile.dcc
package gwent.controller.states

/** Estado que representa el turno del jugador 2
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.1
 */
class Player2TurnState extends AbstractState {
  /** acción que realiza el juego */
  def handle(): Unit = {
    val S1 = c.get.board.get.getSec1Strength()
    val S2 = c.get.board.get.getSec2Strength() + c.get.p2.get.handStrength()
    if ((S2 >= S1 && c.get.p2.get.handHasUnitCard() >= 0) || (S2<= S1 && c.get.p2.get.handHasWeatherCard() >= 0)){
      c.get.view.cpuPlay()
      playCardP2()
    } else {
      c.get.view.cpuPass()
      playCardsP1()
    }
  }
  /** cambia el estado a PlayCardP2 */
  override def playCardP2(): Unit = changeState(new PlayCardP2State())
  /** cambia el estado a PlayCardsP1 */
  override def playCardsP1(): Unit = changeState(new PlayCardsP1State())
  /** Indica que el estado actual es Player2Turn */
  override def isPlayer2Turn(): Boolean = true
}

