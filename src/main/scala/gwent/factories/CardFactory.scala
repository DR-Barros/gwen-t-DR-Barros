package cl.uchile.dcc
package gwent.factories
import gwent.cards.Card
import cl.uchile.dcc.gwent.cards.effects.Effect

trait CardFactory {
  def create(): Card
  protected def effect(n: Int): Effect
}
