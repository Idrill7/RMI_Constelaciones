
/**
 * Esta es la clase Constelacion, se podran crear objetos de su clase que incluyen
 * el nombre y las observaciones sobre esa constelacion
 *
 *
 */
public class Constelacion {

		private String nombre;
		private String observaciones;
	/**
	 * Este es el constructor, en ella tenemos como parametros los String nombre y observaciones
	 * declarados como atributos de la clase
	 * @param nombre
	 * @param observaciones
	 */
	public Constelacion(String nombre, String observaciones) {
		this.nombre = nombre;
		this.observaciones = observaciones;
	}
// Getter y setter //
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	// Sobreescribimos el metodo toString para que a la hora de imprimir por pantalla
	// lo haga de una forma mas optima para su lectura
	@Override
	public String toString() {
		return "" + nombre + ": " + observaciones;
	}
	
	
}
