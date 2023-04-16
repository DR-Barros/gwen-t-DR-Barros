package cl.uchile.dcc
package gwent.Cards

trait Card {
  def getName(): String

  def getCardType(): String
}
