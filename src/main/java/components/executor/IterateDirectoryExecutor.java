package components.executor;

import components.models.PathInfo;

public interface IterateDirectoryExecutor {
	default Iterable<PathInfo> iterate(PathInfo pathInfo) {
		return iterate(pathInfo.getParentPrefix(), pathInfo.getRegexPart(), pathInfo.getParentPostfix(), pathInfo.getFileName());
	}

	Iterable<PathInfo> iterate(String parentPrefix, String regex, String parentPost, String fileName);
}
