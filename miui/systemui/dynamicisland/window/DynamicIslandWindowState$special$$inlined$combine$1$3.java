/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.f
 *  M0.l
 *  U0.p
 *  android.util.Log
 *  i1.g
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import U0.p;
import android.util.Log;
import i1.g;
import miui.systemui.util.CommonUtils;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowState$special$$inlined$combine$1$3", f="DynamicIslandWindowState.kt", l={234}, m="invokeSuspend")
public static final class DynamicIslandWindowState$special$.inlined.combine.3
extends l
implements p {
    private Object L$0;
    Object L$1;
    int label;

    public DynamicIslandWindowState$special$.inlined.combine.3(d d2) {
    }

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
}
