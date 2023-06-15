package com.trofimovas.doctranslatorplugin.presentation;

import com.trofimovas.doctranslatorplugin.application.interfaces.IDocumentationPresenter;
import com.trofimovas.doctranslatorplugin.presentation.views.HtmlJFrame;
public class DocumentationWindowPresenter implements IDocumentationPresenter {
    public void showDocumentation(String text) {
        new HtmlJFrame(text);
    }
}
