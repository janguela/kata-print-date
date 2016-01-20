import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author Jordi Anguela (janguela)
 */
public class SysoutMock extends PrintStream {

	private boolean expectPrintln = false;
	private boolean printlnHasBeenCalled = false;
	private Object printlnArgument = null;

	public SysoutMock(String fileName) throws FileNotFoundException {
		super(fileName);
	}

	@Override
	public void println(Object x) {
		this.printlnHasBeenCalled = true;
		this.printlnArgument = x;
	}

	public void expectPrintln() {
		this.expectPrintln = true;
		this.printlnHasBeenCalled = false;
		this.printlnArgument = null;
	}

	public boolean printlnHasBeenCalled() {
		return printlnWasExpected() && printlnHasBeenCalled;
	}

	public boolean printlnHasBeenCalledWith(Object expectedArgument) {
		return printlnHasBeenCalled() && expectedArgument.equals(printlnArgument);
	}

	private boolean printlnWasExpected() {
		return this.expectPrintln;
	}

}
