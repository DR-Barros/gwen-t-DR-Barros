package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.Section
import gwent.cards.UnitCard

/** Efecto de vinculo estrecho */
class BondEffect extends UnitEffect {
  /** entrega el nombre del efecto */
  def getName(): String = "Vínculo estrecho"

  /** aplica el efecto en la sección correspondiente */
  override def apply(boardSection: Section, card: UnitCard): Unit = {
    card.bond(boardSection)
  }
}
