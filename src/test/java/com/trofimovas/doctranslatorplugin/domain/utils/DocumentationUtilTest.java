package com.trofimovas.doctranslatorplugin.domain.utils;
import com.intellij.openapi.actionSystem.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DocumentationUtilTest {

    @Test
    public void getDocumentationText() {
        //arrange
        var event = new AnActionEvent(null, DataContext.EMPTY_CONTEXT,
                ActionPlaces.UNKNOWN, new Presentation(),new EmptyActionManager(), 1);
        //act
        var actual=DocumentationUtil.getDocumentationText(event);
        //assert
        assertNull(actual);
    }

    @Test
    public void optimizeHtmlDocumentation() {
        //arrange
        var inputHtml = "<div>\n\n\r\n\n<div>";
        var expected = "<div><div>";
        //act
        var actual = DocumentationUtil.optimizeHtmlDocumentation(inputHtml);
        //assert
        assertEquals(expected,actual);
    }
}