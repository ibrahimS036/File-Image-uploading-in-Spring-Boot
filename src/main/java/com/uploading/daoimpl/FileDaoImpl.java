package com.uploading.daoimpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.uploading.dao.FileDao;

@Service
public class FileDaoImpl implements FileDao {

	@Override
	public String uplodeImage(String path, MultipartFile file) {
		// File name
		String originalFilename = file.getOriginalFilename();

		// for creating a new random id for every image/file
		String randomID = UUID.randomUUID().toString();
		String newRandom = randomID.concat(originalFilename.substring(originalFilename.lastIndexOf(".")));

		// Full path
		String filePath = path + File.separator + newRandom;

		// Create folder if not created

		File file2 = new File(path);
		if (!file2.exists()) {
			file2.mkdir();
		}
		// File copy

		try {
			Files.copy(file.getInputStream(), Paths.get(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return originalFilename;

	}

}
