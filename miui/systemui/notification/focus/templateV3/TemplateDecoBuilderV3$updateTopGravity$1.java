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
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.android.systemui.miui.notification.R;
import f1.E;

@f(c="miui.systemui.notification.focus.templateV3.TemplateDecoBuilderV3$updateTopGravity$1", f="TemplateDecoBuilderV3.kt", l={}, m="invokeSuspend")
public static final class TemplateDecoBuilderV3.updateTopGravity.1
extends l
implements o {
    final boolean $isCenterVertical;
    final View $parent;
    int label;

    public TemplateDecoBuilderV3.updateTopGravity.1(View view, boolean bl, d d2) {
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

    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label == 0) {
            k.b((Object)object);
            object = (LinearLayout)this.$parent.findViewById(R.id.area_top);
            if (object != null) {
                boolean bl = this.$isCenterVertical;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(2, R.id.area_bottom);
                object.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                int n = bl ? 16 : 48;
                object.setGravity(n);
            }
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
