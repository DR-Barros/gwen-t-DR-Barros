package cl.uchile.dcc
package gwent.Cards

/** Clase de carta tipo cuerpo a cuerpo
 *
 * @param name nombre de la carta
 * @param strength fuerza de la carta
 */
class CorpCard(private val name: String, private  val strength: Int) extends UnitCard(name, strength) {
  override def getCardType(): String = {
    return "Corp"
  }
}
