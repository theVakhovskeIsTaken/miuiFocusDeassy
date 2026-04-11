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
import miui.systemui.notification.focus.model.TextAndColorInfo;

public final class MultiProgressInfo
extends TextAndColorInfo {
    private String color;
    private int points;
    private int progress;

    public MultiProgressInfo() {
        this(0, null, 0, 7, null);
    }

    public MultiProgressInfo(int n, String string, int n2) {
        this.progress = n;
        this.color = string;
        this.points = n2;
    }

    public /* synthetic */ MultiProgressInfo(int n, String string, int n2, int n3, h h2) {
        if ((n3 & 1) != 0) {
            n = -1;
        }
        if ((n3 & 2) != 0) {
            string = null;
        }
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        this(n, string, n2);
    }

    public static /* synthetic */ MultiProgressInfo copy$default(MultiProgressInfo multiProgressInfo, int n, String string, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = multiProgressInfo.progress;
        }
        if ((n3 & 2) != 0) {
            string = multiProgressInfo.color;
        }
        if ((n3 & 4) != 0) {
            n2 = multiProgressInfo.points;
        }
        return multiProgressInfo.copy(n, string, n2);
    }

    public final int component1() {
        return this.progress;
    }

    public final String component2() {
        return this.color;
    }

    public final int component3() {
        return this.points;
    }

    public final MultiProgressInfo copy(int n, String string, int n2) {
        return new MultiProgressInfo(n, string, n2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof MultiProgressInfo)) {
            return false;
        }
        object = (MultiProgressInfo)object;
        if (this.progress != ((MultiProgressInfo)object).progress) {
            return false;
        }
        if (!o.c((Object)this.color, (Object)((MultiProgressInfo)object).color)) {
            return false;
        }
        return this.points == ((MultiProgressInfo)object).points;
    }

    public final String getColor() {
        return this.color;
    }

    public final int getPoints() {
        return this.points;
    }

    public final int getProgress() {
        return this.progress;
    }

    public int hashCode() {
        int n = Integer.hashCode(this.progress);
        String string = this.color;
        int n2 = string == null ? 0 : string.hashCode();
        return (n * 31 + n2) * 31 + Integer.hashCode(this.points);
    }

    public final void setColor(String string) {
        this.color = string;
    }

    public final void setPoints(int n) {
        this.points = n;
    }

    public final void setProgress(int n) {
        this.progress = n;
    }

    public String toString() {
        int n = this.progress;
        String string = this.color;
        int n2 = this.points;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MultiProgressInfo(progress=");
        stringBuilder.append(n);
        stringBuilder.append(", color=");
        stringBuilder.append(string);
        stringBuilder.append(", points=");
        stringBuilder.append(n2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
