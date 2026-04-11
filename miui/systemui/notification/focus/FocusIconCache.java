/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  android.graphics.drawable.Icon
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus;

import G0.s;
import android.graphics.drawable.Icon;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.o;

public final class FocusIconCache {
    public static final FocusIconCache INSTANCE = new FocusIconCache();
    private static final Map<String, Map<String, Icon>> cache = new HashMap<String, Map<String, Icon>>();

    private FocusIconCache() {
    }

    public final Icon get(String object, String string) {
        o.g((Object)object, (String)"notificationKey");
        Map<String, Map<String, Icon>> map = cache;
        synchronized (map) {
            Throwable throwable2;
            block5: {
                block4: {
                    try {
                        object = map.get(object);
                        if (object == null) break block4;
                    }
                    catch (Throwable throwable2) {}
                    object = (Icon)object.get(string);
                    return object;
                    break block5;
                }
                return null;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void put(String string, String string2, Icon icon) {
        o.g((Object)string, (String)"notificationKey");
        o.g((Object)string2, (String)"iconKey");
        Map<String, Map<String, Icon>> map = cache;
        synchronized (map) {
            Throwable throwable2;
            block5: {
                HashMap<String, Icon> hashMap;
                block4: {
                    try {
                        HashMap<String, Icon> hashMap2;
                        hashMap = hashMap2 = map.get(string);
                        if (hashMap2 != null) break block4;
                        hashMap = new HashMap<String, Icon>();
                        map.put(string, hashMap);
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                }
                if (icon != null) {
                    hashMap.put(string2, icon);
                }
                string = s.a;
                return;
            }
            throw throwable2;
        }
    }

    public final void remove(String object) {
        o.g((Object)object, (String)"notificationKey");
        Map<String, Map<String, Icon>> map = cache;
        synchronized (map) {
            object = map.remove(object);
            return;
        }
    }
}
