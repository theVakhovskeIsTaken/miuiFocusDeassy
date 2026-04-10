/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  f1.E
 */
package miui.systemui.dynamicisland.display;

import E0.e;
import F0.a;
import f1.E;
import miui.systemui.dynamicisland.display.AvoidScreenBurnInHelper;

public final class AvoidScreenBurnInHelper_Factory
implements e {
    private final a scopeProvider;

    public AvoidScreenBurnInHelper_Factory(a a2) {
        this.scopeProvider = a2;
    }

    public static AvoidScreenBurnInHelper_Factory create(a a2) {
        return new AvoidScreenBurnInHelper_Factory(a2);
    }

    public static AvoidScreenBurnInHelper newInstance(E e2) {
        return new AvoidScreenBurnInHelper(e2);
    }

    public AvoidScreenBurnInHelper get() {
        return AvoidScreenBurnInHelper_Factory.newInstance((E)this.scopeProvider.get());
    }
}
