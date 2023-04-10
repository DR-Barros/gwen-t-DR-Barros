package cl.uchile.dcc
package gwent
import gwent.Player
import gwent.Card
import scala.collection.mutable.ListBuffer

class UserPlayer (private  val name: String, private val zone: Int) extends Player {
  private var gems: Int = 2;
  private var cardHand = ListBuffer[Card]()

  def getName(): String = {
    return name
  }

  def getZone(): Int = {
    return zone
  }

  def getGems(): Int = {
    return gems
  }

  def loseGems(): Unit = {
    if (gems >0){
      gems -= 1
    }
  }
  def handSize(): Int = {
    return cardHand.size
  }
  def stealCard(deck: Deck): Unit = {
    if (handSize() < 10){
      val card = deck.stealCard()
      if (card.getName() != "empty") {
        cardHand += card
      }
    }
  }
  def playCard(n: Int): Card = {
    var hS = handSize()
    if (hS > 0 && n < hS){
      var rCard: Card = cardHand(n)
      cardHand -= rCard
      return rCard
    } else if (hS > 0){
      var rCard: Card = cardHand(hS -1)
      cardHand -= rCard
      return rCard
    } else {
      return  new emptyCard
    }
  }
}
