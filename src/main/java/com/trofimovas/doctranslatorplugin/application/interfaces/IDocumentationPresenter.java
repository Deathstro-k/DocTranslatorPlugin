package com.trofimovas.doctranslatorplugin.application.interfaces;

import javax.swing.*;
public interface IDocumentationPresenter{

    default void showDocumentation(String text, JLayeredPane layeredPane){
        System.out.println(text);
    };
    default void showDocumentation(String text){
        System.out.println(text);
    };
}


