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
 *  U0.a
 *  U0.o
 *  f1.E
 *  i1.f
 *  i1.g
 */
package miui.systemui.notification.focus.moduleV3;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.l;
import U0.a;
import U0.o;
import f1.E;
import i1.f;
import i1.g;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;

@M0.f(c="miui.systemui.notification.focus.moduleV3.ModuleViewHolder$registerCompressChanged$1", f="ModuleViewHolder.kt", l={172}, m="invokeSuspend")
public static final class ModuleViewHolder.registerCompressChanged.1
extends l
implements o {
    final a $action;
    int label;
    final ModuleViewHolder this$0;

    public ModuleViewHolder.registerCompressChanged.1(ModuleViewHolder moduleViewHolder, a a2, d d2) {
        this.this$0 = moduleViewHolder;
        this.$action = a2;
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
    public final Object invokeSuspend(Object g2) {
        Object object = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            k.b((Object)g2);
            return s.a;
        } else {
            k.b((Object)g2);
            f f2 = this.this$0.getCompressChanged();
            g2 = new g(this.$action){
                final a $action;
                {
                    this.$action = a2;
                }

                public final Object emit(boolean bl, d d2) {
                    this.$action.invoke();
                    return s.a;
                }
            };
            this.label = 1;
            if (f2.collect(g2, (d)this) != object) return s.a;
            return object;
        }
    }
}
