package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.Section
import gwent.cards.{Card, UnitCard}

class NullEffect extends UnitEffect {
  def getName(): String = ""
  def apply(boardSection: Section, card: UnitCard): Unit = {}
}
