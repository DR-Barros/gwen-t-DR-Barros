package cl.uchile.dcc
package gwent.Cards

import gwent.Cards.Card


/**Clase que representa un mazo de cartas
 *
 * Un mazo de cartas se define como un conjunto de cartas al cual le podemos ir robando cartas
 *
 * @param cards conjunto de cartas en un ListBuffer
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.1
 */
class Deck (private var cards: Array [Card]){
  /** Cantidad de cartas en el mazo
   *
   * Esta variable guarda cuantas cartas hay en el mazo
   */
  private var size = cards.length
  /** Calcula el tamaño del mazo
   *
   * Entrega la cantidad de elementos (cartas) que tiene el mazo
   *
   * @return numero de cartas en el mazo
   */
  def deckSize(): Int = {
    return size
  }

  /**Robar una carta
   *
   * Genera un numero random menor al tamaño del mazo, devuelve la carta en el inidce que corresponde al numero generado,
   * elimina la carta del mazo. En caso de estar vacio el mazo devuelve una carta vacia que indica que no hay cartas
   *
   * @return una carta del mazo
   */
  def stealCard(): Card = {
    if (size > 0){
        val r = new scala.util.Random
        val random = r.nextInt(size)
        val cardReturn = cards(random)
        cards(random) = cards(size-1)
        size -= 1
        return cardReturn
    } else {
      return new emptyCard
    }
  }
}
