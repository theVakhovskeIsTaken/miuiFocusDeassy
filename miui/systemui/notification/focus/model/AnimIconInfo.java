/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package miui.systemui.notification.focus.model;

import android.text.TextUtils;
import miui.systemui.notification.focus.model.TextAndColorInfo;

public final class AnimIconInfo
extends TextAndColorInfo {
    private Boolean autoplay;
    private String effectColor;
    private String effectSrc;
    private Boolean loop;
    private int number = -1;
    private String src;
    private String srcDark;
    private Integer type;

    public final Boolean getAutoplay() {
        return this.autoplay;
    }

    public final String getEffectColor() {
        return this.effectColor;
    }

    public final String getEffectSrc() {
        return this.effectSrc;
    }

    public final Boolean getLoop() {
        return this.loop;
    }

    public final int getNumber() {
        return this.number;
    }

    public final String getSrc() {
        return this.src;
    }

    public final String getSrcDark() {
        String string = this.srcDark;
        if (string != null && !TextUtils.isEmpty((CharSequence)string)) {
            return this.srcDark;
        }
        return this.src;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setAutoplay(Boolean bl) {
        this.autoplay = bl;
    }

    public final void setEffectColor(String string) {
        this.effectColor = string;
    }

    public final void setEffectSrc(String string) {
        this.effectSrc = string;
    }

    public final void setLoop(Boolean bl) {
        this.loop = bl;
    }

    public final void setNumber(int n) {
        this.number = n;
    }

    public final void setSrc(String string) {
        this.src = string;
    }

    public final void setSrcDark(String string) {
        this.srcDark = string;
    }

    public final void setType(Integer n) {
        this.type = n;
    }
}
