package cl.uchile.dcc
package gwent.Exception

/** Excepcion lanzada cuando el mazo esta vacio
 * 
 * @param message el mensaje descriptivo del error
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0 
 */
class DeckIsEmpty(message:String) extends RuntimeException(message){

}
