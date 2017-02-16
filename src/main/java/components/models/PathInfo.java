package components.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.nio.file.Path;
import java.nio.file.Paths;

@Data
@AllArgsConstructor
public class PathInfo {
	private String parentPrefix;
	private String regexPart;
	private String parentPostfix;
	private String fileName;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(parentPrefix);
		builder.append("/");
		builder.append(regexPart);
		builder.append("/");
		builder.append(parentPostfix);
		builder.append("/");
		builder.append(fileName);
		return builder.toString();
	}

	public PathInfo changeParentPostfix(String newPostfix) {
		return new PathInfo(parentPrefix, regexPart, newPostfix, fileName);
	}

	public Path toPath() {
		return Paths.get(parentPrefix, regexPart, parentPostfix, fileName);
	}

	public String getParentDirectory() {
		return parentPrefix + "/" + regexPart + "/" + parentPostfix;
	}
}
