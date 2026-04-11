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
 *  android.service.notification.StatusBarNotification
 *  android.util.Log
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
import android.service.notification.StatusBarNotification;
import android.util.Log;
import f1.E;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolderAdapter;

@f(c="miui.systemui.notification.focus.moduleV3.ModuleViewHolderAdapter$updateView$1", f="ModuleViewHolderAdapter.kt", l={}, m="invokeSuspend")
public static final class ModuleViewHolderAdapter.updateView.1
extends l
implements o {
    final String $moduleType;
    final StatusBarNotification $sbn;
    final Template $template;
    int label;
    final ModuleViewHolderAdapter this$0;

    public ModuleViewHolderAdapter.updateView.1(ModuleViewHolderAdapter moduleViewHolderAdapter, String string, Template template, StatusBarNotification statusBarNotification, d d2) {
        this.this$0 = moduleViewHolderAdapter;
        this.$moduleType = string;
        this.$template = template;
        this.$sbn = statusBarNotification;
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
            this.this$0.dataMap.put(this.$moduleType, this.$template);
            object = (ModuleViewHolder)this.this$0.holders.get(this.$moduleType);
            if (object != null) {
                ((ModuleViewHolder)object).updatePartial(this.$template, this.$sbn);
            }
            if ((object = (ModuleViewHolder)this.this$0.tinyHolders.get(this.$moduleType)) != null) {
                ((ModuleViewHolder)object).updatePartial(this.$template, this.$sbn);
            }
            if ((object = (ModuleViewHolder)this.this$0.decoHolders.get(this.$moduleType)) != null) {
                ((ModuleViewHolder)object).updatePartial(this.$template, this.$sbn);
            }
            if ((object = (ModuleViewHolder)this.this$0.decoLandHolders.get(this.$moduleType)) != null) {
                ((ModuleViewHolder)object).updatePartial(this.$template, this.$sbn);
            }
            String string = this.$moduleType;
            int n = this.this$0.holders.size();
            object = new StringBuilder();
            ((StringBuilder)object).append("updateView");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(n);
            Log.e((String)"ModuleViewHolderAdapter", (String)((StringBuilder)object).toString());
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
