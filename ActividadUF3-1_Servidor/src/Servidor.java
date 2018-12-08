
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
	public static void main(String[] args) {
		String host;
		/**
		 * Este es el puerto en el que estableceremos el servidor
		 */
		int puerto = 2020;
		try {
			/**
			 * Obtenemos la direccion Ip de la red local de la maquina que 
			 * hace de host del programa servidor mediante el metodo getLocalHost() y getHostAdress()
			 * y la guardamos en una variable, host
			 * El metodo getHostAdress() puede desencadenar una excepcion de tipo UnknowHostException
			 * si por algun motivo no se obtiene la direccion IP
			 */
			host = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			System.out.println("No se ha podido obtener la dirección IP");
			System.out.println(e.getMessage());
			return;
		}
		
		try {
			/**
			 * Creamos el registro de objetos remotos 
			 * Los objetos que se inscriban en este objeto Registro, son puestos a disposicion de los clientes
			 * mediante la IP del servidor y el puerto especificado anteriormente
			 */
			Registry registro = LocateRegistry.createRegistry(puerto);
			// Creamos el objeto de la clase Constelaciones que vamos a compartir 
			// Este contiene todas las Constelaciones, las cuales el cliente va a buscar por su nombre
			// mediante el metodo buscarConstelacion() 
			Constelaciones constelaciones = new Constelaciones();
			/**
			 * Usamos el metodo rebind para publicar el objeto de la clase Constelaciones en el registro,
			 *  este tendra como parametros un nombre identificativo junto al objeto de la clase Constelaciones
			 * Asi los clientes pueden obtener el stub de las Constelaciones mediante el identificador asignado
			 */
			registro.rebind("misConstelaciones", constelaciones);
			
			System.out.println("Servicio registrado en host " + host + " y puerto " + puerto);
		} catch (RemoteException e) {
			System.out.println("No se ha podido registrar el servicio");
			System.out.println(e.getMessage());
		}
	}
}