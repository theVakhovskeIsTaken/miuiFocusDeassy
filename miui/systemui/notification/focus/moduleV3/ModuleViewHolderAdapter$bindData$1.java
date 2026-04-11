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
import f1.E;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolderAdapter;

@f(c="miui.systemui.notification.focus.moduleV3.ModuleViewHolderAdapter$bindData$1", f="ModuleViewHolderAdapter.kt", l={}, m="invokeSuspend")
public static final class ModuleViewHolderAdapter.bindData.1
extends l
implements o {
    final String $moduleType;
    final StatusBarNotification $sbn;
    int label;
    final ModuleViewHolderAdapter this$0;

    public ModuleViewHolderAdapter.bindData.1(ModuleViewHolderAdapter moduleViewHolderAdapter, String string, StatusBarNotification statusBarNotification, d d2) {
        this.this$0 = moduleViewHolderAdapter;
        this.$moduleType = string;
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
            StatusBarNotification statusBarNotification;
            Object object2;
            ModuleViewHolderAdapter moduleViewHolderAdapter;
            k.b((Object)object);
            object = (Template)this.this$0.dataMap.get(this.$moduleType);
            if (object != null) {
                moduleViewHolderAdapter = this.this$0;
                object2 = this.$moduleType;
                statusBarNotification = this.$sbn;
                object2 = (ModuleViewHolder)moduleViewHolderAdapter.holders.get(object2);
                if (object2 != null) {
                    ((ModuleViewHolder)object2).bind((Template)object, statusBarNotification);
                }
            }
            if (object != null) {
                moduleViewHolderAdapter = this.this$0;
                object2 = this.$moduleType;
                statusBarNotification = this.$sbn;
                object2 = (ModuleViewHolder)moduleViewHolderAdapter.tinyHolders.get(object2);
                if (object2 != null) {
                    ((ModuleViewHolder)object2).bind((Template)object, statusBarNotification);
                }
            }
            if (object != null) {
                moduleViewHolderAdapter = this.this$0;
                object2 = this.$moduleType;
                statusBarNotification = this.$sbn;
                object2 = (ModuleViewHolder)moduleViewHolderAdapter.decoHolders.get(object2);
                if (object2 != null) {
                    ((ModuleViewHolder)object2).bind((Template)object, statusBarNotification);
                }
            }
            if (object != null) {
                moduleViewHolderAdapter = this.this$0;
                object2 = this.$moduleType;
                statusBarNotification = this.$sbn;
                object2 = (ModuleViewHolder)moduleViewHolderAdapter.decoLandHolders.get(object2);
                if (object2 != null) {
                    ((ModuleViewHolder)object2).bind((Template)object, statusBarNotification);
                }
            }
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
