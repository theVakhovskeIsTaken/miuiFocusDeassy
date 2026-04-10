/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  f1.E
 */
package miui.systemui.dynamicisland.data.repository;

import E0.e;
import F0.a;
import f1.E;
import miui.systemui.dynamicisland.data.repository.DynamicIslandExternalStateRepository;

public final class DynamicIslandExternalStateRepository_Factory
implements e {
    private final a scopeProvider;

    public DynamicIslandExternalStateRepository_Factory(a a2) {
        this.scopeProvider = a2;
    }

    public static DynamicIslandExternalStateRepository_Factory create(a a2) {
        return new DynamicIslandExternalStateRepository_Factory(a2);
    }

    public static DynamicIslandExternalStateRepository newInstance(E e2) {
        return new DynamicIslandExternalStateRepository(e2);
    }

    public DynamicIslandExternalStateRepository get() {
        return DynamicIslandExternalStateRepository_Factory.newInstance((E)this.scopeProvider.get());
    }
}
