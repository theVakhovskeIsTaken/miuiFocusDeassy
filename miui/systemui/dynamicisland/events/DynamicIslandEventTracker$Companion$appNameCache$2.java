/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.util.LruCache
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.events;

import U0.a;
import android.util.LruCache;
import kotlin.jvm.internal.p;

public static final class DynamicIslandEventTracker.Companion.appNameCache.2
extends p
implements a {
    public static final DynamicIslandEventTracker.Companion.appNameCache.2 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    public final LruCache<String, String> invoke() {
        return new LruCache(30);
    }
}
