/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.GradientDrawable$Orientation
 *  android.graphics.drawable.Icon
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.ScaleDrawable
 *  android.service.notification.StatusBarNotification
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  b1.d
 *  com.android.systemui.miui.notification.R$dimen
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.notification.focus.moduleV3;

import U0.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.Icon;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.service.notification.StatusBarNotification;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import b1.d;
import com.android.systemui.miui.notification.R;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.ProgressInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.util.CommonUtils;

public final class ModuleTinyProgressViewHolder
extends ModuleViewHolder {
    private View container;
    private ProgressBar progressBar;
    private ImageView progressThumb;

    public ModuleTinyProgressViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    public static final /* synthetic */ ProgressBar access$getProgressBar$p(ModuleTinyProgressViewHolder moduleTinyProgressViewHolder) {
        return moduleTinyProgressViewHolder.progressBar;
    }

    public static final /* synthetic */ ImageView access$getProgressThumb$p(ModuleTinyProgressViewHolder moduleTinyProgressViewHolder) {
        return moduleTinyProgressViewHolder.progressThumb;
    }

    public static final /* synthetic */ void access$setProgressThumb(ModuleTinyProgressViewHolder moduleTinyProgressViewHolder, ProgressBar progressBar, ImageView imageView) {
        moduleTinyProgressViewHolder.setProgressThumb(progressBar, imageView);
    }

    private final boolean hasProgressIcon(Template object, StatusBarNotification statusBarNotification) {
        Object object2 = ((Template)object).getProgressInfo();
        Object var5_4 = null;
        object2 = object2 != null ? ((ProgressInfo)object2).getPicForward() : null;
        Icon icon = this.getIcon((String)object2, statusBarNotification);
        object2 = ((Template)object).getProgressInfo();
        object2 = object2 != null ? ((ProgressInfo)object2).getPicEnd() : null;
        object2 = this.getIcon((String)object2, statusBarNotification);
        ProgressInfo progressInfo = ((Template)object).getProgressInfo();
        object = var5_4;
        if (progressInfo != null) {
            object = progressInfo.getPicMiddle();
        }
        object = this.getIcon((String)object, statusBarNotification);
        boolean bl = icon != null || object2 != null || object != null;
        return bl;
    }

    private final void setProgressColor(ProgressBar progressBar, Integer n, Integer n2) {
        Drawable drawable;
        if (n != null && n2 != null && n != -1 && n2 != -1 && (drawable = progressBar != null ? progressBar.getProgressDrawable() : null) instanceof LayerDrawable) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius((float)progressBar.getContext().getResources().getDimensionPixelSize(R.dimen.notification_custom_progress_view_corner_radius));
            if (CommonUtils.isLayoutRtl((Context)this.getCtx())) {
                gradientDrawable.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
            } else {
                gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            }
            gradientDrawable.setColors(new int[]{n, n2});
            n = new ScaleDrawable((Drawable)gradientDrawable, 0x800003, 1.0f, -1.0f);
            n.setLevel(progressBar.getProgress() * 100);
            ((LayerDrawable)drawable).setDrawableByLayerId(16908301, (Drawable)n);
            progressBar.setProgressDrawable(drawable);
        }
    }

    private final void setProgressThumb(ProgressBar progressBar, ImageView imageView) {
        if (imageView != null && progressBar != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            o.e((Object)layoutParams, (String)"null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            layoutParams = (FrameLayout.LayoutParams)layoutParams;
            layoutParams.setMarginStart((int)Math.max(Math.min((double)(progressBar.getWidth() * progressBar.getProgress() / 100 - imageView.getWidth() / 2), (double)(progressBar.getWidth() - imageView.getWidth())), 0.0));
            imageView.setLayoutParams(layoutParams);
            if (CommonUtils.isLayoutRtl((Context)this.getCtx())) {
                imageView.setScaleX(-1.0f);
            } else {
                imageView.setScaleX(1.0f);
            }
        }
    }

    @Override
    public void bind(Template object, StatusBarNotification statusBarNotification) {
        Object object2;
        Object var12_5;
        Object object3;
        block55: {
            block54: {
                block53: {
                    block52: {
                        o.g((Object)object, (String)"template");
                        o.g((Object)statusBarNotification, (String)"sbn");
                        super.bind((Template)object, statusBarNotification);
                        object3 = this.getView();
                        if (object3 != null) {
                            object3.setLayoutDirection(CommonUtils.isLayoutRtl((Context)this.getCtx()) ? 1 : 0);
                        }
                        var12_5 = null;
                        object3 = ((Template)object).getProgressInfo();
                        if (object3 == null) break block52;
                        object3 = ((ProgressInfo)object3).getColorProgress();
                        break block53;
                    }
                    object3 = null;
                }
                try {
                    object3 = Color.parseColor((String)object3);
                }
                catch (Exception exception) {
                    object3 = null;
                }
                object2 = ((Template)object).getProgressInfo();
                if (object2 == null) break block54;
                object2 = ((ProgressInfo)object2).getColorProgressEnd();
                break block55;
            }
            object2 = null;
        }
        try {
            object2 = Color.parseColor((String)object2);
        }
        catch (Exception exception) {
            object2 = null;
        }
        ProgressInfo progressInfo = ((Template)object).getProgressInfo();
        Object object4 = progressInfo != null ? Integer.valueOf(progressInfo.getProgress()) : null;
        if (object4 != null) {
            Object object5;
            progressInfo = this.container;
            if (progressInfo != null) {
                progressInfo.setVisibility(0);
            }
            int n = this.hasProgressIcon((Template)object, statusBarNotification) ? R.id.focus_progress_info1 : R.id.focus_progress_info2;
            progressInfo = this.getView();
            progressInfo = progressInfo != null ? (ProgressBar)progressInfo.findViewById(n) : null;
            this.progressBar = progressInfo;
            if (progressInfo != null) {
                progressInfo.setVisibility(0);
            }
            progressInfo = this.progressBar;
            if (progressInfo != null) {
                progressInfo.setMax(100);
            }
            progressInfo = this.progressBar;
            if (progressInfo != null) {
                progressInfo.setProgress((Integer)object4, false);
            }
            if (object2 == null) {
                object5 = this.progressBar;
                if (object5 != null) {
                    progressInfo = object3 != null ? ColorStateList.valueOf((int)((Number)object3).intValue()) : null;
                    object5.setProgressTintList((ColorStateList)progressInfo);
                }
            } else {
                if (object3 != null) {
                    n = ((Number)object3).intValue();
                    statusBarNotification.getNotification().extras.putInt("colorProgress", n);
                }
                statusBarNotification.getNotification().extras.putInt("colorProgressEnd", ((Integer)object2).intValue());
            }
            object5 = (progressInfo = this.getView()) != null ? (ImageView)progressInfo.findViewById(R.id.progress_point1) : null;
            progressInfo = this.getView();
            progressInfo = progressInfo != null ? (ImageView)progressInfo.findViewById(R.id.progress_point2) : null;
            Object object6 = this.getView();
            object6 = object6 != null ? (ImageView)object6.findViewById(R.id.progress_point_middle) : null;
            if (object5 != null) {
                object5.setVisibility(0);
            }
            if (progressInfo != null) {
                progressInfo.setVisibility(0);
            }
            int n2 = (Integer)object4;
            n = 8;
            if (n2 < 50) {
                Object object7;
                object4 = ((Template)object).getProgressInfo();
                object4 = object4 != null ? ((ProgressInfo)object4).getPicMiddleUnselected() : null;
                object4 = object7 = this.getIcon((String)object4, statusBarNotification);
                if (object7 == null) {
                    object4 = ((Template)object).getProgressInfo();
                    object4 = object4 != null ? ((ProgressInfo)object4).getPicMiddle() : null;
                    object4 = this.getIcon((String)object4, statusBarNotification);
                }
                object7 = (object7 = ((Template)object).getProgressInfo()) != null ? ((ProgressInfo)object7).getPicEndUnselected() : null;
                Icon icon = this.getIcon((String)object7, statusBarNotification);
                object7 = icon;
                if (icon == null) {
                    object7 = ((Template)object).getProgressInfo();
                    object7 = object7 != null ? ((ProgressInfo)object7).getPicEnd() : null;
                    object7 = this.getIcon((String)object7, statusBarNotification);
                }
                if (object7 != null && object6 != null) {
                    object6.setVisibility(8);
                }
                if (object5 != null) {
                    object5.setImageIcon((Icon)object4);
                }
                if (progressInfo != null) {
                    progressInfo.setImageIcon((Icon)object7);
                }
            } else if ((Integer)object4 == 50) {
                if (object6 != null) {
                    object6.setVisibility(8);
                }
                if (object5 != null) {
                    object5.setVisibility(0);
                }
                object6 = ((Template)object).getProgressInfo();
                object6 = object6 != null ? ((ProgressInfo)object6).getPicMiddle() : null;
                object6 = object4 = this.getIcon((String)object6, statusBarNotification);
                if (object4 == null) {
                    object6 = ((Template)object).getProgressInfo();
                    object6 = object6 != null ? ((ProgressInfo)object6).getPicMiddleUnselected() : null;
                    object6 = this.getIcon((String)object6, statusBarNotification);
                }
                if (object5 != null) {
                    object5.setImageIcon((Icon)object6);
                }
                object5 = (object5 = ((Template)object).getProgressInfo()) != null ? ((ProgressInfo)object5).getPicEndUnselected() : null;
                object5 = object6 = this.getIcon((String)object5, statusBarNotification);
                if (object6 == null) {
                    object5 = ((Template)object).getProgressInfo();
                    object5 = object5 != null ? ((ProgressInfo)object5).getPicEnd() : null;
                    object5 = this.getIcon((String)object5, statusBarNotification);
                }
                if (progressInfo != null) {
                    progressInfo.setImageIcon((Icon)object5);
                }
            } else if (new d(51, 99).h(((Integer)object4).intValue())) {
                object4 = ((Template)object).getProgressInfo();
                object4 = object4 != null ? ((ProgressInfo)object4).getPicEndUnselected() : null;
                Icon icon = this.getIcon((String)object4, statusBarNotification);
                object4 = icon;
                if (icon == null) {
                    object4 = ((Template)object).getProgressInfo();
                    object4 = object4 != null ? ((ProgressInfo)object4).getPicEnd() : null;
                    object4 = this.getIcon((String)object4, statusBarNotification);
                }
                if (object4 != null) {
                    if (object6 != null) {
                        object6.setVisibility(0);
                    }
                } else if (object6 != null) {
                    object6.setVisibility(8);
                }
                if (object6 != null) {
                    n = object4 != null ? 0 : 8;
                    object6.setVisibility(n);
                }
                if (object5 != null) {
                    object5.setVisibility(8);
                }
                if (progressInfo != null) {
                    progressInfo.setImageIcon((Icon)object4);
                }
            } else {
                if (object5 != null) {
                    object5.setVisibility(8);
                }
                object5 = ((Template)object).getProgressInfo();
                object5 = object5 != null ? ((ProgressInfo)object5).getPicEnd() : null;
                object5 = object4 = this.getIcon((String)object5, statusBarNotification);
                if (object4 == null) {
                    object5 = ((Template)object).getProgressInfo();
                    object5 = object5 != null ? ((ProgressInfo)object5).getPicEndUnselected() : null;
                    object5 = this.getIcon((String)object5, statusBarNotification);
                }
                if (object6 != null) {
                    if (object5 != null) {
                        n = 0;
                    }
                    object6.setVisibility(n);
                }
                if (progressInfo != null) {
                    progressInfo.setImageIcon((Icon)object5);
                }
            }
            progressInfo = ((Template)object).getProgressInfo();
            object = var12_5;
            if (progressInfo != null) {
                object = progressInfo.getPicForward();
            }
            object = this.getIcon((String)object, statusBarNotification);
            statusBarNotification = this.progressThumb;
            if (statusBarNotification != null) {
                statusBarNotification.setVisibility(0);
                statusBarNotification.setImageIcon((Icon)object);
            }
            this.setProgressColor(this.progressBar, (Integer)object3, (Integer)object2);
            this.notifyDataChanged();
        }
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        Object var2_2 = null;
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_tiny_progress, this.getRootView()));
        string = this.getView();
        string = string != null ? string.findViewById(R.id.progressbar_container) : null;
        this.container = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = (ImageView)view.findViewById(R.id.progress_icon);
        }
        this.progressThumb = string;
        this.registerCompressChanged(new a(this){
            final ModuleTinyProgressViewHolder this$0;
            {
                this.this$0 = moduleTinyProgressViewHolder;
                super(0);
            }

            public final void invoke() {
                ModuleTinyProgressViewHolder moduleTinyProgressViewHolder = this.this$0;
                ModuleTinyProgressViewHolder.access$setProgressThumb(moduleTinyProgressViewHolder, ModuleTinyProgressViewHolder.access$getProgressBar$p(moduleTinyProgressViewHolder), ModuleTinyProgressViewHolder.access$getProgressThumb$p(this.this$0));
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.bind(template, statusBarNotification);
    }
}
