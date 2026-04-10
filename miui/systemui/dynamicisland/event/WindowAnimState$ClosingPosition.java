/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.event;

import miui.systemui.dynamicisland.event.WindowAnimState;

public static final class WindowAnimState.ClosingPosition
extends WindowAnimState {
    private final boolean freeform;

    public WindowAnimState.ClosingPosition(boolean bl) {
        this.freeform = bl;
    }

    public static /* synthetic */ WindowAnimState.ClosingPosition copy$default(WindowAnimState.ClosingPosition closingPosition, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = closingPosition.freeform;
        }
        return closingPosition.copy(bl);
    }

    public final boolean component1() {
        return this.freeform;
    }

    public final WindowAnimState.ClosingPosition copy(boolean bl) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WindowAnimState.ClosingPosition)) {
            return false;
        }
        object = object;
        return this.freeform == object.freeform;
    }

    public final boolean getFreeform() {
        return this.freeform;
    }

    public int hashCode() {
        return Boolean.hashCode(this.freeform);
    }

    public String toString() {
        boolean bl = this.freeform;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClosingPosition(freeform=");
        stringBuilder.append(bl);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
