package cl.uchile.dcc
import  munit.FunSuite

class PlayerTest extends munit.FunSuite {
  var player1: Player = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new Player()
  }
}
