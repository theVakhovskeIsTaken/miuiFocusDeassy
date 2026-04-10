/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  com.mi.widget.core.Origin
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.ShaderUtil
 */
package miui.systemui.dynamicisland.module;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.mi.widget.core.Origin;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicFeatureConfig;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.model.PicInfo;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;
import miui.systemui.util.ShaderUtil;

public static final class IslandIconViewHolder$showShaderIcon$.inlined.doOnPreDraw.1
implements Runnable {
    final ViewGroup $parent$inlined;
    final View $this_doOnPreDraw;
    final IslandIconViewHolder this$0;

    public IslandIconViewHolder$showShaderIcon$.inlined.doOnPreDraw.1(View view, IslandIconViewHolder islandIconViewHolder, ViewGroup viewGroup) {
        this.$this_doOnPreDraw = view;
        this.this$0 = islandIconViewHolder;
        this.$parent$inlined = viewGroup;
    }

    @Override
    public final void run() {
        Object object;
        if (DynamicFeatureConfig.INSTANCE.getFEATURE_DYNAMIC_ISLAND_SHADER() && (object = this.this$0.getPicInfo()) != null && (object = ((PicInfo)object).getEffectSrc()) != null && (IslandIconViewHolder.access$getShader$p(this.this$0) == null || IslandIconViewHolder.access$getCurrentShaderEffectSrc$p(this.this$0) == null || !o.c((Object)object, (Object)IslandIconViewHolder.access$getCurrentShaderEffectSrc$p(this.this$0)))) {
            IslandIconViewHolder.access$setCurrentShaderEffectSrc$p(this.this$0, (String)object);
            boolean bl = o.c((Object)object, (Object)"call");
            float f = 0.0f;
            float f2 = 0.0f;
            if (bl) {
                IslandIconViewHolder islandIconViewHolder = this.this$0;
                ShaderUtil shaderUtil = ShaderUtil.INSTANCE;
                ViewGroup viewGroup = this.$parent$inlined;
                ImageView imageView = IslandIconViewHolder.access$getIcon$p(islandIconViewHolder);
                float f3 = f2;
                if (imageView != null) {
                    imageView = imageView.getDrawable();
                    f3 = f2;
                    if (imageView != null) {
                        imageView = imageView.getBounds();
                        f3 = f2;
                        if (imageView != null) {
                            f3 = imageView.width();
                        }
                    }
                }
                IslandIconViewHolder.access$setShader$p(islandIconViewHolder, shaderUtil.setShader((String)object, (View)viewGroup, f3, this.this$0.getContext().getResources().getDimension(R.dimen.island_area_padding), Origin.START, false));
                object = IslandIconViewHolder.access$getShader$p(this.this$0);
                if (object != null) {
                    object.start();
                }
            } else {
                IslandIconViewHolder islandIconViewHolder = this.this$0;
                ShaderUtil shaderUtil = ShaderUtil.INSTANCE;
                ViewGroup viewGroup = this.$parent$inlined;
                ImageView imageView = IslandIconViewHolder.access$getIcon$p(islandIconViewHolder);
                float f4 = f;
                if (imageView != null) {
                    imageView = imageView.getDrawable();
                    f4 = f;
                    if (imageView != null) {
                        imageView = imageView.getBounds();
                        f4 = f;
                        if (imageView != null) {
                            f4 = imageView.width();
                        }
                    }
                }
                IslandIconViewHolder.access$setShader$p(islandIconViewHolder, ShaderUtil.setShader$default((ShaderUtil)shaderUtil, (String)object, (View)viewGroup, (float)f4, (float)this.this$0.getContext().getResources().getDimension(R.dimen.island_area_padding), (Origin)Origin.END, (boolean)false, (int)32, null));
                object = IslandIconViewHolder.access$getShader$p(this.this$0);
                if (object != null) {
                    object.start();
                }
            }
        }
    }
}
