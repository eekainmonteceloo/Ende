package formhtml;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class formhtml extends Formatter {

	@Override
	public String format(LogRecord record) {
		return "<p>"+record.getMessage()+"</p>\n";
	}
	@Override
    public String getHead(Handler h) {
        return "<HTML>\n";
    }
	@Override
    public String getTail(Handler h) {
        return "</HTML>\n";
    }
}
