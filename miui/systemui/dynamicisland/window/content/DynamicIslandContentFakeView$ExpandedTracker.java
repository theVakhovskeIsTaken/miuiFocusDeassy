/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.Log
 */
package miui.systemui.dynamicisland.window.content;

import android.os.Bundle;
import android.util.Log;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;

public static final class DynamicIslandContentFakeView.ExpandedTracker {
    private DynamicIslandEventCoordinator coordinator;
    private String packageName;
    private final Bundle shareBundle = new Bundle();
    private boolean tracked;

    public final void finishTrack() {
        if (!this.tracked) {
            Log.w((String)DynamicIslandContentFakeView.TAG, (String)"finishTrack: not tracked");
            return;
        }
        this.tracked = false;
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.coordinator;
        if (dynamicIslandEventCoordinator != null) {
            Bundle bundle = this.shareBundle;
            bundle.clear();
            bundle.putString("miui.pkg.name", this.packageName);
            dynamicIslandEventCoordinator.finishDropDownExpandedIsland(bundle);
        }
    }

    public final void startTrack(String string, DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        if (this.tracked) {
            Log.e((String)DynamicIslandContentFakeView.TAG, (String)"startTrack: already tracked");
            return;
        }
        if (string != null && string.length() == 0 || dynamicIslandEventCoordinator == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("startTrack: invalid params pkgName=");
            stringBuilder.append(string);
            stringBuilder.append(", coordinator=");
            stringBuilder.append(dynamicIslandEventCoordinator);
            Log.e((String)DynamicIslandContentFakeView.TAG, (String)stringBuilder.toString());
            return;
        }
        this.tracked = true;
        this.packageName = string;
        this.coordinator = dynamicIslandEventCoordinator;
        string = this.shareBundle;
        string.clear();
        string.putString("miui.pkg.name", this.packageName);
        dynamicIslandEventCoordinator = this.coordinator;
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandEventCoordinator.startDropDownExpandedIsland((Bundle)string);
        }
    }

    public final void updateTrack(float f) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
        if (!this.tracked) {
            Log.w((String)DynamicIslandContentFakeView.TAG, (String)"updateTrack: not tracked");
            return;
        }
        float f2 = f;
        if (f < 0.0f) {
            f2 = 0.0f;
        }
        if ((dynamicIslandEventCoordinator = this.coordinator) != null) {
            Bundle bundle = this.shareBundle;
            bundle.clear();
            bundle.putString("miui.pkg.name", this.packageName);
            bundle.putFloat("pull_down_action_offset_y", f2);
            dynamicIslandEventCoordinator.updateDropDownExpandedIsland(bundle);
        }
    }
}
