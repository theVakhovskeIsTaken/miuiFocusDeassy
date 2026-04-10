/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  b1.f
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.device.strategy;

import android.content.Context;
import b1.f;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.device.strategy.DynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;

public final class PhoneDynamicIslandAnimationDelegateHelper
extends DynamicIslandAnimationDelegateHelper {
    public PhoneDynamicIslandAnimationDelegateHelper(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandAnimationController dynamicIslandAnimationController, SmallIslandStateHandler smallIslandStateHandler, BigIslandStateHandler bigIslandStateHandler, ExpandedStateHandler expandedStateHandler, DynamicIslandWindowView dynamicIslandWindowView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        o.g((Object)dynamicIslandAnimationController, (String)"dynamicIslandAnimController");
        o.g((Object)smallIslandStateHandler, (String)"smallIslandStateHandler");
        o.g((Object)bigIslandStateHandler, (String)"bigIslandStateHandler");
        o.g((Object)expandedStateHandler, (String)"expandedStateHandler");
        o.g((Object)((Object)dynamicIslandWindowView), (String)"windowView");
        super(dynamicIslandBaseContentView, dynamicIslandAnimationController, smallIslandStateHandler, bigIslandStateHandler, expandedStateHandler, dynamicIslandWindowView);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final LocationParams calcBigToDeletedParams(DynamicIslandContentView var1_1) {
        var5_2 = (Boolean)this.getWindowView().getWindowViewController().getWindowState().getStatusBarDisappearance().getValue();
        var4_3 = true;
        var7_4 = null;
        var2_6 = var5_2 != false && (var6_5 /* !! */  = (var6_5 /* !! */  = this.getWindowView().getEventCoordinator()) != null && (var6_5 /* !! */  = var6_5 /* !! */ .getBigIslandStateHandler()) != null ? var6_5 /* !! */ .getCurrentTempShow() : null) == null ? 1 : 0;
        var3_7 = (Boolean)this.getWindowView().getWindowViewController().getWindowState().getStatusBarDisappearance().getValue() == false && (var6_5 /* !! */  = (var6_5 /* !! */  = this.getWindowView().getEventCoordinator()) != null && (var6_5 /* !! */  = var6_5 /* !! */ .getBigIslandStateHandler()) != null ? var6_5 /* !! */ .getCurrent() : null) == null && (var6_5 /* !! */  = (var6_5 /* !! */  = this.getWindowView().getEventCoordinator()) != null && (var6_5 /* !! */  = var6_5 /* !! */ .getBigIslandStateHandler()) != null ? var6_5 /* !! */ .getCurrentTempShow() : null) == null;
        var6_5 /* !! */  = CommonUtils.INSTANCE;
        var8_8 = var1_1.getContext();
        o.f((Object)var8_8, (String)"getContext(...)");
        if ((var6_5 /* !! */ .getInVerticalMode((Context)var8_8) || (var8_8 = var1_1.getCurrentIslandData()) == null || (var8_8 = var8_8.getProperties()) == null || var8_8.intValue() != 0) && !var6_5 /* !! */ .getIS_TABLET() || var2_6 == 0 && !var3_7) ** GOTO lbl-1000
        var8_8 = this.getWindowView().getEventCoordinator();
        var6_5 /* !! */  = var7_4;
        if (var8_8 != null) {
            var8_8 = var8_8.getExpandedStateHandler();
            var6_5 /* !! */  = var7_4;
            if (var8_8 != null) {
                var6_5 /* !! */  = var8_8.getCurrent();
            }
        }
        if (var6_5 /* !! */  == null) {
            var2_6 = var1_1.getIslandViewMarginTop();
            var6_5 /* !! */  = DynamicIslandUtils.INSTANCE;
            var1_1 = var1_1.getContext();
            o.f((Object)var1_1, (String)"getContext(...)");
            var2_6 = f.c((int)(var2_6 - var6_5 /* !! */ .dpToPx(8, (Context)var1_1)), (int)0);
        } else lbl-1000:
        // 2 sources

        {
            var2_6 = 0;
            var4_3 = false;
        }
        return new Object(var4_3, false, var2_6, 0){
            private final int height;
            private final boolean isExpand;
            private final boolean needUpdate;
            private final int transY;
            {
                this.needUpdate = bl;
                this.isExpand = bl2;
                this.transY = n;
                this.height = n2;
            }

            public static /* synthetic */ LocationParams copy$default(LocationParams locationParams, boolean bl, boolean bl2, int n, int n2, int n3, Object object) {
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

            public final LocationParams copy(boolean bl, boolean bl2, int n, int n2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public boolean equals(Object object) {
                if (this == object) {
                    return true;
                }
                if (!(object instanceof LocationParams)) {
                    return false;
                }
                object = object;
                if (this.needUpdate != object.needUpdate) {
                    return false;
                }
                if (this.isExpand != object.isExpand) {
                    return false;
                }
                if (this.transY != object.transY) {
                    return false;
                }
                return this.height == object.height;
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
        };
    }

    private final LocationParams calcBigToTempHiddenParams(DynamicIslandContentView dynamicIslandContentView) {
        CommonUtils commonUtils = CommonUtils.INSTANCE;
        dynamicIslandContentView = dynamicIslandContentView.getContext();
        o.f((Object)((Object)dynamicIslandContentView), (String)"getContext(...)");
        boolean bl = !commonUtils.getInVerticalMode((Context)dynamicIslandContentView) && this.getExpandedStateHandler().getCurrent() == null && this.getBigIslandStateHandler().getCurrentTempShow() == null;
        return new /* invalid duplicate definition of identical inner class */;
    }

    private final LocationParams calcExpandedToBigParams(DynamicIslandContentView dynamicIslandContentView) {
        int n;
        int n2;
        int n3;
        if (o.c((Object)((Object)this.getExpandedStateHandler().getLastExpandedView()), (Object)((Object)dynamicIslandContentView)) && this.getExpandedStateHandler().getCurrent() == null) {
            n3 = dynamicIslandContentView.getIslandViewMarginTop();
            n2 = dynamicIslandContentView.getIslandViewHeight();
            n = 1;
        } else {
            n3 = 0;
            n = n2 = 0;
        }
        return new /* invalid duplicate definition of identical inner class */;
    }

    private final LocationParams calcExpandedToTempHiddenParams(DynamicIslandContentView dynamicIslandContentView) {
        int n;
        int n2;
        int n3;
        if (o.c((Object)((Object)this.getExpandedStateHandler().getLastExpandedView()), (Object)((Object)dynamicIslandContentView)) && this.getExpandedStateHandler().getCurrent() == null) {
            Object object = CommonUtils.INSTANCE;
            Context context = dynamicIslandContentView.getContext();
            o.f((Object)context, (String)"getContext(...)");
            boolean bl = object.getInVerticalMode(context);
            n3 = 1;
            if (!bl && (object = (object = this.getWindowView().getEventCoordinator()) != null && (object = object.getBigIslandStateHandler()) != null ? object.getCurrentTempShow() : null) == null) {
                n2 = 0;
                n = 0;
            } else {
                n2 = dynamicIslandContentView.getIslandViewMarginTop();
                n = dynamicIslandContentView.getIslandViewHeight();
            }
        } else {
            n2 = 0;
            n3 = n = 0;
        }
        return new /* invalid duplicate definition of identical inner class */;
    }

    private final LocationParams calcInitToBigParams(DynamicIslandContentView dynamicIslandContentView) {
        int n;
        int n2;
        int n3;
        Object object = CommonUtils.INSTANCE;
        Object object2 = dynamicIslandContentView.getContext();
        o.f((Object)object2, (String)"getContext(...)");
        if ((!object.getInVerticalMode((Context)object2) && (object2 = dynamicIslandContentView.getCurrentIslandData()) != null && (object2 = object2.getProperties()) != null && (Integer)object2 == 0 || object.getIS_TABLET()) && (object = (object = this.getWindowView().getEventCoordinator()) != null && (object = object.getExpandedStateHandler()) != null ? object.getCurrent() : null) == null) {
            n3 = dynamicIslandContentView.getIslandViewMarginTop();
            n2 = dynamicIslandContentView.getIslandViewHeight();
            n = 1;
        } else {
            n3 = 0;
            n = n2 = 0;
        }
        return new /* invalid duplicate definition of identical inner class */;
    }

    private final LocationParams calcInitToExpandedParams(DynamicIslandContentView dynamicIslandContentView) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    private final LocationParams calcLocationParams(DynamicIslandAnimationType object, DynamicIslandContentView dynamicIslandContentView) {
        switch (WhenMappings.$EnumSwitchMapping$0[object.ordinal()]) {
            default: {
                object = new /* invalid duplicate definition of identical inner class */;
                break;
            }
            case 15: {
                object = this.calcTempHiddenToBigParams(dynamicIslandContentView);
                break;
            }
            case 14: {
                object = this.calcBigToTempHiddenParams(dynamicIslandContentView);
                break;
            }
            case 13: {
                object = this.calcBigToDeletedParams(dynamicIslandContentView);
                break;
            }
            case 12: {
                object = this.calcExpandedToTempHiddenParams(dynamicIslandContentView);
                break;
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                object = this.calcExpandedToBigParams(dynamicIslandContentView);
                break;
            }
            case 5: {
                object = this.calcInitToBigParams(dynamicIslandContentView);
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                object = this.calcInitToExpandedParams(dynamicIslandContentView);
            }
        }
        return object;
    }

    private final LocationParams calcTempHiddenToBigParams(DynamicIslandContentView dynamicIslandContentView) {
        int n;
        int n2;
        int n3;
        CommonUtils commonUtils = CommonUtils.INSTANCE;
        Context context = dynamicIslandContentView.getContext();
        o.f((Object)context, (String)"getContext(...)");
        if (!commonUtils.getInVerticalMode(context)) {
            n3 = dynamicIslandContentView.getIslandViewMarginTop();
            n2 = dynamicIslandContentView.getIslandViewHeight();
            n = 1;
        } else {
            n3 = 0;
            n = n2 = 0;
        }
        return new /* invalid duplicate definition of identical inner class */;
    }

    @Override
    public void requestUpdateHeadsUpLocation(DynamicIslandAnimationType object, DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)object, (String)"type");
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        object = this.calcLocationParams((DynamicIslandAnimationType)((Object)object), dynamicIslandContentView);
        if (object.getNeedUpdate()) {
            this.updateHeadsUpLocation(object.isExpand(), object.getTransY(), object.getHeight());
        }
    }

    @Override
    public void updateBigIslandContainerBackground(DynamicIslandBaseContentView dynamicIslandBaseContentView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
    }
}
