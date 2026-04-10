/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.util.Log
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  f1.E
 *  kotlin.jvm.internal.o
 *  o1.a
 *  o1.c
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import M0.f;
import M0.l;
import android.util.Log;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import f1.E;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import o1.a;
import o1.c;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView$addDynamicIslandData$1", f="DynamicIslandWindowView.kt", l={1714, 725}, m="invokeSuspend")
public static final class DynamicIslandWindowView.addDynamicIslandData.1
extends l
implements U0.o {
    final boolean $addToHistoryList;
    final float $cutoutY;
    final DynamicIslandData $dynamicIslandData;
    final boolean $expanded;
    final float $maxWidth;
    float F$0;
    float F$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    boolean Z$1;
    int label;
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.addDynamicIslandData.1(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandData dynamicIslandData, boolean bl, float f2, float f3, boolean bl2, d d2) {
        this.this$0 = dynamicIslandWindowView;
        this.$dynamicIslandData = dynamicIslandData;
        this.$expanded = bl;
        this.$maxWidth = f2;
        this.$cutoutY = f3;
        this.$addToHistoryList = bl2;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object invokeSuspend(Object var1_1) {
        block21: {
            block22: {
                block19: {
                    block20: {
                        var13_5 = L0.c.c();
                        var5_6 = this.label;
                        if (var5_6 != 0) {
                            if (var5_6 != 1) {
                                if (var5_6 != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                var10_7 /* !! */  = (a)this.L$1;
                                var11_9 /* !! */  = (a)this.L$0;
                                var9_10 = var10_7 /* !! */ ;
                                var8_13 /* !! */  = var11_9 /* !! */ ;
                                k.b((Object)var1_1);
                                var1_1 = var11_9 /* !! */ ;
                                break block19;
                            }
                            var7_14 = this.Z$1;
                            var2_15 = this.F$1;
                            var3_17 = this.F$0;
                            var6_18 = this.Z$0;
                            var10_7 /* !! */  = (DynamicIslandData)this.L$3;
                            var11_9 /* !! */  = (DynamicIslandWindowView)this.L$2;
                            var12_19 = (a)this.L$1;
                            var9_10 = (a)this.L$0;
                            var8_13 /* !! */  = var9_10;
                            k.b((Object)var1_1);
                            var8_13 /* !! */  = var12_19;
                            var1_1 = var9_10;
                            var9_10 = var11_9 /* !! */ ;
                            var4_20 = var2_15;
                            break block20;
                        }
                        k.b((Object)var1_1);
                        var10_7 /* !! */  = DynamicIslandWindowView.access$getKeyLocks$p(this.this$0);
                        var9_10 = this.$dynamicIslandData.getKey();
                        var8_13 /* !! */  = var10_7 /* !! */ .get(var9_10);
                        var1_1 = var8_13 /* !! */ ;
                        if (var8_13 /* !! */  == null && (var8_13 /* !! */  = var10_7 /* !! */ .putIfAbsent(var9_10, var1_1 = c.b((boolean)false, (int)1, null))) != null) {
                            var1_1 = var8_13 /* !! */ ;
                        }
                        var1_1 = (a)var1_1;
                        var8_13 /* !! */  = var1_1;
                        try {
                            o.d((Object)var1_1);
                            var8_13 /* !! */  = var1_1;
                            var9_10 = this.this$0;
                            var8_13 /* !! */  = var1_1;
                            var10_7 /* !! */  = this.$dynamicIslandData;
                            var8_13 /* !! */  = var1_1;
                            var6_18 = this.$expanded;
                            var8_13 /* !! */  = var1_1;
                            var2_16 = this.$maxWidth;
                            var8_13 /* !! */  = var1_1;
                            var4_20 = this.$cutoutY;
                            var8_13 /* !! */  = var1_1;
                            var7_14 = this.$addToHistoryList;
                            var8_13 /* !! */  = var1_1;
                            this.L$0 = var1_1;
                            var8_13 /* !! */  = var1_1;
                            this.L$1 = var1_1;
                            var8_13 /* !! */  = var1_1;
                            this.L$2 = var9_10;
                            var8_13 /* !! */  = var1_1;
                            this.L$3 = var10_7 /* !! */ ;
                            var8_13 /* !! */  = var1_1;
                            this.Z$0 = var6_18;
                            var8_13 /* !! */  = var1_1;
                            this.F$0 = var2_16;
                            var8_13 /* !! */  = var1_1;
                            this.F$1 = var4_20;
                            var8_13 /* !! */  = var1_1;
                            this.Z$1 = var7_14;
                            var8_13 /* !! */  = var1_1;
                            this.label = 1;
                            var8_13 /* !! */  = var1_1;
                            var11_9 /* !! */  = var1_1.a(null, (d)this);
                            if (var11_9 /* !! */  == var13_5) {
                                return var13_5;
                            }
                        }
                        catch (Throwable var1_2) {
                            break block21;
                        }
                        var8_13 /* !! */  = var1_1;
                        var3_17 = var2_16;
                    }
                    this.L$0 = var1_1;
                    this.L$1 = var8_13 /* !! */ ;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 2;
                    var9_10 = DynamicIslandWindowView.addDynamicIslandDataSuspend$default((DynamicIslandWindowView)var9_10, (DynamicIslandData)var10_7 /* !! */ , var6_18, var3_17, var4_20, var7_14, false, (d)this, 32, null);
                    if (var9_10 == var13_5) {
                        return var13_5;
                    }
                    var10_7 /* !! */  = var8_13 /* !! */ ;
                }
                var9_10 = var10_7 /* !! */ ;
                var8_13 /* !! */  = var1_1;
                try {
                    var11_9 /* !! */  = s.a;
                    var8_13 /* !! */  = var1_1;
                }
                catch (Throwable var10_8) {
                    var1_1 = var8_13 /* !! */ ;
                    break block22;
                }
                try {
                    var10_7 /* !! */ .c(null);
                }
                catch (Throwable var1_3) {}
                var8_13 /* !! */  = this.$dynamicIslandData.getKey();
                var9_10 = new StringBuilder();
                var9_10.append("addDynamicIslandData end ");
                var9_10.append((String)var8_13 /* !! */ );
                Log.d((String)"DynamicIslandWindowViewImpl", (String)var9_10.toString());
                var8_13 /* !! */  = this.this$0;
                var9_10 = this.$dynamicIslandData.getKey();
                o.d((Object)var1_1);
                DynamicIslandWindowView.access$releaseMutexIfIdle(var8_13 /* !! */ , (String)var9_10, (a)var1_1);
                return s.a;
                catch (Throwable var9_11) {}
                ** GOTO lbl-1000
                catch (Throwable var9_12) {}
lbl-1000:
                // 2 sources

                {
                    var10_7 /* !! */  = var9_10;
                    var9_10 = var8_13 /* !! */ ;
                }
            }
            var8_13 /* !! */  = var1_1;
            var9_10.c(null);
            var8_13 /* !! */  = var1_1;
            throw var10_7 /* !! */ ;
        }
        var10_7 /* !! */  = this.$dynamicIslandData.getKey();
        var9_10 = new StringBuilder();
        var9_10.append("addDynamicIslandData end ");
        var9_10.append((String)var10_7 /* !! */ );
        Log.d((String)"DynamicIslandWindowViewImpl", (String)var9_10.toString());
        var9_10 = this.this$0;
        var10_7 /* !! */  = this.$dynamicIslandData.getKey();
        o.d(var8_13 /* !! */ );
        DynamicIslandWindowView.access$releaseMutexIfIdle((DynamicIslandWindowView)var9_10, (String)var10_7 /* !! */ , var8_13 /* !! */ );
        throw var1_4;
    }
}
