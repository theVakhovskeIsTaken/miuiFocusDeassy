/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  K0.d
 *  M0.d
 *  M0.f
 */
package miui.systemui.dynamicisland.template;

import K0.d;
import M0.f;
import miui.systemui.dynamicisland.template.IslandTemplateBuilder;

@f(c="miui.systemui.dynamicisland.template.IslandTemplateBuilder", f="IslandTemplateBuilder.kt", l={58}, m="initLayout")
public static final class IslandTemplateBuilder.initLayout.1
extends M0.d {
    Object L$0;
    int label;
    Object result;
    final IslandTemplateBuilder this$0;

    public IslandTemplateBuilder.initLayout.1(IslandTemplateBuilder islandTemplateBuilder, d d2) {
        this.this$0 = islandTemplateBuilder;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initLayout((d)this);
    }
}
