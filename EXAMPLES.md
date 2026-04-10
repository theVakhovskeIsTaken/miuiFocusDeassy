# Dynamic Island: The Grimoire (Examples)

This section contains copy-pasteable templates for the most extreme, boundary-pushing configurations the Dynamic Island supports. Each example includes the perfect JSON payload paired with the exact Kotlin `NotificationCompat.Builder` code required to trigger it.

### Example A: The Custom RemoteViews Injector (Bypassing JSON entirely)
This completely escapes the rigid MIUI templating engine by injecting your own Native Android XML layout.

**Code Builder:**
```kotlin
val remoteViews = RemoteViews(context.packageName, R.layout.my_insane_island_layout)
// Setup your custom RemoteViews data...

val focusParamCustom = """
{
  "param_v2": {
    "protocol": 3,
    "business": "remote_view_hijack",
    "updatable": true,
    "islandPriority": 0,
    "highlightColor": "#FF0055",
    "param_island": {
      "smallIslandArea": {}, 
      "bigIslandArea": {} // Heights/Widths are calculated off the RV
    }
  }
}
""".trimIndent()

val builder = NotificationCompat.Builder(context, "island_channel")
    .setSmallIcon(R.drawable.ic_notification)
    .setContentTitle("Secret Layout")
    .setContentText("Check the island.")
    .addExtras(Bundle().apply {
        putParcelable("miui.focus.rv", remoteViews)
        putString("miui.focus.param.custom", focusParamCustom) // Notice the .custom suffix!
        putBoolean("miui.exitFloating", true) // Allow floating window on exit
    })

notificationManager.notify(1337, builder.build())
```

### Example B: The Real-Time Sports Score & Countdown
Using `sameWidthDigitInfo` guarantees that flipping numbers (like a clock) won't jitter or cause layout layout-shifts, complete with 3D flip animations (`turnAnim`).

**Code Builder:**
```kotlin
val paramJson = """
{
  "param_v2": {
    "protocol": 3,
    "business": "sports_ticker",
    "updatable": true,
    "isShowNotification": true,
    "islandPriority": 0,
    "highlightColor": "#FFCC00",
    "param_island": {
      "smallIslandArea": {
        "picInfo": { "type": 0, "pic": "ic_sports_basketball" }
      },
      "bigIslandArea": {
        "imageTextInfoLeft": {
          "type": 1,
          "picInfo": { "type": 0, "pic": "ic_team_logo" },
          "textInfo": { "title": "LAL", "subTitle": "112" }
        },
        "sameWidthDigitInfo": {
          "content": "Q4 ",
          "digit": "02:15",
          "showHighlightColor": true,
          "turnAnim": true,
          "timerInfo": {
            "timerType": 1,
            "timerTotal": 720000, 
            "timerWhen": 1729372100000, 
            "timerSystemCurrent": 1729371965000 
          }
        }
      }
      }
    },
    "baseInfo": {
      "type": 1,
      "title": "LAL takes the lead!",
      "content": "Quarter 4 ending..."
    },
    "iconTextInfo": {
      "animIconInfo": { "type": 0, "src": "ic_sports" },
      "title": "LAL takes the lead!",
      "content": "Quarter 4 ending..."
    }
  },
  "isShowNotification": true
}
""".trimIndent()

val extras = Bundle().apply {
    putString("miui.focus.param", paramJson)
    // Ticker data slides across the screen before island opens
    putString("miui.ticker.data", Base64.encodeToString("LAL takes the lead!".toByteArray(), Base64.NO_WRAP))
}

val builder = NotificationCompat.Builder(context, "sports_channel")
    .setSmallIcon(R.drawable.ic_sports)
    .addExtras(extras)
```

### Example C: The Animated Lottie Aura (Shader Injection)
A combination of a Lottie animation file played natively over the icon, combined with custom glowing background edge effects (`miui.effect.src`).

**Code Builder:**
```kotlin
val paramJson = """
{
  "param_v2": {
    "protocol": 3,
    "business": "magical_item_found",
    "updatable": true,
    "isShowNotification": true,
    "highlightColor": "#9932CC",
    "picInfo": {
      "type": 2, // Type 2 is LOTTIE
      "pic": "raw_lottie_sparkles_id", 
      "loop": true,
      "autoplay": true
    },
    "param_island": {
      "smallIslandArea": {
        "picInfo": { "type": 2, "pic": "raw_lottie_sparkles_id", "loop": true }
      },
      "bigIslandArea": {
        "imageTextInfoLeft": {
          "type": 1,
          "picInfo": { "type": 2, "pic": "raw_lottie_sparkles_id", "loop": true },
          "textInfo": {
            "title": "Legendary Drop!",
            "subTitle": "Tap to claim..."
          }
        }
      }
        }
      }
    },
    "baseInfo": {
      "type": 1,
      "title": "Legendary Drop!",
      "content": "Tap to claim..."
    },
    "iconTextInfo": {
      "animIconInfo": { "type": 0, "src": "ic_loot" },
      "title": "Legendary Drop!",
      "content": "Tap to claim..."
    }
  },
  "isShowNotification": true
}
""".trimIndent()

val extras = Bundle().apply {
    putString("miui.focus.param", paramJson)
    // Tint the blur shadow
    putString("miui.effect.color", "#9932CC")
    // Inject a lottie animation directly into the background edge shader
    putString("miui.bigIsland.effect.src", "anim_aura_glow.json") 
    putString("miui.effect.src", "anim_aura_glow.json")
}

val builder = NotificationCompat.Builder(context, "game_channel")
    .setSmallIcon(R.drawable.ic_loot)
    .addExtras(extras)
```

### Example D: The Bitmap Bundle Bypass (No resources needed)
Instead of passing resource integers, you can pipe raw `Bitmap` objects into the island bypassing the file system.

**Code Builder:**
```kotlin
// Create a bundle holding our actual live bitmaps
val bitmapBundle = Bundle().apply {
    putParcelable("live_avatar", userAvatarBitmap)
    putParcelable("live_preview", cameraPreviewBitmap)
}

val paramJson = """
{
  "param_v2": {
    "protocol": 3,
    "business": "video_call",
    "updatable": true,
    "isShowNotification": true,
    "highlightColor": "#34C759",
    "param_island": {
      "smallIslandArea": {
        "picInfo": { "type": 0, "pic": "live_avatar" } // Resolves from Bundle!
      },
      "bigIslandArea": {
        "imageTextInfoLeft": {
          "type": 1,
          "picInfo": { "type": 0, "pic": "live_avatar" },
          "textInfo": {
            "title": "Incoming Call",
            "subTitle": "Mom"
          }
        },
        "imageTextInfoRight": {
          "type": 6, // ModuleTextOverIcon (Large square video preview layout)
          "picInfo": { "type": 0, "pic": "live_preview" } // Resolves from Bundle!
        }
        }
      }
    },
    "baseInfo": {
      "type": 1,
      "title": "Incoming Call",
      "content": "Mom"
    },
    "iconTextInfo": {
      "animIconInfo": { "type": 0, "src": "ic_call" },
      "title": "Incoming Call",
      "content": "Mom"
    }
  },
  "isShowNotification": true
}
""".trimIndent()

val extras = Bundle().apply {
    putString("miui.focus.param", paramJson)
    // Hook up the image map
    putBundle("miui.focus.pics", bitmapBundle)
    // Force this to be promoted (cannot be swiped away normally)
    putBoolean("miui.focus.isPromoted", true)
}

val builder = NotificationCompat.Builder(context, "call_channel")
    .setSmallIcon(R.drawable.ic_call)
    .addExtras(extras)
```

### Example E: The Concentric Progress Rings (Apple Style)
This recreates the complex layered progress rings using `moduleCombinePic` in the small view and `moduleImageText_3` in the expanded view.

**Code Builder:**
```kotlin
val paramJson = """
{
  "param_v2": {
    "protocol": 3,
    "business": "cloud_sync",
    "updatable": true,
    "isShowNotification": true,
    "islandPriority": 1,
    "highlightColor": "#0A84FF",
    "param_island": {
      "smallIslandArea": {
        "combinePicInfo": {
          "picInfo": { "type": 0, "pic": "ic_cloud" },
          "smallPicInfo": { "type": 0, "pic": "ic_sync_arrow" },
          "progressInfo": {
            "progress": 82,
            "colorReach": "#0A84FF",
            "colorUnReach": "#330A84FF",
            "isCCW": false 
          }
        }
      },
      "bigIslandArea": {
        "imageTextInfoLeft": {
          "type": 1,
          "picInfo": { "type": 0, "pic": "ic_cloud" },
          "textInfo": {
            "title": "Backing up to Xiaomi Cloud",
            "subTitle": "82% - 4 mins remaining" 
          }
        },
        "progressTextInfo": {
          "progressInfo": {
            "progress": 82,
            "colorReach": "#0A84FF",
            "colorUnReach": "#330A84FF",
            "isCCW": false
          }
        }
      }
      }
    },
    "baseInfo": {
      "type": 1,
      "title": "Backing up to Xiaomi Cloud",
      "content": "82% - 4 mins remaining"
    },
    "iconTextInfo": {
      "animIconInfo": { "type": 0, "src": "ic_cloud" },
      "title": "Backing up to Xiaomi Cloud",
      "content": "82% - 4 mins remaining"
    }
  },
  "isShowNotification": true
}
""".trimIndent()

val builder = NotificationCompat.Builder(context, "sync_channel")
    .setSmallIcon(R.drawable.ic_sync)
    .addExtras(Bundle().apply { putString("miui.focus.param", paramJson) })
```

### Example F: Drag & Drop Sharing + Narrow Fonts (TextInfo & ShareData)
This example highlights typography control (`narrowFont`) and includes the elusive `shareData` root property. When expanded, the user can long-press and drag the island out of the status bar to invoke Android's global Drag-and-Drop / Intent Share framework, transferring a payload or image into a dropping app.

**Code Builder:**
```kotlin
val paramJson = """
{
  "param_v2": {
    "protocol": 3,
    "business": "shareable_clipboard",
    "updatable": true,
    "isShowNotification": true,
    "highlightColor": "#FF3B30",
    "param_island": {
      "shareData": {
        "title": "Copied Text",
        "content": "Drag to share anywhere!",
        "pic": "ic_drag_preview",
        "shareContent": "Hey, check out this secret copied text!",
        "sharePic": ""
      },
      "smallIslandArea": {
        "picInfo": { "type": 0, "pic": "ic_clipboard" }
      },
      "bigIslandArea": {
        "imageTextInfoLeft": {
          "type": 1,
          "picInfo": { "type": 0, "pic": "ic_clipboard" },
          "textInfo": {
            "title": "Clipboard Manager",
            "isTitleDigit": true,        // Uses System Clock UI Font
            "narrowFont": true,          // Compresses width
            "turnAnim": true             // Flips letters vertically
          }
        },
        "imageTextInfoRight": {
          "type": 6,                     // ModuleTextOverIcon layout
          "textInfo": {
            "content": "DRAG ME",
            "showHighlightColor": true
          }
        }
      }
    },
    "baseInfo": {
      "type": 1,
      "title": "Copied to Clipboard",
      "content": "Drag from Island to share."
    },
    "iconTextInfo": {
      "animIconInfo": { "type": 0, "src": "ic_clipboard" },
      "title": "Copied to Clipboard",
      "content": "Drag from Island to share."
    }
  },
  "isShowNotification": true
}
""".trimIndent()

val builder = NotificationCompat.Builder(context, "clipboard_channel")
    .setSmallIcon(R.drawable.ic_clipboard)
    .addExtras(Bundle().apply { putString("miui.focus.param", paramJson) })
```
