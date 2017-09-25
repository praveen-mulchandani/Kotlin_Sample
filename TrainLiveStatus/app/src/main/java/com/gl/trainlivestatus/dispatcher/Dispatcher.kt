package com.gl.trainlivestatus.dispatcher

import com.gl.trainlivestatus.actionHandler.IEvent
import com.squareup.otto.Bus
import javax.inject.Inject

/**
 * Responsible for dispatching the event over the event bus
 */
class Dispatcher @Inject constructor(var mBus: Bus) {
    /**
     * Dispatches the given Event over the Event Bus

     * @param event : Even to  be dispatched
     */
    fun dispatch(event: IEvent) {
        mBus.post(event)
    }
}