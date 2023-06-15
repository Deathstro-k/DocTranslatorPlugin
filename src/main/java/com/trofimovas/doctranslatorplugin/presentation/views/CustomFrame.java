package com.trofimovas.doctranslatorplugin.presentation.views;

import com.intellij.ui.components.JBScrollPane;
import javax.swing.*;
import java.awt.*;
public class CustomFrame extends JFrame {
    public CustomFrame(String text) {
        this.setSize(620, 200);
        this.setResizable(false);
        var label = new JLabel(text);
        label.setPreferredSize(new Dimension(600, 0));
        label.setVerticalAlignment(JLabel.TOP);

        JBScrollPane scrollPane = new JBScrollPane(label);
        scrollPane.setPreferredSize(new Dimension(600,0));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.getContentPane().add(scrollPane);
        this.setVisible(true);
    }
}
