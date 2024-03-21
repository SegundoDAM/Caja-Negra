package examenaeropuerto12;

import java.util.Random;

public class Vuelo {
	private String referenciaVuelo;
	private String destino;
	private Pista pistaAsignada;
	private boolean despegueAutorizado;

	public Vuelo(String referenciaVuelo, String destino) {
		this.referenciaVuelo = referenciaVuelo;
		this.destino = destino;
		this.despegueAutorizado = false;
	}

	/**
	 * Si tiene una pista asignada y el despegue autorizado el avion intenta
	 * despegar. si no consigue despegar, por lo que sea, el despegue se desautoriza
	 * 
	 * @return true si ha conseguido despegar y false en caso contrario.
	 */
	public boolean despegar() {
		if (despegueAutorizado) {
			despegueAutorizado = new Random().nextBoolean();;
		}
		return despegueAutorizado;

	}

	public void setPistaAsignada(Pista pistaAsignada) {
		this.pistaAsignada = pistaAsignada;
	}

	public Pista getPistaAsignada() {
		return pistaAsignada;
	}

	public void setDespegueAutorizado(boolean despegueAutorizado) {
		this.despegueAutorizado = despegueAutorizado;
	}

	public boolean isDespegueAutorizado() {
		return despegueAutorizado;
	}

}
