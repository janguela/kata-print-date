import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.util.Date;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

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

	@Test
	public void printDate_prints_current_date_tested_with_mockito() throws Exception {
		// 1. setup data - Prepare object that is being tested
		PrintStream mockedPrintStream = mock(java.io.PrintStream.class);
		PrintDate printDate = new PrintDate(mockedPrintStream);

		// 2. setup expectations - Prepare expectations in mock that is being
		// used by primary object.

		// 3. exercise
		printDate.printCurrentDate();

		// 4. verify expectations - Verify that correct methods has been invoked
		// in mock
		ArgumentCaptor<Date> argument = ArgumentCaptor.forClass(Date.class);
		Date now = new Date();
		verify(mockedPrintStream).println(argument.capture());
		Date printedDate = argument.getValue();
		assertLessThanTwoSeconds(now, printedDate);

		// 5. verify state

		// 6. teardown
		mockedPrintStream.close();
	}

	private void assertLessThanTwoSeconds(Date first, Date second) {
		long nowInMillis = first.getTime() / 2000;
		long argumentInMillis = second.getTime() / 2000;
		assertEquals(nowInMillis, argumentInMillis);
	}

}