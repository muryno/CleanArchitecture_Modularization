package com.muryno.muzic.component.receivers

import android.content.Context
import com.kylecorry.trail_sense.receivers.TrailSenseServiceUtils
import com.kylecorry.trail_sense.shared.commands.Command

class RestartServicesCommand(private val context: Context, private val isBackground: Boolean): Command {
    override fun execute() {
        TrailSenseServiceUtils.restartServices(context, isBackground)
    }
}