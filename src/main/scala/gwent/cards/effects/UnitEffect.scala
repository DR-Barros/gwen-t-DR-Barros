package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.BoardSection

import cl.uchile.dcc.gwent.cards.Card

trait UnitEffect extends Effect {
  def apply(boardSection: BoardSection, card: Card): Unit 
}
