/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus.model;

import android.text.TextUtils;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.ActionInfo;
import miui.systemui.notification.focus.model.TextAndColorInfo;

public final class PicInfo
extends TextAndColorInfo {
    private ActionInfo actionInfo;
    private String pic;
    private String picDark;
    private Integer type;

    public PicInfo() {
        this(null, null, null, 7, null);
    }

    public PicInfo(String string, Integer n, ActionInfo actionInfo) {
        this.pic = string;
        this.type = n;
        this.actionInfo = actionInfo;
    }

    public /* synthetic */ PicInfo(String string, Integer n, ActionInfo actionInfo, int n2, h h2) {
        if ((n2 & 1) != 0) {
            string = null;
        }
        if ((n2 & 2) != 0) {
            n = null;
        }
        if ((n2 & 4) != 0) {
            actionInfo = null;
        }
        this(string, n, actionInfo);
    }

    public static /* synthetic */ PicInfo copy$default(PicInfo picInfo, String string, Integer n, ActionInfo actionInfo, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = picInfo.pic;
        }
        if ((n2 & 2) != 0) {
            n = picInfo.type;
        }
        if ((n2 & 4) != 0) {
            actionInfo = picInfo.actionInfo;
        }
        return picInfo.copy(string, n, actionInfo);
    }

    public final String component1() {
        return this.pic;
    }

    public final Integer component2() {
        return this.type;
    }

    public final ActionInfo component3() {
        return this.actionInfo;
    }

    public final PicInfo copy(String string, Integer n, ActionInfo actionInfo) {
        return new PicInfo(string, n, actionInfo);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PicInfo)) {
            return false;
        }
        object = (PicInfo)object;
        if (!o.c((Object)this.pic, (Object)((PicInfo)object).pic)) {
            return false;
        }
        if (!o.c((Object)this.type, (Object)((PicInfo)object).type)) {
            return false;
        }
        return o.c((Object)this.actionInfo, (Object)((PicInfo)object).actionInfo);
    }

    public final ActionInfo getActionInfo() {
        return this.actionInfo;
    }

    public final String getPic() {
        return this.pic;
    }

    public final String getPicDark() {
        String string = this.picDark;
        if (string != null && !TextUtils.isEmpty((CharSequence)string)) {
            return this.picDark;
        }
        return this.pic;
    }

    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Object object = this.pic;
        int n = 0;
        int n2 = object == null ? 0 : ((String)object).hashCode();
        object = this.type;
        int n3 = object == null ? 0 : object.hashCode();
        object = this.actionInfo;
        if (object != null) {
            n = ((ActionInfo)object).hashCode();
        }
        return (n2 * 31 + n3) * 31 + n;
    }

    public final void setActionInfo(ActionInfo actionInfo) {
        this.actionInfo = actionInfo;
    }

    public final void setPic(String string) {
        this.pic = string;
    }

    public final void setPicDark(String string) {
        this.picDark = string;
    }

    public final void setType(Integer n) {
        this.type = n;
    }

    public String toString() {
        String string = this.pic;
        Integer n = this.type;
        ActionInfo actionInfo = this.actionInfo;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PicInfo(pic=");
        stringBuilder.append(string);
        stringBuilder.append(", type=");
        stringBuilder.append(n);
        stringBuilder.append(", actionInfo=");
        stringBuilder.append(actionInfo);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
