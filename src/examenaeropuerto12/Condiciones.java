package examenaeropuerto12;


public class Condiciones {
    private double temperatura;
    private double viento;
    private double lluvia;
    private boolean helado;

    public Condiciones(double temperatura, double viento, double lluvia, boolean helado) {
        this.temperatura = temperatura;
        this.viento = viento;
        this.lluvia = lluvia;
        this.helado = helado;
    }

    public boolean validate(Condiciones condiciones) {
        return this.temperatura < condiciones.temperatura &&
               cumpleViento(condiciones.viento) &&
                this.lluvia < condiciones.lluvia &&
                !this.helado;
    }

	private boolean cumpleViento(double viento2) {
		return Math.abs(this.viento-viento)<this.viento*.1f;
	}
}

