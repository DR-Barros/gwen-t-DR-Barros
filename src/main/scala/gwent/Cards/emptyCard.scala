package cl.uchile.dcc
package gwent.Cards

import gwent.Cards.Card

class emptyCard extends Card {
  def getName(): String = {
    return "empty"
  }

  def getCardType(): String = {
    return "empty"
  }
}
