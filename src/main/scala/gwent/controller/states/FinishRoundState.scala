package cl.uchile.dcc
package gwent.controller.states

/** Estado que representa el final de una ronda
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class FinishRoundState extends AbstractState {
  /** acción que realiza el juego */
  def handle(): Unit = {
    val S1 = c.get.board.get.getSec1Strength()
    val S2 = c.get.board.get.getSec2Strength()
    if (S1 == S2){
      c.get.view.draw()
      c.get.p1.get.loseGems()
      c.get.p2.get.loseGems()
    } else if (S1 > S2){
      c.get.view.winP1()
      c.get.p2.get.loseGems()
    } else {
      c.get.view.winP2()
      c.get.p1.get.loseGems()
    }
    if (c.get.getIsFinish()){
      finishGame()
    } else {
      nextRound()
    }
  }
  /** cambia el estado a NextRound */
  override def nextRound(): Unit = changeState(new NextRoundState())
  /** cambia el estado a FinishGame */
  override def finishGame(): Unit = changeState(new FinishGameState())
  /** Indica que el estado actual es FinishRound */
  override def isFinishRound(): Boolean = true
}
