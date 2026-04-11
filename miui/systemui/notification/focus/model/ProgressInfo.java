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

public final class ProgressInfo {
    private final String colorProgress;
    private final String colorProgressDark;
    private final String colorProgressEnd;
    private final String colorProgressEndDark;
    private boolean isAutoProgress;
    private boolean isCCW;
    private final String picEnd;
    private final String picEndUnselected;
    private final String picForward;
    private final String picMiddle;
    private final String picMiddleUnselected;
    private int progress;

    public ProgressInfo(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, boolean bl, boolean bl2) {
        o.g((Object)string3, (String)"colorProgressEnd");
        o.g((Object)string4, (String)"colorProgressEndDark");
        o.g((Object)string5, (String)"picForward");
        o.g((Object)string6, (String)"picMiddle");
        o.g((Object)string7, (String)"picMiddleUnselected");
        o.g((Object)string8, (String)"picEnd");
        o.g((Object)string9, (String)"picEndUnselected");
        this.colorProgress = string;
        this.colorProgressDark = string2;
        this.colorProgressEnd = string3;
        this.colorProgressEndDark = string4;
        this.picForward = string5;
        this.picMiddle = string6;
        this.picMiddleUnselected = string7;
        this.picEnd = string8;
        this.picEndUnselected = string9;
        this.isCCW = bl;
        this.isAutoProgress = bl2;
    }

    public /* synthetic */ ProgressInfo(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, boolean bl, boolean bl2, int n, h h2) {
        if ((n & 0x200) != 0) {
            bl = false;
        }
        if ((n & 0x400) != 0) {
            bl2 = false;
        }
        this(string, string2, string3, string4, string5, string6, string7, string8, string9, bl, bl2);
    }

    public static /* synthetic */ ProgressInfo copy$default(ProgressInfo progressInfo, String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, boolean bl, boolean bl2, int n, Object object) {
        block10: {
            if ((n & 1) != 0) {
                string = progressInfo.colorProgress;
            }
            if ((n & 2) != 0) {
                string2 = progressInfo.colorProgressDark;
            }
            if ((n & 4) != 0) {
                string3 = progressInfo.colorProgressEnd;
            }
            if ((n & 8) != 0) {
                string4 = progressInfo.colorProgressEndDark;
            }
            if ((n & 0x10) != 0) {
                string5 = progressInfo.picForward;
            }
            if ((n & 0x20) != 0) {
                string6 = progressInfo.picMiddle;
            }
            if ((n & 0x40) != 0) {
                string7 = progressInfo.picMiddleUnselected;
            }
            if ((n & 0x80) != 0) {
                string8 = progressInfo.picEnd;
            }
            if ((n & 0x100) != 0) {
                string9 = progressInfo.picEndUnselected;
            }
            if ((n & 0x200) != 0) {
                bl = progressInfo.isCCW;
            }
            if ((n & 0x400) == 0) break block10;
            bl2 = progressInfo.isAutoProgress;
        }
        return progressInfo.copy(string, string2, string3, string4, string5, string6, string7, string8, string9, bl, bl2);
    }

    public final String component1() {
        return this.colorProgress;
    }

    public final boolean component10() {
        return this.isCCW;
    }

    public final boolean component11() {
        return this.isAutoProgress;
    }

    public final String component2() {
        return this.colorProgressDark;
    }

    public final String component3() {
        return this.colorProgressEnd;
    }

    public final String component4() {
        return this.colorProgressEndDark;
    }

    public final String component5() {
        return this.picForward;
    }

    public final String component6() {
        return this.picMiddle;
    }

    public final String component7() {
        return this.picMiddleUnselected;
    }

    public final String component8() {
        return this.picEnd;
    }

    public final String component9() {
        return this.picEndUnselected;
    }

    public final ProgressInfo copy(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, boolean bl, boolean bl2) {
        o.g((Object)string3, (String)"colorProgressEnd");
        o.g((Object)string4, (String)"colorProgressEndDark");
        o.g((Object)string5, (String)"picForward");
        o.g((Object)string6, (String)"picMiddle");
        o.g((Object)string7, (String)"picMiddleUnselected");
        o.g((Object)string8, (String)"picEnd");
        o.g((Object)string9, (String)"picEndUnselected");
        return new ProgressInfo(string, string2, string3, string4, string5, string6, string7, string8, string9, bl, bl2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ProgressInfo)) {
            return false;
        }
        object = (ProgressInfo)object;
        if (!o.c((Object)this.colorProgress, (Object)((ProgressInfo)object).colorProgress)) {
            return false;
        }
        if (!o.c((Object)this.colorProgressDark, (Object)((ProgressInfo)object).colorProgressDark)) {
            return false;
        }
        if (!o.c((Object)this.colorProgressEnd, (Object)((ProgressInfo)object).colorProgressEnd)) {
            return false;
        }
        if (!o.c((Object)this.colorProgressEndDark, (Object)((ProgressInfo)object).colorProgressEndDark)) {
            return false;
        }
        if (!o.c((Object)this.picForward, (Object)((ProgressInfo)object).picForward)) {
            return false;
        }
        if (!o.c((Object)this.picMiddle, (Object)((ProgressInfo)object).picMiddle)) {
            return false;
        }
        if (!o.c((Object)this.picMiddleUnselected, (Object)((ProgressInfo)object).picMiddleUnselected)) {
            return false;
        }
        if (!o.c((Object)this.picEnd, (Object)((ProgressInfo)object).picEnd)) {
            return false;
        }
        if (!o.c((Object)this.picEndUnselected, (Object)((ProgressInfo)object).picEndUnselected)) {
            return false;
        }
        if (this.isCCW != ((ProgressInfo)object).isCCW) {
            return false;
        }
        return this.isAutoProgress == ((ProgressInfo)object).isAutoProgress;
    }

    public final String getColorProgress() {
        return this.colorProgress;
    }

    public final String getColorProgressDark() {
        return this.colorProgressDark;
    }

    public final String getColorProgressEnd() {
        return this.colorProgressEnd;
    }

    public final String getColorProgressEndDark() {
        return this.colorProgressEndDark;
    }

    public final String getPicEnd() {
        return this.picEnd;
    }

    public final String getPicEndUnselected() {
        return this.picEndUnselected;
    }

    public final String getPicForward() {
        return this.picForward;
    }

    public final String getPicMiddle() {
        return this.picMiddle;
    }

    public final String getPicMiddleUnselected() {
        return this.picMiddleUnselected;
    }

    public final int getProgress() {
        int n;
        int n2 = n = this.progress;
        if (n < 0) {
            n2 = 0;
        }
        return n2;
    }

    public int hashCode() {
        String string = this.colorProgress;
        int n = 0;
        int n2 = string == null ? 0 : string.hashCode();
        string = this.colorProgressDark;
        if (string != null) {
            n = string.hashCode();
        }
        return (((((((((n2 * 31 + n) * 31 + this.colorProgressEnd.hashCode()) * 31 + this.colorProgressEndDark.hashCode()) * 31 + this.picForward.hashCode()) * 31 + this.picMiddle.hashCode()) * 31 + this.picMiddleUnselected.hashCode()) * 31 + this.picEnd.hashCode()) * 31 + this.picEndUnselected.hashCode()) * 31 + Boolean.hashCode(this.isCCW)) * 31 + Boolean.hashCode(this.isAutoProgress);
    }

    public final boolean isAutoProgress() {
        return this.isAutoProgress;
    }

    public final boolean isCCW() {
        return this.isCCW;
    }

    public final void setAutoProgress(boolean bl) {
        this.isAutoProgress = bl;
    }

    public final void setCCW(boolean bl) {
        this.isCCW = bl;
    }

    public final void setProgress(int n) {
        this.progress = n;
    }

    public String toString() {
        String string = this.colorProgress;
        String string2 = this.colorProgressDark;
        String string3 = this.colorProgressEnd;
        String string4 = this.colorProgressEndDark;
        String string5 = this.picForward;
        String string6 = this.picMiddle;
        String string7 = this.picMiddleUnselected;
        String string8 = this.picEnd;
        String string9 = this.picEndUnselected;
        boolean bl = this.isCCW;
        boolean bl2 = this.isAutoProgress;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgressInfo(colorProgress=");
        stringBuilder.append(string);
        stringBuilder.append(", colorProgressDark=");
        stringBuilder.append(string2);
        stringBuilder.append(", colorProgressEnd=");
        stringBuilder.append(string3);
        stringBuilder.append(", colorProgressEndDark=");
        stringBuilder.append(string4);
        stringBuilder.append(", picForward=");
        stringBuilder.append(string5);
        stringBuilder.append(", picMiddle=");
        stringBuilder.append(string6);
        stringBuilder.append(", picMiddleUnselected=");
        stringBuilder.append(string7);
        stringBuilder.append(", picEnd=");
        stringBuilder.append(string8);
        stringBuilder.append(", picEndUnselected=");
        stringBuilder.append(string9);
        stringBuilder.append(", isCCW=");
        stringBuilder.append(bl);
        stringBuilder.append(", isAutoProgress=");
        stringBuilder.append(bl2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
