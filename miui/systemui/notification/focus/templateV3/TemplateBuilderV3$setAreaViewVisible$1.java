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
 *  android.view.View
 *  android.widget.FrameLayout
 *  f1.E
 */
package miui.systemui.notification.focus.templateV3;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import f1.E;
import miui.systemui.notification.focus.templateV3.TemplateBuilderV3;

@f(c="miui.systemui.notification.focus.templateV3.TemplateBuilderV3$setAreaViewVisible$1", f="TemplateBuilderV3.kt", l={}, m="invokeSuspend")
public static final class TemplateBuilderV3.setAreaViewVisible.1
extends l
implements o {
    final int $areaId;
    final int $visible;
    int label;
    final TemplateBuilderV3 this$0;

    public TemplateBuilderV3.setAreaViewVisible.1(TemplateBuilderV3 templateBuilderV3, int n, int n2, d d2) {
        this.this$0 = templateBuilderV3;
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
        block9: {
            Object var2_3;
            c.c();
            if (this.label != 0) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            k.b((Object)object);
            try {
                object = this.this$0.islandLayout;
                var2_3 = null;
                object = object != null ? (FrameLayout)object.findViewById(this.$areaId) : null;
            }
            catch (Exception exception2) {
                break block9;
            }
            if (object != null) {
                object.setVisibility(this.$visible);
            }
            object = this.this$0.islandLayoutFake;
            object = object != null ? (FrameLayout)object.findViewById(this.$areaId) : null;
            if (object != null) {
                object.setVisibility(this.$visible);
            }
            object = this.this$0.focusLayout;
            object = object != null ? (FrameLayout)object.findViewById(this.$areaId) : null;
            if (object != null) {
                object.setVisibility(this.$visible);
            }
            object = this.this$0.focusDarkLayout;
            object = object != null ? (FrameLayout)object.findViewById(this.$areaId) : null;
            if (object != null) {
                object.setVisibility(this.$visible);
            }
            object = this.this$0.focusModalLayout;
            object = object != null ? (FrameLayout)object.findViewById(this.$areaId) : null;
            if (object != null) {
                object.setVisibility(this.$visible);
            }
            View view = this.this$0.focusModalDarkLayout;
            object = var2_3;
            if (view != null) {
                object = (FrameLayout)view.findViewById(this.$areaId);
            }
            if (object == null) {
                return s.a;
            }
            object.setVisibility(this.$visible);
            return s.a;
        }
        Log.d((String)"TemplateBuilderV3", (String)((Object)exception2).toString());
        return s.a;
    }
}
