/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.view.MotionEvent
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.touch;

import android.graphics.Rect;
import android.graphics.Region;
import android.view.MotionEvent;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;

public static final class TouchEvent.Companion {
    private TouchEvent.Companion() {
    }

    public /* synthetic */ TouchEvent.Companion(h h2) {
        this();
    }

    public final boolean getDEBUG() {
        return DEBUG;
    }

    public final boolean getShouldLog(MotionEvent motionEvent) {
        boolean bl;
        o.g((Object)motionEvent, (String)"<this>");
        boolean bl2 = this.getDEBUG();
        boolean bl3 = bl = true;
        if (!bl2) {
            int n = motionEvent.getActionMasked();
            bl3 = bl;
            if (n != 0) {
                bl3 = bl;
                if (n != 1) {
                    bl3 = n == 3 ? bl : false;
                }
            }
        }
        return bl3;
    }

    public final int getToInt(Boolean bl) {
        int n = bl != null ? (int)(bl.booleanValue() ? 1 : 0) : -1;
        return n;
    }

    public final Boolean getToNullableBoolean(int n) {
        Object object = n != 0 ? (n != 1 ? null : Boolean.TRUE) : Boolean.FALSE;
        return object;
    }

    public final boolean inRect(MotionEvent motionEvent, Rect rect) {
        o.g((Object)motionEvent, (String)"<this>");
        o.g((Object)rect, (String)"rect");
        float f = motionEvent.getX();
        if (f < (float)rect.left) {
            return false;
        }
        if (f > (float)rect.right) {
            return false;
        }
        f = motionEvent.getY();
        if (f < (float)rect.top) {
            return false;
        }
        return !(f > (float)rect.bottom);
    }

    public final boolean inRegion(MotionEvent motionEvent, Region region) {
        o.g((Object)motionEvent, (String)"<this>");
        o.g((Object)region, (String)"region");
        return region.contains((int)motionEvent.getX(), (int)motionEvent.getY());
    }
}
