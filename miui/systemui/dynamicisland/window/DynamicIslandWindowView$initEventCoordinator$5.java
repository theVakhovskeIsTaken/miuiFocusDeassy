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
 *  U0.a
 *  U0.o
 *  U0.p
 *  f1.E
 *  i1.f
 *  i1.g
 *  j1.k
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.l;
import U0.a;
import U0.o;
import U0.p;
import f1.E;
import i1.f;
import i1.g;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

@M0.f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView$initEventCoordinator$5", f="DynamicIslandWindowView.kt", l={381}, m="invokeSuspend")
public static final class DynamicIslandWindowView.initEventCoordinator.5
extends l
implements o {
    int label;
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.initEventCoordinator.5(DynamicIslandWindowView dynamicIslandWindowView, d d2) {
        this.this$0 = dynamicIslandWindowView;
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
    public final Object invokeSuspend(Object g2) {
        Object object = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            k.b((Object)g2);
            return s.a;
        } else {
            k.b((Object)g2);
            f f2 = new f(new f[]{this.this$0.getWindowViewController().getWindowState().getNotificationAppearance(), this.this$0.getWindowViewController().getWindowState().getStatusBarDisappearance(), this.this$0.getWindowViewController().getWindowState().getShowNotificationIcons(), this.this$0.getWindowViewController().getWindowState().getBouncerShowing(), this.this$0.getWindowViewController().getWindowState().getControlCenterExpanded(), this.this$0.getWindowViewController().getWindowState().getScreenPinning(), this.this$0.getWindowViewController().getWindowState().getMiPlayShow(), this.this$0.getWindowViewController().getWindowState().isSuperSaveMode()}){
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
                            Object object2 = c.c();
                            int n = this.label;
                            if (n != 0) {
                                if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                k.b((Object)object);
                                return s.a;
                            } else {
                                k.b((Object)object);
                                object = (g)this.L$0;
                                Boolean[] booleanArray = (Boolean[])((Object[])this.L$1);
                                boolean bl = false;
                                boolean bl2 = booleanArray[0];
                                boolean bl3 = booleanArray[1];
                                boolean bl4 = booleanArray[2];
                                boolean bl5 = booleanArray[3];
                                boolean bl6 = booleanArray[4];
                                boolean bl7 = booleanArray[5];
                                boolean bl8 = booleanArray[6];
                                boolean bl9 = booleanArray[7];
                                if (bl2 || bl6 || bl3 || bl4 || bl5 || bl7 || bl8 || bl9) {
                                    bl = true;
                                }
                                Boolean bl10 = b.a((boolean)bl);
                                this.label = 1;
                                if (object.emit((Object)bl10, (d)this) != object2) return s.a;
                                return object2;
                            }
                        }
                    }, (d)d2)) == c.c()) {
                        return object;
                    }
                    return s.a;
                }
            };
            g2 = new g(this.this$0){
                final DynamicIslandWindowView this$0;
                {
                    this.this$0 = dynamicIslandWindowView;
                }

                public final Object emit(boolean bl, d object) {
                    object = this.this$0.getEventCoordinator();
                    if (object != null) {
                        ((DynamicIslandEventCoordinator)object).updateTouchRegion();
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (f2.collect(g2, (d)this) != object) return s.a;
            return object;
        }
    }
}
