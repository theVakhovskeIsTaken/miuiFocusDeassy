/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.h
 */
package miui.systemui.dynamicisland.model;

import kotlin.jvm.internal.h;

public final class IslandContentViewCalculationResult {
    private final int bigIslandLeftWidth;
    private final int bigIslandLeftWidthHasSmallIsland;
    private final int bigIslandMarginWidth;
    private final int bigIslandRightWidth;
    private final int bigIslandRightWidthHasSmallIsland;
    private final int bigIslandViewWidth;
    private final int bigIslandViewWidthHasSmallIsland;
    private final int bigIslandX;
    private final int bigIslandXHasSmallIsland;

    public IslandContentViewCalculationResult(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        this.bigIslandViewWidth = n;
        this.bigIslandLeftWidth = n2;
        this.bigIslandRightWidth = n3;
        this.bigIslandX = n4;
        this.bigIslandMarginWidth = n5;
        this.bigIslandViewWidthHasSmallIsland = n6;
        this.bigIslandLeftWidthHasSmallIsland = n7;
        this.bigIslandRightWidthHasSmallIsland = n8;
        this.bigIslandXHasSmallIsland = n9;
    }

    public /* synthetic */ IslandContentViewCalculationResult(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, h h2) {
        if ((n10 & 0x20) != 0) {
            n6 = 0;
        }
        if ((n10 & 0x40) != 0) {
            n7 = 0;
        }
        if ((n10 & 0x80) != 0) {
            n8 = 0;
        }
        if ((n10 & 0x100) != 0) {
            n9 = 0;
        }
        this(n, n2, n3, n4, n5, n6, n7, n8, n9);
    }

    public static /* synthetic */ IslandContentViewCalculationResult copy$default(IslandContentViewCalculationResult islandContentViewCalculationResult, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, Object object) {
        block8: {
            if ((n10 & 1) != 0) {
                n = islandContentViewCalculationResult.bigIslandViewWidth;
            }
            if ((n10 & 2) != 0) {
                n2 = islandContentViewCalculationResult.bigIslandLeftWidth;
            }
            if ((n10 & 4) != 0) {
                n3 = islandContentViewCalculationResult.bigIslandRightWidth;
            }
            if ((n10 & 8) != 0) {
                n4 = islandContentViewCalculationResult.bigIslandX;
            }
            if ((n10 & 0x10) != 0) {
                n5 = islandContentViewCalculationResult.bigIslandMarginWidth;
            }
            if ((n10 & 0x20) != 0) {
                n6 = islandContentViewCalculationResult.bigIslandViewWidthHasSmallIsland;
            }
            if ((n10 & 0x40) != 0) {
                n7 = islandContentViewCalculationResult.bigIslandLeftWidthHasSmallIsland;
            }
            if ((n10 & 0x80) != 0) {
                n8 = islandContentViewCalculationResult.bigIslandRightWidthHasSmallIsland;
            }
            if ((n10 & 0x100) == 0) break block8;
            n9 = islandContentViewCalculationResult.bigIslandXHasSmallIsland;
        }
        return islandContentViewCalculationResult.copy(n, n2, n3, n4, n5, n6, n7, n8, n9);
    }

    public final int component1() {
        return this.bigIslandViewWidth;
    }

    public final int component2() {
        return this.bigIslandLeftWidth;
    }

    public final int component3() {
        return this.bigIslandRightWidth;
    }

    public final int component4() {
        return this.bigIslandX;
    }

    public final int component5() {
        return this.bigIslandMarginWidth;
    }

    public final int component6() {
        return this.bigIslandViewWidthHasSmallIsland;
    }

    public final int component7() {
        return this.bigIslandLeftWidthHasSmallIsland;
    }

    public final int component8() {
        return this.bigIslandRightWidthHasSmallIsland;
    }

    public final int component9() {
        return this.bigIslandXHasSmallIsland;
    }

    public final IslandContentViewCalculationResult copy(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        return new IslandContentViewCalculationResult(n, n2, n3, n4, n5, n6, n7, n8, n9);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof IslandContentViewCalculationResult)) {
            return false;
        }
        object = (IslandContentViewCalculationResult)object;
        if (this.bigIslandViewWidth != ((IslandContentViewCalculationResult)object).bigIslandViewWidth) {
            return false;
        }
        if (this.bigIslandLeftWidth != ((IslandContentViewCalculationResult)object).bigIslandLeftWidth) {
            return false;
        }
        if (this.bigIslandRightWidth != ((IslandContentViewCalculationResult)object).bigIslandRightWidth) {
            return false;
        }
        if (this.bigIslandX != ((IslandContentViewCalculationResult)object).bigIslandX) {
            return false;
        }
        if (this.bigIslandMarginWidth != ((IslandContentViewCalculationResult)object).bigIslandMarginWidth) {
            return false;
        }
        if (this.bigIslandViewWidthHasSmallIsland != ((IslandContentViewCalculationResult)object).bigIslandViewWidthHasSmallIsland) {
            return false;
        }
        if (this.bigIslandLeftWidthHasSmallIsland != ((IslandContentViewCalculationResult)object).bigIslandLeftWidthHasSmallIsland) {
            return false;
        }
        if (this.bigIslandRightWidthHasSmallIsland != ((IslandContentViewCalculationResult)object).bigIslandRightWidthHasSmallIsland) {
            return false;
        }
        return this.bigIslandXHasSmallIsland == ((IslandContentViewCalculationResult)object).bigIslandXHasSmallIsland;
    }

    public final int getBigIslandLeftWidth() {
        return this.bigIslandLeftWidth;
    }

    public final int getBigIslandLeftWidthHasSmallIsland() {
        return this.bigIslandLeftWidthHasSmallIsland;
    }

    public final int getBigIslandMarginWidth() {
        return this.bigIslandMarginWidth;
    }

    public final int getBigIslandRightWidth() {
        return this.bigIslandRightWidth;
    }

    public final int getBigIslandRightWidthHasSmallIsland() {
        return this.bigIslandRightWidthHasSmallIsland;
    }

    public final int getBigIslandViewWidth() {
        return this.bigIslandViewWidth;
    }

    public final int getBigIslandViewWidthHasSmallIsland() {
        return this.bigIslandViewWidthHasSmallIsland;
    }

    public final int getBigIslandX() {
        return this.bigIslandX;
    }

    public final int getBigIslandXHasSmallIsland() {
        return this.bigIslandXHasSmallIsland;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.bigIslandViewWidth) * 31 + Integer.hashCode(this.bigIslandLeftWidth)) * 31 + Integer.hashCode(this.bigIslandRightWidth)) * 31 + Integer.hashCode(this.bigIslandX)) * 31 + Integer.hashCode(this.bigIslandMarginWidth)) * 31 + Integer.hashCode(this.bigIslandViewWidthHasSmallIsland)) * 31 + Integer.hashCode(this.bigIslandLeftWidthHasSmallIsland)) * 31 + Integer.hashCode(this.bigIslandRightWidthHasSmallIsland)) * 31 + Integer.hashCode(this.bigIslandXHasSmallIsland);
    }

    public String toString() {
        int n = this.bigIslandViewWidth;
        int n2 = this.bigIslandLeftWidth;
        int n3 = this.bigIslandRightWidth;
        int n4 = this.bigIslandX;
        int n5 = this.bigIslandMarginWidth;
        int n6 = this.bigIslandViewWidthHasSmallIsland;
        int n7 = this.bigIslandLeftWidthHasSmallIsland;
        int n8 = this.bigIslandRightWidthHasSmallIsland;
        int n9 = this.bigIslandXHasSmallIsland;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IslandContentViewCalculationResult(bigIslandViewWidth=");
        stringBuilder.append(n);
        stringBuilder.append(", bigIslandLeftWidth=");
        stringBuilder.append(n2);
        stringBuilder.append(", bigIslandRightWidth=");
        stringBuilder.append(n3);
        stringBuilder.append(", bigIslandX=");
        stringBuilder.append(n4);
        stringBuilder.append(", bigIslandMarginWidth=");
        stringBuilder.append(n5);
        stringBuilder.append(", bigIslandViewWidthHasSmallIsland=");
        stringBuilder.append(n6);
        stringBuilder.append(", bigIslandLeftWidthHasSmallIsland=");
        stringBuilder.append(n7);
        stringBuilder.append(", bigIslandRightWidthHasSmallIsland=");
        stringBuilder.append(n8);
        stringBuilder.append(", bigIslandXHasSmallIsland=");
        stringBuilder.append(n9);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
