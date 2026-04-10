/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.model;

public final class PicInfo {
    private Boolean autoplay;
    private String contentDescription;
    private String effectColor;
    private String effectSrc;
    private Boolean loop;
    private int number;
    private String pic;
    private Integer type;

    public PicInfo() {
        Boolean bl;
        this.loop = bl = Boolean.FALSE;
        this.number = -1;
        this.autoplay = bl;
    }

    public final Boolean getAutoplay() {
        return this.autoplay;
    }

    public final String getContentDescription() {
        return this.contentDescription;
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

    public final String getPic() {
        return this.pic;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setAutoplay(Boolean bl) {
        this.autoplay = bl;
    }

    public final void setContentDescription(String string) {
        this.contentDescription = string;
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

    public final void setPic(String string) {
        this.pic = string;
    }

    public final void setType(Integer n) {
        this.type = n;
    }
}
