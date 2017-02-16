package components.executor;

import components.models.PathInfo;

import java.io.IOException;

public interface CopyExecutor {
	Iterable<String> copy(Iterable<PathInfo> originalPaths, String targetPostFix) throws IOException;
}
