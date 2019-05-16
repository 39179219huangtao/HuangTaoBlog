package com.yijiupi.bi.kit;

import java.io.File;
import java.io.IOException;

public class FileKit {

	public static void createFile(File file) throws IOException {
		if (!file.exists()) {
			File targetDir = file.getParentFile();
			targetDir.mkdirs();
			file.createNewFile();
		}
	}
	
}
