package parking11;

public interface Parkinable {

	/**
	 * Nos calcula el precio de un estacionamiento 
	 * @param horaSalida la hora de retirada del vehiculo
	 * @return la cantidad calculada segun tarifa y duracion en minutos
	 * o -1 si la horaSalida es anterior al inicio del estacionamiento
	 */
	public float cerrarEstacionamiento(Hora horaSalida) ;
	
	
	/**
	 * Cuando ya hemos cerrado el estacionamiento y sabemos el importe
	 * este metodo comunica al parking la cantidad pagada 
	 * @param importe cantidad aportada por el usuario
	 * @return true si el importe es suficiente y false en caso contrario
	 * o si el estacionamiento no esta cerrado
	 */
	public boolean pagarEstacioamiento(Float importe);
	
	/**
	 * 
	 * @param hora
	 * @return
	 */
	public boolean efectuarSalida(Hora hora);
	
}
