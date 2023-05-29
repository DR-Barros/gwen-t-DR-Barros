package cl.uchile.dcc
package gwent.Exception

/** Excepción lanzada cuando el mazo esta vacío
 * 
 * la excepcion notifica que el mazo esta vacio y por lo tanto no se pueden robar cartas
 * 
 * @param message el mensaje descriptivo del error
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0 
 */
class DeckIsEmpty(message:String) extends RuntimeException(message){

}
