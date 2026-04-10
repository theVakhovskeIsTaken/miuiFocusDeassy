/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleRegistry
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window;

import U0.a;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

public static final class DynamicIslandWindowView.lifecycle.2
extends p
implements a {
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.lifecycle.2(DynamicIslandWindowView dynamicIslandWindowView) {
        this.this$0 = dynamicIslandWindowView;
        super(0);
    }

    public final LifecycleRegistry invoke() {
        return new LifecycleRegistry((LifecycleOwner)this.this$0);
    }
}
