package cl.uchile.dcc
package gwent.board
import gwent.cards.UnitCard

import scala.collection.mutable.ArrayBuffer

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
class BoardSection  extends Section {
  /** Fila de cartas cuerpo a cuerpo
   *
   * En el arreglo se guardan las cartas cuerpo a cuerpo
   */
  private var zoneC: ArrayBuffer[UnitCard] = new ArrayBuffer[UnitCard]

  /** Fila de cartas a distancia
   *
   * En el arreglo se guardan las cartas a distancia
   */
  private var zoneD: ArrayBuffer[UnitCard] = new ArrayBuffer[UnitCard]

  /** Fila de cartas de asedio
   *
   * En el arreglo se guardan las cartas de asedio
   */
  private var zoneS: ArrayBuffer[UnitCard] = new ArrayBuffer[UnitCard](6)

  /** Asigna cartas a la seccion cuerpo a cuerpo
   *
   * @param card la carta que se asignara en la seccion cuerpo a cuerpo
   */
  def assignZoneC(card: UnitCard): Unit = {
    zoneC += card
  }

  /** Asigna cartas a la seccion a Distancia
   *
   * @param card la carta que se asignara en la seccion a Distancia
   */
  def assignZoneD(card: UnitCard): Unit = {
    zoneD += card
  }

  /** Asigna cartas a la seccion de asedio
   *
   * @param card la carta que se asignara en la seccion de asedio
   */
  def assignZoneS(card: UnitCard): Unit = {
    zoneS += card
  }

  /** Devuelve un entero con la fuerza que hay en la seccion
   *
   * @return la fuerza que hay en la seccion
   */
  override def getStrength(): Int = {
    var S: Int = 0;
    zoneC.foreach(card => S+=card.getStrength())
    zoneC.foreach(card => S+=card.getStrength())
    zoneC.foreach(card => S+=card.getStrength())
    return S
  }

  /** Devuelve el arreglo corresponiente a la seccion cuerpo a cuerpo
   * 
   * @return el arreglo con las cartas de la seccion cuerpo a cuerpo
   */
  def getZoneC(): ArrayBuffer[UnitCard] = {
    return zoneC.clone()
  }

  /** Devuelve el arreglo corresponiente a la seccion a distancia
   * 
   * @return el arreglo con las cartas de la seccion a distancia
   */
  def getZoneD(): ArrayBuffer[UnitCard] = {
    return zoneD.clone()
  }

  /** Devuelve el arreglo corresponiente a la seccion de asedio
   * 
   * @return el arreglo con las cartas de la seccion de asedio
   */
  def getZoneS(): ArrayBuffer[UnitCard] = {
    return zoneS.clone()
  }

  /** Limpia la sección */
  def clean(): Unit = {
    zoneC = new ArrayBuffer[UnitCard]()
    zoneS = new ArrayBuffer[UnitCard]()
    zoneD = new ArrayBuffer[UnitCard]()
  }

  /** Aplica bond a las cartas de la fila que tienen igual nombre que card
   *
   * @param card carta de referencia que se usa para aplicar bond
   */
  def bondC(card: UnitCard): Unit = {
    zoneC.foreach(unitCard => if(unitCard.getName() == card.getName()){unitCard.moreStrength()})
  }

  /** Aplica bond a las cartas de la fila que tienen igual nombre que card
   *
   * @param card carta de referencia que se usa para aplicar bond
   */
  def bondD(card: UnitCard): Unit = {
    zoneD.foreach(unitCard => if(unitCard.getName() == card.getName()){unitCard.moreStrength()})
  }

  /** Aplica bond a las cartas de la fila que tienen igual nombre que card
   *
   * @param card carta de referencia que se usa para aplicar bond
   */
  def bondS(card: UnitCard): Unit = {
    zoneS.foreach(unitCard => if(unitCard.getName() == card.getName()){unitCard.moreStrength()})
  }

  /** Aplica moral a las cartas de la fila */
  def moralC(): Unit ={
    zoneC.foreach(_.moreStrength())
  }

  /** Aplica moral a las cartas de la fila */
  def moralD(): Unit = {
    zoneD.foreach(_.moreStrength())
  }

  /** Aplica moral a las cartas de la fila */
  def moralS(): Unit = {
    zoneS.foreach(_.moreStrength())
  }

  /** Manda a actualizar el estado de las cartas a despejado*/
  def clear(): Unit = {
    zoneC.foreach(_.clear())
    zoneD.foreach(_.clear())
    zoneS.foreach(_.clear())
  }

  /** Manda a actualizar el estado de las cartas a niebla*/
  def fog(): Unit = {
    zoneC.foreach(_.fog())
    zoneD.foreach(_.fog())
    zoneS.foreach(_.fog())
  }

  /** Manda a actualizar el estado de las cartas a escarcha */
  def frost(): Unit = {
    zoneC.foreach(_.frost())
    zoneD.foreach(_.frost())
    zoneS.foreach(_.frost())
  }

  /** Manda a actualizar el estado de las cartas a lluvia */
  def rain(): Unit = {
    zoneC.foreach(_.rain())
    zoneD.foreach(_.rain())
    zoneS.foreach(_.rain())
  }
}
