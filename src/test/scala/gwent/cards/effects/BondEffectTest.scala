package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.{BoardSection, Section}

import cl.uchile.dcc.gwent.cards.{SiegeCard, UnitCard}

class BondEffectTest extends munit.FunSuite {
  var boardSection: Section = _
  var bond: BondEffect = _

  override def beforeEach(context: BeforeEach): Unit = {
    boardSection = new BoardSection()
    bond = new BondEffect()
  }

  test("Un efecto de vinculo se llama: Vínculo estrecho") {
    assertEquals(bond.getName(), "Vínculo estrecho")
  }
  test("Al hacer apply se añade uno de fuerza a las cartas que tienen el mismo nombre") {
    val card: SiegeCard = new SiegeCard("nombre", 14, new NullEffect)
    val card2: SiegeCard = new SiegeCard("nombre", 14, new NullEffect)
    boardSection.assignZoneS(card)
    bond.apply(boardSection, card2)
    assertEquals(card.getStrength(), 15)
  }
}
