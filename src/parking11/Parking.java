package parking11;

public class Parking implements Parkinable{
	private Hora horaInicio;
	private Hora horafinal;
	private String matricula;
	private float tarifa=0.10f;
	private boolean pagado=false;
	private Hora momentoSalida;
	private boolean permiso;
	
	public Parking(Hora horaInicio, String matricula) {
		super();
		this.horaInicio = horaInicio;
		this.matricula = matricula;
	}

	@Override
	public float cerrarEstacionamiento(Hora horaSalida) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean pagarEstacioamiento(Float importe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean efectuarSalida(Hora hora) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
