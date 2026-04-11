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
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.android.systemui.miui.notification.R$id
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
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.android.systemui.miui.notification.R;
import f1.E;

@f(c="miui.systemui.notification.focus.templateV3.TemplateTinyBuilderV3$updateAreaCenterGravity$1", f="TemplateTinyBuilderV3.kt", l={}, m="invokeSuspend")
public static final class TemplateTinyBuilderV3.updateAreaCenterGravity.1
extends l
implements o {
    final boolean $isCenterVertical;
    final View $parent;
    int label;

    public TemplateTinyBuilderV3.updateAreaCenterGravity.1(View view, boolean bl, d d2) {
        this.$parent = view;
        this.$isCenterVertical = bl;
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
        block5: {
            boolean bl;
            FrameLayout frameLayout;
            c.c();
            if (this.label != 0) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            k.b((Object)object);
            try {
                frameLayout = (FrameLayout)this.$parent.findViewById(R.id.area_a);
                if (frameLayout == null) return s.a;
                bl = this.$isCenterVertical;
                object = frameLayout.getLayoutParams();
                object = object instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams)object : null;
            }
            catch (Exception exception2) {
                break block5;
            }
            if (object == null) {
                return s.a;
            }
            if (bl) {
                object.addRule(15);
                object.removeRule(10);
                object.removeRule(12);
            } else {
                object.addRule(10);
                object.removeRule(15);
                object.removeRule(12);
            }
            frameLayout.setLayoutParams((ViewGroup.LayoutParams)object);
            return s.a;
        }
        Log.e((String)"TemplateTinyBuilderV3", (String)((Object)exception2).toString());
        return s.a;
    }
}
