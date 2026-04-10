/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  U0.a
 *  U0.q
 *  android.graphics.Region
 *  f1.E
 *  i1.E
 *  i1.I
 *  i1.f
 *  i1.h
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import U0.a;
import U0.q;
import android.graphics.Region;
import f1.E;
import i1.I;
import i1.f;
import i1.h;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;

public static final class DynamicIslandTouchRegionInteractor.windowViewTouchRegion.2
extends p
implements a {
    final DynamicIslandTouchRegionInteractor this$0;

    public DynamicIslandTouchRegionInteractor.windowViewTouchRegion.2(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        this.this$0 = dynamicIslandTouchRegionInteractor;
        super(0);
    }

    public final I invoke() {
        I i2 = this.this$0.getWindowViewController().isFreeformAnimRunning();
        I i3 = this.this$0.getWindowViewController().getFreeformAnimRegion();
        I i4 = this.this$0.getTouchRegion();
        i4 = h.j((f)i2, (f)i3, (f)i4, (q)new q(this.this$0, null){
            Object L$0;
            Object L$1;
            boolean Z$0;
            int label;
            final DynamicIslandTouchRegionInteractor this$0;
            {
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
                        object = region.isEmpty() ? DynamicIslandTouchRegionInteractor.access$getFullscreenRegion(this.this$0) : DynamicIslandTouchRegionInteractor.access$mergeTouchRegions(this.this$0, region, region2);
                    }
                    return object;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        });
        return h.B((f)i4, (E)this.this$0.scope, (i1.E)i1.E.a.c(), (Object)new Region());
    }
}
