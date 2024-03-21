package examenaeropuerto12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VueloTest {
	Vuelo vuelo;

	@BeforeEach
	void before() {
		vuelo = new Vuelo("1", "zafra");
	}

	@Test
	void testDespegar() {
		vuelo.setPistaAsignada(new Pista(1, Estado.ocupada));
		vuelo.setDespegueAutorizado(true);
		// el despegue puede ser true o false, es aleatorio
		// intentemoslo diez veces, alguna tiene que salir bien el despegue
		int veces = 10;
		boolean banderaDespegueExitoso = false;
		for (int i = 0; i < veces; i++) {
			if (vuelo.despegar())
				banderaDespegueExitoso = true;
			else {
				vuelo.setDespegueAutorizado(true);
			}
		}
		assertTrue(banderaDespegueExitoso);
	}

	@Test
	void testDespegarSinPista() {
		vuelo.setDespegueAutorizado(false);
		int veces = 10;
		boolean banderaDespegueExitoso = false;
		for (int i = 0; i < veces; i++) {
			if (vuelo.despegar())
				banderaDespegueExitoso = true;
		}
		assertFalse(banderaDespegueExitoso);
	}

	@Test
	void testDespegarConPistaNoAutorizado() {
		vuelo.setPistaAsignada(new Pista(1, Estado.ocupada));
		vuelo.setDespegueAutorizado(false);
		int veces = 10;
		for (int i = 0; i < veces; i++) {
			assertFalse(vuelo.despegar());
		}
	}

}
