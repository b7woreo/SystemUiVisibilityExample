# SystemUIVisibilityDemo

该工程演示了 Android 中正确处理绘制系统状态栏和系统导航栏区域的方式。

## 涉及的概念
### SystemUiVisibility
通过 ```View.setSystemUiVisibility()``` 设置状态栏、导航栏及布局相关状态，相关参数：  
* ```View.SYSTEM_UI_FLAG_FULLSCREEN```：隐藏状态栏
* ```View.SYSTEM_UI_FLAG_HIDE_NAVIGATION```：隐藏导航栏  
* ```View.SYSTEM_UI_FLAG_LAYOUT_STABLE```：当使用 ```View.SYSTEM_UI_FLAG_FULLSCREEN``` 或 ```View.SYSTEM_UI_FLAG_HIDE_NAVIGATION``` 导致状态栏或导航栏显示状态发生变化时，不会触发布局刷新
* ```View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN```：应用布局时使用状态栏区域  
* ```View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION```：应用布局时使用导航栏区域  

### fitsSystemWindows
设置控件是否处理 WindowInsets，当值为 true 时，控件默认通过增加 padding 值处理 WindowInsets。
AndroidSdk < 20 可以通过重写 ```View.fitSystemWindows(Rect)``` 自定义 WindowInsets 的处理方式，AndroidSdk >= 20 可以通过重写 ```View.onApplyWindowInsets(WindowInsets)```或设置 ```View.OnApplyWindowInsetsListener``` 达到同样的效果。

### 主题样式
* v19：
  * ```<item name="android:windowTranslucentStatus">true</item>```：设置状态栏为半透明
  * ```<item name="android:windowTranslucentNavigation">true</item>```：设置导航栏为半透明
* v21：
  * ```<item name="android:statusBarColor">@android:color/transparent</item>```：设置状态栏为透明
  * ```<item name="android:navigationBarColor">@android:color/transparent</item>```：设置导航栏为透明
* v28：
  * ```<item name="android:windowLayoutInDisplayCutoutMode">shortEdges</item>```：设置应用可以利用”刘海屏“的”刘海“区域
