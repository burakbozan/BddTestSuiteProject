package com.ing.suiteapi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.suiteapi.util.Base64Utils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class GithubActionClient {
	private final RestTemplate restTemplate;
	private final ResourceLoader resourceLoader;

	public GithubActionClient(RestTemplate restTemplate,
							  ResourceLoader resourceLoader) {
		this.restTemplate = restTemplate;
		this.resourceLoader = resourceLoader;
	}

	public String getGithubArtifacts() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/vnd.github+json");
		headers.set("Authorization", "Bearer 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");
		headers.set("X-GitHub-Api-Version", "2022-11-28");

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);


		ResponseEntity<String> response = restTemplate.exchange(
				"https://api.github.com/repos/omernaci/bdd-testsuite-demo/actions/artifacts",
				HttpMethod.GET,
				entity,
				String.class
		);

		List<String> artifactIdList = getArtifactDownloadUrls(response.getBody());
		String fileContent = getGithubArtifactsWithRestTemplate(artifactIdList.get(0));
		System.out.println(fileContent);

		return response.getBody();
	}

	public List<String> getArtifactDownloadUrls(String body) throws IOException {
		List<String> artifactIdList = new ArrayList<>();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(body);

		JsonNode artifactsNode = jsonNode.get("artifacts");
		for (JsonNode artifactNode : artifactsNode) {
			artifactIdList.add(artifactNode.get("id").asText());
		}

		return artifactIdList;
	}

	public String getGithubArtifactsWithRestTemplate(String artifactId) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/vnd.github+json");
		headers.set("Authorization", "Bearer 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");
		headers.set("X-GitHub-Api-Version", "2022-11-28");

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		ResponseEntity<String> response = restTemplate.exchange(
				"https://api.github.com/repos/omernaci/bdd-testsuite-demo/actions/artifacts/" + artifactId + "/zip",
				HttpMethod.GET,
				entity,
				String.class
		);

		String root = System.getProperty("user.dir");
		String filePath = "/src/main/resources/cucumber.json";
		String resourceFolderPath = root + filePath;
		byte[] zipBytes = response.getBody().getBytes(StandardCharsets.UTF_8);

		ByteArrayInputStream bais = new ByteArrayInputStream(zipBytes);

		ZipInputStream zis = new ZipInputStream(bais);
/*
		ZipEntry entry;
		while ((entry = zis.getNextEntry()) != null) {
			// Create a file for each entry and write the content to the file in the resource folder
			File outFile = new File(resourceFolderPath, entry.getName());
			FileCopyUtils.copy(zis, new FileOutputStream(outFile));
		}
*/
		ZipEntry entry;
		while ((entry = zis.getNextEntry()) != null) {
			File outFile = new File(resourceFolderPath + entry.getName());
			FileOutputStream fos = new FileOutputStream(outFile);
			IOUtils.copy(zis, fos);
			fos.close();
		}

		zis.close();


		return null;
	}

}
