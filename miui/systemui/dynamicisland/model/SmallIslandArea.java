/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.model;

import miui.systemui.dynamicisland.model.CombinePicInfo;
import miui.systemui.dynamicisland.model.PicInfo;

public final class SmallIslandArea {
    private CombinePicInfo combinePicInfo;
    private PicInfo picInfo;

    public final CombinePicInfo getCombinePicInfo() {
        return this.combinePicInfo;
    }

    public final PicInfo getPicInfo() {
        return this.picInfo;
    }

    public final void setCombinePicInfo(CombinePicInfo combinePicInfo) {
        this.combinePicInfo = combinePicInfo;
    }

    public final void setPicInfo(PicInfo picInfo) {
        this.picInfo = picInfo;
    }
}
