/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Icon
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  android.widget.TextView$BufferType
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  com.mi.widget.view.FlashLightView
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.VideoResUtils
 *  miui.systemui.widget.TextureVideoView
 *  miuix.colorful.texteffect.TextChangeHelper
 *  miuix.colorful.texteffect.TextChangeProcessor
 *  miuix.colorful.texteffect.TimerTextEffectView
 */
package miui.systemui.notification.focus.moduleV3;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.media.MediaPlayer;
import android.net.Uri;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import com.mi.widget.view.FlashLightView;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.FocusParamsException;
import miui.systemui.notification.focus.model.AnimIconInfo;
import miui.systemui.notification.focus.model.BaseInfo;
import miui.systemui.notification.focus.model.IconTextInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.r;
import miui.systemui.notification.focus.moduleV3.s;
import miui.systemui.util.VideoResUtils;
import miui.systemui.widget.TextureVideoView;
import miuix.colorful.texteffect.TextChangeHelper;
import miuix.colorful.texteffect.TextChangeProcessor;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class ModuleNewImageTextViewHolder
extends ModuleViewHolder {
    private View container;
    private TimerTextEffectView focusContent;
    private FlashLightView focusFlashView;
    private View focusIconContainer;
    private ImageView focusProfile;
    private TimerTextEffectView focusSubContent;
    private TimerTextEffectView focusTextDivider;
    private TimerTextEffectView focusTitle;
    private TextureVideoView focusVideoView;
    private final boolean island;

    public ModuleNewImageTextViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl, boolean bl2) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.island = bl2;
    }

    private final void adaptContentViews() {
        int n = this.getTextViewWidth((TextView)this.focusSubContent);
        LinearLayout.LayoutParams layoutParams = null;
        LinearLayout.LayoutParams layoutParams2 = null;
        if (n > 0) {
            Object object = this.focusContent;
            object = object != null ? object.getLayoutParams() : null;
            o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            layoutParams = (LinearLayout.LayoutParams)object;
            TimerTextEffectView timerTextEffectView = this.focusSubContent;
            object = layoutParams2;
            if (timerTextEffectView != null) {
                object = timerTextEffectView.getLayoutParams();
            }
            o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            object = (LinearLayout.LayoutParams)object;
            layoutParams.weight = 0.0f;
            object.weight = 0.0f;
            layoutParams.width = -2;
            object.width = -2;
            layoutParams2 = this.focusContent;
            if (layoutParams2 != null) {
                layoutParams2.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            }
            layoutParams = this.focusSubContent;
            if (layoutParams != null) {
                layoutParams.setLayoutParams((ViewGroup.LayoutParams)object);
            }
        } else {
            Object object = this.focusContent;
            object = object != null ? object.getLayoutParams() : null;
            o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            layoutParams2 = (LinearLayout.LayoutParams)object;
            TimerTextEffectView timerTextEffectView = this.focusSubContent;
            object = layoutParams;
            if (timerTextEffectView != null) {
                object = timerTextEffectView.getLayoutParams();
            }
            o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            object = (LinearLayout.LayoutParams)object;
            layoutParams2.weight = 1.0f;
            object.weight = 1.0f;
            layoutParams2.width = 0;
            object.width = 0;
            layoutParams = this.focusContent;
            if (layoutParams != null) {
                layoutParams.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
            }
            layoutParams = this.focusSubContent;
            if (layoutParams != null) {
                layoutParams.setLayoutParams((ViewGroup.LayoutParams)object);
            }
        }
    }

    public static /* synthetic */ boolean c(ModuleNewImageTextViewHolder moduleNewImageTextViewHolder, MediaPlayer mediaPlayer, int n, int n2) {
        return ModuleNewImageTextViewHolder.showEffects$lambda$4(moduleNewImageTextViewHolder, mediaPlayer, n, n2);
    }

    public static /* synthetic */ void d(ModuleNewImageTextViewHolder moduleNewImageTextViewHolder, MediaPlayer mediaPlayer) {
        ModuleNewImageTextViewHolder.showEffects$lambda$3(moduleNewImageTextViewHolder, mediaPlayer);
    }

    private final void showEffects(Template object, StatusBarNotification statusBarNotification) {
        Object object2 = ((Template)object).getIconTextInfo();
        VideoResUtils videoResUtils = null;
        if (object2 != null && (object2 = ((IconTextInfo)object2).getAnimIconInfo()) != null && (object2 = ((AnimIconInfo)object2).getType()) != null && (Integer)object2 == 1) {
            statusBarNotification = this.focusVideoView;
            if (statusBarNotification != null) {
                statusBarNotification.setVisibility(0);
            }
            statusBarNotification = this.focusProfile;
            if (statusBarNotification != null) {
                statusBarNotification.setVisibility(8);
            }
            statusBarNotification = this.focusFlashView;
            if (statusBarNotification != null) {
                statusBarNotification.setVisibility(8);
            }
            statusBarNotification = this.focusVideoView;
            if (statusBarNotification != null) {
                videoResUtils = VideoResUtils.INSTANCE;
                object = (object = ((Template)object).getIconTextInfo().getAnimIconInfo()) != null ? ((AnimIconInfo)object).getSrc() : null;
                statusBarNotification.setVideoURI(Uri.parse((String)videoResUtils.getVideoRes((String)object, ModuleViewHolder.getContext$default(this, false, 1, null))));
            }
            if ((object = this.focusVideoView) != null) {
                object.setOnPreparedListener((MediaPlayer.OnPreparedListener)new r(this));
            }
            if ((object = this.focusVideoView) != null) {
                object.setOnErrorListener((MediaPlayer.OnErrorListener)new s(this));
            }
        } else {
            object2 = ((Template)object).getIconTextInfo();
            if (object2 != null && (object2 = ((IconTextInfo)object2).getAnimIconInfo()) != null && (object2 = ((AnimIconInfo)object2).getType()) != null && (Integer)object2 == 2) {
                object = this.focusVideoView;
                if (object != null) {
                    object.setVisibility(8);
                }
                object = this.focusProfile;
                if (object != null) {
                    object.setVisibility(8);
                }
                object = this.focusIconContainer;
                if (object != null) {
                    object.setVisibility(8);
                }
                object = this.focusFlashView;
                if (object != null) {
                    object.setVisibility(0);
                }
                object = this.focusFlashView;
                if (object != null && (object = (Object)object.getFlashLightOffset()) != null) {
                    object[0] = 0.0f;
                }
                if ((object = this.focusFlashView) != null && (object = (Object)object.getFlashLightOffset()) != null) {
                    object[1] = 0.14f;
                }
                if ((object = this.focusFlashView) != null && (object = (Object)object.getFlashLightOffset()) != null) {
                    object[2] = -50.0f;
                }
                if ((object = this.focusFlashView) != null && (object = (Object)object.getFlashLightOffset()) != null) {
                    object[3] = 0.0f;
                }
                Log.d((String)"ModuleViewHolder", (String)"focusFlashView VISIBLE");
            } else {
                object2 = this.focusVideoView;
                if (object2 != null) {
                    object2.setVisibility(8);
                }
                object2 = this.focusProfile;
                if (object2 != null) {
                    object2.setVisibility(0);
                }
                object2 = this.focusIconContainer;
                if (object2 != null) {
                    object2.setVisibility(0);
                }
                object2 = this.focusFlashView;
                if (object2 != null) {
                    object2.setVisibility(8);
                }
                if (this.isDark()) {
                    object2 = ((Template)object).getIconTextInfo();
                    object = videoResUtils;
                    if (object2 != null) {
                        object2 = ((IconTextInfo)object2).getAnimIconInfo();
                        object = videoResUtils;
                        if (object2 != null) {
                            object = ((AnimIconInfo)object2).getSrcDark();
                        }
                    }
                } else {
                    object2 = ((Template)object).getIconTextInfo();
                    object = videoResUtils;
                    if (object2 != null) {
                        object2 = ((IconTextInfo)object2).getAnimIconInfo();
                        object = videoResUtils;
                        if (object2 != null) {
                            object = ((AnimIconInfo)object2).getSrc();
                        }
                    }
                }
                if ((object = this.getIcon((String)object, statusBarNotification)) != null) {
                    statusBarNotification = this.getView();
                    if (statusBarNotification != null && (statusBarNotification = (ImageView)statusBarNotification.findViewById(R.id.focus_profile)) != null) {
                        statusBarNotification.setImageIcon((Icon)object);
                    }
                } else {
                    object = this.focusIconContainer;
                    if (object != null) {
                        object.setVisibility(8);
                    }
                }
            }
        }
    }

    private static final void showEffects$lambda$3(ModuleNewImageTextViewHolder moduleNewImageTextViewHolder, MediaPlayer mediaPlayer) {
        o.g((Object)moduleNewImageTextViewHolder, (String)"this$0");
        mediaPlayer.setLooping(true);
        moduleNewImageTextViewHolder = moduleNewImageTextViewHolder.focusVideoView;
        if (moduleNewImageTextViewHolder != null) {
            moduleNewImageTextViewHolder.start();
        }
    }

    private static final boolean showEffects$lambda$4(ModuleNewImageTextViewHolder moduleNewImageTextViewHolder, MediaPlayer mediaPlayer, int n, int n2) {
        o.g((Object)moduleNewImageTextViewHolder, (String)"this$0");
        moduleNewImageTextViewHolder = moduleNewImageTextViewHolder.focusVideoView;
        if (moduleNewImageTextViewHolder != null) {
            moduleNewImageTextViewHolder.stopPlayback();
        }
        return true;
    }

    @Override
    public void bind(Template template, StatusBarNotification statusBarNotification) {
        int n;
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.bind(template, statusBarNotification);
        Object object = template.getIconTextInfo();
        if (object != null && (object = ((IconTextInfo)object).getAnimIconInfo()) != null && (object = ((AnimIconInfo)object).getType()) != null && (Integer)object == 2) {
            this.initTextAndColor(template.getBaseInfo());
        } else {
            this.initTextAndColor(template.getIconTextInfo());
        }
        object = this.container;
        if (object != null) {
            object.setVisibility(0);
        }
        if (!TextUtils.isEmpty((CharSequence)this.getTitle())) {
            object = this.focusTitle;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusTitle;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getTitle()), TextView.BufferType.SPANNABLE);
            }
            if ((object = this.getTitleColor()) != null) {
                n = ((Number)object).intValue();
                object = this.focusTitle;
                if (object != null) {
                    object.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)this.getTitle()), Integer.valueOf(n));
                }
            }
        } else {
            object = this.focusTitle;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty((CharSequence)this.getContent())) {
            object = this.focusContent;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusContent;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getContent()), TextView.BufferType.SPANNABLE);
            }
            if ((object = this.getContentColor()) != null) {
                n = ((Number)object).intValue();
                object = this.focusContent;
                if (object != null) {
                    object.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)this.getContent()), Integer.valueOf(n));
                }
            }
        } else {
            object = this.focusContent;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty((CharSequence)this.getSubContent())) {
            object = this.focusTextDivider;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusSubContent;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusSubContent;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getSubContent()), TextView.BufferType.SPANNABLE);
            }
            if ((object = this.getSubContentColor()) != null) {
                n = ((Number)object).intValue();
                object = this.focusSubContent;
                if (object != null) {
                    object.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)this.getSubContent()), Integer.valueOf(n));
                }
            }
        } else {
            object = this.focusTextDivider;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.focusSubContent;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        this.showEffects(template, statusBarNotification);
        this.adaptContentViews();
    }

    @Override
    public void checkParams(Template object) {
        block9: {
            block8: {
                IconTextInfo iconTextInfo;
                BaseInfo baseInfo;
                block7: {
                    o.g((Object)object, (String)"template");
                    super.checkParams((Template)object);
                    Object object2 = ((Template)object).getIconTextInfo();
                    baseInfo = null;
                    iconTextInfo = null;
                    if (object2 == null || (object2 = ((IconTextInfo)object2).getAnimIconInfo()) == null || (object2 = ((AnimIconInfo)object2).getType()) == null || (Integer)object2 != 2) break block7;
                    baseInfo = ((Template)object).getBaseInfo();
                    object = iconTextInfo;
                    if (baseInfo != null) {
                        object = baseInfo.getTitle();
                    }
                    if (TextUtils.isEmpty((CharSequence)object)) {
                        throw new FocusParamsException("title is empty");
                    }
                    break block8;
                }
                iconTextInfo = ((Template)object).getIconTextInfo();
                object = baseInfo;
                if (iconTextInfo != null) {
                    object = iconTextInfo.getTitle();
                }
                if (TextUtils.isEmpty((CharSequence)object)) break block9;
            }
            return;
        }
        throw new FocusParamsException("title is empty");
    }

    public final boolean getIsland() {
        return this.island;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        this.setView(LayoutInflater.from((Context)this.getContext(this.island)).inflate(R.layout.focus_notification_module_new_image_text, this.getRootView()));
        string = this.getView();
        Object var2_2 = null;
        string = string != null ? string.findViewById(R.id.focus_container_module_new_image_text) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (TimerTextEffectView)string.findViewById(R.id.focus_title) : null;
        this.focusTitle = string;
        string = this.getView();
        string = string != null ? (TimerTextEffectView)string.findViewById(R.id.focus_content) : null;
        this.focusContent = string;
        string = this.getView();
        string = string != null ? (TimerTextEffectView)string.findViewById(R.id.focus_function_text_divider) : null;
        this.focusTextDivider = string;
        string = this.getView();
        string = string != null ? (TimerTextEffectView)string.findViewById(R.id.focus_sub_content) : null;
        this.focusSubContent = string;
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_icon_container) : null;
        this.focusIconContainer = string;
        string = this.getView();
        string = string != null ? (ImageView)string.findViewById(R.id.focus_profile) : null;
        this.focusProfile = string;
        string = this.getView();
        string = string != null ? (TextureVideoView)string.findViewById(R.id.focus_video) : null;
        this.focusVideoView = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = (FlashLightView)view.findViewById(R.id.focus_flash);
        }
        this.focusFlashView = string;
        string = this.focusTitle;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.focusTitle) != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.focusContent;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.focusContent) != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.focusTextDivider;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.focusTextDivider) != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.focusSubContent;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.focusSubContent) != null) {
            string.setEnableEffectWithInit(false);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        TextureVideoView textureVideoView = this.focusVideoView;
        if (textureVideoView != null) {
            textureVideoView.stopPlayback();
        }
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.initTextAndColor(template.getIconTextInfo());
        this.bind(template, statusBarNotification);
    }
}
