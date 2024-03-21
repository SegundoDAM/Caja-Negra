package examenaeropuerto12;

import java.util.ArrayList;

public class TorreDeControl {
    private ArrayList<Pista> pistas;
    private Condiciones requeridas;

    public boolean seleccionarPistaLibre(Vuelo vuelo) {
        for (Pista pista : pistas) {
        	//minima sorpresa violation hace dos cosas
        	//mira si esta ocupada o si lo estan las laterales
            if (!pista.isOcupada()) {
                vuelo.setPistaAsignada(pista);
                return true;
            }
        }
        return false;
    }

    public TorreDeControl(Condiciones requeridas, int cantidadPistas) {
		super();
		this.requeridas = requeridas;
		generarPistas(cantidadPistas);
	}

	private void generarPistas(int cantidadPistas) {
		pistas=new ArrayList<>();
		for (int i = 1; i < cantidadPistas+1; i++) {
			pistas.add(new Pista(i, Estado.libre));
		}
		for (int i = 0; i < pistas.size(); i++) {
			//anteriores
			if(i>0) {
				pistas.get(i).addLateral(pistas.get(i-1));
			}
			//posteriores
			if(i<pistas.size()-1){
				pistas.get(i).addLateral(pistas.get(i+1));
			}
		}
	}

	public ArrayList<Pista> getPistas() {
		return pistas;
	}

	public void setPistas(ArrayList<Pista> pistas) {
		this.pistas = pistas;
	}

	public Condiciones getRequeridas() {
		return requeridas;
	}

	public void setRequeridas(Condiciones requeridas) {
		this.requeridas = requeridas;
	}

	public boolean autorizarDespegue(Vuelo vuelo, Condiciones condicionesActuales) {
        if (vuelo.getPistaAsignada() != null && requeridas.validate(condicionesActuales)) {
            vuelo.setDespegueAutorizado(true);
            return true;
        }
        return false;
    }

    public void despegueCompletado(Vuelo vuelo) {
        vuelo.getPistaAsignada().setEstado(Estado.libre);
    }
}
