import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class BlackBoxTest2Template {

	@Test
	void test() {
		/* Colors: YELLOW, GREEN, RED */ 
		Color expected = Color.YELLOW;
		int x = 5;
		int y = 1;
		boolean b = false;
		Color actual = BlackBox2.F(x, y, b);
		assertEquals(expected, actual);


	}


	@Test
	void green_10_minus2_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = Color.GREEN;
		int x = 10;
		int y = -2;
		boolean b = false;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");

	}

	@Test
	void yellow_10_0_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = Color.YELLOW;
		int x = 10;
		int y = 0;
		boolean b = true;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}


	@Test
	void red_2_1_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = Color.RED;
		int x = 2;
		int y = 1;
		boolean b = true;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}


	@Test
	void yellow_10_2_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = Color.YELLOW;
		int x = 10;
		int y = 2;
		boolean b = true;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}

	@Test
	void green_10_2_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = Color.GREEN;
		int x = 10;
		int y = 2;
		boolean b = false;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}

	@Test
	void null_17_3_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 17;
		int y = 3;
		boolean b = true;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}

	@Test
	void null_17_3_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 17;
		int y = 3;
		boolean b = false;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}


	@Test
	void yellow_5_m1_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = Color.YELLOW;
		int x = 5;
		int y = -1;
		boolean b = true;
		Color actual = BlackBox2.F(x, y, b);
		assertEquals(expected, actual);
	}

	@Test
	void yellow_5_minus1_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = Color.YELLOW;
		int x = 5;
		int y = -1;
		boolean b = false;
		Color actual = BlackBox2.F(x, y, b);
		assertEquals(expected, actual);
	}


	@Test
	void null_0_1_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 0;
		int y = 1;
		boolean b = true;
		Color actual = BlackBox2.F(x, y, b);
		assertEquals(expected, actual);
	}

	@Test
	void null_0_1_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 0;
		int y = 1;
		boolean b = false;
		Color actual = BlackBox2.F(x, y, b);
		assertEquals(expected, actual);
	}

	@Test
	void null_10_3_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 15;
		int y = 3;
		boolean b = true;
		Color actual = BlackBox2.F(x, y, b);
		assertEquals(expected, actual);
	}

	@Test
	void null_10_minus3_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 10;
		int y = -3;
		boolean b = true;
		Color actual = BlackBox2.F(x, y, b);
		assertEquals(expected, actual);
	}

	@Test
	void null_10_minus3_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 10;
		int y = -3;
		boolean b = false;
		Color actual = BlackBox2.F(x, y, b);
		assertEquals(expected, actual);
	}

	@Test
	void null_9_3_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 9;
		int y = 3;
		boolean b = true;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}

	// :: x = RED, y =  UÄq_y2

	@Test
	void null_9_3_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 9;
		int y = 3;
		boolean b = false;
		Color actual = BlackBox2.F(x, y, b);
		assertEquals(expected, actual);
	}

	// :: x = RED, y =  UÄq_y1

	@Test
	void null_9_minus3_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 9;
		int y = -3;
		boolean b = true;
		Color actual = BlackBox2.F(x, y, b);
		assertEquals(expected, actual);
	}

	@Test
	void null_9_minus3_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 9;
		int y = -3;
		boolean b = false;
		Color actual = BlackBox2.F(x, y, b);
		assertEquals(expected, actual);
	}

	// :: x = ÜAqx2 , y = RED

	@Test
	void null_17_1_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 17;
		int y = 1;
		boolean b = true;
		Color actual = BlackBox2.F(x, y, b);
		assertEquals(expected, actual);
	}

	// :: x = ÜAqx2 , y = YELLOW

	@Test
	void null_17_1_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 17;
		int y = 1;
		boolean b = false;
		Color actual = BlackBox2.F(x, y, b);
		assertEquals(expected, actual);
	}

	@Test
	void null_17_minus1_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 17;
		int y = -1;
		boolean b = false;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}

	@Test
	void null_17_minus1_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 17;
		int y = -1;
		boolean b = true;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}

	@Test
	void null_10_3_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 10;
		int y = 3;
		boolean b = false;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}

	@Test
	void null_1_3_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 1;
		int y = 3;
		boolean b = false;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}

	@Test
	void null_1_minus3_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 1;
		int y = -3;
		boolean b = true;
		Color actual = BlackBox2.F(x, y, b);
		//System.out.println(actual);
		assertEquals(expected, actual);
	}

	@Test
	void null_0_0_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 0;
		int y = 0;
		boolean b = false;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}


	@Test
	void null_0_0_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 0;
		int y = 0;
		boolean b = true;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}

	@Test
	void null_minINT_maxINT_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = MIN_VALUE;
		int y = MAX_VALUE;
		boolean b = true;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}

	@Test
	void null_17_minus3_true() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 17;
		int y = -3;
		boolean b = true;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}

	@Test
	void null_17_minus3_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 17;
		int y = -3;
		boolean b = false;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}

	@Test
	void null_0_minus3_false() {
		/* Colors: YELLOW, GREEN, RED */
		Color expected = null;
		int x = 0;
		int y = -3;
		boolean b = false;
		Color actual = BlackBox2.F(x,y,b);
		//System.out.println(actual);
		assertEquals(expected, actual);
		//fail("not implemented yet");
	}




















	// ------- DO NOT TOUCH BELOW THIS LINE -------
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		assertTrue(BlackBox2.evalEqClasses(), "Not all equivalence classes covert!");
	}

}
