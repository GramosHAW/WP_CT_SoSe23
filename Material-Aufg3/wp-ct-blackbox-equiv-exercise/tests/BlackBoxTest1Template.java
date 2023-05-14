import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class BlackBoxTest1Template {

	@Test
	void test() {
		/* Colors: YELLOW, GREEN, RED */ 
		Color expected = Color.YELLOW;
		int x = 5;
		int y = 1;
		boolean b = false;
		Color actual = BlackBox1.G(x, y);
		assertEquals(expected, actual);
		fail("not implemented yet");
	}



	
	
	// ------- DO NOT TOUCH BELOW THIS LINE -------
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		assertTrue(BlackBox1.evalEqClasses(), "Not all equivalence classes covert!");
	}

}
