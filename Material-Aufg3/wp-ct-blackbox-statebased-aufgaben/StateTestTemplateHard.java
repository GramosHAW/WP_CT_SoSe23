import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class StateTestTemplateHard {

	@Test
	void test() {
		SbHard3.start(); // (re-) starting the SbHard3
		SbHard3.getStateName(); // returns the name of the current state
		SbHard3.getStateEvents(); // returns a Set of all permitted events of the current state
		SbHard3.transition("a"); // transition the current state with the given event
		SbHard3.transition("b"); // transition the current state with the given event
		String stateName = SbHard3.getStateName();
		assertEquals("S3", stateName);
	}

	@Test
	void test01() {

		SbHard3.start(); // (re-) starting the SbHard3
		SbHard3.getStateName(); // returns the name of the current state
		SbHard3.getStateEvents(); // returns a Set of all permitted events of the current state
		SbHard3.transition("c"); // transition the current state with the given event
		SbHard3.transition("b"); // transition the current state with the given event
		SbHard3.transition("c"); // transition the current state with the given event
		SbHard3.transition("a"); // transition the current state with the given event
		String stateName = SbHard3.getStateName();
		assertEquals("Final", stateName);
	}

	@Test
	void test02() {
		SbHard3.start(); // (re-) starting the SbHard3
		SbHard3.getStateName(); // returns the name of the current state
		SbHard3.getStateEvents(); // returns a Set of all permitted events of the current state
		SbHard3.transition("e"); // transition the current state with the given event
		SbHard3.transition("d"); // transition the current state with the given event
		SbHard3.transition("d"); // transition the current state with the given event
		SbHard3.transition("a"); // transition the current state with the given event
		SbHard3.transition("c"); // transition the current state with the given event
		String stateName = SbHard3.getStateName();
		assertEquals("S5", stateName);
	}



	// ------- DO NOT TOUCH BELOW THIS LINE -------
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		assertTrue(SbHard3.evalCoverage(), "There are states or transitions left to cover!");

	}
	
}