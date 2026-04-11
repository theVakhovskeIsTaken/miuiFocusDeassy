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
 *  f1.E
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.notification.focus.moduleV3;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import f1.E;
import miui.systemui.notification.focus.moduleV3.ModuleAnimationTextViewHolder;
import miui.systemui.util.CommonUtils;

@f(c="miui.systemui.notification.focus.moduleV3.ModuleAnimationTextViewHolder$fullAodStatusChanged$1", f="ModuleAnimationTextViewHolder.kt", l={}, m="invokeSuspend")
public static final class ModuleAnimationTextViewHolder.fullAodStatusChanged.1
extends l
implements o {
    final boolean $fullAodStatus;
    int label;
    final ModuleAnimationTextViewHolder this$0;

    public ModuleAnimationTextViewHolder.fullAodStatusChanged.1(ModuleAnimationTextViewHolder moduleAnimationTextViewHolder, boolean bl, d d2) {
        this.this$0 = moduleAnimationTextViewHolder;
        this.$fullAodStatus = bl;
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
            if (this.this$0.focusAnimation != null && !CommonUtils.NOT_SUPPORT_LOTTIE) {
                if (this.$fullAodStatus) {
                    object = this.this$0.focusAnimation;
                    if (object != null) {
                        object.setProgress(1.0f);
                    }
                    object = this.this$0.focusAnimation;
                    if (object != null) {
                        object.pauseAnimation();
                    }
                } else if (this.this$0.isAutoPlay && (object = this.this$0.focusAnimation) != null) {
                    object.resumeAnimation();
                }
                return s.a;
            }
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
