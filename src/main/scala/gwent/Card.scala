package cl.uchile.dcc
package gwent

trait Card {
  def getName(): String

  def getCardType(): String
}
