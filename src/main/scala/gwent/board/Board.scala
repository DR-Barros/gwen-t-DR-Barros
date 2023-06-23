package cl.uchile.dcc
package gwent.board
import gwent.cards.{Card, UnitCard, WeatherCard}
import gwent.players.Player

import scala.collection.mutable.ArrayBuffer


/** Representa el tablero del juego
 *
 * El tablero del juego contiene 3 secciones, 1 para cada jugador donde pueden jugar las cartas de unidad
 * y una común para ambos jugadores en donde se juegan las cartas de clima
 *
 * @constructor crea 2 secciones para los jugadores y una para el clima (un arreglo de solo una carta)
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class Board{
  /** Seccion 1
   */
  private val sec1: Section = new BoardSection
  /** Seccion 2
   */
  private val sec2: Section = new BoardSection
  /** Seccion de clima
   */
  private val weatherSec: Array[WeatherCard] = new Array[WeatherCard](1)



  /** juega la carta del jugador en la seccion 1
   *
   * @param player jugador que juega la carta
   * @param n carta que es jugada
   */
  def playCardSec1(player: Player, n: Int): Unit = {
    val card = player.playCard(n)
    card.apply(this,sec1)
    card.assignZone(sec1, weatherSec)
  }

  /** juega la carta del jugador en la seccion 2
   *
   * @param player jugador que juega la carta
   * @param n carta que es jugada
   */
  def playCardSec2(player: Player, n: Int): Unit = {
    val card = player.playCard(n)
    card.apply(this, sec2)
    card.assignZone(sec2, weatherSec)
  }

  /** devuelve la fila cuepo a cuerpo de la seccion 1
   *
   * @return arreglo con  la zona cuerpo a cuerpo de la seccion 1
   */
  def getSec1C(): ArrayBuffer[UnitCard] = {
    return sec1.getZoneC()
  }

  /** devuelve la fila a distancia de la seccion 1
   *
   * @return arreglo con  la zona a distancia de la seccion 1
   */
  def getSec1D(): ArrayBuffer[UnitCard] = {
    sec1.getZoneD()
  }

  /** devuelve la fila de asedio de la seccion 1
   *
   * @return arreglo con  la zona de asedio de la seccion 1
   */
  def getSec1S(): ArrayBuffer[UnitCard] = {
    sec1.getZoneS()
  }

  /** devuelve la fila cuepo a cuerpo de la seccion 2
   *
   * @return arreglo con  la zona cuerpo a cuerpo de la seccion 2
   */
  def getSec2C(): ArrayBuffer[UnitCard] = {
    sec2.getZoneC()
  }

  /** devuelve la fila a distancia de la seccion 2
   *
   * @return arreglo con  la zona a distancia de la seccion 2
   */
  def getSec2D(): ArrayBuffer[UnitCard] = {
    sec2.getZoneD()
  }

  /** devuelve la fila de asedio de la seccion 2
   *
   * @return arreglo con  la zona de asedio de la seccion 2
   */
  def getSec2S(): ArrayBuffer[UnitCard] = {
    sec2.getZoneS()
  }

  /** devuelve la seccion de clima
   *
   * @return arreglo con  seccion de clima
   */
  def getSecW():Array[WeatherCard] = {
    return weatherSec
  }

  /** Manda a actualizar el estado de las cartas a despejado */
  def clear(): Unit = {
    sec1.clear()
    sec2.clear()
  }

  /** Manda a actualizar el estado de las cartas a niebla */
  def fog(): Unit = {
    sec1.fog()
    sec2.fog()
  }

  /** Manda a actualizar el estado de las cartas a escarcha */
  def frost(): Unit = {
    sec1.frost()
    sec2.frost()
  }

  /** Manda a actualizar el estado de las cartas a lluvia */
  def rain(): Unit = {
    sec1.rain()
    sec2.rain()
  }
}
