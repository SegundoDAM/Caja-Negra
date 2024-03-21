package examenaeropuerto12;

public enum Estado {
	libre,ocupada;

	public static boolean isOcupada(Estado pistaEstado) {
		return pistaEstado==ocupada;
	}
}
