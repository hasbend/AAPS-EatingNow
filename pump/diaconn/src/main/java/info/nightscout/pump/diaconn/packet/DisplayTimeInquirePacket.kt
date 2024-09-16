package info.nightscout.pump.diaconn.packet

import app.aaps.core.interfaces.logging.LTag
import dagger.android.HasAndroidInjector
import info.nightscout.pump.diaconn.DiaconnG8Pump
import javax.inject.Inject

/**
 * DisplayTimeInquirePacket
 */
class DisplayTimeInquirePacket(
    injector: HasAndroidInjector
) : DiaconnG8Packet(injector) {

    @Inject lateinit var diaconnG8Pump: DiaconnG8Pump

    init {
        msgType = 0x4E.toByte()
        aapsLogger.debug(LTag.PUMPCOMM, "DisplayTimeInquirePacket request")
    }

    override fun encode(msgSeq: Int): ByteArray {
        val buffer = prefixEncode(msgType, msgSeq, MSG_CON_END)
        return suffixEncode(buffer)
    }

    override fun getFriendlyName(): String {
        return "PUMP_DISPLAY_TIME_INQUIRE"
    }
}