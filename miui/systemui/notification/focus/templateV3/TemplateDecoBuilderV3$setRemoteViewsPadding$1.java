/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  com.android.systemui.miui.notification.R$dimen
 *  com.android.systemui.miui.notification.R$id
 *  f1.E
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus.templateV3;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.android.systemui.miui.notification.R;
import f1.E;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.ProgressInfo;
import miui.systemui.notification.focus.templateV3.TemplateDecoBuilderV3;

@f(c="miui.systemui.notification.focus.templateV3.TemplateDecoBuilderV3$setRemoteViewsPadding$1", f="TemplateDecoBuilderV3.kt", l={}, m="invokeSuspend")
public static final class TemplateDecoBuilderV3.setRemoteViewsPadding.1
extends l
implements U0.o {
    final View $view;
    int label;
    final TemplateDecoBuilderV3 this$0;

    public TemplateDecoBuilderV3.setRemoteViewsPadding.1(View view, TemplateDecoBuilderV3 templateDecoBuilderV3, d d2) {
        this.$view = view;
        this.this$0 = templateDecoBuilderV3;
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
            float f2;
            k.b((Object)object);
            RelativeLayout relativeLayout = (RelativeLayout)this.$view.findViewById(R.id.area_container);
            object = relativeLayout.getLayoutParams();
            o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)object;
            object = this.this$0.context.getResources();
            int n = R.dimen.focus_notify_template_deco_margin;
            layoutParams.setMarginStart((int)object.getDimension(n));
            layoutParams.topMargin = (int)this.this$0.context.getResources().getDimension(n);
            layoutParams.bottomMargin = (int)this.this$0.context.getResources().getDimension(n);
            object = this.this$0.template.getProgressInfo();
            Object var5_5 = null;
            object = object != null ? b.c((int)((ProgressInfo)object).getProgress()) : null;
            if (object != null) {
                FrameLayout frameLayout = (FrameLayout)this.$view.findViewById(R.id.area_a);
                object = frameLayout.getLayoutParams();
                o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)object;
                object = this.this$0.template.getProgressInfo();
                object = object != null ? b.c((int)((ProgressInfo)object).getProgress()) : null;
                o.d((Object)object);
                if ((Integer)object == 100) {
                    f2 = this.this$0.context.getResources().getDimension(R.dimen.focus_notify_template_deco_progress_margin);
                    layoutParams2.setMarginEnd((int)this.this$0.context.getResources().getDimension(R.dimen.focus_notify_template_deco_area_a_margin));
                } else {
                    ProgressInfo progressInfo = this.this$0.template.getProgressInfo();
                    object = var5_5;
                    if (progressInfo != null) {
                        object = b.c((int)progressInfo.getProgress());
                    }
                    o.d((Object)object);
                    int n2 = (Integer)object;
                    if (51 <= n2 && n2 < 100) {
                        f2 = this.this$0.context.getResources().getDimension(R.dimen.focus_notify_template_deco_progress_margin_end);
                        layoutParams2.setMarginEnd((int)this.this$0.context.getResources().getDimension(R.dimen.focus_notify_template_deco_progress_area_a_margin));
                    } else {
                        f2 = this.this$0.context.getResources().getDimension(n);
                    }
                }
                frameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
            } else {
                f2 = this.this$0.context.getResources().getDimension(n);
            }
            layoutParams.setMarginEnd((int)f2);
            relativeLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
