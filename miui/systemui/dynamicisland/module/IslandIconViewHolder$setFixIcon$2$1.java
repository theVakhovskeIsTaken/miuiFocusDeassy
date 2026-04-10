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
 *  android.graphics.drawable.Drawable
 *  androidx.core.graphics.drawable.DrawableKt
 *  f1.E
 */
package miui.systemui.dynamicisland.module;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableKt;
import f1.E;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;

@f(c="miui.systemui.dynamicisland.module.IslandIconViewHolder$setFixIcon$2$1", f="IslandIconViewHolder.kt", l={}, m="invokeSuspend")
public static final class IslandIconViewHolder.setFixIcon.1
extends l
implements o {
    final Drawable $drawable;
    int label;
    final IslandIconViewHolder this$0;

    public IslandIconViewHolder.setFixIcon.1(IslandIconViewHolder islandIconViewHolder, Drawable drawable, d d2) {
        this.this$0 = islandIconViewHolder;
        this.$drawable = drawable;
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
            this.this$0.setLottieColor(DrawableKt.toBitmap$default((Drawable)this.$drawable, (int)0, (int)0, null, (int)7, null));
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
