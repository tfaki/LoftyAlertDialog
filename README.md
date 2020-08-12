# LoftyAlertDialog

You can show them using the library's own statuses, you can customize it yourself if you want. You can show it with simple animation if you want and more.



### How to Install ?

You can add the library to your project using jitpack.io.

Add the code below to your project's gradle file.
```
 allprojects {
        repositories {
            jcenter()
            maven { url "https://jitpack.io" }
        }
   }
```

Add the code below to your app's gradle file.
```
implementation 'com.github.TalhaFaki:LoftyAlertDialog:1.0.0'

```

### How to Use ?

In this example, you can show alertdialog with the LoftyAlertDialog.

Show Default in MainActivity.java

```
 LoftyAlertView.Builder(this)
                .headerTitle("title")
                .alertMessage("message")
                .show()
```

Show two buttons in MainActivity.java

```
LoftyAlertView.Builder(this)
                .headerTitle("title")
                .alertMessage("message")
                .isTwoButton(true)
                .show()
```
If use alert state , you must setChangeable false  in MainActivity.java
```
LoftyAlertView.Builder(this)
                .alertType(AlertTypeState.ERROR)
                .setChangeable(false)
                .headerTitle("title")
                .alertMessage("message")
                .isTwoButton(true)
                .show()
```
If you want animation, you can add this line in MainActivity.java
```
LoftyAlertView.Builder(this)
                .alertType(AlertTypeState.ERROR)
                .setChangeable(false)
                .setAnimation(true)
                .headerTitle("title")
                .alertMessage("message")
                .isTwoButton(true)
                .show()
```
If you want customize in MainActivity.java
```
   LoftyAlertView.Builder(this)
                .setChangeable(true)
                .imageResId(R.drawable.you_want_image)
                .colorId(R.color.whatever_you_want_color)
                .rightButtonAction { 
                    // whatever you want
                }
                .headerTitle("title")
                .alertMessage("message")
                .isTwoButton(true)
                .show()
```
Happy Coding !
