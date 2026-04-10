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
 *  M0.d
 *  U0.a
 *  U0.p
 *  f1.E
 *  i1.E
 *  i1.I
 *  i1.f
 *  i1.g
 *  i1.h
 *  j1.k
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.k;
import G0.s;
import H0.n;
import K0.d;
import L0.c;
import M0.b;
import U0.a;
import U0.p;
import f1.E;
import i1.I;
import i1.f;
import i1.g;
import i1.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowStateInteractor$special$;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;

@DynamicIslandScope
public final class DynamicIslandWindowStateInteractor {
    private final DynamicIslandEventCoordinator eventCoordinator;
    private final I isAppAnimRunning;
    private final E scope;
    private final I visibility;
    private final I visible;
    private final I watchOutsideTouch;
    private final DynamicIslandWindowViewController windowViewController;
    private final DynamicIslandWindowViewTouchInteractor windowViewTouchInteractor;

    public DynamicIslandWindowStateInteractor(@DynamicIsland E e, DynamicIslandEventCoordinator dynamicIslandEventCoordinator, DynamicIslandWindowViewController dynamicIslandWindowViewController, DynamicIslandWindowViewTouchInteractor object) {
        o.g((Object)e, (String)"scope");
        o.g((Object)dynamicIslandEventCoordinator, (String)"eventCoordinator");
        o.g((Object)dynamicIslandWindowViewController, (String)"windowViewController");
        o.g((Object)object, (String)"windowViewTouchInteractor");
        this.scope = e;
        this.eventCoordinator = dynamicIslandEventCoordinator;
        this.windowViewController = dynamicIslandWindowViewController;
        this.windowViewTouchInteractor = object;
        f f2 = h.i((f)this.getWindowHeight(), (f)((DynamicIslandWindowViewTouchInteractor)object).isTracking(), (p)new p(null){
            int I$0;
            boolean Z$0;
            int label;

            public final Object invoke(int n, boolean bl, d object) {
                object = new /* invalid duplicate definition of identical inner class */;
                object.I$0 = n;
                object.Z$0 = bl;
                return object.invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                c.c();
                if (this.label == 0) {
                    k.b((Object)object);
                    int n = this.I$0;
                    boolean bl = this.Z$0;
                    bl = n > 0 || bl;
                    return b.a((boolean)bl);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        });
        dynamicIslandEventCoordinator = i1.E.a;
        i1.E e2 = dynamicIslandEventCoordinator.c();
        object = Boolean.FALSE;
        f2 = h.B((f)f2, (E)e, (i1.E)e2, (Object)object);
        this.visible = f2;
        this.isAppAnimRunning = dynamicIslandWindowViewController.isAppAnimRunning();
        this.visibility = h.B((f)new f(f2){
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
                        if (!(var2_2 /* !! */  instanceof special$$inlined$map$1$2$1)) ** GOTO lbl-1000
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
                                final special$$inlined$map$1$2 this$0;
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
                            var3_4 = (Boolean)var1_1 != false ? 0 : 4;
                            var1_1 = b.c((int)var3_4);
                            var2_2 /* !! */ .label = 1;
                            if (var5_5.emit(var1_1, var2_2 /* !! */ ) == var4_3 /* !! */ ) {
                                return var4_3 /* !! */ ;
                            }
                        }
                        return s.a;
                    }
                }, d2)) == c.c()) {
                    return object;
                }
                return s.a;
            }
        }, (E)e, (i1.E)dynamicIslandEventCoordinator.c(), (Object)4);
        this.watchOutsideTouch = h.B((f)h.C((f)dynamicIslandWindowViewController.getContentViews(), (p)new p(null){
            private Object L$0;
            Object L$1;
            int label;

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
        }), (E)e, (i1.E)dynamicIslandEventCoordinator.c(), (Object)object);
    }

    public static /* synthetic */ void getWatchOutsideTouch$annotations() {
    }

    public final I getVisibility() {
        return this.visibility;
    }

    public final I getVisible() {
        return this.visible;
    }

    public final I getWatchOutsideTouch() {
        return this.watchOutsideTouch;
    }

    public final I getWindowHeight() {
        return this.eventCoordinator.getState();
    }

    public final I isAppAnimRunning() {
        return this.isAppAnimRunning;
    }
}
