/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 */
package miui.systemui.notification.focus.moduleV3;

import E0.e;
import F0.a;
import android.content.Context;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolderAdapter;

public final class ModuleViewHolderAdapter_Factory
implements e {
    private final a contextProvider;
    private final a sysuiContextProvider;

    public ModuleViewHolderAdapter_Factory(a a2, a a3) {
        this.contextProvider = a2;
        this.sysuiContextProvider = a3;
    }

    public static ModuleViewHolderAdapter_Factory create(a a2, a a3) {
        return new ModuleViewHolderAdapter_Factory(a2, a3);
    }

    public static ModuleViewHolderAdapter newInstance(Context context, Context context2) {
        return new ModuleViewHolderAdapter(context, context2);
    }

    public ModuleViewHolderAdapter get() {
        return ModuleViewHolderAdapter_Factory.newInstance((Context)this.contextProvider.get(), (Context)this.sysuiContextProvider.get());
    }
}
