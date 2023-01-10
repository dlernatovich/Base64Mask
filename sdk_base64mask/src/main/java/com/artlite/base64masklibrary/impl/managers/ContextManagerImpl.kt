package com.artlite.base64masklibrary.impl.managers

import android.content.Context
import com.artlite.base64masklibrary.facade.managers.ContextManager
import java.lang.ref.WeakReference

/**
 * Implementation of the [ContextManager].
 */
internal object ContextManagerImpl: ContextManager {

    /**
     * Instance of the [WeakReference].
     */
    private var weakContext: WeakReference<Context>? = null

    /**
     * Method which provide the getting of the [Context].
     * @return Context? instance.
     */
    @Synchronized
    override fun getContext(): Context? = weakContext?.get()

    /**
     * Method which provide to get of the required [Context].
     * @return Context instance of the required [Context].
     */
    @Synchronized
    override fun getRequiredContext(): Context = getContext()!!

    /**
     * Method which provide the set of the [Context].
     * @param context Context? instance.
     */
    @Synchronized
    override fun set(context: Context?) {
        if (context == null) return
        this.weakContext = WeakReference(context)
    }

    /**
     * Method which provide the clear functionality.
     */
    override fun clear() {
        this.weakContext = null
    }

}