/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  E0.d
 *  E0.e
 *  F0.a
 */
package miui.systemui.dynamicisland.window;

import D0.a;
import E0.d;
import E0.e;
import miui.systemui.dynamicisland.dagger.DynamicIslandViewComponent;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewCreator;

public final class DynamicIslandWindowViewCreator_Factory
implements e {
    private final F0.a contextProvider;
    private final F0.a viewComponentFactoryProvider;

    public DynamicIslandWindowViewCreator_Factory(F0.a a2, F0.a a3) {
        this.contextProvider = a2;
        this.viewComponentFactoryProvider = a3;
    }

    public static DynamicIslandWindowViewCreator_Factory create(F0.a a2, F0.a a3) {
        return new DynamicIslandWindowViewCreator_Factory(a2, a3);
    }

    public static DynamicIslandWindowViewCreator newInstance(a a2, DynamicIslandViewComponent.Factory factory) {
        return new DynamicIslandWindowViewCreator(a2, factory);
    }

    public DynamicIslandWindowViewCreator get() {
        return DynamicIslandWindowViewCreator_Factory.newInstance(d.a((F0.a)this.contextProvider), (DynamicIslandViewComponent.Factory)this.viewComponentFactoryProvider.get());
    }
}
