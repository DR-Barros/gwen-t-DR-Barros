package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.Section
import gwent.cards.UnitCard

/** Efecto nulo */
class NullEffect extends UnitEffect {
  /** No tiene nombre */
  def getName(): String = "Sin efecto"
  /** No hace nada */
  def apply(boardSection: Section, card: UnitCard): Unit = {}
}
