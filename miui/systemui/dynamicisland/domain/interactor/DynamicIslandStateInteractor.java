/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.i
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  U0.o
 *  f1.E
 *  f1.f
 *  i1.g
 *  kotlin.jvm.internal.o
 *  miui.systemui.controlcenter.data.repository.ControlCenterExpandRepository
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.domain.interactor;

import G0.i;
import G0.k;
import G0.s;
import K0.d;
import L0.c;
import f1.E;
import f1.f;
import i1.g;
import kotlin.jvm.internal.o;
import miui.systemui.controlcenter.data.repository.ControlCenterExpandRepository;
import miui.systemui.dynamicisland.DynamicIslandStartable;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.util.CommonUtils;

@DynamicIslandScope
public final class DynamicIslandStateInteractor
implements DynamicIslandStartable {
    private final ControlCenterExpandRepository controlCenterExpandRepository;
    private final DynamicIslandWindowViewController dynamicIslandWindowViewController;
    private final E scope;

    public DynamicIslandStateInteractor(@DynamicIsland E e, DynamicIslandWindowViewController dynamicIslandWindowViewController, ControlCenterExpandRepository controlCenterExpandRepository) {
        o.g((Object)e, (String)"scope");
        o.g((Object)dynamicIslandWindowViewController, (String)"dynamicIslandWindowViewController");
        o.g((Object)controlCenterExpandRepository, (String)"controlCenterExpandRepository");
        this.scope = e;
        this.dynamicIslandWindowViewController = dynamicIslandWindowViewController;
        this.controlCenterExpandRepository = controlCenterExpandRepository;
    }

    public static final /* synthetic */ ControlCenterExpandRepository access$getControlCenterExpandRepository$p(DynamicIslandStateInteractor dynamicIslandStateInteractor) {
        return dynamicIslandStateInteractor.controlCenterExpandRepository;
    }

    public static final /* synthetic */ DynamicIslandWindowViewController access$getDynamicIslandWindowViewController$p(DynamicIslandStateInteractor dynamicIslandStateInteractor) {
        return dynamicIslandStateInteractor.dynamicIslandWindowViewController;
    }

    private final void listenForControlCenterAppearance() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandStateInteractor this$0;
            {
                this.this$0 = dynamicIslandStateInteractor;
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
                    object = DynamicIslandStateInteractor.access$getControlCenterExpandRepository$p(this.this$0).getAppearance();
                    g g2 = new g(this.this$0){
                        final DynamicIslandStateInteractor this$0;
                        {
                            this.this$0 = dynamicIslandStateInteractor;
                        }

                        public final Object emit(boolean bl, d d2) {
                            DynamicIslandStateInteractor.access$getDynamicIslandWindowViewController$p(this.this$0).controlCenterExpanded(bl);
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
    }

    private final void listenForControlCenterExpandHeightChanged() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandStateInteractor this$0;
            {
                this.this$0 = dynamicIslandStateInteractor;
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
                    object = DynamicIslandStateInteractor.access$getControlCenterExpandRepository$p(this.this$0).getExpandHeightChanged();
                    g g2 = new g(this.this$0){
                        final DynamicIslandStateInteractor this$0;
                        {
                            this.this$0 = dynamicIslandStateInteractor;
                        }

                        public final Object emit(i i2, d d2) {
                            DynamicIslandStateInteractor.access$getDynamicIslandWindowViewController$p(this.this$0).controlCenterPanelExpandHeightChanged(i2);
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
    }

    @Override
    public void start() {
        this.listenForControlCenterAppearance();
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            this.listenForControlCenterExpandHeightChanged();
        }
    }
}
