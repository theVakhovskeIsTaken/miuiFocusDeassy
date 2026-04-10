/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  H0.n
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.f
 *  M0.l
 *  U0.a
 *  U0.p
 *  i1.f
 *  i1.g
 *  i1.h
 *  j1.k
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.k;
import G0.s;
import H0.n;
import K0.d;
import L0.c;
import M0.b;
import M0.l;
import U0.a;
import U0.p;
import i1.f;
import i1.g;
import i1.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@M0.f(c="miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowStateInteractor$special$$inlined$flatMapLatest$1", f="DynamicIslandWindowStateInteractor.kt", l={189}, m="invokeSuspend")
public static final class DynamicIslandWindowStateInteractor$special$.inlined.flatMapLatest.1
extends l
implements p {
    private Object L$0;
    Object L$1;
    int label;

    public DynamicIslandWindowStateInteractor$special$.inlined.flatMapLatest.1(d d2) {
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final Object invoke(g g2, Object object, d object2) {
        object2 = new /* invalid duplicate definition of identical inner class */;
        object2.L$0 = g2;
        object2.L$1 = object;
        return object2.invokeSuspend(s.a);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Object invokeSuspend(Object object) {
        Object object2 = c.c();
        int n2 = this.label;
        if (n2 != 0) {
            if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            k.b((Object)object);
            return s.a;
        } else {
            k.b((Object)object);
            object = (g)this.L$0;
            Object object3 = (List)this.L$1;
            ArrayList<f> arrayList = new ArrayList<f>(n.o((Iterable)object3, (int)10));
            object3 = object3.iterator();
            while (object3.hasNext()) {
                arrayList.add(((DynamicIslandContentView)((Object)object3.next())).getViewModel().isExpanded());
            }
            f[] fArray = arrayList.toArray(new f[0]);
            f f2 = new f(Arrays.copyOf(fArray, fArray.length)){
                final f[] $flows$inlined;
                {
                    this.$flows$inlined = fArray;
                }

                public Object collect(g object, d d2) {
                    f[] fArray = this.$flows$inlined;
                    if ((object = j1.k.a((g)object, (f[])fArray, (a)new a(fArray){
                        final f[] $flows;
                        {
                            this.$flows = fArray;
                        }

                        public final Boolean[] invoke() {
                            return new Boolean[this.$flows.length];
                        }
                    }, (p)new p(null){
                        private Object L$0;
                        Object L$1;
                        int label;

                        /*
                         * Ignored method signature, as it can't be verified against descriptor
                         */
                        public final Object invoke(g g2, Object[] objectArray, d object) {
                            object = new /* invalid duplicate definition of identical inner class */;
                            object.L$0 = g2;
                            object.L$1 = objectArray;
                            return object.invokeSuspend(s.a);
                        }

                        /*
                         * Enabled force condition propagation
                         * Lifted jumps to return sites
                         */
                        public final Object invokeSuspend(Object object) {
                            boolean bl;
                            g g2;
                            Object object2;
                            block4: {
                                object2 = c.c();
                                int n2 = this.label;
                                if (n2 != 0) {
                                    if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    k.b((Object)object);
                                    return s.a;
                                }
                                k.b((Object)object);
                                g2 = (g)this.L$0;
                                Boolean[] booleanArray = (Boolean[])((Object[])this.L$1);
                                int n3 = booleanArray.length;
                                bl = false;
                                for (n2 = 0; n2 < n3; ++n2) {
                                    object = booleanArray[n2];
                                    if (!((Boolean)object).booleanValue()) {
                                        continue;
                                    }
                                    break block4;
                                }
                                object = null;
                            }
                            if (object != null) {
                                bl = (Boolean)object;
                            }
                            object = b.a((boolean)bl);
                            this.label = 1;
                            if (g2.emit(object, (d)this) != object2) return s.a;
                            return object2;
                        }
                    }, (d)d2)) == c.c()) {
                        return object;
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (h.q((g)object, (f)f2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
