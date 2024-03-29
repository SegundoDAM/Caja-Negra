package guia.objetos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClassWithPropertiesModified06Test {

	@Test
	void testIncrementAmount() {
		int increment=1;
		ClassWithPropertiesModified06 classWithPropertiesModified06=new ClassWithPropertiesModified06();
		int expected=classWithPropertiesModified06.getAmount()+increment;
		classWithPropertiesModified06.incrementAmount(increment);
		assertEquals(expected, classWithPropertiesModified06.getAmount());
	}

}
