/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.b
 *  G0.c
 *  G0.i
 *  G0.k
 *  G0.s
 *  H0.m
 *  K0.d
 *  L0.c
 *  M0.b
 *  U0.o
 *  U0.p
 *  U0.s
 *  android.annotation.SuppressLint
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Point
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Icon
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$DragShadowBuilder
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  e1.e
 *  e1.n
 *  e1.o
 *  f1.E
 *  i1.I
 *  i1.f
 *  i1.g
 *  i1.h
 *  kotlin.jvm.internal.D
 *  kotlin.jvm.internal.j
 *  kotlin.jvm.internal.o
 *  miui.systemui.lifecycle.RepeatWhenAttachedKt
 *  miui.systemui.settings.data.repository.WorkBenchModeRepository
 *  miui.systemui.util.kotlin.DisposableHandles
 */
package miui.systemui.dynamicisland.window.content;

import G0.b;
import G0.c;
import G0.i;
import G0.k;
import G0.s;
import H0.m;
import K0.d;
import U0.p;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import e1.e;
import e1.n;
import e1.o;
import f1.E;
import i1.I;
import i1.f;
import i1.g;
import i1.h;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.j;
import miui.systemui.dynamicisland.DynamicIslandShareUtils;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.domain.interactor.DynamicIslandRegionSamplingInteractor;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.model.ShareData;
import miui.systemui.dynamicisland.template.IslandTemplateFactory;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.DynamicIslandViewModel;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandShareData;
import miui.systemui.dynamicisland.window.content.ShareProviderData;
import miui.systemui.lifecycle.RepeatWhenAttachedKt;
import miui.systemui.settings.data.repository.WorkBenchModeRepository;
import miui.systemui.util.kotlin.DisposableHandles;

public class DynamicIslandBaseContentViewController<T extends DynamicIslandBaseContentView> {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "DynamicIslandBaseContentViewController";
    private boolean clickIsBigLand;
    private final Context context;
    private final DisposableHandles disposables;
    private boolean isProviderAccessible;
    private final IslandTemplateFactory islandTemplateFactory;
    private float marginCardRight;
    private float marginCardTop;
    private final DynamicIslandRegionSamplingInteractor regionSamplingInteractor;
    private final E scope;
    private final DynamicIslandTouchInteractor touchInteractor;
    private final T view;
    private WorkBenchModeRepository workBenchModeState;

    public DynamicIslandBaseContentViewController(T object, @DynamicIsland E e, DynamicIslandRegionSamplingInteractor dynamicIslandRegionSamplingInteractor, IslandTemplateFactory islandTemplateFactory, DynamicIslandTouchInteractor dynamicIslandTouchInteractor, WorkBenchModeRepository workBenchModeRepository) {
        kotlin.jvm.internal.o.g(object, (String)"view");
        kotlin.jvm.internal.o.g((Object)e, (String)"scope");
        kotlin.jvm.internal.o.g((Object)dynamicIslandRegionSamplingInteractor, (String)"regionSamplingInteractor");
        kotlin.jvm.internal.o.g((Object)islandTemplateFactory, (String)"islandTemplateFactory");
        kotlin.jvm.internal.o.g((Object)dynamicIslandTouchInteractor, (String)"touchInteractor");
        kotlin.jvm.internal.o.g((Object)workBenchModeRepository, (String)"workBenchModeRepository");
        this.view = object;
        this.scope = e;
        this.regionSamplingInteractor = dynamicIslandRegionSamplingInteractor;
        this.islandTemplateFactory = islandTemplateFactory;
        this.touchInteractor = dynamicIslandTouchInteractor;
        this.workBenchModeState = workBenchModeRepository;
        e = object.getContext();
        this.context = e;
        dynamicIslandRegionSamplingInteractor = new DisposableHandles();
        this.disposables = dynamicIslandRegionSamplingInteractor;
        dynamicIslandRegionSamplingInteractor.plusAssign(RepeatWhenAttachedKt.repeatWhenAttached$default(object, null, (p)new p(this, null){
            int label;
            final DynamicIslandBaseContentViewController<T> this$0;
            {
                this.this$0 = dynamicIslandBaseContentViewController;
                super(3, d2);
            }

            public final Object invoke(E e2, View view, d d2) {
                return new /* invalid duplicate definition of identical inner class */.invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n2 = this.label;
                if (n2 != 0) {
                    if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    return s.a;
                } else {
                    k.b((Object)object);
                    object = h.l((f)((DynamicIslandBaseContentView)((Object)this.this$0.getView())).getViewModel().getStateName(), (f)((DynamicIslandBaseContentView)((Object)this.this$0.getView())).getHighlightColor(), (f)DynamicIslandBaseContentViewController.access$getRegionSamplingInteractor$p(this.this$0).isRegionDark(), (f)((DynamicIslandBaseContentView)((Object)this.this$0.getView())).getIslandAppAnimRunning(), (f)((DynamicIslandBaseContentView)((Object)this.this$0.getView())).getIslandFreeformAnimRunning(), (U0.s)new U0.s(null){
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
                            L0.c.c();
                            if (this.label == 0) {
                                k.b((Object)object);
                                object = (String)this.L$0;
                                String string = (String)this.L$1;
                                boolean bl = this.Z$0;
                                boolean bl2 = this.Z$1;
                                boolean bl3 = this.Z$2;
                                return m.f((Object[])new Object[]{object, string, M0.b.a((boolean)(bl ^ true)), M0.b.a((boolean)bl2), M0.b.a((boolean)bl3)});
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
                            L0.c.c();
                            if (this.label == 0) {
                                k.b((Object)object);
                                ArrayList<E> arrayList = (ArrayList)this.L$0;
                                boolean bl = true;
                                if (arrayList.get(1) != null) {
                                    object = arrayList.get(1);
                                    kotlin.jvm.internal.o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                                    object = (String)object;
                                } else {
                                    object = "";
                                }
                                E e2 = arrayList.get(2);
                                kotlin.jvm.internal.o.e(e2, (String)"null cannot be cast to non-null type kotlin.Boolean");
                                boolean bl2 = (Boolean)e2;
                                e2 = arrayList.get(3);
                                kotlin.jvm.internal.o.e(e2, (String)"null cannot be cast to non-null type kotlin.Boolean");
                                boolean bl3 = bl;
                                if (!((Boolean)e2).booleanValue()) {
                                    arrayList = arrayList.get(4);
                                    kotlin.jvm.internal.o.e((Object)arrayList, (String)"null cannot be cast to non-null type kotlin.Boolean");
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
                            kotlin.jvm.internal.o.g((Object)o2, (String)"function");
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
                                    bl3 = kotlin.jvm.internal.o.c((Object)this.getFunctionDelegate(), (Object)((j)object).getFunctionDelegate());
                                }
                            }
                            return bl3;
                        }

                        public final b getFunctionDelegate() {
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
        }, (int)1, null));
        dynamicIslandRegionSamplingInteractor.plusAssign(RepeatWhenAttachedKt.repeatWhenAttached$default(object, null, (p)new p(this, null){
            int label;
            final DynamicIslandBaseContentViewController<T> this$0;
            {
                this.this$0 = dynamicIslandBaseContentViewController;
                super(3, d2);
            }

            public final Object invoke(E e2, View view, d d2) {
                return new /* invalid duplicate definition of identical inner class */.invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object g2) {
                Object object = L0.c.c();
                int n2 = this.label;
                if (n2 != 0) {
                    if (n2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)g2);
                } else {
                    k.b((Object)g2);
                    I i2 = DynamicIslandBaseContentViewController.access$getTouchInteractor$p(this.this$0).getSwipeInfo();
                    g2 = new g(this.this$0){
                        final DynamicIslandBaseContentViewController<T> this$0;
                        {
                            this.this$0 = dynamicIslandBaseContentViewController;
                        }

                        public final Object emit(i i2, d d2) {
                            ((DynamicIslandBaseContentView)((Object)this.this$0.getView())).setSwipeInfo(i2);
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (i2.collect(g2, (d)this) == object) {
                        return object;
                    }
                }
                throw new c();
            }
        }, (int)1, null));
        dynamicIslandRegionSamplingInteractor.plusAssign(RepeatWhenAttachedKt.repeatWhenAttached$default(object, null, (p)new p(this, null){
            int label;
            final DynamicIslandBaseContentViewController<T> this$0;
            {
                this.this$0 = dynamicIslandBaseContentViewController;
                super(3, d2);
            }

            public final Object invoke(E e2, View view, d d2) {
                return new /* invalid duplicate definition of identical inner class */.invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n2 = this.label;
                if (n2 != 0) {
                    if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    return s.a;
                } else {
                    k.b((Object)object);
                    if (!(this.this$0.getView() instanceof DynamicIslandContentFakeView)) return s.a;
                    object = h.i((f)((DynamicIslandContentFakeView)((Object)this.this$0.getView())).getTrackingToOpenMW(), (f)((DynamicIslandContentFakeView)((Object)this.this$0.getView())).getStartEnterMiniWindowBeforeAnimation(), (p)new p(null){
                        boolean Z$0;
                        boolean Z$1;
                        int label;

                        public final Object invoke(boolean bl, boolean bl2, d object) {
                            object = new /* invalid duplicate definition of identical inner class */;
                            object.Z$0 = bl;
                            object.Z$1 = bl2;
                            return object.invokeSuspend(s.a);
                        }

                        public final Object invokeSuspend(Object object) {
                            L0.c.c();
                            if (this.label == 0) {
                                k.b((Object)object);
                                boolean bl = this.Z$0;
                                boolean bl2 = this.Z$1;
                                bl = bl || bl2;
                                return M0.b.a((boolean)bl);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    });
                    g g2 = new g(this.this$0){
                        final DynamicIslandBaseContentViewController<T> this$0;
                        {
                            this.this$0 = dynamicIslandBaseContentViewController;
                        }

                        public final Object emit(boolean bl, d object) {
                            object = ((DynamicIslandBaseContentView)((Object)this.this$0.getView())).getDynamicIslandEventCoordinator();
                            if (object != null) {
                                ((DynamicIslandEventCoordinator)object).updateTouchRegion();
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)1, null));
        dynamicIslandRegionSamplingInteractor = ((DynamicIslandBaseContentView)((Object)object)).getMask();
        float f2 = 0.0f;
        float f3 = dynamicIslandRegionSamplingInteractor != null && (dynamicIslandRegionSamplingInteractor = dynamicIslandRegionSamplingInteractor.getContext()) != null && (dynamicIslandRegionSamplingInteractor = dynamicIslandRegionSamplingInteractor.getResources()) != null ? dynamicIslandRegionSamplingInteractor.getDimension(R.dimen.isLand_drag_card_hand_margin_right) : 0.0f;
        this.marginCardRight = f3;
        object = ((DynamicIslandBaseContentView)((Object)object)).getMask();
        f3 = f2;
        if (object != null) {
            object = object.getContext();
            f3 = f2;
            if (object != null) {
                object = object.getResources();
                f3 = f2;
                if (object != null) {
                    f3 = object.getDimension(R.dimen.isLand_drag_card_hand_margin_top);
                }
            }
        }
        this.marginCardTop = f3;
        object = DynamicIslandShareUtils.INSTANCE;
        kotlin.jvm.internal.o.f((Object)e, (String)"context");
        this.isProviderAccessible = ((DynamicIslandShareUtils)object).isProviderAccessible((Context)e, Uri.parse((String)"content://com.miui.personalassistant.picker.share"));
    }

    public static final /* synthetic */ DynamicIslandRegionSamplingInteractor access$getRegionSamplingInteractor$p(DynamicIslandBaseContentViewController dynamicIslandBaseContentViewController) {
        return dynamicIslandBaseContentViewController.regionSamplingInteractor;
    }

    public static final /* synthetic */ DynamicIslandTouchInteractor access$getTouchInteractor$p(DynamicIslandBaseContentViewController dynamicIslandBaseContentViewController) {
        return dynamicIslandBaseContentViewController.touchInteractor;
    }

    private final i calculateViewPosition(View object, float f2) {
        int[] nArray = new int[2];
        if (object != null) {
            object.getLocationOnScreen(nArray);
        }
        int n = (int)((float)nArray[1] + f2);
        int n2 = nArray[0];
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        kotlin.jvm.internal.o.d((Object)object);
        return new i((Object)(n2 + (Integer)object / 2), (Object)n);
    }

    private final int dragShareAddFlags() {
        int n = 768;
        try {
            Field field = View.class.getDeclaredField("DRAG_FLAG_DYNAMIC_ISLAND_CUSTOM_ANIMATION");
            ((AccessibleObject)field).setAccessible(true);
            int n2 = field.getInt(null);
            n = 0x300 | n2;
        }
        catch (Exception exception) {
            Log.e((String)TAG, (String)"\u53cd\u5c04\u83b7\u53d6 DRAG_FLAG_DYNAMIC_ISLAND_CUSTOM_ANIMATION \u5931\u8d25", (Throwable)exception);
        }
        return n;
    }

    @SuppressLint(value={"InflateParams"})
    private final View.DragShadowBuilder dragShareCard(DynamicIslandBaseContentView object, DynamicIslandData object2, ShareData object3) {
        Object object4 = LayoutInflater.from((Context)this.context);
        int n = R.layout.dynamic_island_share_view;
        Object var9_6 = null;
        Object var8_7 = null;
        View view = object4.inflate(n, null);
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        object4 = object2 != null && (object4 = object2.getExtras()) != null ? object4.getString("miui.pkg.name") : null;
        object2 = object2 != null && (object2 = object2.getExtras()) != null ? object2.getBundle("miui.focus.pics") : null;
        object2 = object2 != null ? (Icon)object2.getParcelable("miui_media_album_icon") : null;
        ImageView imageView = (ImageView)view.findViewById(R.id.share_icon);
        TextView textView = (TextView)view.findViewById(R.id.share_title);
        Object object5 = object3 != null ? ((ShareData)object3).getTitle() : null;
        textView.setText((CharSequence)object5);
        object5 = (TextView)view.findViewById(R.id.share_content);
        object3 = object3 != null ? ((ShareData)object3).getContent() : null;
        object5.setText((CharSequence)object3);
        if (object2 != null) {
            object2 = object2.loadDrawable(this.context);
            object = var9_6;
            if (object2 != null) {
                object = DynamicIslandShareUtils.INSTANCE;
                object3 = this.context;
                kotlin.jvm.internal.o.f((Object)object3, (String)"context");
                object = ((DynamicIslandShareUtils)object).drawableAddRounded((Context)object3, (Drawable)object2, this.context.getResources().getDimensionPixelSize(R.dimen.island_share_pic_radius));
            }
        } else {
            object5 = DynamicIslandUtils.INSTANCE;
            object3 = this.context;
            kotlin.jvm.internal.o.f((Object)object3, (String)"context");
            object2 = var8_7;
            if (object != null) {
                object2 = ((DynamicIslandBaseContentView)((Object)object)).getUserId();
            }
            object = ((DynamicIslandUtils)object5).getAppIcon((Context)object3, (String)object4, (Integer)object2);
        }
        imageView.setImageDrawable((Drawable)object);
        int n2 = this.context.getResources().getDimensionPixelSize(R.dimen.island_share_view_width);
        n = this.context.getResources().getDimensionPixelSize(R.dimen.island_share_view_height);
        view.measure(n2, n);
        view.layout(0, 0, n2, n);
        return new View.DragShadowBuilder(view, n2, n, this){
            final View $dragView;
            final int $height;
            final int $width;
            final DynamicIslandBaseContentViewController<T> this$0;
            {
                this.$dragView = view;
                this.$width = n2;
                this.$height = n3;
                this.this$0 = dynamicIslandBaseContentViewController;
                super(view);
            }

            public void onDrawShadow(Canvas canvas) {
                kotlin.jvm.internal.o.g((Object)canvas, (String)"canvas");
                this.$dragView.draw(canvas);
            }

            public void onProvideShadowMetrics(Point point, Point point2) {
                kotlin.jvm.internal.o.g((Object)point, (String)"outShadowSize");
                kotlin.jvm.internal.o.g((Object)point2, (String)"outShadowTouchPoint");
                super.onProvideShadowMetrics(point, point2);
                point.set(this.$width, this.$height);
                point2.set(this.$width - (int)this.this$0.getMarginCardRight(), this.$height / 2 - (int)this.this$0.getMarginCardTop());
            }
        };
    }

    private final Intent dragShareIntent(DynamicIslandBaseContentView object, DynamicIslandData object2, ShareData object3, float f2) {
        Object object5 = this.calculateViewPosition((View)object, f2);
        int n = ((Number)object5.a()).intValue();
        int n2 = ((Number)object5.b()).intValue();
        ShareProviderData shareProviderData = DynamicIslandShareData.INSTANCE.getShareProviderData();
        Object var9_9 = null;
        object5 = object2 != null && (object5 = object2.getExtras()) != null ? object5.getString("miui.pkg.name") : null;
        shareProviderData.setPackageName((String)object5);
        Object object6 = object3 != null ? ((ShareData)object3).getShareContent() : null;
        for (String object42 : this.dragShareSplitByLinks(String.valueOf(object6))) {
            if (!o.v((CharSequence)object42, (CharSequence)"http", (boolean)false, (int)2, null)) continue;
            shareProviderData.setShareUrl(object42);
        }
        object6 = object3 != null ? ((ShareData)object3).getContent() : null;
        shareProviderData.setShareMessage((String)object6);
        if (shareProviderData.getShareMessage() == null) {
            object6 = D.a;
            object6 = DynamicIslandUtils.INSTANCE;
            Context context = this.context;
            kotlin.jvm.internal.o.f((Object)context, (String)"context");
            object6 = String.format("\u6765\u81ea%s\u7684\u5206\u4eab", Arrays.copyOf(new Object[]{((DynamicIslandUtils)object6).getAppName(context, (DynamicIslandData)object2)}, 1));
            kotlin.jvm.internal.o.f((Object)object6, (String)"format(...)");
            shareProviderData.setShareMessage((String)object6);
        }
        object6 = object2 != null && (object6 = object2.getExtras()) != null ? object6.getBundle("miui.focus.pics") : null;
        if ((object6 = object6 != null ? (Icon)object6.getParcelable("miui_media_album_icon") : null) != null) {
            DynamicIslandShareUtils dynamicIslandShareUtils = DynamicIslandShareUtils.INSTANCE;
            object5 = this.context;
            kotlin.jvm.internal.o.f((Object)object5, (String)"context");
            shareProviderData.setShareIconByteArray(dynamicIslandShareUtils.iconToByteArrayAndCompress((Icon)object6, (Context)object5));
        } else {
            DynamicIslandShareUtils dynamicIslandShareUtils = DynamicIslandShareUtils.INSTANCE;
            DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
            Context context = this.context;
            kotlin.jvm.internal.o.f((Object)context, (String)"context");
            object6 = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getUserId() : null;
            object5 = dynamicIslandShareUtils.drawableToBitmap(dynamicIslandUtils.getAppIcon(context, (String)object5, (Integer)object6));
            object5 = object5 != null ? (Object)dynamicIslandShareUtils.bitmapToByteArray((Bitmap)object5) : null;
            shareProviderData.setShareIconByteArray((byte[])object5);
        }
        object5 = DynamicIslandUtils.INSTANCE;
        object6 = this.context;
        kotlin.jvm.internal.o.f((Object)object6, (String)"context");
        object5 = object5.getAppName((Context)object6, (DynamicIslandData)object2);
        object2 = object3 != null ? ((ShareData)object3).getTitle() : null;
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("\u3010");
        ((StringBuilder)object3).append((String)object5);
        ((StringBuilder)object3).append("\u3011 ");
        ((StringBuilder)object3).append((String)object2);
        shareProviderData.setTitle(((StringBuilder)object3).toString());
        shareProviderData.setValue(0);
        object3 = new Bundle();
        if (shareProviderData.getShareUrl() != null && this.isProviderAccessible) {
            object2 = var9_9;
            if (object != null) {
                object = ((DynamicIslandBaseContentView)((Object)object)).getDynamicIslandEventCoordinator();
                object2 = var9_9;
                if (object != null) {
                    object = ((DynamicIslandEventCoordinator)object).getWindowView();
                    object2 = var9_9;
                    if (object != null) {
                        object = ((DynamicIslandWindowView)((Object)object)).getWindowViewController();
                        object2 = var9_9;
                        if (object != null) {
                            object2 = ((DynamicIslandWindowViewController)object).getHyperDropInfoNotifierService();
                        }
                    }
                }
            }
            object3.putBinder("IHyperDropInfoNotifier", (IBinder)object2);
            Log.e((String)TAG, (String)"Call fw to determine if the page is WX and send the provider.");
        }
        object = new Intent();
        object.putExtra("centerX", n);
        object.putExtra("centerY", n2);
        object.putExtra("isMainIslandDrag", this.clickIsBigLand);
        object.putExtras((Bundle)object3);
        return object;
    }

    private final List<String> dragShareSplitByLinks(String object) {
        Object object2 = new e("(?=https?://\\S+)").b((CharSequence)object, 0);
        object = new ArrayList();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            Object e2 = object2.next();
            if (n.n((CharSequence)((String)e2))) continue;
            object.add(e2);
        }
        return object;
    }

    public final void destroy() {
        this.disposables.dispose();
    }

    public final DisposableHandles getDisposables$miui_dynamicisland_release() {
        return this.disposables;
    }

    public final IslandTemplateFactory getIslandTemplateFactory() {
        return this.islandTemplateFactory;
    }

    public final float getMarginCardRight() {
        return this.marginCardRight;
    }

    public final float getMarginCardTop() {
        return this.marginCardTop;
    }

    public final E getScope() {
        return this.scope;
    }

    public final T getView() {
        return this.view;
    }

    public final WorkBenchModeRepository getWorkBenchModeState() {
        return this.workBenchModeState;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void onLongPressed(DynamicIslandBaseContentView object, DynamicIslandData object2, float f2) {
        boolean bl;
        Object object3;
        Object object4;
        Object object5;
        block13: {
            Object var9_6;
            block15: {
                block14: {
                    block12: {
                        block11: {
                            void var8_13;
                            I i2;
                            Log.d((String)"DynamicIslandContentView", (String)"onLongPressed");
                            var9_6 = null;
                            if (object != null && (object5 = ((DynamicIslandBaseContentView)((Object)object)).getDynamicIslandEventCoordinator()) != null) {
                                DynamicIslandEventCoordinator.dispatchEvent$default((DynamicIslandEventCoordinator)object5, DynamicIslandEvent.IslandLongPressed.INSTANCE, null, 2, null);
                            }
                            object5 = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getTemplate() : null;
                            object4 = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getViewModel() : null;
                            object3 = object != null && (object3 = ((DynamicIslandBaseContentView)((Object)object)).getDynamicIslandEventCoordinator()) != null && (object3 = ((DynamicIslandEventCoordinator)object3).getWindowView()) != null && (object3 = ((DynamicIslandWindowView)((Object)object3)).getWindowViewController()) != null && (object3 = ((DynamicIslandWindowViewController)object3).getWindowState()) != null && (object3 = ((DynamicIslandWindowState)object3).getMiPlayShow()) != null ? (Boolean)object3.getValue() : null;
                            if (object4 != null && (i2 = ((DynamicIslandViewModel)object4).getState()) != null) {
                                DynamicIslandState dynamicIslandState = (DynamicIslandState)i2.getValue();
                            } else {
                                Object var8_12 = null;
                            }
                            if (var8_13 instanceof DynamicIslandState.Expanded || object5 == null || kotlin.jvm.internal.o.c((Object)object3, (Object)Boolean.TRUE)) return;
                            object3 = ((IslandTemplate)object5).getShareData();
                            if (object3 == null) break block11;
                            object3 = ((ShareData)object3).getShareContent();
                            break block12;
                        }
                        object3 = null;
                    }
                    if (!TextUtils.isEmpty((CharSequence)object3)) break block13;
                    object5 = ((DynamicIslandBaseContentView)((Object)object)).getAnimatorDelegate();
                    if (object5 == null) return;
                    object2 = ((DynamicIslandBaseContentView)((Object)object)).getDynamicIslandEventCoordinator();
                    if (object2 == null) break block14;
                    object2 = ((DynamicIslandEventCoordinator)object2).getBigIsLandAndSmallIsLandList();
                    break block15;
                }
                object2 = null;
            }
            try {
                ((DynamicIslandAnimationDelegate)object5).isLandDragShake((List<DynamicIslandContentView>)object2);
                return;
            }
            catch (Exception exception) {
                DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = ((DynamicIslandBaseContentView)((Object)object)).getAnimatorDelegate();
                if (dynamicIslandAnimationDelegate == null) return;
                object5 = ((DynamicIslandBaseContentView)((Object)object)).getDynamicIslandEventCoordinator();
                object = var9_6;
                if (object5 != null) {
                    object = ((DynamicIslandEventCoordinator)object5).getBigIsLandAndSmallIsLandList();
                }
                dynamicIslandAnimationDelegate.isLandDragShake((List<DynamicIslandContentView>)object);
            }
        }
        object4 = object4 != null && (object4 = ((DynamicIslandViewModel)object4).getState()) != null ? (DynamicIslandState)object4.getValue() : null;
        this.clickIsBigLand = bl = object4 instanceof DynamicIslandState.BigIsland;
        object4 = bl ? "BigIsland" : "SmallIsland";
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("onLongPressed: dragDynamicIsLandIs");
        ((StringBuilder)object3).append((String)object4);
        Log.d((String)"DynamicIslandContentView", (String)((StringBuilder)object3).toString());
        object4 = this.dragShareCard((DynamicIslandBaseContentView)((Object)object), (DynamicIslandData)object2, ((IslandTemplate)object5).getShareData());
        object3 = this.dragShareIntent((DynamicIslandBaseContentView)((Object)object), (DynamicIslandData)object2, ((IslandTemplate)object5).getShareData(), f2);
        object2 = ((IslandTemplate)object5).getShareData();
        object2 = object2 != null ? ((ShareData)object2).getShareContent() : null;
        object2 = new ClipData.Item((CharSequence)object2, (Intent)object3, null);
        object.startDragAndDrop(new ClipData((CharSequence)"Label", new String[]{"text/plain"}, (ClipData.Item)object2), (View.DragShadowBuilder)object4, null, this.dragShareAddFlags());
        return;
    }

    public final void setMarginCardRight(float f2) {
        this.marginCardRight = f2;
    }

    public final void setMarginCardTop(float f2) {
        this.marginCardTop = f2;
    }

    public final void setWorkBenchModeState(WorkBenchModeRepository workBenchModeRepository) {
        kotlin.jvm.internal.o.g((Object)workBenchModeRepository, (String)"<set-?>");
        this.workBenchModeState = workBenchModeRepository;
    }
}
