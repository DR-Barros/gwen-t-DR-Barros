package cl.uchile.dcc
package gwent.Cards

import gwent.Cards.Card

import scala.collection.mutable.ListBuffer

class CardsHand {
  private var cards: ListBuffer [Card] = ListBuffer [Card]()

  def handSize(): Int = {
    return cards.size
  }

  def addCards(card: Card): Unit = {
    if (card.getCardType() != "Empty" && handSize() < 10){
      cards += card
    }
  }
  def playCard(n: Int): Card = {
    val card = cards(n)
    cards -= card
    return card
  }
}
