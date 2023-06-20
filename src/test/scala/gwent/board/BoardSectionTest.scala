package cl.uchile.dcc
package gwent.board

import gwent.cards.{Card, CorpCard}
import gwent.cards.effects.NullEffect

class BoardSectionTest extends munit.FunSuite{
  var Sec1: BoardSection = _

  override def beforeEach(context: BeforeEach): Unit = {
    Sec1 = new BoardSection()
  }
  test("Las secciones del tablero comienzan vacias"){
    assertEquals(Sec1.getZoneC().toSeq, new Array[Card](6).toSeq)
    assertEquals(Sec1.getZoneS().toSeq, new Array[Card](6).toSeq)
    assertEquals(Sec1.getZoneD().toSeq, new Array[Card](6).toSeq)
  }
  test("Las cartas pueden ser asignadas a alguna zona de la seccion"){
    val card: Card = new CorpCard("nombre", 14, new NullEffect)
    Sec1.assignZoneC(card)
    assert(card.equals(Sec1.getZoneC()(0)))
    Sec1.assignZoneD(card)
    assert(card.equals(Sec1.getZoneD()(0)))
    Sec1.assignZoneS(card)
    assert(card.equals(Sec1.getZoneS()(0)))
  }
}
