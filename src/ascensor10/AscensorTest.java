package ascensor10;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AscensorTest {
	Ascensor ascensor;
	int plantaSolicitada;
	int[] plantasExpected;

	@BeforeEach
	void setUp() throws Exception {
		ascensor = new Ascensor();
	}

	@Test
	void testSolicitarPlanta() {
		// siempre subiendo
		// supongo que planta actual 0
		ascensor.setPlantaActual(0);
		ascensor.setEstado(Estado.subiendo);
		plantaSolicitada = 5;
		plantasExpected = new int[] { 5 };
		// comienzo la prueba
		ascensor.solicitarPlanta(plantaSolicitada);
		// compruebo
		assertEquals(ascensor.getPlantasSolicitadas(), Arrays.asList(plantasExpected));
		plantaSolicitada = 9;
		plantasExpected = new int[] { 5, 9 };
		ascensor.solicitarPlanta(plantaSolicitada);
		assertEquals(ascensor.getPlantasSolicitadas(), Arrays.asList(plantasExpected));
		plantaSolicitada = 7;
		ascensor.solicitarPlanta(plantaSolicitada);
		plantasExpected = new int[] { 5, 7, 9 };
	}

	@Test
	void testSolicitarPlantaDos() {
		// decidir entre seguir subiendo o bajar
		plantaSolicitada = 7;
		ascensor.setPlantaActual(5);
		ascensor.setEstado(Estado.subiendo);
		ascensor.solicitarPlanta(plantaSolicitada);
		plantasExpected = new int[] { 7 };
		assertEquals(ascensor.getPlantasSolicitadas(), Arrays.asList(plantasExpected));
		plantaSolicitada = 4;
		plantasExpected = new int[] { 7, 4 };
		ascensor.solicitarPlanta(plantaSolicitada);
		assertEquals(ascensor.getPlantasSolicitadas(), Arrays.asList(plantasExpected));
		plantaSolicitada = 8;
		plantasExpected = new int[] { 7, 8, 4 };
		ascensor.solicitarPlanta(plantaSolicitada);
		assertEquals(ascensor.getPlantasSolicitadas(), Arrays.asList(plantasExpected));
		plantaSolicitada = 3;
		plantasExpected = new int[] { 7, 8, 4, 3 };
		ascensor.solicitarPlanta(plantaSolicitada);
		assertEquals(ascensor.getPlantasSolicitadas(), Arrays.asList(plantasExpected));
	}

	@Test
	void testSolicitarPlantaTres() {
		ascensor.setPlantaActual(8);
		ascensor.setEstado(Estado.bajando);
		plantaSolicitada = 4;
		ascensor.solicitarPlanta(plantaSolicitada);
		plantasExpected = new int[] {4};
		assertEquals(ascensor.getPlantasSolicitadas(), Arrays.asList(plantasExpected));
		assertTrue(ascensor.getPlantasSolicitadas().equals(Arrays.asList(plantasExpected)));
		plantaSolicitada = 3;
		ascensor.solicitarPlanta(plantaSolicitada);
		plantasExpected = new int[] {4,3};
		assertEquals(ascensor.getPlantasSolicitadas(), Arrays.asList(plantasExpected));
		plantaSolicitada = 9;
		ascensor.solicitarPlanta(plantaSolicitada);
		plantasExpected = new int[] {4,3,9};
		assertEquals(ascensor.getPlantasSolicitadas(), Arrays.asList(plantasExpected));
	}
	@Test
	void testSeguirRuta() {
		ascensor.setPlantaActual(0);
		ascensor.setEstado(Estado.subiendo);
		ArrayList<Integer> lista=new ArrayList();
		lista.add(5);
		lista.add(7);
		lista.add(9);
		lista.add(4);
		ascensor.setPlantasSolicitadas(lista);
		//estoy en la cinco
		assertEquals(ascensor.seguirRuta(),lista.get(0));
		lista.remove(0);
		assertEquals(ascensor.getPlantasSolicitadas(), lista);
		//estoy en la siete
		assertEquals(ascensor.seguirRuta(),lista.get(0));
		lista.remove(0);
		assertEquals(ascensor.getPlantasSolicitadas(), lista);
		//estoy en la nueve
		assertEquals(ascensor.seguirRuta(),lista.get(0));
		lista.remove(0);
		assertEquals(ascensor.getPlantasSolicitadas(), lista);
		assertEquals(ascensor.getEstado(),Estado.bajando);
	}

}
