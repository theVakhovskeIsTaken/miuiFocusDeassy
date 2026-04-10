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
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.content;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import java.util.ArrayList;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;

@f(c="miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController$1$2", f="DynamicIslandBaseContentViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandBaseContentViewController.2
extends l
implements U0.o {
    Object L$0;
    int label;
    final DynamicIslandBaseContentViewController<T> this$0;

    public DynamicIslandBaseContentViewController.2(DynamicIslandBaseContentViewController<? extends T> dynamicIslandBaseContentViewController, d d2) {
        this.this$0 = dynamicIslandBaseContentViewController;
        super(2, d2);
    }

    public final d create(Object object, d object2) {
        object2 = new /* invalid duplicate definition of identical inner class */;
        object2.L$0 = object;
        return object2;
    }

    public final Object invoke(ArrayList<? extends Object> arrayList, d d2) {
        return (this.create(arrayList, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label == 0) {
            k.b((Object)object);
            ArrayList arrayList = (ArrayList)this.L$0;
            boolean bl = true;
            if (arrayList.get(1) != null) {
                object = arrayList.get(1);
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                object = (String)object;
            } else {
                object = "";
            }
            Object e = arrayList.get(2);
            o.e(e, (String)"null cannot be cast to non-null type kotlin.Boolean");
            boolean bl2 = (Boolean)e;
            e = arrayList.get(3);
            o.e(e, (String)"null cannot be cast to non-null type kotlin.Boolean");
            boolean bl3 = bl;
            if (!((Boolean)e).booleanValue()) {
                arrayList = arrayList.get(4);
                o.e((Object)arrayList, (String)"null cannot be cast to non-null type kotlin.Boolean");
                bl3 = (Boolean)((Object)arrayList) != false ? bl : false;
            }
            ((DynamicIslandBaseContentView)((Object)this.this$0.getView())).updateDarkLightMode(((DynamicIslandBaseContentView)((Object)this.this$0.getView())).getState(), (String)object, bl2, bl3);
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
