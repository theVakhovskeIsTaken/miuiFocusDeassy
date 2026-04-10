/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.data.repository;

public static final class DynamicIslandSizeRepository.PhoneContentViewDimensions {
    private final int bigIslandMinWidth;
    private final int islandViewHeight;

    public DynamicIslandSizeRepository.PhoneContentViewDimensions(int n, int n2) {
        this.islandViewHeight = n;
        this.bigIslandMinWidth = n2;
    }

    public static /* synthetic */ DynamicIslandSizeRepository.PhoneContentViewDimensions copy$default(DynamicIslandSizeRepository.PhoneContentViewDimensions phoneContentViewDimensions, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = phoneContentViewDimensions.islandViewHeight;
        }
        if ((n3 & 2) != 0) {
            n2 = phoneContentViewDimensions.bigIslandMinWidth;
        }
        return phoneContentViewDimensions.copy(n, n2);
    }

    public final int component1() {
        return this.islandViewHeight;
    }

    public final int component2() {
        return this.bigIslandMinWidth;
    }

    public final DynamicIslandSizeRepository.PhoneContentViewDimensions copy(int n, int n2) {
        return new DynamicIslandSizeRepository.PhoneContentViewDimensions(n, n2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DynamicIslandSizeRepository.PhoneContentViewDimensions)) {
            return false;
        }
        object = object;
        if (this.islandViewHeight != (object).islandViewHeight) {
            return false;
        }
        return this.bigIslandMinWidth == (object).bigIslandMinWidth;
    }

    public final int getBigIslandMinWidth() {
        return this.bigIslandMinWidth;
    }

    public final int getIslandViewHeight() {
        return this.islandViewHeight;
    }

    public int hashCode() {
        return Integer.hashCode(this.islandViewHeight) * 31 + Integer.hashCode(this.bigIslandMinWidth);
    }

    public String toString() {
        int n = this.islandViewHeight;
        int n2 = this.bigIslandMinWidth;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PhoneContentViewDimensions(islandViewHeight=");
        stringBuilder.append(n);
        stringBuilder.append(", bigIslandMinWidth=");
        stringBuilder.append(n2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
