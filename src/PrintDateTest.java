import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

/**
 * @author Jordi Anguela (janguela)
 */
public class PrintDateTest {

	@Test
	public void printDate_prints_current_date_tested_with_stub() throws Exception {
		// 1. setup - Prepare object that is being tested and its stubs
		// collaborators
		SysoutStub printStream = new SysoutStub("tmp/tmp.txt");
		PrintDate printDate = new PrintDate(printStream);

		// 2. exercise
		printDate.printCurrentDate();

		// 3. verify state
		Date printedDate = (Date) printStream.lastPrintedObject();
		Date now = new Date();
		assertTrue(now.equals(printedDate));

		// 4. teardown
		printStream.close();
	}

	@Test
	public void printDate_prints_current_date_tested_with_mock() throws Exception {
		// 1. setup data - Prepare object that is being tested
		SysoutMock printStream = new SysoutMock("tmp/tmp.txt");
		PrintDate printDate = new PrintDate(printStream);

		// 2. setup expectations - Prepare expectations in mock that is being
		// used by primary object.
		printStream.expectPrintln();

		// 3. exercise
		printDate.printCurrentDate();

		// 4. verify expectations - Verify that correct methods has been invoked
		// in mock
		Date now = new Date();
		assertTrue(printStream.printlnHasBeenCalledWith(now));

		// 5. verify state

		// 6. teardown
		printStream.close();
	}
}