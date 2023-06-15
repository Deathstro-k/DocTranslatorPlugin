package com.trofimovas.doctranslatorplugin.infrastructure.traslatorApiProviders;

import com.google.gson.JsonParser;
import com.trofimovas.doctranslatorplugin.infrastructure.traslatorApiProviders.base.AbstractTranslatorApiProvider;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;
public class MicrosoftAzureTranslatorApiProvider extends AbstractTranslatorApiProvider {
    @Override
    public String translateAsync(String optimizedHtml) throws IOException, InterruptedException, ExecutionException {

        var request = HttpRequest.newBuilder()
                                 .uri(URI.create("https://microsoft-translator-text.p.rapidapi.com/translate?to%5B0%5D=ru&api-version=3.0&profanityAction=NoAction&textType=html"))
                                 .header("content-type", "application/json")
                                 .header("X-RapidAPI-Key", "d42a59f0e2msh85710d295683f8fp1aa16bjsn12874b91af07")
                                 .header("X-RapidAPI-Host", "microsoft-translator-text.p.rapidapi.com")
                                 .method("POST", HttpRequest.BodyPublishers.ofString("[{\"Text\":\""+optimizedHtml+"\"}]"))
                                 .build();
        var result = HttpClient.newHttpClient()
                                     .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                                     .thenApply(HttpResponse::body)
                                     .thenApply( r->getTranslationTag(r))
                                     .get();
        return result;
    }
    @Override
    public String getTranslationTag(String responseBody) {
        var text = JsonParser.parseString(responseBody)
                             .getAsJsonArray()
                             .get(0)
                             .getAsJsonObject()
                             .get("translations").getAsJsonArray()
                             .get(0)
                             .getAsJsonObject()
                             .get("text")
                             .getAsString();
        return text;
    }
}
