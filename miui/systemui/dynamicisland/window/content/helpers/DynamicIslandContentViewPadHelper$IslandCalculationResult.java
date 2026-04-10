/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window.content.helpers;

public static final class DynamicIslandContentViewPadHelper.IslandCalculationResult {
    private final int islandWidth;
    private final int leftWidth;
    private final int marginWidth;
    private final int rightWidth;
    private final int ruleNum;

    public DynamicIslandContentViewPadHelper.IslandCalculationResult(int n, int n2, int n3, int n4, int n5) {
        this.leftWidth = n;
        this.rightWidth = n2;
        this.marginWidth = n3;
        this.islandWidth = n4;
        this.ruleNum = n5;
    }

    public static /* synthetic */ DynamicIslandContentViewPadHelper.IslandCalculationResult copy$default(DynamicIslandContentViewPadHelper.IslandCalculationResult islandCalculationResult, int n, int n2, int n3, int n4, int n5, int n6, Object object) {
        if ((n6 & 1) != 0) {
            n = islandCalculationResult.leftWidth;
        }
        if ((n6 & 2) != 0) {
            n2 = islandCalculationResult.rightWidth;
        }
        if ((n6 & 4) != 0) {
            n3 = islandCalculationResult.marginWidth;
        }
        if ((n6 & 8) != 0) {
            n4 = islandCalculationResult.islandWidth;
        }
        if ((n6 & 0x10) != 0) {
            n5 = islandCalculationResult.ruleNum;
        }
        return islandCalculationResult.copy(n, n2, n3, n4, n5);
    }

    public final int component1() {
        return this.leftWidth;
    }

    public final int component2() {
        return this.rightWidth;
    }

    public final int component3() {
        return this.marginWidth;
    }

    public final int component4() {
        return this.islandWidth;
    }

    public final int component5() {
        return this.ruleNum;
    }

    public final DynamicIslandContentViewPadHelper.IslandCalculationResult copy(int n, int n2, int n3, int n4, int n5) {
        return new DynamicIslandContentViewPadHelper.IslandCalculationResult(n, n2, n3, n4, n5);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DynamicIslandContentViewPadHelper.IslandCalculationResult)) {
            return false;
        }
        object = object;
        if (this.leftWidth != (object).leftWidth) {
            return false;
        }
        if (this.rightWidth != (object).rightWidth) {
            return false;
        }
        if (this.marginWidth != (object).marginWidth) {
            return false;
        }
        if (this.islandWidth != (object).islandWidth) {
            return false;
        }
        return this.ruleNum == (object).ruleNum;
    }

    public final int getIslandWidth() {
        return this.islandWidth;
    }

    public final int getLeftWidth() {
        return this.leftWidth;
    }

    public final int getMarginWidth() {
        return this.marginWidth;
    }

    public final int getRightWidth() {
        return this.rightWidth;
    }

    public final int getRuleNum() {
        return this.ruleNum;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.leftWidth) * 31 + Integer.hashCode(this.rightWidth)) * 31 + Integer.hashCode(this.marginWidth)) * 31 + Integer.hashCode(this.islandWidth)) * 31 + Integer.hashCode(this.ruleNum);
    }

    public String toString() {
        int n = this.leftWidth;
        int n2 = this.rightWidth;
        int n3 = this.marginWidth;
        int n4 = this.islandWidth;
        int n5 = this.ruleNum;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IslandCalculationResult(leftWidth=");
        stringBuilder.append(n);
        stringBuilder.append(", rightWidth=");
        stringBuilder.append(n2);
        stringBuilder.append(", marginWidth=");
        stringBuilder.append(n3);
        stringBuilder.append(", islandWidth=");
        stringBuilder.append(n4);
        stringBuilder.append(", ruleNum=");
        stringBuilder.append(n5);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
