/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.Resources
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import kotlin.jvm.internal.o;

public static final class DynamicIslandUtils.contextWrapper.1
extends ContextWrapper {
    final Context $context;

    public DynamicIslandUtils.contextWrapper.1(Context context) {
        this.$context = context;
        super(context);
    }

    public Context getApplicationContext() {
        return onlyApplicationContext;
    }

    public Resources getResources() {
        Resources resources = this.$context.getResources();
        o.f((Object)resources, (String)"getResources(...)");
        return resources;
    }
}
