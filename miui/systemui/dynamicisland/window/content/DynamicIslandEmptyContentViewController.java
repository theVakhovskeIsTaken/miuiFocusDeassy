/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  U0.o
 *  android.view.View
 *  f1.E
 *  f1.f
 *  i1.f
 *  i1.g
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.coroutines.flow.ViewUtilsKt
 */
package miui.systemui.dynamicisland.window.content;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import android.view.View;
import f1.E;
import f1.f;
import i1.g;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandStartable;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandEmptyContentView;
import miui.systemui.util.coroutines.flow.ViewUtilsKt;

@DynamicIslandScope
public final class DynamicIslandEmptyContentViewController
implements DynamicIslandStartable {
    private final E scope;
    private final DynamicIslandTouchInteractor touchInteractor;
    private final DynamicIslandEmptyContentView view;

    public DynamicIslandEmptyContentViewController(DynamicIslandWindowView dynamicIslandWindowView, @DynamicIsland E e, DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        o.g((Object)((Object)dynamicIslandWindowView), (String)"windowView");
        o.g((Object)e, (String)"scope");
        o.g((Object)dynamicIslandTouchInteractor, (String)"touchInteractor");
        this.scope = e;
        this.touchInteractor = dynamicIslandTouchInteractor;
        this.view = (DynamicIslandEmptyContentView)dynamicIslandWindowView.requireViewById(R.id.empty_content_view);
    }

    public static final /* synthetic */ DynamicIslandTouchInteractor access$getTouchInteractor$p(DynamicIslandEmptyContentViewController dynamicIslandEmptyContentViewController) {
        return dynamicIslandEmptyContentViewController.touchInteractor;
    }

    public static final /* synthetic */ DynamicIslandEmptyContentView access$getView$p(DynamicIslandEmptyContentViewController dynamicIslandEmptyContentViewController) {
        return dynamicIslandEmptyContentViewController.view;
    }

    @Override
    public void start() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandEmptyContentViewController this$0;
            {
                this.this$0 = dynamicIslandEmptyContentViewController;
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
                    DynamicIslandEmptyContentView dynamicIslandEmptyContentView = DynamicIslandEmptyContentViewController.access$getView$p(this.this$0);
                    o.f((Object)((Object)dynamicIslandEmptyContentView), (String)"access$getView$p(...)");
                    i1.f f2 = ViewUtilsKt.getOnClick((View)dynamicIslandEmptyContentView);
                    g g2 = new g(this.this$0){
                        final DynamicIslandEmptyContentViewController this$0;
                        {
                            this.this$0 = dynamicIslandEmptyContentViewController;
                        }

                        public final Object emit(s s2, d d2) {
                            DynamicIslandEmptyContentViewController.access$getTouchInteractor$p(this.this$0).performClick();
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (f2.collect(g2, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)3, null);
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandEmptyContentViewController this$0;
            {
                this.this$0 = dynamicIslandEmptyContentViewController;
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
                    DynamicIslandEmptyContentView dynamicIslandEmptyContentView = DynamicIslandEmptyContentViewController.access$getView$p(this.this$0);
                    o.f((Object)((Object)dynamicIslandEmptyContentView), (String)"access$getView$p(...)");
                    i1.f f2 = ViewUtilsKt.getOnLongClick((View)dynamicIslandEmptyContentView);
                    g g2 = new g(this.this$0){
                        final DynamicIslandEmptyContentViewController this$0;
                        {
                            this.this$0 = dynamicIslandEmptyContentViewController;
                        }

                        public final Object emit(Function1 function1, d d2) {
                            function1.invoke((Object)b.a((boolean)DynamicIslandEmptyContentViewController.access$getTouchInteractor$p(this.this$0).performLongClick()));
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (f2.collect(g2, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)3, null);
    }
}
