package com.artlite.base64mask.ui.abs

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * Base activity class.
 */
open class BaseActivity(@LayoutRes private val layout: Int) : AppCompatActivity() {

    /**
     * Method which provide the create functional.
     * @param savedInstanceState Bundle?
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(layout)
    }

}