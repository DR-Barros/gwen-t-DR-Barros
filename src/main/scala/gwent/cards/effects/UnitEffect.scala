package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.Section

import gwent.cards.UnitCard

trait UnitEffect extends Effect {
  def apply(boardSection: Section, card: UnitCard): Unit 
}
