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
import miui.systemui.dynamicisland.template.IslandTemplateFactory;

@f(c="miui.systemui.dynamicisland.template.IslandTemplateFactory", f="IslandTemplateFactory.kt", l={222, 224, 236, 238}, m="createSmallIslandTemplateView")
public static final class IslandTemplateFactory.createSmallIslandTemplateView.1
extends M0.d {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    Object result;
    final IslandTemplateFactory this$0;

    public IslandTemplateFactory.createSmallIslandTemplateView.1(IslandTemplateFactory islandTemplateFactory, d d2) {
        this.this$0 = islandTemplateFactory;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createSmallIslandTemplateView(null, null, null, null, false, null, (d)this);
    }
}
