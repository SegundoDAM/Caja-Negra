package examenaeropuerto12;

import java.util.ArrayList;
import java.util.Objects;


public class Pista {
    private int numero;
    private ArrayList<Pista> laterales;
    private Estado estado;

    public Pista(int numero, Estado estado) {
        this.numero = numero;
        this.estado = estado;
        this.laterales = new ArrayList<>();
    }

    public void setEstado(Estado estado) {
		this.estado = estado;
	}

	boolean isOcupada() {
		if (Estado.isOcupada(estado)) {
			return true;
		}
		for (Pista pista : laterales) {
			if (Estado.isOcupada(pista.estado)) {
				return true;
			}
		}
		return false;
    }

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ArrayList<Pista> getLaterales() {
		return laterales;
	}

	public void setLaterales(ArrayList<Pista> laterales) {
		this.laterales = laterales;
	}

	public Estado getEstado() {
		return estado;
	}

	public void addLateral(Pista pista) {
		laterales.add(pista);
		
	}
}