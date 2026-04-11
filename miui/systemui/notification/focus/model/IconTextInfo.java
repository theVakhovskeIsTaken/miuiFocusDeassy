/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.notification.focus.model;

import miui.systemui.notification.focus.model.AnimIconInfo;
import miui.systemui.notification.focus.model.TextAndColorInfo;

public final class IconTextInfo
extends TextAndColorInfo {
    private AnimIconInfo animIconInfo;
    private Integer type;

    public final AnimIconInfo getAnimIconInfo() {
        return this.animIconInfo;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setAnimIconInfo(AnimIconInfo animIconInfo) {
        this.animIconInfo = animIconInfo;
    }

    public final void setType(Integer n) {
        this.type = n;
    }
}
