package cl.uchile.dcc
package gwent.cards

import gwent.cards.effects.{ClearEffect, FogEffect, NullEffect}
import gwent.exception.DeckIsEmpty

class DeckTest extends munit.FunSuite{
  var U1: CorpCard = _
  var U2: DistanceCard = _
  var W1: WeatherCard = _
  var W2: WeatherCard = _
  var D1: Deck = _
  var D2: Deck = _

  override def beforeEach(context: BeforeEach): Unit = {
    U1 = new CorpCard("soldado", 15, new NullEffect)
    U2 = new DistanceCard("arquera", 4, new NullEffect)
    W1 = new WeatherCard("Escarcha", new ClearEffect)
    W2 = new WeatherCard("Niebla", new FogEffect)
    D1 = new Deck(Array(U1, U2, W1))
    D2 = new Deck(Array())
  }

  test("Los mazos pueden tener 0 o mas cartas") {
    assertEquals(D1.deckSize(), 3)
    assertEquals(D2.deckSize(), 0)
  }
  test("Si un mazo tiene cartas se puede sacar una y el mazo queda con una carta menos") {
    assertEquals(D1.deckSize(), 3)
    var card = D1.stealCard()
    assert(card.isInstanceOf[Card])
    assertEquals(D1.deckSize(), 2)
    card = D1.stealCard()
    assert(card.isInstanceOf[Card])

  }
  test("Si un mazo no tiene cartas lanza la excepcion DeckIsEmpty") {
    intercept[DeckIsEmpty]{D2.stealCard()}
  }
}
