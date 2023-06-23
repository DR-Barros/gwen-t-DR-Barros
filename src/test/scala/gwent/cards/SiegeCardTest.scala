package cl.uchile.dcc
package gwent.cards

import gwent.cards.effects.{ClearEffect, NullEffect}

class SiegeCardTest extends munit.FunSuite{
  var C1: SiegeCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    C1 = new SiegeCard("catapulta", 25, new NullEffect)
  }
  test("Una carta de asedio tien nombre"){
    assertEquals(C1.getName(), "catapulta")
  }
  test("Una carta de asedio es de tipo asedio"){
    assertEquals(C1.getCardType(), "Siege")
  }
  test("Una carta de asedio tiene fuerza"){
    assertEquals(C1.getStrength(), 25)
  }
  test("Una carta de asedio puede aumentar en uno su fuerza"){
    assertEquals(C1.getStrength(), 25)
    C1.moreStrength()
    assertEquals(C1.getStrength(), 26)
  }
  test("Una carta de asedio se identifica por su nombre y fuerza") {
    assert(C1.equals(new SiegeCard("catapulta", 25, new NullEffect)))
    assert(!C1.equals(new SiegeCard("Torre", 25, new NullEffect)))
    assert(!C1.equals(new SiegeCard("catapulta", 20, new NullEffect)))
  }
  test("Una carta de asedio solo es igual a otra carta de asedio con igual nombre y fuerza") {
    assert(C1.equals(new SiegeCard("catapulta", 25, new NullEffect)))
    assert(!C1.equals(new SiegeCard("catapultas", 25, new NullEffect)))
    assert(!C1.equals(new SiegeCard("catapulta", 19, new NullEffect)))
    assert(!C1.equals(new CorpCard("catapulta", 25, new NullEffect)))
    assert(!C1.equals(new DistanceCard("catapulta", 25, new NullEffect)))
    assert(!C1.equals(new WeatherCard("Soleado", new ClearEffect)))
  }
  test("Una Carta de asedio se inicializa en el estado despejado") {
    assert(C1.isClear())
    assert(!C1.isFog())
    assert(!C1.isRain())
    assert(!C1.isFrost())
  }
  test("Una carta de asedio solo puede pasar de despejado a lluvia y viceversa") {
    C1.clear()
    assert(C1.isClear())
    C1.rain()
    assert(C1.isRain())
    C1.fog()
    assert(!C1.isFog())
    C1.frost()
    assert(!C1.isFrost())
    assert(C1.isRain())
    C1.rain()
    assert(C1.isRain())
    C1.clear()
    assert(C1.isClear())
  }
  test("Si una carta cuerpo a cuerpo sufre escarcha su fuerza pasa a 1") {
    assertEquals(C1.getStrength(), 25)
    C1.rain()
    assertEquals(C1.getStrength(), 1)
  }
}
