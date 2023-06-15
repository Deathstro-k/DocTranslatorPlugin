package com.trofimovas.doctranslatorplugin.usecase;
import com.trofimovas.doctranslatorplugin.application.interfaces.ITraslatorApiProvider;
import com.trofimovas.doctranslatorplugin.domain.utils.DocumentationUtil;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import static com.trofimovas.doctranslatorplugin.domain.utils.DependencyInjectionUtil.getDependency;
public class Translator {
    private final ITraslatorApiProvider translatorProvider;
    public Translator() {
        this.translatorProvider = getDependency("com.trofimovAS.DocTranslatorPlugin.translatorApiProvider");
    }
    public final String translateDocumentation(String documentation) throws IOException, ExecutionException, InterruptedException {

        if(documentation != null){
            var optimizedHtmlDocumentation = DocumentationUtil.optimizeHtmlDocumentation(documentation);
            return translatorProvider.translateAsync(optimizedHtmlDocumentation);
        }
        return null;
    }
}
