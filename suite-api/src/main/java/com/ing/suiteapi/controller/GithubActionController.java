package com.ing.suiteapi.controller;

import com.ing.suiteapi.service.GithubActionClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GithubActionController {

	private final GithubActionClient githubActionClient;

	public GithubActionController(GithubActionClient githubActionClient) {
		this.githubActionClient = githubActionClient;
	}

	@GetMapping("/github/artifacts")
	public String getGithubArtifacts() throws IOException {
		return githubActionClient.getGithubArtifacts();
	}
}