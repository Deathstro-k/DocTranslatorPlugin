package com.trofimovas.doctranslatorplugin.domain.utils;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiWhiteSpace;
import org.jetbrains.annotations.Nullable;

import static com.intellij.codeInsight.documentation.DocumentationManager.getProviderFromElement;
public class DocumentationUtil {
    public static String getDocumentationText(@Nullable AnActionEvent event)
    {
        var psiElement=event.getData(CommonDataKeys.PSI_ELEMENT);
        if(isContainsDocumentation(psiElement))
        {
            var documentationProvider = getProviderFromElement(psiElement);
            var documentationText=documentationProvider
                    .generateDoc(psiElement,psiElement.getOriginalElement());
            return documentationText;
        }
        return null;
    }

    private static Boolean isContainsDocumentation(PsiElement psiElement)
    {
        return psiElement != null && !(psiElement instanceof PsiWhiteSpace);
    }
    public static String optimizeHtmlDocumentation(String html)
    {
        if(html!=null)
        {
            var optimizedHtml=html.replace("\"","\\\"")
                    .replaceAll("(\\r|\\n)", "");
            return optimizedHtml;
        }
        return null;
    }
}
