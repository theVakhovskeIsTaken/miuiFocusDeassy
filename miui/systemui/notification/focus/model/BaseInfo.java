/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.notification.focus.model;

import miui.systemui.notification.focus.model.TextAndColorInfo;

public final class BaseInfo
extends TextAndColorInfo {
    private String picFunction;
    private Boolean setMarginBottom;
    private Boolean setMarginTop;
    private Boolean showContentDivider;
    private Boolean showDivider;
    private Integer type;

    public BaseInfo() {
        Boolean bl;
        this.showDivider = bl = Boolean.FALSE;
        this.showContentDivider = bl;
        this.setMarginTop = bl;
        this.setMarginBottom = bl;
    }

    public final String getPicFunction() {
        return this.picFunction;
    }

    public final Boolean getSetMarginBottom() {
        return this.setMarginBottom;
    }

    public final Boolean getSetMarginTop() {
        return this.setMarginTop;
    }

    public final Boolean getShowContentDivider() {
        return this.showContentDivider;
    }

    public final Boolean getShowDivider() {
        return this.showDivider;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setPicFunction(String string) {
        this.picFunction = string;
    }

    public final void setSetMarginBottom(Boolean bl) {
        this.setMarginBottom = bl;
    }

    public final void setSetMarginTop(Boolean bl) {
        this.setMarginTop = bl;
    }

    public final void setShowContentDivider(Boolean bl) {
        this.showContentDivider = bl;
    }

    public final void setShowDivider(Boolean bl) {
        this.showDivider = bl;
    }

    public final void setType(Integer n) {
        this.type = n;
    }
}
