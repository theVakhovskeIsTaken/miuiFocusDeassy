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
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  android.widget.TextView$BufferType
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.VideoResUtils
 *  miui.systemui.widget.TextureVideoView
 */
package miui.systemui.notification.focus.moduleV3;

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
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.FocusParamsException;
import miui.systemui.notification.focus.model.AnimIconInfo;
import miui.systemui.notification.focus.model.IconTextInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.moduleV3.A;
import miui.systemui.notification.focus.moduleV3.B;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.util.VideoResUtils;
import miui.systemui.widget.TextureVideoView;

public final class ModuleTinyNewImageTextViewHolder
extends ModuleViewHolder {
    private View container;
    private TextView focusContent;
    private View focusIconContainer;
    private ImageView focusProfile;
    private TextView focusSubContent;
    private TextView focusTitle;
    private TextureVideoView focusVideoView;

    public ModuleTinyNewImageTextViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    public static /* synthetic */ void c(ModuleTinyNewImageTextViewHolder moduleTinyNewImageTextViewHolder, MediaPlayer mediaPlayer) {
        ModuleTinyNewImageTextViewHolder.showEffects$lambda$3(moduleTinyNewImageTextViewHolder, mediaPlayer);
    }

    public static /* synthetic */ boolean d(ModuleTinyNewImageTextViewHolder moduleTinyNewImageTextViewHolder, MediaPlayer mediaPlayer, int n, int n2) {
        return ModuleTinyNewImageTextViewHolder.showEffects$lambda$4(moduleTinyNewImageTextViewHolder, mediaPlayer, n, n2);
    }

    private final void showEffects(Template object, StatusBarNotification statusBarNotification) {
        Object object2 = ((Template)object).getIconTextInfo();
        TextureVideoView textureVideoView = null;
        if (object2 != null && (object2 = ((IconTextInfo)object2).getAnimIconInfo()) != null && (object2 = ((AnimIconInfo)object2).getType()) != null && (Integer)object2 == 1) {
            statusBarNotification = this.focusVideoView;
            if (statusBarNotification != null) {
                statusBarNotification.setVisibility(0);
            }
            statusBarNotification = this.focusProfile;
            if (statusBarNotification != null) {
                statusBarNotification.setVisibility(8);
            }
            textureVideoView = this.focusVideoView;
            if (textureVideoView != null) {
                statusBarNotification = VideoResUtils.INSTANCE;
                object = (object = ((Template)object).getIconTextInfo().getAnimIconInfo()) != null ? ((AnimIconInfo)object).getSrc() : null;
                textureVideoView.setVideoURI(Uri.parse((String)statusBarNotification.getVideoRes((String)object, ModuleViewHolder.getContext$default(this, false, 1, null))));
            }
            if ((object = this.focusVideoView) != null) {
                object.setOnPreparedListener((MediaPlayer.OnPreparedListener)new A(this));
            }
            if ((object = this.focusVideoView) != null) {
                object.setOnErrorListener((MediaPlayer.OnErrorListener)new B(this));
            }
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
                object = textureVideoView;
                if (object2 != null) {
                    object2 = ((IconTextInfo)object2).getAnimIconInfo();
                    object = textureVideoView;
                    if (object2 != null) {
                        object = ((AnimIconInfo)object2).getSrcDark();
                    }
                }
            } else {
                object2 = ((Template)object).getIconTextInfo();
                object = textureVideoView;
                if (object2 != null) {
                    object2 = ((IconTextInfo)object2).getAnimIconInfo();
                    object = textureVideoView;
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

    private static final void showEffects$lambda$3(ModuleTinyNewImageTextViewHolder moduleTinyNewImageTextViewHolder, MediaPlayer mediaPlayer) {
        o.g((Object)moduleTinyNewImageTextViewHolder, (String)"this$0");
        mediaPlayer.setLooping(true);
        moduleTinyNewImageTextViewHolder = moduleTinyNewImageTextViewHolder.focusVideoView;
        if (moduleTinyNewImageTextViewHolder != null) {
            moduleTinyNewImageTextViewHolder.start();
        }
    }

    private static final boolean showEffects$lambda$4(ModuleTinyNewImageTextViewHolder moduleTinyNewImageTextViewHolder, MediaPlayer mediaPlayer, int n, int n2) {
        o.g((Object)moduleTinyNewImageTextViewHolder, (String)"this$0");
        moduleTinyNewImageTextViewHolder = moduleTinyNewImageTextViewHolder.focusVideoView;
        if (moduleTinyNewImageTextViewHolder != null) {
            moduleTinyNewImageTextViewHolder.stopPlayback();
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
        object = this.focusTitle;
        if (object != null) {
            object.setText((CharSequence)Html.fromHtml((String)this.getTitle()), TextView.BufferType.SPANNABLE);
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
            object = this.focusContent;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getContent()), TextView.BufferType.SPANNABLE);
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
            object = this.focusSubContent;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getSubContent()), TextView.BufferType.SPANNABLE);
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
        this.showEffects(template, statusBarNotification);
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
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_tiny_new_image_text, this.getRootView()));
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_container_module_new_image_text) : null;
        this.container = string;
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
        string = string != null ? string.findViewById(R.id.focus_icon_container) : null;
        this.focusIconContainer = string;
        string = this.getView();
        string = string != null ? (ImageView)string.findViewById(R.id.focus_profile) : null;
        this.focusProfile = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = (TextureVideoView)view.findViewById(R.id.focus_video);
        }
        this.focusVideoView = string;
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
