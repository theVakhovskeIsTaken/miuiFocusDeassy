/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.model;

import miui.systemui.dynamicisland.model.PicInfo;
import miui.systemui.dynamicisland.model.ProgressInfo;
import miui.systemui.dynamicisland.model.TextInfo;

public final class ImageTextInfo {
    private PicInfo picInfo;
    private ProgressInfo progressInfo;
    private TextInfo textInfo;
    private Integer type;

    public final PicInfo getPicInfo() {
        return this.picInfo;
    }

    public final ProgressInfo getProgressInfo() {
        return this.progressInfo;
    }

    public final TextInfo getTextInfo() {
        return this.textInfo;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setPicInfo(PicInfo picInfo) {
        this.picInfo = picInfo;
    }

    public final void setProgressInfo(ProgressInfo progressInfo) {
        this.progressInfo = progressInfo;
    }

    public final void setTextInfo(TextInfo textInfo) {
        this.textInfo = textInfo;
    }

    public final void setType(Integer n) {
        this.type = n;
    }
}
