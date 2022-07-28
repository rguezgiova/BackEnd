package com.bosonit.sa2.file.infraestructure.dto;

import com.bosonit.sa2.file.domain.File;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class FileDto {
    private long id;
    private String name;
    private String extension;
    private String path;
    private Date uploadDate;

    public FileDto(File file) {
        setId(file.getId());
        setName(file.getName());
        setExtension(file.getExtension());
        setPath(file.getPath());
        setUploadDate(file.getUploadDate());
    }

    public FileDto(String name, String extension, String path) {
        setName(name);
        setExtension(extension);
        setPath(path);
    }
}