package cl.uchile.dcc
import munit.FunSuite

class CardTest extends munit.FunSuite {
  var U1: UnitCard = _
  var U2: UnitCard = _
  var W1: WeatherCard = _
  var W2: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    U1 = new UnitCard("soldado")
    U2 = new UnitCard("arquera")
    W1 = new WheatherCard("Escarcha")
    W2 = new WeatherCard("Niebla")
  }
  test("Las Cartas tienen nombre"){
    assertEquals(U1.getName(), "soldado")
    assertEquals(U2.getName(), "arquera")
    assertEquals(W1.getName(), "Escarcha")
    assertEquals(W2.getName(), "Niebla")
  }
  test("Las Cartas tienen un tipo"){
    assertEquals(U1.getTipe(), "Unit")
    assertEquals(U1.getTipe(), U2.getTipe())
    assertEquals(W1.getTipe(), "Weather")
    assertEquals(W1.getTipe(), W2.getTipe())
  }
}
