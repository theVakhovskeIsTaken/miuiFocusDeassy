/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package miui.systemui.notification.focus.model;

import android.text.TextUtils;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.model.TimerInfo;

public final class ChatInfo
extends TextAndColorInfo {
    private String appIconPkg;
    private String picProfile;
    private String picProfileDark;
    private TimerInfo timerInfo;

    public final String getAppIconPkg() {
        return this.appIconPkg;
    }

    public final String getPicProfile() {
        return this.picProfile;
    }

    public final String getPicProfileDark() {
        String string = this.picProfileDark;
        if (string != null && !TextUtils.isEmpty((CharSequence)string)) {
            return this.picProfileDark;
        }
        return this.picProfile;
    }

    public final TimerInfo getTimerInfo() {
        return this.timerInfo;
    }

    public final void setAppIconPkg(String string) {
        this.appIconPkg = string;
    }

    public final void setPicProfile(String string) {
        this.picProfile = string;
    }

    public final void setPicProfileDark(String string) {
        this.picProfileDark = string;
    }

    public final void setTimerInfo(TimerInfo timerInfo) {
        this.timerInfo = timerInfo;
    }
}
