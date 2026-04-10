/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.util.Log
 *  i1.g
 *  kotlin.jvm.internal.o
 *  miui.systemui.Prefs
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import i1.g;
import kotlin.jvm.internal.o;
import miui.systemui.Prefs;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewRefactor;

public static final class DynamicIslandWindowViewRefactor.listenForExpandedState.2<T>
implements g {
    final DynamicIslandWindowViewRefactor this$0;

    public DynamicIslandWindowViewRefactor.listenForExpandedState.2(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor) {
        this.this$0 = dynamicIslandWindowViewRefactor;
    }

    public final Object emit(boolean bl, d object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("expandedState ");
        ((StringBuilder)object).append(bl);
        Log.e((String)"DynamicIslandWindowViewRefactor", (String)((StringBuilder)object).toString());
        object = new Intent("com.miui.action.ACTION_EXPANDED_STATE_CHANGED");
        object.putExtra("islandExpanded", bl);
        SharedPreferences sharedPreferences = Prefs.getNotif((Context)this.this$0.sysUIContext);
        o.f((Object)sharedPreferences, (String)"getNotif(...)");
        sharedPreferences = sharedPreferences.edit();
        sharedPreferences.putBoolean("islandExpanded", bl);
        sharedPreferences.apply();
        this.this$0.context.sendBroadcast((Intent)object);
        return s.a;
    }
}
