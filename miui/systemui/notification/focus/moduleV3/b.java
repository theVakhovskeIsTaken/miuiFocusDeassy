/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Icon
 *  android.widget.ImageView
 */
package miui.systemui.notification.focus.moduleV3;

import android.graphics.drawable.Icon;
import android.widget.ImageView;
import miui.systemui.notification.focus.moduleV3.ModuleBackgroundViewHolder;

public final class b
implements Runnable {
    public final ImageView a;
    public final Icon b;

    public /* synthetic */ b(ImageView imageView, Icon icon) {
        this.a = imageView;
        this.b = icon;
    }

    @Override
    public final void run() {
        ModuleBackgroundViewHolder.c(this.a, this.b);
    }
}
