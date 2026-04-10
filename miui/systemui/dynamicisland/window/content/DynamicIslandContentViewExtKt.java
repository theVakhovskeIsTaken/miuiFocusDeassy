/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  kotlin.jvm.internal.o
 *  miui.systemui.animation.FolmeKt
 *  miuix.animation.IFolme
 *  miuix.animation.base.AnimConfig
 *  miuix.animation.controller.AnimState
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.window.content;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collection;
import kotlin.jvm.internal.o;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.display.AntiBurnInManager;
import miui.systemui.dynamicisland.display.AntiBurnInManagerKt;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miuix.animation.IFolme;
import miuix.animation.base.AnimConfig;
import miuix.animation.controller.AnimState;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public final class DynamicIslandContentViewExtKt {
    public static final void animBgBurnIn(DynamicIslandContentView dynamicIslandContentView, float f, float f2) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"<this>");
        IFolme iFolme = FolmeKt.getFolme((View)dynamicIslandContentView);
        AnimState animState = new AnimState();
        DynamicIslandContentView.Companion companion = DynamicIslandContentView.Companion;
        iFolme.to((Object)animState.add(companion.getCONTAINER_BG_ALPHA(), f2, new long[0]), new AnimConfig[]{new AnimConfig().setSpecial(companion.getCONTAINER_BG_ALPHA(), companion.getANTI_BURN_IN_EASE(), new float[0]).addListeners(new TransitionListener[]{new TransitionListener(dynamicIslandContentView, f2){
            final DynamicIslandContentView $this_animBgBurnIn;
            final float $to;
            {
                this.$this_animBgBurnIn = dynamicIslandContentView;
                this.$to = f;
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                if (this.$to == 0.6f) {
                    DynamicIslandContentViewExtKt.hideTextShade(this.$this_animBgBurnIn);
                } else {
                    DynamicIslandContentViewExtKt.restoreShade(this.$this_animBgBurnIn);
                }
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                object = this.$this_animBgBurnIn.getContainer();
                object = object != null ? object.getBackground() : null;
                if (object != null) {
                    object.setAlpha((int)((float)255 * this.$this_animBgBurnIn.getContainerBgAlpha()));
                }
                this.$this_animBgBurnIn.invalidate();
            }
        }})});
    }

    public static final void animEnterBurnIn(DynamicIslandContentView dynamicIslandContentView, DynamicIslandContentView object, boolean bl) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"<this>");
        object = dynamicIslandContentView.getDynamicIslandEventCoordinator();
        Object var3_3 = null;
        object = object != null && (object = ((DynamicIslandEventCoordinator)object).getBigIslandStateHandler()) != null ? ((BigIslandStateHandler)object).getCurrent() : null;
        Object object2 = dynamicIslandContentView.getDynamicIslandEventCoordinator();
        dynamicIslandContentView = var3_3;
        if (object2 != null) {
            object2 = ((DynamicIslandEventCoordinator)object2).getSmallIslandStateHandler();
            dynamicIslandContentView = var3_3;
            if (object2 != null) {
                dynamicIslandContentView = ((SmallIslandStateHandler)object2).getCurrent();
            }
        }
        if (object != null) {
            DynamicIslandContentViewExtKt.animBgBurnIn(object, 0.0f, 0.6f);
        }
        if (dynamicIslandContentView != null) {
            DynamicIslandContentViewExtKt.animBgBurnIn(dynamicIslandContentView, 0.0f, 0.6f);
        }
    }

    public static final void animExitBurnIn(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"<this>");
        Object object = dynamicIslandContentView.getDynamicIslandEventCoordinator();
        Object var3_3 = null;
        object = object != null && (object = ((DynamicIslandEventCoordinator)object).getBigIslandStateHandler()) != null ? ((BigIslandStateHandler)object).getCurrent() : null;
        Object object2 = dynamicIslandContentView.getDynamicIslandEventCoordinator();
        dynamicIslandContentView = var3_3;
        if (object2 != null) {
            object2 = ((DynamicIslandEventCoordinator)object2).getSmallIslandStateHandler();
            dynamicIslandContentView = var3_3;
            if (object2 != null) {
                dynamicIslandContentView = ((SmallIslandStateHandler)object2).getCurrent();
            }
        }
        if (object != null) {
            DynamicIslandContentViewExtKt.animBgBurnIn((DynamicIslandContentView)((Object)object), 0.0f, 1.0f);
        }
        if (dynamicIslandContentView != null) {
            DynamicIslandContentViewExtKt.animBgBurnIn(dynamicIslandContentView, 0.0f, 1.0f);
        }
    }

    public static final void dispatchAutoExpand(DynamicIslandContentView object) {
        o.g((Object)object, (String)"<this>");
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = object.getDynamicIslandEventCoordinator();
        if (dynamicIslandEventCoordinator != null && !dynamicIslandEventCoordinator.getUserExpanded() && (object = object.getDynamicIslandEventCoordinator()) != null) {
            DynamicIslandEventCoordinator.dispatchEvent$default((DynamicIslandEventCoordinator)object, DynamicIslandEvent.AutoExpandIsland.INSTANCE, null, 2, null);
        }
    }

    public static final long getRemainingUnitExact(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"<this>");
        long l = dynamicIslandContentView.getHasEverBurnedIn() ? dynamicIslandContentView.getRemainingBurnInUnit() : dynamicIslandContentView.getRemainingUnit();
        return l;
    }

    public static final long getRemainingUnitLong(DynamicIslandContentView object) {
        o.g((Object)object, (String)"<this>");
        long l = ((DynamicIslandContentView)((Object)object)).getHasEverBurnedIn() ? ((DynamicIslandContentView)((Object)object)).getRemainingBurnInUnit() : ((DynamicIslandContentView)((Object)object)).getRemainingUnit();
        object = l;
        if (((Number)object).longValue() < 0L) {
            object = null;
        }
        l = object != null ? ((Long)object).longValue() : AntiBurnInManager.Companion.getEXTEND_EXPOSE_TIME();
        return l;
    }

    public static final void hideTextShade(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"<this>");
        if (!dynamicIslandContentView.inBurnIn()) {
            return;
        }
        for (View view : AntiBurnInManagerKt.findAllViewsById((ViewGroup)dynamicIslandContentView, R.id.island_text_shade)) {
            if (view.getVisibility() != 0) continue;
            dynamicIslandContentView.getShadeBackUp().put(view, 0);
            view.setVisibility(8);
        }
    }

    public static final void initRemainingUnit(DynamicIslandContentView dynamicIslandContentView, long l) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"<this>");
        if (!dynamicIslandContentView.getRemainingUnitInited()) {
            dynamicIslandContentView.setRemainingUnit(l);
            dynamicIslandContentView.setRemainingUnitInited(true);
        }
    }

    public static final boolean pkgHasOtherIslandWindowAnimating(DynamicIslandContentView object) {
        boolean bl;
        Object object2;
        o.g((Object)object, (String)"<this>");
        boolean bl2 = ((DynamicIslandBaseContentView)((Object)object)).pkgHasMultIslands((DynamicIslandContentView)((Object)object));
        Object object3 = ((DynamicIslandBaseContentView)((Object)object)).getPkgName();
        boolean bl3 = true;
        if (object3 != null && (object2 = ((DynamicIslandBaseContentView)((Object)object)).getDynamicIslandEventCoordinator()) != null && (object2 = ((DynamicIslandEventCoordinator)object2).hasIsland((String)object3)) != null && !object2.isEmpty()) {
            object3 = object2.iterator();
            while (object3.hasNext()) {
                DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)object3.next());
                object2 = ((DynamicIslandBaseContentView)((Object)object)).getDynamicIslandEventCoordinator();
                if (object2 == null || !((DynamicIslandEventCoordinator)object2).isIslandWindowAnimating(dynamicIslandContentView)) continue;
                bl = true;
                break;
            }
        } else {
            bl = false;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("pkgHasOtherIslandWindowAnimating: ");
        ((StringBuilder)object).append(bl2);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(bl);
        Log.w((String)"DynamicIslandContentView", (String)((StringBuilder)object).toString());
        bl = bl2 && bl ? bl3 : false;
        return bl;
    }

    public static final void restoreShade(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"<this>");
        for (View view : AntiBurnInManagerKt.findAllViewsById((ViewGroup)dynamicIslandContentView, R.id.island_text_shade)) {
            Integer n = dynamicIslandContentView.getShadeBackUp().get(view);
            if (n == null) continue;
            view.setVisibility(n.intValue());
        }
    }
}
