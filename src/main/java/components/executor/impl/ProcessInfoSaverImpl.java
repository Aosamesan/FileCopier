package components.executor.impl;

import components.executor.ProcessInfoSaver;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;

@Component
public class ProcessInfoSaverImpl implements ProcessInfoSaver {
	@Resource(name = "logFileName")
	private String logFileName;

	@Override
	public void saveLogs(Iterable<String> logs) throws IOException {
		File logFile = new File(logFileName);
		if(!logFile.exists()) {
			logFile.createNewFile();
		}

		PrintStream printStream = new PrintStream(logFile);
		for(String log : logs) {
			printStream.println(log);
		}
		printStream.close();
	}
}
