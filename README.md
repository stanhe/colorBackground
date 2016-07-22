# colorBackground
Can change color background
## description
it used as a picture covered on the imageview in Android,it looks translucent,you can put an bitmap under it,and it will auto change background color

## how to use
compile 'com.stanhe:auto_change_bgColor:1.0.0'

### layout
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.stan.d0601_background.Bg_MainActivity"
    android:background="@drawable/littlehuang">
    <com.example.stan.mylibrary.GradientImageView
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
    </RelativeLayout>
    

