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
 *  com.airbnb.lottie.LottieAnimationView
 *  f1.E
 *  miui.systemui.util.LottieResUtils
 */
package miui.systemui.notification.focus.moduleV3;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import com.airbnb.lottie.LottieAnimationView;
import f1.E;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandAnimationTextViewHolder;
import miui.systemui.util.LottieResUtils;

@f(c="miui.systemui.notification.focus.moduleV3.ModuleDecoLandAnimationTextViewHolder$onDetach$1", f="ModuleDecoLandAnimationTextViewHolder.kt", l={}, m="invokeSuspend")
public static final class ModuleDecoLandAnimationTextViewHolder.onDetach.1
extends l
implements o {
    int label;
    final ModuleDecoLandAnimationTextViewHolder this$0;

    public ModuleDecoLandAnimationTextViewHolder.onDetach.1(ModuleDecoLandAnimationTextViewHolder moduleDecoLandAnimationTextViewHolder, d d2) {
        this.this$0 = moduleDecoLandAnimationTextViewHolder;
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
            LottieResUtils.cancelLottieAnimate$default((LottieResUtils)LottieResUtils.INSTANCE, (LottieAnimationView)this.this$0.focusAnimation, (boolean)false, (int)2, null);
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
