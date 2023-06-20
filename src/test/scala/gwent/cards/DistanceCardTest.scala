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

}
