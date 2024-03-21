package examenaeropuerto12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CondicionesTest {

	@Test
	void testValidate() {
		//requisitos
		 double temperatura=20;
		 double viento=10;
		 double lluvia=10;
		 boolean helado=false;
		 Condiciones requisitosCondiciones=new Condiciones(temperatura, viento, lluvia, helado);
		 //vamos poniendo las diferentes posibilidades (una a una)
		 //iguales a las requeridas
		 temperatura=20;
		 viento=10;
		 lluvia=10;
		 helado=false;
		 assertTrue(requisitosCondiciones.validate(new Condiciones(temperatura, viento, lluvia, helado)));
		 //no cumple temperatura
		 temperatura=19;
		 viento=10;
		 lluvia=11;
		 helado=false;
		 assertFalse(requisitosCondiciones.validate(new Condiciones(temperatura, viento, lluvia, helado)));
		 //no cumple lluvia
		 temperatura=20;
		 viento=9;
		 lluvia=11;
		 helado=false;
		 assertFalse(requisitosCondiciones.validate(new Condiciones(temperatura, viento, lluvia, helado)));
		 //no cumple helado
		 temperatura=20;
		 viento=10;
		 lluvia=10;
		 helado=true;
		 assertFalse(requisitosCondiciones.validate(new Condiciones(temperatura, viento, lluvia, helado)));
		 //no cumple viento 
		 temperatura=20;
		 viento=12;
		 lluvia=10;
		 helado=false;
		 assertFalse(requisitosCondiciones.validate(new Condiciones(temperatura, viento, lluvia, helado)));
		 //cumple viento 10% 
		 temperatura=20;
		 viento=11;
		 lluvia=10;
		 helado=false;
		 assertTrue(requisitosCondiciones.validate(new Condiciones(temperatura, viento, lluvia, helado)));
	}

}
