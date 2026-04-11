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
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.templateV3.TemplateDecoLandBuilderV3;

public final class TemplateDecoLandBuilderV3_Factory {
    private final a contextProvider;
    private final a moduleViewHolderAdapterProvider;

    public TemplateDecoLandBuilderV3_Factory(a a2, a a3) {
        this.contextProvider = a2;
        this.moduleViewHolderAdapterProvider = a3;
    }

    public static TemplateDecoLandBuilderV3_Factory create(a a2, a a3) {
        return new TemplateDecoLandBuilderV3_Factory(a2, a3);
    }

    public static TemplateDecoLandBuilderV3 newInstance(Context context, Template template, boolean bl, a a2) {
        return new TemplateDecoLandBuilderV3(context, template, bl, a2);
    }

    public TemplateDecoLandBuilderV3 get(Template template, boolean bl) {
        return TemplateDecoLandBuilderV3_Factory.newInstance((Context)this.contextProvider.get(), template, bl, this.moduleViewHolderAdapterProvider);
    }
}
