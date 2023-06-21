package cl.uchile.dcc
package gwent.cards

import gwent.cards.effects.{ClearEffect, NullEffect}

class CorpCardTest extends munit.FunSuite{
  var C1: CorpCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    C1 = new CorpCard("vikingo", 18, new NullEffect)
  }
  test("Una carta cuerpo a cuerpo tien nombre"){
    assertEquals(C1.getName(), "vikingo")
  }
  test("Una carta de cuerpo a cuerpo es de tipo cuerpo a cuerpo"){
    assertEquals(C1.getCardType(), "Corp")
  }
  test("Una carta de cuerpo a cuerpo tiene fuerza"){
    assertEquals(C1.getStrength(), 18)
  }
  test("Una carta cuepo a cuerpo puede aumentar en 1 su fuerza"){
    assertEquals(C1.getStrength(), 18)
    C1.moreStrength()
    assertEquals(C1.getStrength(), 19)
  }
  test("Una carta cuerpo a cuerpo se identifica por su nombre y fuerza"){
    assert(C1.equals(new CorpCard("vikingo", 18, new NullEffect)))
    assert(!C1.equals(new CorpCard("soldado", 18, new NullEffect)))
    assert(!C1.equals(new CorpCard("vikingo", 10, new NullEffect)))
  }
  test("Una carta cuerpo a cuerpo solo es igual a otra carta cuerpo a cuerpo con igual nombre y fuerza"){
    assert(C1.equals(new CorpCard("vikingo", 18, new NullEffect)))
    assert(!C1.equals(new CorpCard("vikingos", 18, new NullEffect)))
    assert(!C1.equals(new CorpCard("vikingo", 19, new NullEffect)))
    assert(!C1.equals(new DistanceCard("vikingo", 18, new NullEffect)))
    assert(!C1.equals(new SiegeCard("vikingo", 18, new NullEffect)))
    assert(!C1.equals(new WeatherCard("Soleado", new ClearEffect)))
  }
}