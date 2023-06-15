package com.trofimovas.doctranslatorplugin.infrastructure.traslatorApiProviders.base;

import com.trofimovas.doctranslatorplugin.application.interfaces.ITraslatorApiProvider;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
public class AbstractTranslatorApiProvider implements ITraslatorApiProvider {
    @Override
    public String translateAsync(String inputText) throws IOException, InterruptedException, ExecutionException { return null; }
    public String getTranslationTag(String responseBody) { return null; }
}
