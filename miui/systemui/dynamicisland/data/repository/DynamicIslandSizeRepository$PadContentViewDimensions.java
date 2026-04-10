/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.data.repository;

public static final class DynamicIslandSizeRepository.PadContentViewDimensions {
    private final int bigIslandFixedMarginWidth;
    private final int bigIslandMaxWidth;
    private final int bigIslandMinWidth;
    private final int bigIslandReducedWidth;
    private final int islandViewHeight;

    public DynamicIslandSizeRepository.PadContentViewDimensions(int n, int n2, int n3, int n4, int n5) {
        this.islandViewHeight = n;
        this.bigIslandMinWidth = n2;
        this.bigIslandMaxWidth = n3;
        this.bigIslandFixedMarginWidth = n4;
        this.bigIslandReducedWidth = n5;
    }

    public static /* synthetic */ DynamicIslandSizeRepository.PadContentViewDimensions copy$default(DynamicIslandSizeRepository.PadContentViewDimensions padContentViewDimensions, int n, int n2, int n3, int n4, int n5, int n6, Object object) {
        if ((n6 & 1) != 0) {
            n = padContentViewDimensions.islandViewHeight;
        }
        if ((n6 & 2) != 0) {
            n2 = padContentViewDimensions.bigIslandMinWidth;
        }
        if ((n6 & 4) != 0) {
            n3 = padContentViewDimensions.bigIslandMaxWidth;
        }
        if ((n6 & 8) != 0) {
            n4 = padContentViewDimensions.bigIslandFixedMarginWidth;
        }
        if ((n6 & 0x10) != 0) {
            n5 = padContentViewDimensions.bigIslandReducedWidth;
        }
        return padContentViewDimensions.copy(n, n2, n3, n4, n5);
    }

    public final int component1() {
        return this.islandViewHeight;
    }

    public final int component2() {
        return this.bigIslandMinWidth;
    }

    public final int component3() {
        return this.bigIslandMaxWidth;
    }

    public final int component4() {
        return this.bigIslandFixedMarginWidth;
    }

    public final int component5() {
        return this.bigIslandReducedWidth;
    }

    public final DynamicIslandSizeRepository.PadContentViewDimensions copy(int n, int n2, int n3, int n4, int n5) {
        return new DynamicIslandSizeRepository.PadContentViewDimensions(n, n2, n3, n4, n5);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DynamicIslandSizeRepository.PadContentViewDimensions)) {
            return false;
        }
        object = object;
        if (this.islandViewHeight != (object).islandViewHeight) {
            return false;
        }
        if (this.bigIslandMinWidth != (object).bigIslandMinWidth) {
            return false;
        }
        if (this.bigIslandMaxWidth != (object).bigIslandMaxWidth) {
            return false;
        }
        if (this.bigIslandFixedMarginWidth != (object).bigIslandFixedMarginWidth) {
            return false;
        }
        return this.bigIslandReducedWidth == (object).bigIslandReducedWidth;
    }

    public final int getBigIslandFixedMarginWidth() {
        return this.bigIslandFixedMarginWidth;
    }

    public final int getBigIslandMaxWidth() {
        return this.bigIslandMaxWidth;
    }

    public final int getBigIslandMinWidth() {
        return this.bigIslandMinWidth;
    }

    public final int getBigIslandReducedWidth() {
        return this.bigIslandReducedWidth;
    }

    public final int getIslandViewHeight() {
        return this.islandViewHeight;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.islandViewHeight) * 31 + Integer.hashCode(this.bigIslandMinWidth)) * 31 + Integer.hashCode(this.bigIslandMaxWidth)) * 31 + Integer.hashCode(this.bigIslandFixedMarginWidth)) * 31 + Integer.hashCode(this.bigIslandReducedWidth);
    }

    public String toString() {
        int n = this.islandViewHeight;
        int n2 = this.bigIslandMinWidth;
        int n3 = this.bigIslandMaxWidth;
        int n4 = this.bigIslandFixedMarginWidth;
        int n5 = this.bigIslandReducedWidth;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PadContentViewDimensions(islandViewHeight=");
        stringBuilder.append(n);
        stringBuilder.append(", bigIslandMinWidth=");
        stringBuilder.append(n2);
        stringBuilder.append(", bigIslandMaxWidth=");
        stringBuilder.append(n3);
        stringBuilder.append(", bigIslandFixedMarginWidth=");
        stringBuilder.append(n4);
        stringBuilder.append(", bigIslandReducedWidth=");
        stringBuilder.append(n5);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
