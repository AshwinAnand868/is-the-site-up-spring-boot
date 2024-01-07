package io.javarefresh.isthesiteup.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlCheckController {

    private final String SITE_IS_UP = "Site is up!";
    private final String SITE_IS_DOWN = "Site is down!";
    private final String INCORRECT_URL = "Url is incorrect!";

    @GetMapping("/check")
    public String getUrlStatusMessage(@RequestParam String url) {
        String returnMessage = "";

        try {
            URL urlObj = new URI(url).toURL();
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            // connection is open
            conn.setRequestMethod("GET");

            // connect to the website
            conn.connect();

            int responseCodeCategory = conn.getResponseCode() / 100;
            // connection successful, checking the response code
            if (responseCodeCategory != 2 || responseCodeCategory != 3) {
                returnMessage = SITE_IS_UP;
            } else {
                returnMessage = SITE_IS_DOWN;
            }

        } catch (MalformedURLException | URISyntaxException e) {
            returnMessage = INCORRECT_URL;
        } catch (IOException e) {
            returnMessage = SITE_IS_DOWN;
        }

        return returnMessage;
    }
}
