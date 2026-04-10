/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemProperties
 */
package miui.systemui.dynamicisland;

import android.os.SystemProperties;

public final class DynamicFeatureConfig {
    private static final boolean DEBUG_AVOID_SCREEN_BURN_IN;
    private static final boolean FEATURE_DYNAMIC_ISLAND;
    private static final boolean FEATURE_DYNAMIC_ISLAND_ANIMATION;
    private static final boolean FEATURE_DYNAMIC_ISLAND_SHADER;
    public static final DynamicFeatureConfig INSTANCE;
    private static final boolean ISLAND_XMS_RELEASE;
    private static final boolean ISLAND_XMS_SWITCHER;

    static {
        INSTANCE = new DynamicFeatureConfig();
        FEATURE_DYNAMIC_ISLAND = SystemProperties.getBoolean((String)"persist.sys.feature.island", (boolean)true);
        FEATURE_DYNAMIC_ISLAND_SHADER = SystemProperties.getBoolean((String)"persist.sys.feature.island.shader", (boolean)true);
        FEATURE_DYNAMIC_ISLAND_ANIMATION = SystemProperties.getBoolean((String)"persist.sys.feature.island.animation", (boolean)true);
        DEBUG_AVOID_SCREEN_BURN_IN = SystemProperties.getBoolean((String)"debug.sysui.notif.island.asbi", (boolean)false);
        ISLAND_XMS_RELEASE = SystemProperties.getBoolean((String)"persist.sys.feature.xms.release", (boolean)true);
        ISLAND_XMS_SWITCHER = SystemProperties.getBoolean((String)"persist.sys.feature.xms.switcher", (boolean)false);
    }

    private DynamicFeatureConfig() {
    }

    public final boolean getDEBUG_AVOID_SCREEN_BURN_IN() {
        return DEBUG_AVOID_SCREEN_BURN_IN;
    }

    public final boolean getFEATURE_DYNAMIC_ISLAND() {
        return FEATURE_DYNAMIC_ISLAND;
    }

    public final boolean getFEATURE_DYNAMIC_ISLAND_ANIMATION() {
        return FEATURE_DYNAMIC_ISLAND_ANIMATION;
    }

    public final boolean getFEATURE_DYNAMIC_ISLAND_SHADER() {
        return FEATURE_DYNAMIC_ISLAND_SHADER;
    }

    public final boolean getISLAND_XMS_RELEASE() {
        return ISLAND_XMS_RELEASE;
    }

    public final boolean getISLAND_XMS_SWITCHER() {
        return ISLAND_XMS_SWITCHER;
    }
}
