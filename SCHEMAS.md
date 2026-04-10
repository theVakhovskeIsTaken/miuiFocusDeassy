# Dynamic Island: Exhaustive JSON Schemas

The `param_island` object is bound to stringent data models in the background. Here is the *exhaustive* list of all properties and child objects mapped exactly from the SystemUI `model` classes (`miui.systemui.dynamicisland.model.*`). 

### `PicInfo` (Icon & Image Settings)
Used whenever an image or animation must be rendered.
```json
"picInfo": {
  "type": 0,                      // 0: Resource ID/String, 1: File Path, 2: Lottie View
  "pic": "miui.focus.icon",       // Path, string, or resource identifier
  "loop": false,                  // For type 2 (Lottie): Should the animation loop?
  "autoplay": true,               // For type 2 (Lottie): Autoplay on display?
  "number": -1,                   // Internal grouping identifier
  "contentDescription": "Icon",   // Accessibility description
  "effectColor": "#FF0000",       // Shading effect applied specifically to this icon
  "effectSrc": "shader.json"      // Specific shader animation file to apply behind icon
}
```

### `ProgressInfo` (Progress Indicators)
Used primarily in `CombinePicInfo` or `ProgressTextInfo`.
```json
"progressInfo": {
  "progress": 75,                 // Integer 0-100 indicating percentage
  "colorReach": "#34C759",        // HEX Color of the "filled" portion
  "colorUnReach": "#E5E5EA",      // HEX Color of the "empty" background track
  "isCCW": false                  // Boolean mode: Count-Clockwise rendering
}
```

### `CombinePicInfo` (Small Island Badges)
Primarily used in `smallIslandArea` to wrap an icon with a ring progress indicator.
```json
"combinePicInfo": {
  "picInfo": { ... },             // The central image (inherits PicInfo)
  "smallPicInfo": { ... },        // An optional secondary/overlay image (inherits PicInfo)
  "progressInfo": { ... }         // The ring wrapped around the icon (inherits ProgressInfo)
}
```

### `FixedWidthDigitInfo` & `SameWidthDigitInfo` (Clocks/Timers/Scores)
Used to render performance-sensitive, highly animated digit displays without jitter.
```json
"fixedWidthDigitInfo": {          // OR "sameWidthDigitInfo":
  "content": "Score:",            // The static text prefix
  "digit": "24",                  // The numbers to render with fixed-width spacing
  "showHighlightColor": true,     // Tint using the root `highlightColor` 
  "turnAnim": true,               // Enables 3D flipping/turning animation when digits change
  
  // Specific to `SameWidthDigitInfo` only:
  "timerInfo": {
    "timerType": 0,               // 0: Count up, 1: Count down
    "timerTotal": 60000,          // Total timer length (ms) 
    "timerWhen": 1672531200000,   // Epoch absolute target time
    "timerSystemCurrent": 0       // System time reference point
  }
}
```

### `ImageTextInfo` (Standard Text Layouts)
The most common module type, especially for `imageTextInfoLeft` and `imageTextInfoRight`.
```json
"imageTextInfo": {
  "type": 1,                      // Layout Type Identifier (1-6)
  "picInfo": { ... },             // Rendered on the Left or Right boundary depending on type
  "textInfo": {                   // Basic Title/Subtitle rendering
    "title": "Main Header",
    "subTitle": "Details",
    "descText": "Footnote"
  },
  "progressInfo": { ... }         // Replaces SubTitle with a linear progress bar if type allows
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
