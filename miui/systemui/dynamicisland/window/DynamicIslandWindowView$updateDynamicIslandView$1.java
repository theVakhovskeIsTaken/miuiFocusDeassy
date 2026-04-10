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

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView$updateDynamicIslandView$1", f="DynamicIslandWindowView.kt", l={1714, 892}, m="invokeSuspend")
public static final class DynamicIslandWindowView.updateDynamicIslandView.1
extends l
implements U0.o {
    final DynamicIslandData $dynamicIslandData;
    final boolean $expanded;
    final float $maxWidth;
    final boolean $reInflated;
    float F$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    boolean Z$1;
    int label;
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.updateDynamicIslandView.1(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandData dynamicIslandData, boolean bl, float f2, boolean bl2, d d2) {
        this.this$0 = dynamicIslandWindowView;
        this.$dynamicIslandData = dynamicIslandData;
        this.$expanded = bl;
        this.$maxWidth = f2;
        this.$reInflated = bl2;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object invokeSuspend(Object object) {
        void var1_4;
        Object object2;
        Object object3;
        Object object4;
        block19: {
            Object object5;
            block20: {
                block17: {
                    boolean bl;
                    float f2;
                    boolean bl2;
                    Object object6;
                    block18: {
                        object6 = L0.c.c();
                        int n = this.label;
                        if (n != 0) {
                            if (n != 1) {
                                if (n != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                object4 = (a)this.L$1;
                                object5 = (a)this.L$0;
                                object3 = object4;
                                object2 = object5;
                                k.b((Object)object);
                                object = object5;
                                break block17;
                            }
                            bl2 = this.Z$1;
                            f2 = this.F$0;
                            bl = this.Z$0;
                            object4 = (DynamicIslandData)this.L$3;
                            object5 = (DynamicIslandWindowView)((Object)this.L$2);
                            a a2 = (a)this.L$1;
                            object3 = (a)this.L$0;
                            object2 = object3;
                            k.b((Object)object);
                            object = object3;
                            object2 = a2;
                            object3 = object5;
                            break block18;
                        }
                        k.b((Object)object);
                        object4 = this.this$0.keyLocks;
                        object3 = this.$dynamicIslandData.getKey();
                        object2 = object4.get(object3);
                        object = object2;
                        if (object2 == null && (object2 = object4.putIfAbsent(object3, object = c.b((boolean)false, (int)1, null))) != null) {
                            object = object2;
                        }
                        object3 = (a)object;
                        object2 = object3;
                        try {
                            o.d((Object)object3);
                            object2 = object3;
                            object5 = this.this$0;
                            object2 = object3;
                            object4 = this.$dynamicIslandData;
                            object2 = object3;
                            bl = this.$expanded;
                            object2 = object3;
                            f2 = this.$maxWidth;
                            object2 = object3;
                            bl2 = this.$reInflated;
                            object2 = object3;
                            this.L$0 = object3;
                            object2 = object3;
                            this.L$1 = object3;
                            object2 = object3;
                            this.L$2 = object5;
                            object2 = object3;
                            this.L$3 = object4;
                            object2 = object3;
                            this.Z$0 = bl;
                            object2 = object3;
                            this.F$0 = f2;
                            object2 = object3;
                            this.Z$1 = bl2;
                            object2 = object3;
                            this.label = 1;
                            object2 = object3;
                            object = object3.a(null, (d)this);
                            if (object == object6) {
                                return object6;
                            }
                        }
                        catch (Throwable throwable) {
                            break block19;
                        }
                        object = object3;
                        object2 = object3;
                        object3 = object5;
                    }
                    this.L$0 = object;
                    this.L$1 = object2;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 2;
                    object3 = ((DynamicIslandWindowView)((Object)object3)).updateDynamicIslandViewSuspend((DynamicIslandData)object4, bl, f2, false, bl2, (d)this);
                    if (object3 == object6) {
                        return object6;
                    }
                    object4 = object2;
                }
                object3 = object4;
                object2 = object;
                try {
                    object5 = s.a;
                    object2 = object;
                }
                catch (Throwable throwable) {
                    object4 = object3;
                    object = object2;
                    break block20;
                }
                try {
                    object4.c(null);
                }
                catch (Throwable throwable) {}
                object2 = this.$dynamicIslandData.getKey();
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("updateDynamicIslandView end ");
                ((StringBuilder)object3).append((String)object2);
                Log.e((String)"DynamicIslandWindowViewImpl", (String)((StringBuilder)object3).toString());
                object2 = this.this$0;
                object3 = this.$dynamicIslandData.getKey();
                o.d((Object)object);
                ((DynamicIslandWindowView)object2).releaseMutexIfIdle((String)object3, (a)object);
                return s.a;
                catch (Throwable throwable) {
                    object4 = object2;
                    object5 = throwable;
                }
            }
            object2 = object;
            object4.c(null);
            object2 = object;
            throw object5;
        }
        object4 = this.$dynamicIslandData.getKey();
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("updateDynamicIslandView end ");
        ((StringBuilder)object3).append((String)object4);
        Log.e((String)"DynamicIslandWindowViewImpl", (String)((StringBuilder)object3).toString());
        object3 = this.this$0;
        object4 = this.$dynamicIslandData.getKey();
        o.d(object2);
        ((DynamicIslandWindowView)((Object)object3)).releaseMutexIfIdle((String)object4, object2);
        throw var1_4;
    }
}
