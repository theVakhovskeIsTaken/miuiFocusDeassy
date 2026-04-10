/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.data.repository;

public static final class DynamicIslandSizeRepository.IslandWidthParams {
    private final float batteryWidth;
    private final float clockWidth;
    private final float maxWidth;

    public DynamicIslandSizeRepository.IslandWidthParams(float f, float f2, float f3) {
        this.maxWidth = f;
        this.clockWidth = f2;
        this.batteryWidth = f3;
    }

    public static /* synthetic */ DynamicIslandSizeRepository.IslandWidthParams copy$default(DynamicIslandSizeRepository.IslandWidthParams islandWidthParams, float f, float f2, float f3, int n, Object object) {
        if ((n & 1) != 0) {
            f = islandWidthParams.maxWidth;
        }
        if ((n & 2) != 0) {
            f2 = islandWidthParams.clockWidth;
        }
        if ((n & 4) != 0) {
            f3 = islandWidthParams.batteryWidth;
        }
        return islandWidthParams.copy(f, f2, f3);
    }

    public final float component1() {
        return this.maxWidth;
    }

    public final float component2() {
        return this.clockWidth;
    }

    public final float component3() {
        return this.batteryWidth;
    }

    public final DynamicIslandSizeRepository.IslandWidthParams copy(float f, float f2, float f3) {
        return new DynamicIslandSizeRepository.IslandWidthParams(f, f2, f3);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DynamicIslandSizeRepository.IslandWidthParams)) {
            return false;
        }
        object = object;
        if (Float.compare(this.maxWidth, (object).maxWidth) != 0) {
            return false;
        }
        if (Float.compare(this.clockWidth, (object).clockWidth) != 0) {
            return false;
        }
        return Float.compare(this.batteryWidth, (object).batteryWidth) == 0;
    }

    public final float getBatteryWidth() {
        return this.batteryWidth;
    }

    public final float getClockWidth() {
        return this.clockWidth;
    }

    public final float getMaxWidth() {
        return this.maxWidth;
    }

    public int hashCode() {
        return (Float.hashCode(this.maxWidth) * 31 + Float.hashCode(this.clockWidth)) * 31 + Float.hashCode(this.batteryWidth);
    }

    public String toString() {
        float f = this.maxWidth;
        float f2 = this.clockWidth;
        float f3 = this.batteryWidth;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IslandWidthParams(maxWidth=");
        stringBuilder.append(f);
        stringBuilder.append(", clockWidth=");
        stringBuilder.append(f2);
        stringBuilder.append(", batteryWidth=");
        stringBuilder.append(f3);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
