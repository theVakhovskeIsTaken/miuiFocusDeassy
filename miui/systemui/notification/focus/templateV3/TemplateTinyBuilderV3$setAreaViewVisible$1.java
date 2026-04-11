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
package miui.systemui.notification.focus.templateV3;

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
import miui.systemui.notification.focus.templateV3.TemplateTinyBuilderV3;

@f(c="miui.systemui.notification.focus.templateV3.TemplateTinyBuilderV3$setAreaViewVisible$1", f="TemplateTinyBuilderV3.kt", l={}, m="invokeSuspend")
public static final class TemplateTinyBuilderV3.setAreaViewVisible.1
extends l
implements o {
    final int $areaId;
    final int $visible;
    int label;
    final TemplateTinyBuilderV3 this$0;

    public TemplateTinyBuilderV3.setAreaViewVisible.1(TemplateTinyBuilderV3 templateTinyBuilderV3, int n, int n2, d d2) {
        this.this$0 = templateTinyBuilderV3;
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
        c.c();
        if (this.label != 0) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        k.b((Object)object);
        try {
            object = (FrameLayout)this.this$0.tinyLayout.findViewById(this.$areaId);
            if (object != null) {
                object.setVisibility(this.$visible);
            }
            object = (FrameLayout)this.this$0.tinyDarkLayout.findViewById(this.$areaId);
            if (object != null) {
                object.setVisibility(this.$visible);
            }
            object = (FrameLayout)this.this$0.tinyKeyguardLayout.findViewById(this.$areaId);
            if (object != null) {
                object.setVisibility(this.$visible);
            }
            object = (FrameLayout)this.this$0.tinyKeyguardDarkLayout.findViewById(this.$areaId);
            if (object != null) {
                object.setVisibility(this.$visible);
            }
            object = (FrameLayout)this.this$0.tinyModalLayout.findViewById(this.$areaId);
            if (object != null) {
                object.setVisibility(this.$visible);
            }
            object = (FrameLayout)this.this$0.tinyModalDarkLayout.findViewById(this.$areaId);
            if (object == null) {
                return s.a;
            }
            object.setVisibility(this.$visible);
            return s.a;
        }
        catch (Exception exception) {
            Log.e((String)"TemplateTinyBuilderV3", (String)((Object)exception).toString());
        }
        return s.a;
    }
}
