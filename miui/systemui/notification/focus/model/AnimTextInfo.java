/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.notification.focus.model;

import miui.systemui.notification.focus.model.AnimIconInfo;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.model.TimerInfo;

public final class AnimTextInfo
extends TextAndColorInfo {
    private AnimIconInfo animIconInfo;
    private TimerInfo timerInfo;

    public final AnimIconInfo getAnimIconInfo() {
        return this.animIconInfo;
    }

    public final TimerInfo getTimerInfo() {
        return this.timerInfo;
    }

    public final void setAnimIconInfo(AnimIconInfo animIconInfo) {
        this.animIconInfo = animIconInfo;
    }

    public final void setTimerInfo(TimerInfo timerInfo) {
        this.timerInfo = timerInfo;
    }
}
