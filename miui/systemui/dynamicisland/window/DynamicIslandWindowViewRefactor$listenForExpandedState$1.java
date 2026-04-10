/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.d
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.util.Log
 *  f1.E
 *  i1.f
 *  i1.g
 *  kotlin.jvm.internal.o
 *  miui.systemui.Prefs
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.l;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import f1.E;
import i1.f;
import i1.g;
import kotlin.jvm.internal.o;
import miui.systemui.Prefs;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewRefactor;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewRefactor$listenForExpandedState$1$invokeSuspend$;

@M0.f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewRefactor$listenForExpandedState$1", f="DynamicIslandWindowViewRefactor.kt", l={57}, m="invokeSuspend")
public static final class DynamicIslandWindowViewRefactor.listenForExpandedState.1
extends l
implements U0.o {
    int label;
    final DynamicIslandWindowViewRefactor this$0;

    public DynamicIslandWindowViewRefactor.listenForExpandedState.1(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor, d d2) {
        this.this$0 = dynamicIslandWindowViewRefactor;
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
            object = new f((f)this.this$0.eventCoordinator.getExpandedState()){
                final f $this_unsafeTransform$inlined;
                {
                    this.$this_unsafeTransform$inlined = f2;
                }

                public Object collect(g object, d d2) {
                    if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object){
                        final g $this_unsafeFlow;
                        {
                            this.$this_unsafeFlow = g2;
                        }

                        /*
                         * Unable to fully structure code
                         * Could not resolve type clashes
                         */
                        public final Object emit(Object var1_1, d var2_2) {
                            if (!(var2_2 /* !! */  instanceof invokeSuspend$$inlined$mapNotNull$1$2$1)) ** GOTO lbl-1000
                            var4_3 /* !! */  = var2_2 /* !! */ ;
                            var3_4 = var4_3 /* !! */ .label;
                            if ((var3_4 & -2147483648) != 0) {
                                var4_3 /* !! */ .label = var3_4 + -2147483648;
                                var2_2 /* !! */  = var4_3 /* !! */ ;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var2_2 /* !! */  = new M0.d(this, var2_2 /* !! */ ){
                                    Object L$0;
                                    int label;
                                    Object result;
                                    final invokeSuspend$$inlined$mapNotNull$1$2 this$0;
                                    {
                                        this.this$0 = var1_1;
                                        super(d2);
                                    }

                                    public final Object invokeSuspend(Object object) {
                                        this.result = object;
                                        this.label |= Integer.MIN_VALUE;
                                        return this.this$0.emit(null, (d)this);
                                    }
                                };
                            }
                            var5_5 = var2_2 /* !! */ .result;
                            var4_3 /* !! */  = c.c();
                            var3_4 = var2_2 /* !! */ .label;
                            if (var3_4 == 0) ** GOTO lbl17
                            if (var3_4 == 1) {
                                k.b((Object)var5_5);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl17:
                                // 1 sources

                                k.b((Object)var5_5);
                                var5_5 = this.$this_unsafeFlow;
                                var1_1 = (Boolean)var1_1;
                                if (var1_1 != null) {
                                    var2_2 /* !! */ .label = 1;
                                    if (var5_5.emit(var1_1, var2_2 /* !! */ ) == var4_3 /* !! */ ) {
                                        return var4_3 /* !! */ ;
                                    }
                                }
                            }
                            return s.a;
                        }
                    }, d2)) == c.c()) {
                        return object;
                    }
                    return s.a;
                }
            };
            g g2 = new g(this.this$0){
                final DynamicIslandWindowViewRefactor this$0;
                {
                    this.this$0 = dynamicIslandWindowViewRefactor;
                }

                public final Object emit(boolean bl, d object) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("expandedState ");
                    ((StringBuilder)object).append(bl);
                    Log.e((String)"DynamicIslandWindowViewRefactor", (String)((StringBuilder)object).toString());
                    object = new Intent("com.miui.action.ACTION_EXPANDED_STATE_CHANGED");
                    object.putExtra("islandExpanded", bl);
                    SharedPreferences sharedPreferences = Prefs.getNotif((Context)DynamicIslandWindowViewRefactor.access$getSysUIContext$p(this.this$0));
                    o.f((Object)sharedPreferences, (String)"getNotif(...)");
                    sharedPreferences = sharedPreferences.edit();
                    sharedPreferences.putBoolean("islandExpanded", bl);
                    sharedPreferences.apply();
                    DynamicIslandWindowViewRefactor.access$getContext$p(this.this$0).sendBroadcast((Intent)object);
                    return s.a;
                }
            };
            this.label = 1;
            if (object.collect(g2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
