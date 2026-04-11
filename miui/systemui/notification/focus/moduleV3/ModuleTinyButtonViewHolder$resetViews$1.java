/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.p
 */
package miui.systemui.notification.focus.moduleV3;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;

public static final class ModuleTinyButtonViewHolder.resetViews.1
extends p
implements Function1 {
    final ViewGroup $focusContainer;

    public ModuleTinyButtonViewHolder.resetViews.1(ViewGroup viewGroup) {
        this.$focusContainer = viewGroup;
        super(1);
    }

    public final View invoke(int n) {
        Object object = this.$focusContainer;
        object = object != null ? object.getChildAt(n) : null;
        return object;
    }
}
