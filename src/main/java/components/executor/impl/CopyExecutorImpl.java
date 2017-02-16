package components.executor.impl;

import components.executor.CopyExecutor;
import components.models.PathInfo;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Component
public class CopyExecutorImpl implements CopyExecutor {
	@Override
	public Iterable<String> copy(Iterable<PathInfo> originalPaths, String targetPostFix) throws IOException {
		List<String> regexParts = new ArrayList<>();
		for(PathInfo pathInfo : originalPaths) {
			PathInfo targetPathInfo = pathInfo.changeParentPostfix(targetPostFix);
			File targetDirectory = new File(targetPathInfo.getParentDirectory());
			if(!targetDirectory.exists()) {
				targetDirectory.mkdir();
			} else if(!targetDirectory.isDirectory()) {
				throw new RuntimeException("Already exists! but not a directory! : " + targetDirectory.getAbsolutePath());
			}
			Files.copy(pathInfo.toPath(), targetPathInfo.toPath());
			regexParts.add(pathInfo.getRegexPart());
		}
		return regexParts;
	}
}
