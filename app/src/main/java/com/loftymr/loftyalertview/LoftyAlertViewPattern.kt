package com.loftymr.loftyalertview

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.lofty_alert_view.*

class LoftyAlertView(
    context: Context,
    val layoutId: Int,
    var imageResId: Int,
    var colorId: Int,
    var headerTitle: String,
    val isTwoButton: Boolean,
    val rightButtonText: String,
    val leftButtonText: String,
    val alertType: AlertTypeState,
    val alertMessage: String,
    val cancelable: Boolean,
    val rightButtonAction: (() -> Unit)? = null,
    val leftButtonAction: (() -> Unit)? = null,
    val changeable: Boolean,
    val animation: Boolean,
    val onDismissCallback: (() -> Unit)? = null,
    val onShownCallback: (() -> Unit)? = null) : AlertDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        leftButton.visibility = if (isTwoButton) View.VISIBLE else View.GONE

        rightButton.text = rightButtonText

        leftButton.text = leftButtonText

        rightButton.setOnClickListener {
            rightButtonAction?.invoke()
            dismiss()
        }

        leftButton.setOnClickListener {
            leftButtonAction?.invoke()
            dismiss()
        }

        setOnDismissListener {
            onDismissCallback?.invoke()
        }

        setOnShowListener {
            onShownCallback?.invoke()
        }

        when(alertType){
            AlertTypeState.WARNING -> {
                if (!changeable){
                    imageResId = R.drawable.ic_alert_warning_icon
                    colorId = R.color.yellow
                    leftButton.setTextColor(ContextCompat.getColor(context, colorId))
                    leftButton.setStrokeColorResource(colorId)
                } else {
                    leftButton.setTextColor(ContextCompat.getColor(context, colorId))
                    leftButton.setStrokeColorResource(colorId)
                }
            }
            AlertTypeState.ERROR -> {
                if (!changeable){
                    imageResId = R.drawable.ic_alert_error_icon
                    colorId = R.color.red
                    leftButton.setTextColor(ContextCompat.getColor(context, colorId))
                    leftButton.setStrokeColorResource(colorId)
                } else {
                    leftButton.setTextColor(ContextCompat.getColor(context, colorId))
                    leftButton.setStrokeColorResource(colorId)
                }
            }
            AlertTypeState.INFO -> {
                if (!changeable){
                    imageResId = R.drawable.ic_alert_info_icon
                    colorId = R.color.blue
                    leftButton.setTextColor(ContextCompat.getColor(context, colorId))
                    leftButton.setStrokeColorResource(colorId)
                } else {
                    leftButton.setTextColor(ContextCompat.getColor(context, colorId))
                    leftButton.setStrokeColorResource(colorId)
                }
            }
        }

        rightButton.backgroundTintList = ContextCompat.getColorStateList(context, colorId)
        caption.text = headerTitle
        imageView.setImageResource(imageResId)
        headerBottomLine.setBackgroundResource(colorId)
        tvMessage.text = alertMessage
        setCancelable(cancelable)
    }


    override fun onStart() {
        super.onStart()
        if (animation){
            window!!.setWindowAnimations(R.style.DialogNoAnimation)
        }
    }


    open class Builder(private var context: Context) {
        private var layoutId: Int = R.layout.lofty_alert_view
        private var imageResId: Int = R.drawable.ic_alert_warning_icon
        private var colorId: Int = R.color.blue
        private var headerTitle: String = context.getString(R.string.alert_warning_title)
        private var isTwoButton: Boolean = false
        private var rightButtonText: String = context.getString(R.string.ok)
        private var leftButtonText: String = context.getString(R.string.cancel)
        private var alertType: AlertTypeState = AlertTypeState.DEFAULT
        private var alertMessage: String = ""
        private var cancelable: Boolean = false
        private var changeable: Boolean = true
        private var animation: Boolean = false
        private var rightButtonAction: (() -> Unit)? = null
        private var leftButtonAction: (() -> Unit)? = null
        private var onDismissCallback: (() -> Unit)? = null
        private var onShownCallback: (() -> Unit)? = null

        fun layoutId(layoutId: Int) = apply { this.layoutId = layoutId }
        fun imageResId(imageResId: Int) = apply { this.imageResId = imageResId }
        fun colorId(colorId: Int) = apply { this.colorId = colorId }
        fun headerTitle(headerTitle: String) = apply { this.headerTitle = headerTitle }
        fun isTwoButton(isTwoButton: Boolean) = apply { this.isTwoButton = isTwoButton }
        fun rightButtonText(rightButtonText: String) = apply { this.rightButtonText = rightButtonText }
        fun leftButtonText(leftButtonText: String) = apply { this.leftButtonText = leftButtonText }
        fun alertType(alertType: AlertTypeState) = apply { this.alertType = alertType }
        fun alertMessage(alertTypeMessage: String) = apply { this.alertMessage = alertTypeMessage }
        fun setCancelable(cancelable: Boolean) = apply { this.cancelable = cancelable }
        fun setChangeable(changeable: Boolean) = apply { this.changeable = changeable }
        fun setAnimation(animation: Boolean) = apply { this.animation = animation }
        fun rightButtonAction(rightButtonAction: (() -> Unit)) = apply { this.rightButtonAction = rightButtonAction }
        fun leftButtonAction(leftButtonAction: (() -> Unit)?) = apply { this.leftButtonAction = leftButtonAction }
        fun onDismissCallback(onDismissCallback: (() -> Unit)?) = apply { this.onDismissCallback = onDismissCallback }
        fun onShownCallback(onShownCallback: (() -> Unit)?) = apply { this.onShownCallback = onShownCallback }

        fun show() = LoftyAlertView(
            context,
            layoutId,
            imageResId,
            colorId,
            headerTitle,
            isTwoButton,
            rightButtonText,
            leftButtonText,
            alertType,
            alertMessage,
            cancelable,
            rightButtonAction,
            leftButtonAction,
            changeable,
            animation,
            onDismissCallback,
            onShownCallback
        ).show()
    }


}


enum class AlertTypeState {
    INFO, WARNING, ERROR, DEFAULT
}