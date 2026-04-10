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
 *  U0.a
 *  U0.o
 *  android.content.res.Configuration
 *  h1.o
 *  h1.q
 *  kotlin.jvm.internal.o
 *  miui.systemui.autodensity.AutoDensityController$OnDensityChangeListener
 */
package miui.systemui.dynamicisland.touch.data.repository;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.a;
import android.content.res.Configuration;
import h1.q;
import kotlin.jvm.internal.o;
import miui.systemui.autodensity.AutoDensityController;
import miui.systemui.dynamicisland.touch.data.repository.DynamicIslandTouchConstantsRepository;

@f(c="miui.systemui.dynamicisland.touch.data.repository.DynamicIslandTouchConstantsRepository$densityChanged$1", f="DynamicIslandTouchConstantsRepository.kt", l={33, 35}, m="invokeSuspend")
public static final class DynamicIslandTouchConstantsRepository.densityChanged.1
extends l
implements U0.o {
    private Object L$0;
    Object L$1;
    int label;
    final DynamicIslandTouchConstantsRepository this$0;

    public DynamicIslandTouchConstantsRepository.densityChanged.1(DynamicIslandTouchConstantsRepository dynamicIslandTouchConstantsRepository, d d2) {
        this.this$0 = dynamicIslandTouchConstantsRepository;
        super(2, d2);
    }

    public final d create(Object object, d object2) {
        object2 = new /* invalid duplicate definition of identical inner class */;
        object2.L$0 = object;
        return object2;
    }

    public final Object invoke(q q2, d d2) {
        return (this.create(q2, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        block5: {
            listener.1 var3_4;
            Object object2;
            block6: {
                block2: {
                    block3: {
                        block4: {
                            object2 = c.c();
                            int n = this.label;
                            if (n == 0) break block2;
                            if (n == 1) break block3;
                            if (n != 2) break block4;
                            k.b((Object)object);
                            break block5;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    var3_4 = this.L$1;
                    q q2 = (q)this.L$0;
                    k.b((Object)object);
                    object = q2;
                    break block6;
                }
                k.b((Object)object);
                object = (q)this.L$0;
                var3_4 = new AutoDensityController.OnDensityChangeListener((q)object){
                    final q $$this$conflatedCallbackFlow;
                    {
                        this.$$this$conflatedCallbackFlow = q2;
                    }

                    public void onConfigChanged(Configuration configuration) {
                        o.g((Object)configuration, (String)"config");
                        this.$$this$conflatedCallbackFlow.i((Object)s.a);
                    }
                };
                s s2 = s.a;
                this.L$0 = object;
                this.L$1 = var3_4;
                this.label = 1;
                if (object.j((Object)s2, (d)this) == object2) {
                    return object2;
                }
            }
            this.this$0.autoDensityController.addOnDensityChangeListener((AutoDensityController.OnDensityChangeListener)var3_4);
            var3_4 = new a(this.this$0, var3_4){
                final listener.1 $listener;
                final DynamicIslandTouchConstantsRepository this$0;
                {
                    this.this$0 = dynamicIslandTouchConstantsRepository;
                    this.$listener = var2_2;
                    super(0);
                }

                public final void invoke() {
                    DynamicIslandTouchConstantsRepository.access$getAutoDensityController$p(this.this$0).removeOnDensityChangeListener((AutoDensityController.OnDensityChangeListener)this.$listener);
                }
            };
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (h1.o.a((q)object, (a)var3_4, (d)this) == object2) {
                return object2;
            }
        }
        return s.a;
    }
}
