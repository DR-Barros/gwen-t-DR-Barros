package cl.uchile.dcc
package gwent.view

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.effects.NullEffect
import cl.uchile.dcc.gwent.cards.{Card, CorpCard}

import java.io.{ByteArrayOutputStream, PrintStream}
import scala.collection.mutable.ArrayBuffer

class ViewTest extends munit.FunSuite {
  var v: View = _

  override def beforeEach(context: BeforeEach): Unit = {
    v = new View

  }
  test("puede imprimir el estado de un tablero"){
    val b = new Board
    val outputStream = new ByteArrayOutputStream
    Console.withOut(new PrintStream(outputStream)) {
      v.showBoard(b.getSecW(),b.getSec1C(),b.getSec1S(), b.getSec1D(), b.getSec2C(), b.getSec2S(), b.getSec2D())
    }
    val resultado = outputStream.toString.trim
    val lineas = resultado.split('\n').map(_.trim)
    assertEquals(lineas(0), "Sección CPU")
    assertEquals(lineas(1), "Fila cartas a Distancia")
    assertEquals(lineas(2), "Fila cartas de asedio")
    assertEquals(lineas(3), "Fila combate cuerpo a cuerpo")
    assertEquals(lineas(4), "Carta clima: vacio")
    assertEquals(lineas(5), "Sección Jugador")
    assertEquals(lineas(6), "Fila combate cuerpo a cuerpo")
    assertEquals(lineas(7), "Fila cartas de asedio")
    assertEquals(lineas(8), "Fila cartas a Distancia")
  }
  test("Imprime las cartas en la mano"){
    val outputStream = new ByteArrayOutputStream
    Console.withOut(new PrintStream(outputStream)) {
      v.showHand(ArrayBuffer[Card](new CorpCard("card", 1, new NullEffect)))
    }
    val resultado = outputStream.toString.trim
    val lineas = resultado.split('\n').map(_.trim)
    assertEquals(lineas(0), "Tu mano es:")
    assertEquals(lineas(1), "Carta 1: card Fuerza: 1 Efecto: Sin efecto")
  }
  test("Imprime que la mano esta vacia de estarlo") {
    val outputStream = new ByteArrayOutputStream
    Console.withOut(new PrintStream(outputStream)) {
      v.showHand(new ArrayBuffer[Card](0))
    }
    val resultado = outputStream.toString.trim
    assertEquals(resultado, "Tu mano esta vacia")
  }
  test("imprime que el CPU esta jugando"){
    val outputStream = new ByteArrayOutputStream
    Console.withOut(new PrintStream(outputStream)) {
      v.cpuPlay()
    }
    val resultado = outputStream.toString.trim
    assertEquals(resultado, "Esta jugando el cpu")
  }
  test("imprime que el CPU paso su turno") {
    val outputStream = new ByteArrayOutputStream
    Console.withOut(new PrintStream(outputStream)) {
      v.cpuPass()
    }
    val resultado = outputStream.toString.trim
    assertEquals(resultado, "El cpu paso su turno")
  }
}
