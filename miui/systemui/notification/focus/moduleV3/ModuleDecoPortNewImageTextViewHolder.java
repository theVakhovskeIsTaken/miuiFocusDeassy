/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  H0.m
 *  android.content.Context
 *  android.graphics.drawable.Icon
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.TextView$BufferType
 *  com.android.systemui.miui.notification.R$dimen
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.VideoResUtils
 *  miui.systemui.widget.TextureVideoView
 */
package miui.systemui.notification.focus.moduleV3;

import H0.m;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.media.MediaPlayer;
import android.net.Uri;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.FocusParamsException;
import miui.systemui.notification.focus.model.AnimIconInfo;
import miui.systemui.notification.focus.model.IconTextInfo;
import miui.systemui.notification.focus.model.PicInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.ext.ModuleViewHolderExtKt;
import miui.systemui.notification.focus.moduleV3.p;
import miui.systemui.notification.focus.moduleV3.q;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.VideoResUtils;
import miui.systemui.widget.TextureVideoView;

public final class ModuleDecoPortNewImageTextViewHolder
extends ModuleViewHolder {
    private View container;
    private TextView focusContent;
    private View focusIconContainer;
    private ImageView focusProfile;
    private TextView focusSubContent;
    private TextView focusTitle;
    private LinearLayout focusTitleContainer;
    private TextureVideoView focusVideoView;

    public ModuleDecoPortNewImageTextViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    public static /* synthetic */ boolean c(ModuleDecoPortNewImageTextViewHolder moduleDecoPortNewImageTextViewHolder, MediaPlayer mediaPlayer, int n, int n2) {
        return ModuleDecoPortNewImageTextViewHolder.showEffects$lambda$8(moduleDecoPortNewImageTextViewHolder, mediaPlayer, n, n2);
    }

    public static /* synthetic */ void d(ModuleDecoPortNewImageTextViewHolder moduleDecoPortNewImageTextViewHolder, MediaPlayer mediaPlayer) {
        ModuleDecoPortNewImageTextViewHolder.showEffects$lambda$7(moduleDecoPortNewImageTextViewHolder, mediaPlayer);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final void showEffects(Template object, StatusBarNotification statusBarNotification, boolean bl) {
        int n = (int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_deco_port_icon_ear_size);
        int n2 = (int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_deco_port_icon_size);
        if (bl) {
            n2 = n;
        }
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
            statusBarNotification = this.focusVideoView;
            if (statusBarNotification != null) {
                videoResUtils = VideoResUtils.INSTANCE;
                object = (object = ((Template)object).getIconTextInfo().getAnimIconInfo()) != null ? ((AnimIconInfo)object).getSrc() : null;
                statusBarNotification.setVideoURI(Uri.parse((String)videoResUtils.getVideoRes((String)object, ModuleViewHolder.getContext$default(this, false, 1, null))));
            }
            if ((object = this.focusVideoView) != null) {
                object.setOnPreparedListener((MediaPlayer.OnPreparedListener)new p(this));
            }
            if ((object = this.focusVideoView) == null) return;
            object.setOnErrorListener((MediaPlayer.OnErrorListener)new q(this));
            return;
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
                if (statusBarNotification == null || (statusBarNotification = (ImageView)statusBarNotification.findViewById(R.id.focus_profile)) == null) return;
                statusBarNotification.setImageIcon((Icon)object);
                object = statusBarNotification.getLayoutParams();
                if (object == null) throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                ((ViewGroup.LayoutParams)object).width = n2;
                ((ViewGroup.LayoutParams)object).height = n2;
                statusBarNotification.setLayoutParams((ViewGroup.LayoutParams)object);
                return;
            } else {
                object = this.focusIconContainer;
                if (object == null) return;
                object.setVisibility(8);
            }
        }
    }

    private static final void showEffects$lambda$7(ModuleDecoPortNewImageTextViewHolder moduleDecoPortNewImageTextViewHolder, MediaPlayer mediaPlayer) {
        o.g((Object)moduleDecoPortNewImageTextViewHolder, (String)"this$0");
        mediaPlayer.setLooping(true);
        moduleDecoPortNewImageTextViewHolder = moduleDecoPortNewImageTextViewHolder.focusVideoView;
        if (moduleDecoPortNewImageTextViewHolder != null) {
            moduleDecoPortNewImageTextViewHolder.start();
        }
    }

    private static final boolean showEffects$lambda$8(ModuleDecoPortNewImageTextViewHolder moduleDecoPortNewImageTextViewHolder, MediaPlayer mediaPlayer, int n, int n2) {
        o.g((Object)moduleDecoPortNewImageTextViewHolder, (String)"this$0");
        moduleDecoPortNewImageTextViewHolder = moduleDecoPortNewImageTextViewHolder.focusVideoView;
        if (moduleDecoPortNewImageTextViewHolder != null) {
            moduleDecoPortNewImageTextViewHolder.stopPlayback();
        }
        return true;
    }

    @Override
    public void bind(Template template, StatusBarNotification statusBarNotification) {
        int n;
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.bind(template, statusBarNotification);
        this.initTextAndColor(template.getIconTextInfo());
        Object object = this.container;
        if (object != null) {
            object.setVisibility(0);
        }
        object = this.focusTitle;
        if (object != null) {
            object.setVisibility(0);
        }
        object = this.getTitle();
        boolean bl = true;
        if (object != null && ModuleViewHolderExtKt.containsHTML((String)object)) {
            object = this.focusTitle;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getTitle()), TextView.BufferType.SPANNABLE);
            }
        } else {
            object = this.focusTitle;
            if (object != null) {
                object.setText((CharSequence)this.getTitle());
            }
        }
        if ((object = this.getTitleColor()) != null) {
            n = ((Number)object).intValue();
            object = this.focusTitle;
            if (object != null) {
                object.setTextColor(n);
            }
        }
        if (!TextUtils.isEmpty((CharSequence)this.getContent())) {
            object = this.focusContent;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.getContent();
            if (object != null && ModuleViewHolderExtKt.containsHTML((String)object)) {
                object = this.focusContent;
                if (object != null) {
                    object.setText((CharSequence)Html.fromHtml((String)this.getContent()), TextView.BufferType.SPANNABLE);
                }
            } else {
                object = this.focusContent;
                if (object != null) {
                    object.setText((CharSequence)this.getContent());
                }
            }
            if ((object = this.getContentColor()) != null) {
                n = ((Number)object).intValue();
                object = this.focusContent;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        } else {
            object = this.focusContent;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty((CharSequence)this.getSubContent())) {
            object = this.focusSubContent;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.getSubContent();
            if (object != null && ModuleViewHolderExtKt.containsHTML((String)object)) {
                object = this.focusSubContent;
                if (object != null) {
                    object.setText((CharSequence)Html.fromHtml((String)this.getSubContent()), TextView.BufferType.SPANNABLE);
                }
            } else {
                object = this.focusSubContent;
                if (object != null) {
                    object.setText((CharSequence)this.getSubContent());
                }
            }
            if ((object = this.getSubContentColor()) != null) {
                n = ((Number)object).intValue();
                object = this.focusSubContent;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        } else {
            object = this.focusSubContent;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        if ((object = template.getIconTextInfo()) != null && (object = ((IconTextInfo)object).getType()) != null && (Integer)object == 1) {
            object = this.focusTitleContainer;
            if (object != null) {
                object.setGravity(1);
            }
            object = this.focusTitle;
            if (object != null) {
                CommonUtils.setMarginTop$default((CommonUtils)CommonUtils.INSTANCE, (View)object, (int)((int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_deco_port_title_padding)), (boolean)false, (int)2, null);
            }
            if ((object = this.focusContent) != null) {
                CommonUtils.setMarginTop$default((CommonUtils)CommonUtils.INSTANCE, (View)object, (int)((int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_deco_port_title_padding)), (boolean)false, (int)2, null);
            }
            if ((object = this.focusSubContent) != null) {
                CommonUtils.setMarginTop$default((CommonUtils)CommonUtils.INSTANCE, (View)object, (int)((int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_deco_port_title_padding)), (boolean)false, (int)2, null);
            }
            this.showEffects(template, statusBarNotification, true);
        } else {
            this.setTextLinesByTitle(this.getTitle(), this.getSubContent(), this.focusTitle, this.focusContent, this.focusSubContent);
            object = this.focusTitleContainer;
            if (object != null) {
                object.setGravity(0x800003);
            }
            object = template.getPicInfo();
            if (object == null || (object = ((PicInfo)object).getType()) == null || (Integer)object != 1) {
                bl = false;
            }
            if (!bl) {
                this.showEffects(template, statusBarNotification, false);
            } else {
                template = this.focusIconContainer;
                if (template != null) {
                    template.setVisibility(8);
                }
            }
        }
    }

    @Override
    public void checkParams(Template object) {
        o.g((Object)object, (String)"template");
        super.checkParams((Template)object);
        object = ((Template)object).getIconTextInfo();
        object = object != null ? ((TextAndColorInfo)object).getTitle() : null;
        if (!TextUtils.isEmpty((CharSequence)object)) {
            return;
        }
        throw new FocusParamsException("title is empty");
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        Object var2_2 = null;
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_deco_port_new_image_text, this.getRootView()));
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_container_module_new_image_text) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (LinearLayout)string.findViewById(R.id.focus_title_container) : null;
        this.focusTitleContainer = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_title) : null;
        this.focusTitle = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_content) : null;
        this.focusContent = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_sub_content) : null;
        this.focusSubContent = string;
        string = this.getView();
        string = string != null ? (TextureVideoView)string.findViewById(R.id.focus_video) : null;
        this.focusVideoView = string;
        string = this.getView();
        string = string != null ? (ImageView)string.findViewById(R.id.focus_profile) : null;
        this.focusProfile = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = view.findViewById(R.id.focus_icon_container);
        }
        this.focusIconContainer = string;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        TextureVideoView textureVideoView = this.focusVideoView;
        if (textureVideoView != null) {
            textureVideoView.stopPlayback();
        }
    }

    public final void setTextLinesByTitle(String string2, String object, TextView textView, TextView textView2, TextView textView3) {
        int n = string2 != null ? ModuleViewHolderExtKt.customLength(string2) : 0;
        boolean bl = object == null || object.length() == 0;
        if (textView != null) {
            textView.setMaxLines(3);
        }
        if (n <= 11) {
            if (!bl) {
                if (textView2 != null) {
                    textView2.setMaxLines(3);
                }
                if (textView3 != null) {
                    textView3.setMaxLines(1);
                    textView3.setVisibility(0);
                }
            } else {
                if (textView2 != null) {
                    textView2.setMaxLines(4);
                }
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
            }
        } else if (n <= 21) {
            if (!bl) {
                if (textView2 != null) {
                    textView2.setMaxLines(2);
                }
                if (textView3 != null) {
                    textView3.setMaxLines(1);
                    textView3.setVisibility(0);
                }
            } else {
                if (textView2 != null) {
                    textView2.setMaxLines(3);
                }
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
            }
        } else if (n <= 31) {
            if (!bl) {
                if (textView2 != null) {
                    textView2.setMaxLines(1);
                }
                if (textView3 != null) {
                    textView3.setMaxLines(1);
                    textView3.setVisibility(0);
                }
            } else {
                if (textView2 != null) {
                    textView2.setMaxLines(2);
                }
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
            }
        } else {
            if (textView != null) {
                textView.setMaxLines(4);
            }
            if (textView2 != null) {
                textView2.setMaxLines(1);
            }
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        for (String string2 : m.j((Object[])new TextView[]{textView, textView2, textView3})) {
            if (string2 == null) continue;
            string2.setEllipsize(TextUtils.TruncateAt.END);
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
