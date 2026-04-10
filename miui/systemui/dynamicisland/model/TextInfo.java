/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.model;

public final class TextInfo {
    private String content;
    private String frontTitle;
    private Boolean isTitleDigit;
    private Boolean narrowFont;
    private Boolean showHighlightColor;
    private String title;
    private Boolean turnAnim;

    public TextInfo() {
        Boolean bl;
        this.showHighlightColor = bl = Boolean.FALSE;
        this.narrowFont = bl;
        this.turnAnim = bl;
        this.isTitleDigit = bl;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getFrontTitle() {
        return this.frontTitle;
    }

    public final Boolean getNarrowFont() {
        return this.narrowFont;
    }

    public final Boolean getShowHighlightColor() {
        return this.showHighlightColor;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean getTurnAnim() {
        return this.turnAnim;
    }

    public final Boolean isTitleDigit() {
        return this.isTitleDigit;
    }

    public final void setContent(String string) {
        this.content = string;
    }

    public final void setFrontTitle(String string) {
        this.frontTitle = string;
    }

    public final void setNarrowFont(Boolean bl) {
        this.narrowFont = bl;
    }

    public final void setShowHighlightColor(Boolean bl) {
        this.showHighlightColor = bl;
    }

    public final void setTitle(String string) {
        this.title = string;
    }

    public final void setTitleDigit(Boolean bl) {
        this.isTitleDigit = bl;
    }

    public final void setTurnAnim(Boolean bl) {
        this.turnAnim = bl;
    }
}
