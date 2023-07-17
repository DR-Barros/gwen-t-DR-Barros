package cl.uchile.dcc
package gwent.cards

import gwent.cards.effects.{ClearEffect, FogEffect, NullEffect}

class WeatherCardTest extends munit.FunSuite{
  var W1: WeatherCard = _
  var W2: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    W1 = new WeatherCard("soleado", new ClearEffect)
    W2 = new WeatherCard("nublado", new FogEffect)
  }
  test("Una carta de clima tiene nombre"){
    assertEquals(W1.getName(), "soleado")
  }
  test("Una carta de clima tiene un print") {
    assertEquals(W1.print(), "soleado Tipo: Weather Efecto: Clima despejado")
  }
  test("Una carta de clima es de tipo clima y no es igual a una carta de unidad"){
    assertEquals(W1.getCardType(), "Weather")
    assert(!W1.equals(new CorpCard("Soldado", 15, new NullEffect)))
    assert(!W1.equals(new DistanceCard("Arquera", 15, new NullEffect)))
    assert(!W1.equals(new SiegeCard("catapulta", 20, new NullEffect)))
  }
  test("Una carta clima se identifica por su nombre"){
    assert(W1.equals(new WeatherCard("soleado", new ClearEffect)))
    assert(!W1.equals(W2))
  }
}
