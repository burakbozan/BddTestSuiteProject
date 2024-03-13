package com.ing.suiteapi.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
@Component
public class HtmlReader {

    private final ResourceLoader resourceLoader;

    public HtmlReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public String readHtmlFile() {
        try {
            // Dosyayı yükleyin
            Resource resource = resourceLoader.getResource("classpath:htmlResult.txt");
            
            // Dosyadan InputStream alın
            InputStream inputStream = resource.getInputStream();
            
            // InputStream'den veriyi okuyun ve String'e dönüştürün
            byte[] fileBytes = FileCopyUtils.copyToByteArray(inputStream);
            String fileContent = new String(fileBytes, StandardCharsets.UTF_8);
            
            return fileContent;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}