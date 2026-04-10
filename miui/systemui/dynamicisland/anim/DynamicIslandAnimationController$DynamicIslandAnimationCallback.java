/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.anim;

import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static interface DynamicIslandAnimationController.DynamicIslandAnimationCallback {
    public void onAnimationCancel();

    public void onAnimationFinished();

    public void onAnimationStart(boolean var1, DynamicIslandContentView var2);

    public void onShowOnceStateChange();

    public void onStateChange(String var1, DynamicIslandContentView var2);
}
