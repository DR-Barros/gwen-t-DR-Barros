package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.BoardSection
import gwent.cards.Card

class NullEffect extends UnitEffect {
  def getName(): String = ""
  def apply(boardSection: BoardSection, card: Card): Unit = {}
}
