/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  b1.f
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.FlipUtils
 */
package miui.systemui.dynamicisland.window.content.helpers;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import b1.f;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository;
import miui.systemui.dynamicisland.model.IslandContentViewCalculationParams;
import miui.systemui.dynamicisland.model.IslandContentViewCalculationResult;
import miui.systemui.dynamicisland.model.IslandContentViewHolder;
import miui.systemui.dynamicisland.window.content.helpers.DynamicIslandContentViewBaseHelper;
import miui.systemui.util.FlipUtils;

public final class DynamicIslandContentViewPhoneHelper
implements DynamicIslandContentViewBaseHelper {
    private static final float COMPATIBILITY_VALUE = -1.0f;
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "DynamicIslandPhoneHelper";
    private final Context context;
    private final DynamicIslandSizeRepository sizeRepository;

    public DynamicIslandContentViewPhoneHelper(Context context, DynamicIslandSizeRepository dynamicIslandSizeRepository) {
        o.g((Object)context, (String)"context");
        o.g((Object)dynamicIslandSizeRepository, (String)"sizeRepository");
        this.context = context;
        this.sizeRepository = dynamicIslandSizeRepository;
    }

    private final IslandContentViewCalculationResult calculateFlipTinyLayout(IslandContentViewCalculationParams object) {
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        float f = 810.0f - (float)dynamicIslandUtils.dpToPx(32, this.context);
        float f2 = ((IslandContentViewCalculationParams)object).getCutoutWidth();
        float f3 = 2;
        int n = (int)((f - f2) / f3);
        int n2 = (int)((f - (float)((IslandContentViewCalculationParams)object).getCutoutWidth()) / f3);
        int n3 = Math.min(n + n2 + ((IslandContentViewCalculationParams)object).getCutoutWidth(), (int)f);
        int n4 = (((IslandContentViewCalculationParams)object).getScreenWidth() - n3) / 2;
        object = new StringBuilder();
        ((StringBuilder)object).append("calculateBigIslandWidth isTinyScreen bigIslandLeftWidth=");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" bigIslandRightWidth=");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(" bigIslandViewWidth=");
        ((StringBuilder)object).append(n3);
        ((StringBuilder)object).append(" bigIslandX=");
        ((StringBuilder)object).append(n4);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        return new IslandContentViewCalculationResult(n3, n, n2, n4, dynamicIslandUtils.dpToPx(30, this.context), 0, 0, 0, 0);
    }

    private final float calculateMaxWidthWithSmall(IslandContentViewCalculationParams object, StringBuilder stringBuilder) {
        int n = Math.min(((IslandContentViewCalculationParams)object).getScreenWidth(), ((IslandContentViewCalculationParams)object).getScreenHeight());
        if (((IslandContentViewCalculationParams)object).isFoldScreenLayoutLarge()) {
            return (float)n * 0.42f;
        }
        if (((IslandContentViewCalculationParams)object).getClockWidth() == -1.0f || ((IslandContentViewCalculationParams)object).getBatteryWidth() == -1.0f) {
            return ((IslandContentViewCalculationParams)object).getMaxWidth();
        }
        float f = n / 2;
        float f2 = f - ((IslandContentViewCalculationParams)object).getClockWidth();
        f -= ((IslandContentViewCalculationParams)object).getBatteryWidth();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("calculateBigIslandWidth screenWidth:");
        stringBuilder2.append(n);
        stringBuilder2.append(", maxWidthLeft:");
        stringBuilder2.append(f2);
        stringBuilder2.append(", maxWidthRight:");
        stringBuilder2.append(f);
        stringBuilder.append(stringBuilder2.toString());
        o.f((Object)stringBuilder, (String)"append(...)");
        stringBuilder.append('\n');
        f = Math.min(f2, f - (float)(((IslandContentViewCalculationParams)object).getSmallIslandViewWidth() / 2));
        f2 = (float)2 * f + (float)(((IslandContentViewCalculationParams)object).getSmallIslandViewWidth() / 2);
        object = new StringBuilder();
        ((StringBuilder)object).append("calculateBigIslandWidth maxWidthLeftWithHalfCutOut:");
        ((StringBuilder)object).append(f);
        ((StringBuilder)object).append(", maxWidthWithSmall:");
        ((StringBuilder)object).append(f2);
        stringBuilder.append(((StringBuilder)object).toString());
        o.f((Object)stringBuilder, (String)"append(...)");
        stringBuilder.append('\n');
        return f2;
    }

    @Override
    public IslandContentViewCalculationResult calculateBigIslandWidth(IslandContentViewCalculationParams islandContentViewCalculationParams) {
        o.g((Object)islandContentViewCalculationParams, (String)"params");
        StringBuilder stringBuilder = new StringBuilder();
        if (FlipUtils.isFlipTiny()) {
            return this.calculateFlipTinyLayout(islandContentViewCalculationParams);
        }
        int n = islandContentViewCalculationParams.getBigIslandAreaLeftWidth();
        int n2 = islandContentViewCalculationParams.getBigIslandAreaRightWidth();
        int n3 = islandContentViewCalculationParams.getBigIslandAreaLeftWidth();
        int n4 = islandContentViewCalculationParams.getBigIslandAreaRightWidth();
        int n5 = this.getBigIslandMinWidth();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("calculateBigIslandWidth bigIsland bigIslandAreaLeftWidth:");
        stringBuilder2.append(n3);
        stringBuilder2.append(", bigIslandAreaRightWidth:");
        stringBuilder2.append(n4);
        stringBuilder2.append(", bigIslandMinWidth:");
        stringBuilder2.append(n5);
        stringBuilder.append(stringBuilder2.toString());
        o.f((Object)stringBuilder, (String)"append(...)");
        stringBuilder.append('\n');
        n3 = islandContentViewCalculationParams.getBigIslandLeftWidth() == 0 ? n : islandContentViewCalculationParams.getBigIslandLeftWidth();
        n4 = islandContentViewCalculationParams.getBigIslandRightWidth() == 0 ? n : islandContentViewCalculationParams.getBigIslandRightWidth();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("calculateBigIslandWidth bigIslandLeftWidth=");
        stringBuilder2.append(n3);
        stringBuilder2.append(" bigIslandRightWidth=");
        stringBuilder2.append(n4);
        stringBuilder.append(stringBuilder2.toString());
        o.f((Object)stringBuilder, (String)"append(...)");
        stringBuilder.append('\n');
        float f2 = islandContentViewCalculationParams.getMaxWidth();
        if (islandContentViewCalculationParams.isFoldScreenLayoutLarge()) {
            Log.e((String)TAG, (String)"calculateBigIslandWidth isFoldScreenLayoutLarge");
            f2 = (float)Math.min(islandContentViewCalculationParams.getScreenWidth(), islandContentViewCalculationParams.getScreenHeight()) * 0.42f;
        }
        n3 = islandContentViewCalculationParams.getCutoutWidth();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("calculateBigIslandWidth cutoutWidth ");
        stringBuilder2.append(n3);
        stringBuilder2.append(" ");
        stringBuilder2.append(f2);
        stringBuilder.append(stringBuilder2.toString());
        o.f((Object)stringBuilder, (String)"append(...)");
        stringBuilder.append('\n');
        n4 = Math.max(n, n2);
        n3 = n4 + n4;
        n5 = Math.max(Math.min(islandContentViewCalculationParams.getCutoutWidth() + n3, (int)f2), this.getBigIslandMinWidth());
        int n6 = (islandContentViewCalculationParams.getScreenWidth() - n5) / 2;
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("calculateBigIslandWidth bigIslandX ");
        stringBuilder2.append(n6);
        stringBuilder2.append(" ");
        stringBuilder2.append(n4);
        stringBuilder2.append(" ");
        stringBuilder2.append(n4);
        stringBuilder2.append(" ");
        stringBuilder2.append(n5);
        stringBuilder.append(stringBuilder2.toString());
        o.f((Object)stringBuilder, (String)"append(...)");
        stringBuilder.append('\n');
        n3 = n5 < islandContentViewCalculationParams.getCutoutWidth() + n3 ? n4 - (n3 + islandContentViewCalculationParams.getCutoutWidth() - n5) / 2 : n4 + (n5 - n4 - n4 - islandContentViewCalculationParams.getCutoutWidth()) / 2;
        int n7 = islandContentViewCalculationParams.getSmallIslandViewWidth();
        n4 = islandContentViewCalculationParams.getSmallIslandViewWidth();
        int n8 = islandContentViewCalculationParams.getSpace();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("calculateBigIslandWidth smallWidth: ");
        stringBuilder2.append(n4);
        stringBuilder2.append(", space: ");
        stringBuilder2.append(n8);
        stringBuilder.append(stringBuilder2.toString());
        o.f((Object)stringBuilder, (String)"append(...)");
        stringBuilder.append('\n');
        n4 = n7 / 2;
        if (n - n2 > n4) {
            stringBuilder.append("calculateBigIslandWidth1");
            o.f((Object)stringBuilder, (String)"append(...)");
            stringBuilder.append('\n');
            n2 = n - n4;
            n4 = n;
            n = n2;
        } else {
            stringBuilder.append("calculateBigIslandWidth2");
            o.f((Object)stringBuilder, (String)"append(...)");
            stringBuilder.append('\n');
            n4 = n2 + n4;
            n = n2;
        }
        n2 = n4 + n + islandContentViewCalculationParams.getCutoutWidth() + islandContentViewCalculationParams.getSpace() + n7;
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("calculateBigIslandWidth measuredBigIslandWithSmallWidth:");
        stringBuilder2.append(n2);
        stringBuilder.append(stringBuilder2.toString());
        o.f((Object)stringBuilder, (String)"append(...)");
        stringBuilder.append('\n');
        n7 = f.c((int)f.f((int)n2, (int)((int)this.calculateMaxWidthWithSmall(islandContentViewCalculationParams, stringBuilder))), (int)(this.getBigIslandMinWidth() + islandContentViewCalculationParams.getSpace() + n7));
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("calculateBigIslandWidth bigIslandViewWithSmallWidth:");
        stringBuilder2.append(n7);
        stringBuilder.append(stringBuilder2.toString());
        o.f((Object)stringBuilder, (String)"append(...)");
        stringBuilder.append('\n');
        if (n7 < n2) {
            n2 = (n2 - n7) / 2;
            n4 -= n2;
            n2 = n - n2;
            n = n4;
            n4 = n2;
        } else {
            n7 = (n7 - n2) / 2;
            n2 = n4 + n7;
            n4 = n + n7;
            n = n2;
        }
        islandContentViewCalculationParams.setBigIslandViewWidthHasSmallIsland(islandContentViewCalculationParams.getCutoutWidth() + n + n4);
        islandContentViewCalculationParams.setBigIslandXHasSmallIsland(islandContentViewCalculationParams.getScreenWidth() / 2 - islandContentViewCalculationParams.getCutoutWidth() / 2 - n);
        if (islandContentViewCalculationParams.isRtl()) {
            islandContentViewCalculationParams.setBigIslandXHasSmallIsland(islandContentViewCalculationParams.getScreenWidth() / 2 + islandContentViewCalculationParams.getCutoutWidth() / 2 + n - islandContentViewCalculationParams.getBigIslandViewWidthHasSmallIsland());
        }
        n2 = islandContentViewCalculationParams.getBigIslandXHasSmallIsland();
        n7 = islandContentViewCalculationParams.getBigIslandViewWidthHasSmallIsland();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("calculateBigIslandWidth bigIslandXHasSmallIsland1 ");
        stringBuilder2.append(n2);
        stringBuilder2.append(" ");
        stringBuilder2.append(n);
        stringBuilder2.append(" ");
        stringBuilder2.append(n4);
        stringBuilder2.append(" ");
        stringBuilder2.append(n7);
        stringBuilder.append(stringBuilder2.toString());
        o.f((Object)stringBuilder, (String)"append(...)");
        stringBuilder.append('\n');
        Log.e((String)TAG, (String)stringBuilder.toString());
        return new IslandContentViewCalculationResult(n5, n3, n3, n6, DynamicIslandUtils.INSTANCE.dpToPx(30, this.context), islandContentViewCalculationParams.getBigIslandViewWidthHasSmallIsland(), n, n4, islandContentViewCalculationParams.getBigIslandXHasSmallIsland());
    }

    @Override
    public IslandContentViewHolder findAndInitViews(View object, View object2) {
        FrameLayout frameLayout = null;
        LinearLayout linearLayout = object != null ? (LinearLayout)object.findViewById(R.id.big_container) : null;
        object2 = object2 != null ? (FrameLayout)object2.findViewById(R.id.small_container) : null;
        FrameLayout frameLayout2 = object != null ? (FrameLayout)object.findViewById(R.id.area_left) : null;
        if (object != null) {
            frameLayout = (FrameLayout)object.findViewById(R.id.area_right);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("findAndInitViews (Phone): bigContainer=");
        ((StringBuilder)object).append(linearLayout);
        ((StringBuilder)object).append(", smallContainer=");
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append(", areaLeft=");
        ((StringBuilder)object).append(frameLayout2);
        ((StringBuilder)object).append(", areaRight=");
        ((StringBuilder)object).append(frameLayout);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        return new IslandContentViewHolder(linearLayout, (FrameLayout)object2, frameLayout2, frameLayout, null);
    }

    @Override
    public int getBigIslandMinWidth() {
        return (this.sizeRepository.getPhoneContentViewDimensions().getValue()).getBigIslandMinWidth();
    }

    @Override
    public int getIslandHeight() {
        return this.context.getResources().getDimensionPixelSize(R.dimen.island_height);
    }

    @Override
    public int getIslandViewHeight() {
        return (this.sizeRepository.getPhoneContentViewDimensions().getValue()).getIslandViewHeight();
    }
}
