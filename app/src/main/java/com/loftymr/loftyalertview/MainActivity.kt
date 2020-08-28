package com.loftymr.loftyalertview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationSet
import android.widget.Toast
import android.widget.ToggleButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview.setOnClickListener {
            LoftyAlertView.Builder(this)
                .alertType(AlertTypeState.WARNING)
                .setChangeable(true)
                .setAnimation(true)
                .colorId(R.color.gray)
                .imageResId(R.drawable.ic_launcher_foreground)
                .headerTitle("header")
                .alertMessage("message")
                .leftButtonText("okeee")
                .isTwoButton(true)
                .onDismissCallback {
                    textview.text = "dismissed"
                }
                .onShownCallback {
                    Toast.makeText(this, "showing", Toast.LENGTH_LONG).show()
                }
                .show()
        }

    }
}