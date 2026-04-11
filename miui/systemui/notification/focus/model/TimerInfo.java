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

public final class TimerInfo {
    private Long timerSystemCurrent;
    private long timerTotal;
    private int timerType;
    private Long timerWhen;

    public TimerInfo(int n, Long l, long l2, Long l3) {
        this.timerType = n;
        this.timerWhen = l;
        this.timerTotal = l2;
        this.timerSystemCurrent = l3;
    }

    public /* synthetic */ TimerInfo(int n, Long l, long l2, Long l3, int n2, h h2) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        if ((n2 & 4) != 0) {
            l2 = 0L;
        }
        this(n, l, l2, l3);
    }

    public static /* synthetic */ TimerInfo copy$default(TimerInfo timerInfo, int n, Long l, long l2, Long l3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = timerInfo.timerType;
        }
        if ((n2 & 2) != 0) {
            l = timerInfo.timerWhen;
        }
        if ((n2 & 4) != 0) {
            l2 = timerInfo.timerTotal;
        }
        if ((n2 & 8) != 0) {
            l3 = timerInfo.timerSystemCurrent;
        }
        return timerInfo.copy(n, l, l2, l3);
    }

    public final int component1() {
        return this.timerType;
    }

    public final Long component2() {
        return this.timerWhen;
    }

    public final long component3() {
        return this.timerTotal;
    }

    public final Long component4() {
        return this.timerSystemCurrent;
    }

    public final TimerInfo copy(int n, Long l, long l2, Long l3) {
        return new TimerInfo(n, l, l2, l3);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof TimerInfo)) {
            return false;
        }
        object = (TimerInfo)object;
        if (this.timerType != ((TimerInfo)object).timerType) {
            return false;
        }
        if (!o.c((Object)this.timerWhen, (Object)((TimerInfo)object).timerWhen)) {
            return false;
        }
        if (this.timerTotal != ((TimerInfo)object).timerTotal) {
            return false;
        }
        return o.c((Object)this.timerSystemCurrent, (Object)((TimerInfo)object).timerSystemCurrent);
    }

    public final Long getTimerSystemCurrent() {
        return this.timerSystemCurrent;
    }

    public final long getTimerTotal() {
        return this.timerTotal;
    }

    public final int getTimerType() {
        return this.timerType;
    }

    public final Long getTimerWhen() {
        return this.timerWhen;
    }

    public int hashCode() {
        int n = Integer.hashCode(this.timerType);
        Long l = this.timerWhen;
        int n2 = 0;
        int n3 = l == null ? 0 : ((Object)l).hashCode();
        int n4 = Long.hashCode(this.timerTotal);
        l = this.timerSystemCurrent;
        if (l != null) {
            n2 = ((Object)l).hashCode();
        }
        return ((n * 31 + n3) * 31 + n4) * 31 + n2;
    }

    public final void setTimerSystemCurrent(Long l) {
        this.timerSystemCurrent = l;
    }

    public final void setTimerTotal(long l) {
        this.timerTotal = l;
    }

    public final void setTimerType(int n) {
        this.timerType = n;
    }

    public final void setTimerWhen(Long l) {
        this.timerWhen = l;
    }

    public String toString() {
        int n = this.timerType;
        Long l = this.timerWhen;
        long l2 = this.timerTotal;
        Long l3 = this.timerSystemCurrent;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TimerInfo(timerType=");
        stringBuilder.append(n);
        stringBuilder.append(", timerWhen=");
        stringBuilder.append(l);
        stringBuilder.append(", timerTotal=");
        stringBuilder.append(l2);
        stringBuilder.append(", timerSystemCurrent=");
        stringBuilder.append(l3);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
