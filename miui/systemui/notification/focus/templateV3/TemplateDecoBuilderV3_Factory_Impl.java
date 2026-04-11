/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.f
 *  F0.a
 */
package miui.systemui.notification.focus.templateV3;

import E0.f;
import F0.a;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.templateV3.TemplateDecoBuilderV3;
import miui.systemui.notification.focus.templateV3.TemplateDecoBuilderV3_Factory;

public final class TemplateDecoBuilderV3_Factory_Impl
implements TemplateDecoBuilderV3.Factory {
    private final TemplateDecoBuilderV3_Factory delegateFactory;

    public TemplateDecoBuilderV3_Factory_Impl(TemplateDecoBuilderV3_Factory templateDecoBuilderV3_Factory) {
        this.delegateFactory = templateDecoBuilderV3_Factory;
    }

    public static a create(TemplateDecoBuilderV3_Factory templateDecoBuilderV3_Factory) {
        return f.a((Object)new TemplateDecoBuilderV3_Factory_Impl(templateDecoBuilderV3_Factory));
    }

    @Override
    public TemplateDecoBuilderV3 create(Template template, boolean bl) {
        return this.delegateFactory.get(template, bl);
    }
}
