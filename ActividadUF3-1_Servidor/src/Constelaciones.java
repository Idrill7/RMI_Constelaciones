
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Esta es la clase Constelaciones, extiende de la clase UnicastRemoteObject que
 * permitira a los clientes obtener el stub del objeto para establecer la
 * comunicacion y poder invocar a los metodos remotos, por ello implementamos la
 * interfaz remota ConstelacionInterfaceRMI
 *
 */
public class Constelaciones extends UnicastRemoteObject implements ConstelacionInterfaceRMI {

	/**
	 * Es importante que la clase use la interfaz Serializable para asi poder
	 * convertir cualquier objeto en una secuencia/flujo de bytes, para que
	 * posteriormente el objeto pueda salir de la Maquina Virtual donde se encuentre
	 */
	private static final long serialVersionUID = 418590081234853327L;
	// declaramos la referencia de la lista, ArrayList, que creamos en el
	// constructor de esta
	// clase
	private List<Constelacion> constelaciones;

	/**
	 * Creamos en el constructor una coleccion de tipo ArrayList de objetos de la
	 * clase Constelacion. Estos seran aniadidos a la coleccion "constelaciones",
	 * con un nombre y una observacion
	 * 
	 * @throws RemoteException
	 */
	public Constelaciones() throws RemoteException {

		constelaciones = new ArrayList<Constelacion>();

		constelaciones.add(new Constelacion("Osa Mayor", "Se desplaza en c�rculos alrededor del polo norte."));

		constelaciones.add(new Constelacion("Osa Menor",
				"Su estrella m�s conocida es la polar que se encuentra en la prolongaci�n del eje de la tierra."));

		constelaciones.add(new Constelacion("Tauro", "Una de las constelaciones m�s conocidas desde tiempos remotos."));

		constelaciones.add(new Constelacion("Leo", "De las m�s brillantes del Zod�aco."));

		constelaciones.add(new Constelacion("Escorpio", "Sus estrellas forman un escorpi�n."));

		constelaciones.add(new Constelacion("Can Mayor", "Contiene la estrella Sirio, la m�s brillante en el cielo nocturno."));

		constelaciones.add(new Constelacion("Casiopea", "Tiene forma de M o W. Es conocida desde mucha antig�edad."));

		constelaciones.add(new Constelacion("El Boyero", "Contiene la estrella Arturo, uno de las m�s luminosas del cielo."));

		constelaciones.add(new Constelacion("Cruz del sur", "Se�ala al polo sur. Constelaci�n muy peque�a."));

		constelaciones.add(new Constelacion("Acuario", "Una de las m�s antiguas. Incluye 56 estrellas."));

		constelaciones.add(new Constelacion("Geminis", "Destaca por sus dos gemelos, las estrellas C�stor y P�lux."));
	}

	@Override

	/**
	 * Sobreescribimos el metodo buscarConstelacion, este recibira un nombre 
	 * , se recorrera con un for-each todas las constelaciones, si
	 * el nombre se encuentra en el ArrayList, se devuelve como resultado usando el
	 * metodo toString()
	 * 
	 * @return devolvemos el .toString() de la constelacion, que imprime el nombre y
	 *         las observaciones la constelacion buscada
	 *  @throws RemoteException
	 */

	public String buscarConstelacion(String nombre) throws RemoteException {
		String resultado = "";
		for (Constelacion c : constelaciones) {

			if (c.getNombre().equals(nombre)) {
				resultado = c + "\n";
			}
		}
		return resultado;
	}
}
