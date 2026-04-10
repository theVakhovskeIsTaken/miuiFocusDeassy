/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.event;

import kotlin.jvm.internal.o;

public class State {
    private String deleteKey = "";
    private boolean deleteNoAnimation;
    private boolean expanded;
    private Long postTime;
    private boolean tempShow;
    private Long time;
    private String updateKey = "";
    private Boolean updateOrder;

    public State() {
        Long l;
        this.time = l = Long.valueOf(0L);
        this.postTime = l;
        this.expanded = true;
        this.updateOrder = Boolean.FALSE;
    }

    public final String getDeleteKey() {
        return this.deleteKey;
    }

    public final boolean getDeleteNoAnimation() {
        return this.deleteNoAnimation;
    }

    public final boolean getExpanded() {
        return this.expanded;
    }

    public final Long getPostTime() {
        return this.postTime;
    }

    public final boolean getTempShow() {
        return this.tempShow;
    }

    public final Long getTime() {
        return this.time;
    }

    public final String getUpdateKey() {
        return this.updateKey;
    }

    public final Boolean getUpdateOrder() {
        return this.updateOrder;
    }

    public final void setDeleteKey(String string) {
        o.g((Object)string, (String)"<set-?>");
        this.deleteKey = string;
    }

    public final void setDeleteNoAnimation(boolean bl) {
        this.deleteNoAnimation = bl;
    }

    public final void setExpanded(boolean bl) {
        this.expanded = bl;
    }

    public final void setPostTime(Long l) {
        this.postTime = l;
    }

    public final void setTempShow(boolean bl) {
        this.tempShow = bl;
    }

    public final void setTime(Long l) {
        this.time = l;
    }

    public final void setUpdateKey(String string) {
        o.g((Object)string, (String)"<set-?>");
        this.updateKey = string;
    }

    public final void setUpdateOrder(Boolean bl) {
        this.updateOrder = bl;
    }

    public String toString() {
        String string = this.getClass().getSimpleName();
        boolean bl = this.expanded;
        boolean bl2 = this.tempShow;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(string);
        stringBuilder.append("] expanded ");
        stringBuilder.append(bl);
        stringBuilder.append(", tempShow ");
        stringBuilder.append(bl2);
        return stringBuilder.toString();
    }
}
