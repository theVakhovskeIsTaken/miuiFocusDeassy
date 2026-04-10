/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  U0.o
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.FrameLayout
 *  f1.E
 *  f1.f
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 *  miui.systemui.animation.FolmeKt
 *  miuix.animation.base.AnimConfig
 *  miuix.animation.controller.AnimState
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 *  miuix.animation.property.FloatProperty
 */
package miui.systemui.dynamicisland;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import f1.E;
import f1.f;
import java.util.Collection;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.DynamicIslandBackgroundViewController;
import miui.systemui.dynamicisland.R;
import miuix.animation.base.AnimConfig;
import miuix.animation.controller.AnimState;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;
import miuix.animation.property.FloatProperty;

@SuppressLint(value={"UseCompatLoadingForDrawables"})
public final class DynamicIslandBackgroundView
extends FrameLayout {
    private static final ALPHA.1 ALPHA;
    public static final Companion Companion;
    public static final float MINI_VISIBLE_CHANGE = 0.1f;
    private int actualHeight;
    private int actualLeft;
    private int actualTop;
    private int actualWidth;
    private float backgroundAlpha;
    private DynamicIslandBackgroundViewController controller;
    private Drawable drawable;
    private int stokeWidth;

    static {
        Companion = new Object(null){
            {
                this();
            }
        };
        ALPHA = new FloatProperty<DynamicIslandBackgroundView>(){

            public float getValue(DynamicIslandBackgroundView dynamicIslandBackgroundView) {
                o.g((Object)((Object)dynamicIslandBackgroundView), (String)"view");
                return DynamicIslandBackgroundView.access$getBackgroundAlpha$p(dynamicIslandBackgroundView);
            }

            public void setValue(DynamicIslandBackgroundView dynamicIslandBackgroundView, float f2) {
                o.g((Object)((Object)dynamicIslandBackgroundView), (String)"view");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandBackgroundView.access$setBackgroundAlpha$p(dynamicIslandBackgroundView, f2);
            }
        };
    }

    public DynamicIslandBackgroundView(Context context, AttributeSet attributeSet) {
        o.g((Object)context, (String)"context");
        super(context, attributeSet);
        this.stokeWidth = this.getResources().getDimensionPixelSize(R.dimen.island_stroke);
    }

    public /* synthetic */ DynamicIslandBackgroundView(Context context, AttributeSet attributeSet, int n, h h2) {
        if ((n & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet);
    }

    public static final /* synthetic */ float access$getBackgroundAlpha$p(DynamicIslandBackgroundView dynamicIslandBackgroundView) {
        return dynamicIslandBackgroundView.backgroundAlpha;
    }

    public static final /* synthetic */ void access$scheduleUpdate(DynamicIslandBackgroundView dynamicIslandBackgroundView) {
        dynamicIslandBackgroundView.scheduleUpdate();
    }

    public static final /* synthetic */ void access$setBackgroundAlpha$p(DynamicIslandBackgroundView dynamicIslandBackgroundView, float f) {
        dynamicIslandBackgroundView.backgroundAlpha = f;
    }

    private final void scheduleUpdate() {
        Drawable drawable = this.drawable;
        if (drawable != null) {
            drawable.setAlpha((int)((float)255 * this.backgroundAlpha));
        }
        this.invalidate();
    }

    public final void alphaAnimation(float f) {
        FolmeKt.getFolme((View)this).to((Object)new AnimState().add((FloatProperty)ALPHA, f, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this){
            final DynamicIslandBackgroundView this$0;
            {
                this.this$0 = dynamicIslandBackgroundView;
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                DynamicIslandBackgroundView.access$scheduleUpdate(this.this$0);
            }
        }})});
    }

    public final int getActualHeight() {
        return this.actualHeight;
    }

    public final int getActualLeft() {
        return this.actualLeft;
    }

    public final int getActualTop() {
        return this.actualTop;
    }

    public final int getActualWidth() {
        return this.actualWidth;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public final int getStokeWidth() {
        return this.stokeWidth;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void onDraw(Canvas canvas) {
        Drawable drawable;
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.save();
        }
        if ((drawable = this.drawable) != null) {
            int n = this.actualTop;
            int n2 = this.stokeWidth;
            int n3 = this.actualHeight;
            int n4 = this.actualLeft;
            int n5 = this.actualWidth;
            if (drawable != null) {
                drawable.setBounds(n4 - n2, n - n2, n5 + n2, n3 + n2);
            }
            if ((drawable = this.drawable) != null) {
                o.d((Object)canvas);
                drawable.draw(canvas);
            }
        }
        if (canvas != null) {
            canvas.restore();
        }
    }

    public final void setActualHeight(int n) {
        this.actualHeight = n;
    }

    public final void setActualLeft(int n) {
        this.actualLeft = n;
    }

    public final void setActualTop(int n) {
        this.actualTop = n;
    }

    public final void setActualWidth(int n) {
        this.actualWidth = n;
    }

    public final void setController(DynamicIslandBackgroundViewController dynamicIslandBackgroundViewController) {
        o.g((Object)dynamicIslandBackgroundViewController, (String)"controller");
        this.controller = dynamicIslandBackgroundViewController;
        f.b((E)dynamicIslandBackgroundViewController.getScope(), null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandBackgroundView this$0;
            {
                this.this$0 = dynamicIslandBackgroundView;
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
                    FolmeKt.cleanFolmeWhenDetached((View)this.this$0);
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public final void setStokeWidth(int n) {
        this.stokeWidth = n;
    }

    public void setVisibility(int n) {
        this.setTransitionAlpha(1.0f);
        super.setVisibility(n);
    }

    public final void superSetVisibility(int n) {
        super.setVisibility(n);
    }
}
