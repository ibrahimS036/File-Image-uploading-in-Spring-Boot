package com.uploading.dao;

import org.springframework.web.multipart.MultipartFile;

public interface FileDao {

	public String uplodeImage(String path, MultipartFile file);

}
