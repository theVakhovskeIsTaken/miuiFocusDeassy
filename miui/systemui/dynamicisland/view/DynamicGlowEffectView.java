/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SizeF
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  com.mi.widget.view.LightBgView
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SizeF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.mi.widget.view.LightBgView;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.view.a;

public abstract class DynamicGlowEffectView
extends FrameLayout {
    private static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String LOG_TAG = "DynamicGlowEffectView";
    private boolean adaptiveGlowViewSize;
    private float alphaOfGlowEffect;
    private boolean enabledGlowEffect;
    private final LightBgView mContainer;
    private ViewGroup mGlowEffectBottomContainer;
    private View mGlowEffectBottomView;
    private ViewGroup mGlowEffectUpperContainer;
    private View mGlowEffectUpperView;
    private float zOrderOfGlowEffect;

    public DynamicGlowEffectView(Context context) {
        o.g((Object)context, (String)"context");
        this(context, null, 2, null);
    }

    public DynamicGlowEffectView(Context context, AttributeSet attributeSet) {
        o.g((Object)context, (String)"context");
        super(context, attributeSet);
        this.adaptiveGlowViewSize = true;
        context = new LightBgView(context, null, 0, 0, null, 30, null);
        context.setAutoApertureSize(false);
        context.setSizeOfGlowArea(context.getResources().getDimension(R.dimen.island_glow_effect_area_size));
        this.addView((View)context);
        context.addOnLayoutChangeListener((View.OnLayoutChangeListener)new a(this));
        this.mContainer = context;
        this.alphaOfGlowEffect = 1.0f;
    }

    public /* synthetic */ DynamicGlowEffectView(Context context, AttributeSet attributeSet, int n, h h2) {
        if ((n & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet);
    }

    public static /* synthetic */ void a(DynamicGlowEffectView dynamicGlowEffectView, View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        DynamicGlowEffectView.mContainer$lambda$3$lambda$2(dynamicGlowEffectView, view, n, n2, n3, n4, n5, n6, n7, n8);
    }

    private static final void mContainer$lambda$3$lambda$2(DynamicGlowEffectView object, View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        o.g((Object)object, (String)"this$0");
        boolean bl = ((DynamicGlowEffectView)((Object)object)).adaptiveGlowViewSize;
        if (!bl) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Ignore update glow effect view size du to adaptiveGlowViewSize=");
            ((StringBuilder)object).append(bl);
            Log.i((String)LOG_TAG, (String)((StringBuilder)object).toString());
            return;
        }
        View view2 = ((DynamicGlowEffectView)((Object)object)).mGlowEffectUpperView;
        if (view2 != null) {
            view = view2.getLayoutParams();
            if (view != null) {
                view.width = n3 - n;
                view.height = n4 - n2;
                view2.setLayoutParams((ViewGroup.LayoutParams)view);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
        if ((view = ((DynamicGlowEffectView)((Object)object)).mGlowEffectUpperView) != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((int)(n3 - n), (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)(n4 - n2), (int)0x40000000));
        }
        if ((view = ((DynamicGlowEffectView)((Object)object)).mGlowEffectBottomView) != null) {
            object = view.getLayoutParams();
            if (object != null) {
                ((ViewGroup.LayoutParams)object).width = n3 - n;
                ((ViewGroup.LayoutParams)object).height = n4 - n2;
                view.setLayoutParams((ViewGroup.LayoutParams)object);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
    }

    public static /* synthetic */ void stopGlowEffect$miui_dynamicisland_release$default(DynamicGlowEffectView dynamicGlowEffectView, boolean bl, int n, Object object) {
        if (object == null) {
            if ((n & 1) != 0) {
                bl = false;
            }
            dynamicGlowEffectView.stopGlowEffect$miui_dynamicisland_release(bl);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopGlowEffect");
    }

    public final boolean getAdaptiveGlowViewSize() {
        return this.adaptiveGlowViewSize;
    }

    public final float getAlphaOfGlowEffect$miui_dynamicisland_release() {
        return this.alphaOfGlowEffect;
    }

    public final LightBgView getMContainer() {
        return this.mContainer;
    }

    public final ViewGroup getMGlowEffectBottomContainer() {
        return this.mGlowEffectBottomContainer;
    }

    public final View getMGlowEffectBottomView() {
        return this.mGlowEffectBottomView;
    }

    public final ViewGroup getMGlowEffectUpperContainer() {
        return this.mGlowEffectUpperContainer;
    }

    public final View getMGlowEffectUpperView() {
        return this.mGlowEffectUpperView;
    }

    public final float getZOrderOfGlowEffect$miui_dynamicisland_release() {
        return this.zOrderOfGlowEffect;
    }

    public final void initGlowEffect$miui_dynamicisland_release(ViewGroup viewGroup, ViewGroup viewGroup2) {
        o.g((Object)viewGroup, (String)"topContainer");
        o.g((Object)viewGroup2, (String)"bottomContainer");
        View view = new View(this.getContext());
        view.setBackgroundColor(0);
        viewGroup.addView(view);
        this.mGlowEffectUpperView = view;
        view = new View(this.getContext());
        view.setBackgroundColor(0);
        viewGroup2.addView(view);
        this.mGlowEffectBottomView = view;
        this.mGlowEffectBottomContainer = viewGroup2;
        this.mGlowEffectUpperContainer = viewGroup;
        this.mContainer.setEffectView(this.mGlowEffectUpperView, view);
    }

    public void onDetachedFromWindow() {
        Object object;
        super.onDetachedFromWindow();
        View view = this.mGlowEffectUpperView;
        if (view != null) {
            object = view.getParent();
            object = object instanceof ViewGroup ? (ViewGroup)object : null;
            if (object != null) {
                object.removeView(view);
            }
            this.mGlowEffectUpperView = null;
        }
        if ((view = this.mGlowEffectBottomView) != null) {
            object = view.getParent();
            object = object instanceof ViewGroup ? (ViewGroup)object : null;
            if (object != null) {
                object.removeView(view);
            }
            this.mGlowEffectBottomView = null;
        }
    }

    public final void setAdaptiveGlowViewSize(boolean bl) {
        this.adaptiveGlowViewSize = bl;
    }

    public final void setAlphaOfGlowEffect$miui_dynamicisland_release(float f) {
        this.alphaOfGlowEffect = f;
        View view = this.mGlowEffectUpperView;
        if (view != null) {
            view.setAlpha(f);
        }
        view = this.mGlowEffectBottomView;
        if (view != null) {
            view.setAlpha(f);
        }
    }

    public final void setGlowEffectPosition(float f, float f2, float f3, float f4, float f5) {
        this.mContainer.setSizeOfGlowRadius(f5);
        this.mContainer.setBottomApertureSize(new SizeF(f3 -= f, f4 -= f2));
        this.mContainer.setUpperApertureSize(new SizeF(f3, f4));
        View view = this.mGlowEffectUpperView;
        if (view != null) {
            view.setTranslationX(f3 / 2.0f + f - (float)view.getWidth() / 2.0f);
            view.setTranslationY(f4 / 2.0f + f2 - (float)view.getHeight() / 2.0f);
        }
        if ((view = this.mGlowEffectBottomView) != null) {
            view.setTranslationX(f + f3 / 2.0f - (float)view.getWidth() / 2.0f);
            view.setTranslationY(f2 + f4 / 2.0f - (float)view.getHeight() / 2.0f);
        }
    }

    public final void setMGlowEffectBottomContainer(ViewGroup viewGroup) {
        this.mGlowEffectBottomContainer = viewGroup;
    }

    public final void setMGlowEffectBottomView(View view) {
        this.mGlowEffectBottomView = view;
    }

    public final void setMGlowEffectUpperContainer(ViewGroup viewGroup) {
        this.mGlowEffectUpperContainer = viewGroup;
    }

    public final void setMGlowEffectUpperView(View view) {
        this.mGlowEffectUpperView = view;
    }

    public final void setZOrderOfGlowEffect$miui_dynamicisland_release(float f) {
        this.zOrderOfGlowEffect = f;
        Object object = this.mGlowEffectUpperView;
        ViewGroup viewGroup = null;
        if ((object = object != null ? object.getParent() : null) instanceof ViewGroup) {
            viewGroup = (ViewGroup)object;
        }
        if (viewGroup != null && viewGroup.getZ() < f) {
            object = new StringBuilder();
            ((StringBuilder)object).append("GlowEffectUpperView z-order must greater than or equal to ");
            ((StringBuilder)object).append(f);
            ((StringBuilder)object).append(", Adjust z-order to ");
            ((StringBuilder)object).append(f);
            Log.i((String)LOG_TAG, (String)((StringBuilder)object).toString());
            viewGroup.setZ(f);
        }
    }

    public final void startGlowEffect$miui_dynamicisland_release() {
        if (this.enabledGlowEffect) {
            return;
        }
        this.enabledGlowEffect = true;
        LightBgView.start$default((LightBgView)this.mContainer, (boolean)false, (int)1, null);
    }

    public final void stopGlowEffect$miui_dynamicisland_release(boolean bl) {
        if (!this.enabledGlowEffect) {
            return;
        }
        this.enabledGlowEffect = false;
        this.mContainer.stop(bl);
    }
}
