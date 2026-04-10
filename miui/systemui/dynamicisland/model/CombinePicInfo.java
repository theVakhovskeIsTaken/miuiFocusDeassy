/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.model;

import miui.systemui.dynamicisland.model.PicInfo;
import miui.systemui.dynamicisland.model.ProgressInfo;

public final class CombinePicInfo {
    private PicInfo picInfo;
    private ProgressInfo progressInfo;
    private PicInfo smallPicInfo;

    public final PicInfo getPicInfo() {
        return this.picInfo;
    }

    public final ProgressInfo getProgressInfo() {
        return this.progressInfo;
    }

    public final PicInfo getSmallPicInfo() {
        return this.smallPicInfo;
    }

    public final void setPicInfo(PicInfo picInfo) {
        this.picInfo = picInfo;
    }

    public final void setProgressInfo(ProgressInfo progressInfo) {
        this.progressInfo = progressInfo;
    }

    public final void setSmallPicInfo(PicInfo picInfo) {
        this.smallPicInfo = picInfo;
    }
}
