/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.b
 *  G0.k
 *  G0.s
 *  H0.m
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.f
 *  M0.l
 *  U0.o
 *  U0.p
 *  U0.s
 *  android.view.View
 *  f1.E
 *  i1.f
 *  i1.g
 *  i1.h
 *  kotlin.jvm.internal.j
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.content;

import G0.k;
import G0.s;
import H0.m;
import K0.d;
import L0.c;
import M0.b;
import M0.l;
import U0.p;
import android.view.View;
import f1.E;
import i1.f;
import i1.g;
import i1.h;
import java.util.ArrayList;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;

@M0.f(c="miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController$1", f="DynamicIslandBaseContentViewController.kt", l={85}, m="invokeSuspend")
public static final class DynamicIslandBaseContentViewController.1
extends l
implements p {
    int label;
    final DynamicIslandBaseContentViewController<T> this$0;

    public DynamicIslandBaseContentViewController.1(DynamicIslandBaseContentViewController<? extends T> dynamicIslandBaseContentViewController, d d2) {
        this.this$0 = dynamicIslandBaseContentViewController;
        super(3, d2);
    }

    public final Object invoke(E e, View view, d d2) {
        return new /* invalid duplicate definition of identical inner class */.invokeSuspend(s.a);
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
            object = h.l((f)((DynamicIslandBaseContentView)((Object)this.this$0.getView())).getViewModel().getStateName(), (f)((DynamicIslandBaseContentView)((Object)this.this$0.getView())).getHighlightColor(), (f)this.this$0.regionSamplingInteractor.isRegionDark(), (f)((DynamicIslandBaseContentView)((Object)this.this$0.getView())).getIslandAppAnimRunning(), (f)((DynamicIslandBaseContentView)((Object)this.this$0.getView())).getIslandFreeformAnimRunning(), (U0.s)new U0.s(null){
                Object L$0;
                Object L$1;
                boolean Z$0;
                boolean Z$1;
                boolean Z$2;
                int label;

                public final Object invoke(String string, String string2, boolean bl, boolean bl2, boolean bl3, d object) {
                    object = new /* invalid duplicate definition of identical inner class */;
                    object.L$0 = string;
                    object.L$1 = string2;
                    object.Z$0 = bl;
                    object.Z$1 = bl2;
                    object.Z$2 = bl3;
                    return object.invokeSuspend(s.a);
                }

                public final Object invokeSuspend(Object object) {
                    c.c();
                    if (this.label == 0) {
                        k.b((Object)object);
                        object = (String)this.L$0;
                        String string = (String)this.L$1;
                        boolean bl = this.Z$0;
                        boolean bl2 = this.Z$1;
                        boolean bl3 = this.Z$2;
                        return m.f((Object[])new Object[]{object, string, b.a((boolean)(bl ^ true)), b.a((boolean)bl2), b.a((boolean)bl3)});
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            });
            g g2 = new g(new U0.o(this.this$0, null){
                Object L$0;
                int label;
                final DynamicIslandBaseContentViewController<T> this$0;
                {
                    this.this$0 = dynamicIslandBaseContentViewController;
                    super(2, d2);
                }

                public final d create(Object object, d object2) {
                    object2 = new /* invalid duplicate definition of identical inner class */;
                    object2.L$0 = object;
                    return object2;
                }

                public final Object invoke(ArrayList<? extends Object> arrayList, d d2) {
                    return (this.create(arrayList, d2)).invokeSuspend(s.a);
                }

                public final Object invokeSuspend(Object object) {
                    c.c();
                    if (this.label == 0) {
                        k.b((Object)object);
                        ArrayList<E> arrayList = (ArrayList)this.L$0;
                        boolean bl = true;
                        if (arrayList.get(1) != null) {
                            object = arrayList.get(1);
                            o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                            object = (String)object;
                        } else {
                            object = "";
                        }
                        E e = arrayList.get(2);
                        o.e(e, (String)"null cannot be cast to non-null type kotlin.Boolean");
                        boolean bl2 = (Boolean)e;
                        e = arrayList.get(3);
                        o.e(e, (String)"null cannot be cast to non-null type kotlin.Boolean");
                        boolean bl3 = bl;
                        if (!((Boolean)e).booleanValue()) {
                            arrayList = arrayList.get(4);
                            o.e((Object)arrayList, (String)"null cannot be cast to non-null type kotlin.Boolean");
                            bl3 = (Boolean)((Object)arrayList) != false ? bl : false;
                        }
                        ((DynamicIslandBaseContentView)((Object)this.this$0.getView())).updateDarkLightMode(((DynamicIslandBaseContentView)((Object)this.this$0.getView())).getState(), (String)object, bl2, bl3);
                        return s.a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }){
                private final U0.o function;
                {
                    o.g((Object)o2, (String)"function");
                    this.function = o2;
                }

                public final /* synthetic */ Object emit(Object object, d d2) {
                    return this.function.invoke(object, (Object)d2);
                }

                public final boolean equals(Object object) {
                    boolean bl;
                    boolean bl2 = object instanceof g;
                    boolean bl3 = bl = false;
                    if (bl2) {
                        bl3 = bl;
                        if (object instanceof j) {
                            bl3 = o.c((Object)this.getFunctionDelegate(), (Object)((j)object).getFunctionDelegate());
                        }
                    }
                    return bl3;
                }

                public final G0.b getFunctionDelegate() {
                    return this.function;
                }

                public final int hashCode() {
                    return this.getFunctionDelegate().hashCode();
                }
            };
            this.label = 1;
            if (object.collect(g2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
