package com.oip.helpdesk.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import com.oip.helpdesk.config.StorageFileNotFoundException;
import com.oip.helpdesk.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("/storage")
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public void serveFile(@PathVariable String filename,HttpServletResponse response) throws IOException {
        Resource file = storageService.loadAsResource(filename);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(file.getInputStream(), response.getOutputStream());
    }

    @PostMapping("/save")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try{
            storageService.store(file);
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        System.out.println("entro pero no encontro");
        return ResponseEntity.notFound().build();
    }

}