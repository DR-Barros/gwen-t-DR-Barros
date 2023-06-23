package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.Section
import gwent.cards.UnitCard

class BondEffect extends UnitEffect {
  def getName(): String = "Vínculo estrecho"

  override def apply(boardSection: Section, card: UnitCard): Unit = {
    card.bond(boardSection)
  }
}
