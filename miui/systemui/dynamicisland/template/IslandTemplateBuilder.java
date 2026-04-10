/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  K0.g
 *  L0.c
 *  M0.d
 *  U0.o
 *  android.content.Context
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  f1.E
 *  f1.f
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.template;

import G0.k;
import G0.s;
import K0.d;
import K0.g;
import L0.c;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import f1.E;
import f1.f;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.concurrency.dagger.qualifiers.IslandInflateThread;
import miui.systemui.dynamicisland.concurrency.dagger.qualifiers.IslandUiImmediateThread;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.module.IslandModuleViewHolderAdapter;
import miui.systemui.dynamicisland.template.IslandTemplateBuilder;

public final class IslandTemplateBuilder {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "IslandTemplateBuilder";
    private final boolean bigIsland;
    private final Context context;
    private FrameLayout cutout;
    private final DynamicIslandData data;
    private final U0.o emitEvent;
    private final g inflateContext;
    private final boolean isFakeView;
    private final IslandModuleViewHolderAdapter islandAdapter;
    private View islandLayout;
    private String leftModule;
    private String moduleLeft;
    private String moduleRight;
    private String moduleSmall;
    private String rightModule;
    private final ViewGroup root;
    private final g uiImmediate;

    public IslandTemplateBuilder(Context context, @IslandUiImmediateThread g g2, @IslandInflateThread g g3, ViewGroup viewGroup, boolean bl, boolean bl2, U0.o o2, IslandModuleViewHolderAdapter islandModuleViewHolderAdapter, DynamicIslandData dynamicIslandData) {
        o.g((Object)context, (String)"context");
        o.g((Object)g2, (String)"uiImmediate");
        o.g((Object)g3, (String)"inflateContext");
        o.g((Object)viewGroup, (String)"root");
        o.g((Object)o2, (String)"emitEvent");
        o.g((Object)islandModuleViewHolderAdapter, (String)"islandAdapter");
        o.g((Object)dynamicIslandData, (String)"data");
        this.context = context;
        this.uiImmediate = g2;
        this.inflateContext = g3;
        this.root = viewGroup;
        this.bigIsland = bl;
        this.isFakeView = bl2;
        this.emitEvent = o2;
        this.islandAdapter = islandModuleViewHolderAdapter;
        this.data = dynamicIslandData;
        this.moduleLeft = "";
        this.moduleRight = "";
        this.moduleSmall = "";
    }

    public static final /* synthetic */ boolean access$getBigIsland$p(IslandTemplateBuilder islandTemplateBuilder) {
        return islandTemplateBuilder.bigIsland;
    }

    public static final /* synthetic */ DynamicIslandData access$getData$p(IslandTemplateBuilder islandTemplateBuilder) {
        return islandTemplateBuilder.data;
    }

    public static final /* synthetic */ U0.o access$getEmitEvent$p(IslandTemplateBuilder islandTemplateBuilder) {
        return islandTemplateBuilder.emitEvent;
    }

    public static final /* synthetic */ IslandModuleViewHolderAdapter access$getIslandAdapter$p(IslandTemplateBuilder islandTemplateBuilder) {
        return islandTemplateBuilder.islandAdapter;
    }

    public static final /* synthetic */ View access$getIslandLayout$p(IslandTemplateBuilder islandTemplateBuilder) {
        return islandTemplateBuilder.islandLayout;
    }

    public static final /* synthetic */ ViewGroup access$getRoot$p(IslandTemplateBuilder islandTemplateBuilder) {
        return islandTemplateBuilder.root;
    }

    public static final /* synthetic */ boolean access$isFakeView$p(IslandTemplateBuilder islandTemplateBuilder) {
        return islandTemplateBuilder.isFakeView;
    }

    public static final /* synthetic */ void access$setCutout$p(IslandTemplateBuilder islandTemplateBuilder, FrameLayout frameLayout) {
        islandTemplateBuilder.cutout = frameLayout;
    }

    public static final /* synthetic */ void access$setIslandLayout$p(IslandTemplateBuilder islandTemplateBuilder, View view) {
        islandTemplateBuilder.islandLayout = view;
    }

    public final Object addIslandModuleView(int n, String string, IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData, d d2) {
        int n2 = R.id.area_left;
        if (n == n2 || n == R.id.fake_area_left) {
            this.moduleLeft = string;
        } else if (n == R.id.area_right || n == R.id.fake_area_right) {
            this.moduleRight = string;
        } else if (n == R.id.small_container || n == R.id.fake_small_container) {
            this.moduleSmall = string;
        }
        Object object = this.islandLayout;
        object = object != null ? (FrameLayout)object.findViewById(n) : null;
        if (n != n2 && n != R.id.fake_area_left) {
            if (n == R.id.area_right || n == R.id.fake_area_right) {
                this.rightModule = string;
            }
        } else {
            this.leftModule = string;
        }
        return f.c((g)this.uiImmediate, (U0.o)new U0.o(this, islandTemplate, string, (FrameLayout)object, dynamicIslandData, null){
            final DynamicIslandData $data;
            final String $moduleType;
            final IslandTemplate $template;
            final FrameLayout $view;
            int label;
            final IslandTemplateBuilder this$0;
            {
                this.this$0 = islandTemplateBuilder;
                this.$template = islandTemplate;
                this.$moduleType = string;
                this.$view = frameLayout;
                this.$data = dynamicIslandData;
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
                } else {
                    Object object3;
                    k.b((Object)object);
                    IslandModuleViewHolderAdapter islandModuleViewHolderAdapter = IslandTemplateBuilder.access$getIslandAdapter$p(this.this$0);
                    object = this.$template;
                    String string = this.$moduleType;
                    FrameLayout frameLayout = this.$view;
                    o.e((Object)frameLayout, (String)"null cannot be cast to non-null type android.view.ViewGroup");
                    U0.o o2 = IslandTemplateBuilder.access$getEmitEvent$p(this.this$0);
                    DynamicIslandData dynamicIslandData = this.$data;
                    this.label = 1;
                    object = object3 = islandModuleViewHolderAdapter.createModuleViewHolder((IslandTemplate)object, string, (ViewGroup)frameLayout, o2, dynamicIslandData, (d)this);
                    if (object3 == object2) {
                        return object2;
                    }
                }
                View view = (View)object;
                if (view == null) {
                    return this.this$0;
                }
                object = this.$view;
                if (object == null) {
                    object = null;
                }
                if (object != null) {
                    object.addView(view);
                }
                IslandTemplateBuilder.access$getIslandAdapter$p(this.this$0).initView(this.$moduleType);
                IslandTemplateBuilder.access$getIslandAdapter$p(this.this$0).bindData(this.$moduleType, this.$data);
                return this.this$0;
            }
        }, (d)d2);
    }

    public final View buildIslandView() {
        return this.islandLayout;
    }

    public final Context getContext() {
        return this.context;
    }

    public final g getInflateContext() {
        return this.inflateContext;
    }

    public final g getUiImmediate() {
        return this.uiImmediate;
    }

    public final IslandTemplateBuilder hideModuleView() {
        this.islandAdapter.hiddenView(this.leftModule);
        this.islandAdapter.hiddenView(this.rightModule);
        return this;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final Object initLayout(d var1_1) {
        if (!(var1_1 /* !! */  instanceof initLayout.1)) ** GOTO lbl-1000
        var3_2 /* !! */  = var1_1 /* !! */ ;
        var2_3 = var3_2 /* !! */ .label;
        if ((var2_3 & -2147483648) != 0) {
            var3_2 /* !! */ .label = var2_3 + -2147483648;
            var1_1 /* !! */  = var3_2 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 /* !! */  = new M0.d(this, var1_1 /* !! */ ){
                Object L$0;
                int label;
                Object result;
                final IslandTemplateBuilder this$0;
                {
                    this.this$0 = islandTemplateBuilder;
                    super(d2);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.initLayout((d)this);
                }
            };
        }
        var5_4 = var1_1 /* !! */ .result;
        var4_5 = c.c();
        var2_3 = var1_1 /* !! */ .label;
        if (var2_3 == 0) ** GOTO lbl18
        if (var2_3 == 1) {
            var3_2 /* !! */  = (IslandTemplateBuilder)var1_1 /* !! */ .L$0;
            k.b((Object)var5_4);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl18:
            // 1 sources

            k.b((Object)var5_4);
            var5_4 = this.inflateContext;
            var6_6 = new U0.o(this, null){
                int label;
                final IslandTemplateBuilder this$0;
                {
                    this.this$0 = islandTemplateBuilder;
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
                        IslandTemplateBuilder islandTemplateBuilder = this.this$0;
                        if (IslandTemplateBuilder.access$getBigIsland$p(islandTemplateBuilder)) {
                            if (IslandTemplateBuilder.access$isFakeView$p(this.this$0)) {
                                object = DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce(IslandTemplateBuilder.access$getData$p(this.this$0)) ? LayoutInflater.from((Context)this.this$0.getContext()).inflate(R.layout.fake_dynamic_big_island_template_pad, IslandTemplateBuilder.access$getRoot$p(this.this$0), false) : LayoutInflater.from((Context)this.this$0.getContext()).inflate(R.layout.fake_dynamic_big_island_template, IslandTemplateBuilder.access$getRoot$p(this.this$0), false);
                                object.setLayoutDirection(this.this$0.getContext().getResources().getConfiguration().getLayoutDirection());
                            } else {
                                if (DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce(IslandTemplateBuilder.access$getData$p(this.this$0))) {
                                    Log.d((String)"IslandTemplateBuilder", (String)"bigIslandView:isPad 1/2");
                                    object = LayoutInflater.from((Context)this.this$0.getContext()).inflate(R.layout.dynamic_big_island_template_standard_pad, IslandTemplateBuilder.access$getRoot$p(this.this$0), false);
                                } else {
                                    Log.d((String)"IslandTemplateBuilder", (String)"bigIslandView:isPhone or isPad 0");
                                    object = LayoutInflater.from((Context)this.this$0.getContext()).inflate(R.layout.dynamic_big_island_template_standard, IslandTemplateBuilder.access$getRoot$p(this.this$0), false);
                                }
                                object.setLayoutDirection(this.this$0.getContext().getResources().getConfiguration().getLayoutDirection());
                            }
                        } else if (IslandTemplateBuilder.access$isFakeView$p(this.this$0)) {
                            object = LayoutInflater.from((Context)this.this$0.getContext()).inflate(R.layout.fake_dynamic_small_island_template, IslandTemplateBuilder.access$getRoot$p(this.this$0), false);
                            object.setLayoutDirection(this.this$0.getContext().getResources().getConfiguration().getLayoutDirection());
                        } else {
                            object = LayoutInflater.from((Context)this.this$0.getContext()).inflate(R.layout.dynamic_small_island_template_standard, IslandTemplateBuilder.access$getRoot$p(this.this$0), false);
                            object.setLayoutDirection(this.this$0.getContext().getResources().getConfiguration().getLayoutDirection());
                        }
                        IslandTemplateBuilder.access$setIslandLayout$p(islandTemplateBuilder, (View)object);
                        islandTemplateBuilder = this.this$0;
                        boolean bl = IslandTemplateBuilder.access$isFakeView$p(islandTemplateBuilder);
                        object = null;
                        if (bl) {
                            View view = IslandTemplateBuilder.access$getIslandLayout$p(this.this$0);
                            if (view != null) {
                                object = (FrameLayout)view.findViewById(R.id.fake_area_cutout);
                            }
                        } else {
                            View view = IslandTemplateBuilder.access$getIslandLayout$p(this.this$0);
                            if (view != null) {
                                object = (FrameLayout)view.findViewById(R.id.area_cutout);
                            }
                        }
                        IslandTemplateBuilder.access$setCutout$p(islandTemplateBuilder, (FrameLayout)object);
                        return s.a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            };
            var1_1 /* !! */ .L$0 = this;
            var1_1 /* !! */ .label = 1;
            var3_2 /* !! */  = this;
            if (f.c((g)var5_4, (U0.o)var6_6, (d)var1_1 /* !! */ ) == var4_5) {
                return var4_5;
            }
        }
        var3_2 /* !! */ .root.addView(var3_2 /* !! */ .islandLayout);
        return s.a;
    }

    public final boolean isSameModuleLeft(String string) {
        o.g((Object)string, (String)"moduleType");
        return o.c((Object)string, (Object)this.moduleLeft);
    }

    public final boolean isSameModuleRight(String string) {
        o.g((Object)string, (String)"moduleType");
        return o.c((Object)string, (Object)this.moduleRight);
    }

    public final boolean isSameModuleSmall(String string) {
        o.g((Object)string, (String)"moduleType");
        return o.c((Object)string, (Object)this.moduleSmall);
    }

    public final void removeIslandView() {
        this.root.removeAllViews();
    }

    public final IslandTemplateBuilder removeModuleView(String string) {
        o.g((Object)string, (String)"moduleType");
        this.islandAdapter.removeView(string);
        return this;
    }

    public final IslandTemplateBuilder setIslandAreaViewVisible(int n, int n2, E e) {
        o.g((Object)e, (String)"uiScope");
        f.b((E)e, null, null, (U0.o)new U0.o(this, n, n2, null){
            final int $areaId;
            final int $visible;
            int label;
            final IslandTemplateBuilder this$0;
            {
                this.this$0 = islandTemplateBuilder;
                this.$areaId = n;
                this.$visible = n2;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final Object invokeSuspend(Object object) {
                Exception exception2;
                block3: {
                    c.c();
                    if (this.label != 0) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    try {
                        object = IslandTemplateBuilder.access$getIslandLayout$p(this.this$0);
                        object = object != null ? (FrameLayout)object.findViewById(this.$areaId) : null;
                    }
                    catch (Exception exception2) {
                        break block3;
                    }
                    if (object == null) {
                        return s.a;
                    }
                    object.setVisibility(this.$visible);
                    return s.a;
                }
                Log.e((String)"IslandTemplateBuilder", (String)((Object)exception2).toString());
                return s.a;
            }
        }, (int)3, null);
        return this;
    }

    public final IslandTemplateBuilder showModuleView() {
        this.islandAdapter.showView(this.leftModule);
        this.islandAdapter.showView(this.rightModule);
        return this;
    }

    public final void updateCutoutWidth(int n) {
        Object object = this.cutout;
        object = object != null ? object.getLayoutParams() : null;
        if (object != null) {
            object.width = n;
        }
    }

    public final void updateLeftWidth(int n) {
        this.islandAdapter.updateLeftWidth(this.leftModule, n);
    }

    public final IslandTemplateBuilder updateModuleView(String string, IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)string, (String)"moduleType");
        o.g((Object)islandTemplate, (String)"template");
        this.islandAdapter.updateView(string, islandTemplate, dynamicIslandData);
        return this;
    }

    public final void updateRightWidth(int n) {
        this.islandAdapter.updateRightWidth(this.rightModule, n);
    }
}
