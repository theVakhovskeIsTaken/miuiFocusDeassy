/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;

public static final class DynamicMiniWindowDataRepo.updateDataInfo.set.1
extends p
implements Function1 {
    public static final DynamicMiniWindowDataRepo.updateDataInfo.set.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    public final ConcurrentHashMap.KeySetView<Integer, Boolean> invoke(String string) {
        o.g((Object)string, (String)"it");
        return ConcurrentHashMap.newKeySet();
    }
}
