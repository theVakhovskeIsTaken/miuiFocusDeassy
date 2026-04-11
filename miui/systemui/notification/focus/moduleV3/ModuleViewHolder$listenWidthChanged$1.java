/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus.moduleV3;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.moduleV3.E;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;

public static final class ModuleViewHolder.listenWidthChanged.1
implements View.OnAttachStateChangeListener {
    final ModuleViewHolder this$0;

    public ModuleViewHolder.listenWidthChanged.1(ModuleViewHolder moduleViewHolder) {
        this.this$0 = moduleViewHolder;
    }

    public static /* synthetic */ boolean a(ModuleViewHolder moduleViewHolder) {
        return ModuleViewHolder.listenWidthChanged.1.onViewAttachedToWindow$lambda$0(moduleViewHolder);
    }

    private static final boolean onViewAttachedToWindow$lambda$0(ModuleViewHolder moduleViewHolder) {
        o.g((Object)moduleViewHolder, (String)"this$0");
        View view = moduleViewHolder.getView();
        if (view != null && moduleViewHolder.getLastWidth() == view.getMeasuredWidth()) {
            moduleViewHolder.getWidthChanged().setValue((Object)Boolean.FALSE);
            return true;
        }
        moduleViewHolder.getWidthChanged().setValue((Object)Boolean.TRUE);
        view = moduleViewHolder.getView();
        int n = view != null ? view.getMeasuredWidth() : 0;
        moduleViewHolder.setLastWidth(n);
        return true;
    }

    public void onViewAttachedToWindow(View object) {
        o.g((Object)object, (String)"p0");
        object = this.this$0.getView();
        if (object != null && (object = object.getViewTreeObserver()) != null) {
            object.removeOnPreDrawListener(this.this$0.onPreDrawListener);
        }
        object = this.this$0;
        ((ModuleViewHolder)object).onPreDrawListener = (ViewTreeObserver.OnPreDrawListener)new E((ModuleViewHolder)object);
        object = this.this$0.getView();
        if (object != null && (object = object.getViewTreeObserver()) != null) {
            object.addOnPreDrawListener(this.this$0.onPreDrawListener);
        }
    }

    public void onViewDetachedFromWindow(View view) {
        o.g((Object)view, (String)"p0");
        view = this.this$0.getView();
        if (view != null && (view = view.getViewTreeObserver()) != null) {
            view.removeOnPreDrawListener(this.this$0.onPreDrawListener);
        }
    }
}
