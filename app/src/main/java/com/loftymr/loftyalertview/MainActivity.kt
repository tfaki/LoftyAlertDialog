package com.loftymr.loftyalertview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview.setOnClickListener {
            LoftyAlertView.Builder(this)
                .alertType(AlertTypeState.WARNING)
                .setChangeable(false)
                .setAnimation(true)
                .colorId(R.color.gray)
                .imageResId(R.drawable.ic_launcher_foreground)
                .headerTitle("header")
                .alertMessage("message")
                .leftButtonText("okeee")
                .isTwoButton(false)
                .show()
        }

    }
}