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

@f(c="miui.systemui.dynamicisland.template.IslandTemplateFactory", f="IslandTemplateFactory.kt", l={150, 154, 155, 178, 190, 191}, m="createBigIslandTemplateView")
public static final class IslandTemplateFactory.createBigIslandTemplateView.1
extends M0.d {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    Object result;
    final IslandTemplateFactory this$0;

    public IslandTemplateFactory.createBigIslandTemplateView.1(IslandTemplateFactory islandTemplateFactory, d d2) {
        this.this$0 = islandTemplateFactory;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createBigIslandTemplateView(null, null, null, null, false, null, (d)this);
    }
}
