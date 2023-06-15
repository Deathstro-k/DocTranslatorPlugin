package com.trofimovas.doctranslatorplugin.domain.utils;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.ex.AnActionListener;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.util.ActionCallback;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.List;

public class EmptyActionManager extends ActionManager {
    @Override
    public @NotNull ActionPopupMenu createActionPopupMenu(@NonNls @NotNull String place, @NotNull ActionGroup group) {
        return null;
    }

    @Override
    public @NotNull ActionToolbar createActionToolbar(@NonNls @NotNull String place, @NotNull ActionGroup group, boolean horizontal) {
        return null;
    }

    @Override
    public AnAction getAction(@NonNls @NotNull String actionId) {
        return null;
    }

    @Override
    public @NonNls String getId(@NotNull AnAction action) {
        return null;
    }

    @Override
    public void registerAction(@NonNls @NotNull String actionId, @NotNull AnAction action) {

    }

    @Override
    public void registerAction(@NotNull String actionId, @NotNull AnAction action, @Nullable PluginId pluginId) {

    }

    @Override
    public void unregisterAction(@NotNull String actionId) {

    }

    @Override
    public void replaceAction(@NotNull String actionId, @NotNull AnAction newAction) {

    }

    @Override
    public String @NotNull [] getActionIds(@NotNull String idPrefix) {
        return new String[0];
    }

    @Override
    public @NotNull List<@NonNls String> getActionIdList(@NotNull String idPrefix) {
        return null;
    }

    @Override
    public boolean isGroup(@NotNull String actionId) {
        return false;
    }

    @Override
    public @NotNull JComponent createButtonToolbar(@NotNull String actionPlace, @NotNull ActionGroup messageActionGroup) {
        return null;
    }

    @Override
    public @Nullable AnAction getActionOrStub(@NotNull @NonNls String id) {
        return null;
    }

    @Override
    public void addTimerListener(@NotNull TimerListener listener) {

    }

    @Override
    public void removeTimerListener(@NotNull TimerListener listener) {

    }

    @Override
    public @NotNull ActionCallback tryToExecute(@NotNull AnAction action, @Nullable InputEvent inputEvent, @Nullable Component contextComponent, @Nullable String place, boolean now) {
        return null;
    }

    @Override
    public void addAnActionListener(AnActionListener listener) {

    }

    @Override
    public void removeAnActionListener(AnActionListener listener) {

    }

    @Override
    public @Nullable KeyboardShortcut getKeyboardShortcut(@NonNls @NotNull String actionId) {
        return null;
    }
}
