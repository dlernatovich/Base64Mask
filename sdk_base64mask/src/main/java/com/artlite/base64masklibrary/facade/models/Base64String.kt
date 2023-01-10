package com.artlite.base64masklibrary.facade.models

import androidx.annotation.StringRes
import com.artlite.base64masklibrary.facade.helpers.Base64MaskHelper
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Base 64 String functional.
 */
interface Base64String {

    /**
     * [Int] value of the steps.
     */
    val steps: Int

    /**
     * [Int] value of the [String] resources.
     */
    val stringRes: Int?

    /**
     * [String] value of the masked.
     */
    val string: String?

}