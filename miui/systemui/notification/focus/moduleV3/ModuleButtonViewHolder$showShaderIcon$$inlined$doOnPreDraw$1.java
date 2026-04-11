/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  com.android.systemui.miui.notification.R$dimen
 *  com.mi.widget.core.Origin
 *  com.mi.widget.shader.CallingShader
 *  miui.systemui.dynamicisland.DynamicFeatureConfig
 *  miui.systemui.util.ShaderUtil
 */
package miui.systemui.notification.focus.moduleV3;

import android.view.View;
import android.view.ViewGroup;
import com.android.systemui.miui.notification.R;
import com.mi.widget.core.Origin;
import com.mi.widget.shader.CallingShader;
import miui.systemui.dynamicisland.DynamicFeatureConfig;
import miui.systemui.notification.focus.moduleV3.ModuleButtonViewHolder;
import miui.systemui.util.ShaderUtil;

public static final class ModuleButtonViewHolder$showShaderIcon$.inlined.doOnPreDraw.1
implements Runnable {
    final ViewGroup $parent$inlined;
    final View $this_doOnPreDraw;
    final View $view$inlined;
    final ModuleButtonViewHolder this$0;

    public ModuleButtonViewHolder$showShaderIcon$.inlined.doOnPreDraw.1(View view, ModuleButtonViewHolder moduleButtonViewHolder, ViewGroup viewGroup, View view2) {
        this.$this_doOnPreDraw = view;
        this.this$0 = moduleButtonViewHolder;
        this.$parent$inlined = viewGroup;
        this.$view$inlined = view2;
    }

    @Override
    public final void run() {
        if (DynamicFeatureConfig.INSTANCE.getFEATURE_DYNAMIC_ISLAND_SHADER()) {
            ModuleButtonViewHolder.access$setShader$p(this.this$0, ShaderUtil.setShader$default((ShaderUtil)ShaderUtil.INSTANCE, (String)"call", (View)this.$parent$inlined, (float)this.$view$inlined.getWidth(), (float)this.this$0.getCtx().getResources().getDimension(R.dimen.focus_notify_template_margin), (Origin)Origin.END, (boolean)false, (int)32, null));
            CallingShader callingShader = ModuleButtonViewHolder.access$getShader$p(this.this$0);
            if (callingShader != null) {
                callingShader.start();
            }
        }
    }
}
