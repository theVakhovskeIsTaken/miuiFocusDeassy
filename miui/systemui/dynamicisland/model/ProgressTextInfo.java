/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.model;

import miui.systemui.dynamicisland.model.ProgressInfo;
import miui.systemui.dynamicisland.model.TextInfo;

public final class ProgressTextInfo {
    private ProgressInfo progressInfo;
    private TextInfo textInfo;

    public final ProgressInfo getProgressInfo() {
        return this.progressInfo;
    }

    public final TextInfo getTextInfo() {
        return this.textInfo;
    }

    public final void setProgressInfo(ProgressInfo progressInfo) {
        this.progressInfo = progressInfo;
    }

    public final void setTextInfo(TextInfo textInfo) {
        this.textInfo = textInfo;
    }
}
