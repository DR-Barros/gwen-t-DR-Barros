package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.{Section, BoardSection}

import cl.uchile.dcc.gwent.cards.{SiegeCard, UnitCard}

class MoralEffectTest extends munit.FunSuite {
  var boardSection: Section = _
  var moral: MoralEffect = _

  override def beforeEach(context: BeforeEach): Unit = {
    boardSection = new BoardSection()
    moral = new MoralEffect()
  }

  test("Un efecto de Moral se llama: Refuerzo moral") {
    assertEquals(moral.getName(), "Refuerzo moral")
  }
  test("Al hacer apply se añade uno de fuerza a todas las cartas que estaran en la misma fila"){
    val card: SiegeCard = new SiegeCard("nombre", 14, new NullEffect)
    val card2: SiegeCard = new SiegeCard("nombre", 14, new NullEffect)
    boardSection.assignZoneS(card)
    moral.apply(boardSection, card2)
    assertEquals(card.getStrength(), 15)
  }
}
