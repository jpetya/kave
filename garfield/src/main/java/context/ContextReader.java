package context;

import java.io.IOException;
import java.nio.file.Path;

public interface ContextReader {

	public Boolean checkSecurityToken();
	public Path getFileTransferHome() throws IOException;
	public Boolean isNoSQLEnabled();
	
}
