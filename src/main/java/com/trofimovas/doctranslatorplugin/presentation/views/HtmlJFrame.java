package com.trofimovas.doctranslatorplugin.presentation.views;

import com.intellij.ui.components.JBScrollPane;
import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;

public class HtmlJFrame extends JFrame {

    public HtmlJFrame(String text) {

        var editorPane = new JEditorPane();
        editorPane.setEditable(false);

        editorPane.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        editorPane.setMaximumSize(new Dimension(600, Integer.MAX_VALUE));
        editorPane.setBackground(UIManager.getColor("Label.background"));
        editorPane.setFont(UIManager.getFont("Label.font"));
        editorPane.setMargin(new Insets(0, 5, 0, 5));

        var kit = new HTMLEditorKit();
        var styleSheet = kit.getStyleSheet();
        styleSheet.addRule("body {width : 100%;}");
        styleSheet.addRule("pre {word-wrap: break-word; white-space: pre-wrap;}");
        editorPane.setEditorKit(kit);
        editorPane.setText(text);

        var scrollPane = new JBScrollPane(editorPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(600, 480));

        getContentPane().add(scrollPane);
        pack();
        // Отображение окна
        setVisible(true);
    }
}