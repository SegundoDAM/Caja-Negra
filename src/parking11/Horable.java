package parking11;

public interface Horable {

	/**
	 * nos dice si una hora es posterior a otra
	 * @param hora la que comparamos
	 * @return true si la hora del parametro es posterior o false en caso contrario
	 */
	public boolean isLater(Hora hora);
	
	/**
	 * Nos calcula los minutos transcurridos entre las dos horas
	 * @param hora la que queremos comprobar
	 * @return la cantidad de minutos de diferencia entre la hora
	 * del parametro y la hora del objeto. Si la hora del parametro
	 * es anterior a la hora del objeto, el retorno es -1
	 */
	public int getDurationInMinutes(Hora hora);
		
}
