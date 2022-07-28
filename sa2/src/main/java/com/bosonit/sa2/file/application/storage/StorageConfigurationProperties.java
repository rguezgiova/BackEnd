package com.bosonit.sa2.file.application.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.File;

@ConfigurationProperties("storage")
public class StorageConfigurationProperties {
    private String path = ".\\files\\";
    File folder = new File(path);

    public String getPath() {
        if (!folder.exists()) {
            folder.mkdir();
            return path;
        }
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}