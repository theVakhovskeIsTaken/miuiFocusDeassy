/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.util.Log
 *  android.widget.FrameLayout
 *  f1.E
 */
package miui.systemui.dynamicisland.template;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.util.Log;
import android.widget.FrameLayout;
import f1.E;
import miui.systemui.dynamicisland.template.IslandTemplateBuilder;

@f(c="miui.systemui.dynamicisland.template.IslandTemplateBuilder$setIslandAreaViewVisible$1", f="IslandTemplateBuilder.kt", l={}, m="invokeSuspend")
public static final class IslandTemplateBuilder.setIslandAreaViewVisible.1
extends l
implements o {
    final int $areaId;
    final int $visible;
    int label;
    final IslandTemplateBuilder this$0;

    public IslandTemplateBuilder.setIslandAreaViewVisible.1(IslandTemplateBuilder islandTemplateBuilder, int n, int n2, d d2) {
        this.this$0 = islandTemplateBuilder;
        this.$areaId = n;
        this.$visible = n2;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object invokeSuspend(Object object) {
        Exception exception2;
        block3: {
            c.c();
            if (this.label != 0) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            k.b((Object)object);
            try {
                object = this.this$0.islandLayout;
                object = object != null ? (FrameLayout)object.findViewById(this.$areaId) : null;
            }
            catch (Exception exception2) {
                break block3;
            }
            if (object == null) {
                return s.a;
            }
            object.setVisibility(this.$visible);
            return s.a;
        }
        Log.e((String)"IslandTemplateBuilder", (String)((Object)exception2).toString());
        return s.a;
    }
}
