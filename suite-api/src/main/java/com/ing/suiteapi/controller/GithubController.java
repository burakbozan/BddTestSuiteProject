package com.ing.suiteapi.controller;

import com.ing.suiteapi.service.GithubClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/github/")
public class GithubController {

	private final GithubClient githubActionClient;

	public GithubController(GithubClient githubActionClient) {
		this.githubActionClient = githubActionClient;
	}

	@GetMapping("/reports")
	public String getGithubArtifacts() throws IOException {
		return githubActionClient.getCucumberReportAsJson();
	}

	@GetMapping("/reports/html")
	public String getGithubFile() throws IOException {
		return githubActionClient.getCucumberReportAsHtml();
	}

}