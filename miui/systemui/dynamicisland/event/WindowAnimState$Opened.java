/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.h
 */
package miui.systemui.dynamicisland.event;

import kotlin.jvm.internal.h;
import miui.systemui.dynamicisland.event.WindowAnimState;

public static final class WindowAnimState.Opened
extends WindowAnimState {
    private final boolean byAnimEvent;
    private final boolean freeform;
    private final boolean hasAnimate;

    public WindowAnimState.Opened(boolean bl, boolean bl2, boolean bl3) {
        this.freeform = bl;
        this.hasAnimate = bl2;
        this.byAnimEvent = bl3;
    }

    public /* synthetic */ WindowAnimState.Opened(boolean bl, boolean bl2, boolean bl3, int n, h h2) {
        if ((n & 4) != 0) {
            bl3 = true;
        }
        this(bl, bl2, bl3);
    }

    public static /* synthetic */ WindowAnimState.Opened copy$default(WindowAnimState.Opened opened, boolean bl, boolean bl2, boolean bl3, int n, Object object) {
        if ((n & 1) != 0) {
            bl = opened.freeform;
        }
        if ((n & 2) != 0) {
            bl2 = opened.hasAnimate;
        }
        if ((n & 4) != 0) {
            bl3 = opened.byAnimEvent;
        }
        return opened.copy(bl, bl2, bl3);
    }

    public final boolean component1() {
        return this.freeform;
    }

    public final boolean component2() {
        return this.hasAnimate;
    }

    public final boolean component3() {
        return this.byAnimEvent;
    }

    public final WindowAnimState.Opened copy(boolean bl, boolean bl2, boolean bl3) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WindowAnimState.Opened)) {
            return false;
        }
        object = object;
        if (this.freeform != object.freeform) {
            return false;
        }
        if (this.hasAnimate != object.hasAnimate) {
            return false;
        }
        return this.byAnimEvent == object.byAnimEvent;
    }

    public final boolean getByAnimEvent() {
        return this.byAnimEvent;
    }

    public final boolean getFreeform() {
        return this.freeform;
    }

    public final boolean getHasAnimate() {
        return this.hasAnimate;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.freeform) * 31 + Boolean.hashCode(this.hasAnimate)) * 31 + Boolean.hashCode(this.byAnimEvent);
    }

    public String toString() {
        boolean bl = this.freeform;
        boolean bl2 = this.hasAnimate;
        boolean bl3 = this.byAnimEvent;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Opened(freeform=");
        stringBuilder.append(bl);
        stringBuilder.append(", hasAnimate=");
        stringBuilder.append(bl2);
        stringBuilder.append(", byAnimEvent=");
        stringBuilder.append(bl3);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
