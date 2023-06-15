package com.trofimovas.doctranslatorplugin.presentation.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.trofimovas.doctranslatorplugin.application.interfaces.IDocumentationPresenter;
import com.trofimovas.doctranslatorplugin.usecase.Translator;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import static com.trofimovas.doctranslatorplugin.domain.utils.DependencyInjectionUtil.getDependency;
import static com.trofimovas.doctranslatorplugin.domain.utils.DocumentationUtil.getDocumentationText;

public final class TranslateAction extends AnAction {
    private final IDocumentationPresenter presenter;
    private Translator traslator = new Translator();
    public TranslateAction() {

        this.presenter = getDependency("com.trofimovAS.DocTranslatorPlugin.documentationPresenter");
    }
    @Override
    public void actionPerformed(AnActionEvent event) {

        var documentation = getDocumentationText(event);

        var translatedDocumentation= "";

        try {
            translatedDocumentation = traslator.translateDocumentation(documentation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(translatedDocumentation!=null){
            presenter.showDocumentation(translatedDocumentation);
        }
    }
}