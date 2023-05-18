package cl.uchile.dcc
package gwent.Board
import gwent.Cards.Card
import gwent.Cards.CorpCard

class BoardTest {

}

class BoardSectionTest extends munit.FunSuite{
  var Sec1: BoardSection = _

  override def beforeEach(context: BeforeEach): Unit = {
    Sec1 = new BoardSection()
  }
  test("Las secciones del tablero comienzan vacias"){
    assertEquals(Sec1.showZoneC().toSeq, new Array[Card](25).toSeq)
    assertEquals(Sec1.showZoneS().toSeq, new Array[Card](25).toSeq)
    assertEquals(Sec1.showZoneD().toSeq, new Array[Card](25).toSeq)
  }
  test("Las cartas pueden ser asignadas a alguna zona de la seccion"){
    val card: Card = new CorpCard("nombre", 14)
    Sec1.assignZoneC(card)
    assert(card.equals(Sec1.showZoneC()(0)))
    Sec1.assignZoneD(card)
    assert(card.equals(Sec1.showZoneD()(0)))
    Sec1.assignZoneS(card)
    assert(card.equals(Sec1.showZoneS()(0)))
  }
}
