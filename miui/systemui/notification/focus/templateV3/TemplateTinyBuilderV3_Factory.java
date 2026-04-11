/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  F0.a
 *  android.content.Context
 */
package miui.systemui.notification.focus.templateV3;

import F0.a;
import android.content.Context;
import miui.systemui.notification.focus.templateV3.TemplateTinyBuilderV3;

public final class TemplateTinyBuilderV3_Factory {
    private final a contextProvider;
    private final a moduleViewHolderAdapterProvider;

    public TemplateTinyBuilderV3_Factory(a a2, a a3) {
        this.contextProvider = a2;
        this.moduleViewHolderAdapterProvider = a3;
    }

    public static TemplateTinyBuilderV3_Factory create(a a2, a a3) {
        return new TemplateTinyBuilderV3_Factory(a2, a3);
    }

    public static TemplateTinyBuilderV3 newInstance(Context context, boolean bl, a a2) {
        return new TemplateTinyBuilderV3(context, bl, a2);
    }

    public TemplateTinyBuilderV3 get(boolean bl) {
        return TemplateTinyBuilderV3_Factory.newInstance((Context)this.contextProvider.get(), bl, this.moduleViewHolderAdapterProvider);
    }
}
