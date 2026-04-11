/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.notification.focus.model;

import miui.systemui.notification.focus.model.ActionInfo;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.model.TimerInfo;

public final class HintInfo
extends TextAndColorInfo {
    private ActionInfo actionInfo;
    private String colorContentBg;
    private String picContent;
    private TimerInfo timerInfo;
    private int titleLineCount;
    private Integer type;

    public final ActionInfo getActionInfo() {
        return this.actionInfo;
    }

    public final String getColorContentBg() {
        return this.colorContentBg;
    }

    public final String getPicContent() {
        return this.picContent;
    }

    public final TimerInfo getTimerInfo() {
        return this.timerInfo;
    }

    public final int getTitleLineCount() {
        return this.titleLineCount;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setActionInfo(ActionInfo actionInfo) {
        this.actionInfo = actionInfo;
    }

    public final void setColorContentBg(String string) {
        this.colorContentBg = string;
    }

    public final void setPicContent(String string) {
        this.picContent = string;
    }

    public final void setTimerInfo(TimerInfo timerInfo) {
        this.timerInfo = timerInfo;
    }

    public final void setTitleLineCount(int n) {
        this.titleLineCount = n;
    }

    public final void setType(Integer n) {
        this.type = n;
    }
}
