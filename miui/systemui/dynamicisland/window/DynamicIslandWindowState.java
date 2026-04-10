/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.j
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  U0.a
 *  U0.p
 *  U0.q
 *  android.content.Context
 *  android.util.Log
 *  f1.E
 *  i1.E
 *  i1.I
 *  i1.K
 *  i1.f
 *  i1.g
 *  i1.h
 *  i1.u
 *  j1.k
 *  kotlin.jvm.internal.o
 *  miui.systemui.controlcenter.ConfigUtils
 *  miui.systemui.dagger.qualifiers.SystemUI
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.DeviceUtils
 */
package miui.systemui.dynamicisland.window;

import G0.j;
import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import U0.a;
import U0.p;
import U0.q;
import android.content.Context;
import android.util.Log;
import f1.E;
import i1.I;
import i1.K;
import i1.f;
import i1.g;
import i1.h;
import i1.u;
import kotlin.jvm.internal.o;
import miui.systemui.controlcenter.ConfigUtils;
import miui.systemui.dagger.qualifiers.SystemUI;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.data.repository.DynamicIslandExternalStateRepository;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.DeviceUtils;

@DynamicIslandScope
public final class DynamicIslandWindowState {
    private u bouncerShowing;
    private Boolean configChange;
    private u controlCenterExpanded;
    private u controlCenterPanelHeightChanging;
    private u controlCenterPanelSwipeToAppearance;
    private u deskTopAnimating;
    private boolean expanded;
    private final DynamicIslandExternalStateRepository externalRepository;
    private boolean isAodOn;
    private boolean isDeviceInteractive;
    private boolean isFullAodOn;
    private boolean isShowOnceIsland;
    private final u isSuperSaveMode;
    private boolean isTinyScreen;
    private boolean keyguardShowing;
    private u kidSpaceShow;
    private boolean lastTinyScreenStatus;
    private final I lockScreenControlCenterCollapse;
    private u miPlayShow;
    private u notificationAppearance;
    private u notificationPanelHeightChanging;
    private u notificationPanelSwipeToAppearance;
    private boolean notificationVisible;
    private final E scope;
    private u screenLocked;
    private boolean screenLockedChange;
    private u screenPinning;
    private u showNotificationIcons;
    private u statusBarDisappearance;
    private u statusBarViewShowing;
    private final u statusBarWindowsInsetsShow;
    private final u statusBarisTransientShowing;
    private final Context sysUIContext;
    private final I tempHidden;
    private Boolean tempHiddenChange;
    private TempHiddenType tempHiddenType;
    private String topActivityPkg;

    public DynamicIslandWindowState(@DynamicIsland E e, DynamicIslandExternalStateRepository object, @SystemUI Context object2) {
        o.g((Object)e, (String)"scope");
        o.g((Object)object, (String)"externalRepository");
        o.g((Object)object2, (String)"sysUIContext");
        this.scope = e;
        this.externalRepository = object;
        this.sysUIContext = object2;
        object2 = Boolean.TRUE;
        this.showNotificationIcons = K.a((Object)object2);
        object = Boolean.FALSE;
        this.controlCenterExpanded = K.a((Object)object);
        this.notificationAppearance = K.a((Object)object);
        this.miPlayShow = K.a((Object)object);
        this.kidSpaceShow = K.a((Object)object);
        this.statusBarDisappearance = K.a((Object)object);
        this.deskTopAnimating = K.a((Object)object);
        this.screenLocked = K.a((Object)object);
        this.bouncerShowing = K.a((Object)object);
        this.statusBarViewShowing = K.a((Object)object2);
        this.statusBarisTransientShowing = K.a((Object)object);
        this.statusBarWindowsInsetsShow = K.a((Object)object2);
        this.screenPinning = K.a((Object)object);
        this.isSuperSaveMode = K.a((Object)object);
        this.notificationPanelSwipeToAppearance = K.a((Object)object);
        this.controlCenterPanelSwipeToAppearance = K.a((Object)object);
        this.notificationPanelHeightChanging = K.a((Object)object);
        this.controlCenterPanelHeightChanging = K.a((Object)object);
        this.topActivityPkg = "";
        this.isDeviceInteractive = true;
        f f2 = h.j((f)this.notificationAppearance, (f)this.controlCenterExpanded, (f)this.screenLocked, (q)new q(null){
            boolean Z$0;
            boolean Z$1;
            boolean Z$2;
            int label;

            public final Object invoke(boolean bl, boolean bl2, boolean bl3, d object) {
                object = new /* invalid duplicate definition of identical inner class */;
                object.Z$0 = bl;
                object.Z$1 = bl2;
                object.Z$2 = bl3;
                return object.invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                c.c();
                if (this.label == 0) {
                    k.b((Object)object);
                    boolean bl = this.Z$0;
                    boolean bl2 = this.Z$1;
                    boolean bl3 = this.Z$2;
                    bl3 = bl && !bl2 && bl3;
                    return b.a((boolean)bl3);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        });
        object2 = i1.E.a;
        this.lockScreenControlCenterCollapse = h.B((f)f2, (E)e, (i1.E)object2.c(), (Object)object);
        this.tempHidden = h.B((f)h.j((f)new f(new f[]{this.notificationAppearance, this.screenLocked, this.statusBarDisappearance, this.controlCenterExpanded, this.deskTopAnimating, this.bouncerShowing, this.screenPinning, this.notificationPanelSwipeToAppearance, this.controlCenterPanelSwipeToAppearance, this.kidSpaceShow}){
            final f[] $flows$inlined;
            {
                this.$flows$inlined = fArray;
            }

            public Object collect(g object, d d2) {
                f[] fArray = this.$flows$inlined;
                if ((object = j1.k.a((g)object, (f[])fArray, (a)new a(fArray){
                    final f[] $flows;
                    {
                        this.$flows = fArray;
                    }

                    public final Boolean[] invoke() {
                        return new Boolean[this.$flows.length];
                    }
                }, (p)new p(null){
                    private Object L$0;
                    Object L$1;
                    int label;

                    /*
                     * Ignored method signature, as it can't be verified against descriptor
                     */
                    public final Object invoke(g g2, Object[] objectArray, d object) {
                        object = new /* invalid duplicate definition of identical inner class */;
                        object.L$0 = g2;
                        object.L$1 = objectArray;
                        return object.invokeSuspend(s.a);
                    }

                    /*
                     * Unable to fully structure code
                     */
                    public final Object invokeSuspend(Object var1_1) {
                        block5: {
                            block3: {
                                block4: {
                                    var13_2 = c.c();
                                    var2_3 = this.label;
                                    if (var2_3 == 0) break block3;
                                    if (var2_3 != 1) break block4;
                                    k.b((Object)var1_1);
                                    break block5;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            k.b((Object)var1_1);
                            var1_1 = (g)this.L$0;
                            var14_4 = (Boolean[])((Object[])this.L$1);
                            var9_5 = var14_4[0];
                            var10_6 = var14_4[1];
                            var12_7 = var14_4[2];
                            var4_8 = var14_4[3];
                            var7_9 = var14_4[4];
                            var6_10 = var14_4[5];
                            var5_11 = var14_4[6];
                            var11_12 = var14_4[7];
                            var8_13 = var14_4[8];
                            var3_14 = var14_4[9];
                            var14_4 = new StringBuilder();
                            var14_4.append("tempHidden1: screenLocked:");
                            var14_4.append(var10_6);
                            var14_4.append(" controlCenterExpanded:");
                            var14_4.append(var4_8);
                            var14_4.append(" notificationAppearance:");
                            var14_4.append(var9_5);
                            var14_4.append(" statusBarDisappearance:");
                            var14_4.append(var12_7);
                            var14_4.append(" bouncerShowing:");
                            var14_4.append(var6_10);
                            var14_4.append(" deskTopAnimating:");
                            var14_4.append(var7_9);
                            var14_4.append(" screenPinning:");
                            var14_4.append(var5_11);
                            var14_4.append(" notificationPanelSwipeToAppearance:");
                            var14_4.append(var11_12);
                            var14_4.append(" controlCenterPanelSwipeToAppearance:");
                            var14_4.append(var8_13);
                            var14_4.append(" kidSpaceShow:");
                            var14_4.append(var3_14);
                            Log.d((String)"DynamicIslandEventDebug", (String)var14_4.toString());
                            var14_4 = CommonUtils.INSTANCE;
                            if (var14_4.getIS_TABLET() != false ? var5_11 == false && (var11_12 != false || var8_13 != false) : var10_6 == false && var9_5 != false && var5_11 == false) ** GOTO lbl-1000
                            if (var12_7 && !var5_11 || (var10_6 || var6_10) && (var14_4.getIS_TABLET() != false ? var8_13 == false : var4_8 == false)) ** GOTO lbl-1000
                            if (!var7_9 && !var3_14) {
                                var3_14 = false;
                            } else lbl-1000:
                            // 3 sources

                            {
                                var3_14 = true;
                            }
                            var14_4 = b.a((boolean)var3_14);
                            this.label = 1;
                            if (var1_1.emit(var14_4, (d)this) == var13_2) {
                                return var13_2;
                            }
                        }
                        return s.a;
                    }
                }, (d)d2)) == c.c()) {
                    return object;
                }
                return s.a;
            }
        }, (f)this.showNotificationIcons, (f)this.screenLocked, (q)new q(null){
            boolean Z$0;
            boolean Z$1;
            boolean Z$2;
            int label;

            public final Object invoke(boolean bl, boolean bl2, boolean bl3, d object) {
                object = new /* invalid duplicate definition of identical inner class */;
                object.Z$0 = bl;
                object.Z$1 = bl2;
                object.Z$2 = bl3;
                return object.invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                c.c();
                if (this.label == 0) {
                    k.b((Object)object);
                    boolean bl = this.Z$0;
                    boolean bl2 = this.Z$1;
                    boolean bl3 = this.Z$2;
                    object = new StringBuilder();
                    ((StringBuilder)object).append("tempHidden2: tempHiddenResult:");
                    ((StringBuilder)object).append(bl);
                    ((StringBuilder)object).append(" showNotificationIcons:");
                    ((StringBuilder)object).append(bl2);
                    ((StringBuilder)object).append(" ");
                    Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object).toString());
                    bl2 = bl || bl3 && !bl2;
                    return b.a((boolean)bl2);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }), (E)e, (i1.E)object2.c(), (Object)object);
    }

    public final boolean canSwipe() {
        boolean bl = ((Boolean)this.statusBarDisappearance.getValue() == false || (Boolean)this.screenPinning.getValue() != false) && !CommonUtils.INSTANCE.getIS_TABLET();
        return bl;
    }

    public final u getBouncerShowing() {
        return this.bouncerShowing;
    }

    public final Boolean getConfigChange() {
        return this.configChange;
    }

    public final u getControlCenterExpanded() {
        return this.controlCenterExpanded;
    }

    public final u getControlCenterPanelHeightChanging() {
        return this.controlCenterPanelHeightChanging;
    }

    public final u getControlCenterPanelSwipeToAppearance() {
        return this.controlCenterPanelSwipeToAppearance;
    }

    public final u getDeskTopAnimating() {
        return this.deskTopAnimating;
    }

    public final boolean getExpanded() {
        return this.expanded;
    }

    public final DynamicIslandExternalStateRepository getExternalRepository() {
        return this.externalRepository;
    }

    public final boolean getKeyguardShowing() {
        return this.keyguardShowing;
    }

    public final u getKidSpaceShow() {
        return this.kidSpaceShow;
    }

    public final boolean getLastTinyScreenStatus() {
        return this.lastTinyScreenStatus;
    }

    public final I getLockScreenControlCenterCollapse() {
        return this.lockScreenControlCenterCollapse;
    }

    public final u getMiPlayShow() {
        return this.miPlayShow;
    }

    public final u getNotificationAppearance() {
        return this.notificationAppearance;
    }

    public final u getNotificationPanelHeightChanging() {
        return this.notificationPanelHeightChanging;
    }

    public final u getNotificationPanelSwipeToAppearance() {
        return this.notificationPanelSwipeToAppearance;
    }

    public final boolean getNotificationVisible() {
        return this.notificationVisible;
    }

    public final boolean getPanelHeightChanging() {
        boolean bl = CommonUtils.INSTANCE.getIS_TABLET() && ((Boolean)this.notificationPanelHeightChanging.getValue() != false || (Boolean)this.controlCenterPanelHeightChanging.getValue() != false);
        return bl;
    }

    public final u getScreenLocked() {
        return this.screenLocked;
    }

    public final boolean getScreenLockedChange() {
        return this.screenLockedChange;
    }

    public final u getScreenPinning() {
        return this.screenPinning;
    }

    public final u getShowNotificationIcons() {
        return this.showNotificationIcons;
    }

    public final u getStatusBarDisappearance() {
        return this.statusBarDisappearance;
    }

    public final u getStatusBarViewShowing() {
        return this.statusBarViewShowing;
    }

    public final u getStatusBarWindowsInsetsShow() {
        return this.statusBarWindowsInsetsShow;
    }

    public final u getStatusBarisTransientShowing() {
        return this.statusBarisTransientShowing;
    }

    public final I getTempHidden() {
        return this.tempHidden;
    }

    public final Boolean getTempHiddenChange() {
        return this.tempHiddenChange;
    }

    public final TempHiddenType getTempHiddenType() {
        return this.tempHiddenType;
    }

    public final String getTopActivityPkg() {
        return this.topActivityPkg;
    }

    public final boolean isAdaptDesktopAnimation(Context context) {
        o.g((Object)context, (String)"context");
        boolean bl = ConfigUtils.INSTANCE.isLandscape(context) && (Boolean)this.screenPinning.getValue() == false && !CommonUtils.INSTANCE.getIS_TABLET();
        return bl;
    }

    public final boolean isAodOn() {
        return this.isAodOn;
    }

    public final boolean isDeviceInteractive() {
        return this.isDeviceInteractive;
    }

    public final boolean isFullAodOn() {
        return this.isFullAodOn;
    }

    public final boolean isNeedDelayUnLockAnimation() {
        boolean bl = (DeviceUtils.isMidLowLevel() || DeviceUtils.isLowLevel() || DeviceUtils.isNormalLevel() || DeviceUtils.isSubMidLevel()) && (Boolean)this.screenLocked.getValue() == false && this.tempHiddenType == TempHiddenType.SCREEN_LOCKED;
        return bl;
    }

    public final boolean isShowOnceIsland() {
        return this.isShowOnceIsland;
    }

    public final boolean isSplitScreenMode() {
        Object object;
        Object object2;
        try {
            object2 = j.a;
            object2 = Class.forName("com.android.wm.shell.sosc.SoScUtils", false, this.sysUIContext.getClassLoader());
            object2 = ((Class)object2).getDeclaredMethod("isSoScActive", null).invoke(((Class)object2).getDeclaredMethod("getInstance", null).invoke(null, null), null);
            o.e((Object)object2, (String)"null cannot be cast to non-null type kotlin.Boolean");
            object = (Boolean)object2;
            boolean bl = (Boolean)object;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("isSplitScreenMode: value = ");
            ((StringBuilder)object2).append(bl);
            Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object2).toString());
            object2 = j.a((Object)object);
        }
        catch (Throwable throwable) {
            object = j.a;
            object2 = j.a((Object)k.a((Throwable)throwable));
        }
        object = j.b((Object)object2);
        if (object != null) {
            Log.e((String)"DynamicIslandEventDebug", (String)"Failed to invoke method isSoScActive.", (Throwable)object);
        }
        Boolean bl = Boolean.FALSE;
        object = object2;
        if (j.c((Object)object2)) {
            object = bl;
        }
        return (Boolean)object;
    }

    public final u isSuperSaveMode() {
        return this.isSuperSaveMode;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean isTempHidden(Integer n) {
        boolean bl = (Boolean)this.miPlayShow.getValue();
        boolean bl2 = true;
        if (bl) {
            return true;
        }
        if (((Boolean)this.bouncerShowing.getValue()).booleanValue() && n != null && n == 0 && !((Boolean)this.screenPinning.getValue()).booleanValue() && !CommonUtils.INSTANCE.getIS_TABLET()) {
            return false;
        }
        if (((Boolean)this.kidSpaceShow.getValue()).booleanValue() && CommonUtils.INSTANCE.getIS_TABLET() && (n == null || n != 0)) {
            return true;
        }
        boolean bl3 = ((Boolean)this.tempHidden.getValue()).booleanValue() || !((Boolean)this.statusBarViewShowing.getValue()).booleanValue();
        boolean bl4 = n == null || n != 0;
        bl4 = !((Boolean)this.externalRepository.isDeviceInteractive().getValue()).booleanValue() || ((Boolean)this.bouncerShowing.getValue()).booleanValue() || bl4 && (!CommonUtils.INSTANCE.getIS_TABLET() || ((Boolean)this.notificationPanelSwipeToAppearance.getValue()).booleanValue() || ((Boolean)this.controlCenterPanelSwipeToAppearance.getValue()).booleanValue()) || CommonUtils.INSTANCE.getIS_TABLET() && this.isSplitScreenMode() && bl4;
        if (!bl3) return false;
        if (!bl4) return false;
        bl = bl2;
        if ((Boolean)this.screenPinning.getValue() == false) return bl;
        bl = bl2;
        if (this.screenLockedChange) return bl;
        if (!this.isShowOnceIsland) return false;
        return bl2;
    }

    public final boolean isTinyScreen() {
        return this.isTinyScreen;
    }

    public final boolean isToScreenLockNoAnimation() {
        boolean bl = this.isAodOn;
        boolean bl2 = false;
        boolean bl3 = bl && this.isFullAodOn;
        boolean bl4 = (Boolean)this.screenLocked.getValue() != false && this.screenLockedChange && !bl3;
        bl3 = !this.isDeviceInteractive && !bl3;
        if (bl4 || bl3) {
            bl2 = true;
        }
        return bl2;
    }

    public final void setAodOn(boolean bl) {
        this.isAodOn = bl;
    }

    public final void setBouncerShowing(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.bouncerShowing = u2;
    }

    public final void setConfigChange(Boolean bl) {
        this.configChange = bl;
    }

    public final void setControlCenterExpanded(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.controlCenterExpanded = u2;
    }

    public final void setControlCenterPanelHeightChanging(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.controlCenterPanelHeightChanging = u2;
    }

    public final void setControlCenterPanelSwipeToAppearance(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.controlCenterPanelSwipeToAppearance = u2;
    }

    public final void setDeskTopAnimating(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.deskTopAnimating = u2;
    }

    public final void setDeviceInteractive(boolean bl) {
        this.isDeviceInteractive = bl;
    }

    public final void setExpanded(boolean bl) {
        this.expanded = bl;
    }

    public final void setFullAodOn(boolean bl) {
        this.isFullAodOn = bl;
    }

    public final void setKeyguardShowing(boolean bl) {
        this.keyguardShowing = bl;
    }

    public final void setKidSpaceShow(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.kidSpaceShow = u2;
    }

    public final void setLastTinyScreenStatus(boolean bl) {
        this.lastTinyScreenStatus = bl;
    }

    public final void setMiPlayShow(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.miPlayShow = u2;
    }

    public final void setNotificationAppearance(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.notificationAppearance = u2;
    }

    public final void setNotificationPanelHeightChanging(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.notificationPanelHeightChanging = u2;
    }

    public final void setNotificationPanelSwipeToAppearance(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.notificationPanelSwipeToAppearance = u2;
    }

    public final void setNotificationVisible(boolean bl) {
        this.notificationVisible = bl;
    }

    public final void setScreenLocked(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.screenLocked = u2;
    }

    public final void setScreenLockedChange(boolean bl) {
        this.screenLockedChange = bl;
    }

    public final void setScreenPinning(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.screenPinning = u2;
    }

    public final void setShowNotificationIcons(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.showNotificationIcons = u2;
    }

    public final void setShowOnceIsland(boolean bl) {
        this.isShowOnceIsland = bl;
    }

    public final void setStatusBarDisappearance(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.statusBarDisappearance = u2;
    }

    public final void setStatusBarViewShowing(u u2) {
        o.g((Object)u2, (String)"<set-?>");
        this.statusBarViewShowing = u2;
    }

    public final void setTempHiddenChange(Boolean bl) {
        this.tempHiddenChange = bl;
    }

    public final void setTempHiddenType(TempHiddenType tempHiddenType) {
        if (this.tempHiddenType != tempHiddenType) {
            this.tempHiddenType = tempHiddenType;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setTempHiddenType tempHiddenType=");
            stringBuilder.append((Object)tempHiddenType);
            Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
        }
    }

    public final void setTinyScreen(boolean bl) {
        this.isTinyScreen = bl;
    }

    public final void setTopActivityPkg(String string) {
        this.topActivityPkg = string;
    }

    public final void updateShowOnceIslandState(DynamicIslandContentView dynamicIslandContentView) {
        boolean bl = dynamicIslandContentView != null;
        this.isShowOnceIsland = bl;
    }
}
