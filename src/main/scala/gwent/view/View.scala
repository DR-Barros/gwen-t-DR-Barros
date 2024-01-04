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

  /** Muestra en consola la mano del jugador */
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

  /** Le pregunta al jugador si quiere jugar una carta o pasar el turno
   * 
   * @return un string con la respuesta del jugador
   */
  def playerTurn(): String = {
    println("Quieres jugar una carta o pasar (escribe 'jugar' o 'pasar'):")
    var input: String = StdIn.readLine().toLowerCase()
    val p = Array("jugar", "pasar")
    while (!p.contains(input)) {
      println(input)
      println("escribe 'jugar' o 'pasar' para elegir acción:")
      input = StdIn.readLine().toLowerCase()
    }
    return input
  }

  /** Permite al jugador decidir que carta quiere jugar
   * 
   * @param n entero que representa el numero de cartas que tiene en la mano el jugador
   * @return devuelve el entero que representa la carta que quiere jugar el jugador
   */
  def selectCard(n: Int): Int = {
    println(s"Elige una carta entre 1 y $n para jugar")
    var ret: Int = StdIn.readInt()
    while (ret<=0 || ret > n){
      println(s"La carta debe ser entre 1 y $n")
      ret = StdIn.readInt()
    }
    return ret
  }
  /** Indica en consola que el CPU esta jugando */
  def cpuPlay(): Unit = println("Esta jugando el CPU")

  /** Indica en consola que el CPU paso su turno */
  def cpuPass(): Unit = println("El cpu paso su turno")

  /** Indica en consola que el Jugador gano la ronda */
  def winP1(): Unit = println("Gano la ronda el Jugador")

  /** Indica en consola que el CPU gano la ronda */
  def winP2(): Unit = println("Gano la ronda el CPU")

  /** Indica en consola que hubo empate en la ronda*/
  def draw(): Unit = println("Empataron la ronda")

  /**Pregunta al jugador si quiere jugar una nueva partida
   * 
   * @return string con la respuesta del jugador
   */
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
