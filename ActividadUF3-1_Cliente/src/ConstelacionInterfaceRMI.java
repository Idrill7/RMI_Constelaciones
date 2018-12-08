
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * Esta es la Interface que comparte el Servidor con el Cliente
 * El cliente usa el metodo buscarConstelacion()
 *
 */
public interface ConstelacionInterfaceRMI extends Remote{
	public String buscarConstelacion(String nombre) throws RemoteException;
}
