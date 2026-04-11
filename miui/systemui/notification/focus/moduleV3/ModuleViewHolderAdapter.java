/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  K0.g
 *  L0.c
 *  U0.o
 *  android.content.Context
 *  android.service.notification.StatusBarNotification
 *  android.util.Log
 *  android.view.ViewGroup
 *  e1.n
 *  f1.E
 *  f1.F
 *  f1.Q
 *  f1.f
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.o$a
 *  miui.systemui.dagger.qualifiers.SystemUI
 */
package miui.systemui.notification.focus.moduleV3;

import G0.k;
import G0.s;
import K0.d;
import K0.g;
import L0.c;
import android.content.Context;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.view.ViewGroup;
import e1.n;
import f1.E;
import f1.F;
import f1.Q;
import f1.f;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.o;
import miui.systemui.dagger.qualifiers.SystemUI;
import miui.systemui.notification.focus.model.HighlightInfo;
import miui.systemui.notification.focus.model.HighlightInfoV3;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.moduleV3.ModuleAnimationTextViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleBackgroundViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleButtonViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleCoverViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandAnimationTextViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandButtonViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandCoverViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandImageTextHighlightViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandImageTextImViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandMarkTextImageViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandMarkViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandNewImageTextViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandProgressViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandTextButton4ViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandTextButton5ViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandTextButtonViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandTextViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoMultiProgressViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortAnimationTextViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortButtonViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortCoverViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortImageTextHighlightViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortImageTextImViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortMarkTextImageViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortMarkViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortNewImageTextViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortProgressViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortTextButton4ViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortTextButton5ViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortTextButtonViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortTextViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleImageTextHighlightViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleImageTextImViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleMarkTextImageViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleMarkViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleMultiProgressViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleNewImageTextViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleProgressViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTextButton4ViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTextButton5ViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTextButtonViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTextViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyAnimationTextViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyBackgroundViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyButtonViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyCoverViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyImageTextHighlightViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyImageTextImViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyMarkTextImageViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyMarkViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyMultiProgressViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyNewImageTextViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyProgressViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyTextButton4ViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyTextButton5ViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyTextButtonViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleTinyTextViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;

public final class ModuleViewHolderAdapter {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "ModuleViewHolderAdapter";
    private final Context context;
    private final Map<String, Template> dataMap;
    private final Map<String, ModuleViewHolder> decoHolders;
    private final Map<String, ModuleViewHolder> decoLandHolders;
    private final Map<String, ModuleViewHolder> holders;
    private E scope;
    private final Context sysuiContext;
    private final Map<String, ModuleViewHolder> tinyHolders;

    public ModuleViewHolderAdapter(Context context, @SystemUI Context context2) {
        o.g((Object)context, (String)"context");
        o.g((Object)context2, (String)"sysuiContext");
        this.context = context;
        this.sysuiContext = context2;
        this.holders = new LinkedHashMap<String, ModuleViewHolder>();
        this.tinyHolders = new LinkedHashMap<String, ModuleViewHolder>();
        this.decoHolders = new LinkedHashMap<String, ModuleViewHolder>();
        this.decoLandHolders = new LinkedHashMap<String, ModuleViewHolder>();
        this.dataMap = new LinkedHashMap<String, Template>();
        this.scope = F.a((g)Q.c());
    }

    public static final /* synthetic */ Map access$getDataMap$p(ModuleViewHolderAdapter moduleViewHolderAdapter) {
        return moduleViewHolderAdapter.dataMap;
    }

    public static final /* synthetic */ Map access$getDecoHolders$p(ModuleViewHolderAdapter moduleViewHolderAdapter) {
        return moduleViewHolderAdapter.decoHolders;
    }

    public static final /* synthetic */ Map access$getDecoLandHolders$p(ModuleViewHolderAdapter moduleViewHolderAdapter) {
        return moduleViewHolderAdapter.decoLandHolders;
    }

    public static final /* synthetic */ Map access$getHolders$p(ModuleViewHolderAdapter moduleViewHolderAdapter) {
        return moduleViewHolderAdapter.holders;
    }

    public static final /* synthetic */ Map access$getTinyHolders$p(ModuleViewHolderAdapter moduleViewHolderAdapter) {
        return moduleViewHolderAdapter.tinyHolders;
    }

    public static final /* synthetic */ void access$hasDarkFields$checkDark(List list, String string, Object ... objectArray) {
        ModuleViewHolderAdapter.hasDarkFields$checkDark(list, string, objectArray);
    }

    private final void checkAnimTextInfoDark(Template template, U0.o o2) {
        this.checkTextAndColorDark("animTextInfo", template.getAnimTextInfo(), o2);
    }

    private final void checkBaseInfoDark(Template template, U0.o o2) {
        this.checkTextAndColorDark("baseInfo", template.getBaseInfo(), o2);
    }

    private final void checkChatInfoDark(Template template, U0.o o2) {
        this.checkTextAndColorDark("chatInfo", template.getChatInfo(), o2);
    }

    private final void checkCoverInfoDark(Template template, U0.o o2) {
        this.checkTextAndColorDark("coverInfo", template.getCoverInfo(), o2);
    }

    private final void checkHighlightInfoDark(Template object, U0.o o2) {
        this.checkTextAndColorDark("highlightInfo", ((Template)object).getHighlightInfo(), o2);
        object = ((Template)object).getHighlightInfo();
        if (object != null) {
            o2.invoke((Object)"highlightInfo.picFunctionDark", (Object)new String[]{((HighlightInfo)object).getPicFunctionDark()});
        }
    }

    private final void checkHighlightInfoV3Dark(Template object, U0.o o2) {
        this.checkTextAndColorDark("highlightInfoV3", ((Template)object).getHighlightInfoV3(), o2);
        object = ((Template)object).getHighlightInfoV3();
        if (object != null) {
            o2.invoke((Object)"highlightInfoV3.highLightTextColorDark", (Object)new String[]{((HighlightInfoV3)object).getHighLightTextColorDark()});
            o2.invoke((Object)"highlightInfoV3.highLightbgColorDark", (Object)new String[]{((HighlightInfoV3)object).getHighLightbgColorDark()});
            o2.invoke((Object)"highlightInfoV3.primaryColorDark", (Object)new String[]{((HighlightInfoV3)object).getPrimaryColorDark()});
            o2.invoke((Object)"highlightInfoV3.secondaryColorDark", (Object)new String[]{((HighlightInfoV3)object).getSecondaryColorDark()});
        }
    }

    private final void checkHintInfoDark(Template template, U0.o o2) {
        this.checkTextAndColorDark("hintInfo", template.getHintInfo(), o2);
    }

    private final void checkIconTextInfoDark(Template template, U0.o o2) {
        this.checkTextAndColorDark("iconTextInfo", template.getIconTextInfo(), o2);
    }

    private final void checkMultiProgressInfoDark(Template template, U0.o o2) {
        this.checkTextAndColorDark("multiProgressInfo", template.getMultiProgressInfo(), o2);
    }

    private final void checkPicInfoDark(Template template, U0.o o2) {
        this.checkTextAndColorDark("picInfo", template.getPicInfo(), o2);
    }

    private final void checkTextAndColorDark(String string, TextAndColorInfo textAndColorInfo, U0.o o2) {
        if (textAndColorInfo != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(".colorTitleDark");
            o2.invoke((Object)stringBuilder.toString(), (Object)new String[]{textAndColorInfo.getColorTitleDark()});
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(".colorContentDark");
            o2.invoke((Object)stringBuilder.toString(), (Object)new String[]{textAndColorInfo.getColorContentDark()});
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(".colorSubTitleDark");
            o2.invoke((Object)stringBuilder.toString(), (Object)new String[]{textAndColorInfo.getColorSubTitleDark()});
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(".colorSubContentDark");
            o2.invoke((Object)stringBuilder.toString(), (Object)new String[]{textAndColorInfo.getColorSubContentDark()});
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(".colorExtraTitleDark");
            o2.invoke((Object)stringBuilder.toString(), (Object)new String[]{textAndColorInfo.getColorExtraTitleDark()});
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(".colorSpecialTitleDark");
            o2.invoke((Object)stringBuilder.toString(), (Object)new String[]{textAndColorInfo.getColorSpecialTitleDark()});
        }
    }

    public static /* synthetic */ void createDecoLandModuleViewHolder$default(ModuleViewHolderAdapter moduleViewHolderAdapter, Template template, String string, boolean bl, ViewGroup viewGroup, int n, Object object) {
        if ((n & 4) != 0) {
            bl = false;
        }
        moduleViewHolderAdapter.createDecoLandModuleViewHolder(template, string, bl, viewGroup);
    }

    public static /* synthetic */ void createDecoModuleViewHolder$default(ModuleViewHolderAdapter moduleViewHolderAdapter, Template template, String string, boolean bl, ViewGroup viewGroup, int n, Object object) {
        if ((n & 4) != 0) {
            bl = false;
        }
        moduleViewHolderAdapter.createDecoModuleViewHolder(template, string, bl, viewGroup);
    }

    public static /* synthetic */ void createModuleViewHolder$default(ModuleViewHolderAdapter moduleViewHolderAdapter, Template template, StatusBarNotification statusBarNotification, String string, boolean bl, boolean bl2, boolean bl3, ViewGroup viewGroup, boolean bl4, boolean bl5, int n, Object object) {
        if ((n & 8) != 0) {
            bl = false;
        }
        if ((n & 0x10) != 0) {
            bl2 = true;
        }
        if ((n & 0x20) != 0) {
            bl3 = false;
        }
        if ((n & 0x80) != 0) {
            bl4 = false;
        }
        if ((n & 0x100) != 0) {
            bl5 = false;
        }
        moduleViewHolderAdapter.createModuleViewHolder(template, statusBarNotification, string, bl, bl2, bl3, viewGroup, bl4, bl5);
    }

    public static /* synthetic */ void createTinyModuleViewHolder$default(ModuleViewHolderAdapter moduleViewHolderAdapter, Template template, String string, boolean bl, ViewGroup viewGroup, String string2, int n, Object object) {
        if ((n & 4) != 0) {
            bl = false;
        }
        moduleViewHolderAdapter.createTinyModuleViewHolder(template, string, bl, viewGroup, string2);
    }

    private final boolean hasDarkFields(Template template) {
        ArrayList<String> arrayList = new ArrayList<String>();
        this.checkBaseInfoDark(template, new U0.o(arrayList){
            final List<String> $darkValues;
            {
                this.$darkValues = list;
                super(2, o.a.class, "checkDark", "hasDarkFields$checkDark(Ljava/util/List;Ljava/lang/String;[Ljava/lang/Object;)V", 0);
            }

            public final void invoke(String string, Object[] objectArray) {
                o.g((Object)string, (String)"p0");
                o.g((Object)objectArray, (String)"p1");
                ModuleViewHolderAdapter.access$hasDarkFields$checkDark(this.$darkValues, string, objectArray);
            }
        });
        this.checkChatInfoDark(template, new U0.o(arrayList){
            final List<String> $darkValues;
            {
                this.$darkValues = list;
                super(2, o.a.class, "checkDark", "hasDarkFields$checkDark(Ljava/util/List;Ljava/lang/String;[Ljava/lang/Object;)V", 0);
            }

            public final void invoke(String string, Object[] objectArray) {
                o.g((Object)string, (String)"p0");
                o.g((Object)objectArray, (String)"p1");
                ModuleViewHolderAdapter.access$hasDarkFields$checkDark(this.$darkValues, string, objectArray);
            }
        });
        this.checkHighlightInfoDark(template, new U0.o(arrayList){
            final List<String> $darkValues;
            {
                this.$darkValues = list;
                super(2, o.a.class, "checkDark", "hasDarkFields$checkDark(Ljava/util/List;Ljava/lang/String;[Ljava/lang/Object;)V", 0);
            }

            public final void invoke(String string, Object[] objectArray) {
                o.g((Object)string, (String)"p0");
                o.g((Object)objectArray, (String)"p1");
                ModuleViewHolderAdapter.access$hasDarkFields$checkDark(this.$darkValues, string, objectArray);
            }
        });
        this.checkHighlightInfoV3Dark(template, new U0.o(arrayList){
            final List<String> $darkValues;
            {
                this.$darkValues = list;
                super(2, o.a.class, "checkDark", "hasDarkFields$checkDark(Ljava/util/List;Ljava/lang/String;[Ljava/lang/Object;)V", 0);
            }

            public final void invoke(String string, Object[] objectArray) {
                o.g((Object)string, (String)"p0");
                o.g((Object)objectArray, (String)"p1");
                ModuleViewHolderAdapter.access$hasDarkFields$checkDark(this.$darkValues, string, objectArray);
            }
        });
        this.checkPicInfoDark(template, new U0.o(arrayList){
            final List<String> $darkValues;
            {
                this.$darkValues = list;
                super(2, o.a.class, "checkDark", "hasDarkFields$checkDark(Ljava/util/List;Ljava/lang/String;[Ljava/lang/Object;)V", 0);
            }

            public final void invoke(String string, Object[] objectArray) {
                o.g((Object)string, (String)"p0");
                o.g((Object)objectArray, (String)"p1");
                ModuleViewHolderAdapter.access$hasDarkFields$checkDark(this.$darkValues, string, objectArray);
            }
        });
        this.checkMultiProgressInfoDark(template, new U0.o(arrayList){
            final List<String> $darkValues;
            {
                this.$darkValues = list;
                super(2, o.a.class, "checkDark", "hasDarkFields$checkDark(Ljava/util/List;Ljava/lang/String;[Ljava/lang/Object;)V", 0);
            }

            public final void invoke(String string, Object[] objectArray) {
                o.g((Object)string, (String)"p0");
                o.g((Object)objectArray, (String)"p1");
                ModuleViewHolderAdapter.access$hasDarkFields$checkDark(this.$darkValues, string, objectArray);
            }
        });
        this.checkHintInfoDark(template, new U0.o(arrayList){
            final List<String> $darkValues;
            {
                this.$darkValues = list;
                super(2, o.a.class, "checkDark", "hasDarkFields$checkDark(Ljava/util/List;Ljava/lang/String;[Ljava/lang/Object;)V", 0);
            }

            public final void invoke(String string, Object[] objectArray) {
                o.g((Object)string, (String)"p0");
                o.g((Object)objectArray, (String)"p1");
                ModuleViewHolderAdapter.access$hasDarkFields$checkDark(this.$darkValues, string, objectArray);
            }
        });
        this.checkAnimTextInfoDark(template, new U0.o(arrayList){
            final List<String> $darkValues;
            {
                this.$darkValues = list;
                super(2, o.a.class, "checkDark", "hasDarkFields$checkDark(Ljava/util/List;Ljava/lang/String;[Ljava/lang/Object;)V", 0);
            }

            public final void invoke(String string, Object[] objectArray) {
                o.g((Object)string, (String)"p0");
                o.g((Object)objectArray, (String)"p1");
                ModuleViewHolderAdapter.access$hasDarkFields$checkDark(this.$darkValues, string, objectArray);
            }
        });
        this.checkCoverInfoDark(template, new U0.o(arrayList){
            final List<String> $darkValues;
            {
                this.$darkValues = list;
                super(2, o.a.class, "checkDark", "hasDarkFields$checkDark(Ljava/util/List;Ljava/lang/String;[Ljava/lang/Object;)V", 0);
            }

            public final void invoke(String string, Object[] objectArray) {
                o.g((Object)string, (String)"p0");
                o.g((Object)objectArray, (String)"p1");
                ModuleViewHolderAdapter.access$hasDarkFields$checkDark(this.$darkValues, string, objectArray);
            }
        });
        this.checkIconTextInfoDark(template, new U0.o(arrayList){
            final List<String> $darkValues;
            {
                this.$darkValues = list;
                super(2, o.a.class, "checkDark", "hasDarkFields$checkDark(Ljava/util/List;Ljava/lang/String;[Ljava/lang/Object;)V", 0);
            }

            public final void invoke(String string, Object[] objectArray) {
                o.g((Object)string, (String)"p0");
                o.g((Object)objectArray, (String)"p1");
                ModuleViewHolderAdapter.access$hasDarkFields$checkDark(this.$darkValues, string, objectArray);
            }
        });
        return arrayList.isEmpty() ^ true;
    }

    private static final void hasDarkFields$checkDark(List<String> list, String string, Object ... objectArray) {
        for (Object object : objectArray) {
            if (object == null || n.n((CharSequence)object.toString())) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(" = ");
            stringBuilder.append(object);
            list.add(stringBuilder.toString());
        }
    }

    public final void bindData(String string, StatusBarNotification statusBarNotification) {
        o.g((Object)string, (String)"moduleType");
        o.g((Object)statusBarNotification, (String)"sbn");
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, string, statusBarNotification, null){
            final String $moduleType;
            final StatusBarNotification $sbn;
            int label;
            final ModuleViewHolderAdapter this$0;
            {
                this.this$0 = moduleViewHolderAdapter;
                this.$moduleType = string;
                this.$sbn = statusBarNotification;
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
                    StatusBarNotification statusBarNotification;
                    Object object2;
                    ModuleViewHolderAdapter moduleViewHolderAdapter;
                    k.b((Object)object);
                    object = (Template)ModuleViewHolderAdapter.access$getDataMap$p(this.this$0).get(this.$moduleType);
                    if (object != null) {
                        moduleViewHolderAdapter = this.this$0;
                        object2 = this.$moduleType;
                        statusBarNotification = this.$sbn;
                        object2 = (ModuleViewHolder)ModuleViewHolderAdapter.access$getHolders$p(moduleViewHolderAdapter).get(object2);
                        if (object2 != null) {
                            ((ModuleViewHolder)object2).bind((Template)object, statusBarNotification);
                        }
                    }
                    if (object != null) {
                        moduleViewHolderAdapter = this.this$0;
                        object2 = this.$moduleType;
                        statusBarNotification = this.$sbn;
                        object2 = (ModuleViewHolder)ModuleViewHolderAdapter.access$getTinyHolders$p(moduleViewHolderAdapter).get(object2);
                        if (object2 != null) {
                            ((ModuleViewHolder)object2).bind((Template)object, statusBarNotification);
                        }
                    }
                    if (object != null) {
                        moduleViewHolderAdapter = this.this$0;
                        object2 = this.$moduleType;
                        statusBarNotification = this.$sbn;
                        object2 = (ModuleViewHolder)ModuleViewHolderAdapter.access$getDecoHolders$p(moduleViewHolderAdapter).get(object2);
                        if (object2 != null) {
                            ((ModuleViewHolder)object2).bind((Template)object, statusBarNotification);
                        }
                    }
                    if (object != null) {
                        moduleViewHolderAdapter = this.this$0;
                        object2 = this.$moduleType;
                        statusBarNotification = this.$sbn;
                        object2 = (ModuleViewHolder)ModuleViewHolderAdapter.access$getDecoLandHolders$p(moduleViewHolderAdapter).get(object2);
                        if (object2 != null) {
                            ((ModuleViewHolder)object2).bind((Template)object, statusBarNotification);
                        }
                    }
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void createDecoLandModuleViewHolder(Template var1_1, String var2_2, boolean var3_3, ViewGroup var4_4) {
        block28: {
            o.g((Object)var1_1, (String)"template");
            o.g((Object)var2_2, (String)"moduleType");
            o.g((Object)var4_4 /* !! */ , (String)"rootView");
            var5_5 = new StringBuilder();
            var5_5.append("createDecoLandModuleViewHolder ");
            var5_5.append(var2_2);
            Log.e((String)"ModuleViewHolderAdapter", (String)var5_5.toString());
            switch (var2_2.hashCode()) {
                default: {
                    ** GOTO lbl-1000
                }
                case 1650049210: {
                    if (!var2_2.equals("moduleBackground") || this.hasDarkFields(var1_1)) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleTinyBackgroundViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block28;
                }
                case 1612310245: {
                    if (var2_2.equals("moduleImageTextHighlightTime")) ** GOTO lbl-1000
                    ** GOTO lbl-1000
                }
                case 618807284: {
                    if (!var2_2.equals("moduleNewImageText")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoLandNewImageTextViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block28;
                }
                case 371824776: {
                    if (!var2_2.equals("MODULE_MARK_TEXT_IMAGE")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoLandMarkTextImageViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3, false);
                    break block28;
                }
                case 345230277: {
                    if (!var2_2.equals("moduleAnimationText")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoLandAnimationTextViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block28;
                }
                case 150577728: {
                    if (!var2_2.equals("moduleImageTextIM")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoLandImageTextImViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block28;
                }
                case -95182663: {
                    if (!var2_2.equals("moduleProgress")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoLandProgressViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block28;
                }
                case -219243403: {
                    if (var2_2.equals("MODULE_MARK_4")) ** GOTO lbl66
                    ** GOTO lbl-1000
                }
                case -600777736: {
                    if (var2_2.equals("moduleImageTextHighlight")) ** GOTO lbl-1000
                    ** GOTO lbl-1000
                }
                case -947909766: {
                    if (!var2_2.equals("moduleMultiProgress")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoMultiProgressViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block28;
                }
                case -1205408359: {
                    if (!var2_2.equals("moduleText2")) ** GOTO lbl-1000
                    ** GOTO lbl56
                }
                case -1205408360: {
                    if (!var2_2.equals("moduleText1")) ** GOTO lbl-1000
lbl56:
                    // 2 sources

                    var4_4 /* !! */  = new ModuleDecoLandTextViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block28;
                }
                case -1211998214: {
                    if (var2_2.equals("moduleMark3")) ** GOTO lbl66
                    ** GOTO lbl-1000
                }
                case -1211998215: {
                    if (var2_2.equals("moduleMark2")) ** GOTO lbl66
                    ** GOTO lbl-1000
                }
                case -1211998216: {
                    if (!var2_2.equals("moduleMark1")) ** GOTO lbl-1000
lbl66:
                    // 4 sources

                    var4_4 /* !! */  = new ModuleDecoLandMarkViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block28;
                }
                case -1220812629: {
                    if (!var2_2.equals("moduleCover")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoLandCoverViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block28;
                }
                case -1391993033: {
                    if (!var2_2.equals("moduleButton5")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoLandTextButton5ViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block28;
                }
                case -1391993034: {
                    if (!var2_2.equals("moduleButton4")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoLandTextButton4ViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block28;
                }
                case -1391993035: {
                    if (var2_2.equals("moduleButton3")) ** GOTO lbl85
                    ** GOTO lbl-1000
                }
                case -1391993036: {
                    if (!var2_2.equals("moduleButton2")) ** GOTO lbl-1000
lbl85:
                    // 2 sources

                    var4_4 /* !! */  = new ModuleDecoLandTextButtonViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block28;
                }
                case -1391993037: {
                    if (!var2_2.equals("moduleButton1")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoLandButtonViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block28;
                }
                case -1558702500: 
            }
            if (!var2_2.equals("moduleImageTextHighlightSport")) lbl-1000:
            // 23 sources

            {
                var4_4 /* !! */  = null;
            } else lbl-1000:
            // 3 sources

            {
                var4_4 /* !! */  = new ModuleDecoLandImageTextHighlightViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
            }
        }
        if (var4_4 /* !! */  != null) {
            var4_4 /* !! */ .initView(var2_2);
        }
        if (var4_4 /* !! */  != null) {
            var4_4 /* !! */ .checkParams(var1_1);
        }
        this.decoLandHolders.put(var2_2, (ModuleViewHolder)var4_4 /* !! */ );
        this.dataMap.put(var2_2, var1_1);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void createDecoModuleViewHolder(Template var1_1, String var2_2, boolean var3_3, ViewGroup var4_4) {
        block27: {
            o.g((Object)var1_1, (String)"template");
            o.g((Object)var2_2, (String)"moduleType");
            o.g((Object)var4_4 /* !! */ , (String)"rootView");
            var5_5 = new StringBuilder();
            var5_5.append("createDecoModuleViewHolder ");
            var5_5.append(var2_2);
            Log.e((String)"ModuleViewHolderAdapter", (String)var5_5.toString());
            switch (var2_2.hashCode()) {
                default: {
                    ** GOTO lbl-1000
                }
                case 1650049210: {
                    if (!var2_2.equals("moduleBackground") || this.hasDarkFields(var1_1)) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleTinyBackgroundViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case 1612310245: {
                    if (var2_2.equals("moduleImageTextHighlightTime")) ** GOTO lbl-1000
                    ** GOTO lbl-1000
                }
                case 618807284: {
                    if (!var2_2.equals("moduleNewImageText")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoPortNewImageTextViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case 371824776: {
                    if (!var2_2.equals("MODULE_MARK_TEXT_IMAGE")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoPortMarkTextImageViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3, false);
                    break block27;
                }
                case 345230277: {
                    if (!var2_2.equals("moduleAnimationText")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoPortAnimationTextViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case 150577728: {
                    if (!var2_2.equals("moduleImageTextIM")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoPortImageTextImViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -95182663: {
                    if (!var2_2.equals("moduleProgress")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoPortProgressViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -219243403: {
                    if (var2_2.equals("MODULE_MARK_4")) ** GOTO lbl63
                    ** GOTO lbl-1000
                }
                case -947909766: {
                    if (!var2_2.equals("moduleMultiProgress")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoMultiProgressViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1205408359: {
                    if (!var2_2.equals("moduleText2")) ** GOTO lbl-1000
                    ** GOTO lbl53
                }
                case -1205408360: {
                    if (!var2_2.equals("moduleText1")) ** GOTO lbl-1000
lbl53:
                    // 2 sources

                    var4_4 /* !! */  = new ModuleDecoPortTextViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1211998214: {
                    if (var2_2.equals("moduleMark3")) ** GOTO lbl63
                    ** GOTO lbl-1000
                }
                case -1211998215: {
                    if (var2_2.equals("moduleMark2")) ** GOTO lbl63
                    ** GOTO lbl-1000
                }
                case -1211998216: {
                    if (!var2_2.equals("moduleMark1")) ** GOTO lbl-1000
lbl63:
                    // 4 sources

                    var4_4 /* !! */  = new ModuleDecoPortMarkViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1220812629: {
                    if (!var2_2.equals("moduleCover")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoPortCoverViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1391993033: {
                    if (!var2_2.equals("moduleButton5")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoPortTextButton5ViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1391993034: {
                    if (!var2_2.equals("moduleButton4")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoPortTextButton4ViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1391993035: {
                    if (var2_2.equals("moduleButton3")) ** GOTO lbl82
                    ** GOTO lbl-1000
                }
                case -1391993036: {
                    if (!var2_2.equals("moduleButton2")) ** GOTO lbl-1000
lbl82:
                    // 2 sources

                    var4_4 /* !! */  = new ModuleDecoPortTextButtonViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1391993037: {
                    if (!var2_2.equals("moduleButton1")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleDecoPortButtonViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1558702500: 
            }
            if (!var2_2.equals("moduleImageTextHighlightSport")) lbl-1000:
            // 22 sources

            {
                var4_4 /* !! */  = null;
            } else lbl-1000:
            // 2 sources

            {
                var4_4 /* !! */  = new ModuleDecoPortImageTextHighlightViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
            }
        }
        if (var4_4 /* !! */  != null) {
            var4_4 /* !! */ .initView(var2_2);
        }
        if (var4_4 /* !! */  != null) {
            var4_4 /* !! */ .checkParams(var1_1);
        }
        this.decoHolders.put(var2_2, (ModuleViewHolder)var4_4 /* !! */ );
        this.dataMap.put(var2_2, var1_1);
    }

    /*
     * Unable to fully structure code
     */
    public final void createModuleViewHolder(Template var1_1, StatusBarNotification var2_2, String var3_3, boolean var4_4, boolean var5_5, boolean var6_6, ViewGroup var7_7, boolean var8_8, boolean var9_9) {
        block26: {
            o.g((Object)var1_1, (String)"template");
            o.g((Object)var2_2, (String)"sbn");
            o.g((Object)var3_3, (String)"moduleType");
            o.g((Object)var7_7, (String)"rootView");
            var2_2 = new StringBuilder();
            var2_2.append("createModuleViewHolder ");
            var2_2.append(var3_3);
            Log.e((String)"ModuleViewHolderAdapter", (String)var2_2.toString());
            switch (var3_3.hashCode()) {
                default: {
                    ** GOTO lbl-1000
                }
                case 1650049210: {
                    if (!var3_3.equals("moduleBackground")) ** GOTO lbl-1000
                    var2_2 = new ModuleBackgroundViewHolder(this.context, this.sysuiContext, var7_7, var4_4);
                    break block26;
                }
                case 618807284: {
                    if (!var3_3.equals("moduleNewImageText")) ** GOTO lbl-1000
                    var2_2 = new ModuleNewImageTextViewHolder(this.context, this.sysuiContext, var7_7, var4_4, var8_8);
                    break block26;
                }
                case 371824776: {
                    if (!var3_3.equals("MODULE_MARK_TEXT_IMAGE")) ** GOTO lbl-1000
                    var2_2 = new ModuleMarkTextImageViewHolder(this.context, this.sysuiContext, var7_7, var4_4, var8_8);
                    break block26;
                }
                case 345230277: {
                    if (!var3_3.equals("moduleAnimationText")) ** GOTO lbl-1000
                    var2_2 = new ModuleAnimationTextViewHolder(this.context, this.sysuiContext, var7_7, var4_4, var8_8, var9_9);
                    break block26;
                }
                case 150577728: {
                    if (!var3_3.equals("moduleImageTextIM")) ** GOTO lbl-1000
                    var2_2 = new ModuleImageTextImViewHolder(this.context, this.sysuiContext, var7_7, var4_4, var8_8);
                    break block26;
                }
                case -95182663: {
                    if (!var3_3.equals("moduleProgress")) ** GOTO lbl-1000
                    var2_2 = new ModuleProgressViewHolder(this.context, this.sysuiContext, var7_7, var4_4, var8_8);
                    break block26;
                }
                case -219243403: {
                    if (var3_3.equals("MODULE_MARK_4")) ** GOTO lbl65
                    ** GOTO lbl-1000
                }
                case -600777736: {
                    if (!var3_3.equals("moduleImageTextHighlight")) ** GOTO lbl-1000
                    var2_2 = new ModuleImageTextHighlightViewHolder(this.context, this.sysuiContext, var7_7, var4_4, var8_8);
                    break block26;
                }
                case -947909766: {
                    if (!var3_3.equals("moduleMultiProgress")) ** GOTO lbl-1000
                    var2_2 = new ModuleMultiProgressViewHolder(this.context, this.sysuiContext, var7_7, var4_4, var8_8);
                    break block26;
                }
                case -1205408359: {
                    if (!var3_3.equals("moduleText2")) ** GOTO lbl-1000
                    ** GOTO lbl55
                }
                case -1205408360: {
                    if (!var3_3.equals("moduleText1")) ** GOTO lbl-1000
lbl55:
                    // 2 sources

                    var2_2 = new ModuleTextViewHolder(this.context, this.sysuiContext, var7_7, var4_4, var8_8);
                    break block26;
                }
                case -1211998214: {
                    if (var3_3.equals("moduleMark3")) ** GOTO lbl65
                    ** GOTO lbl-1000
                }
                case -1211998215: {
                    if (var3_3.equals("moduleMark2")) ** GOTO lbl65
                    ** GOTO lbl-1000
                }
                case -1211998216: {
                    if (!var3_3.equals("moduleMark1")) ** GOTO lbl-1000
lbl65:
                    // 4 sources

                    var2_2 = new ModuleMarkViewHolder(this.context, this.sysuiContext, var7_7, var4_4, var8_8);
                    break block26;
                }
                case -1220812629: {
                    if (!var3_3.equals("moduleCover")) ** GOTO lbl-1000
                    var2_2 = new ModuleCoverViewHolder(this.context, this.sysuiContext, var7_7, var4_4, var8_8);
                    break block26;
                }
                case -1391993033: {
                    if (!var3_3.equals("moduleButton5")) ** GOTO lbl-1000
                    var2_2 = new ModuleTextButton5ViewHolder(this.context, this.sysuiContext, var7_7, var4_4, var8_8);
                    break block26;
                }
                case -1391993034: {
                    if (!var3_3.equals("moduleButton4")) ** GOTO lbl-1000
                    var2_2 = new ModuleTextButton4ViewHolder(this.context, this.sysuiContext, var7_7, var4_4, var8_8);
                    break block26;
                }
                case -1391993035: {
                    if (var3_3.equals("moduleButton3")) ** GOTO lbl84
                    ** GOTO lbl-1000
                }
                case -1391993036: {
                    if (!var3_3.equals("moduleButton2")) ** GOTO lbl-1000
lbl84:
                    // 2 sources

                    var2_2 = new ModuleTextButtonViewHolder(this.context, this.sysuiContext, var7_7, var4_4, var8_8);
                    break block26;
                }
                case -1391993037: 
            }
            if (!var3_3.equals("moduleButton1")) lbl-1000:
            // 21 sources

            {
                var2_2 = null;
            } else {
                var2_2 = new ModuleButtonViewHolder(this.context, this.sysuiContext, var7_7, var4_4, var8_8);
            }
        }
        if (var2_2 != null) {
            var2_2.initView(var3_3);
        }
        if (var2_2 != null) {
            var2_2.checkParams(var1_1);
        }
        this.holders.put(var3_3, (ModuleViewHolder)var2_2);
        this.dataMap.put(var3_3, var1_1);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void createTinyModuleViewHolder(Template var1_1, String var2_2, boolean var3_3, ViewGroup var4_4, String var5_5) {
        block27: {
            o.g((Object)var1_1, (String)"template");
            o.g((Object)var2_2, (String)"moduleType");
            o.g((Object)var4_4 /* !! */ , (String)"rootView");
            o.g((Object)var5_5, (String)"refType");
            var6_6 = new StringBuilder();
            var6_6.append("createTinyModuleViewHolder ");
            var6_6.append(var2_2);
            var6_6.append(" ");
            var6_6.append(var5_5);
            Log.e((String)"ModuleViewHolderAdapter", (String)var6_6.toString());
            switch (var2_2.hashCode()) {
                default: {
                    ** GOTO lbl-1000
                }
                case 1650049210: {
                    if (!var2_2.equals("moduleBackground")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleTinyBackgroundViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case 1612310245: {
                    if (var2_2.equals("moduleImageTextHighlightTime")) ** GOTO lbl-1000
                    ** GOTO lbl-1000
                }
                case 618807284: {
                    if (!var2_2.equals("moduleNewImageText")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleTinyNewImageTextViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case 371824776: {
                    if (!var2_2.equals("MODULE_MARK_TEXT_IMAGE")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleTinyMarkTextImageViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3, false);
                    break block27;
                }
                case 345230277: {
                    if (!var2_2.equals("moduleAnimationText")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleTinyAnimationTextViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3, var5_5);
                    break block27;
                }
                case 150577728: {
                    if (!var2_2.equals("moduleImageTextIM")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleTinyImageTextImViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -95182663: {
                    if (!var2_2.equals("moduleProgress")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleTinyProgressViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -219243403: {
                    if (var2_2.equals("MODULE_MARK_4")) ** GOTO lbl68
                    ** GOTO lbl-1000
                }
                case -947909766: {
                    if (!var2_2.equals("moduleMultiProgress")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleTinyMultiProgressViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1205408359: {
                    if (!var2_2.equals("moduleText2")) ** GOTO lbl-1000
                    ** GOTO lbl58
                }
                case -1205408360: {
                    if (!var2_2.equals("moduleText1")) ** GOTO lbl-1000
lbl58:
                    // 2 sources

                    var4_4 /* !! */  = new ModuleTinyTextViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1211998214: {
                    if (var2_2.equals("moduleMark3")) ** GOTO lbl68
                    ** GOTO lbl-1000
                }
                case -1211998215: {
                    if (var2_2.equals("moduleMark2")) ** GOTO lbl68
                    ** GOTO lbl-1000
                }
                case -1211998216: {
                    if (!var2_2.equals("moduleMark1")) ** GOTO lbl-1000
lbl68:
                    // 4 sources

                    var4_4 /* !! */  = new ModuleTinyMarkViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1220812629: {
                    if (!var2_2.equals("moduleCover")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleTinyCoverViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1391993033: {
                    if (!var2_2.equals("moduleButton5")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleTinyTextButton5ViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1391993034: {
                    if (!var2_2.equals("moduleButton4")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleTinyTextButton4ViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1391993035: {
                    if (var2_2.equals("moduleButton3")) ** GOTO lbl87
                    ** GOTO lbl-1000
                }
                case -1391993036: {
                    if (!var2_2.equals("moduleButton2")) ** GOTO lbl-1000
lbl87:
                    // 2 sources

                    var4_4 /* !! */  = new ModuleTinyTextButtonViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1391993037: {
                    if (!var2_2.equals("moduleButton1")) ** GOTO lbl-1000
                    var4_4 /* !! */  = new ModuleTinyButtonViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
                    break block27;
                }
                case -1558702500: 
            }
            if (!var2_2.equals("moduleImageTextHighlightSport")) lbl-1000:
            // 22 sources

            {
                var4_4 /* !! */  = null;
            } else lbl-1000:
            // 2 sources

            {
                var4_4 /* !! */  = new ModuleTinyImageTextHighlightViewHolder(this.context, this.sysuiContext, var4_4 /* !! */ , var3_3);
            }
        }
        if (var4_4 /* !! */  != null) {
            var4_4 /* !! */ .initView(var2_2);
        }
        if (var4_4 /* !! */  != null) {
            var4_4 /* !! */ .checkParams(var1_1);
        }
        this.tinyHolders.put(var2_2, (ModuleViewHolder)var4_4 /* !! */ );
        this.dataMap.put(var2_2, var1_1);
    }

    public final void removeView(String string) {
        o.g((Object)string, (String)"moduleType");
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, string, null){
            final String $moduleType;
            int label;
            final ModuleViewHolderAdapter this$0;
            {
                this.this$0 = moduleViewHolderAdapter;
                this.$moduleType = string;
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
                    object = (ModuleViewHolder)ModuleViewHolderAdapter.access$getHolders$p(this.this$0).remove(this.$moduleType);
                    if (object != null) {
                        ((ModuleViewHolder)object).onDetach();
                    }
                    if ((object = (ModuleViewHolder)ModuleViewHolderAdapter.access$getTinyHolders$p(this.this$0).remove(this.$moduleType)) != null) {
                        ((ModuleViewHolder)object).onDetach();
                    }
                    if ((object = (ModuleViewHolder)ModuleViewHolderAdapter.access$getDecoHolders$p(this.this$0).remove(this.$moduleType)) != null) {
                        ((ModuleViewHolder)object).onDetach();
                    }
                    if ((object = (ModuleViewHolder)ModuleViewHolderAdapter.access$getDecoLandHolders$p(this.this$0).remove(this.$moduleType)) != null) {
                        ((ModuleViewHolder)object).onDetach();
                    }
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final void updateView(String string, Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)string, (String)"moduleType");
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, string, template, statusBarNotification, null){
            final String $moduleType;
            final StatusBarNotification $sbn;
            final Template $template;
            int label;
            final ModuleViewHolderAdapter this$0;
            {
                this.this$0 = moduleViewHolderAdapter;
                this.$moduleType = string;
                this.$template = template;
                this.$sbn = statusBarNotification;
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
                    ModuleViewHolderAdapter.access$getDataMap$p(this.this$0).put(this.$moduleType, this.$template);
                    object = (ModuleViewHolder)ModuleViewHolderAdapter.access$getHolders$p(this.this$0).get(this.$moduleType);
                    if (object != null) {
                        ((ModuleViewHolder)object).updatePartial(this.$template, this.$sbn);
                    }
                    if ((object = (ModuleViewHolder)ModuleViewHolderAdapter.access$getTinyHolders$p(this.this$0).get(this.$moduleType)) != null) {
                        ((ModuleViewHolder)object).updatePartial(this.$template, this.$sbn);
                    }
                    if ((object = (ModuleViewHolder)ModuleViewHolderAdapter.access$getDecoHolders$p(this.this$0).get(this.$moduleType)) != null) {
                        ((ModuleViewHolder)object).updatePartial(this.$template, this.$sbn);
                    }
                    if ((object = (ModuleViewHolder)ModuleViewHolderAdapter.access$getDecoLandHolders$p(this.this$0).get(this.$moduleType)) != null) {
                        ((ModuleViewHolder)object).updatePartial(this.$template, this.$sbn);
                    }
                    String string = this.$moduleType;
                    int n2 = ModuleViewHolderAdapter.access$getHolders$p(this.this$0).size();
                    object = new StringBuilder();
                    ((StringBuilder)object).append("updateView");
                    ((StringBuilder)object).append(string);
                    ((StringBuilder)object).append(n2);
                    Log.e((String)"ModuleViewHolderAdapter", (String)((StringBuilder)object).toString());
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }
}
