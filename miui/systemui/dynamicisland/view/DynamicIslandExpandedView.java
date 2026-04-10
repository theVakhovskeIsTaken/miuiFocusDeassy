/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.AttachedSurfaceControl
 *  android.view.View
 *  android.view.ViewGroup
 *  android.window.SurfaceSyncGroup
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandGlowEffectLayer
 *  com.mi.widget.core.Origin
 *  com.mi.widget.shader.CallingShader
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.ShaderUtil
 */
package miui.systemui.dynamicisland.view;

import G0.s;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AttachedSurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.window.SurfaceSyncGroup;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandGlowEffectLayer;
import com.mi.widget.core.Origin;
import com.mi.widget.shader.CallingShader;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.view.DynamicGlowEffectView;
import miui.systemui.dynamicisland.view.b;
import miui.systemui.util.ShaderUtil;

public final class DynamicIslandExpandedView
extends DynamicGlowEffectView {
    private static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String LOG_TAG = "DynamicIslandExpandedView";
    private AttachedSurfaceControl glowEffectLayerSurfaceSyncer;
    private boolean mAttachInterruptedAnim;
    private View mContentView;
    private DynamicIslandGlowEffectLayer mGlowEffectLayer;
    private boolean mStartCallShaderInVisible;

    public DynamicIslandExpandedView(Context context) {
        o.g((Object)context, (String)"context");
        this(context, null, 2, null);
    }

    public DynamicIslandExpandedView(Context context, AttributeSet attributeSet) {
        o.g((Object)context, (String)"context");
        super(context, attributeSet);
    }

    public /* synthetic */ DynamicIslandExpandedView(Context context, AttributeSet attributeSet, int n, h h2) {
        if ((n & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet);
    }

    public static /* synthetic */ void b(DynamicIslandExpandedView dynamicIslandExpandedView, String string) {
        DynamicIslandExpandedView.detachFromInterruptedAnimWithSync$lambda$2(dynamicIslandExpandedView, string);
    }

    private final void detachFromInterruptedAnim(String string) {
        if (!this.mAttachInterruptedAnim) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("detachFromInterruptedAnim: Not attach to any interrupted anim, packageName=");
            stringBuilder.append(string);
            Log.w((String)LOG_TAG, (String)stringBuilder.toString());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("detachFromInterruptedAnim: Detach from interrupted anim packageName=");
        stringBuilder.append(string);
        Log.i((String)LOG_TAG, (String)stringBuilder.toString());
        this.mAttachInterruptedAnim = false;
        string = this.getMGlowEffectBottomView();
        stringBuilder = null;
        string = string != null ? string.getParent() : null;
        string = string instanceof View ? (View)string : null;
        string = string != null ? string.getRootSurfaceControl() : null;
        this.glowEffectLayerSurfaceSyncer = string;
        string = this.getMGlowEffectBottomView();
        string = string != null ? string.getParent() : null;
        if (string instanceof ViewGroup) {
            stringBuilder = (ViewGroup)string;
        }
        if (stringBuilder != null) {
            stringBuilder.removeView(this.getMGlowEffectBottomView());
        }
        if ((string = this.getMGlowEffectBottomContainer()) != null) {
            string.addView(this.getMGlowEffectBottomView());
        }
        this.getMContainer().invalidate();
    }

    private static final void detachFromInterruptedAnimWithSync$lambda$2(DynamicIslandExpandedView dynamicIslandExpandedView, String string) {
        o.g((Object)((Object)dynamicIslandExpandedView), (String)"this$0");
        o.g((Object)string, (String)"$packageName");
        Object object = dynamicIslandExpandedView.getMGlowEffectUpperView();
        object = object != null ? object.getParent() : null;
        object = object instanceof ViewGroup ? (ViewGroup)object : null;
        if (object != null) {
            object.removeView(dynamicIslandExpandedView.getMGlowEffectUpperView());
        }
        if ((object = dynamicIslandExpandedView.getMGlowEffectUpperContainer()) != null) {
            object.addView(dynamicIslandExpandedView.getMGlowEffectUpperView());
        }
        dynamicIslandExpandedView.getMContainer().invalidate();
        DynamicIslandGlowEffectLayer dynamicIslandGlowEffectLayer = dynamicIslandExpandedView.mGlowEffectLayer;
        if (dynamicIslandGlowEffectLayer != null) {
            object = new SurfaceSyncGroup("GlowEffectSSG");
            object.add(dynamicIslandExpandedView.getRootSurfaceControl(), null);
            object.markSyncReady();
            dynamicIslandExpandedView = s.a;
            dynamicIslandGlowEffectLayer.hideGlowEffectLayer(string, (SurfaceSyncGroup)object);
        }
    }

    public final void attachGlowViewToInterruptedAnim$miui_dynamicisland_release(String string, DynamicIslandGlowEffectLayer object) {
        o.g((Object)string, (String)"packageName");
        o.g((Object)object, (String)"glowEffectSurfaceLayer");
        if (this.mAttachInterruptedAnim) {
            Log.w((String)LOG_TAG, (String)"attachGlowViewToInterruptedAnim: Already attach to interrupted anim");
            return;
        }
        if (this.getMGlowEffectBottomView() != null && this.getMGlowEffectUpperView() != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("attachGlowViewToInterruptedAnim: Attach to interrupted anim packageName=");
            stringBuilder.append(string);
            Log.i((String)LOG_TAG, (String)stringBuilder.toString());
            this.mAttachInterruptedAnim = true;
            stringBuilder = this.getMGlowEffectBottomContainer();
            if (stringBuilder != null) {
                stringBuilder.removeView(this.getMGlowEffectBottomView());
                stringBuilder = this.getMGlowEffectUpperContainer();
                if (stringBuilder != null) {
                    stringBuilder.removeView(this.getMGlowEffectUpperView());
                    this.mGlowEffectLayer = object;
                    View view = this.getMGlowEffectUpperView();
                    if (view != null) {
                        stringBuilder = this.getMGlowEffectBottomView();
                        if (stringBuilder != null) {
                            object.showGlowEffectLayer(string, view, (View)stringBuilder);
                            return;
                        }
                        throw new IllegalStateException("Required value was null.");
                    }
                    throw new IllegalStateException("Required value was null.");
                }
                throw new IllegalStateException("Required value was null.");
            }
            throw new IllegalStateException("Required value was null.");
        }
        string = this.getMGlowEffectUpperView();
        View view = this.getMGlowEffectBottomView();
        object = new StringBuilder();
        ((StringBuilder)object).append("attachGlowViewToInterruptedAnim: UpperGlowView=");
        ((StringBuilder)object).append((Object)string);
        ((StringBuilder)object).append(", BottomGlowView=");
        ((StringBuilder)object).append(view);
        Log.w((String)LOG_TAG, (String)((StringBuilder)object).toString());
    }

    public final void detachFromInterruptedAnimWithStopGlowEffect$miui_dynamicisland_release(String string) {
        o.g((Object)string, (String)"packageName");
        if (!this.mAttachInterruptedAnim) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("detachFromInterruptedAnimWithStopGlowEffect: Not attach to any interrupted anim, packageName=");
            stringBuilder.append(string);
            Log.w((String)LOG_TAG, (String)stringBuilder.toString());
            return;
        }
        this.detachFromInterruptedAnim(string);
        string = this.getMGlowEffectUpperView();
        ViewGroup viewGroup = null;
        string = string != null ? string.getParent() : null;
        if (string instanceof ViewGroup) {
            viewGroup = (ViewGroup)string;
        }
        if (viewGroup != null) {
            viewGroup.removeView(this.getMGlowEffectUpperView());
        }
        if ((string = this.getMGlowEffectUpperContainer()) != null) {
            string.addView(this.getMGlowEffectUpperView());
        }
        this.getMContainer().stop(true);
    }

    public final void detachFromInterruptedAnimWithSync$miui_dynamicisland_release(String string) {
        o.g((Object)string, (String)"packageName");
        if (!this.mAttachInterruptedAnim) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("detachFromInterruptedAnimWithSync: Not attach to any interrupted anim, packageName=");
            stringBuilder.append(string);
            Log.w((String)LOG_TAG, (String)stringBuilder.toString());
            return;
        }
        this.detachFromInterruptedAnim(string);
        this.postOnAnimation(new b(this, string));
    }

    public void onVisibilityChanged(View object, int n) {
        o.g((Object)object, (String)"changedView");
        super.onVisibilityChanged(object, n);
        object = this.mContentView;
        if (object == null) {
            return;
        }
        if (object != null) {
            if ((object = object.getTag(R.id.custom_view_shader)) instanceof CallingShader) {
                if (this.isShown()) {
                    if (this.mStartCallShaderInVisible) {
                        ((CallingShader)object).start();
                    }
                } else {
                    ((CallingShader)object).stop();
                }
                this.mStartCallShaderInVisible = false;
            }
            return;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final s removeContentView$miui_dynamicisland_release() {
        View view = this.mContentView;
        if (view != null) {
            this.getMContainer().removeView(view);
            view = s.a;
        } else {
            view = null;
        }
        return view;
    }

    public final void setContentView$miui_dynamicisland_release(View view) {
        this.mContentView = view;
        this.getMContainer().addView(view);
    }

    public final void startCallingEffectIfNeeded$miui_dynamicisland_release() {
        View view = this.mContentView;
        if (view == null) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        Object object = view.getTag(R.id.custom_view_shader_id);
        Object object2 = view.getTag(R.id.custom_view_shader_type);
        if (object instanceof Integer && object2 instanceof String) {
            Object object3 = this.mContentView;
            if (object3 != null) {
                View view2 = object3.findViewById(((Number)object).intValue());
                if (view2 == null) {
                    return;
                }
                object = new int[2];
                view.getLocationOnScreen((int[])object);
                object3 = new int[2];
                view2.getLocationOnScreen((int[])object3);
                ViewGroup viewGroup = (ViewGroup)view;
                int n = viewGroup.getWidth();
                int n2 = view2.getWidth();
                View view3 = object3[0];
                Object object4 = object[0];
                int n3 = R.id.custom_view_shader;
                object = view.getTag(n3);
                object3 = object;
                if (!(object instanceof CallingShader)) {
                    object3 = ShaderUtil.INSTANCE;
                    object = (String)object2;
                    object2 = viewGroup.getChildAt(0);
                    o.f((Object)object2, (String)"getChildAt(...)");
                    object3 = ShaderUtil.setShader$default((ShaderUtil)object3, (String)object, (View)object2, (float)view2.getWidth(), (float)(n - n2 - (view3 - object4)), (Origin)Origin.RIGHT, (boolean)false, (int)32, null);
                    view.setTag(n3, object3);
                }
                if (this.isShown()) {
                    o.e((Object)object3, (String)"null cannot be cast to non-null type com.mi.widget.shader.CallingShader<*>");
                    ((CallingShader)object3).start();
                } else {
                    this.mStartCallShaderInVisible = true;
                }
                return;
            }
            throw new IllegalStateException("Required value was null.");
        }
    }

    public final void stopCallingEffectIfNeeded$miui_dynamicisland_release() {
        Object object = this.mContentView;
        if (object != null) {
            if ((object = object.getTag(R.id.custom_view_shader)) instanceof CallingShader) {
                if (this.mStartCallShaderInVisible) {
                    this.mStartCallShaderInVisible = false;
                } else {
                    ((CallingShader)object).stop();
                }
            }
            return;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final void syncInterruptAnimWithSwitchFromFakeToReal$miui_dynamicisland_release(SurfaceSyncGroup surfaceSyncGroup) {
        o.g((Object)surfaceSyncGroup, (String)"ssg");
        AttachedSurfaceControl attachedSurfaceControl = this.glowEffectLayerSurfaceSyncer;
        if (attachedSurfaceControl != null) {
            surfaceSyncGroup.add(attachedSurfaceControl, null);
        }
        this.glowEffectLayerSurfaceSyncer = null;
        surfaceSyncGroup.markSyncReady();
    }

    public final void updateGlowEffectAnim$miui_dynamicisland_release(float f, float f2, float f3, float f4, float f5) {
        if (!this.mAttachInterruptedAnim) {
            this.setGlowEffectPosition(f, f2, f3, f4, f5);
        }
    }

    public final void updateInterruptedAnim$miui_dynamicisland_release(float f, float f2, float f3, float f4, float f5) {
        if (!this.mAttachInterruptedAnim) {
            return;
        }
        this.setGlowEffectPosition(f, f2, f3, f4, f5);
    }
}
