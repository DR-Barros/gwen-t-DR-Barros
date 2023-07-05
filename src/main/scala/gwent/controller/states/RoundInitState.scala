package cl.uchile.dcc
package gwent.controller.states

import scala.util.Random

class RoundInitState extends AbstractState {
  def handle(): Unit = {
    var n: Int = Random.nextInt(2)
    if (n == 0){
      player1Turn()
    } else {
      player2Turn()
    }
  }

  override def player1Turn(): Unit = changeState(new Player1TurnState())

  override def player2Turn(): Unit = changeState(new Player2TurnState())

  override def isRoundInit(): Boolean = true
}
