package com.avast.example.android.github.api;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * @author Tomáš Kypta (kypta)
 */
public class ApiFactory {

    private static final String GITHUB_API_URL = "https://api.github.com";

    public static GitHubApi createGitHubApi() {
        RestAdapter adapter = new RestAdapter.Builder()
            .setEndpoint(GITHUB_API_URL)
            .setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader("Accept", "application/vnd.github.v3+json");
                }
            })
            .setLogLevel(RestAdapter.LogLevel.BASIC)
            .build();

        return adapter.create(GitHubApi.class);
    }
}
