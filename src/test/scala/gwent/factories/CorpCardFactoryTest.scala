package cl.uchile.dcc
package gwent.factories

import gwent.cards.CorpCard

class CorpCardFactoryTest extends munit.FunSuite {
  var c: CorpCardFactory = _
  override def beforeEach(context: BeforeEach): Unit = {
    c = new CorpCardFactory
  }
  test("Crea cartas cuerpo a cuerpo"){
    assert(c.create().isInstanceOf[CorpCard])
    assert(c.create().isInstanceOf[CorpCard])
    assert(c.create().isInstanceOf[CorpCard])
    assert(c.create().isInstanceOf[CorpCard])
    assert(c.create().isInstanceOf[CorpCard])
    assert(c.create().isInstanceOf[CorpCard])
    assert(c.create().isInstanceOf[CorpCard])
  }
}
