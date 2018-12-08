
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteRMI {

	public static void main(String[] args) {
		// Creamos la referencia del registro
		Registry registry;
		// Creamos el Scanner que va a leer lo que entre por consola
		Scanner lector = new Scanner(System.in);
		try {
			// El cliente obtiene el acceso al registro de objetos remotos mediante la IP y puerto del servidor
			registry = LocateRegistry.getRegistry("192.168.1.41", 2020);
			System.out.println("Hemos obtenido el registro");
			// El cliente obtiene el stub a partir del nombre identificativo que le damos al registro en el programa Servidor
			// El metodo lookup() devuelve un objeto tipo Remote segun el nombre que indicamos, este nombre va a ser el que hemos registrado en el Servidor
			//hacemos el casteo a un objeto de la interface ConstelacionInterfaceRMI
			// que esta en el cliente y en el servidor, para asi poder usar el metodo buscarConstelacion()
			ConstelacionInterfaceRMI constelaciones = (ConstelacionInterfaceRMI) registry.lookup("misConstelaciones");
			System.out.println("Hemos obtenido el objeto remoto");
			System.out.println(); // Retorno de carro

			String buscado;
			String busqueda;
			
			/**
			 * Hasta que el cliente escriba FIN, le pediremos un nombre de constelacion
			 * Leeremos lo que escribe por consola, si no escribe nada(le da a enter con un blanco), le pediremos que inserte alguna constelacion
			 * Si la busqueda no devuelve nada, le indicamos que no se encuentra en la lista
			 * Y si se encuentra , se imprime por pantalla el nombre y la observacion de la constelacion mediante el metodo buscarConstelacion()
			 */
			do {
				System.out.println("_____________________________________________________");
				System.out.println("Escribe nombre de la constelacion <FIN para terminar>");
				
				// en buscado guardamos lo que va a escribir el cliente
				buscado = lector.nextLine();
				// en busqueda lo que hacemos es usar el metodo buscarConstelacion()  que recibe como parametro lo que ha buscado el cliente
				busqueda = constelaciones.buscarConstelacion(buscado);	
				
				// Si lo que escribe el cliente es un blanco, es decir,no escribe nada, entonces le indicamos que inserte alguna constelación 
				if (buscado.isEmpty()) {
					System.out.println("Inserte alguna constelacion");
				}
				// Si el cliente no escribe FIN, se hace la busqueda de la constelacion
				else if (!buscado.equals("FIN")) {
				System.out.println();

				// y si la busqueda esta vacia, es decir, la constelacion no se encuentra en la lista, se lo haremos saber al cliente
				if ( busqueda.isEmpty()) {
					System.out.println(buscado + " no se encuentra en la lista de Constelaciones.");
				} else 
					// si no esta vacia la busqueda, mostramos la constelacion
						System.out.println(busqueda);
			
				}
			
			} while (!buscado.equals("FIN"));
			// cuando el cliente escribe FIN, entonces se acaba la conexion con el mismo
			System.out.println("Conexion finalizada");
			
		} catch (RemoteException | NotBoundException e) {
			System.out.println(e.getMessage());
		}
		lector.close();
	}

}