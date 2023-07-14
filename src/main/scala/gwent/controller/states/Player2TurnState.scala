package cl.uchile.dcc
package gwent.controller.states

class Player2TurnState extends AbstractState {
  def handle(): Unit = {}

  override def playCardP2(): Unit = changeState(new PlayCardP2State())

  override def playCardsP1(): Unit = changeState(new PlayCardsP1State())

  override def isPlayer2Turn(): Boolean = true
}

