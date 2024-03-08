package ascensor10;

import java.util.ArrayList;

/**
 * El ascensor tiene diez plantas.
 * El ascensor comienza en la planta cero su funcionamiento
 * @author alumno
 *
 */
public class Ascensor {

	private final int maxPlanta=10;
	private Estado estado=Estado.subiendo;
	private int plantaActual=0;
	private ArrayList<Integer> plantasSolicitadas;
	


	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getPlantaActual() {
		return plantaActual;
	}

	public void setPlantaActual(int plantaActual) {
		this.plantaActual = plantaActual;
	}

	public ArrayList<Integer> getPlantasSolicitadas() {
		return plantasSolicitadas;
	}
	
	public void setPlantasSolicitadas(ArrayList<Integer> plantasSolicitadas) {
		this.plantasSolicitadas = plantasSolicitadas;
	}
	/**
	 * El usuario pide la planta a la que quiere ir.
	 * Esta peticion se ordena para parar en todas las plantas
	 * intermedias que hayan sido solicitadas previamente.
	 * Si no hay ninguna peticion para seguir en el mismo sentido
	 * procede a ir en el sentido contrario
	 * @param planta
	 */
	public void solicitarPlanta(int planta) {
		
	}
	
	public Estado getEstado() {
		return estado;
	}

	/**
	 * El ascensor seguira su sentido, dependiendo del estado actual,
	 * si está subiendo ira a la siguiente planta solicitada mayor que la
	 * actual, si esta bajando lo hara en la menor. En ningun caso cambiará de sentido
	 * si todavia quedan plantas solicitadas a las que no se ha llegado
	 * @return la planta alcanzada hasta parar. Si no tiene mas paradas pendientes se queda
	 * en la planta actual
	 */
	public int seguirRuta() {
		return -1;
	}
}
