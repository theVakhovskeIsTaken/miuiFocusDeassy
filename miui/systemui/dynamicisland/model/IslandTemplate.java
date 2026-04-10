/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.model;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.model.BigIslandArea;
import miui.systemui.dynamicisland.model.ShareData;
import miui.systemui.dynamicisland.model.SmallIslandArea;

public final class IslandTemplate {
    private String appContentDescription;
    private final BigIslandArea bigIslandArea;
    private final String business;
    private final boolean dismissIsland;
    private final int expandedTime;
    private String highlightColor;
    private boolean islandOrder;
    private Integer islandPriority;
    private Integer islandProperty;
    private final int islandTimeout;
    private final Boolean maxSize;
    private Boolean needCloseAnimation;
    private final ShareData shareData;
    private final SmallIslandArea smallIslandArea;

    public IslandTemplate(BigIslandArea bigIslandArea, SmallIslandArea smallIslandArea, ShareData shareData, String string, boolean bl, int n, String string2, Integer n2, Integer n3, boolean bl2, Boolean bl3, int n4, Boolean bl4, String string3) {
        this.bigIslandArea = bigIslandArea;
        this.smallIslandArea = smallIslandArea;
        this.shareData = shareData;
        this.business = string;
        this.dismissIsland = bl;
        this.islandTimeout = n;
        this.highlightColor = string2;
        this.islandProperty = n2;
        this.islandPriority = n3;
        this.islandOrder = bl2;
        this.needCloseAnimation = bl3;
        this.expandedTime = n4;
        this.maxSize = bl4;
        this.appContentDescription = string3;
    }

    public static /* synthetic */ IslandTemplate copy$default(IslandTemplate islandTemplate, BigIslandArea bigIslandArea, SmallIslandArea smallIslandArea, ShareData shareData, String string, boolean bl, int n, String string2, Integer n2, Integer n3, boolean bl2, Boolean bl3, int n4, Boolean bl4, String string3, int n5, Object object) {
        block13: {
            if ((n5 & 1) != 0) {
                bigIslandArea = islandTemplate.bigIslandArea;
            }
            if ((n5 & 2) != 0) {
                smallIslandArea = islandTemplate.smallIslandArea;
            }
            if ((n5 & 4) != 0) {
                shareData = islandTemplate.shareData;
            }
            if ((n5 & 8) != 0) {
                string = islandTemplate.business;
            }
            if ((n5 & 0x10) != 0) {
                bl = islandTemplate.dismissIsland;
            }
            if ((n5 & 0x20) != 0) {
                n = islandTemplate.islandTimeout;
            }
            if ((n5 & 0x40) != 0) {
                string2 = islandTemplate.highlightColor;
            }
            if ((n5 & 0x80) != 0) {
                n2 = islandTemplate.islandProperty;
            }
            if ((n5 & 0x100) != 0) {
                n3 = islandTemplate.islandPriority;
            }
            if ((n5 & 0x200) != 0) {
                bl2 = islandTemplate.islandOrder;
            }
            if ((n5 & 0x400) != 0) {
                bl3 = islandTemplate.needCloseAnimation;
            }
            if ((n5 & 0x800) != 0) {
                n4 = islandTemplate.expandedTime;
            }
            if ((n5 & 0x1000) != 0) {
                bl4 = islandTemplate.maxSize;
            }
            if ((n5 & 0x2000) == 0) break block13;
            string3 = islandTemplate.appContentDescription;
        }
        return islandTemplate.copy(bigIslandArea, smallIslandArea, shareData, string, bl, n, string2, n2, n3, bl2, bl3, n4, bl4, string3);
    }

    public final BigIslandArea component1() {
        return this.bigIslandArea;
    }

    public final boolean component10() {
        return this.islandOrder;
    }

    public final Boolean component11() {
        return this.needCloseAnimation;
    }

    public final int component12() {
        return this.expandedTime;
    }

    public final Boolean component13() {
        return this.maxSize;
    }

    public final String component14() {
        return this.appContentDescription;
    }

    public final SmallIslandArea component2() {
        return this.smallIslandArea;
    }

    public final ShareData component3() {
        return this.shareData;
    }

    public final String component4() {
        return this.business;
    }

    public final boolean component5() {
        return this.dismissIsland;
    }

    public final int component6() {
        return this.islandTimeout;
    }

    public final String component7() {
        return this.highlightColor;
    }

    public final Integer component8() {
        return this.islandProperty;
    }

    public final Integer component9() {
        return this.islandPriority;
    }

    public final IslandTemplate copy(BigIslandArea bigIslandArea, SmallIslandArea smallIslandArea, ShareData shareData, String string, boolean bl, int n, String string2, Integer n2, Integer n3, boolean bl2, Boolean bl3, int n4, Boolean bl4, String string3) {
        return new IslandTemplate(bigIslandArea, smallIslandArea, shareData, string, bl, n, string2, n2, n3, bl2, bl3, n4, bl4, string3);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof IslandTemplate)) {
            return false;
        }
        object = (IslandTemplate)object;
        if (!o.c((Object)this.bigIslandArea, (Object)((IslandTemplate)object).bigIslandArea)) {
            return false;
        }
        if (!o.c((Object)this.smallIslandArea, (Object)((IslandTemplate)object).smallIslandArea)) {
            return false;
        }
        if (!o.c((Object)this.shareData, (Object)((IslandTemplate)object).shareData)) {
            return false;
        }
        if (!o.c((Object)this.business, (Object)((IslandTemplate)object).business)) {
            return false;
        }
        if (this.dismissIsland != ((IslandTemplate)object).dismissIsland) {
            return false;
        }
        if (this.islandTimeout != ((IslandTemplate)object).islandTimeout) {
            return false;
        }
        if (!o.c((Object)this.highlightColor, (Object)((IslandTemplate)object).highlightColor)) {
            return false;
        }
        if (!o.c((Object)this.islandProperty, (Object)((IslandTemplate)object).islandProperty)) {
            return false;
        }
        if (!o.c((Object)this.islandPriority, (Object)((IslandTemplate)object).islandPriority)) {
            return false;
        }
        if (this.islandOrder != ((IslandTemplate)object).islandOrder) {
            return false;
        }
        if (!o.c((Object)this.needCloseAnimation, (Object)((IslandTemplate)object).needCloseAnimation)) {
            return false;
        }
        if (this.expandedTime != ((IslandTemplate)object).expandedTime) {
            return false;
        }
        if (!o.c((Object)this.maxSize, (Object)((IslandTemplate)object).maxSize)) {
            return false;
        }
        return o.c((Object)this.appContentDescription, (Object)((IslandTemplate)object).appContentDescription);
    }

    public final String getAppContentDescription() {
        return this.appContentDescription;
    }

    public final BigIslandArea getBigIslandArea() {
        return this.bigIslandArea;
    }

    public final String getBusiness() {
        return this.business;
    }

    public final boolean getDismissIsland() {
        return this.dismissIsland;
    }

    public final int getExpandedTime() {
        return this.expandedTime;
    }

    public final String getHighlightColor() {
        return this.highlightColor;
    }

    public final boolean getIslandOrder() {
        return this.islandOrder;
    }

    public final Integer getIslandPriority() {
        return this.islandPriority;
    }

    public final Integer getIslandProperty() {
        return this.islandProperty;
    }

    public final int getIslandTimeout() {
        return this.islandTimeout;
    }

    public final Boolean getMaxSize() {
        return this.maxSize;
    }

    public final Boolean getNeedCloseAnimation() {
        return this.needCloseAnimation;
    }

    public final ShareData getShareData() {
        return this.shareData;
    }

    public final SmallIslandArea getSmallIslandArea() {
        return this.smallIslandArea;
    }

    public int hashCode() {
        Object object = this.bigIslandArea;
        int n = 0;
        int n2 = object == null ? 0 : object.hashCode();
        object = this.smallIslandArea;
        int n3 = object == null ? 0 : object.hashCode();
        object = this.shareData;
        int n4 = object == null ? 0 : object.hashCode();
        object = this.business;
        int n5 = object == null ? 0 : ((String)object).hashCode();
        int n6 = Boolean.hashCode(this.dismissIsland);
        int n7 = Integer.hashCode(this.islandTimeout);
        object = this.highlightColor;
        int n8 = object == null ? 0 : ((String)object).hashCode();
        object = this.islandProperty;
        int n9 = object == null ? 0 : object.hashCode();
        object = this.islandPriority;
        int n10 = object == null ? 0 : object.hashCode();
        int n11 = Boolean.hashCode(this.islandOrder);
        object = this.needCloseAnimation;
        int n12 = object == null ? 0 : object.hashCode();
        int n13 = Integer.hashCode(this.expandedTime);
        object = this.maxSize;
        int n14 = object == null ? 0 : object.hashCode();
        object = this.appContentDescription;
        if (object != null) {
            n = ((String)object).hashCode();
        }
        return ((((((((((((n2 * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n9) * 31 + n10) * 31 + n11) * 31 + n12) * 31 + n13) * 31 + n14) * 31 + n;
    }

    public final void setAppContentDescription(String string) {
        this.appContentDescription = string;
    }

    public final void setHighlightColor(String string) {
        this.highlightColor = string;
    }

    public final void setIslandOrder(boolean bl) {
        this.islandOrder = bl;
    }

    public final void setIslandPriority(Integer n) {
        this.islandPriority = n;
    }

    public final void setIslandProperty(Integer n) {
        this.islandProperty = n;
    }

    public final void setNeedCloseAnimation(Boolean bl) {
        this.needCloseAnimation = bl;
    }

    public String toString() {
        BigIslandArea bigIslandArea = this.bigIslandArea;
        SmallIslandArea smallIslandArea = this.smallIslandArea;
        ShareData shareData = this.shareData;
        String string = this.business;
        boolean bl = this.dismissIsland;
        int n = this.islandTimeout;
        String string2 = this.highlightColor;
        Integer n2 = this.islandProperty;
        Integer n3 = this.islandPriority;
        boolean bl2 = this.islandOrder;
        Boolean bl3 = this.needCloseAnimation;
        int n4 = this.expandedTime;
        Boolean bl4 = this.maxSize;
        String string3 = this.appContentDescription;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IslandTemplate(bigIslandArea=");
        stringBuilder.append(bigIslandArea);
        stringBuilder.append(", smallIslandArea=");
        stringBuilder.append(smallIslandArea);
        stringBuilder.append(", shareData=");
        stringBuilder.append(shareData);
        stringBuilder.append(", business=");
        stringBuilder.append(string);
        stringBuilder.append(", dismissIsland=");
        stringBuilder.append(bl);
        stringBuilder.append(", islandTimeout=");
        stringBuilder.append(n);
        stringBuilder.append(", highlightColor=");
        stringBuilder.append(string2);
        stringBuilder.append(", islandProperty=");
        stringBuilder.append(n2);
        stringBuilder.append(", islandPriority=");
        stringBuilder.append(n3);
        stringBuilder.append(", islandOrder=");
        stringBuilder.append(bl2);
        stringBuilder.append(", needCloseAnimation=");
        stringBuilder.append(bl3);
        stringBuilder.append(", expandedTime=");
        stringBuilder.append(n4);
        stringBuilder.append(", maxSize=");
        stringBuilder.append(bl4);
        stringBuilder.append(", appContentDescription=");
        stringBuilder.append(string3);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
