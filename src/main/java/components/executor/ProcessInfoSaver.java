package components.executor;

import java.io.IOException;

public interface ProcessInfoSaver {
	void saveLogs(Iterable<String> logs) throws IOException ;
}
