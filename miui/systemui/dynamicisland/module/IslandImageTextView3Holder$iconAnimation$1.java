/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.module;

import java.util.Collection;
import miui.systemui.dynamicisland.module.IslandImageTextView3Holder;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public static final class IslandImageTextView3Holder.iconAnimation.1
extends TransitionListener {
    final IslandImageTextView3Holder this$0;

    public IslandImageTextView3Holder.iconAnimation.1(IslandImageTextView3Holder islandImageTextView3Holder) {
        this.this$0 = islandImageTextView3Holder;
    }

    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        this.this$0.scheduleUpdate();
    }
}
