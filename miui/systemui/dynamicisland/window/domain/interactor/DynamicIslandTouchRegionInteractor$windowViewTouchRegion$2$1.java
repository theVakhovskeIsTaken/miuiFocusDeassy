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
 *  U0.q
 *  android.graphics.Region
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.q;
import android.graphics.Region;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;

@f(c="miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor$windowViewTouchRegion$2$1", f="DynamicIslandTouchRegionInteractor.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandTouchRegionInteractor.windowViewTouchRegion.1
extends l
implements q {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final DynamicIslandTouchRegionInteractor this$0;

    public DynamicIslandTouchRegionInteractor.windowViewTouchRegion.1(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor, d d2) {
        this.this$0 = dynamicIslandTouchRegionInteractor;
        super(4, d2);
    }

    public final Object invoke(boolean bl, Region region, Region region2, d object) {
        object = new /* invalid duplicate definition of identical inner class */;
        object.Z$0 = bl;
        object.L$0 = region;
        object.L$1 = region2;
        return object.invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label == 0) {
            k.b((Object)object);
            boolean bl = this.Z$0;
            Region region = (Region)this.L$0;
            Region region2 = (Region)this.L$1;
            object = region2;
            if (bl) {
                object = region.isEmpty() ? this.this$0.getFullscreenRegion() : this.this$0.mergeTouchRegions(region);
            }
            return object;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
