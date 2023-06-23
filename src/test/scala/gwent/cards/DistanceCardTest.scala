package cl.uchile.dcc
package gwent.cards

import gwent.cards.effects.{ClearEffect, NullEffect}

class DistanceCardTest extends munit.FunSuite{
  var C1: DistanceCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    C1 = new DistanceCard("arquera", 14, new NullEffect)
  }
  test("Una carta a distancia tien nombre"){
    assertEquals(C1.getName(), "arquera")
  }
  test("Una carta a distancia es de a distancia"){
    assertEquals(C1.getCardType(), "Distance")
  }
  test("Una carta a distancia tiene fuerza"){
    assertEquals(C1.getStrength(), 14)
  }
  test("Una carta a distancia puede aumentar en uno su fuerza"){
    assertEquals(C1.getStrength(), 14)
    C1.moreStrength()
    assertEquals(C1.getStrength(), 15)
  }
  test("Una carta a distancia se identifica por su nombre y fuerza") {
    assert(C1.equals(new DistanceCard("arquera", 14, new NullEffect)))
    assert(!C1.equals(new DistanceCard("mago", 14, new NullEffect)))
    assert(!C1.equals(new DistanceCard("arquera", 10, new NullEffect)))
  }
  test("Una carta a distancia solo es igual a otra carta a distancia con igual nombre y fuerza") {
    assert(C1.equals(new DistanceCard("arquera", 14, new NullEffect)))
    assert(!C1.equals(new DistanceCard("arqueras", 14, new NullEffect)))
    assert(!C1.equals(new DistanceCard("arquera", 19, new NullEffect)))
    assert(!C1.equals(new CorpCard("arquera", 14, new NullEffect)))
    assert(!C1.equals(new SiegeCard("arquera", 14, new NullEffect)))
    assert(!C1.equals(new WeatherCard("Soleado", new ClearEffect)))
  }
  test("Una carta a distancia se inicializa en el estado despejado"){
    assert(C1.isClear())
    assert(!C1.isFog())
    assert(!C1.isRain())
    assert(!C1.isFrost())
  }
  test("Una carta a distancia solo puede pasar de despejado a niebla y viceversa"){
    C1.clear()
    assert(C1.isClear())
    C1.fog()
    assert(C1.isFog())
    C1.fog()
    assert(C1.isFog())
    C1.clear()
    assert(C1.isClear())
    C1.frost()
    assert(!C1.isFrost())
    C1.rain()
    assert(!C1.isRain())
  }
  test("Si una carta a distancia sufre niebla su fuerza pasa a 1") {
    assertEquals(C1.getStrength(), 14)
    C1.fog()
    assertEquals(C1.getStrength(), 1)
  }
}
