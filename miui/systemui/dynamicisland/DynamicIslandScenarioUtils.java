/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.SystemClock
 *  android.util.Log
 *  android.view.ThreadedRenderer
 *  android.view.View
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 *  z0.a
 */
package miui.systemui.dynamicisland;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.ThreadedRenderer;
import android.view.View;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.o;
import miui.systemui.util.CommonUtils;
import z0.a;

public final class DynamicIslandScenarioUtils {
    public static final boolean DEBUG = true;
    public static final DynamicIslandScenarioUtils INSTANCE = new DynamicIslandScenarioUtils();
    public static final long ISLAND_CLOSE_APP_JANK = 359L;
    public static final long ISLAND_CLOSE_BIG_ISLAND_JANK = 435L;
    public static final long ISLAND_CLOSE_EXPAND_JANK = 476L;
    public static final long ISLAND_CLOSE_FREEFORM_JANK = 361L;
    public static final long ISLAND_CLOSE_SMALL_ISLAND_JANK = 439L;
    public static final long ISLAND_OPEN_APP_JANK = 358L;
    public static final long ISLAND_OPEN_FREEFORM_JANK = 360L;
    public static final long ISLAND_SHOW_BIG_ISLAND_JANK = 434L;
    public static final long ISLAND_SHOW_EXPAND_JANK = 475L;
    public static final long ISLAND_SHOW_SMALL_ISLAND_JANK = 438L;
    public static final long ISLAND_STATE_CHANGE_ANIMATION = 357L;
    public static final long ISLAND_SWIPE_IN_BIG_JANK = 494L;
    public static final long ISLAND_SWIPE_IN_EXPAND_JANK = 496L;
    public static final long ISLAND_SWIPE_IN_SMALL_JANK = 495L;
    public static final long ISLAND_SWITCH_BIG_TO_EXPAND_JANK = 437L;
    public static final long ISLAND_SWITCH_BIG_TO_SMALL_JANK = 436L;
    public static final long ISLAND_SWITCH_EXPAND_TO_BIG_JANK = 477L;
    public static final long ISLAND_SWITCH_EXPAND_TO_SMALL_JANK = 478L;
    public static final long ISLAND_SWITCH_SMALL_TO_BIG_JANK = 440L;
    public static final long ISLAND_SWITCH_SMALL_TO_EXPAND_JANK = 474L;
    public static final String TAG = "DynamicIslandScenarioUtils";
    private static Bundle cachedBundle;
    private static int cachedTid;
    private static int dynamicIslandRenderThreadId;
    private static boolean isBigTracking;
    private static boolean isExpandTracking;
    private static boolean isSmallTracking;

    private DynamicIslandScenarioUtils() {
    }

    public static /* synthetic */ void setDynamicIslandScenarioState$default(DynamicIslandScenarioUtils dynamicIslandScenarioUtils, long l, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        dynamicIslandScenarioUtils.setDynamicIslandScenarioState(l, bl);
    }

    public final boolean isBigTracking() {
        return isBigTracking;
    }

    public final boolean isExpandTracking() {
        return isExpandTracking;
    }

    public final boolean isSmallTracking() {
        return isSmallTracking;
    }

    public final void log(long l, boolean bl) {
        boolean bl2 = CommonUtils.IS_MULTI_RENDER_THREAD;
        int n = dynamicIslandRenderThreadId;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setScenarioState, type: ");
        stringBuilder.append(l);
        stringBuilder.append(", isStart: ");
        stringBuilder.append(bl);
        stringBuilder.append(", isMultiRenderThread: ");
        stringBuilder.append(bl2);
        stringBuilder.append(", dynamicIslandRenderThreadId: ");
        stringBuilder.append(n);
        Log.i((String)TAG, (String)stringBuilder.toString());
    }

    public final void setBigTracking(boolean bl) {
        isBigTracking = bl;
    }

    public final void setDynamicIslandRenderThreadId(View object) {
        o.g((Object)object, (String)"view");
        if (dynamicIslandRenderThreadId == 0) {
            int n;
            block16: {
                int n2;
                int n3 = 0;
                n = n2 = 0;
                ThreadedRenderer threadedRenderer = object.getThreadedRenderer();
                n = n3;
                if (threadedRenderer == null) break block16;
                n = n2;
                AnnotatedElement annotatedElement = threadedRenderer.getClass().getSuperclass();
                n = n3;
                if (annotatedElement == null) break block16;
                n = n2;
                object = ((Class)annotatedElement).getDeclaredMethod("nGetRenderThreadTid", Long.TYPE);
                n = n2;
                ((AccessibleObject)object).setAccessible(true);
                n = n2;
                annotatedElement = ((Class)annotatedElement).getDeclaredField("mNativeProxy");
                n = n2;
                ((AccessibleObject)annotatedElement).setAccessible(true);
                n = n2;
                object = ((Method)object).invoke((Object)threadedRenderer, ((Field)annotatedElement).getLong(threadedRenderer));
                n = n2;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.Int");
                n = n2;
                n = n3 = ((Integer)object).intValue();
                n = n3;
                object = new StringBuilder();
                n = n3;
                ((StringBuilder)object).append("setDynamicIslandRenderThreadId  tid=");
                n = n3;
                ((StringBuilder)object).append(n3);
                n = n3;
                try {
                    Log.d((String)TAG, (String)((StringBuilder)object).toString());
                    n = n3;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            dynamicIslandRenderThreadId = n;
        }
    }

    public final void setDynamicIslandScenarioState(long l, boolean bl) {
        if (l > 0L) {
            int n;
            this.log(l, bl);
            long l2 = SystemClock.elapsedRealtime();
            if (CommonUtils.IS_MULTI_RENDER_THREAD && (n = dynamicIslandRenderThreadId) != 0) {
                if (cachedBundle == null || cachedTid != n) {
                    Bundle bundle = new Bundle();
                    bundle.putIntArray("tids", new int[]{dynamicIslandRenderThreadId});
                    cachedBundle = bundle;
                    cachedTid = dynamicIslandRenderThreadId;
                }
                a.a().d(l, l2, bl, cachedBundle);
            } else {
                a.a().c(l, l2, bl);
            }
        }
    }

    public final void setExpandTracking(boolean bl) {
        isExpandTracking = bl;
    }

    public final void setSmallTracking(boolean bl) {
        isSmallTracking = bl;
    }

    public final void setSwipeExpandStart() {
        this.setDynamicIslandScenarioState(496L, true);
        isExpandTracking = true;
    }

    public final void setSwipeIslandStart(boolean bl, boolean bl2, boolean bl3) {
        if (!bl && !bl3) {
            if (bl2) {
                this.setDynamicIslandScenarioState(495L, true);
                isSmallTracking = true;
            }
            return;
        }
        this.setDynamicIslandScenarioState(494L, true);
        isBigTracking = true;
    }
}
