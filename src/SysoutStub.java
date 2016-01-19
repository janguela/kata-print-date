import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author Jordi Anguela (janguela)
 */
public class SysoutStub extends PrintStream {

	Object printedObject;

	public SysoutStub(String fileName) throws FileNotFoundException {
		super(fileName);
	}

	@Override
	public void println(Object x) {
		printedObject = x;
	}

	public Object lastPrintedObject() {
		return printedObject;
	}

}
