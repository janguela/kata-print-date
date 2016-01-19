import java.io.PrintStream;

import org.junit.Test;

/**
 * @author Jordi Anguela (janguela)
 */
public class PrintDateTest {

	@Test
	public void printDate() throws Exception {
		PrintStream printStream = System.out;
		PrintDate printDate = new PrintDate(printStream);
		printDate.printCurrentDate();
		// How can we test this function?
	}
}