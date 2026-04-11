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
import miui.systemui.notification.focus.moduleV3.ModuleTinyProgressViewHolder;

public static final class ModuleTinyProgressViewHolder.initView.1
extends p
implements a {
    final ModuleTinyProgressViewHolder this$0;

    public ModuleTinyProgressViewHolder.initView.1(ModuleTinyProgressViewHolder moduleTinyProgressViewHolder) {
        this.this$0 = moduleTinyProgressViewHolder;
        super(0);
    }

    public final void invoke() {
        ModuleTinyProgressViewHolder moduleTinyProgressViewHolder = this.this$0;
        moduleTinyProgressViewHolder.setProgressThumb(moduleTinyProgressViewHolder.progressBar, this.this$0.progressThumb);
    }
}
