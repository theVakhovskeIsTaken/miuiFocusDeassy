/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.os.SystemProperties
 *  android.view.MotionEvent
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.MotionEventKt
 */
package miui.systemui.dynamicisland.touch;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.SystemProperties;
import android.view.MotionEvent;
import kotlin.jvm.internal.o;
import miui.systemui.util.MotionEventKt;

public final class TouchEvent {
    public static final Companion Companion = new Object(null){
        {
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
    };
    private static final boolean DEBUG = SystemProperties.getBoolean((String)"debug.sysui.notif.island.touch", (boolean)false);
    public static final String SOURCE_DYNAMIC_ISLAND = "dynamic_island";
    public static final String SOURCE_NOTIF_SHADE = "notif_shade";
    public static final String SOURCE_STATUS_BAR = "status_bar";
    private final MotionEvent event;
    private Boolean result;
    private final String source;

    public TouchEvent(MotionEvent motionEvent, String string) {
        o.g((Object)motionEvent, (String)"event");
        o.g((Object)string, (String)"source");
        this.event = motionEvent;
        this.source = string;
    }

    public static /* synthetic */ TouchEvent copy$default(TouchEvent touchEvent, MotionEvent motionEvent, String string, int n, Object object) {
        if ((n & 1) != 0) {
            motionEvent = touchEvent.event;
        }
        if ((n & 2) != 0) {
            string = touchEvent.source;
        }
        return touchEvent.copy(motionEvent, string);
    }

    public final MotionEvent component1() {
        return this.event;
    }

    public final String component2() {
        return this.source;
    }

    public final TouchEvent copy(MotionEvent motionEvent, String string) {
        o.g((Object)motionEvent, (String)"event");
        o.g((Object)string, (String)"source");
        return new TouchEvent(motionEvent, string);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof TouchEvent)) {
            return false;
        }
        object = (TouchEvent)object;
        if (!o.c((Object)this.event, (Object)((TouchEvent)object).event)) {
            return false;
        }
        return o.c((Object)this.source, (Object)((TouchEvent)object).source);
    }

    public final MotionEvent getEvent() {
        return this.event;
    }

    public final Boolean getResult() {
        return this.result;
    }

    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        return this.event.hashCode() * 31 + this.source.hashCode();
    }

    public final void setResult(Boolean bl) {
        this.result = bl;
    }

    public String toString() {
        String string = MotionEventKt.getMotionEventAction((MotionEvent)this.event);
        String string2 = this.source;
        Boolean bl = this.result;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TouchEvent { action=");
        stringBuilder.append(string);
        stringBuilder.append(", source=");
        stringBuilder.append(string2);
        stringBuilder.append(", result=");
        stringBuilder.append(bl);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
