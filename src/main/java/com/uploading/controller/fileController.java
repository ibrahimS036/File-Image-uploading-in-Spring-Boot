package com.uploading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.uploading.daoimpl.FileDaoImpl;
import com.uploading.paylode.FileResponse;

@RestController
@RequestMapping("/file")
public class fileController {

	@Autowired
	private FileDaoImpl service;

	@Value("${project.image}")
	private String path;

	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUplode(@RequestParam("image") MultipartFile image) {
		String fileName = this.service.uplodeImage(path, image);
		return new ResponseEntity<>(new FileResponse(fileName, "Image Successfully Uploaded!"), HttpStatus.OK);
	}

}
