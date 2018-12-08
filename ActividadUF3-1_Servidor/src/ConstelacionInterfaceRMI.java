



import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * 
 * Interface Java que contiene la definicion de los metodos que el cliente invocara de manera remota
 * Para ello extendemos de la interface Remote, esto permite a los objetos la capacidad de poder invocar a los metodos de la interfaz desde
 * cualquier maquina virtual de java situada en cualquier equipo remoto
 * Tanto la interface como los metodos de la misma deben de ser publicos
 */
public interface ConstelacionInterfaceRMI extends Remote{
	// Los metodos lanzan la excepcion RemoteException, que esta en relacion con
	// los errores que pueden ocurrir durante la invocacion a metodos remotos
	
	/**
	 * Este metodo recibe como parametro el nombre (String), que seria el de la constelacion a buscar
	 * Permite buscar la constelacion por el nombre de la misma
	 * @param nombre
	 * @return String
	 * @throws RemoteException
	 */
	public String buscarConstelacion(String nombre) throws RemoteException;
}
