/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.b
 *  K0.d
 *  U0.o
 *  i1.g
 *  kotlin.jvm.internal.j
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.content;

import G0.b;
import K0.d;
import i1.g;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;

public static final class DynamicIslandBaseContentViewController.sam.kotlinx_coroutines_flow_FlowCollector.0
implements g,
j {
    private final U0.o function;

    public DynamicIslandBaseContentViewController.sam.kotlinx_coroutines_flow_FlowCollector.0(U0.o o2) {
        o.g((Object)o2, (String)"function");
        this.function = o2;
    }

    public final /* synthetic */ Object emit(Object object, d d2) {
        return this.function.invoke(object, (Object)d2);
    }

    public final boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof g;
        boolean bl3 = bl = false;
        if (bl2) {
            bl3 = bl;
            if (object instanceof j) {
                bl3 = o.c((Object)this.getFunctionDelegate(), (Object)((j)object).getFunctionDelegate());
            }
        }
        return bl3;
    }

    public final b getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return this.getFunctionDelegate().hashCode();
    }
}
