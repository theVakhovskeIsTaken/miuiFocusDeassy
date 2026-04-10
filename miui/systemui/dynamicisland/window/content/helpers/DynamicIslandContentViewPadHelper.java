/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.i
 *  G0.o
 *  android.content.Context
 *  android.util.Log
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  b1.f
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.SystemBarUtilsCompat
 */
package miui.systemui.dynamicisland.window.content.helpers;

import G0.i;
import G0.o;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import b1.f;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository;
import miui.systemui.dynamicisland.model.IslandContentViewCalculationParams;
import miui.systemui.dynamicisland.model.IslandContentViewCalculationResult;
import miui.systemui.dynamicisland.model.IslandContentViewHolder;
import miui.systemui.dynamicisland.window.content.helpers.DynamicIslandContentViewBaseHelper;
import miui.systemui.util.SystemBarUtilsCompat;

public final class DynamicIslandContentViewPadHelper
implements DynamicIslandContentViewBaseHelper {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "DynamicIslandPadHelper";
    private final Context context;
    private final DynamicIslandSizeRepository sizeRepository;

    public DynamicIslandContentViewPadHelper(Context context, DynamicIslandSizeRepository dynamicIslandSizeRepository) {
        kotlin.jvm.internal.o.g((Object)context, (String)"context");
        kotlin.jvm.internal.o.g((Object)dynamicIslandSizeRepository, (String)"sizeRepository");
        this.context = context;
        this.sizeRepository = dynamicIslandSizeRepository;
    }

    private final IslandCalculationResult calculateLargeContentWidth(int n, int n2) {
        i i2;
        int n3 = this.getBigIslandMaxWidth() - this.getBigIslandFixedMarginWidth();
        if (n > n2) {
            int n4 = f.c((int)(n3 - n2), (int)this.getBigIslandReducedWidth());
            n = n2;
            if (n4 + n2 > n3) {
                n = n3 - n4;
            }
            i2 = o.a((Object)n4, (Object)n);
        } else {
            int n5 = f.c((int)(n3 - n), (int)this.getBigIslandReducedWidth());
            n2 = n;
            if (n5 + n > n3) {
                n2 = n3 - n5;
            }
            i2 = o.a((Object)n2, (Object)n5);
        }
        n2 = ((Number)i2.a()).intValue();
        n = ((Number)i2.b()).intValue();
        return new Object(n2, n, this.getBigIslandFixedMarginWidth(), n2 + n + this.getBigIslandFixedMarginWidth(), 3){
            private final int islandWidth;
            private final int leftWidth;
            private final int marginWidth;
            private final int rightWidth;
            private final int ruleNum;
            {
                this.leftWidth = n;
                this.rightWidth = n2;
                this.marginWidth = n3;
                this.islandWidth = n4;
                this.ruleNum = n5;
            }

            public static /* synthetic */ IslandCalculationResult copy$default(IslandCalculationResult islandCalculationResult, int n, int n2, int n3, int n4, int n5, int n6, Object object) {
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

            public final IslandCalculationResult copy(int n, int n2, int n3, int n4, int n5) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public boolean equals(Object object) {
                if (this == object) {
                    return true;
                }
                if (!(object instanceof IslandCalculationResult)) {
                    return false;
                }
                object = object;
                if (this.leftWidth != object.leftWidth) {
                    return false;
                }
                if (this.rightWidth != object.rightWidth) {
                    return false;
                }
                if (this.marginWidth != object.marginWidth) {
                    return false;
                }
                if (this.islandWidth != object.islandWidth) {
                    return false;
                }
                return this.ruleNum == object.ruleNum;
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
        };
    }

    private final IslandCalculationResult calculateMiddleContentWidth(int n, int n2, int n3) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    private final IslandCalculationResult calculateSmallContentWidth(int n, int n2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    @Override
    public IslandContentViewCalculationResult calculateBigIslandWidth(IslandContentViewCalculationParams islandContentViewCalculationParams) {
        kotlin.jvm.internal.o.g((Object)islandContentViewCalculationParams, (String)"params");
        int n = islandContentViewCalculationParams.getBigIslandAreaLeftWidth();
        int n2 = islandContentViewCalculationParams.getBigIslandAreaRightWidth();
        int n3 = n + n2 + this.getBigIslandFixedMarginWidth();
        Object object = new StringBuilder();
        ((StringBuilder)object).append("calculateBigIslandWidth(Pad): leftWidth=");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(", rightWidth=");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(", contentWidth=");
        ((StringBuilder)object).append(n3);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        object = n3 <= this.getBigIslandMinWidth() ? this.calculateSmallContentWidth(n, n2) : (n3 <= this.getBigIslandMaxWidth() ? this.calculateMiddleContentWidth(n, n2, n3) : this.calculateLargeContentWidth(n, n2));
        int n4 = object.component1();
        n = object.component2();
        n2 = object.component3();
        int n5 = object.component4();
        n3 = object.component5();
        object = new StringBuilder();
        ((StringBuilder)object).append("calculateBigIslandWidth(Pad) Rule ");
        ((StringBuilder)object).append(n3);
        ((StringBuilder)object).append(": islandWidth=");
        ((StringBuilder)object).append(n5);
        ((StringBuilder)object).append(", leftWidth=");
        ((StringBuilder)object).append(n4);
        ((StringBuilder)object).append(", rightWidth=");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(", marginWidth=");
        ((StringBuilder)object).append(n2);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        return new IslandContentViewCalculationResult(n5, n4, n, (islandContentViewCalculationParams.getScreenWidth() - n5) / 2, n2, 0, 0, 0, 0);
    }

    @Override
    public IslandContentViewHolder findAndInitViews(View view, View object) {
        FrameLayout frameLayout = null;
        object = view != null ? (LinearLayout)view.findViewById(R.id.big_container) : null;
        FrameLayout frameLayout2 = view != null ? (FrameLayout)view.findViewById(R.id.area_left) : null;
        FrameLayout frameLayout3 = view != null ? (FrameLayout)view.findViewById(R.id.area_right) : null;
        if (view != null) {
            frameLayout = (FrameLayout)view.findViewById(R.id.area_margin);
        }
        Log.d((String)TAG, (String)"findAndInitViews (Pad)");
        return new IslandContentViewHolder((LinearLayout)object, null, frameLayout2, frameLayout3, frameLayout);
    }

    public final int getBigIslandFixedMarginWidth() {
        return (this.sizeRepository.getPadContentViewDimensions().getValue()).getBigIslandFixedMarginWidth();
    }

    public final int getBigIslandMaxWidth() {
        return (this.sizeRepository.getPadContentViewDimensions().getValue()).getBigIslandMaxWidth();
    }

    @Override
    public int getBigIslandMinWidth() {
        return (this.sizeRepository.getPadContentViewDimensions().getValue()).getBigIslandMinWidth();
    }

    public final int getBigIslandReducedWidth() {
        return (this.sizeRepository.getPadContentViewDimensions().getValue()).getBigIslandReducedWidth();
    }

    @Override
    public int getIslandHeight() {
        int n = this.context.getResources().getDimensionPixelSize(R.dimen.island_height_pad);
        Integer n2 = SystemBarUtilsCompat.INSTANCE.getStatusBarHeightCompat(this.context);
        int n3 = 0;
        int n4 = n2 != null ? n2 : 0;
        int n5 = this.context.getResources().getDimensionPixelSize(R.dimen.big_island_min_margin_pad);
        if ((n4 /= 2) - n / 2 < n5) {
            Log.d((String)TAG, (String)"getIslandHeight: islandHeight \u8fc7\u9ad8\uff0c\u91cd\u65b0\u8bbe\u7f6e\u6458\u8981\u6001\u9ad8\u5ea6");
            n = (n4 - n5) * 2;
            n4 = n3;
            if (n > 0) {
                n4 = n;
            }
            return n4;
        }
        return n;
    }

    @Override
    public int getIslandViewHeight() {
        return (this.sizeRepository.getPadContentViewDimensions().getValue()).getIslandViewHeight();
    }
}
