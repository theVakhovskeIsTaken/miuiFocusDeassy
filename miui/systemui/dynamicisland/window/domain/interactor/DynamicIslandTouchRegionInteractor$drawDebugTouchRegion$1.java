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
 *  android.graphics.Canvas
 *  android.graphics.Region
 *  f1.E
 *  i1.g
 *  i1.y
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.graphics.Canvas;
import android.graphics.Region;
import f1.E;
import i1.g;
import i1.y;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;

@f(c="miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor$drawDebugTouchRegion$1", f="DynamicIslandTouchRegionInteractor.kt", l={128}, m="invokeSuspend")
public static final class DynamicIslandTouchRegionInteractor.drawDebugTouchRegion.1
extends l
implements o {
    int label;
    final DynamicIslandTouchRegionInteractor this$0;

    public DynamicIslandTouchRegionInteractor.drawDebugTouchRegion.1(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor, d d2) {
        this.this$0 = dynamicIslandTouchRegionInteractor;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object g2) {
        Object object = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b((Object)g2);
        } else {
            k.b((Object)g2);
            y y2 = this.this$0.windowView.getDispatchDrawEvent();
            g2 = new g(this.this$0){
                final DynamicIslandTouchRegionInteractor this$0;
                {
                    this.this$0 = dynamicIslandTouchRegionInteractor;
                }

                public final Object emit(Canvas canvas, d d2) {
                    canvas.drawRect(((Region)this.this$0.getWindowViewTouchRegion().getValue()).getBounds(), DynamicIslandTouchRegionInteractor.access$getPaint(this.this$0));
                    return s.a;
                }
            };
            this.label = 1;
            if (y2.collect(g2, (d)this) == object) {
                return object;
            }
        }
        throw new G0.c();
    }
}
