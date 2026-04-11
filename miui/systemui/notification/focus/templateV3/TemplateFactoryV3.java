/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  K0.g
 *  L0.c
 *  U.d
 *  U0.o
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.drawable.Icon
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 *  android.util.Log
 *  android.widget.RemoteViews
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
 *  f1.E
 *  f1.f
 *  kotlin.jvm.internal.o
 *  miui.systemui.coroutines.Dispatchers
 *  miui.systemui.notification.NotificationUtil
 *  miui.systemui.util.FocusNotificationUtil
 *  miui.systemui.util.concurrency.ConcurrencyModule
 *  o1.a
 *  o1.c
 *  org.json.JSONObject
 */
package miui.systemui.notification.focus.templateV3;

import G0.k;
import G0.s;
import K0.g;
import U.d;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;
import com.android.systemui.miui.notification.R;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import f1.E;
import f1.f;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.o;
import miui.systemui.coroutines.Dispatchers;
import miui.systemui.notification.NotificationUtil;
import miui.systemui.notification.focus.FocusIconCache;
import miui.systemui.notification.focus.FocusNotifUtils;
import miui.systemui.notification.focus.FocusParamsException;
import miui.systemui.notification.focus.InflateAndAuthCallBack;
import miui.systemui.notification.focus.model.AnimTextInfo;
import miui.systemui.notification.focus.model.BaseInfo;
import miui.systemui.notification.focus.model.BgInfo;
import miui.systemui.notification.focus.model.ChatInfo;
import miui.systemui.notification.focus.model.CoverInfo;
import miui.systemui.notification.focus.model.HighlightInfo;
import miui.systemui.notification.focus.model.HintInfo;
import miui.systemui.notification.focus.model.PicInfo;
import miui.systemui.notification.focus.model.ProgressInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.templateV3.TemplateBuilderV3;
import miui.systemui.notification.focus.templateV3.TemplateDecoBuilderV3;
import miui.systemui.notification.focus.templateV3.TemplateDecoLandBuilderV3;
import miui.systemui.notification.focus.templateV3.TemplateTinyBuilderV3;
import miui.systemui.util.FocusNotificationUtil;
import miui.systemui.util.concurrency.ConcurrencyModule;
import o1.a;
import o1.c;
import org.json.JSONObject;

public final class TemplateFactoryV3 {
    private static final String AREA_A = "area_a";
    private static final String AREA_C = "area_c";
    private static final String AREA_D = "area_d";
    private static final String AREA_E = "area_e";
    public static final Companion Companion = new Object(null){
        {
            this();
        }

        public final boolean isBgPicDownloadFailStatic(Template object, StatusBarNotification object2) {
            boolean bl;
            block10: {
                block9: {
                    Object var7_5;
                    BgInfo bgInfo;
                    Bundle bundle;
                    block8: {
                        String string;
                        block7: {
                            o.g((Object)object, (String)"template");
                            o.g((Object)object2, (String)"sbn");
                            bundle = object2.getNotification().extras.getBundle("miui.focus.pics");
                            bgInfo = ((Template)object).getBgInfo();
                            var7_5 = null;
                            string = bgInfo != null ? bgInfo.getPicBg() : null;
                            if (bundle == null) break block7;
                            Icon icon = (Icon)bundle.getParcelable(string);
                            bgInfo = icon;
                            if (icon != null) break block8;
                        }
                        bgInfo = (object2 = object2.getKey()) != null ? FocusIconCache.INSTANCE.get((String)object2, string) : null;
                    }
                    if (bundle == null) break block9;
                    object2 = ((Template)object).getBgInfo();
                    object = var7_5;
                    if (object2 != null) {
                        object = ((BgInfo)object2).getPicBg();
                    }
                    boolean bl2 = bundle.containsKey((String)object);
                    bl = true;
                    if (bl2 && bgInfo == null) break block10;
                }
                bl = false;
            }
            return bl;
        }
    };
    private static final String TAG = "TemplateFactory";
    private final Map<String, TemplateDecoLandBuilderV3> builderDecoLandMap;
    private final Map<String, TemplateDecoBuilderV3> builderDecoMap;
    private final Map<String, TemplateBuilderV3> builderMap;
    private final Map<String, TemplateTinyBuilderV3> builderTinyMap;
    private final FocusNotifUtils focusNotifUtils;
    private boolean isFlipDevice;
    private final ConcurrentHashMap<String, a> keyLocks;
    private final TemplateBuilderV3.Factory templateBuilderV3Factory;
    private final TemplateDecoBuilderV3.Factory templateDecoBuilderV3Factory;
    private final TemplateDecoLandBuilderV3.Factory templateDecoLandBuilderV3Factory;
    private final Map<String, Template> templateMap;
    private final TemplateTinyBuilderV3.Factory templateTinyBuilderV3Factory;

    public TemplateFactoryV3(FocusNotifUtils focusNotifUtils, TemplateBuilderV3.Factory factory, TemplateDecoBuilderV3.Factory factory2, TemplateDecoLandBuilderV3.Factory factory3, TemplateTinyBuilderV3.Factory factory4) {
        o.g((Object)focusNotifUtils, (String)"focusNotifUtils");
        o.g((Object)factory, (String)"templateBuilderV3Factory");
        o.g((Object)factory2, (String)"templateDecoBuilderV3Factory");
        o.g((Object)factory3, (String)"templateDecoLandBuilderV3Factory");
        o.g((Object)factory4, (String)"templateTinyBuilderV3Factory");
        this.focusNotifUtils = focusNotifUtils;
        this.templateBuilderV3Factory = factory;
        this.templateDecoBuilderV3Factory = factory2;
        this.templateDecoLandBuilderV3Factory = factory3;
        this.templateTinyBuilderV3Factory = factory4;
        this.templateMap = new LinkedHashMap<String, Template>();
        this.builderMap = new LinkedHashMap<String, TemplateBuilderV3>();
        this.builderTinyMap = new LinkedHashMap<String, TemplateTinyBuilderV3>();
        this.builderDecoMap = new LinkedHashMap<String, TemplateDecoBuilderV3>();
        this.builderDecoLandMap = new LinkedHashMap<String, TemplateDecoLandBuilderV3>();
        this.keyLocks = new ConcurrentHashMap();
    }

    public static final /* synthetic */ ConcurrentHashMap access$getKeyLocks$p(TemplateFactoryV3 templateFactoryV3) {
        return templateFactoryV3.keyLocks;
    }

    public static final /* synthetic */ boolean access$isBgPicDownloadFail(TemplateFactoryV3 templateFactoryV3, Template template, StatusBarNotification statusBarNotification) {
        return templateFactoryV3.isBgPicDownloadFail(template, statusBarNotification);
    }

    public static final /* synthetic */ Object access$resetErrorNotification(TemplateFactoryV3 templateFactoryV3, FocusNotificationContent focusNotificationContent, StatusBarNotification statusBarNotification, InflateAndAuthCallBack inflateAndAuthCallBack, K0.d d2) {
        return templateFactoryV3.resetErrorNotification(focusNotificationContent, statusBarNotification, inflateAndAuthCallBack, d2);
    }

    private final void checkAreaA(StatusBarNotification statusBarNotification, Template template) {
        if (o.c((Object)TemplateFactoryV3.chooseModule$default(this, template, AREA_A, null, 4, null), (Object)"")) {
            Log.d((String)"FocusPlugin", (String)"areaAModule is empty");
            statusBarNotification.getNotification().extras.putBoolean("show_notification", false);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final String chooseDecoModule(Template object, String object2) {
        String string;
        block25: {
            int n = ((String)object2).hashCode();
            string = "";
            switch (n) {
                default: {
                    return "";
                }
                case -1409553101: {
                    if (!((String)object2).equals(AREA_E)) return "";
                    if ((object = ((Template)object).getPicInfo()) == null) return "";
                    if (((PicInfo)object).getType() == null) {
                        NotificationUtil.debugLog((String)"FocusPlugin", (String)"picInfo type error");
                        return "";
                    }
                    if ((object = ((PicInfo)object).getType()) == null) return "";
                    if ((Integer)object != 1) return "";
                    return "moduleMark1";
                }
                case -1409553102: {
                    if (!((String)object2).equals(AREA_D)) return "";
                    if (((Template)object).getTextButton() != null) {
                        return "moduleButton4";
                    }
                    if (((Template)object).getHighlightInfoV3() != null) {
                        return "moduleButton5";
                    }
                    if (((Template)object).getMultiProgressInfo() != null) {
                        return "moduleMultiProgress";
                    }
                    object2 = ((Template)object).getProgressInfo();
                    object = ((Template)object).getHintInfo();
                    if (object2 != null) {
                        ((ProgressInfo)object2).getProgress();
                        if (((ProgressInfo)object2).getProgress() >= 0 && ((ProgressInfo)object2).getColorProgress() != null) {
                            if (!TextUtils.isEmpty((CharSequence)((ProgressInfo)object2).getColorProgress())) return "moduleProgress";
                        }
                        NotificationUtil.debugLog((String)"FocusPlugin", (String)"progressInfo param error");
                        return "";
                    }
                    if (object == null) return "";
                    if (((HintInfo)object).getType() == null) {
                        NotificationUtil.debugLog((String)"FocusPlugin", (String)"hintActionInfo type error");
                        return "";
                    }
                    object2 = ((HintInfo)object).getType();
                    if (object2 != null && (Integer)object2 == 2) {
                        if (!TextUtils.isEmpty((CharSequence)((TextAndColorInfo)object).getContent())) return "moduleButton2";
                        NotificationUtil.debugLog((String)"FocusPlugin", (String)"hintActionInfo content error");
                        return "";
                    }
                    object2 = ((HintInfo)object).getType();
                    if (object2 == null) return "";
                    if ((Integer)object2 != 1) return "";
                    if (!TextUtils.isEmpty((CharSequence)((TextAndColorInfo)object).getTitle())) return "moduleButton3";
                    NotificationUtil.debugLog((String)"FocusPlugin", (String)"hintActionInfo title error");
                    return "";
                }
                case -1409553103: {
                    if (!((String)object2).equals(AREA_C)) return "";
                    if (((Template)object).getActions() != null) {
                        return "moduleButton1";
                    }
                    object2 = ((Template)object).getPicInfo();
                    if (object2 == null) return "";
                    if (((PicInfo)object2).getType() == null) {
                        NotificationUtil.debugLog((String)"FocusPlugin", (String)"picInfo type error");
                        return "";
                    }
                    object = ((PicInfo)object2).getType();
                    if (object != null && (Integer)object == 5) {
                        return "MODULE_MARK_TEXT_IMAGE";
                    }
                    if (object != null && (Integer)object == 4) {
                        if (((PicInfo)object2).getActionInfo() != null) return "MODULE_MARK_4";
                        NotificationUtil.debugLog((String)"FocusPlugin", (String)"picInfo actionInfo error");
                        return "";
                    }
                    if (object != null && (Integer)object == 3) {
                        if (((PicInfo)object2).getPic() != null) return "moduleMark3";
                        NotificationUtil.debugLog((String)"FocusPlugin", (String)"picInfo 3 pic error");
                        return "";
                    }
                    if (object == null) return "";
                    if ((Integer)object != 2) return "";
                    if (((PicInfo)object2).getPic() != null) return "moduleMark2";
                    NotificationUtil.debugLog((String)"FocusPlugin", (String)"picInfo  2 pic error");
                    return "";
                }
                case -1409553105: {
                    if (((String)object2).equals(AREA_A)) break block25;
                }
            }
            return "";
        }
        object2 = ((Template)object).getBaseInfo();
        HighlightInfo highlightInfo = ((Template)object).getHighlightInfo();
        ChatInfo chatInfo = ((Template)object).getChatInfo();
        AnimTextInfo animTextInfo = ((Template)object).getAnimTextInfo();
        CoverInfo coverInfo = ((Template)object).getCoverInfo();
        object = ((Template)object).getIconTextInfo();
        if (animTextInfo != null) {
            return "moduleAnimationText";
        }
        if (coverInfo != null) {
            return "moduleCover";
        }
        if (object != null) {
            return "moduleNewImageText";
        }
        if (object2 != null) {
            if (((BaseInfo)object2).getType() == null) throw new FocusParamsException("baseInfo param is error");
            if (TextUtils.isEmpty((CharSequence)((TextAndColorInfo)object2).getTitle())) throw new FocusParamsException("baseInfo param is error");
            object = ((BaseInfo)object2).getType();
            if (object == null) return "moduleText1";
            if ((Integer)object != 2) return "moduleText1";
            return "moduleText2";
        }
        if (highlightInfo != null) {
            if (highlightInfo.getType() != 1) return "moduleImageTextHighlightSport";
            return "moduleImageTextHighlightTime";
        }
        if (chatInfo != null) {
            if (TextUtils.isEmpty((CharSequence)chatInfo.getTitle())) throw new FocusParamsException("chatInfo param is error");
            return "moduleImageTextIM";
        }
        Log.e((String)TAG, (String)"has no AREA_A params");
        return string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final String chooseModule(Template object, String object2, Boolean bl) {
        String string;
        block23: {
            int n = ((String)object2).hashCode();
            string = "";
            switch (n) {
                default: {
                    return "";
                }
                case -1409553102: {
                    if (!((String)object2).equals(AREA_D)) return "";
                    if (((Template)object).getTextButton() != null) {
                        return "moduleButton4";
                    }
                    if (((Template)object).getHighlightInfoV3() != null) {
                        return "moduleButton5";
                    }
                    if (((Template)object).getMultiProgressInfo() != null) {
                        return "moduleMultiProgress";
                    }
                    object2 = ((Template)object).getProgressInfo();
                    object = ((Template)object).getHintInfo();
                    if (object2 != null) {
                        ((ProgressInfo)object2).getProgress();
                        if (((ProgressInfo)object2).getProgress() >= 0 && ((ProgressInfo)object2).getColorProgress() != null) {
                            if (!TextUtils.isEmpty((CharSequence)((ProgressInfo)object2).getColorProgress())) return "moduleProgress";
                        }
                        NotificationUtil.debugLog((String)"FocusPlugin", (String)"progressInfo param error");
                        return "";
                    }
                    if (object == null) return "";
                    if (((HintInfo)object).getType() == null) {
                        NotificationUtil.debugLog((String)"FocusPlugin", (String)"hintActionInfo type error");
                        return "";
                    }
                    object2 = ((HintInfo)object).getType();
                    if (object2 != null && (Integer)object2 == 2) {
                        if (!TextUtils.isEmpty((CharSequence)((TextAndColorInfo)object).getContent())) return "moduleButton2";
                        NotificationUtil.debugLog((String)"FocusPlugin", (String)"hintActionInfo content error");
                        return "";
                    }
                    object2 = ((HintInfo)object).getType();
                    if (object2 == null) return "";
                    if ((Integer)object2 != 1) return "";
                    if (!TextUtils.isEmpty((CharSequence)((TextAndColorInfo)object).getTitle())) return "moduleButton3";
                    NotificationUtil.debugLog((String)"FocusPlugin", (String)"hintActionInfo title error");
                    return "";
                }
                case -1409553103: {
                    if (!((String)object2).equals(AREA_C)) return "";
                    if (((Template)object).getActions() != null) {
                        return "moduleButton1";
                    }
                    object2 = ((Template)object).getPicInfo();
                    if (object2 == null) return "";
                    if (((PicInfo)object2).getType() == null) {
                        NotificationUtil.debugLog((String)"FocusPlugin", (String)"picInfo type error");
                        return "";
                    }
                    object = ((PicInfo)object2).getType();
                    if (object != null && (Integer)object == 5) {
                        return "MODULE_MARK_TEXT_IMAGE";
                    }
                    if (object != null && (Integer)object == 4) {
                        if (((PicInfo)object2).getActionInfo() != null) return "MODULE_MARK_4";
                        NotificationUtil.debugLog((String)"FocusPlugin", (String)"picInfo actionInfo error");
                        return "";
                    }
                    if (object != null && (Integer)object == 3) {
                        if (((PicInfo)object2).getPic() != null) return "moduleMark3";
                        NotificationUtil.debugLog((String)"FocusPlugin", (String)"picInfo 3 pic error");
                        return "";
                    }
                    if (object == null) return "moduleMark1";
                    if ((Integer)object != 2) return "moduleMark1";
                    if (((PicInfo)object2).getPic() != null) return "moduleMark2";
                    NotificationUtil.debugLog((String)"FocusPlugin", (String)"picInfo  2 pic error");
                    return "";
                }
                case -1409553105: {
                    if (((String)object2).equals(AREA_A)) break block23;
                }
            }
            return "";
        }
        BaseInfo baseInfo = ((Template)object).getBaseInfo();
        object2 = ((Template)object).getHighlightInfo();
        ChatInfo chatInfo = ((Template)object).getChatInfo();
        AnimTextInfo animTextInfo = ((Template)object).getAnimTextInfo();
        CoverInfo coverInfo = ((Template)object).getCoverInfo();
        object = ((Template)object).getIconTextInfo();
        if (animTextInfo != null) {
            return "moduleAnimationText";
        }
        if (coverInfo != null) {
            return "moduleCover";
        }
        if (object != null) {
            return "moduleNewImageText";
        }
        if (baseInfo != null) {
            if (baseInfo.getType() == null) throw new FocusParamsException("baseInfo param is error");
            if (TextUtils.isEmpty((CharSequence)baseInfo.getTitle())) throw new FocusParamsException("baseInfo param is error");
            object = baseInfo.getType();
            if (object == null) return "moduleText1";
            if ((Integer)object != 2) return "moduleText1";
            return "moduleText2";
        }
        if (object2 != null) {
            if (!o.c((Object)bl, (Object)Boolean.TRUE)) return "moduleImageTextHighlight";
            if (((HighlightInfo)object2).getType() != 1) return "moduleImageTextHighlightSport";
            return "moduleImageTextHighlightTime";
        }
        if (chatInfo != null) {
            if (TextUtils.isEmpty((CharSequence)chatInfo.getTitle())) throw new FocusParamsException("chatInfo param is error");
            return "moduleImageTextIM";
        }
        Log.e((String)TAG, (String)"has no AREA_A params.");
        return string;
    }

    public static /* synthetic */ String chooseModule$default(TemplateFactoryV3 templateFactoryV3, Template template, String string, Boolean bl, int n, Object object) {
        if ((n & 4) != 0) {
            bl = Boolean.FALSE;
        }
        return templateFactoryV3.chooseModule(template, string, bl);
    }

    private final void createDecoLandTemplateView(Template object, StatusBarNotification object2, boolean bl, FocusNotificationContent focusNotificationContent) {
        boolean bl2;
        Object object3;
        boolean bl3;
        String string;
        String string2;
        String string3;
        String string4;
        block10: {
            block9: {
                NotificationUtil.debugLog((String)"FocusPlugin", (String)"createDecoLandTemplateView");
                string4 = this.chooseDecoModule((Template)object, AREA_A);
                if (o.c((Object)string4, (Object)"")) {
                    return;
                }
                string3 = this.chooseDecoModule((Template)object, AREA_C);
                string2 = this.chooseDecoModule((Template)object, AREA_E);
                string = this.chooseDecoModule((Template)object, AREA_D);
                bl3 = this.isSolidBackground((Template)object, (StatusBarNotification)object2);
                object3 = this.builderDecoLandMap.get(object2.getKey());
                if (object3 == null) break block9;
                boolean bl4 = ((TemplateDecoLandBuilderV3)object3).isSameModuleA(string4);
                bl2 = true;
                if (bl4 && ((TemplateDecoLandBuilderV3)object3).isSameModuleC(string3) && ((TemplateDecoLandBuilderV3)object3).isSameModuleD(string) && ((TemplateDecoLandBuilderV3)object3).isSameModuleE(string2)) break block10;
            }
            bl2 = false;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("isSameModule: ");
        ((StringBuilder)object3).append(bl2);
        Log.d((String)"FocusPlugin", (String)((StringBuilder)object3).toString());
        if (!bl2) {
            this.removeDecoLandTemplateView((StatusBarNotification)object2, focusNotificationContent);
        }
        if (this.builderDecoLandMap.containsKey(object2.getKey())) {
            int n;
            int n2;
            object3 = this.builderDecoLandMap.get(object2.getKey());
            if (object3 != null && (object3 = ((TemplateDecoLandBuilderV3)object3).updateModuleView(string4, bl3, (Template)object, (StatusBarNotification)object2)) != null && (object3 = ((TemplateDecoLandBuilderV3)object3).updateModuleView(string3, bl3, (Template)object, (StatusBarNotification)object2)) != null && (object3 = ((TemplateDecoLandBuilderV3)object3).updateModuleView(string2, bl3, (Template)object, (StatusBarNotification)object2)) != null && (object = ((TemplateDecoLandBuilderV3)object3).updateModuleView(string, bl3, (Template)object, (StatusBarNotification)object2)) != null && (object = ((TemplateDecoLandBuilderV3)object).setViewLayoutPadding()) != null && (object = ((TemplateDecoLandBuilderV3)object).setAreaViewVisible(n2 = R.id.area_a, n = !TextUtils.isEmpty((CharSequence)string4) ? 0 : 8)) != null && (object = ((TemplateDecoLandBuilderV3)object).setAreaViewVisible(n2 = R.id.area_c, n = !TextUtils.isEmpty((CharSequence)string3) ? 0 : 8)) != null && (object = ((TemplateDecoLandBuilderV3)object).setAreaViewVisible(n2 = R.id.area_e, n = !TextUtils.isEmpty((CharSequence)string2) ? 0 : 8)) != null && (object = ((TemplateDecoLandBuilderV3)object).setAreaViewVisible(n2 = R.id.area_d, n = !TextUtils.isEmpty((CharSequence)string) ? 0 : 8)) != null) {
                ((TemplateDecoLandBuilderV3)object).buildView(focusNotificationContent);
            }
        } else {
            object3 = this.templateDecoLandBuilderV3Factory.create((Template)object, bl);
            int n = R.id.area_a;
            TemplateDecoLandBuilderV3 templateDecoLandBuilderV3 = ((TemplateDecoLandBuilderV3)object3).addModuleView(n, string4, bl3, (Template)object, (StatusBarNotification)object2);
            int n3 = R.id.area_c;
            templateDecoLandBuilderV3 = templateDecoLandBuilderV3.addModuleView(n3, string3, bl3, (Template)object, (StatusBarNotification)object2);
            int n4 = R.id.area_e;
            templateDecoLandBuilderV3 = templateDecoLandBuilderV3.addModuleView(n4, string2, bl3, (Template)object, (StatusBarNotification)object2);
            int n5 = R.id.area_d;
            object = templateDecoLandBuilderV3.addModuleView(n5, string, bl3, (Template)object, (StatusBarNotification)object2).addModuleView(R.id.area_bg, "moduleBackground", bl3, (Template)object, (StatusBarNotification)object2).setViewLayoutPadding();
            int n6 = !TextUtils.isEmpty((CharSequence)string4) ? 0 : 8;
            object = ((TemplateDecoLandBuilderV3)object).setAreaViewVisible(n, n6);
            n6 = !TextUtils.isEmpty((CharSequence)string3) ? 0 : 8;
            object = ((TemplateDecoLandBuilderV3)object).setAreaViewVisible(n3, n6);
            n6 = !TextUtils.isEmpty((CharSequence)string2) ? 0 : 8;
            object = ((TemplateDecoLandBuilderV3)object).setAreaViewVisible(n4, n6);
            n6 = !TextUtils.isEmpty((CharSequence)string) ? 0 : 8;
            ((TemplateDecoLandBuilderV3)object).setAreaViewVisible(n5, n6).buildView(focusNotificationContent);
            object = this.builderDecoLandMap;
            object2 = object2.getKey();
            o.f((Object)object2, (String)"getKey(...)");
            object.put(object2, object3);
        }
    }

    public static /* synthetic */ void createDecoLandTemplateView$default(TemplateFactoryV3 templateFactoryV3, Template template, StatusBarNotification statusBarNotification, boolean bl, FocusNotificationContent focusNotificationContent, int n, Object object) {
        if ((n & 4) != 0) {
            bl = true;
        }
        templateFactoryV3.createDecoLandTemplateView(template, statusBarNotification, bl, focusNotificationContent);
    }

    private final void createDecoTemplateView(Template object, StatusBarNotification object2, boolean bl, FocusNotificationContent focusNotificationContent) {
        boolean bl2;
        Object object3;
        boolean bl3;
        String string;
        String string2;
        String string3;
        String string4;
        block10: {
            block9: {
                NotificationUtil.debugLog((String)"FocusPlugin", (String)"createDecoTemplateView");
                string4 = this.chooseDecoModule((Template)object, AREA_A);
                if (o.c((Object)string4, (Object)"")) {
                    return;
                }
                string3 = this.chooseDecoModule((Template)object, AREA_C);
                string2 = this.chooseDecoModule((Template)object, AREA_E);
                string = this.chooseDecoModule((Template)object, AREA_D);
                bl3 = this.isSolidBackground((Template)object, (StatusBarNotification)object2);
                object3 = this.builderDecoMap.get(object2.getKey());
                if (object3 == null) break block9;
                boolean bl4 = ((TemplateDecoBuilderV3)object3).isSameModuleA(string4);
                bl2 = true;
                if (bl4 && ((TemplateDecoBuilderV3)object3).isSameModuleC(string3) && ((TemplateDecoBuilderV3)object3).isSameModuleD(string) && ((TemplateDecoBuilderV3)object3).isSameModuleE(string2)) break block10;
            }
            bl2 = false;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("isSameModule: ");
        ((StringBuilder)object3).append(bl2);
        Log.d((String)"FocusPlugin", (String)((StringBuilder)object3).toString());
        if (!bl2) {
            this.removeDecoTemplateView((StatusBarNotification)object2, focusNotificationContent);
        }
        if (this.builderDecoMap.containsKey(object2.getKey())) {
            int n;
            int n2;
            object3 = this.builderDecoMap.get(object2.getKey());
            if (object3 != null && (object3 = ((TemplateDecoBuilderV3)object3).updateModuleView(string4, bl3, (Template)object, (StatusBarNotification)object2)) != null && (object3 = ((TemplateDecoBuilderV3)object3).updateModuleView(string3, bl3, (Template)object, (StatusBarNotification)object2)) != null && (object3 = ((TemplateDecoBuilderV3)object3).updateModuleView(string2, bl3, (Template)object, (StatusBarNotification)object2)) != null && (object = ((TemplateDecoBuilderV3)object3).updateModuleView(string, bl3, (Template)object, (StatusBarNotification)object2)) != null && (object = ((TemplateDecoBuilderV3)object).setAreaTopGravity()) != null && (object = ((TemplateDecoBuilderV3)object).setViewLayoutPadding()) != null && (object = ((TemplateDecoBuilderV3)object).setAreaViewVisible(n2 = R.id.area_a, n = !TextUtils.isEmpty((CharSequence)string4) ? 0 : 8)) != null && (object = ((TemplateDecoBuilderV3)object).setAreaViewVisible(n2 = R.id.area_c, n = !TextUtils.isEmpty((CharSequence)string3) ? 0 : 8)) != null && (object = ((TemplateDecoBuilderV3)object).setAreaViewVisible(n2 = R.id.area_e, n = !TextUtils.isEmpty((CharSequence)string2) ? 0 : 8)) != null && (object = ((TemplateDecoBuilderV3)object).setAreaViewVisible(n2 = R.id.area_d, n = !TextUtils.isEmpty((CharSequence)string) ? 0 : 8)) != null) {
                ((TemplateDecoBuilderV3)object).buildView(focusNotificationContent);
            }
        } else {
            object3 = this.templateDecoBuilderV3Factory.create((Template)object, bl);
            int n = R.id.area_a;
            TemplateDecoBuilderV3 templateDecoBuilderV3 = ((TemplateDecoBuilderV3)object3).addModuleView(n, string4, bl3, (Template)object, (StatusBarNotification)object2);
            int n3 = R.id.area_c;
            templateDecoBuilderV3 = templateDecoBuilderV3.addModuleView(n3, string3, bl3, (Template)object, (StatusBarNotification)object2);
            int n4 = R.id.area_e;
            templateDecoBuilderV3 = templateDecoBuilderV3.addModuleView(n4, string2, bl3, (Template)object, (StatusBarNotification)object2);
            int n5 = R.id.area_d;
            object = templateDecoBuilderV3.addModuleView(n5, string, bl3, (Template)object, (StatusBarNotification)object2).addModuleView(R.id.area_bg, "moduleBackground", bl3, (Template)object, (StatusBarNotification)object2).setAreaTopGravity().setViewLayoutPadding();
            int n6 = !TextUtils.isEmpty((CharSequence)string4) ? 0 : 8;
            object = ((TemplateDecoBuilderV3)object).setAreaViewVisible(n, n6);
            n6 = !TextUtils.isEmpty((CharSequence)string3) ? 0 : 8;
            object = ((TemplateDecoBuilderV3)object).setAreaViewVisible(n3, n6);
            n6 = !TextUtils.isEmpty((CharSequence)string2) ? 0 : 8;
            object = ((TemplateDecoBuilderV3)object).setAreaViewVisible(n4, n6);
            n6 = !TextUtils.isEmpty((CharSequence)string) ? 0 : 8;
            ((TemplateDecoBuilderV3)object).setAreaViewVisible(n5, n6).buildView(focusNotificationContent);
            object = this.builderDecoMap;
            object2 = object2.getKey();
            o.f((Object)object2, (String)"getKey(...)");
            object.put((String)object2, (TemplateDecoBuilderV3)object3);
        }
    }

    public static /* synthetic */ void createDecoTemplateView$default(TemplateFactoryV3 templateFactoryV3, Template template, StatusBarNotification statusBarNotification, boolean bl, FocusNotificationContent focusNotificationContent, int n, Object object) {
        if ((n & 4) != 0) {
            bl = true;
        }
        templateFactoryV3.createDecoTemplateView(template, statusBarNotification, bl, focusNotificationContent);
    }

    private final void createStandardTemplateView(Template object, StatusBarNotification statusBarNotification, boolean bl, FocusNotificationContent focusNotificationContent, InflateAndAuthCallBack inflateAndAuthCallBack) {
        boolean bl2;
        Object object2;
        boolean bl3;
        Object object3;
        Object object4;
        Object object5;
        block11: {
            block10: {
                NotificationUtil.debugLog((String)"FocusPlugin", (String)"createStandardTemplate");
                object5 = TemplateFactoryV3.chooseModule$default(this, (Template)object, AREA_A, null, 4, null);
                if (o.c((Object)object5, (Object)"")) {
                    Log.d((String)"FocusPlugin", (String)"areaAModule is empty");
                    object = statusBarNotification.getKey();
                    o.f((Object)object, (String)"getKey(...)");
                    inflateAndAuthCallBack.onInflateSuccess((String)object, focusNotificationContent);
                    return;
                }
                object4 = TemplateFactoryV3.chooseModule$default(this, (Template)object, AREA_C, null, 4, null);
                object3 = TemplateFactoryV3.chooseModule$default(this, (Template)object, AREA_D, null, 4, null);
                bl3 = this.isSolidBackground((Template)object, statusBarNotification);
                object2 = this.builderMap.get(statusBarNotification.getKey());
                if (object2 == null) break block10;
                boolean bl4 = ((TemplateBuilderV3)object2).isSameModuleA((String)object5, (Template)object);
                bl2 = true;
                if (bl4 && ((TemplateBuilderV3)object2).isSameModuleC((String)object4) && ((TemplateBuilderV3)object2).isSameModuleD((String)object3)) break block11;
            }
            bl2 = false;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("isSameModule: ");
        ((StringBuilder)object2).append(bl2);
        Log.d((String)"FocusPlugin", (String)((StringBuilder)object2).toString());
        if (!bl2 || this.focusNotifUtils.getOS1Template().containsKey(statusBarNotification.getKey())) {
            this.focusNotifUtils.getOS1Template().remove(statusBarNotification.getKey());
            this.removeStandardTemplateView(statusBarNotification, focusNotificationContent);
        }
        if (this.builderMap.containsKey(statusBarNotification.getKey())) {
            int n;
            int n2;
            TemplateBuilderV3 templateBuilderV3 = this.builderMap.get(statusBarNotification.getKey());
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("createStandardTemplateView: ");
            ((StringBuilder)object2).append(templateBuilderV3);
            Log.d((String)"EmptyNotif", (String)((StringBuilder)object2).toString());
            if (templateBuilderV3 != null && (object2 = templateBuilderV3.setAreaViewVisible(n2 = R.id.area_bg, n = !bl3 ? 0 : 8)) != null && (object2 = ((TemplateBuilderV3)object2).setAreaViewVisible(n2 = R.id.area_a, n = !TextUtils.isEmpty((CharSequence)object5) ? 0 : 8)) != null && (object2 = ((TemplateBuilderV3)object2).setAreaViewVisible(n2 = R.id.area_c, n = !TextUtils.isEmpty((CharSequence)object4) ? 0 : 4)) != null) {
                n2 = R.id.area_d;
                n = !TextUtils.isEmpty((CharSequence)object3) ? 0 : 8;
                if ((object2 = ((TemplateBuilderV3)object2).setAreaViewVisible(n2, n)) != null && (object3 = ((TemplateBuilderV3)object2).updateModuleView((String)object3, bl3, (Template)object, statusBarNotification)) != null && (object5 = ((TemplateBuilderV3)object3).updateModuleView((String)object5, bl3, (Template)object, statusBarNotification)) != null && (object4 = ((TemplateBuilderV3)object5).updateModuleView((String)object4, bl3, (Template)object, statusBarNotification)) != null && (object4 = ((TemplateBuilderV3)object4).updateModuleView("moduleBackground", bl3, (Template)object, statusBarNotification)) != null) {
                    ((TemplateBuilderV3)object4).buildView(focusNotificationContent, (Template)object);
                }
            }
        } else {
            object2 = this.templateBuilderV3Factory.create(bl);
            Object object6 = new StringBuilder();
            ((StringBuilder)object6).append("createStandardTemplateView:new ");
            ((StringBuilder)object6).append(object2);
            Log.d((String)"EmptyNotif", (String)((StringBuilder)object6).toString());
            int n = R.id.area_bg;
            int n3 = !bl3 ? 0 : 8;
            object6 = ((TemplateBuilderV3)object2).setAreaViewVisible(n, n3);
            int n4 = R.id.area_a;
            n3 = !TextUtils.isEmpty((CharSequence)object5) ? 0 : 8;
            object6 = ((TemplateBuilderV3)object6).setAreaViewVisible(n4, n3);
            int n5 = R.id.area_c;
            n3 = !TextUtils.isEmpty((CharSequence)object4) ? 0 : 4;
            object6 = ((TemplateBuilderV3)object6).setAreaViewVisible(n5, n3);
            int n6 = R.id.area_d;
            n3 = !TextUtils.isEmpty((CharSequence)object3) ? 0 : 8;
            ((TemplateBuilderV3)object6).setAreaViewVisible(n6, n3).addModuleView(n, "moduleBackground", bl3, (Template)object, statusBarNotification).addModuleView(n6, (String)object3, bl3, (Template)object, statusBarNotification).addModuleView(n5, (String)object4, bl3, (Template)object, statusBarNotification).addModuleView(n4, (String)object5, bl3, (Template)object, statusBarNotification).buildView(focusNotificationContent, (Template)object);
            object4 = this.builderMap;
            object5 = statusBarNotification.getKey();
            o.f((Object)object5, (String)"getKey(...)");
            object4.put(object5, object2);
        }
        object5 = this.templateMap;
        object4 = statusBarNotification.getKey();
        o.f((Object)object4, (String)"getKey(...)");
        object5.put(object4, object);
        object = statusBarNotification.getKey();
        o.f((Object)object, (String)"getKey(...)");
        inflateAndAuthCallBack.onInflateSuccess((String)object, focusNotificationContent);
    }

    public static /* synthetic */ void createStandardTemplateView$default(TemplateFactoryV3 templateFactoryV3, Template template, StatusBarNotification statusBarNotification, boolean bl, FocusNotificationContent focusNotificationContent, InflateAndAuthCallBack inflateAndAuthCallBack, int n, Object object) {
        if ((n & 4) != 0) {
            bl = true;
        }
        templateFactoryV3.createStandardTemplateView(template, statusBarNotification, bl, focusNotificationContent, inflateAndAuthCallBack);
    }

    private final void createTinyTemplateView(Template object, StatusBarNotification object2, boolean bl, FocusNotificationContent focusNotificationContent) {
        NotificationUtil.debugLog((String)"FocusPlugin", (String)"createTinyTemplateView");
        Object object3 = Boolean.TRUE;
        Object object4 = this.chooseModule((Template)object, AREA_A, (Boolean)object3);
        if (o.c((Object)object4, (Object)"")) {
            return;
        }
        Object object5 = this.chooseModule((Template)object, AREA_C, (Boolean)object3);
        object3 = this.chooseModule((Template)object, AREA_D, (Boolean)object3);
        boolean bl2 = this.isSolidBackground((Template)object, (StatusBarNotification)object2);
        Object object6 = this.builderTinyMap.get(object2.getKey());
        boolean bl3 = true;
        boolean bl4 = true;
        int n = 0;
        int n2 = 0;
        boolean bl5 = object6 != null && ((TemplateTinyBuilderV3)object6).isSameModuleA((String)object4) && ((TemplateTinyBuilderV3)object6).isSameModuleC((String)object5) && ((TemplateTinyBuilderV3)object6).isSameModuleD((String)object3);
        object6 = new StringBuilder();
        ((StringBuilder)object6).append("isSameModule: ");
        ((StringBuilder)object6).append(bl5);
        Log.d((String)"FocusPlugin", (String)((StringBuilder)object6).toString());
        if (!bl5) {
            this.removeTinyTemplateView((StatusBarNotification)object2, focusNotificationContent);
        }
        bl5 = this.builderTinyMap.containsKey(object2.getKey());
        int n3 = 4;
        if (bl5) {
            int n4;
            object6 = this.builderTinyMap.get(object2.getKey());
            if (object6 != null && (object6 = ((TemplateTinyBuilderV3)object6).setArecCenterGravity(o.c((Object)object5, (Object)"moduleButton1"))) != null && (object6 = ((TemplateTinyBuilderV3)object6).setAreaCenterGravity(bl = object3.length() == 0 ? bl4 : false)) != null && (object6 = ((TemplateTinyBuilderV3)object6).setAreaViewVisible(n = R.id.area_bg, n4 = !bl2 ? 0 : 8)) != null && (object6 = ((TemplateTinyBuilderV3)object6).setAreaViewVisible(n = R.id.area_a, n4 = !TextUtils.isEmpty((CharSequence)object4) ? 0 : 8)) != null) {
                n4 = R.id.area_c;
                if (!TextUtils.isEmpty((CharSequence)object5)) {
                    n3 = 0;
                }
                if ((object6 = ((TemplateTinyBuilderV3)object6).setAreaViewVisible(n4, n3)) != null) {
                    n4 = R.id.area_d;
                    n3 = !TextUtils.isEmpty((CharSequence)object3) ? n2 : 8;
                    if ((object6 = ((TemplateTinyBuilderV3)object6).setAreaViewVisible(n4, n3)) != null && (object3 = ((TemplateTinyBuilderV3)object6).updateModuleView((String)object3, bl2, (Template)object, (StatusBarNotification)object2)) != null && (object4 = ((TemplateTinyBuilderV3)object3).updateModuleView((String)object4, bl2, (Template)object, (StatusBarNotification)object2)) != null && (object5 = ((TemplateTinyBuilderV3)object4).updateModuleView((String)object5, bl2, (Template)object, (StatusBarNotification)object2)) != null && (object = ((TemplateTinyBuilderV3)object5).updateModuleView("moduleBackground", bl2, (Template)object, (StatusBarNotification)object2)) != null) {
                        ((TemplateTinyBuilderV3)object).buildView(focusNotificationContent);
                    }
                }
            }
        } else {
            object6 = this.templateTinyBuilderV3Factory.create(bl);
            TemplateTinyBuilderV3 templateTinyBuilderV3 = ((TemplateTinyBuilderV3)object6).setArecCenterGravity(o.c((Object)object5, (Object)"moduleButton1"));
            bl = object3.length() == 0 ? bl3 : false;
            templateTinyBuilderV3 = templateTinyBuilderV3.setAreaCenterGravity(bl);
            n2 = R.id.area_bg;
            int n5 = !bl2 ? 0 : 8;
            templateTinyBuilderV3 = templateTinyBuilderV3.setAreaViewVisible(n2, n5);
            int n6 = R.id.area_a;
            n5 = !TextUtils.isEmpty((CharSequence)object4) ? 0 : 8;
            templateTinyBuilderV3 = templateTinyBuilderV3.setAreaViewVisible(n6, n5);
            n5 = R.id.area_c;
            if (!TextUtils.isEmpty((CharSequence)object5)) {
                n3 = 0;
            }
            templateTinyBuilderV3 = templateTinyBuilderV3.setAreaViewVisible(n5, n3);
            int n7 = R.id.area_d;
            n3 = !TextUtils.isEmpty((CharSequence)object3) ? n : 8;
            templateTinyBuilderV3.setAreaViewVisible(n7, n3).addModuleView(n2, "moduleBackground", bl2, (Template)object, (StatusBarNotification)object2).addModuleView(n7, (String)object3, bl2, (Template)object, (StatusBarNotification)object2).addModuleView(n6, (String)object4, bl2, (Template)object, (StatusBarNotification)object2).addModuleView(n5, (String)object5, bl2, (Template)object, (StatusBarNotification)object2).buildView(focusNotificationContent);
            object = this.builderTinyMap;
            object2 = object2.getKey();
            o.f((Object)object2, (String)"getKey(...)");
            object.put(object2, object6);
        }
    }

    public static /* synthetic */ void createTinyTemplateView$default(TemplateFactoryV3 templateFactoryV3, Template template, StatusBarNotification statusBarNotification, boolean bl, FocusNotificationContent focusNotificationContent, int n, Object object) {
        if ((n & 4) != 0) {
            bl = true;
        }
        templateFactoryV3.createTinyTemplateView(template, statusBarNotification, bl, focusNotificationContent);
    }

    private final Bundle getBitmapBundle(StatusBarNotification statusBarNotification) {
        try {
            statusBarNotification = statusBarNotification.getNotification().extras.getBundle("miui.focus.pics");
        }
        catch (Exception exception) {
            statusBarNotification = null;
        }
        return statusBarNotification;
    }

    private final Icon getIcon(String string, StatusBarNotification object, Bundle object2) {
        block3: {
            block2: {
                if (object2 == null) break block2;
                Icon icon = (Icon)object2.getParcelable(string);
                object2 = icon;
                if (icon != null) break block3;
            }
            object2 = object != null && (object = object.getKey()) != null ? FocusIconCache.INSTANCE.get((String)object, string) : null;
        }
        return object2;
    }

    private final void handleAodAndStatusBar(StatusBarNotification statusBarNotification, Context object, String string, String string2, String string3, String string4, String string5, Bundle bundle) {
        statusBarNotification.getNotification().extras.putString("miui.focus.ticker", string);
        statusBarNotification.getNotification().extras.putString("miui.focus.pic_ticker", string2);
        statusBarNotification.getNotification().extras.putString("miui.focus.pic_ticker_dark", string3);
        string = new RemoteViews(object.getPackageName(), R.layout.focus_notification_template_aod_v2);
        if (string4 != null && !TextUtils.isEmpty((CharSequence)string4)) {
            this.setTextVisibleAndText((RemoteViews)string, string4);
            int n = R.id.focus_aod_icon;
            string.setViewVisibility(n, 0);
            object = bundle != null ? (Icon)bundle.getParcelable(string5) : null;
            if (bundle != null && bundle.containsKey(string5) && object != null) {
                string.setImageViewIcon(n, (Icon)object);
            } else {
                statusBarNotification.getNotification().extras.putInt("miui.focus.aodIconId", n);
            }
            statusBarNotification.getNotification().extras.putParcelable("miui.focus.rvAod", (Parcelable)string);
        }
    }

    private final void handleTimeout(StatusBarNotification statusBarNotification, int n) {
        long l = n < 0 ? 5000L : 60000L * (long)n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("handleTimeout ");
        stringBuilder.append(l);
        NotificationUtil.debugLog((String)"FocusPlugin", (String)stringBuilder.toString());
        statusBarNotification.getNotification().extras.putLong("miui.timeout", l);
    }

    private final boolean isBgPicDownloadFail(Template object, StatusBarNotification statusBarNotification) {
        boolean bl;
        block5: {
            block4: {
                Bundle bundle = this.getBitmapBundle(statusBarNotification);
                Object object2 = ((Template)object).getBgInfo();
                Object var6_5 = null;
                object2 = object2 != null ? ((BgInfo)object2).getPicBg() : null;
                statusBarNotification = this.getIcon((String)object2, statusBarNotification, bundle);
                if (bundle == null) break block4;
                object2 = ((Template)object).getBgInfo();
                object = var6_5;
                if (object2 != null) {
                    object = ((BgInfo)object2).getPicBg();
                }
                boolean bl2 = bundle.containsKey((String)object);
                bl = true;
                if (bl2 && statusBarNotification == null) break block5;
            }
            bl = false;
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final boolean isSolidBackground(Template object, StatusBarNotification object2) {
        Bundle bundle = this.getBitmapBundle((StatusBarNotification)object2);
        Object object3 = ((Template)object).getBgInfo();
        Object var7_6 = null;
        object3 = object3 != null ? ((BgInfo)object3).getPicBg() : null;
        object3 = this.getIcon((String)object3, (StatusBarNotification)object2, bundle);
        boolean bl = false;
        boolean bl2 = bundle != null && bundle.containsKey((String)(object2 = (object2 = ((Template)object).getBgInfo()) != null ? ((BgInfo)object2).getPicBg() : null)) && object3 == null;
        try {
            object = ((Template)object).getBgInfo();
            object = object != null ? ((BgInfo)object).getColorBg() : null;
            object = Color.parseColor((String)object);
        }
        catch (Exception exception) {
            object = var7_6;
        }
        if (bl2) return true;
        boolean bl3 = bl;
        if (object3 != null) return bl3;
        bl3 = bl;
        if (object != null) return bl3;
        return true;
    }

    private final void removeDecoLandTemplateView(StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        if (this.builderDecoLandMap.containsKey(statusBarNotification.getKey())) {
            TemplateDecoLandBuilderV3 templateDecoLandBuilderV3 = this.builderDecoLandMap.get(statusBarNotification.getKey());
            Object object = this.templateMap.get(statusBarNotification.getKey());
            if (object != null) {
                Object object2 = this.chooseDecoModule((Template)object, AREA_A);
                Object object3 = this.chooseDecoModule((Template)object, AREA_C);
                Object object4 = this.chooseDecoModule((Template)object, AREA_E);
                object = this.chooseDecoModule((Template)object, AREA_D);
                if (templateDecoLandBuilderV3 != null && (object2 = templateDecoLandBuilderV3.removeModuleView((String)object2)) != null && (object3 = ((TemplateDecoLandBuilderV3)object2).removeModuleView((String)object3)) != null && (object4 = ((TemplateDecoLandBuilderV3)object3).removeModuleView((String)object4)) != null && (object4 = ((TemplateDecoLandBuilderV3)object4).removeModuleView((String)object)) != null && (object4 = ((TemplateDecoLandBuilderV3)object4).removeModuleView("moduleBackground")) != null) {
                    ((TemplateDecoLandBuilderV3)object4).removeView(focusNotificationContent);
                }
            }
        }
        this.builderDecoLandMap.remove(statusBarNotification.getKey());
    }

    private final void removeDecoTemplateView(StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        if (this.builderDecoMap.containsKey(statusBarNotification.getKey())) {
            TemplateDecoBuilderV3 templateDecoBuilderV3 = this.builderDecoMap.get(statusBarNotification.getKey());
            Object object = this.templateMap.get(statusBarNotification.getKey());
            if (object != null) {
                String string = this.chooseDecoModule((Template)object, AREA_A);
                Object object2 = this.chooseDecoModule((Template)object, AREA_C);
                Object object3 = this.chooseDecoModule((Template)object, AREA_E);
                object = this.chooseDecoModule((Template)object, AREA_D);
                if (templateDecoBuilderV3 != null && (templateDecoBuilderV3 = templateDecoBuilderV3.removeModuleView(string)) != null && (object2 = templateDecoBuilderV3.removeModuleView((String)object2)) != null && (object3 = ((TemplateDecoBuilderV3)object2).removeModuleView((String)object3)) != null && (object3 = ((TemplateDecoBuilderV3)object3).removeModuleView((String)object)) != null && (object3 = ((TemplateDecoBuilderV3)object3).removeModuleView("moduleBackground")) != null) {
                    ((TemplateDecoBuilderV3)object3).removeView(focusNotificationContent);
                }
            }
        }
        this.builderDecoMap.remove(statusBarNotification.getKey());
    }

    private final void removeStandardTemplateView(StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        if (this.builderMap.containsKey(statusBarNotification.getKey())) {
            TemplateBuilderV3 templateBuilderV3 = this.builderMap.get(statusBarNotification.getKey());
            Object object = this.templateMap.get(statusBarNotification.getKey());
            if (object != null) {
                Object object2 = TemplateFactoryV3.chooseModule$default(this, (Template)object, AREA_A, null, 4, null);
                Object object3 = TemplateFactoryV3.chooseModule$default(this, (Template)object, AREA_C, null, 4, null);
                object = TemplateFactoryV3.chooseModule$default(this, (Template)object, AREA_D, null, 4, null);
                if (templateBuilderV3 != null && (templateBuilderV3 = templateBuilderV3.removeModuleView((String)object)) != null && (object2 = templateBuilderV3.removeModuleView((String)object2)) != null && (object3 = ((TemplateBuilderV3)object2).removeModuleView((String)object3)) != null && (object3 = ((TemplateBuilderV3)object3).removeModuleView("moduleBackground")) != null) {
                    ((TemplateBuilderV3)object3).removeView(focusNotificationContent);
                }
            }
        }
        this.builderMap.remove(statusBarNotification.getKey());
    }

    private final void removeTemplateView(StatusBarNotification statusBarNotification) {
        this.builderMap.remove(statusBarNotification.getKey());
        this.builderTinyMap.remove(statusBarNotification.getKey());
        this.builderDecoMap.remove(statusBarNotification.getKey());
        this.builderDecoLandMap.remove(statusBarNotification.getKey());
    }

    private final void removeTinyTemplateView(StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        if (this.builderTinyMap.containsKey(statusBarNotification.getKey())) {
            TemplateTinyBuilderV3 templateTinyBuilderV3 = this.builderTinyMap.get(statusBarNotification.getKey());
            Object object = this.templateMap.get(statusBarNotification.getKey());
            if (object != null) {
                Boolean bl = Boolean.TRUE;
                Object object2 = this.chooseModule((Template)object, AREA_A, bl);
                Object object3 = this.chooseModule((Template)object, AREA_C, bl);
                object = this.chooseModule((Template)object, AREA_D, bl);
                if (templateTinyBuilderV3 != null && (templateTinyBuilderV3 = templateTinyBuilderV3.removeModuleView((String)object)) != null && (object2 = templateTinyBuilderV3.removeModuleView((String)object2)) != null && (object3 = ((TemplateTinyBuilderV3)object2).removeModuleView((String)object3)) != null && (object3 = ((TemplateTinyBuilderV3)object3).removeModuleView("moduleBackground")) != null) {
                    ((TemplateTinyBuilderV3)object3).removeView(focusNotificationContent);
                }
            }
        }
        this.builderTinyMap.remove(statusBarNotification.getKey());
    }

    private final Object resetErrorNotification(FocusNotificationContent focusNotificationContent, StatusBarNotification statusBarNotification, InflateAndAuthCallBack inflateAndAuthCallBack, K0.d object) {
        focusNotificationContent.reset();
        statusBarNotification.getNotification().extras.putBoolean("miui.focus.isFocus", false);
        object = statusBarNotification.getKey();
        o.f((Object)object, (String)"getKey(...)");
        inflateAndAuthCallBack.onInflateFailed((String)object, focusNotificationContent);
        FocusNotificationUtil.removeFocusNotification((StatusBarNotification)statusBarNotification);
        return s.a;
    }

    private final void setTextVisibleAndText(RemoteViews remoteViews, String string) {
        int n = R.id.focus_aod_title;
        remoteViews.setViewVisibility(n, 0);
        remoteViews.setTextViewText(n, (CharSequence)string);
    }

    private final void wrapNotification(Context object, Template template, StatusBarNotification statusBarNotification) {
        String string;
        Object object2;
        Object object3;
        Object object4 = this.getBitmapBundle(statusBarNotification);
        if (object4 != null && (object3 = object4.keySet()) != null) {
            object2 = object3.iterator();
            while (object2.hasNext()) {
                string = (String)object2.next();
                FocusIconCache focusIconCache = FocusIconCache.INSTANCE;
                object3 = statusBarNotification.getKey();
                o.f((Object)object3, (String)"getKey(...)");
                o.d((Object)string);
                focusIconCache.put((String)object3, string, (Icon)object4.getParcelable(string));
            }
        }
        int n = template.getTimeout() != 0 ? template.getTimeout() : 720;
        string = template.getAodTitle();
        object2 = template.getAodPic();
        this.handleTimeout(statusBarNotification, n);
        object3 = !TextUtils.isEmpty((CharSequence)template.getTicker()) ? template.getTicker() : (NotificationUtil.DEBUG ? "noTicker" : "");
        this.handleAodAndStatusBar(statusBarNotification, (Context)object, (String)object3, template.getTickerPic(), template.getTickerPicDark(), string, (String)object2, (Bundle)object4);
        statusBarNotification.getNotification().extras.putBoolean("show_notification", o.c((Object)template.isShowNotification(), (Object)Boolean.FALSE) ^ true);
        boolean bl = template.getEnableFloat();
        boolean bl2 = template.getUpdatable();
        object4 = template.getIslandFirstFloat();
        object3 = template.getReopen();
        object = object3;
        if (object3 == null) {
            object = "close";
        }
        statusBarNotification.getNotification().extras.putBoolean("miui.customHideBorder", true);
        statusBarNotification.getNotification().extras.putBoolean("miui.enableFloat", bl);
        object3 = statusBarNotification.getNotification().extras;
        boolean bl3 = object4 != null ? (Boolean)object4 : true;
        object3.putBoolean("miui.island.firstFloat", bl3);
        if (bl2) {
            statusBarNotification.getNotification().extras.putString("miui.focus.reopen", (String)object);
            statusBarNotification.getNotification().extras.putBoolean("miui.focus.enableAlert", bl);
            statusBarNotification.getNotification().extras.putBoolean("miui.focus.tickerAutoClose", false);
            statusBarNotification.getNotification().flags &= 0xFFFFFFEF;
        } else {
            statusBarNotification.getNotification().extras.remove("miui.focus.reopen");
            statusBarNotification.getNotification().extras.putBoolean("miui.focus.tickerAutoClose", true);
            statusBarNotification.getNotification().flags |= 0x10;
        }
        statusBarNotification.getNotification().extras.putString("miui.effect.src", template.getOutEffectSrc());
        statusBarNotification.getNotification().extras.putString("miui.effect.color", template.getOutEffectColor());
    }

    public final void clean() {
        this.templateMap.clear();
        this.builderMap.clear();
        this.builderTinyMap.clear();
        this.builderDecoMap.clear();
        this.builderDecoLandMap.clear();
    }

    public final void createTemplate(Context context, Context object, JSONObject jSONObject, StatusBarNotification statusBarNotification, boolean bl, FocusNotificationContent focusNotificationContent, InflateAndAuthCallBack inflateAndAuthCallBack) {
        o.g((Object)context, (String)"context");
        o.g((Object)object, (String)"sysuicontext");
        o.g((Object)jSONObject, (String)"focusParam");
        o.g((Object)statusBarNotification, (String)"sbn");
        o.g((Object)focusNotificationContent, (String)"focusContent");
        o.g((Object)inflateAndAuthCallBack, (String)"inflateCallBack");
        object = (Template)new d().j(jSONObject.toString(), Template.class);
        o.d((Object)object);
        this.wrapNotification(context, (Template)object, statusBarNotification);
        this.checkAreaA(statusBarNotification, (Template)object);
        this.isFlipDevice = bl;
        f.b((E)ConcurrencyModule.INSTANCE.getUiScope(), null, null, (U0.o)new U0.o(this, statusBarNotification, (Template)object, focusNotificationContent, inflateAndAuthCallBack, bl, null){
            final FocusNotificationContent $focusContent;
            final InflateAndAuthCallBack $inflateCallBack;
            final boolean $isFlip;
            final StatusBarNotification $sbn;
            final Template $template;
            int label;
            final TemplateFactoryV3 this$0;
            {
                this.this$0 = templateFactoryV3;
                this.$sbn = statusBarNotification;
                this.$template = template;
                this.$focusContent = focusNotificationContent;
                this.$inflateCallBack = inflateAndAuthCallBack;
                this.$isFlip = bl;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e, K0.d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    return s.a;
                } else {
                    k.b((Object)object);
                    object = Dispatchers.INSTANCE.getIO();
                    U0.o o2 = new U0.o(this.this$0, this.$sbn, this.$template, this.$focusContent, this.$inflateCallBack, this.$isFlip, null){
                        final FocusNotificationContent $focusContent;
                        final InflateAndAuthCallBack $inflateCallBack;
                        final boolean $isFlip;
                        final StatusBarNotification $sbn;
                        final Template $template;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        Object L$5;
                        boolean Z$0;
                        int label;
                        final TemplateFactoryV3 this$0;
                        {
                            this.this$0 = templateFactoryV3;
                            this.$sbn = statusBarNotification;
                            this.$template = template;
                            this.$focusContent = focusNotificationContent;
                            this.$inflateCallBack = inflateAndAuthCallBack;
                            this.$isFlip = bl;
                            super(2, d2);
                        }

                        public final K0.d create(Object object, K0.d d2) {
                            return new /* invalid duplicate definition of identical inner class */;
                        }

                        public final Object invoke(E e, K0.d d2) {
                            return (this.create(e, d2)).invokeSuspend(s.a);
                        }

                        /*
                         * Unable to fully structure code
                         * Enabled aggressive block sorting
                         * Enabled unnecessary exception pruning
                         * Enabled aggressive exception aggregation
                         */
                        public final Object invokeSuspend(Object var1_1) {
                            block29: {
                                block23: {
                                    block28: {
                                        block27: {
                                            block26: {
                                                block24: {
                                                    block25: {
                                                        var10_4 = L0.c.c();
                                                        var2_5 = this.label;
                                                        if (var2_5 != 0) {
                                                            if (var2_5 != 1) {
                                                                if (var2_5 != 2) {
                                                                    if (var2_5 != 3) {
                                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                    }
                                                                    var4_7 = var5_6 = (a)this.L$0;
                                                                    k.b((Object)var1_1);
                                                                    var1_1 = var5_6;
                                                                    break block23;
                                                                }
                                                                var4_7 = var5_6 = (a)this.L$0;
                                                                k.b((Object)var1_1);
                                                                var1_1 = var5_6;
                                                                break block24;
                                                            }
                                                            var3_9 = this.Z$0;
                                                            var5_6 = (InflateAndAuthCallBack)this.L$5;
                                                            var6_10 = (FocusNotificationContent)this.L$4;
                                                            var4_7 = (StatusBarNotification)this.L$3;
                                                            var8_11 = (Template)this.L$2;
                                                            var7_13 /* !! */  = (TemplateFactoryV3)this.L$1;
                                                            var9_14 = (a)this.L$0;
                                                            k.b((Object)var1_1);
                                                            var1_1 = var9_14;
                                                            break block25;
                                                        }
                                                        k.b((Object)var1_1);
                                                        var5_6 = TemplateFactoryV3.access$getKeyLocks$p(this.this$0);
                                                        var6_10 = this.$sbn.getKey();
                                                        var1_1 = var4_7 = var5_6.get(var6_10);
                                                        if (var4_7 == null && (var4_7 = var5_6.putIfAbsent(var6_10, var1_1 = c.b((boolean)false, (int)1, null))) != null) {
                                                            var1_1 = var4_7;
                                                        }
                                                        var1_1 = (a)var1_1;
                                                        try {
                                                            o.d((Object)var1_1);
                                                            var7_13 /* !! */  = this.this$0;
                                                            var8_11 = this.$template;
                                                            var4_7 = this.$sbn;
                                                            var6_10 = this.$focusContent;
                                                            var5_6 = this.$inflateCallBack;
                                                            var3_9 = this.$isFlip;
                                                            this.L$0 = var1_1;
                                                            this.L$1 = var7_13 /* !! */ ;
                                                            this.L$2 = var8_11;
                                                            this.L$3 = var4_7;
                                                            this.L$4 = var6_10;
                                                            this.L$5 = var5_6;
                                                            this.Z$0 = var3_9;
                                                            this.label = 1;
                                                            var9_15 = var1_1.a(null, (K0.d)this);
                                                            if (var9_15 != var10_4) break block25;
                                                            return var10_4;
                                                        }
                                                        catch (Throwable var1_3) {}
                                                    }
                                                    o.d((Object)var8_11);
                                                    if (!TemplateFactoryV3.access$isBgPicDownloadFail(var7_13 /* !! */ , var8_11, (StatusBarNotification)var4_7)) break block26;
                                                    Log.e((String)"FocusPlugin", (String)"createTemplateError: BgPicDownloadFail");
                                                    this.L$0 = var1_1;
                                                    this.L$1 = null;
                                                    this.L$2 = null;
                                                    this.L$3 = null;
                                                    this.L$4 = null;
                                                    this.L$5 = null;
                                                    this.label = 2;
                                                    var4_7 = TemplateFactoryV3.access$resetErrorNotification(var7_13 /* !! */ , (FocusNotificationContent)var6_10, (StatusBarNotification)var4_7, (InflateAndAuthCallBack)var5_6, (K0.d)this);
                                                    if (var4_7 != var10_4) break block24;
                                                    return var10_4;
                                                }
                                                var4_7 = var1_1;
                                                var4_7 = var5_6 = s.a;
                                            }
                                            if (!var3_9) ** GOTO lbl88
                                            try {
                                                TemplateFactoryV3.createTinyTemplateView$default(var7_13 /* !! */ , var8_11, (StatusBarNotification)var4_7, false, (FocusNotificationContent)var6_10, 4, null);
                                                if (var8_11.getHideDeco()) break block27;
                                                TemplateFactoryV3.createDecoTemplateView$default(var7_13 /* !! */ , var8_11, (StatusBarNotification)var4_7, false, (FocusNotificationContent)var6_10, 4, null);
                                                TemplateFactoryV3.createDecoLandTemplateView$default(var7_13 /* !! */ , var8_11, (StatusBarNotification)var4_7, false, (FocusNotificationContent)var6_10, 4, null);
                                            }
                                            catch (Exception var8_12) {
                                                break block28;
                                            }
                                        }
                                        TemplateFactoryV3.createStandardTemplateView$default(var7_13 /* !! */ , var8_11, (StatusBarNotification)var4_7, false, (FocusNotificationContent)var6_10, (InflateAndAuthCallBack)var5_6, 4, null);
                                        var8_11 = ConcurrencyModule.INSTANCE.getUiScope();
                                        var7_13 /* !! */  = new U0.o((InflateAndAuthCallBack)var5_6, (StatusBarNotification)var4_7, (FocusNotificationContent)var6_10, null){
                                            final FocusNotificationContent $focusContent;
                                            final InflateAndAuthCallBack $inflateCallBack;
                                            final StatusBarNotification $sbn;
                                            int label;
                                            {
                                                this.$inflateCallBack = inflateAndAuthCallBack;
                                                this.$sbn = statusBarNotification;
                                                this.$focusContent = focusNotificationContent;
                                                super(2, d2);
                                            }

                                            public final K0.d create(Object object, K0.d d2) {
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public final Object invoke(E e, K0.d d2) {
                                                return (this.create(e, d2)).invokeSuspend(s.a);
                                            }

                                            public final Object invokeSuspend(Object object) {
                                                L0.c.c();
                                                if (this.label == 0) {
                                                    k.b((Object)object);
                                                    InflateAndAuthCallBack inflateAndAuthCallBack = this.$inflateCallBack;
                                                    object = this.$sbn.getKey();
                                                    o.f((Object)object, (String)"getKey(...)");
                                                    inflateAndAuthCallBack.onInflateFinish((String)object, this.$focusContent);
                                                    return s.a;
                                                }
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                        };
                                        f.b((E)var8_11, null, null, (U0.o)var7_13 /* !! */ , (int)3, null);
                                        var1_1.c(null);
                                        TemplateFactoryV3.access$getKeyLocks$p(this.this$0).remove(this.$sbn.getKey());
                                        return s.a;
                                    }
                                    try {
                                        var8_12.printStackTrace();
                                        this.L$0 = var1_1;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.L$4 = null;
                                        this.L$5 = null;
                                        this.label = 3;
                                        var4_7 = TemplateFactoryV3.access$resetErrorNotification(var7_13 /* !! */ , (FocusNotificationContent)var6_10, (StatusBarNotification)var4_7, (InflateAndAuthCallBack)var5_6, (K0.d)this);
                                        if (var4_7 == var10_4) {
                                            return var10_4;
                                        }
                                        break block23;
                                    }
                                    catch (Throwable var4_8) {
                                        var5_6 = var1_1;
                                        var1_1 = var4_8;
                                        var4_7 = var5_6;
                                    }
                                    break block29;
                                }
                                var4_7 = var1_1;
                                try {
                                    var4_7 = var5_6 = s.a;
                                }
                                catch (Throwable var1_2) {
                                    break block29;
                                }
                                var1_1.c(null);
                                TemplateFactoryV3.access$getKeyLocks$p(this.this$0).remove(this.$sbn.getKey());
                                return var4_7;
                            }
                            var4_7.c(null);
                            throw var1_1;
                            TemplateFactoryV3.access$getKeyLocks$p(this.this$0).remove(this.$sbn.getKey());
                            throw var1_3;
                        }
                    };
                    this.label = 1;
                    if (f.c((g)object, (U0.o)o2, (K0.d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)3, null);
        statusBarNotification.getNotification().extras.putBoolean("miui.focus.isFocus", true);
    }

    public final void removeTemplate(StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        o.g((Object)statusBarNotification, (String)"sbn");
        o.g((Object)focusNotificationContent, (String)"focusContent");
        this.removeStandardTemplateView(statusBarNotification, focusNotificationContent);
        if (this.isFlipDevice) {
            this.removeTinyTemplateView(statusBarNotification, focusNotificationContent);
            this.removeDecoTemplateView(statusBarNotification, focusNotificationContent);
            this.removeDecoLandTemplateView(statusBarNotification, focusNotificationContent);
        }
        this.removeTemplateView(statusBarNotification);
    }
}
