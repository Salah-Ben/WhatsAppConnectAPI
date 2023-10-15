package com.example.demo.dto;

import org.springframework.core.io.ByteArrayResource;

public class FileResource extends ByteArrayResource {
    private String fileName;
        @Override
        public String getFilename() {
            return fileName;
        }
    public FileResource(byte[] byteArray, String fileName) {
        super(byteArray);
        this.fileName = fileName;
    }
}
