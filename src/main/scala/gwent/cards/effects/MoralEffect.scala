package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.Section
import gwent.cards.UnitCard

/** Efecto de Refuerzo moral */
class MoralEffect extends UnitEffect {
  /** entrega el nombre del efecto */
  def getName(): String = "Refuerzo moral"

  /** aplica el efecto en la sección correspondiente */
  override def apply(boardSection: Section, card: UnitCard): Unit = {
    card.moral(boardSection)
  }
}
