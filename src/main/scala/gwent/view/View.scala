package cl.uchile.dcc
package gwent.view

import gwent.cards.{Card, CorpCard, DistanceCard, SiegeCard, WeatherCard}

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

/** Es la clase encargada de mostrar en la consola el flujo del juego y recibir los inputs
 *
 * Genera la interfaz visual del juego en consola y recibe los inputs del jugador
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class View {
  /** Muestra en consola el estado actual del tablero */
  def showBoard(secW: Array[WeatherCard], sec1C:ArrayBuffer[CorpCard], sec1S:ArrayBuffer[SiegeCard], sec1D:ArrayBuffer[DistanceCard], sec2C:ArrayBuffer[CorpCard], sec2S:ArrayBuffer[SiegeCard], sec2D:ArrayBuffer[DistanceCard]): Unit = {
    println("Sección CPU \nFila cartas a Distancia")
    for (c <- sec2D)
      println("Carta: "+ c.getName()+" Fuerza:"+c.getStrength())
    println("Fila cartas de asedio")
    for (c <- sec2S)
      println("Carta: " + c.getName() + " Fuerza:" + c.getStrength())
    println("Fila combate cuerpo a cuerpo")
    for (c <- sec2C)
      println("Carta: " + c.getName() + " Fuerza:" + c.getStrength())
    if (secW(0)== null){
      println("Carta clima: vacio")
    } else {
      println("Carta clima: "+secW(0).getName())
    }
    println("Sección Jugador"+"\nFila combate cuerpo a cuerpo")
    for (c <- sec1C)
      println("Carta: " + c.getName() + " Fuerza:" + c.getStrength())
    println("Fila cartas de asedio")
    for (c <- sec1S)
      println("Carta: " + c.getName() + " Fuerza:" + c.getStrength())
    println("Fila cartas a Distancia")
    for (c <- sec1D)
      println("Carta: " + c.getName() + " Fuerza:" + c.getStrength())
  }

  def showHand(hand: ArrayBuffer[Card]): Unit = {
    if(hand.size > 0){
      var i: Int = 1
      println("Tu mano es:")
      for (card <- hand){
        println(s"Carta $i: "+card.print())
        i += 1
      }
    } else {
      println("Tu mano esta vacia")
    }
  }
  def selectCard(n: Int): Int = {
    println(s"Elige una carta entre 1 y $n")
    var ret: Int = StdIn.readInt()
    while (ret<=0 || ret > n){
      println(s"Elige una carta entre 1 y $n")
      ret = StdIn.readInt()
    }
    return ret
  }
  def cpuPlay(): Unit = println("Esta jugando el cpu")
  
  def cpuPass(): Unit = println("El cpu paso su turno")
 
  def winP1(): Unit = println("Gano la ronda el CPU")
  
  def winP2(): Unit = println("Gano la ronda el jugador 1")
  
  def draw(): Unit = println("Empataron la ronda")
  
  def finishGame(): String ={
    println("Quieres jugar una nueva partida: (si/no)")
    var input: String = StdIn.readLine().toLowerCase()
    while (input != "si" || input != "no"){
      println("Quieres jugar una nueva partida: (si/no)")
      var input: String = StdIn.readLine().toLowerCase()
    }
    return input
  }
}
