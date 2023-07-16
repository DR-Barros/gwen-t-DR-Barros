package cl.uchile.dcc
package gwent.factories

import gwent.cards.WeatherCard

class WeatherCardFactoryTest extends munit.FunSuite {
  var c: WeatherCardFactory = _
  override def beforeEach(context: BeforeEach): Unit = {
    c = new WeatherCardFactory
  }
  test("Crea cartas de clima"){
    assert(c.create().isInstanceOf[WeatherCard])
    assert(c.create().isInstanceOf[WeatherCard])
    assert(c.create().isInstanceOf[WeatherCard])
    assert(c.create().isInstanceOf[WeatherCard])
    assert(c.create().isInstanceOf[WeatherCard])
    assert(c.create().isInstanceOf[WeatherCard])
    assert(c.create().isInstanceOf[WeatherCard])
  }
}
