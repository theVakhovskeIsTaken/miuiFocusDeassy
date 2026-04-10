/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.device.strategy;

public static final class PhoneDynamicIslandAnimationDelegateHelper.LocationParams {
    private final int height;
    private final boolean isExpand;
    private final boolean needUpdate;
    private final int transY;

    public PhoneDynamicIslandAnimationDelegateHelper.LocationParams(boolean bl, boolean bl2, int n, int n2) {
        this.needUpdate = bl;
        this.isExpand = bl2;
        this.transY = n;
        this.height = n2;
    }

    public static /* synthetic */ PhoneDynamicIslandAnimationDelegateHelper.LocationParams copy$default(PhoneDynamicIslandAnimationDelegateHelper.LocationParams locationParams, boolean bl, boolean bl2, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            bl = locationParams.needUpdate;
        }
        if ((n3 & 2) != 0) {
            bl2 = locationParams.isExpand;
        }
        if ((n3 & 4) != 0) {
            n = locationParams.transY;
        }
        if ((n3 & 8) != 0) {
            n2 = locationParams.height;
        }
        return locationParams.copy(bl, bl2, n, n2);
    }

    public final boolean component1() {
        return this.needUpdate;
    }

    public final boolean component2() {
        return this.isExpand;
    }

    public final int component3() {
        return this.transY;
    }

    public final int component4() {
        return this.height;
    }

    public final PhoneDynamicIslandAnimationDelegateHelper.LocationParams copy(boolean bl, boolean bl2, int n, int n2) {
        return new PhoneDynamicIslandAnimationDelegateHelper.LocationParams(bl, bl2, n, n2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PhoneDynamicIslandAnimationDelegateHelper.LocationParams)) {
            return false;
        }
        object = object;
        if (this.needUpdate != (object).needUpdate) {
            return false;
        }
        if (this.isExpand != (object).isExpand) {
            return false;
        }
        if (this.transY != (object).transY) {
            return false;
        }
        return this.height == (object).height;
    }

    public final int getHeight() {
        return this.height;
    }

    public final boolean getNeedUpdate() {
        return this.needUpdate;
    }

    public final int getTransY() {
        return this.transY;
    }

    public int hashCode() {
        return ((Boolean.hashCode(this.needUpdate) * 31 + Boolean.hashCode(this.isExpand)) * 31 + Integer.hashCode(this.transY)) * 31 + Integer.hashCode(this.height);
    }

    public final boolean isExpand() {
        return this.isExpand;
    }

    public String toString() {
        boolean bl = this.needUpdate;
        boolean bl2 = this.isExpand;
        int n = this.transY;
        int n2 = this.height;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocationParams(needUpdate=");
        stringBuilder.append(bl);
        stringBuilder.append(", isExpand=");
        stringBuilder.append(bl2);
        stringBuilder.append(", transY=");
        stringBuilder.append(n);
        stringBuilder.append(", height=");
        stringBuilder.append(n2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
