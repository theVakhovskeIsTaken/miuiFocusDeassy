/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window;

import U0.a;
import android.graphics.Paint;
import kotlin.jvm.internal.p;

public static final class DynamicIslandWindowController.paint.2
extends p
implements a {
    public static final DynamicIslandWindowController.paint.2 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    public final Paint invoke() {
        Paint paint2 = new Paint(1);
        paint2.setColor(-65281);
        paint2.setStrokeWidth(10.0f);
        paint2.setStyle(Paint.Style.STROKE);
        return paint2;
    }
}
