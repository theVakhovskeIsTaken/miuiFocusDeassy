/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.i
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  f1.E
 */
package miui.systemui.dynamicisland.data.repository;

import G0.i;
import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import f1.E;
import miui.systemui.dynamicisland.data.repository.DynamicIslandExternalStateRepository;

@f(c="miui.systemui.dynamicisland.data.repository.DynamicIslandExternalStateRepository$notifyCommandQueueDisableChanged$1", f="DynamicIslandExternalStateRepository.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandExternalStateRepository.notifyCommandQueueDisableChanged.1
extends l
implements o {
    final i $disable;
    int label;
    final DynamicIslandExternalStateRepository this$0;

    public DynamicIslandExternalStateRepository.notifyCommandQueueDisableChanged.1(DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository, i i2, d d2) {
        this.this$0 = dynamicIslandExternalStateRepository;
        this.$disable = i2;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label == 0) {
            k.b((Object)object);
            this.this$0._commandQueueDisable.setValue((Object)this.$disable);
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
