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
 *  android.graphics.Region
 *  android.util.Log
 *  android.view.ViewTreeObserver$InternalInsetsInfo
 *  f1.E
 *  i1.g
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.graphics.Region;
import android.util.Log;
import android.view.ViewTreeObserver;
import f1.E;
import i1.g;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;

@f(c="miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor$updateInternalInsets$1", f="DynamicIslandTouchRegionInteractor.kt", l={118}, m="invokeSuspend")
public static final class DynamicIslandTouchRegionInteractor.updateInternalInsets.1
extends l
implements o {
    int label;
    final DynamicIslandTouchRegionInteractor this$0;

    public DynamicIslandTouchRegionInteractor.updateInternalInsets.1(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor, d d2) {
        this.this$0 = dynamicIslandTouchRegionInteractor;
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
            if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            k.b((Object)object);
            return s.a;
        } else {
            k.b((Object)object);
            object = this.this$0.computeInternalInsetsEvent;
            g g2 = new g(this.this$0){
                final DynamicIslandTouchRegionInteractor this$0;
                {
                    this.this$0 = dynamicIslandTouchRegionInteractor;
                }

                public final Object emit(ViewTreeObserver.InternalInsetsInfo internalInsetsInfo, d d2) {
                    if (DynamicIslandTouchRegionInteractor.access$getDEBUG$cp()) {
                        Log.d((String)"DynamicIslandTouchRegionInteractor", (String)"updateInternalInsets");
                    }
                    internalInsetsInfo.setTouchableInsets(3);
                    internalInsetsInfo.touchableRegion.set((Region)this.this$0.getWindowViewTouchRegion().getValue());
                    return s.a;
                }
            };
            this.label = 1;
            if (object.collect(g2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
