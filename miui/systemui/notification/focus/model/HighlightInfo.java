/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.notification.focus.model;

import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.model.TimerInfo;

public final class HighlightInfo
extends TextAndColorInfo {
    private String picFunction;
    private String picFunctionDark;
    private TimerInfo timerInfo;
    private int type = 1;

    public final String getPicFunction() {
        return this.picFunction;
    }

    public final String getPicFunctionDark() {
        return this.picFunctionDark;
    }

    public final TimerInfo getTimerInfo() {
        return this.timerInfo;
    }

    public final int getType() {
        return this.type;
    }

    public final void setPicFunction(String string) {
        this.picFunction = string;
    }

    public final void setPicFunctionDark(String string) {
        this.picFunctionDark = string;
    }

    public final void setTimerInfo(TimerInfo timerInfo) {
        this.timerInfo = timerInfo;
    }

    public final void setType(int n) {
        this.type = n;
    }
}
