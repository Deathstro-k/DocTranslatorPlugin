package com.trofimovas.doctranslatorplugin.infrastructure.traslatorApiProviders;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class GoogleTranslateApiProviderTest {

    @Test
    public void translateAsync() throws IOException, ExecutionException, InterruptedException {
        //arrange
        var inputHtml="<div>dad</div>";
        var excepted="<div>����</div>";
        //act
        var actual = new GoogleTranslateApiProvider().translateAsync(inputHtml);
        //assert
        assertEquals(excepted,actual);
    }
    @Test
    public void getTranslationTag() {

        //arrange
        var responseBody = "[\n" +
                "  {\n" +
                "    \"detectedLanguage\": {\n" +
                "      \"language\": \"en\",\n" +
                "      \"score\": 1\n" +
                "    },\n" +
                "    \"translations\": [\n" +
                "      {\n" +
                "        \"text\": \"� �� ����� ����� �������� �� ����� ������ �� �������� ��������� ���.\",\n" +
                "        \"to\": \"ru\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        var excepted ="� �� ����� ����� �������� �� ����� ������ �� �������� ��������� ���.";
        //act
        var actual=new GoogleTranslateApiProvider().getTranslationTag(responseBody);
        //assert
        assertEquals(excepted,actual);
    }
}