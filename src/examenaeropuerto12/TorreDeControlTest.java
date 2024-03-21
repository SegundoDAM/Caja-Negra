package examenaeropuerto12;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TorreDeControlTest {
	TorreDeControl torreDeControl;
	double temperatura = 20;
	double viento = 10;
	double lluvia = 10;
	boolean helado = false;
	Condiciones requisitosCondiciones;
	int cantidadPistas = 3;

	@BeforeEach
	void beforeE() {
		// requisitos
		requisitosCondiciones = new Condiciones(temperatura, viento, lluvia, helado);
		// Yo no se como se va a programar. por eso pongo setters y no constructores
		torreDeControl = new TorreDeControl(requisitosCondiciones, cantidadPistas);
		torreDeControl.setRequeridas(requisitosCondiciones);
	}

	@Test
	void testSeleccionarPistaLibre() {
		// al principio debe haber pistas libres.
		// Observa que en el constructor no pongo la pista ni la autorizacion
		Vuelo vuelo = new Vuelo("1", "zafra");
		assertTrue(torreDeControl.seleccionarPistaLibre(vuelo));
		// Será verdad, aqui lo compruebo
		assertNotNull(vuelo.getPistaAsignada());
	}

	@Test
	void testSeleccionarPistaLibreDenegada() {
		/*
		 * Esta es dificil Cuando se deniega una pista? cuando no hay ninguna libre.
		 * Esto depende del numero de pistas del aeropuerto. ¿Cuantas pistas se pueden
		 * ocupar? con 1 pista 1, con 2, 1; con tres: dos (las de ambos lados) con
		 * cuatro, tambien dos. Es lo que llamamos la funcion techo.
		 */
		int cantidadDePistas = torreDeControl.getPistas().size();
		int cantidadDePistasUsablesALaVez = (int) Math.ceil((double) cantidadDePistas / 2);
		Vuelo vuelo;
		int referencia = 1;
		do {
			vuelo = new Vuelo(String.valueOf(referencia++), "zafra");
		} while (torreDeControl.seleccionarPistaLibre(vuelo));
		// una vez llegados aqui el numero de pistas ocupadas debe ser igual a
		// cantidadDePistasUsablesALaVez
		int contadorPistasOcupadas = 0;
		for (Pista pista : torreDeControl.getPistas()) {
			if (pista.isOcupada())
				contadorPistasOcupadas++;
		}
		assertTrue(cantidadDePistasUsablesALaVez == contadorPistasOcupadas);
	}

	@Test
	void testSeleccionarPistaLibreDenegadaMasSencillo() {
		/**
		 * Sin embargo esto es complicado. hagasmoslo de una forma más sencilla
		 */
		Vuelo vuelo;
		int referencia = 1;
		do {
			vuelo = new Vuelo(String.valueOf(referencia++), "zafra");
		} while (torreDeControl.seleccionarPistaLibre(vuelo));
		// cuando llegamos aqui ya no hay pistas libres, o eso dice
		// hay que poner un poco de codigo porque es aleatorio
		for (Pista pista : torreDeControl.getPistas()) {
			if (!pista.isOcupada()) {
				boolean ocupada = false;
				for (Pista lateral : pista.getLaterales()) {
					if (lateral.isOcupada())
						ocupada = true;
				}
				assertTrue(ocupada);
			}
		}
	}

	@Test
	void testAutorizarDespegueAfirmativo() {
		Vuelo vuelo = new Vuelo("1", "zafra");
		// debe tener una pista asignada
		torreDeControl.seleccionarPistaLibre(vuelo);
		assertNotNull(vuelo.getPistaAsignada());
		// ponemos las mismas que las requeridas
		assertTrue(torreDeControl.autorizarDespegue(vuelo, requisitosCondiciones));

	}

	@Test
	void testAutorizarDespegueNegativo() {
		// porque no hay pistas libres
		Vuelo vuelo;
		int referencia = 1;
		do {
			vuelo = new Vuelo(String.valueOf(referencia++), "zafra");
		} while (torreDeControl.seleccionarPistaLibre(vuelo));
		assertNull(vuelo.getPistaAsignada());
		assertFalse(torreDeControl.autorizarDespegue(vuelo, requisitosCondiciones));

	}

	@Test
	void testAutorizarDespegueNegativoPorCondiciones() {
		Vuelo vuelo = new Vuelo("1", "zafra");
		// debe tener una pista asignada
		torreDeControl.seleccionarPistaLibre(vuelo);
		assertNotNull(vuelo.getPistaAsignada());
		Condiciones noAutorizadas = new Condiciones(temperatura - 1, viento, lluvia, helado);
		assertFalse(
				torreDeControl.autorizarDespegue(vuelo, noAutorizadas));/**
																		 * No creo que haga falta comprobar las otras
																		 * porque depende del test de condiciones
																		 */
	}

	@Test
	void testDespegueCompletado() {
		Vuelo vuelo = new Vuelo("1", "zafra");
		// debe tener una pista asignada
		torreDeControl.seleccionarPistaLibre(vuelo);
		assertNotNull(vuelo.getPistaAsignada());
		// ponemos las mismas que las requeridas
		assertTrue(torreDeControl.autorizarDespegue(vuelo, requisitosCondiciones));
		// el vuelo lo tiene todo para poder despegar
		boolean despegar = false;
		do {
			despegar = vuelo.despegar();
			if (despegar) {
				torreDeControl.despegueCompletado(vuelo);
				assertTrue(!vuelo.getPistaAsignada().isOcupada());
			} else {
				vuelo.setDespegueAutorizado(true);
			}
		} while (!despegar);
	}

}
