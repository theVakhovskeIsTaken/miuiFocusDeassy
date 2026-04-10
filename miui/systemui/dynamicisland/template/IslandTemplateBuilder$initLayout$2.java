/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.content.Context
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.widget.FrameLayout
 *  f1.E
 */
package miui.systemui.dynamicisland.template;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import f1.E;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.template.IslandTemplateBuilder;

@f(c="miui.systemui.dynamicisland.template.IslandTemplateBuilder$initLayout$2", f="IslandTemplateBuilder.kt", l={}, m="invokeSuspend")
public static final class IslandTemplateBuilder.initLayout.2
extends l
implements o {
    int label;
    final IslandTemplateBuilder this$0;

    public IslandTemplateBuilder.initLayout.2(IslandTemplateBuilder islandTemplateBuilder, d d2) {
        this.this$0 = islandTemplateBuilder;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label == 0) {
            k.b((Object)object);
            IslandTemplateBuilder islandTemplateBuilder = this.this$0;
            if (islandTemplateBuilder.bigIsland) {
                if (this.this$0.isFakeView) {
                    object = DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce(this.this$0.data) ? LayoutInflater.from((Context)this.this$0.getContext()).inflate(R.layout.fake_dynamic_big_island_template_pad, this.this$0.root, false) : LayoutInflater.from((Context)this.this$0.getContext()).inflate(R.layout.fake_dynamic_big_island_template, this.this$0.root, false);
                    object.setLayoutDirection(this.this$0.getContext().getResources().getConfiguration().getLayoutDirection());
                } else {
                    if (DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce(this.this$0.data)) {
                        Log.d((String)"IslandTemplateBuilder", (String)"bigIslandView:isPad 1/2");
                        object = LayoutInflater.from((Context)this.this$0.getContext()).inflate(R.layout.dynamic_big_island_template_standard_pad, this.this$0.root, false);
                    } else {
                        Log.d((String)"IslandTemplateBuilder", (String)"bigIslandView:isPhone or isPad 0");
                        object = LayoutInflater.from((Context)this.this$0.getContext()).inflate(R.layout.dynamic_big_island_template_standard, this.this$0.root, false);
                    }
                    object.setLayoutDirection(this.this$0.getContext().getResources().getConfiguration().getLayoutDirection());
                }
            } else if (this.this$0.isFakeView) {
                object = LayoutInflater.from((Context)this.this$0.getContext()).inflate(R.layout.fake_dynamic_small_island_template, this.this$0.root, false);
                object.setLayoutDirection(this.this$0.getContext().getResources().getConfiguration().getLayoutDirection());
            } else {
                object = LayoutInflater.from((Context)this.this$0.getContext()).inflate(R.layout.dynamic_small_island_template_standard, this.this$0.root, false);
                object.setLayoutDirection(this.this$0.getContext().getResources().getConfiguration().getLayoutDirection());
            }
            islandTemplateBuilder.islandLayout = (View)object;
            islandTemplateBuilder = this.this$0;
            boolean bl = islandTemplateBuilder.isFakeView;
            object = null;
            if (bl) {
                View view = this.this$0.islandLayout;
                if (view != null) {
                    object = (FrameLayout)view.findViewById(R.id.fake_area_cutout);
                }
            } else {
                View view = this.this$0.islandLayout;
                if (view != null) {
                    object = (FrameLayout)view.findViewById(R.id.area_cutout);
                }
            }
            islandTemplateBuilder.cutout = (FrameLayout)object;
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
