/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.model;

import miui.systemui.dynamicisland.model.TimerInfo;

public final class SameWidthDigitInfo {
    private String content;
    private String digit;
    private Boolean showHighlightColor = Boolean.FALSE;
    private TimerInfo timerInfo;
    private Boolean turnAnim;

    public final String getContent() {
        return this.content;
    }

    public final String getDigit() {
        return this.digit;
    }

    public final Boolean getShowHighlightColor() {
        return this.showHighlightColor;
    }

    public final TimerInfo getTimerInfo() {
        return this.timerInfo;
    }

    public final Boolean getTurnAnim() {
        return this.turnAnim;
    }

    public final void setContent(String string) {
        this.content = string;
    }

    public final void setDigit(String string) {
        this.digit = string;
    }

    public final void setShowHighlightColor(Boolean bl) {
        this.showHighlightColor = bl;
    }

    public final void setTimerInfo(TimerInfo timerInfo) {
        this.timerInfo = timerInfo;
    }

    public final void setTurnAnim(Boolean bl) {
        this.turnAnim = bl;
    }
}
