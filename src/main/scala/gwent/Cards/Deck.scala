package cl.uchile.dcc
package gwent.Cards

import gwent.Cards.Card

import scala.collection.mutable.ListBuffer

class Deck (private var cards: ListBuffer [Card]){
  def deckSize(): Int = {
    return cards.size
  }
  def stealCard(): Card = {
    val n = deckSize()
    if (n > 0){
        val r = new scala.util.Random
        val random = r.nextInt(n)
        val cardReturn = cards(random)
        cards -= cardReturn
        return cardReturn
    } else {
      return new emptyCard
    }
    
  }
}
