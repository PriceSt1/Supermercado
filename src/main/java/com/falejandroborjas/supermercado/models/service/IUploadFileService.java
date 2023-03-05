package com.falejandroborjas.supermercado.models.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

public interface IUploadFileService {

    public Resource load(String filename) throws MalformedURLException;
    public String copy(MultipartFile file) throws IOException;
    public boolean delete(String file);
    public Path getPath(String filename);
    public void deleteAll();
    public void init() throws IOException;
}
