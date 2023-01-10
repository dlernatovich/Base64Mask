package com.artlite.base64masklibrary.impl.models

import androidx.annotation.StringRes
import com.artlite.base64masklibrary.facade.helpers.Base64MaskHelper
import com.artlite.base64masklibrary.facade.models.Base64String
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Class which provide the base
 */
final class Base64StringEncoder: ReadOnlyProperty<Any?, String?>, Base64String {

    /** [Int] value of the steps. */
    override val steps: Int

    /** [Int] value of the [String] resources. */
    override val stringRes: Int?

    /** [String] value of the masked. */
    override val string: String?

    /** [String] value of the decoded. */
    private var decoded: String? = null

    /**
     * Constructor which provide to create the [Base64StringEncoder].
     * @param steps Int value.
     * @param stringRes Int value.
     * @constructor
     */
    constructor(steps: Int, @StringRes stringRes: Int) : super() {
        this.steps = steps
        this.stringRes = stringRes
        this.string = null
    }

    /**
     * Constructor which provide to create the [Base64StringEncoder].
     * @param steps Int value.
     * @param string String instance.
     * @constructor
     */
    constructor(steps: Int, string: String?) : super() {
        this.steps = steps
        this.stringRes = null
        this.string = string
    }

    /**
     * Returns the value of the property for the given object.
     * @param thisRef the object for which the value is requested.
     * @param property the metadata for the property.
     * @return the property value.
     */
    override fun getValue(thisRef: Any?, property: KProperty<*>): String? {
        val encoder by Base64MaskHelper()
        if (decoded == null) {
            decoded = when(stringRes) {
                null -> when(string) {
                    null -> null
                    else -> encoder.encode(string, steps)
                }
                else -> encoder.encode(stringRes, steps)
            }
        }
        return decoded
    }

}

/**
 * Class which provide the base
 */
final class Base64StringDecoder: ReadOnlyProperty<Any?, String?>, Base64String {

    /** [Int] value of the steps. */
    override val steps: Int

    /** [Int] value of the [String] resources. */
    override val stringRes: Int?

    /** [String] value of the masked. */
    override val string: String?

    /** [String] value of the decoded. */
    private var decoded: String? = null

    /**
     * Constructor which provide to create the [Base64StringDecoder].
     * @param steps Int value.
     * @param stringRes Int value.
     * @constructor
     */
    constructor(steps: Int, @StringRes stringRes: Int) : super() {
        this.steps = steps
        this.stringRes = stringRes
        this.string = null
    }

    /**
     * Constructor which provide to create the [Base64StringDecoder].
     * @param steps Int value.
     * @param string String instance.
     * @constructor
     */
    constructor(steps: Int, string: String?) : super() {
        this.steps = steps
        this.stringRes = null
        this.string = string
    }

    /**
     * Returns the value of the property for the given object.
     * @param thisRef the object for which the value is requested.
     * @param property the metadata for the property.
     * @return the property value.
     */
    override fun getValue(thisRef: Any?, property: KProperty<*>): String? {
        val encoder by Base64MaskHelper()
        if (decoded == null) {
            decoded = when(stringRes) {
                null -> when(string) {
                    null -> null
                    else -> encoder.decode(string, steps)
                }
                else -> encoder.decode(stringRes, steps)
            }
        }
        return decoded
    }

}