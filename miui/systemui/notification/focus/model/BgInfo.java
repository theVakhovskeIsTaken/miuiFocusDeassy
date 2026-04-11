/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus.model;

import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;

public final class BgInfo {
    private final String colorBg;
    private String picBg;
    private int type;

    public BgInfo(int n, String string, String string2) {
        o.g((Object)string, (String)"colorBg");
        this.type = n;
        this.colorBg = string;
        this.picBg = string2;
    }

    public /* synthetic */ BgInfo(int n, String string, String string2, int n2, h h2) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        if ((n2 & 4) != 0) {
            string2 = null;
        }
        this(n, string, string2);
    }

    public static /* synthetic */ BgInfo copy$default(BgInfo bgInfo, int n, String string, String string2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = bgInfo.type;
        }
        if ((n2 & 2) != 0) {
            string = bgInfo.colorBg;
        }
        if ((n2 & 4) != 0) {
            string2 = bgInfo.picBg;
        }
        return bgInfo.copy(n, string, string2);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.colorBg;
    }

    public final String component3() {
        return this.picBg;
    }

    public final BgInfo copy(int n, String string, String string2) {
        o.g((Object)string, (String)"colorBg");
        return new BgInfo(n, string, string2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof BgInfo)) {
            return false;
        }
        object = (BgInfo)object;
        if (this.type != ((BgInfo)object).type) {
            return false;
        }
        if (!o.c((Object)this.colorBg, (Object)((BgInfo)object).colorBg)) {
            return false;
        }
        return o.c((Object)this.picBg, (Object)((BgInfo)object).picBg);
    }

    public final String getColorBg() {
        return this.colorBg;
    }

    public final String getPicBg() {
        return this.picBg;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int n = Integer.hashCode(this.type);
        int n2 = this.colorBg.hashCode();
        String string = this.picBg;
        int n3 = string == null ? 0 : string.hashCode();
        return (n * 31 + n2) * 31 + n3;
    }

    public final void setPicBg(String string) {
        this.picBg = string;
    }

    public final void setType(int n) {
        this.type = n;
    }

    public String toString() {
        int n = this.type;
        String string = this.colorBg;
        String string2 = this.picBg;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BgInfo(type=");
        stringBuilder.append(n);
        stringBuilder.append(", colorBg=");
        stringBuilder.append(string);
        stringBuilder.append(", picBg=");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
