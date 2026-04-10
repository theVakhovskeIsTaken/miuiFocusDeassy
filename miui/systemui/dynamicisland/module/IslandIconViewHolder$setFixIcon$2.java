/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  K0.g
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.graphics.drawable.Drawable
 *  androidx.core.graphics.drawable.DrawableKt
 *  f1.E
 *  f1.b0
 *  f1.f
 *  miui.systemui.coroutines.Dispatchers
 */
package miui.systemui.dynamicisland.module;

import G0.k;
import G0.s;
import K0.d;
import K0.g;
import L0.c;
import M0.l;
import U0.o;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableKt;
import f1.E;
import f1.b0;
import f1.f;
import miui.systemui.coroutines.Dispatchers;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;

@M0.f(c="miui.systemui.dynamicisland.module.IslandIconViewHolder$setFixIcon$2", f="IslandIconViewHolder.kt", l={254}, m="invokeSuspend")
public static final class IslandIconViewHolder.setFixIcon.2
extends l
implements o {
    final Drawable $drawable;
    int label;
    final IslandIconViewHolder this$0;

    public IslandIconViewHolder.setFixIcon.2(IslandIconViewHolder islandIconViewHolder, Drawable drawable, d d2) {
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Object invokeSuspend(Object object) {
        Object object2 = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            k.b((Object)object);
            return s.a;
        } else {
            k.b((Object)object);
            b0 b02 = Dispatchers.INSTANCE.getIO();
            o o2 = new o(this.this$0, this.$drawable, null){
                final Drawable $drawable;
                int label;
                final IslandIconViewHolder this$0;
                {
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
                        IslandIconViewHolder.access$setLottieColor(this.this$0, DrawableKt.toBitmap$default((Drawable)this.$drawable, (int)0, (int)0, null, (int)7, null));
                        return s.a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            };
            this.label = 1;
            if (f.c((g)b02, (o)o2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
