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
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  f1.E
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.template;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import f1.E;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.module.IslandModuleViewHolderAdapter;
import miui.systemui.dynamicisland.template.IslandTemplateBuilder;

@f(c="miui.systemui.dynamicisland.template.IslandTemplateBuilder$addIslandModuleView$2", f="IslandTemplateBuilder.kt", l={144}, m="invokeSuspend")
public static final class IslandTemplateBuilder.addIslandModuleView.2
extends l
implements U0.o {
    final DynamicIslandData $data;
    final String $moduleType;
    final IslandTemplate $template;
    final FrameLayout $view;
    int label;
    final IslandTemplateBuilder this$0;

    public IslandTemplateBuilder.addIslandModuleView.2(IslandTemplateBuilder islandTemplateBuilder, IslandTemplate islandTemplate, String string, FrameLayout frameLayout, DynamicIslandData dynamicIslandData, d d2) {
        this.this$0 = islandTemplateBuilder;
        this.$template = islandTemplate;
        this.$moduleType = string;
        this.$view = frameLayout;
        this.$data = dynamicIslandData;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Object invokeSuspend(Object object) {
        Object object2 = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            k.b((Object)object);
        } else {
            Object object3;
            k.b((Object)object);
            IslandModuleViewHolderAdapter islandModuleViewHolderAdapter = this.this$0.islandAdapter;
            object = this.$template;
            String string = this.$moduleType;
            FrameLayout frameLayout = this.$view;
            o.e((Object)frameLayout, (String)"null cannot be cast to non-null type android.view.ViewGroup");
            U0.o o2 = this.this$0.emitEvent;
            DynamicIslandData dynamicIslandData = this.$data;
            this.label = 1;
            object = object3 = islandModuleViewHolderAdapter.createModuleViewHolder((IslandTemplate)object, string, (ViewGroup)frameLayout, o2, dynamicIslandData, (d)this);
            if (object3 == object2) {
                return object2;
            }
        }
        View view = (View)object;
        if (view == null) {
            return this.this$0;
        }
        object = this.$view;
        if (object == null) {
            object = null;
        }
        if (object != null) {
            object.addView(view);
        }
        this.this$0.islandAdapter.initView(this.$moduleType);
        this.this$0.islandAdapter.bindData(this.$moduleType, this.$data);
        return this.this$0;
    }
}
