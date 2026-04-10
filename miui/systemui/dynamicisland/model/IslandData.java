/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.model;

import miui.systemui.dynamicisland.model.BigIslandData;
import miui.systemui.dynamicisland.model.SmallIslandData;

public final class IslandData {
    private BigIslandData bigIsland;
    private SmallIslandData smallIsland;

    public final BigIslandData getBigIsland() {
        return this.bigIsland;
    }

    public final SmallIslandData getSmallIsland() {
        return this.smallIsland;
    }

    public final void setBigIsland(BigIslandData bigIslandData) {
        this.bigIsland = bigIslandData;
    }

    public final void setSmallIsland(SmallIslandData smallIslandData) {
        this.smallIsland = smallIslandData;
    }
}
