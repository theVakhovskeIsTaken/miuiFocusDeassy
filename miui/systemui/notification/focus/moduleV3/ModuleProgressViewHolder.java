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
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ProgressBar
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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.android.systemui.miui.notification.R;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.ProgressInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.util.CommonUtils;

public final class ModuleProgressViewHolder
extends ModuleViewHolder {
    private View container;
    private final boolean island;
    private ProgressBar progressBar;
    private ImageView progressThumb;

    public ModuleProgressViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl, boolean bl2) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.island = bl2;
    }

    public static final /* synthetic */ ProgressBar access$getProgressBar$p(ModuleProgressViewHolder moduleProgressViewHolder) {
        return moduleProgressViewHolder.progressBar;
    }

    public static final /* synthetic */ ImageView access$getProgressThumb$p(ModuleProgressViewHolder moduleProgressViewHolder) {
        return moduleProgressViewHolder.progressThumb;
    }

    public static final /* synthetic */ void access$setProgressThumb(ModuleProgressViewHolder moduleProgressViewHolder, ProgressBar progressBar, ImageView imageView) {
        moduleProgressViewHolder.setProgressThumb(progressBar, imageView);
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
    public void bind(Template object, StatusBarNotification object2) {
        Object object3;
        Object object4;
        block52: {
            block51: {
                block50: {
                    block49: {
                        o.g((Object)object, (String)"template");
                        o.g((Object)object2, (String)"sbn");
                        super.bind((Template)object, (StatusBarNotification)object2);
                        object4 = this.getView();
                        if (object4 != null) {
                            object4.setLayoutDirection(CommonUtils.isLayoutRtl((Context)this.getCtx()) ? 1 : 0);
                        }
                        object4 = ((Template)object).getProgressInfo();
                        if (object4 == null) break block49;
                        object4 = ((ProgressInfo)object4).getColorProgress();
                        break block50;
                    }
                    object4 = null;
                }
                try {
                    object4 = Color.parseColor((String)object4);
                }
                catch (Exception exception) {
                    object4 = null;
                }
                object3 = ((Template)object).getProgressInfo();
                if (object3 == null) break block51;
                object3 = ((ProgressInfo)object3).getColorProgressEnd();
                break block52;
            }
            object3 = null;
        }
        try {
            object3 = Color.parseColor((String)object3);
        }
        catch (Exception exception) {
            object3 = null;
        }
        Object object5 = ((Template)object).getProgressInfo();
        Object object6 = object5 != null ? Integer.valueOf(((ProgressInfo)object5).getProgress()) : null;
        if (object6 != null && (Integer)object6 >= 0) {
            Object object7;
            object5 = this.container;
            if (object5 != null) {
                object5.setVisibility(0);
            }
            int n = this.hasProgressIcon((Template)object, (StatusBarNotification)object2) ? R.id.focus_progress_info1 : R.id.focus_progress_info2;
            object5 = this.getView();
            object5 = object5 != null ? (ProgressBar)object5.findViewById(n) : null;
            this.progressBar = object5;
            if (object5 != null) {
                object5.setVisibility(0);
            }
            object5 = this.progressBar;
            if (object5 != null) {
                object5.setMax(100);
            }
            object5 = this.progressBar;
            if (object5 != null) {
                object5.setProgress(((Integer)object6).intValue(), false);
            }
            if ((object5 = this.progressBar) != null) {
                object5.invalidate();
            }
            if (object3 == null) {
                object7 = this.progressBar;
                if (object7 != null) {
                    object5 = object4 != null ? ColorStateList.valueOf((int)((Number)object4).intValue()) : null;
                    object7.setProgressTintList((ColorStateList)object5);
                }
            } else {
                if (object4 != null) {
                    n = ((Number)object4).intValue();
                    object2.getNotification().extras.putInt("colorProgress", n);
                }
                object2.getNotification().extras.putInt("colorProgressEnd", ((Integer)object3).intValue());
            }
            object5 = (object5 = this.getView()) != null ? (ImageView)object5.findViewById(R.id.progress_point1) : null;
            object7 = this.getView();
            object7 = object7 != null ? (ImageView)object7.findViewById(R.id.progress_point2) : null;
            if (object5 != null) {
                object5.setVisibility(0);
            }
            if (object7 != null) {
                object7.setVisibility(0);
            }
            Object object8 = ((Template)object).getProgressInfo();
            object8 = object8 != null ? ((ProgressInfo)object8).getPicEnd() : null;
            Object object9 = ((Template)object).getProgressInfo();
            object9 = object9 != null ? ((ProgressInfo)object9).getPicMiddle() : null;
            Object object10 = ((Template)object).getProgressInfo();
            object10 = object10 != null ? ((ProgressInfo)object10).getPicForward() : null;
            Object object11 = ((Template)object).getProgressInfo();
            object11 = object11 != null ? ((ProgressInfo)object11).getPicEndUnselected() : null;
            Object object12 = ((Template)object).getProgressInfo();
            object12 = object12 != null ? ((ProgressInfo)object12).getPicMiddleUnselected() : null;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("s0: picEnd=");
            stringBuilder.append((String)object8);
            stringBuilder.append(", picMiddle=");
            stringBuilder.append((String)object9);
            stringBuilder.append(", picForward=");
            stringBuilder.append((String)object10);
            stringBuilder.append(", picEndUnselected=");
            stringBuilder.append((String)object11);
            stringBuilder.append(", picMiddleUnselected=");
            stringBuilder.append((String)object12);
            Log.d((String)"ModuleViewHolder", (String)stringBuilder.toString());
            if ((Integer)object6 < 50) {
                object6 = ((Template)object).getProgressInfo();
                object6 = object6 != null ? ((ProgressInfo)object6).getPicMiddleUnselected() : null;
                object6 = object8 = this.getIcon((String)object6, (StatusBarNotification)object2);
                if (object8 == null) {
                    object6 = ((Template)object).getProgressInfo();
                    object6 = object6 != null ? ((ProgressInfo)object6).getPicMiddle() : null;
                    object6 = this.getIcon((String)object6, (StatusBarNotification)object2);
                }
                object8 = (object8 = ((Template)object).getProgressInfo()) != null ? ((ProgressInfo)object8).getPicEndUnselected() : null;
                object8 = object9 = this.getIcon((String)object8, (StatusBarNotification)object2);
                if (object9 == null) {
                    object8 = ((Template)object).getProgressInfo();
                    object8 = object8 != null ? ((ProgressInfo)object8).getPicEnd() : null;
                    object8 = this.getIcon((String)object8, (StatusBarNotification)object2);
                }
                if (object5 != null) {
                    object5.setImageIcon((Icon)object6);
                }
                if (object7 != null) {
                    object7.setImageIcon((Icon)object8);
                }
                if (object6 != null) {
                    object5 = new StringBuilder();
                    ((StringBuilder)object5).append("s1:");
                    ((StringBuilder)object5).append(object6);
                    Log.d((String)"ModuleViewHolder", (String)((StringBuilder)object5).toString());
                } else {
                    Log.d((String)"ModuleViewHolder", (String)"s1:middleIcon is null");
                }
                if (object8 != null) {
                    object5 = new StringBuilder();
                    ((StringBuilder)object5).append("s1:");
                    ((StringBuilder)object5).append(object8);
                    Log.d((String)"ModuleViewHolder", (String)((StringBuilder)object5).toString());
                } else {
                    Log.d((String)"ModuleViewHolder", (String)"s1:endIcon is null");
                }
            } else if ((Integer)object6 < 100) {
                object6 = ((Template)object).getProgressInfo();
                object6 = object6 != null ? ((ProgressInfo)object6).getPicMiddle() : null;
                object9 = this.getIcon((String)object6, (StatusBarNotification)object2);
                object6 = ((Template)object).getProgressInfo();
                object6 = object6 != null ? ((ProgressInfo)object6).getPicEndUnselected() : null;
                object6 = object8 = this.getIcon((String)object6, (StatusBarNotification)object2);
                if (object8 == null) {
                    object6 = ((Template)object).getProgressInfo();
                    object6 = object6 != null ? ((ProgressInfo)object6).getPicEnd() : null;
                    object6 = this.getIcon((String)object6, (StatusBarNotification)object2);
                }
                if (object5 != null) {
                    object5.setImageIcon((Icon)object9);
                }
                if (object7 != null) {
                    object7.setImageIcon((Icon)object6);
                }
                if (object9 != null) {
                    object5 = new StringBuilder();
                    ((StringBuilder)object5).append("s2:");
                    ((StringBuilder)object5).append(object9);
                    Log.d((String)"ModuleViewHolder", (String)((StringBuilder)object5).toString());
                } else {
                    Log.d((String)"ModuleViewHolder", (String)"s2:middleIcon is null");
                }
                if (object6 != null) {
                    object5 = new StringBuilder();
                    ((StringBuilder)object5).append("s2:");
                    ((StringBuilder)object5).append(object6);
                    Log.d((String)"ModuleViewHolder", (String)((StringBuilder)object5).toString());
                } else {
                    Log.d((String)"ModuleViewHolder", (String)"s2:endIcon is null");
                }
            } else {
                object6 = ((Template)object).getProgressInfo();
                object6 = object6 != null ? ((ProgressInfo)object6).getPicMiddle() : null;
                object8 = this.getIcon((String)object6, (StatusBarNotification)object2);
                object6 = ((Template)object).getProgressInfo();
                object6 = object6 != null ? ((ProgressInfo)object6).getPicEnd() : null;
                object6 = this.getIcon((String)object6, (StatusBarNotification)object2);
                if (object5 != null) {
                    object5.setImageIcon((Icon)object8);
                }
                if (object7 != null) {
                    object7.setImageIcon((Icon)object6);
                }
                if (object8 != null) {
                    object5 = new StringBuilder();
                    ((StringBuilder)object5).append("s3:");
                    ((StringBuilder)object5).append(object8);
                    Log.d((String)"ModuleViewHolder", (String)((StringBuilder)object5).toString());
                } else {
                    Log.d((String)"ModuleViewHolder", (String)"s3:middleIcon is null");
                }
                if (object6 != null) {
                    object5 = new StringBuilder();
                    ((StringBuilder)object5).append("s3:");
                    ((StringBuilder)object5).append(object6);
                    Log.d((String)"ModuleViewHolder", (String)((StringBuilder)object5).toString());
                } else {
                    Log.d((String)"ModuleViewHolder", (String)"s3:endIcon is null");
                }
            }
            object = ((Template)object).getProgressInfo();
            object = object != null ? ((ProgressInfo)object).getPicForward() : null;
            object = this.getIcon((String)object, (StatusBarNotification)object2);
            object2 = this.progressThumb;
            if (object2 != null) {
                object2.setImageIcon((Icon)object);
            }
            this.setProgressColor(this.progressBar, (Integer)object4, (Integer)object3);
            if (object != null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("s4:");
                ((StringBuilder)object2).append(object);
                Log.d((String)"ModuleViewHolder", (String)((StringBuilder)object2).toString());
            } else {
                Log.d((String)"ModuleViewHolder", (String)"s4:endIcon is null");
            }
            this.notifyDataChanged();
        }
    }

    public final boolean getIsland() {
        return this.island;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        this.setView(LayoutInflater.from((Context)this.getContext(this.island)).inflate(R.layout.focus_notification_module_progress, this.getRootView()));
        string = this.getView();
        Object var2_2 = null;
        string = string != null ? string.findViewById(R.id.progressbar_container) : null;
        this.container = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = (ImageView)view.findViewById(R.id.progress_icon);
        }
        this.progressThumb = string;
        this.registerCompressChanged(new a(this){
            final ModuleProgressViewHolder this$0;
            {
                this.this$0 = moduleProgressViewHolder;
                super(0);
            }

            public final void invoke() {
                ModuleProgressViewHolder moduleProgressViewHolder = this.this$0;
                ModuleProgressViewHolder.access$setProgressThumb(moduleProgressViewHolder, ModuleProgressViewHolder.access$getProgressBar$p(moduleProgressViewHolder), ModuleProgressViewHolder.access$getProgressThumb$p(this.this$0));
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
