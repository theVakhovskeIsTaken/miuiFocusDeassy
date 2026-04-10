/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.i
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  U0.o
 *  f1.E
 *  f1.f
 *  i1.I
 *  i1.K
 *  i1.h
 *  i1.u
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.data.repository;

import G0.i;
import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import f1.E;
import f1.f;
import i1.I;
import i1.K;
import i1.h;
import i1.u;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;

@DynamicIslandScope
public final class DynamicIslandExternalStateRepository {
    private final u _bouncerIsOrWillBeShowing;
    private final u _commandQueueDisable;
    private final u _isDeviceInteractive;
    private final u _isKeyguardGoingAway;
    private final u _isKeyguardOccluded;
    private final u _isKeyguardShowing;
    private final u _miPlayShow;
    private final u _notificationAppearance;
    private final u _notificationVisible;
    private final I bouncerIsOrWillBeShowing;
    private final I commandQueueDisable;
    private final I isDeviceInteractive;
    private final I isKeyguardGoingAway;
    private final I isKeyguardOccluded;
    private final I isKeyguardShowing;
    private final I miPlayShow;
    private final I notificationAppearance;
    private final I notificationVisible;
    private final E scope;

    public DynamicIslandExternalStateRepository(@DynamicIsland E object) {
        Object object2;
        o.g((Object)object, (String)"scope");
        this.scope = object;
        object = Boolean.FALSE;
        this._notificationVisible = object2 = K.a((Object)object);
        this.notificationVisible = h.b((u)object2);
        this._notificationAppearance = object2 = K.a((Object)object);
        this.notificationAppearance = h.b((u)object2);
        this._miPlayShow = object2 = K.a((Object)object);
        this.miPlayShow = h.b((u)object2);
        object2 = 0;
        this._commandQueueDisable = object2 = K.a((Object)new i(object2, object2));
        this.commandQueueDisable = h.b((u)object2);
        this._isKeyguardShowing = object2 = K.a((Object)object);
        this.isKeyguardShowing = h.b((u)object2);
        this._isKeyguardOccluded = object2 = K.a((Object)object);
        this.isKeyguardOccluded = h.b((u)object2);
        this._isKeyguardGoingAway = object2 = K.a((Object)object);
        this.isKeyguardGoingAway = h.b((u)object2);
        this._bouncerIsOrWillBeShowing = object2 = K.a((Object)object);
        this.bouncerIsOrWillBeShowing = h.b((u)object2);
        object = K.a((Object)object);
        this._isDeviceInteractive = object;
        this.isDeviceInteractive = h.b((u)object);
    }

    public static final /* synthetic */ u access$get_bouncerIsOrWillBeShowing$p(DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository) {
        return dynamicIslandExternalStateRepository._bouncerIsOrWillBeShowing;
    }

    public static final /* synthetic */ u access$get_commandQueueDisable$p(DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository) {
        return dynamicIslandExternalStateRepository._commandQueueDisable;
    }

    public static final /* synthetic */ u access$get_isDeviceInteractive$p(DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository) {
        return dynamicIslandExternalStateRepository._isDeviceInteractive;
    }

    public static final /* synthetic */ u access$get_isKeyguardGoingAway$p(DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository) {
        return dynamicIslandExternalStateRepository._isKeyguardGoingAway;
    }

    public static final /* synthetic */ u access$get_isKeyguardOccluded$p(DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository) {
        return dynamicIslandExternalStateRepository._isKeyguardOccluded;
    }

    public static final /* synthetic */ u access$get_isKeyguardShowing$p(DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository) {
        return dynamicIslandExternalStateRepository._isKeyguardShowing;
    }

    public static final /* synthetic */ u access$get_miPlayShow$p(DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository) {
        return dynamicIslandExternalStateRepository._miPlayShow;
    }

    public static final /* synthetic */ u access$get_notificationAppearance$p(DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository) {
        return dynamicIslandExternalStateRepository._notificationAppearance;
    }

    public static final /* synthetic */ u access$get_notificationVisible$p(DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository) {
        return dynamicIslandExternalStateRepository._notificationVisible;
    }

    public final I getBouncerIsOrWillBeShowing() {
        return this.bouncerIsOrWillBeShowing;
    }

    public final I getCommandQueueDisable() {
        return this.commandQueueDisable;
    }

    public final I getMiPlayShow() {
        return this.miPlayShow;
    }

    public final I getNotificationAppearance() {
        return this.notificationAppearance;
    }

    public final I getNotificationVisible() {
        return this.notificationVisible;
    }

    public final I isDeviceInteractive() {
        return this.isDeviceInteractive;
    }

    public final I isKeyguardGoingAway() {
        return this.isKeyguardGoingAway;
    }

    public final I isKeyguardOccluded() {
        return this.isKeyguardOccluded;
    }

    public final I isKeyguardShowing() {
        return this.isKeyguardShowing;
    }

    public final void notifyBouncerIsOrWillBeShowing(boolean bl) {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, bl, null){
            final boolean $value;
            int label;
            final DynamicIslandExternalStateRepository this$0;
            {
                this.this$0 = dynamicIslandExternalStateRepository;
                this.$value = bl;
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
                    DynamicIslandExternalStateRepository.access$get_bouncerIsOrWillBeShowing$p(this.this$0).setValue((Object)b.a((boolean)this.$value));
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final void notifyCommandQueueDisableChanged(i i2) {
        o.g((Object)i2, (String)"disable");
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, i2, null){
            final i $disable;
            int label;
            final DynamicIslandExternalStateRepository this$0;
            {
                this.this$0 = dynamicIslandExternalStateRepository;
                this.$disable = i2;
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
                    DynamicIslandExternalStateRepository.access$get_commandQueueDisable$p(this.this$0).setValue((Object)this.$disable);
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final void notifyDeviceInteractive(boolean bl) {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, bl, null){
            final boolean $value;
            int label;
            final DynamicIslandExternalStateRepository this$0;
            {
                this.this$0 = dynamicIslandExternalStateRepository;
                this.$value = bl;
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
                    DynamicIslandExternalStateRepository.access$get_isDeviceInteractive$p(this.this$0).setValue((Object)b.a((boolean)this.$value));
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final void notifyKeyguardGoingAway(boolean bl) {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, bl, null){
            final boolean $value;
            int label;
            final DynamicIslandExternalStateRepository this$0;
            {
                this.this$0 = dynamicIslandExternalStateRepository;
                this.$value = bl;
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
                    DynamicIslandExternalStateRepository.access$get_isKeyguardGoingAway$p(this.this$0).setValue((Object)b.a((boolean)this.$value));
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final void notifyKeyguardOccluded(boolean bl) {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, bl, null){
            final boolean $occluded;
            int label;
            final DynamicIslandExternalStateRepository this$0;
            {
                this.this$0 = dynamicIslandExternalStateRepository;
                this.$occluded = bl;
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
                    DynamicIslandExternalStateRepository.access$get_isKeyguardOccluded$p(this.this$0).setValue((Object)b.a((boolean)this.$occluded));
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final void notifyKeyguardShowingChanged(boolean bl) {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, bl, null){
            final boolean $showing;
            int label;
            final DynamicIslandExternalStateRepository this$0;
            {
                this.this$0 = dynamicIslandExternalStateRepository;
                this.$showing = bl;
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
                    DynamicIslandExternalStateRepository.access$get_isKeyguardShowing$p(this.this$0).setValue((Object)b.a((boolean)this.$showing));
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final void notifyMiPlayShowStateChanged(boolean bl) {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, bl, null){
            final boolean $miplayShow;
            int label;
            final DynamicIslandExternalStateRepository this$0;
            {
                this.this$0 = dynamicIslandExternalStateRepository;
                this.$miplayShow = bl;
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
                    DynamicIslandExternalStateRepository.access$get_miPlayShow$p(this.this$0).setValue((Object)b.a((boolean)this.$miplayShow));
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final void notifyNotificationAppearanceChanged(boolean bl) {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, bl, null){
            final boolean $appearance;
            int label;
            final DynamicIslandExternalStateRepository this$0;
            {
                this.this$0 = dynamicIslandExternalStateRepository;
                this.$appearance = bl;
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
                    DynamicIslandExternalStateRepository.access$get_notificationAppearance$p(this.this$0).setValue((Object)b.a((boolean)this.$appearance));
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final void notifyNotificationVisibleChanged(boolean bl) {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, bl, null){
            final boolean $visible;
            int label;
            final DynamicIslandExternalStateRepository this$0;
            {
                this.this$0 = dynamicIslandExternalStateRepository;
                this.$visible = bl;
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
                    DynamicIslandExternalStateRepository.access$get_notificationVisible$p(this.this$0).setValue((Object)b.a((boolean)this.$visible));
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }
}
