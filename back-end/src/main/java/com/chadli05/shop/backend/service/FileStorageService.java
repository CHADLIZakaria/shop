package com.chadli05.shop.backend.service;

import java.io.IOException;
import java.util.Optional;

import com.chadli05.shop.backend.model.FileDB;
import com.chadli05.shop.backend.repository.FileDBRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    @Autowired
    private FileDBRepository fileDBRepository;

    public FileDB store(MultipartFile  file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB fileDB = new FileDB(null, fileName, file.getContentType(), file.getBytes());
        return fileDBRepository.save(fileDB);
    }

    public FileDB getFile(Long id){
        return fileDBRepository.findById(id).get();
    }
}
