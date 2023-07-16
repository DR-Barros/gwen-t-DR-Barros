package cl.uchile.dcc
package gwent.factories
import gwent.cards.Card

trait CardFactory {
  def create(): Card
}
