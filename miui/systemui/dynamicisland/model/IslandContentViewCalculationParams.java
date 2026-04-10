/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.h
 */
package miui.systemui.dynamicisland.model;

import kotlin.jvm.internal.h;

public final class IslandContentViewCalculationParams {
    private final float batteryWidth;
    private final int bigIslandAreaLeftWidth;
    private final int bigIslandAreaRightWidth;
    private final int bigIslandLeftWidth;
    private final int bigIslandRightWidth;
    private int bigIslandViewWidthHasSmallIsland;
    private int bigIslandXHasSmallIsland;
    private final float clockWidth;
    private final int cutoutWidth;
    private final boolean isFoldScreenLayoutLarge;
    private final boolean isRtl;
    private final float maxWidth;
    private final int screenHeight;
    private final int screenWidth;
    private final int smallIslandViewWidth;
    private final int space;

    public IslandContentViewCalculationParams(int n, int n2, int n3, int n4, float f, float f2, float f3, int n5, int n6, int n7, int n8, int n9, boolean bl, boolean bl2, int n10, int n11) {
        this.bigIslandAreaLeftWidth = n;
        this.bigIslandAreaRightWidth = n2;
        this.bigIslandLeftWidth = n3;
        this.bigIslandRightWidth = n4;
        this.maxWidth = f;
        this.clockWidth = f2;
        this.batteryWidth = f3;
        this.cutoutWidth = n5;
        this.screenWidth = n6;
        this.screenHeight = n7;
        this.smallIslandViewWidth = n8;
        this.space = n9;
        this.isRtl = bl;
        this.isFoldScreenLayoutLarge = bl2;
        this.bigIslandViewWidthHasSmallIsland = n10;
        this.bigIslandXHasSmallIsland = n11;
    }

    public /* synthetic */ IslandContentViewCalculationParams(int n, int n2, int n3, int n4, float f, float f2, float f3, int n5, int n6, int n7, int n8, int n9, boolean bl, boolean bl2, int n10, int n11, int n12, h h2) {
        if ((n12 & 0x400) != 0) {
            n8 = 0;
        }
        if ((n12 & 0x800) != 0) {
            n9 = 0;
        }
        if ((n12 & 0x1000) != 0) {
            bl = false;
        }
        if ((n12 & 0x2000) != 0) {
            bl2 = false;
        }
        if ((n12 & 0x4000) != 0) {
            n10 = 0;
        }
        if ((n12 & 0x8000) != 0) {
            n11 = 0;
        }
        this(n, n2, n3, n4, f, f2, f3, n5, n6, n7, n8, n9, bl, bl2, n10, n11);
    }

    public static /* synthetic */ IslandContentViewCalculationParams copy$default(IslandContentViewCalculationParams islandContentViewCalculationParams, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5, int n6, int n7, int n8, int n9, boolean bl, boolean bl2, int n10, int n11, int n12, Object object) {
        block15: {
            if ((n12 & 1) != 0) {
                n = islandContentViewCalculationParams.bigIslandAreaLeftWidth;
            }
            if ((n12 & 2) != 0) {
                n2 = islandContentViewCalculationParams.bigIslandAreaRightWidth;
            }
            if ((n12 & 4) != 0) {
                n3 = islandContentViewCalculationParams.bigIslandLeftWidth;
            }
            if ((n12 & 8) != 0) {
                n4 = islandContentViewCalculationParams.bigIslandRightWidth;
            }
            if ((n12 & 0x10) != 0) {
                f = islandContentViewCalculationParams.maxWidth;
            }
            if ((n12 & 0x20) != 0) {
                f2 = islandContentViewCalculationParams.clockWidth;
            }
            if ((n12 & 0x40) != 0) {
                f3 = islandContentViewCalculationParams.batteryWidth;
            }
            if ((n12 & 0x80) != 0) {
                n5 = islandContentViewCalculationParams.cutoutWidth;
            }
            if ((n12 & 0x100) != 0) {
                n6 = islandContentViewCalculationParams.screenWidth;
            }
            if ((n12 & 0x200) != 0) {
                n7 = islandContentViewCalculationParams.screenHeight;
            }
            if ((n12 & 0x400) != 0) {
                n8 = islandContentViewCalculationParams.smallIslandViewWidth;
            }
            if ((n12 & 0x800) != 0) {
                n9 = islandContentViewCalculationParams.space;
            }
            if ((n12 & 0x1000) != 0) {
                bl = islandContentViewCalculationParams.isRtl;
            }
            if ((n12 & 0x2000) != 0) {
                bl2 = islandContentViewCalculationParams.isFoldScreenLayoutLarge;
            }
            if ((n12 & 0x4000) != 0) {
                n10 = islandContentViewCalculationParams.bigIslandViewWidthHasSmallIsland;
            }
            if ((n12 & 0x8000) == 0) break block15;
            n11 = islandContentViewCalculationParams.bigIslandXHasSmallIsland;
        }
        return islandContentViewCalculationParams.copy(n, n2, n3, n4, f, f2, f3, n5, n6, n7, n8, n9, bl, bl2, n10, n11);
    }

    public final int component1() {
        return this.bigIslandAreaLeftWidth;
    }

    public final int component10() {
        return this.screenHeight;
    }

    public final int component11() {
        return this.smallIslandViewWidth;
    }

    public final int component12() {
        return this.space;
    }

    public final boolean component13() {
        return this.isRtl;
    }

    public final boolean component14() {
        return this.isFoldScreenLayoutLarge;
    }

    public final int component15() {
        return this.bigIslandViewWidthHasSmallIsland;
    }

    public final int component16() {
        return this.bigIslandXHasSmallIsland;
    }

    public final int component2() {
        return this.bigIslandAreaRightWidth;
    }

    public final int component3() {
        return this.bigIslandLeftWidth;
    }

    public final int component4() {
        return this.bigIslandRightWidth;
    }

    public final float component5() {
        return this.maxWidth;
    }

    public final float component6() {
        return this.clockWidth;
    }

    public final float component7() {
        return this.batteryWidth;
    }

    public final int component8() {
        return this.cutoutWidth;
    }

    public final int component9() {
        return this.screenWidth;
    }

    public final IslandContentViewCalculationParams copy(int n, int n2, int n3, int n4, float f, float f2, float f3, int n5, int n6, int n7, int n8, int n9, boolean bl, boolean bl2, int n10, int n11) {
        return new IslandContentViewCalculationParams(n, n2, n3, n4, f, f2, f3, n5, n6, n7, n8, n9, bl, bl2, n10, n11);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof IslandContentViewCalculationParams)) {
            return false;
        }
        object = (IslandContentViewCalculationParams)object;
        if (this.bigIslandAreaLeftWidth != ((IslandContentViewCalculationParams)object).bigIslandAreaLeftWidth) {
            return false;
        }
        if (this.bigIslandAreaRightWidth != ((IslandContentViewCalculationParams)object).bigIslandAreaRightWidth) {
            return false;
        }
        if (this.bigIslandLeftWidth != ((IslandContentViewCalculationParams)object).bigIslandLeftWidth) {
            return false;
        }
        if (this.bigIslandRightWidth != ((IslandContentViewCalculationParams)object).bigIslandRightWidth) {
            return false;
        }
        if (Float.compare(this.maxWidth, ((IslandContentViewCalculationParams)object).maxWidth) != 0) {
            return false;
        }
        if (Float.compare(this.clockWidth, ((IslandContentViewCalculationParams)object).clockWidth) != 0) {
            return false;
        }
        if (Float.compare(this.batteryWidth, ((IslandContentViewCalculationParams)object).batteryWidth) != 0) {
            return false;
        }
        if (this.cutoutWidth != ((IslandContentViewCalculationParams)object).cutoutWidth) {
            return false;
        }
        if (this.screenWidth != ((IslandContentViewCalculationParams)object).screenWidth) {
            return false;
        }
        if (this.screenHeight != ((IslandContentViewCalculationParams)object).screenHeight) {
            return false;
        }
        if (this.smallIslandViewWidth != ((IslandContentViewCalculationParams)object).smallIslandViewWidth) {
            return false;
        }
        if (this.space != ((IslandContentViewCalculationParams)object).space) {
            return false;
        }
        if (this.isRtl != ((IslandContentViewCalculationParams)object).isRtl) {
            return false;
        }
        if (this.isFoldScreenLayoutLarge != ((IslandContentViewCalculationParams)object).isFoldScreenLayoutLarge) {
            return false;
        }
        if (this.bigIslandViewWidthHasSmallIsland != ((IslandContentViewCalculationParams)object).bigIslandViewWidthHasSmallIsland) {
            return false;
        }
        return this.bigIslandXHasSmallIsland == ((IslandContentViewCalculationParams)object).bigIslandXHasSmallIsland;
    }

    public final float getBatteryWidth() {
        return this.batteryWidth;
    }

    public final int getBigIslandAreaLeftWidth() {
        return this.bigIslandAreaLeftWidth;
    }

    public final int getBigIslandAreaRightWidth() {
        return this.bigIslandAreaRightWidth;
    }

    public final int getBigIslandLeftWidth() {
        return this.bigIslandLeftWidth;
    }

    public final int getBigIslandRightWidth() {
        return this.bigIslandRightWidth;
    }

    public final int getBigIslandViewWidthHasSmallIsland() {
        return this.bigIslandViewWidthHasSmallIsland;
    }

    public final int getBigIslandXHasSmallIsland() {
        return this.bigIslandXHasSmallIsland;
    }

    public final float getClockWidth() {
        return this.clockWidth;
    }

    public final int getCutoutWidth() {
        return this.cutoutWidth;
    }

    public final float getMaxWidth() {
        return this.maxWidth;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    public final int getSmallIslandViewWidth() {
        return this.smallIslandViewWidth;
    }

    public final int getSpace() {
        return this.space;
    }

    public int hashCode() {
        return ((((((((((((((Integer.hashCode(this.bigIslandAreaLeftWidth) * 31 + Integer.hashCode(this.bigIslandAreaRightWidth)) * 31 + Integer.hashCode(this.bigIslandLeftWidth)) * 31 + Integer.hashCode(this.bigIslandRightWidth)) * 31 + Float.hashCode(this.maxWidth)) * 31 + Float.hashCode(this.clockWidth)) * 31 + Float.hashCode(this.batteryWidth)) * 31 + Integer.hashCode(this.cutoutWidth)) * 31 + Integer.hashCode(this.screenWidth)) * 31 + Integer.hashCode(this.screenHeight)) * 31 + Integer.hashCode(this.smallIslandViewWidth)) * 31 + Integer.hashCode(this.space)) * 31 + Boolean.hashCode(this.isRtl)) * 31 + Boolean.hashCode(this.isFoldScreenLayoutLarge)) * 31 + Integer.hashCode(this.bigIslandViewWidthHasSmallIsland)) * 31 + Integer.hashCode(this.bigIslandXHasSmallIsland);
    }

    public final boolean isFoldScreenLayoutLarge() {
        return this.isFoldScreenLayoutLarge;
    }

    public final boolean isRtl() {
        return this.isRtl;
    }

    public final void setBigIslandViewWidthHasSmallIsland(int n) {
        this.bigIslandViewWidthHasSmallIsland = n;
    }

    public final void setBigIslandXHasSmallIsland(int n) {
        this.bigIslandXHasSmallIsland = n;
    }

    public String toString() {
        int n = this.bigIslandAreaLeftWidth;
        int n2 = this.bigIslandAreaRightWidth;
        int n3 = this.bigIslandLeftWidth;
        int n4 = this.bigIslandRightWidth;
        float f = this.maxWidth;
        float f2 = this.clockWidth;
        float f3 = this.batteryWidth;
        int n5 = this.cutoutWidth;
        int n6 = this.screenWidth;
        int n7 = this.screenHeight;
        int n8 = this.smallIslandViewWidth;
        int n9 = this.space;
        boolean bl = this.isRtl;
        boolean bl2 = this.isFoldScreenLayoutLarge;
        int n10 = this.bigIslandViewWidthHasSmallIsland;
        int n11 = this.bigIslandXHasSmallIsland;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IslandContentViewCalculationParams(bigIslandAreaLeftWidth=");
        stringBuilder.append(n);
        stringBuilder.append(", bigIslandAreaRightWidth=");
        stringBuilder.append(n2);
        stringBuilder.append(", bigIslandLeftWidth=");
        stringBuilder.append(n3);
        stringBuilder.append(", bigIslandRightWidth=");
        stringBuilder.append(n4);
        stringBuilder.append(", maxWidth=");
        stringBuilder.append(f);
        stringBuilder.append(", clockWidth=");
        stringBuilder.append(f2);
        stringBuilder.append(", batteryWidth=");
        stringBuilder.append(f3);
        stringBuilder.append(", cutoutWidth=");
        stringBuilder.append(n5);
        stringBuilder.append(", screenWidth=");
        stringBuilder.append(n6);
        stringBuilder.append(", screenHeight=");
        stringBuilder.append(n7);
        stringBuilder.append(", smallIslandViewWidth=");
        stringBuilder.append(n8);
        stringBuilder.append(", space=");
        stringBuilder.append(n9);
        stringBuilder.append(", isRtl=");
        stringBuilder.append(bl);
        stringBuilder.append(", isFoldScreenLayoutLarge=");
        stringBuilder.append(bl2);
        stringBuilder.append(", bigIslandViewWidthHasSmallIsland=");
        stringBuilder.append(n10);
        stringBuilder.append(", bigIslandXHasSmallIsland=");
        stringBuilder.append(n11);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
