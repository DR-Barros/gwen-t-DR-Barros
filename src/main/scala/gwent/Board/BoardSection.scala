package cl.uchile.dcc
package gwent.Board
import gwent.Cards.Card

/**Representa la seccion del tablero de cada jugador
 *
 * Cada seccion tiene 3 filas para los distintos tipos de carta (Corp, Distance & Siege),
 * las filas se representan por arreglos de cartas, en cada fila pueden haber hasta 6 cartas
 * esto dado un mazo estandar de GWENT
 *
 * @constructor crea un arreglo para cada fila de cartas y un contador que por cada fila que indica cuantas cartas tiene
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class BoardSection {
  /** Fila de cartas cuerpo a cuerpo
   *
   * En el arreglo se guardan las cartas cuerpo a cuerpo
   */
  private var zoneC: Array[Card] = new Array[Card](6)
  /** Contador de cartas cuerpo a cuerpo
   *
   * Lleva el registro de cuantas cartas se tienen en la fila cuerpo a cuerpo
   */
  private var countC: Int = 0
  /** Fila de cartas a distancia
   *
   * En el arreglo se guardan las cartas a distancia
   */
  private var zoneD: Array[Card] = new Array[Card](6)
  /** Contador de cartas a distancia
   *
   * Lleva el registro de cuantas cartas se tienen en la fila a distancia
   */
  private var countD: Int = 0
  /** Fila de cartas de asedio
   *
   * En el arreglo se guardan las cartas de asedio
   */
  private var zoneS: Array[Card] = new Array[Card](6)
  /** Contador de cartas de asedio
   *
   * Lleva el registro de cuantas cartas se tienen en la fila de asedio
   */
  private var countS: Int = 0

  /** Asigna cartas a la seccion cuerpo a cuerpo
   *
   * @param card la carta que se asignara en la seccion cuerpo a cuerpo
   */
  def assignZoneC(card: Card): Unit = {
    zoneC(countC) = card
    countC += 1
  }

  /** Asigna cartas a la seccion a Distancia
   *
   * @param card la carta que se asignara en la seccion a Distancia
   */
  def assignZoneD(card: Card): Unit = {
    zoneD(countD) = card
    countD += 1
  }

  /** Asigna cartas a la seccion de asedio
   *
   * @param card la carta que se asignara en la seccion de asedio
   */
  def assignZoneS(card: Card): Unit = {
    zoneS(countS) = card
    countS += 1
  }

  /** Devuelve el arreglo corresponiente a la seccion cuerpo a cuerpo
   * 
   * @return el arreglo con las cartas de la seccion cuerpo a cuerpo
   */
  def getZoneC(): Array[Card] = {
    return zoneC
  }

  /** Devuelve el arreglo corresponiente a la seccion a distancia
   * 
   * @return el arreglo con las cartas de la seccion a distancia
   */
  def getZoneD(): Array[Card] = {
    return zoneD
  }

  /** Devuelve el arreglo corresponiente a la seccion de asedio
   * 
   * @return el arreglo con las cartas de la seccion de asedio
   */
  def getZoneS(): Array[Card] = {
    return zoneS
  }
}
