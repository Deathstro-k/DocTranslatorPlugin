package com.trofimovas.doctranslatorplugin.domain.utils;

import com.intellij.openapi.extensions.ExtensionPointName;
import java.util.List;
public class DependencyInjectionUtil{

    public static <T> T getDependency(String path)
    {
        ExtensionPointName<T> EP_NAME = ExtensionPointName.create(path);
        return EP_NAME.getExtensionList().get(0);
    }
    public static <T> List<T> getDependencyList(String path)
    {
        ExtensionPointName<T> EP_NAME = ExtensionPointName.create(path);
        return EP_NAME.getExtensionList();
    }

}
