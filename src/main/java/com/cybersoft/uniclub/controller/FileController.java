package com.cybersoft.uniclub.controller;

import com.cybersoft.uniclub.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileServiceImp fileServiceImp;

    @GetMapping("/{name:.+}")
    @CrossOrigin
    public ResponseEntity<?> getFile(@PathVariable String name) {
        Resource resource = fileServiceImp.load(name);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + name + "\"").body(resource);

    }

}
