package minerva.android.walletmanager.model.defs

import androidx.annotation.IntDef
import minerva.android.walletmanager.model.defs.WalletActionStatus.Companion.ADDED
import minerva.android.walletmanager.model.defs.WalletActionStatus.Companion.AUTHORISED
import minerva.android.walletmanager.model.defs.WalletActionStatus.Companion.CHANGED
import minerva.android.walletmanager.model.defs.WalletActionStatus.Companion.FAILED
import minerva.android.walletmanager.model.defs.WalletActionStatus.Companion.LOG_IN
import minerva.android.walletmanager.model.defs.WalletActionStatus.Companion.RECEIVED
import minerva.android.walletmanager.model.defs.WalletActionStatus.Companion.REMOVED
import minerva.android.walletmanager.model.defs.WalletActionStatus.Companion.SENT
import minerva.android.walletmanager.model.defs.WalletActionStatus.Companion.SIGNED

@Retention(AnnotationRetention.SOURCE)
@IntDef(REMOVED, CHANGED, ADDED, RECEIVED, SENT, FAILED, LOG_IN, AUTHORISED, SIGNED)
annotation class WalletActionStatus {
    companion object {
        const val REMOVED = 0
        const val CHANGED = 1
        const val ADDED = 2
        const val RECEIVED = 3
        const val SENT = 4
        const val FAILED = 5
        const val LOG_IN = 6
        const val AUTHORISED = 7
        const val SIGNED = 8
        const val SAFE_ACCOUNT_ADDED = 9
        const val SAFE_ACCOUNT_REMOVED = 10
    }
}