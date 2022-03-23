package com.chadli05.shop.backend.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    public void init();
    public void save(MultipartFile file, String suffixName);
    public Resource load(String fileName);
    public void deleteAll();
    public Stream<Path> loadAll();
    
}
