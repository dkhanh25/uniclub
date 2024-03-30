package com.cybersoft.uniclub.service.imp;

import org.springframework.web.multipart.MultipartFile;

public interface FileServiceImp {
    void saveFile(MultipartFile file);
}
