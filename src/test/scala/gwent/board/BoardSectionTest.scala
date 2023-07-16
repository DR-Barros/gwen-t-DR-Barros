package cl.uchile.dcc
package gwent.board

import gwent.cards.{Card, CorpCard, DistanceCard, SiegeCard, UnitCard}
import gwent.cards.effects.NullEffect

import scala.collection.mutable.ArrayBuffer

class BoardSectionTest extends munit.FunSuite{
  var Sec1: BoardSection = _

  override def beforeEach(context: BeforeEach): Unit = {
    Sec1 = new BoardSection()
  }
  test("Las secciones del tablero comienzan vacias"){
    assertEquals(Sec1.getZoneC().toSeq, new ArrayBuffer[UnitCard].toSeq)
    assertEquals(Sec1.getZoneS().toSeq, new ArrayBuffer[UnitCard].toSeq)
    assertEquals(Sec1.getZoneD().toSeq, new ArrayBuffer[UnitCard].toSeq)
  }
  test("Las cartas pueden ser asignadas a alguna zona de la seccion"){
    val card: UnitCard = new CorpCard("nombre", 14, new NullEffect)
    Sec1.assignZoneC(card)
    assert(card.equals(Sec1.getZoneC()(0)))
    Sec1.assignZoneD(card)
    assert(card.equals(Sec1.getZoneD()(0)))
    Sec1.assignZoneS(card)
    assert(card.equals(Sec1.getZoneS()(0)))
  }
  test("las cartas al aplicarle vinculo a la fila C, si tienen el mismo nombre aumentan en uno su fuerza"){
    val card: UnitCard = new CorpCard("nombre", 14, new NullEffect)
    val card2: UnitCard = new CorpCard("nombre", 14, new NullEffect)
    val card3: UnitCard = new CorpCard("nombre3", 14, new NullEffect)
    Sec1.assignZoneC(card)
    Sec1.assignZoneC(card3)
    Sec1.bondC(card2)
    assertEquals(card.getStrength(), 15)
    assertEquals(card3.getStrength(), 14)
  }
  test("las cartas al aplicarle vinculo a la fila D, si tienen el mismo nombre aumentan en uno su fuerza") {
    val card: UnitCard = new DistanceCard("nombre", 14, new NullEffect)
    val card2: UnitCard = new DistanceCard("nombre", 14, new NullEffect)
    val card3: UnitCard = new DistanceCard("nombre3", 14, new NullEffect)
    Sec1.assignZoneD(card)
    Sec1.assignZoneD(card3)
    Sec1.bondD(card2)
    assertEquals(card.getStrength(), 15)
    assertEquals(card3.getStrength(), 14)
  }
  test("las cartas al aplicarle vinculo a la fila S, si tienen el mismo nombre aumentan en uno su fuerza") {
    val card: UnitCard = new SiegeCard("nombre", 14, new NullEffect)
    val card2: UnitCard = new SiegeCard("nombre", 14, new NullEffect)
    val card3: UnitCard = new SiegeCard("nombre3", 14, new NullEffect)
    Sec1.assignZoneS(card)
    Sec1.assignZoneS(card3)
    Sec1.bondS(card2)
    assertEquals(card.getStrength(), 15)
    assertEquals(card3.getStrength(), 14)
  }
  test("las cartas al aplicarle moral a la fila C aumentan en uno su fuerza") {
    val card: UnitCard = new CorpCard("nombre", 14, new NullEffect)
    val card2: UnitCard = new CorpCard("nombre2", 14, new NullEffect)
    Sec1.assignZoneC(card)
    Sec1.assignZoneC(card2)
    Sec1.moralC()
    assertEquals(card.getStrength(), 15)
    assertEquals(card2.getStrength(), 15)
  }
  test("las cartas al aplicarle moral a la fila D aumentan en uno su fuerza") {
    val card: UnitCard = new DistanceCard("nombre", 14, new NullEffect)
    val card2: UnitCard = new DistanceCard("nombre2", 14, new NullEffect)
    Sec1.assignZoneD(card)
    Sec1.assignZoneD(card2)
    Sec1.moralD()
    assertEquals(card.getStrength(), 15)
    assertEquals(card2.getStrength(), 15)
  }
  test("las cartas al aplicarle moral a la fila S aumentan en uno su fuerza") {
    val card: UnitCard = new SiegeCard("nombre", 14, new NullEffect)
    val card2: UnitCard = new SiegeCard("nombre2", 14, new NullEffect)
    Sec1.assignZoneS(card)
    Sec1.assignZoneS(card2)
    Sec1.moralS()
    assertEquals(card.getStrength(), 15)
    assertEquals(card2.getStrength(), 15)
  }
  test("Al aplicar frost todas las cartas cuerpo a cuerpo pasan a estado frost") {
    val card: UnitCard = new CorpCard("nombre", 14, new NullEffect)
    val card2: UnitCard = new DistanceCard("nombre", 14, new NullEffect)
    val card3: UnitCard = new SiegeCard("nombre", 14, new NullEffect)
    Sec1.assignZoneC(card)
    Sec1.assignZoneD(card2)
    Sec1.assignZoneS(card3)
    Sec1.frost()
    assert(card.isFrost())
    assert(!card2.isFrost())
    assert(!card3.isFrost())
  }
  test("Al aplicar fog todas las cartas de distancia pasan a estado fog"){
    val card: UnitCard = new CorpCard("nombre", 14, new NullEffect)
    val card2: UnitCard = new DistanceCard("nombre", 14, new NullEffect)
    val card3: UnitCard = new SiegeCard("nombre", 14, new NullEffect)
    Sec1.assignZoneC(card)
    Sec1.assignZoneD(card2)
    Sec1.assignZoneS(card3)
    Sec1.fog()
    assert(!card.isFog())
    assert(card2.isFog())
    assert(!card3.isFog())
  }
  test("Al aplicar rain todas las cartas de asedio pasan a estado rain") {
    val card: UnitCard = new CorpCard("nombre", 14, new NullEffect)
    val card2: UnitCard = new DistanceCard("nombre", 14, new NullEffect)
    val card3: UnitCard = new SiegeCard("nombre", 14, new NullEffect)
    Sec1.assignZoneC(card)
    Sec1.assignZoneD(card2)
    Sec1.assignZoneS(card3)
    Sec1.rain()
    assert(!card.isRain())
    assert(!card2.isRain())
    assert(card3.isRain())
  }
  test("Al aplicar clear todas las cartas pasan a estado clear") {
    val card: UnitCard = new CorpCard("nombre", 14, new NullEffect)
    val card2: UnitCard = new DistanceCard("nombre", 14, new NullEffect)
    val card3: UnitCard = new SiegeCard("nombre", 14, new NullEffect)
    Sec1.assignZoneC(card)
    Sec1.assignZoneD(card2)
    Sec1.assignZoneS(card3)
    Sec1.clear()
    assert(card.isClear())
    assert(card2.isClear())
    assert(card3.isClear())
  }
  test("se puede obtener la fuerza de que hay en las cartas del tableros"){
    val card: UnitCard = new CorpCard("nombre", 14, new NullEffect)
    val card2: UnitCard = new DistanceCard("nombre", 14, new NullEffect)
    val card3: UnitCard = new SiegeCard("nombre", 14, new NullEffect)
    Sec1.assignZoneC(card)
    Sec1.assignZoneD(card2)
    Sec1.assignZoneS(card3)
    assertEquals(Sec1.getStrength(), 42)
  }
  test("Se puede borrar las cartas de la seccion del tablero"){
    val card: UnitCard = new CorpCard("nombre", 14, new NullEffect)
    val card2: UnitCard = new DistanceCard("nombre", 14, new NullEffect)
    val card3: UnitCard = new SiegeCard("nombre", 14, new NullEffect)
    Sec1.assignZoneC(card)
    Sec1.assignZoneD(card2)
    Sec1.assignZoneS(card3)
    Sec1.clean()
    assertEquals(Sec1.getZoneC(), new ArrayBuffer[UnitCard](0))
    assertEquals(Sec1.getZoneD(), new ArrayBuffer[UnitCard](0))
    assertEquals(Sec1.getZoneS(), new ArrayBuffer[UnitCard](0))
  }
}
