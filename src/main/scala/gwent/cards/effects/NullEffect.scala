package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.Section
import gwent.cards.{Card, UnitCard}

/** Efecto nulo */
class NullEffect extends UnitEffect {
  /** No tiene nombre */
  def getName(): String = ""
  /** No hace nada */
  def apply(boardSection: Section, card: UnitCard): Unit = {}
}
