/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.model;

public final class ProgressInfo {
    private String colorReach;
    private String colorUnReach;
    private Boolean isCCW = Boolean.FALSE;
    private Integer progress;

    public final String getColorReach() {
        return this.colorReach;
    }

    public final String getColorUnReach() {
        return this.colorUnReach;
    }

    public final Integer getProgress() {
        return this.progress;
    }

    public final Boolean isCCW() {
        return this.isCCW;
    }

    public final void setCCW(Boolean bl) {
        this.isCCW = bl;
    }

    public final void setColorReach(String string) {
        this.colorReach = string;
    }

    public final void setColorUnReach(String string) {
        this.colorUnReach = string;
    }

    public final void setProgress(Integer n) {
        this.progress = n;
    }
}
