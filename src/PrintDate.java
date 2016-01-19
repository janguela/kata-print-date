import java.io.PrintStream;
import java.util.Date;

/**
 * print-date kata
 * 
 * @author Jordi Anguela (janguela)
 */
public class PrintDate {
	PrintStream printStream;

	public PrintDate(PrintStream printStream) {
		this.printStream = printStream;
	}

	public void printCurrentDate() {
		printStream.println(new Date());
	}
}