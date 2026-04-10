# Dynamic Island: Exhaustive JSON Schemas

The `param_island` object is bound to stringent data models in the background. To make testing seamless, here is the *exhaustive* list of all properties and child objects mapped exactly from the SystemUI `model` classes (`miui.systemui.dynamicisland.model.*`), presented as **fully copy-pasteable JSON mockups** that you can drop directly into your testing payload.

### `PicInfo` (Icon & Image Settings)
Used whenever an image or animation must be rendered.
```json
{
  "param_v2": {
    "protocol": 3,
    "business": "pic_info_demo",
    "updatable": true,
    "isShowNotification": true,
    "param_island": {
      "islandPriority": 0,
      "smallIslandArea": {
        "picInfo": {
          "type": 0,
          "pic": "miui.focus.icon",
          "loop": false,
          "autoplay": true,
          "number": -1,
          "contentDescription": "Icon",
          "effectColor": "#FF0000"
        }
      }
    },
    "baseInfo": { "type": 1, "title": "PicInfo Demo", "content": "Testing PicInfo" },
    "iconTextInfo": { "animIconInfo": { "type": 0, "src": "miui.focus.icon" }, "title": "PicInfo Demo", "content": "Testing PicInfo" }
  },
  "isShowNotification": true
}
```

### `ProgressInfo` (Progress Indicators)
Used primarily in `CombinePicInfo` or `ProgressTextInfo`.
```json
{
  "param_v2": {
    "protocol": 3,
    "business": "progress_demo",
    "updatable": true,
    "isShowNotification": true,
    "param_island": {
      "islandPriority": 0,
      "bigIslandArea": {
        "imageTextInfoLeft": {
          "type": 1,
          "textInfo": { "title": "Downloading..." }
        },
        "progressTextInfo": {
          "progressInfo": {
            "progress": 75,
            "colorReach": "#34C759",
            "colorUnReach": "#E5E5EA",
            "isCCW": false
          }
        }
      }
    },
    "baseInfo": { "type": 1, "title": "ProgressInfo Demo", "content": "Testing ProgressInfo" },
    "iconTextInfo": { "animIconInfo": { "type": 0, "src": "miui.focus.icon" }, "title": "ProgressInfo Demo", "content": "Testing ProgressInfo" }
  },
  "isShowNotification": true
}
```

### `CombinePicInfo` (Small Island Badges)
Primarily used in `smallIslandArea` to wrap an icon with a ring progress indicator.
```json
{
  "param_v2": {
    "protocol": 3,
    "business": "combine_pic_demo",
    "updatable": true,
    "isShowNotification": true,
    "param_island": {
      "islandPriority": 0,
      "smallIslandArea": {
        "combinePicInfo": {
          "picInfo": { "type": 0, "pic": "ic_download" },
          "smallPicInfo": { "type": 0, "pic": "ic_status" },
          "progressInfo": { "progress": 45, "colorReach": "#0A84FF", "isCCW": false }
        }
      }
    },
    "baseInfo": { "type": 1, "title": "CombinePic Demo", "content": "Testing CombinePicInfo" },
    "iconTextInfo": { "animIconInfo": { "type": 0, "src": "miui.focus.icon" }, "title": "CombinePic Demo", "content": "Testing CombinePicInfo" }
  },
  "isShowNotification": true
}
```

### `ShareData` (Drag & Drop Intent Creation)
This completely undocumented model enables **Native Drag & Drop**. If present, a user can literally drag the island down or onto another app to invoke Android's global Share menu or initiate a Drag & Drop transfer!
```json
{
  "param_v2": {
    "protocol": 3,
    "business": "share_data_demo",
    "updatable": true,
    "isShowNotification": true,
    "param_island": {
      "islandPriority": 0,
      "shareData": {
        "title": "Shared Title",
        "content": "Description",
        "pic": "ic_share_preview",
        "shareContent": "URL or Payload",
        "sharePic": "ic_share_image"
      },
      "smallIslandArea": { "picInfo": { "type": 0, "pic": "ic_share" } },
      "bigIslandArea": { "imageTextInfoLeft": { "type": 1, "picInfo": { "type": 0, "pic": "ic_share" }, "textInfo": { "title": "Drag to share!" } } }
    },
    "baseInfo": { "type": 1, "title": "ShareData Demo", "content": "Testing ShareData" },
    "iconTextInfo": { "animIconInfo": { "type": 0, "src": "miui.focus.icon" }, "title": "ShareData Demo", "content": "Testing ShareData" }
  },
  "isShowNotification": true
}
```

### `FixedWidthDigitInfo` & `SameWidthDigitInfo` (Clocks/Timers/Scores)
Used to render performance-sensitive, highly animated digit displays without jitter.
```json
{
  "param_v2": {
    "protocol": 3,
    "business": "digit_demo",
    "updatable": true,
    "isShowNotification": true,
    "param_island": {
      "islandPriority": 0,
      "bigIslandArea": {
        "sameWidthDigitInfo": {
          "content": "Score: ",
          "digit": "24",
          "showHighlightColor": true,
          "turnAnim": true,
          "timerInfo": {
            "timerType": 0,
            "timerTotal": 60000,
            "timerWhen": 1672531200000,
            "timerSystemCurrent": 0
          }
        }
      }
    },
    "baseInfo": { "type": 1, "title": "DigitInfo Demo", "content": "Testing DigitInfo" },
    "iconTextInfo": { "animIconInfo": { "type": 0, "src": "miui.focus.icon" }, "title": "DigitInfo Demo", "content": "Testing DigitInfo" }
  },
  "isShowNotification": true
}
```

### `TextInfo` (Typographic Control & Titles)
Used as the basic building block for text manipulation, supporting narrow fonts and custom styling.
```json
{
  "param_v2": {
    "protocol": 3,
    "business": "text_info_demo",
    "updatable": true,
    "isShowNotification": true,
    "param_island": {
      "islandPriority": 0,
      "bigIslandArea": {
        "imageTextInfoLeft": {
          "type": 1,
          "textInfo": {
            "content": "Main Body",
            "frontTitle": "Prefix: ",
            "title": "Header",
            "isTitleDigit": true,
            "narrowFont": true,
            "showHighlightColor": true,
            "turnAnim": true
          }
        }
      }
    },
    "baseInfo": { "type": 1, "title": "TextInfo Demo", "content": "Testing TextInfo" },
    "iconTextInfo": { "animIconInfo": { "type": 0, "src": "miui.focus.icon" }, "title": "TextInfo Demo", "content": "Testing TextInfo" }
  },
  "isShowNotification": true
}
```

### `ImageTextInfo` (Standard Text Layouts)
The most common module type, especially for `imageTextInfoLeft` and `imageTextInfoRight`.
```json
{
  "param_v2": {
    "protocol": 3,
    "business": "image_text_demo",
    "updatable": true,
    "isShowNotification": true,
    "param_island": {
      "islandPriority": 0,
      "bigIslandArea": {
        "imageTextInfoLeft": {
          "type": 1,
          "picInfo": { "type": 0, "pic": "ic_status" },
          "textInfo": { "title": "Main Header", "subTitle": "Details", "descText": "Footnote" }
        }
      }
    },
    "baseInfo": { "type": 1, "title": "ImageText Demo", "content": "Testing ImageTextInfo" },
    "iconTextInfo": { "animIconInfo": { "type": 0, "src": "miui.focus.icon" }, "title": "ImageText Demo", "content": "Testing ImageTextInfo" }
  },
  "isShowNotification": true
}
```

### The Ultimate `param_island` Payload Example
This example demonstrates deploying nearly every supported rendering feature simultaneously. 

```json
{
  "param_v2": {
    "protocol": 3,
    "business": "com.example.playground_island",
    "updatable": true,
    "isShowNotification": true,
    
    "param_island": {
      "islandPriority": 0,
      "islandTimeout": 5000,
      "expandedTime": 10000,
      "highlightColor": "#007AFF",
      "needCloseAnimation": true,
    
      "picInfo": {
        "type": 0,
        "pic": "ic_system_update",
        "loop": true
      },
    
      "smallIslandArea": {
        "combinePicInfo": {
          "picInfo": {
            "type": 0,
            "pic": "ic_system_update"
          },
          "progressInfo": {
            "progress": 33,
            "colorReach": "#007AFF",
            "isCCW": false
          }
        }
      },
      "bigIslandArea": {
        "imageTextInfoLeft": {
          "type": 1,
          "picInfo": {
            "type": 0,
            "pic": "ic_system_update",
            "effectColor": "#007AFF"
          },
          "textInfo": {
            "title": "System Update",
            "subTitle": "Preparing..."
          }
        },
        "sameWidthDigitInfo": {
          "content": "Time Left: ",
          "digit": "05:00",
          "showHighlightColor": true,
          "turnAnim": true,
          "timerInfo": {
            "timerType": 1,
            "timerTotal": 300000,
            "timerWhen": 0,
            "timerSystemCurrent": 0
          }
        }
      }
    },
    
    "baseInfo": {
      "type": 1,
      "title": "System Update",
      "content": "Preparing to install..."
    },
    "iconTextInfo": {
      "animIconInfo": {
        "type": 0,
        "src": "ic_system_update",
        "loop": true,
        "autoplay": true
      },
      "title": "System Update",
      "content": "Preparing to install..."
    }
  },
  "isShowNotification": true
}
```
