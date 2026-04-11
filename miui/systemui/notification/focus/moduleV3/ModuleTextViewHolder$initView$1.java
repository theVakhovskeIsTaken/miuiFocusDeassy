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
import miui.systemui.notification.focus.moduleV3.ModuleTextViewHolder;

public static final class ModuleTextViewHolder.initView.1
extends p
implements a {
    final ModuleTextViewHolder this$0;

    public ModuleTextViewHolder.initView.1(ModuleTextViewHolder moduleTextViewHolder) {
        this.this$0 = moduleTextViewHolder;
        super(0);
    }

    public final void invoke() {
        this.this$0.checkAndCompressTitleViews();
        this.this$0.checkAndCompressContentViews();
    }
}
