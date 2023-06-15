package com.trofimovas.doctranslatorplugin.application.interfaces;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface ITraslatorApiProvider {
    String translateAsync(String inputText) throws IOException, InterruptedException, ExecutionException;

}
