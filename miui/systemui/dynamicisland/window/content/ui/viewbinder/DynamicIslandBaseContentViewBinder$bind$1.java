/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  U0.p
 *  android.util.Log
 *  android.view.View
 *  f1.E
 *  f1.f
 *  i1.I
 *  i1.g
 */
package miui.systemui.dynamicisland.window.content.ui.viewbinder;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.l;
import U0.o;
import U0.p;
import android.util.Log;
import android.view.View;
import f1.E;
import f1.f;
import i1.I;
import i1.g;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

@M0.f(c="miui.systemui.dynamicisland.window.content.ui.viewbinder.DynamicIslandBaseContentViewBinder$bind$1", f="DynamicIslandBaseContentViewBinder.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandBaseContentViewBinder.bind.1
extends l
implements p {
    final boolean $propOnce;
    final DynamicIslandSizeRepository $sizeRepository;
    final DynamicIslandBaseContentView $view;
    private Object L$0;
    int label;

    public DynamicIslandBaseContentViewBinder.bind.1(DynamicIslandSizeRepository dynamicIslandSizeRepository, DynamicIslandBaseContentView dynamicIslandBaseContentView, boolean bl, d d2) {
        this.$sizeRepository = dynamicIslandSizeRepository;
        this.$view = dynamicIslandBaseContentView;
        this.$propOnce = bl;
        super(3, d2);
    }

    public final Object invoke(E e, View object, d d2) {
        object = new /* invalid duplicate definition of identical inner class */;
        object.L$0 = e;
        return object.invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label == 0) {
            k.b((Object)object);
            object = (E)this.L$0;
            f.b((E)object, null, null, (o)new o(this.$sizeRepository, this.$view, null){
                final DynamicIslandSizeRepository $sizeRepository;
                final DynamicIslandBaseContentView $view;
                int label;
                {
                    this.$sizeRepository = dynamicIslandSizeRepository;
                    this.$view = dynamicIslandBaseContentView;
                    super(2, d2);
                }

                public final d create(Object object, d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(E e, d d2) {
                    return (this.create(e, d2)).invokeSuspend(s.a);
                }

                public final Object invokeSuspend(Object object) {
                    Object object2 = c.c();
                    int n = this.label;
                    if (n != 0) {
                        if (n != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        k.b((Object)object);
                    } else {
                        k.b((Object)object);
                        object = this.$sizeRepository.getCutoutY();
                        g g2 = new g(this.$view){
                            final DynamicIslandBaseContentView $view;
                            {
                                this.$view = dynamicIslandBaseContentView;
                            }

                            public final Object emit(float f2, d d2) {
                                this.$view.setCutoutY(f2);
                                return s.a;
                            }
                        };
                        this.label = 1;
                        if (object.collect(g2, (d)this) == object2) {
                            return object2;
                        }
                    }
                    throw new G0.c();
                }
            }, (int)3, null);
            f.b((E)object, null, null, (o)new o(this.$sizeRepository, this.$view, null){
                final DynamicIslandSizeRepository $sizeRepository;
                final DynamicIslandBaseContentView $view;
                int label;
                {
                    this.$sizeRepository = dynamicIslandSizeRepository;
                    this.$view = dynamicIslandBaseContentView;
                    super(2, d2);
                }

                public final d create(Object object, d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(E e, d d2) {
                    return (this.create(e, d2)).invokeSuspend(s.a);
                }

                public final Object invokeSuspend(Object object) {
                    Object object2 = c.c();
                    int n = this.label;
                    if (n != 0) {
                        if (n != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        k.b((Object)object);
                    } else {
                        k.b((Object)object);
                        object = this.$sizeRepository.getCutoutHeight();
                        g g2 = new g(this.$view){
                            final DynamicIslandBaseContentView $view;
                            {
                                this.$view = dynamicIslandBaseContentView;
                            }

                            public final Object emit(float f2, d d2) {
                                this.$view.setCutoutHeight(f2);
                                return s.a;
                            }
                        };
                        this.label = 1;
                        if (object.collect(g2, (d)this) == object2) {
                            return object2;
                        }
                    }
                    throw new G0.c();
                }
            }, (int)3, null);
            f.b((E)object, null, null, (o)new o(this.$sizeRepository, this.$view, null){
                final DynamicIslandSizeRepository $sizeRepository;
                final DynamicIslandBaseContentView $view;
                int label;
                {
                    this.$sizeRepository = dynamicIslandSizeRepository;
                    this.$view = dynamicIslandBaseContentView;
                    super(2, d2);
                }

                public final d create(Object object, d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(E e, d d2) {
                    return (this.create(e, d2)).invokeSuspend(s.a);
                }

                public final Object invokeSuspend(Object object) {
                    Object object2 = c.c();
                    int n = this.label;
                    if (n != 0) {
                        if (n != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        k.b((Object)object);
                    } else {
                        k.b((Object)object);
                        object = this.$sizeRepository.getIslandWidthParams();
                        g g2 = new g(this.$view){
                            final DynamicIslandBaseContentView $view;
                            {
                                this.$view = dynamicIslandBaseContentView;
                            }

                            public final Object emit(DynamicIslandSizeRepository.IslandWidthParams islandWidthParams, d object) {
                                object = this.$view;
                                float f2 = islandWidthParams.getMaxWidth();
                                float f3 = islandWidthParams.getClockWidth();
                                float f4 = islandWidthParams.getBatteryWidth();
                                ((DynamicIslandBaseContentView)((Object)object)).setMaxWidth(f2, f3, f4);
                                return s.a;
                            }
                        };
                        this.label = 1;
                        if (object.collect(g2, (d)this) == object2) {
                            return object2;
                        }
                    }
                    throw new G0.c();
                }
            }, (int)3, null);
            f.b((E)object, null, null, (o)new o(this.$sizeRepository, this.$propOnce, this.$view, null){
                final boolean $propOnce;
                final DynamicIslandSizeRepository $sizeRepository;
                final DynamicIslandBaseContentView $view;
                int label;
                {
                    this.$sizeRepository = dynamicIslandSizeRepository;
                    this.$propOnce = bl;
                    this.$view = dynamicIslandBaseContentView;
                    super(2, d2);
                }

                public final d create(Object object, d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(E e, d d2) {
                    return (this.create(e, d2)).invokeSuspend(s.a);
                }

                public final Object invokeSuspend(Object g2) {
                    Object object = c.c();
                    int n = this.label;
                    if (n != 0) {
                        if (n != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        k.b((Object)g2);
                    } else {
                        k.b((Object)g2);
                        I i2 = this.$sizeRepository.getStatusBarDatePosX();
                        g2 = new g(this.$propOnce, this.$view){
                            final boolean $propOnce;
                            final DynamicIslandBaseContentView $view;
                            {
                                this.$propOnce = bl;
                                this.$view = dynamicIslandBaseContentView;
                            }

                            public final Object emit(int n, d object) {
                                object = new StringBuilder();
                                ((StringBuilder)object).append("statusBarDatePosX change to ");
                                ((StringBuilder)object).append(n);
                                Log.d((String)"DynamicIslandContentView", (String)((StringBuilder)object).toString());
                                if (this.$propOnce) {
                                    return s.a;
                                }
                                if (n != this.$view.getStatusBarDatePosX()) {
                                    this.$view.setStatusBarDatePosX(n);
                                    this.$view.updateBigIslandLayout();
                                    object = this.$view.getDynamicIslandEventCoordinator();
                                    if (object != null) {
                                        ((DynamicIslandEventCoordinator)object).updateTouchRegion();
                                    }
                                    if (this.$view.getState() instanceof DynamicIslandState.BigIsland) {
                                        object = this.$view.getAnimatorDelegate();
                                        if (object != null) {
                                            ((DynamicIslandAnimationDelegate)object).updateBigIslandPosition();
                                        }
                                        if ((object = this.$view.getAnimatorDelegate()) != null) {
                                            ((DynamicIslandAnimationDelegate)object).containerScheduleUpdate();
                                        }
                                    }
                                }
                                return s.a;
                            }
                        };
                        this.label = 1;
                        if (i2.collect(g2, (d)this) == object) {
                            return object;
                        }
                    }
                    throw new G0.c();
                }
            }, (int)3, null);
            f.b((E)object, null, null, (o)new o(this.$sizeRepository, this.$view, null){
                final DynamicIslandSizeRepository $sizeRepository;
                final DynamicIslandBaseContentView $view;
                int label;
                {
                    this.$sizeRepository = dynamicIslandSizeRepository;
                    this.$view = dynamicIslandBaseContentView;
                    super(2, d2);
                }

                public final d create(Object object, d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(E e, d d2) {
                    return (this.create(e, d2)).invokeSuspend(s.a);
                }

                public final Object invokeSuspend(Object object) {
                    Object object2 = c.c();
                    int n = this.label;
                    if (n != 0) {
                        if (n != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        k.b((Object)object);
                    } else {
                        k.b((Object)object);
                        object = this.$sizeRepository.getPhoneContentViewDimensions();
                        g g2 = new g(this.$view){
                            final DynamicIslandBaseContentView $view;
                            {
                                this.$view = dynamicIslandBaseContentView;
                            }

                            public final Object emit(DynamicIslandSizeRepository.PhoneContentViewDimensions phoneContentViewDimensions, d d2) {
                                this.$view.requestLayout();
                                return s.a;
                            }
                        };
                        this.label = 1;
                        if (object.collect(g2, (d)this) == object2) {
                            return object2;
                        }
                    }
                    throw new G0.c();
                }
            }, (int)3, null);
            f.b((E)object, null, null, (o)new o(this.$sizeRepository, this.$view, null){
                final DynamicIslandSizeRepository $sizeRepository;
                final DynamicIslandBaseContentView $view;
                int label;
                {
                    this.$sizeRepository = dynamicIslandSizeRepository;
                    this.$view = dynamicIslandBaseContentView;
                    super(2, d2);
                }

                public final d create(Object object, d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(E e, d d2) {
                    return (this.create(e, d2)).invokeSuspend(s.a);
                }

                public final Object invokeSuspend(Object g2) {
                    Object object = c.c();
                    int n = this.label;
                    if (n != 0) {
                        if (n != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        k.b((Object)g2);
                    } else {
                        k.b((Object)g2);
                        I i2 = this.$sizeRepository.getPadContentViewDimensions();
                        g2 = new g(this.$view){
                            final DynamicIslandBaseContentView $view;
                            {
                                this.$view = dynamicIslandBaseContentView;
                            }

                            public final Object emit(DynamicIslandSizeRepository.PadContentViewDimensions padContentViewDimensions, d d2) {
                                this.$view.requestLayout();
                                return s.a;
                            }
                        };
                        this.label = 1;
                        if (i2.collect(g2, (d)this) == object) {
                            return object;
                        }
                    }
                    throw new G0.c();
                }
            }, (int)3, null);
            f.b((E)object, null, null, (o)new o(this.$sizeRepository, this.$view, null){
                final DynamicIslandSizeRepository $sizeRepository;
                final DynamicIslandBaseContentView $view;
                int label;
                {
                    this.$sizeRepository = dynamicIslandSizeRepository;
                    this.$view = dynamicIslandBaseContentView;
                    super(2, d2);
                }

                public final d create(Object object, d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(E e, d d2) {
                    return (this.create(e, d2)).invokeSuspend(s.a);
                }

                public final Object invokeSuspend(Object g2) {
                    Object object = c.c();
                    int n = this.label;
                    if (n != 0) {
                        if (n != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        k.b((Object)g2);
                    } else {
                        k.b((Object)g2);
                        I i2 = this.$sizeRepository.getExpandedIslandWidth();
                        g2 = new g(this.$view){
                            final DynamicIslandBaseContentView $view;
                            {
                                this.$view = dynamicIslandBaseContentView;
                            }

                            public final Object emit(int n, d d2) {
                                this.$view.setExpandedIslandWidth(n);
                                return s.a;
                            }
                        };
                        this.label = 1;
                        if (i2.collect(g2, (d)this) == object) {
                            return object;
                        }
                    }
                    throw new G0.c();
                }
            }, (int)3, null);
            f.b((E)object, null, null, (o)new o(this.$sizeRepository, this.$view, null){
                final DynamicIslandSizeRepository $sizeRepository;
                final DynamicIslandBaseContentView $view;
                int label;
                {
                    this.$sizeRepository = dynamicIslandSizeRepository;
                    this.$view = dynamicIslandBaseContentView;
                    super(2, d2);
                }

                public final d create(Object object, d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(E e, d d2) {
                    return (this.create(e, d2)).invokeSuspend(s.a);
                }

                public final Object invokeSuspend(Object object) {
                    Object object2 = c.c();
                    int n = this.label;
                    if (n != 0) {
                        if (n != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        k.b((Object)object);
                    } else {
                        k.b((Object)object);
                        object = this.$sizeRepository.getHeadsUpStatusBarPadding();
                        g g2 = new g(this.$view){
                            final DynamicIslandBaseContentView $view;
                            {
                                this.$view = dynamicIslandBaseContentView;
                            }

                            public final Object emit(int n, d d2) {
                                this.$view.setHeadsUpStatusBarPadding(n);
                                return s.a;
                            }
                        };
                        this.label = 1;
                        if (object.collect(g2, (d)this) == object2) {
                            return object2;
                        }
                    }
                    throw new G0.c();
                }
            }, (int)3, null);
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
