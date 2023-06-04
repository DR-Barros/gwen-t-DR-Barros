package cl.uchile.dcc
package gwent.board
import gwent.cards.Card

import gwent.players.Player

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
  private val sec1: BoardSection = new BoardSection
  /** Seccion 2
   */
  private val sec2: BoardSection = new BoardSection
  /** Seccion de clima
   */
  private val weatherSec: Array[Card] = new Array[Card](1)

  /** juega la carta del jugador en la seccion 1
   *
   * @param player jugador que juega la carta
   * @param n carta que es jugada
   */
  def playCardSec1(player: Player, n: Int): Unit = {
    val card = player.playCard(n)
    card.assignZone(sec1, weatherSec)
  }

  /** juega la carta del jugador en la seccion 2
   *
   * @param player jugador que juega la carta
   * @param n carta que es jugada
   */
  def playCardSec2(player: Player, n: Int): Unit = {
    val card = player.playCard(n)
    card.assignZone(sec2, weatherSec)
  }

  /** devuelve la fila cuepo a cuerpo de la seccion 1
   *
   * @return arreglo con  la zona cuerpo a cuerpo de la seccion 1
   */
  def getSec1C(): Array[Card] = {
    return sec1.getZoneC()
  }

  /** devuelve la fila a distancia de la seccion 1
   *
   * @return arreglo con  la zona a distancia de la seccion 1
   */
  def getSec1D(): Array[Card] = {
    sec1.getZoneD()
  }

  /** devuelve la fila de asedio de la seccion 1
   *
   * @return arreglo con  la zona de asedio de la seccion 1
   */
  def getSec1S(): Array[Card] = {
    sec1.getZoneS()
  }

  /** devuelve la fila cuepo a cuerpo de la seccion 2
   *
   * @return arreglo con  la zona cuerpo a cuerpo de la seccion 2
   */
  def getSec2C(): Array[Card] = {
    sec2.getZoneC()
  }

  /** devuelve la fila a distancia de la seccion 2
   *
   * @return arreglo con  la zona a distancia de la seccion 2
   */
  def getSec2D(): Array[Card] = {
    sec2.getZoneD()
  }

  /** devuelve la fila de asedio de la seccion 2
   *
   * @return arreglo con  la zona de asedio de la seccion 2
   */
  def getSec2S(): Array[Card] = {
    sec2.getZoneS()
  }

  /** devuelve la seccion de clima
   *
   * @return arreglo con  seccion de clima
   */
  def getSecW():Array[Card] = {
    return weatherSec
  }
}
