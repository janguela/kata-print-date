import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

/**
 * @author Jordi Anguela (janguela)
 */
public class PrintDateTest {

	@Test
	public void printDate_prints_current_date_tested_with_stub() throws Exception {
		SysoutStub printStream = new SysoutStub("tmp/tmp.txt");
		PrintDate printDate = new PrintDate(printStream);
		printDate.printCurrentDate();

		Date printedDate = (Date) printStream.lastPrintedObject();
		Date now = new Date();
		assertTrue(now.equals(printedDate));
	}
}