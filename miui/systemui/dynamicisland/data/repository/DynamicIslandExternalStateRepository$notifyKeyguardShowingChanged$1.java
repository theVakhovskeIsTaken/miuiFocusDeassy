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
 *  U0.o
 *  f1.E
 */
package miui.systemui.dynamicisland.data.repository;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import U0.o;
import f1.E;
import miui.systemui.dynamicisland.data.repository.DynamicIslandExternalStateRepository;

@f(c="miui.systemui.dynamicisland.data.repository.DynamicIslandExternalStateRepository$notifyKeyguardShowingChanged$1", f="DynamicIslandExternalStateRepository.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandExternalStateRepository.notifyKeyguardShowingChanged.1
extends l
implements o {
    final boolean $showing;
    int label;
    final DynamicIslandExternalStateRepository this$0;

    public DynamicIslandExternalStateRepository.notifyKeyguardShowingChanged.1(DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository, boolean bl, d d2) {
        this.this$0 = dynamicIslandExternalStateRepository;
        this.$showing = bl;
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
            this.this$0._isKeyguardShowing.setValue((Object)b.a((boolean)this.$showing));
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
