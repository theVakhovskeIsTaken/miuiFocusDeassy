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

@f(c="miui.systemui.dynamicisland.template.IslandTemplateFactory", f="IslandTemplateFactory.kt", l={344}, m="createBigIslandTemplate")
public static final class IslandTemplateFactory.createBigIslandTemplate.1
extends M0.d {
    int label;
    Object result;
    final IslandTemplateFactory this$0;

    public IslandTemplateFactory.createBigIslandTemplate.1(IslandTemplateFactory islandTemplateFactory, d d2) {
        this.this$0 = islandTemplateFactory;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createBigIslandTemplate(null, null, null, null, false, null, (d)this);
    }
}
