/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package miui.systemui.dynamicisland.window.content.helpers;

import android.view.View;
import miui.systemui.dynamicisland.model.IslandContentViewCalculationParams;
import miui.systemui.dynamicisland.model.IslandContentViewCalculationResult;
import miui.systemui.dynamicisland.model.IslandContentViewHolder;

public interface DynamicIslandContentViewBaseHelper {
    public IslandContentViewCalculationResult calculateBigIslandWidth(IslandContentViewCalculationParams var1);

    public IslandContentViewHolder findAndInitViews(View var1, View var2);

    public int getBigIslandMinWidth();

    public int getIslandHeight();

    public int getIslandViewHeight();
}
