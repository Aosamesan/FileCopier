package components.controllers;

import components.executor.CopyExecutor;
import components.executor.IterateDirectoryExecutor;
import components.executor.ProcessInfoSaver;
import components.models.PathInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CopyController {
	@Autowired
	CopyExecutor copyExecutor;

	@Autowired
	IterateDirectoryExecutor iterateDirectoryExecutor;

	@Autowired
	ProcessInfoSaver processInfoSaver;

	public void execute(PathInfo pathInfo, String targetPostfix) throws IOException {
		Iterable<PathInfo> originPaths = iterateDirectoryExecutor.iterate(pathInfo);
		Iterable<String> processed = copyExecutor.copy(originPaths, targetPostfix);
		processInfoSaver.saveLogs(processed);
	}
}
