/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package miui.systemui.dynamicisland.module.ext;

import android.view.View;

public final class IslandIconViewHolderExtKt {
    public static final void checkRes(int n, View view) {
        if (n == -1) {
            if (view != null) {
                view.setVisibility(8);
            }
        } else if (view != null) {
            view.setVisibility(0);
        }
    }
}
