package com.artlite.base64mask.core

import android.app.Application
import android.content.Context
import com.artlite.base64mask.R
import com.artlite.base64masklibrary.facade.core.SdkBase64Mask
import com.artlite.base64masklibrary.impl.models.Base64StringDecoder
import com.artlite.base64masklibrary.impl.models.Base64StringEncoder

/**
 * Current application class.
 */
class CurrentApplication: Application() {

    /**
     * Instance of the Base64 Mask library.
     */
    private val base64Mask by SdkBase64Mask()

    /**
     * Method which provide the action when application created.
     */
    override fun onCreate() {
        super.onCreate()
        this.base64Mask.onCreate(this)
        this.test(this)
    }

    /**
     * Method which provide the test functionality.
     * @param context Context instance.
     */
    private fun test(context: Context) {
        val steps = context.resources.getInteger(R.integer.test_steps)
        val encoded: String? by Base64StringEncoder(steps, R.string.test_normal)
        val decoded: String? by Base64StringDecoder(steps, R.string.test_masked)

        println(encoded)
        println(decoded)
    }

}