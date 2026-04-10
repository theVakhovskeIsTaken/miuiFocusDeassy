/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  f1.E
 *  miui.systemui.ui.data.repository.ConfigurationRepository
 */
package miui.systemui.dynamicisland.data.repository;

import E0.e;
import F0.a;
import android.content.Context;
import f1.E;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository;
import miui.systemui.ui.data.repository.ConfigurationRepository;

public final class DynamicIslandSizeRepository_Factory
implements e {
    private final a configRepositoryProvider;
    private final a contextProvider;
    private final a scopeProvider;

    public DynamicIslandSizeRepository_Factory(a a2, a a3, a a4) {
        this.scopeProvider = a2;
        this.contextProvider = a3;
        this.configRepositoryProvider = a4;
    }

    public static DynamicIslandSizeRepository_Factory create(a a2, a a3, a a4) {
        return new DynamicIslandSizeRepository_Factory(a2, a3, a4);
    }

    public static DynamicIslandSizeRepository newInstance(E e2, Context context, ConfigurationRepository configurationRepository) {
        return new DynamicIslandSizeRepository(e2, context, configurationRepository);
    }

    public DynamicIslandSizeRepository get() {
        return DynamicIslandSizeRepository_Factory.newInstance((E)this.scopeProvider.get(), (Context)this.contextProvider.get(), (ConfigurationRepository)this.configRepositoryProvider.get());
    }
}
