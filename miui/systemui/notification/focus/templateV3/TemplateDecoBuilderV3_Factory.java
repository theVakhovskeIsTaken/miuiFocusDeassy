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
import miui.systemui.notification.focus.templateV3.TemplateDecoBuilderV3;

public final class TemplateDecoBuilderV3_Factory {
    private final a contextProvider;
    private final a moduleViewHolderAdapterProvider;

    public TemplateDecoBuilderV3_Factory(a a2, a a3) {
        this.contextProvider = a2;
        this.moduleViewHolderAdapterProvider = a3;
    }

    public static TemplateDecoBuilderV3_Factory create(a a2, a a3) {
        return new TemplateDecoBuilderV3_Factory(a2, a3);
    }

    public static TemplateDecoBuilderV3 newInstance(Context context, Template template, boolean bl, a a2) {
        return new TemplateDecoBuilderV3(context, template, bl, a2);
    }

    public TemplateDecoBuilderV3 get(Template template, boolean bl) {
        return TemplateDecoBuilderV3_Factory.newInstance((Context)this.contextProvider.get(), template, bl, this.moduleViewHolderAdapterProvider);
    }
}
