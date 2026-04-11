/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.content.Context
 *  android.util.Log
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.TextView
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 *  miui.systemui.util.CommonUtils
 *  miuix.colorful.texteffect.HyperChronometer
 */
package miui.systemui.notification.focus.moduleV3;

import U0.a;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import miui.systemui.notification.focus.moduleV3.ModuleTinyAnimationTextViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.u;
import miui.systemui.notification.focus.moduleV3.v;
import miui.systemui.util.CommonUtils;
import miuix.colorful.texteffect.HyperChronometer;

public static final class ModuleTinyAnimationTextViewHolder.initView.1
extends p
implements a {
    final ModuleTinyAnimationTextViewHolder this$0;

    public ModuleTinyAnimationTextViewHolder.initView.1(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
        this.this$0 = moduleTinyAnimationTextViewHolder;
        super(0);
    }

    public static /* synthetic */ void b(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
        ModuleTinyAnimationTextViewHolder.initView.1.invoke$lambda$1(moduleTinyAnimationTextViewHolder);
    }

    public static /* synthetic */ void c(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
        ModuleTinyAnimationTextViewHolder.initView.1.invoke$lambda$0(moduleTinyAnimationTextViewHolder);
    }

    private static final void invoke$lambda$0(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
        o.g((Object)moduleTinyAnimationTextViewHolder, (String)"this$0");
        moduleTinyAnimationTextViewHolder = moduleTinyAnimationTextViewHolder.chronometer;
        if (moduleTinyAnimationTextViewHolder != null) {
            moduleTinyAnimationTextViewHolder.requestLayout();
        }
    }

    private static final void invoke$lambda$1(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
        o.g((Object)moduleTinyAnimationTextViewHolder, (String)"this$0");
        moduleTinyAnimationTextViewHolder = moduleTinyAnimationTextViewHolder.chronometer;
        if (moduleTinyAnimationTextViewHolder != null) {
            moduleTinyAnimationTextViewHolder.requestLayout();
        }
    }

    public final void invoke() {
        Object object = this.this$0.titleContainer;
        int n = object != null ? object.getWidth() : 0;
        if (n > 0 && n != this.this$0.lastTitleContainerWidth) {
            this.this$0.lastTitleContainerWidth = n;
            object = this.this$0;
            int n2 = ((ModuleViewHolder)object).getTextViewWidth((TextView)((ModuleTinyAnimationTextViewHolder)object).chronometer, "88:88:88");
            Object object2 = null;
            object = null;
            if (n2 > n) {
                float f2 = n;
                float f3 = n2;
                float f4 = f2 / f3;
                f3 = f2 = f3 * (f4 - 1.0f) / (float)2;
                if (CommonUtils.isLayoutRtl((Context)ModuleViewHolder.getContext$default(this.this$0, false, 1, null))) {
                    f3 = f2 * (float)-1;
                }
                if ((object2 = this.this$0.chronometer) != null) {
                    object = object2.getLayoutParams();
                }
                if (object != null) {
                    ((ViewGroup.LayoutParams)object).width = n2;
                }
                object = this.this$0.chronometer;
                if (object != null) {
                    object.setScaleX(f4);
                }
                object = this.this$0.chronometer;
                if (object != null) {
                    object.setScaleY(f4);
                }
                object = this.this$0.chronometer;
                if (object != null) {
                    object.setTranslationX(f3);
                }
                object = this.this$0.chronometer;
                if (object != null) {
                    object.post((Runnable)new u(this.this$0));
                }
                object = this.this$0.getRefType();
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(" adjust chronometer for ");
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(", scale to ");
                ((StringBuilder)object2).append(f4);
                ((StringBuilder)object2).append(", transX to ");
                ((StringBuilder)object2).append(f3);
                Log.d((String)"ModuleTinyAnimationTextViewHolder", (String)((StringBuilder)object2).toString());
            } else {
                object = this.this$0.chronometer;
                object = object != null ? Float.valueOf(object.getTranslationX()) : null;
                if (!o.b((Float)object, (float)0.0f)) {
                    Log.d((String)"ModuleTinyAnimationTextViewHolder", (String)" reset chronometer state");
                    HyperChronometer hyperChronometer = this.this$0.chronometer;
                    object = object2;
                    if (hyperChronometer != null) {
                        object = hyperChronometer.getLayoutParams();
                    }
                    if (object != null) {
                        ((ViewGroup.LayoutParams)object).width = -2;
                    }
                    object = this.this$0.chronometer;
                    if (object != null) {
                        object.setScaleX(1.0f);
                    }
                    object = this.this$0.chronometer;
                    if (object != null) {
                        object.setScaleY(1.0f);
                    }
                    object = this.this$0.chronometer;
                    if (object != null) {
                        object.setTranslationX(0.0f);
                    }
                    object = this.this$0.chronometer;
                    if (object != null) {
                        object.post((Runnable)new v(this.this$0));
                    }
                }
            }
        }
    }
}
