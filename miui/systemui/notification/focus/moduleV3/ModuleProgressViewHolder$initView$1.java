/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  kotlin.jvm.internal.p
 */
package miui.systemui.notification.focus.moduleV3;

import U0.a;
import kotlin.jvm.internal.p;
import miui.systemui.notification.focus.moduleV3.ModuleProgressViewHolder;

public static final class ModuleProgressViewHolder.initView.1
extends p
implements a {
    final ModuleProgressViewHolder this$0;

    public ModuleProgressViewHolder.initView.1(ModuleProgressViewHolder moduleProgressViewHolder) {
        this.this$0 = moduleProgressViewHolder;
        super(0);
    }

    public final void invoke() {
        ModuleProgressViewHolder moduleProgressViewHolder = this.this$0;
        moduleProgressViewHolder.setProgressThumb(moduleProgressViewHolder.progressBar, this.this$0.progressThumb);
    }
}
