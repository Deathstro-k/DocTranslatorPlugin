package com.trofimovas.doctranslatorplugin.infrastructure.traslatorApiProviders;

import com.google.gson.JsonParser;
import com.trofimovas.doctranslatorplugin.infrastructure.traslatorApiProviders.base.AbstractTranslatorApiProvider;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

public class GoogleTranslateApiProvider extends AbstractTranslatorApiProvider {
    @Override
    public String translateAsync(String optimizedHtml) throws IOException, InterruptedException, ExecutionException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://google-translate1.p.rapidapi.com/language/translate/v2"))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("Accept-Encoding", "application/gzip")
                .header("X-RapidAPI-Key", "0bb711038bmshf35803e5557e6b5p10fd2fjsn93e6880278d5")
                .header("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString("q="+optimizedHtml+"&format=html&target=ru&source=en"))
                .build();
        var result = HttpClient.newHttpClient()
                               .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                               .thenApplyAsync(HttpResponse::body)
                               .thenApplyAsync( r->getTranslationTag(r))
                               .get();
        return result;
    }
    @Override
    public String getTranslationTag(String responseBody) {

        var text = JsonParser.parseString(responseBody).getAsJsonObject()
                .getAsJsonObject("data")
                .getAsJsonArray("translations")
                .get(0)
                .getAsJsonObject()
                .get("translatedText")
                .getAsString();
        return text;
    }
}
