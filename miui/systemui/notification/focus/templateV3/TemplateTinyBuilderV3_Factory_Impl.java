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
import miui.systemui.notification.focus.templateV3.TemplateTinyBuilderV3;
import miui.systemui.notification.focus.templateV3.TemplateTinyBuilderV3_Factory;

public final class TemplateTinyBuilderV3_Factory_Impl
implements TemplateTinyBuilderV3.Factory {
    private final TemplateTinyBuilderV3_Factory delegateFactory;

    public TemplateTinyBuilderV3_Factory_Impl(TemplateTinyBuilderV3_Factory templateTinyBuilderV3_Factory) {
        this.delegateFactory = templateTinyBuilderV3_Factory;
    }

    public static a create(TemplateTinyBuilderV3_Factory templateTinyBuilderV3_Factory) {
        return f.a((Object)new TemplateTinyBuilderV3_Factory_Impl(templateTinyBuilderV3_Factory));
    }

    @Override
    public TemplateTinyBuilderV3 create(boolean bl) {
        return this.delegateFactory.get(bl);
    }
}
