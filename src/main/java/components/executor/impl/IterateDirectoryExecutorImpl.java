package components.executor.impl;

import components.executor.IterateDirectoryExecutor;
import components.models.PathInfo;
import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class IterateDirectoryExecutorImpl implements IterateDirectoryExecutor {
	@Override
	public Iterable<PathInfo> iterate(String parentPrefix, String regex, String parentPost, String fileName) {
		List<PathInfo> resultList = new ArrayList<>();
		File parentPreDirectory = new File(parentPrefix);
		if (!parentPreDirectory.exists()) {
			throw new RuntimeException(parentPrefix + " does not exist.");
		} else if (!parentPreDirectory.isDirectory()) {
			throw new RuntimeException(parentPrefix + " seems not to be a directory.");
		}

		File[] preChild = parentPreDirectory.listFiles();
		Pattern regexPattern = Pattern.compile(regex);

		for (File file : preChild) {
			Matcher matcher = regexPattern.matcher(file.getName());
			if(matcher.matches() && file.isDirectory()) {
				File innerFile = new File(file.getAbsolutePath(), parentPost);
				if(innerFile.exists() && innerFile.isDirectory()) {
					File targetFile = new File(innerFile.getAbsolutePath(), fileName);
					if(targetFile.exists() && targetFile.isFile()) {
						resultList.add(new PathInfo(parentPrefix, file.getName(), parentPost, fileName));
					}
				}
			}
		}

		return resultList;
	}
}
