/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  H0.m
 *  android.os.Bundle
 *  android.util.Log
 *  i1.I
 *  kotlin.jvm.internal.E
 *  kotlin.jvm.internal.o
 *  miui.systemui.settings.data.repository.WorkBenchModeRepository
 */
package miui.systemui.dynamicisland.event;

import H0.m;
import android.os.Bundle;
import android.util.Log;
import i1.I;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.EventCoordinator;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.settings.data.repository.WorkBenchModeRepository;

@DynamicIslandScope
public final class AppEventCoordinator
extends EventCoordinator {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "AppEventCoordinator";
    private List<DynamicIslandContentView> exitAppStateList;
    private final I isDeskMode;

    public AppEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator, WorkBenchModeRepository workBenchModeRepository) {
        o.g((Object)dynamicIslandEventCoordinator, (String)"dynamicIslandEventCoordinator");
        o.g((Object)workBenchModeRepository, (String)"workBenchModeRepository");
        super(dynamicIslandEventCoordinator);
        this.exitAppStateList = new ArrayList<DynamicIslandContentView>();
        this.isDeskMode = workBenchModeRepository.isWorkbenchModeEnabled();
    }

    /*
     * WARNING - void declaration
     */
    private final boolean hasAppExpanded() {
        ArrayList<DynamicIslandContentView> object2 = this.getAppStateHandler().getCurrentList();
        if (object2 != null) {
            for (DynamicIslandContentView dynamicIslandContentView : object2) {
                void var1_6;
                if (dynamicIslandContentView != null) {
                    DynamicIslandState dynamicIslandState = dynamicIslandContentView.getState();
                } else {
                    Object var1_5 = null;
                }
                if (!(var1_6 instanceof DynamicIslandState.AppExpanded)) continue;
                return true;
            }
        }
        return false;
    }

    public final List<DynamicIslandContentView> getExitAppStateList() {
        return this.exitAppStateList;
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    @Override
    public void handleAppEvent(DynamicIslandEvent var1_1, DynamicIslandContentView var2_2, ArrayList<DynamicIslandContentView> var3_3) {
        block41: {
            block37: {
                block40: {
                    block39: {
                        block38: {
                            o.g((Object)var1_1, (String)"event");
                            var8_4 = var1_1 instanceof DynamicIslandEvent.EnterApp;
                            var4_5 = 0;
                            var14_6 = null;
                            var15_7 = null;
                            var13_8 = null;
                            var12_9 = null;
                            if (!var8_4) break block37;
                            var9_10 /* !! */  = new StringBuilder();
                            var9_10 /* !! */ .append("handleEvent: ");
                            var9_10 /* !! */ .append(var1_1);
                            Log.d((String)"DynamicIslandEventDebug", (String)var9_10 /* !! */ .toString());
                            var1_1 = var2_2 != null ? var2_2.getState() : null;
                            var9_10 /* !! */  = var2_2 != null && (var9_10 /* !! */  = var2_2.getCurrentIslandData()) != null && (var9_10 /* !! */  = var9_10 /* !! */ .getExtras()) != null ? var9_10 /* !! */ .getString("miui.pkg.name") : null;
                            var10_12 = var2_2 != null && (var10_12 = var2_2.getCurrentIslandData()) != null ? var10_12.getKey() : null;
                            var11_14 /* !! */  = this.getShowOnceIslandHandler().getCurrent();
                            var11_14 /* !! */  = var11_14 /* !! */  != null && (var11_14 /* !! */  = var11_14 /* !! */ .getCurrentIslandData()) != null ? var11_14 /* !! */ .getKey() : null;
                            var8_4 = o.c((Object)var10_12, (Object)var11_14 /* !! */ );
                            var7_16 = 1;
                            if (!var8_4) break block38;
                            this.getShowOnceIslandHandler().setCurrent(null);
                            this.getBigIslandStateHandler().setCurrentTempShow(null);
                            ** GOTO lbl57
                        }
                        var11_14 /* !! */  = this.getBigIslandStateHandler().getCurrent();
                        var11_14 /* !! */  = var11_14 /* !! */  != null && (var11_14 /* !! */  = var11_14 /* !! */ .getCurrentIslandData()) != null ? var11_14 /* !! */ .getKey() : null;
                        if (!o.c((Object)var10_12, (Object)var11_14 /* !! */ )) break block39;
                        this.getBigIslandStateHandler().setCurrent(null);
                        this.getBigIslandStateHandler().handleFillInState(var3_3);
                        ** GOTO lbl57
                    }
                    var11_14 /* !! */  = this.getSmallIslandStateHandler().getCurrent();
                    var11_14 /* !! */  = var11_14 /* !! */  != null && (var11_14 /* !! */  = var11_14 /* !! */ .getCurrentIslandData()) != null ? var11_14 /* !! */ .getKey() : null;
                    if (!o.c((Object)var10_12, (Object)var11_14 /* !! */ )) break block40;
                    this.getSmallIslandStateHandler().setCurrent(null);
                    this.getSmallIslandStateHandler().handleFillInState(var3_3);
                    StateHandler.addState$default(this.getBigIslandStateHandler(), this.getBigIslandStateHandler().getCurrent(), null, 2, null);
                    ** GOTO lbl57
                }
                var11_14 /* !! */  = this.getExpandedStateHandler().getCurrent();
                var11_14 /* !! */  = var11_14 /* !! */  != null && (var11_14 /* !! */  = var11_14 /* !! */ .getCurrentIslandData()) != null ? var11_14 /* !! */ .getKey() : null;
                if (o.c((Object)var10_12, (Object)var11_14 /* !! */ )) {
                    var4_5 = var2_2 != null && (var10_12 = var2_2.getState()) != null && var10_12.getTempShow() == true ? 1 : 0;
                    var4_5 ^= 1;
                    this.getExpandedStateHandler().setCurrent(null);
                } else {
                    var11_14 /* !! */  = this.getHiddenStateHandler().getCurrent();
                    var11_14 /* !! */  = var11_14 /* !! */  != null && (var11_14 /* !! */  = var11_14 /* !! */ .getCurrentIslandData()) != null ? var11_14 /* !! */ .getKey() : null;
                    if (o.c((Object)var10_12, (Object)var11_14 /* !! */ )) {
                        var10_12 = var2_2 != null && (var10_12 = var2_2.getCurrentIslandData()) != null ? var10_12.getKey() : null;
                        this.removeHiddenState(var3_3, (String)var10_12);
                    }
lbl57:
                    // 6 sources

                    var4_5 = 1;
                }
                if (var4_5 == 0) {
                    this.getStateHandler();
                    var3_3 = var12_9;
                    if (var1_1 != null) {
                        var3_3 = new DynamicIslandState(){};
                        var3_3.setTempShow(true);
                        var3_3 = var1_1.changeToState((DynamicIslandState)var3_3);
                    }
                    this.getAppStateHandler().addState(var2_2, (DynamicIslandState)var3_3);
                    this.getStateHandler().stop();
                    return;
                }
                var10_12 = var3_3 != null ? var3_3.iterator() : null;
                while ((var4_5 = var10_12 != null && var10_12.hasNext() == true ? 1 : 0) != 0) {
                    var11_14 /* !! */  = var10_12.next();
                    o.f((Object)var11_14 /* !! */ , (String)"next(...)");
                    var11_14 /* !! */  = var11_14 /* !! */ .getCurrentIslandData();
                    if (!o.c((Object)(var11_14 /* !! */  = var11_14 /* !! */  != null ? var11_14 /* !! */ .getKey() : null), (Object)(var12_9 = var2_2 != null && (var12_9 = var2_2.getCurrentIslandData()) != null ? var12_9.getKey() : null))) continue;
                    var10_12.remove();
                }
                var10_12 = (ArrayList)E.d(this.getMiniWindowStateHandler().getCurrentMap()).remove(var9_10 /* !! */ );
                var10_12 = var10_12 != null ? var10_12.iterator() : null;
                while ((var4_5 = var10_12 != null && var10_12.hasNext() == true ? 1 : 0) != 0) {
                    var11_14 /* !! */  = (DynamicIslandContentView)var10_12.next();
                    var12_9 = this.getDynamicIslandEventCoordinator();
                    var11_14 /* !! */  = var11_14 /* !! */  != null && (var11_14 /* !! */  = var11_14 /* !! */ .getCurrentIslandData()) != null ? var11_14 /* !! */ .getExtras() : null;
                    var12_9.onWindowAnimExtendLifetimeEnd((Bundle)var11_14 /* !! */ );
                }
                var10_12 = this.getAppStateHandler().getCurrentList();
                if (var10_12 != null) {
                    var11_14 /* !! */  = var10_12.iterator();
                    var4_5 = 0;
                    var5_17 = 0;
                    while (true) {
                        var6_18 = var4_5;
                        if (var11_14 /* !! */ .hasNext()) {
                            var10_12 = var11_14 /* !! */ .next();
                            if (var5_17 < 0) {
                                m.n();
                            }
                            var10_12 = (var12_9 = (DynamicIslandContentView)var10_12) != null && (var10_12 = var12_9.getCurrentIslandData()) != null && (var10_12 = var10_12.getExtras()) != null ? var10_12.getString("miui.pkg.name") : null;
                            var6_18 = var4_5;
                            if (!o.c((Object)var10_12, (Object)var9_10 /* !! */ )) {
                                var6_18 = var4_5;
                                if (!((Boolean)this.isDeskMode.getValue()).booleanValue()) {
                                    if (var12_9 != null) {
                                        this.collapse((DynamicIslandContentView)var12_9, var3_3, this.isTinyScreen());
                                        this.exitAppStateList.add((DynamicIslandContentView)var12_9);
                                    }
                                    var6_18 = 1;
                                }
                            }
                            ++var5_17;
                            var4_5 = var6_18;
                            continue;
                        }
                        break;
                    }
                } else {
                    var6_18 = 0;
                }
                if (var6_18 != 0 && (var3_3 = this.getAppStateHandler().getCurrentList()) != null) {
                    var3_3.clear();
                }
                if ((var3_3 = this.getAppStateHandler().getCurrentList()) != null) {
                    for (Object var3_3 : var3_3) {
                        var3_3 = var3_3 != null && (var3_3 = var3_3.getCurrentIslandData()) != null ? var3_3.getKey() : null;
                        if (!o.c((Object)var3_3, (Object)(var9_10 /* !! */  = var2_2 != null && (var9_10 /* !! */  = var2_2.getCurrentIslandData()) != null ? var9_10 /* !! */ .getKey() : null))) continue;
                        return;
                    }
                }
                if ((var4_5 = (var3_3 = this.getAppStateHandler().getCurrentList()) != null && (var3_3.isEmpty() ^ true) == true ? var7_16 : 0) != 0) {
                    if (this.hasAppExpanded()) {
                        this.getStateHandler();
                        var3_3 = var14_6;
                        if (var1_1 != null) {
                            var3_3 = (Boolean)this.isDeskMode.getValue() != false ? new /* invalid duplicate definition of identical inner class */ : new DynamicIslandState(){};
                            var3_3 = var1_1.changeToState((DynamicIslandState)var3_3);
                        }
                        if ((var1_1 = this.getAppStateHandler().getCurrentList()) != null) {
                            var1_1.add(var2_2);
                        }
                        this.getAppStateHandler().addState(var2_2, (DynamicIslandState)var3_3);
                    } else {
                        this.getStateHandler();
                        var3_3 = var15_7;
                        if (var1_1 != null) {
                            var3_3 = var1_1.changeToState(new /* invalid duplicate definition of identical inner class */);
                        }
                        if ((var1_1 = this.getAppStateHandler().getCurrentList()) != null) {
                            var1_1.add(0, var2_2);
                        }
                        this.getAppStateHandler().addState(var2_2, (DynamicIslandState)var3_3);
                    }
                } else {
                    this.getStateHandler();
                    var3_3 = var13_8;
                    if (var1_1 != null) {
                        var3_3 = var1_1.changeToState(new /* invalid duplicate definition of identical inner class */);
                    }
                    if ((var1_1 = this.getAppStateHandler().getCurrentList()) != null) {
                        var1_1.add(var2_2);
                    }
                    this.getAppStateHandler().addState(var2_2, (DynamicIslandState)var3_3);
                }
                this.getStateHandler().stop();
                break block41;
            }
            if (var1_1 instanceof DynamicIslandEvent.ExitApp) {
                var9_11 = new StringBuilder();
                var9_11.append(" handleEvent: ");
                var9_11.append(var1_1);
                Log.e((String)"DynamicIslandEventDebug", (String)var9_11.toString());
                var1_1 = var2_2 != null && (var1_1 = var2_2.getCurrentIslandData()) != null && (var1_1 = var1_1.getExtras()) != null ? var1_1.getString("miui.pkg.name") : null;
                var9_11 = this.getAppStateHandler().getCurrentList();
                if (var9_11 != null) {
                    var10_13 = var9_11.iterator();
                    while (var10_13.hasNext()) {
                        var9_11 = var10_13.next();
                        if (var4_5 < 0) {
                            m.n();
                        }
                        var9_11 = (var11_15 = (DynamicIslandContentView)var9_11) != null && (var9_11 = var11_15.getCurrentIslandData()) != null && (var9_11 = var9_11.getExtras()) != null ? var9_11.getString("miui.pkg.name") : null;
                        var12_9 = new StringBuilder();
                        var12_9.append("ExitApp: ");
                        var12_9.append((String)var1_1);
                        var12_9.append(" ");
                        var12_9.append((String)var9_11);
                        Log.e((String)"DynamicIslandEventDebug", (String)var12_9.toString());
                        if (o.c((Object)var9_11, var1_1) && var11_15 != null) {
                            this.collapse(var11_15, var3_3, this.isTinyScreen());
                            this.getStateHandler().stop();
                        }
                        ++var4_5;
                    }
                }
                if (((Boolean)this.isDeskMode.getValue()).booleanValue()) {
                    var1_1 = this.getAppStateHandler().getCurrentList();
                    if (var1_1 != null) {
                        var1_1.remove((Object)var2_2);
                    }
                } else {
                    var1_1 = this.getAppStateHandler().getCurrentList();
                    if (var1_1 != null) {
                        var1_1.clear();
                    }
                }
            }
        }
    }

    public final I isDeskMode() {
        return this.isDeskMode;
    }

    public final void setExitAppStateList(List<DynamicIslandContentView> list) {
        o.g(list, (String)"<set-?>");
        this.exitAppStateList = list;
    }
}
