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
 *  f1.E
 */
package miui.systemui.notification.focus.moduleV3;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import f1.E;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolderAdapter;

@f(c="miui.systemui.notification.focus.moduleV3.ModuleViewHolderAdapter$removeView$1", f="ModuleViewHolderAdapter.kt", l={}, m="invokeSuspend")
public static final class ModuleViewHolderAdapter.removeView.1
extends l
implements o {
    final String $moduleType;
    int label;
    final ModuleViewHolderAdapter this$0;

    public ModuleViewHolderAdapter.removeView.1(ModuleViewHolderAdapter moduleViewHolderAdapter, String string, d d2) {
        this.this$0 = moduleViewHolderAdapter;
        this.$moduleType = string;
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
            object = (ModuleViewHolder)this.this$0.holders.remove(this.$moduleType);
            if (object != null) {
                ((ModuleViewHolder)object).onDetach();
            }
            if ((object = (ModuleViewHolder)this.this$0.tinyHolders.remove(this.$moduleType)) != null) {
                ((ModuleViewHolder)object).onDetach();
            }
            if ((object = (ModuleViewHolder)this.this$0.decoHolders.remove(this.$moduleType)) != null) {
                ((ModuleViewHolder)object).onDetach();
            }
            if ((object = (ModuleViewHolder)this.this$0.decoLandHolders.remove(this.$moduleType)) != null) {
                ((ModuleViewHolder)object).onDetach();
            }
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
