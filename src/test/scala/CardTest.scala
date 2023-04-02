package cl.uchile.dcc
import gwent.UnitCard
import gwent.WeatherCard

import munit.FunSuite

class CardTest extends munit.FunSuite {
  var U1: UnitCard = _
  var U2: UnitCard = _
  var W1: WeatherCard = _
  var W2: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    U1 = new UnitCard("soldado")
    U2 = new UnitCard("arquera")
    W1 = new WeatherCard("Escarcha")
    W2 = new WeatherCard("Niebla")
  }
  test("Las Cartas tienen nombre"){
    assertEquals(U1.getName(), "soldado")
    assertEquals(U2.getName(), "arquera")
    assertEquals(W1.getName(), "Escarcha")
    assertEquals(W2.getName(), "Niebla")
  }
  test("Las Cartas tienen un tipo"){
    assertEquals(U1.getCardType(), "Unit")
    assertEquals(U1.getCardType(), U2.getCardType())
    assertEquals(W1.getCardType(), "Weather")
    assertEquals(W1.getCardType(), W2.getCardType())
  }
}
