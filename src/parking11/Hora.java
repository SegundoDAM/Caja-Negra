package parking11;
import java.time.LocalDateTime;

public class Hora implements Horable{

	private int hora;
	private int minutos;
	
	
	/**
	 * Existen unos limites: 
	 * las horas solo pueden tomar valores entre 0 y 23 
	 * y los minutos entre 0 y 59
	 * si no cumple, la hora sera la 00:00
	 */
	public Hora(int i, int j) {
		super();
		this.hora = i;
		this.minutos = j;
	}

	public static Hora now() {
		return new Hora(LocalDateTime.now().getHour(),LocalDateTime.now().getMinute());
	}

	@Override
	public boolean isLater(Hora hora) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getDurationInMinutes(Hora hora) {
		// TODO Auto-generated method stub
		return 0;
	}
}
