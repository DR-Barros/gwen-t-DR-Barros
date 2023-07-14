package cl.uchile.dcc
package gwent.controller.states

import scala.io.StdIn

class Player1TurnState extends AbstractState {
  def handle(): Unit = {
    val n: Int = c.get.p1.get.handSize()
    if (n == 0){
      playCardsP2()
    } else {
      println("Quieres jugar una carta o pasar (escribe 'jugar' o 'pasar'):")
      var input: String = StdIn.readLine().toLowerCase()
      val p = Array("jugar", "pasar")
      while (!p.contains(input)) {
        println(input)
        println("escribe 'jugar' o 'pasar' para elegir acción:")
        input = StdIn.readLine().toLowerCase()
      }
      if (input == "jugar") {
        playCardP1()
      } else {
        playCardsP2()
      }
    }
  }
  override def playCardP1(): Unit = changeState(new PlayCardP1State())

  override def playCardsP2(): Unit = changeState(new PlayCardsP2State())
  override def isPlayer1Turn(): Boolean = true
}