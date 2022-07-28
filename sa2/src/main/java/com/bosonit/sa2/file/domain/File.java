package com.bosonit.sa2.file.domain;

import com.bosonit.sa2.file.infraestructure.dto.FileDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String extension;
    private String path;
    private Date uploadDate;

    public File(FileDto fileDto) {
        setName(fileDto.getName());
        setExtension(fileDto.getExtension());
        setPath(fileDto.getPath());
        setUploadDate(new Date());
    }
}