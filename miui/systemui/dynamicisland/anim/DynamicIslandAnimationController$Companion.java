/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.anim;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;

public static final class DynamicIslandAnimationController.Companion {
    private DynamicIslandAnimationController.Companion() {
    }

    public /* synthetic */ DynamicIslandAnimationController.Companion(h h2) {
        this();
    }

    private final Method getSetMiSelfBlurMethod() {
        return (Method)setMiSelfBlurMethod$delegate.getValue();
    }

    public final void setMiSelfBlurCompat(View view, int n) {
        block3: {
            o.g((Object)view, (String)"<this>");
            Method method = this.getSetMiSelfBlurMethod();
            if (method == null) break block3;
            try {
                method.invoke((Object)view, n, null);
            }
            catch (Throwable throwable) {
                Log.e((String)"DynamicIslandAnimDebug", (String)"Invoke setMiSelfBlurMethod failed.", (Throwable)throwable);
            }
        }
    }
}
