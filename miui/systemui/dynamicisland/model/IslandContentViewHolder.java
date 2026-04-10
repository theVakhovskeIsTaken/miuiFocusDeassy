/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.model;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import kotlin.jvm.internal.o;

public final class IslandContentViewHolder {
    private final LinearLayout bigContainer;
    private final FrameLayout bigIslandAreaLeft;
    private final FrameLayout bigIslandAreaMargin;
    private final FrameLayout bigIslandAreaRight;
    private final FrameLayout smallContainer;

    public IslandContentViewHolder(LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4) {
        this.bigContainer = linearLayout;
        this.smallContainer = frameLayout;
        this.bigIslandAreaLeft = frameLayout2;
        this.bigIslandAreaRight = frameLayout3;
        this.bigIslandAreaMargin = frameLayout4;
    }

    public static /* synthetic */ IslandContentViewHolder copy$default(IslandContentViewHolder islandContentViewHolder, LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, int n, Object object) {
        if ((n & 1) != 0) {
            linearLayout = islandContentViewHolder.bigContainer;
        }
        if ((n & 2) != 0) {
            frameLayout = islandContentViewHolder.smallContainer;
        }
        if ((n & 4) != 0) {
            frameLayout2 = islandContentViewHolder.bigIslandAreaLeft;
        }
        if ((n & 8) != 0) {
            frameLayout3 = islandContentViewHolder.bigIslandAreaRight;
        }
        if ((n & 0x10) != 0) {
            frameLayout4 = islandContentViewHolder.bigIslandAreaMargin;
        }
        return islandContentViewHolder.copy(linearLayout, frameLayout, frameLayout2, frameLayout3, frameLayout4);
    }

    public final LinearLayout component1() {
        return this.bigContainer;
    }

    public final FrameLayout component2() {
        return this.smallContainer;
    }

    public final FrameLayout component3() {
        return this.bigIslandAreaLeft;
    }

    public final FrameLayout component4() {
        return this.bigIslandAreaRight;
    }

    public final FrameLayout component5() {
        return this.bigIslandAreaMargin;
    }

    public final IslandContentViewHolder copy(LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4) {
        return new IslandContentViewHolder(linearLayout, frameLayout, frameLayout2, frameLayout3, frameLayout4);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof IslandContentViewHolder)) {
            return false;
        }
        object = (IslandContentViewHolder)object;
        if (!o.c((Object)this.bigContainer, (Object)((IslandContentViewHolder)object).bigContainer)) {
            return false;
        }
        if (!o.c((Object)this.smallContainer, (Object)((IslandContentViewHolder)object).smallContainer)) {
            return false;
        }
        if (!o.c((Object)this.bigIslandAreaLeft, (Object)((IslandContentViewHolder)object).bigIslandAreaLeft)) {
            return false;
        }
        if (!o.c((Object)this.bigIslandAreaRight, (Object)((IslandContentViewHolder)object).bigIslandAreaRight)) {
            return false;
        }
        return o.c((Object)this.bigIslandAreaMargin, (Object)((IslandContentViewHolder)object).bigIslandAreaMargin);
    }

    public final LinearLayout getBigContainer() {
        return this.bigContainer;
    }

    public final FrameLayout getBigIslandAreaLeft() {
        return this.bigIslandAreaLeft;
    }

    public final FrameLayout getBigIslandAreaMargin() {
        return this.bigIslandAreaMargin;
    }

    public final FrameLayout getBigIslandAreaRight() {
        return this.bigIslandAreaRight;
    }

    public final FrameLayout getSmallContainer() {
        return this.smallContainer;
    }

    public int hashCode() {
        LinearLayout linearLayout = this.bigContainer;
        int n = 0;
        int n2 = linearLayout == null ? 0 : linearLayout.hashCode();
        linearLayout = this.smallContainer;
        int n3 = linearLayout == null ? 0 : linearLayout.hashCode();
        linearLayout = this.bigIslandAreaLeft;
        int n4 = linearLayout == null ? 0 : linearLayout.hashCode();
        linearLayout = this.bigIslandAreaRight;
        int n5 = linearLayout == null ? 0 : linearLayout.hashCode();
        linearLayout = this.bigIslandAreaMargin;
        if (linearLayout != null) {
            n = linearLayout.hashCode();
        }
        return (((n2 * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n;
    }

    public String toString() {
        LinearLayout linearLayout = this.bigContainer;
        FrameLayout frameLayout = this.smallContainer;
        FrameLayout frameLayout2 = this.bigIslandAreaLeft;
        FrameLayout frameLayout3 = this.bigIslandAreaRight;
        FrameLayout frameLayout4 = this.bigIslandAreaMargin;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IslandContentViewHolder(bigContainer=");
        stringBuilder.append(linearLayout);
        stringBuilder.append(", smallContainer=");
        stringBuilder.append(frameLayout);
        stringBuilder.append(", bigIslandAreaLeft=");
        stringBuilder.append(frameLayout2);
        stringBuilder.append(", bigIslandAreaRight=");
        stringBuilder.append(frameLayout3);
        stringBuilder.append(", bigIslandAreaMargin=");
        stringBuilder.append(frameLayout4);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
