/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.graphics.Region
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  f1.E
 *  i1.I
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import f1.E;
import i1.I;
import i1.g;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView$initEventCoordinator$1", f="DynamicIslandWindowView.kt", l={322}, m="invokeSuspend")
public static final class DynamicIslandWindowView.initEventCoordinator.1
extends l
implements o {
    int label;
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.initEventCoordinator.1(DynamicIslandWindowView dynamicIslandWindowView, d d2) {
        this.this$0 = dynamicIslandWindowView;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Object invokeSuspend(Object object) {
        Object object2 = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b((Object)object);
            throw new G0.c();
        } else {
            I i2;
            k.b((Object)object);
            object = this.this$0.getEventCoordinator();
            if (object == null || (i2 = ((DynamicIslandEventCoordinator)object).getIslandRegion()) == null) return s.a;
            object = new g(this.this$0){
                final DynamicIslandWindowView this$0;
                {
                    this.this$0 = dynamicIslandWindowView;
                }

                public final Object emit(Region region, d object) {
                    boolean bl = this.this$0.getWindowViewController().getWindowState().isToScreenLockNoAnimation();
                    object = new StringBuilder();
                    ((StringBuilder)object).append("islandRegion ");
                    ((StringBuilder)object).append(region);
                    ((StringBuilder)object).append(" ");
                    ((StringBuilder)object).append(bl);
                    Log.e((String)"DynamicIslandWindowViewImpl", (String)((StringBuilder)object).toString());
                    object = new Bundle();
                    object.putString("action_key", "action_back_island_width_changed");
                    object.putBoolean("extra_back_change_island_region_no_anim", bl);
                    object.putParcelable("extra_back_island_region", (Parcelable)region);
                    region = DynamicIslandWindowView.access$getListener$p(this.this$0);
                    if (region != null) {
                        region.onIslandViewChanged((Bundle)object);
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (i2.collect((g)object, (d)this) != object2) throw new G0.c();
            return object2;
        }
    }
}
