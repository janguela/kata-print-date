import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author Jordi Anguela (janguela)
 */
public class SysoutMock extends PrintStream {

	private boolean expectPrintln = false;
	private boolean printlnHasBeenCalled = false;

	public SysoutMock(String fileName) throws FileNotFoundException {
		super(fileName);
	}

	@Override
	public void println(Object x) {
		this.printlnHasBeenCalled = true;
	}

	public void expectPrintln() {
		this.expectPrintln = true;
		this.printlnHasBeenCalled = false;
	}

	public boolean printlnHasBeenCalled() {
		return printlnWasExpected() && printlnHasBeenCalled;
	}

	private boolean printlnWasExpected() {
		return this.expectPrintln;
	}

}
