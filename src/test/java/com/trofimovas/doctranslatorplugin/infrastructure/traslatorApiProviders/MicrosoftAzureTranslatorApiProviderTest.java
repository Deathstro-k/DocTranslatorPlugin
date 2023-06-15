package com.trofimovas.doctranslatorplugin.infrastructure.traslatorApiProviders;

import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.Presentation;
import com.trofimovas.doctranslatorplugin.domain.utils.DocumentationUtil;
import com.trofimovas.doctranslatorplugin.domain.utils.EmptyActionManager;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class MicrosoftAzureTranslatorApiProviderTest {

    @Test
    public void translateAsync() throws IOException, ExecutionException, InterruptedException {
        //arange
        var inputHtml="<div>dad</div>";
        var excepted="<div>папа</div>";
        //act
        var actual = new MicrosoftAzureTranslatorApiProvider().translateAsync(inputHtml);
        //assert
        assertEquals(excepted,actual);
    }

    @Test
    public void getTranslationTag() {
        //arange
        var responseBody = "[\n" +
                "  {\n" +
                "    \"detectedLanguage\": {\n" +
                "      \"language\": \"en\",\n" +
                "      \"score\": 1\n" +
                "    },\n" +
                "    \"translations\": [\n" +
                "      {\n" +
                "        \"text\": \"Я бы очень хотел проехать на вашей машине по кварталу несколько раз.\",\n" +
                "        \"to\": \"ru\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        var excepted ="Я бы очень хотел проехать на вашей машине по кварталу несколько раз.";
        //act
        var actual=new MicrosoftAzureTranslatorApiProvider().getTranslationTag(responseBody);
        //assert
        assertEquals(excepted,actual);
    }
}