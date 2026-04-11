/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 */
package miui.systemui.notification.focus.moduleV3;

import U0.a;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import miui.systemui.notification.focus.moduleV3.ModuleTextButtonViewHolder;

public static final class ModuleTextButtonViewHolder.initView.2
extends p
implements a {
    final String $module;
    final ModuleTextButtonViewHolder this$0;

    public ModuleTextButtonViewHolder.initView.2(String string, ModuleTextButtonViewHolder moduleTextButtonViewHolder) {
        this.$module = string;
        this.this$0 = moduleTextButtonViewHolder;
        super(0);
    }

    public final void invoke() {
        String string = this.$module;
        if (o.c((Object)string, (Object)"moduleButton2")) {
            this.this$0.adaptModuleButton2Views();
        } else if (o.c((Object)string, (Object)"moduleButton3")) {
            this.this$0.adaptModuleButton3Views();
        }
    }
}
