package com.ing.suiteapi.service;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class GithubClient {
	private final RestTemplate restTemplate;
	private final ResourceLoader resourceLoader;

	public GithubClient(RestTemplate restTemplate,
						ResourceLoader resourceLoader) {
		this.restTemplate = restTemplate;
		this.resourceLoader = resourceLoader;
	}

	public String getCucumberReportAsJson() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://raw.githubusercontent.com/omernaci/bdd-testsuite-demo/master/reports/CucumberTestReport.json";
		String reportContent = restTemplate.getForObject(url, String.class);
		String root = System.getProperty("user.dir");
		String filePath = "/src/main/resources/cucumber.json";
		String resourceFolderPath = root + filePath;

		try {
			Path path = Paths.get(resourceFolderPath);
			Files.write(path, reportContent.getBytes());
			System.out.println("Report content saved to file: " + resourceFolderPath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return restTemplate.getForObject(url, String.class);
	}

}
