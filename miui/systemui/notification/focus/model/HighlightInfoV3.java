/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.notification.focus.model;

import miui.systemui.notification.focus.model.ActionInfo;
import miui.systemui.notification.focus.model.TextAndColorInfo;

public final class HighlightInfoV3
extends TextAndColorInfo {
    private ActionInfo actionInfo;
    private String highLightText;
    private String highLightTextColor;
    private String highLightTextColorDark;
    private String highLightbgColor;
    private String highLightbgColorDark;
    private String primaryColor;
    private String primaryColorDark;
    private String primaryText;
    private String secondaryColor;
    private String secondaryColorDark;
    private String secondaryText;
    private Boolean showSecondaryLine = Boolean.FALSE;

    public final ActionInfo getActionInfo() {
        return this.actionInfo;
    }

    public final String getHighLightText() {
        return this.highLightText;
    }

    public final String getHighLightTextColor() {
        return this.highLightTextColor;
    }

    public final String getHighLightTextColorDark() {
        return this.highLightTextColorDark;
    }

    public final String getHighLightbgColor() {
        return this.highLightbgColor;
    }

    public final String getHighLightbgColorDark() {
        return this.highLightbgColorDark;
    }

    public final String getPrimaryColor() {
        return this.primaryColor;
    }

    public final String getPrimaryColorDark() {
        return this.primaryColorDark;
    }

    public final String getPrimaryText() {
        return this.primaryText;
    }

    public final String getSecondaryColor() {
        return this.secondaryColor;
    }

    public final String getSecondaryColorDark() {
        return this.secondaryColorDark;
    }

    public final String getSecondaryText() {
        return this.secondaryText;
    }

    public final Boolean getShowSecondaryLine() {
        return this.showSecondaryLine;
    }

    public final void setActionInfo(ActionInfo actionInfo) {
        this.actionInfo = actionInfo;
    }

    public final void setHighLightText(String string) {
        this.highLightText = string;
    }

    public final void setHighLightTextColor(String string) {
        this.highLightTextColor = string;
    }

    public final void setHighLightTextColorDark(String string) {
        this.highLightTextColorDark = string;
    }

    public final void setHighLightbgColor(String string) {
        this.highLightbgColor = string;
    }

    public final void setHighLightbgColorDark(String string) {
        this.highLightbgColorDark = string;
    }

    public final void setPrimaryColor(String string) {
        this.primaryColor = string;
    }

    public final void setPrimaryColorDark(String string) {
        this.primaryColorDark = string;
    }

    public final void setPrimaryText(String string) {
        this.primaryText = string;
    }

    public final void setSecondaryColor(String string) {
        this.secondaryColor = string;
    }

    public final void setSecondaryColorDark(String string) {
        this.secondaryColorDark = string;
    }

    public final void setSecondaryText(String string) {
        this.secondaryText = string;
    }

    public final void setShowSecondaryLine(Boolean bl) {
        this.showSecondaryLine = bl;
    }
}
