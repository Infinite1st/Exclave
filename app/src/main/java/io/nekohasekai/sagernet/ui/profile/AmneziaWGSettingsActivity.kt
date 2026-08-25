/******************************************************************************
 *                                                                            *
 * Copyright (C) 2021 by nekohasekai <contact-sagernet@sekai.icu>             *
 *                                                                            *
 * This program is free software: you can redistribute it and/or modify       *
 * it under the terms of the GNU General Public License as published by       *
 * the Free Software Foundation, either version 3 of the License, or          *
 *  (at your option) any later version.                                       *
 *                                                                            *
 * This program is distributed in the hope that it will be useful,            *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of             *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the              *
 * GNU General Public License for more details.                               *
 *                                                                            *
 * You should have received a copy of the GNU General Public License          *
 * along with this program. If not, see <http://www.gnu.org/licenses/>.       *
 *                                                                            *
 ******************************************************************************/

package io.nekohasekai.sagernet.ui.profile

import android.os.Bundle
import androidx.preference.EditTextPreference
import androidx.preference.PreferenceFragmentCompat
import io.nekohasekai.sagernet.Key
import io.nekohasekai.sagernet.R
import io.nekohasekai.sagernet.database.DataStore
import io.nekohasekai.sagernet.database.preference.EditTextPreferenceModifiers
import io.nekohasekai.sagernet.fmt.amneziawg.AmneziaWGBean
import io.nekohasekai.sagernet.ktx.unwrapIDN

class AmneziaWGSettingsActivity : ProfileSettingsActivity<AmneziaWGBean>() {

    override fun createEntity() = AmneziaWGBean()

    override fun AmneziaWGBean.init() {
        DataStore.profileName = name

        DataStore.serverLocalAddress = localAddress
        DataStore.serverPrivateKey = privateKey

        DataStore.serverAddress = serverAddress
        DataStore.serverPort = serverPort

        DataStore.serverCertificates = peerPublicKey
        DataStore.serverPassword = peerPreSharedKey

        DataStore.serverMTU = mtu
        DataStore.serverWireGuardReserved = reserved
        DataStore.serverWireGuardKeepaliveInterval = keepaliveInterval

        DataStore.serverAmneziaWGJc = jc
        DataStore.serverAmneziaWGJmin = jmin
        DataStore.serverAmneziaWGJmax = jmax
        DataStore.serverAmneziaWGS1 = s1
        DataStore.serverAmneziaWGS2 = s2
        DataStore.serverAmneziaWGS3 = s3
        DataStore.serverAmneziaWGS4 = s4
        DataStore.serverAmneziaWGH1 = h1
        DataStore.serverAmneziaWGH2 = h2
        DataStore.serverAmneziaWGH3 = h3
        DataStore.serverAmneziaWGH4 = h4
        DataStore.serverAmneziaWGI1 = i1
        DataStore.serverAmneziaWGI2 = i2
        DataStore.serverAmneziaWGI3 = i3
        DataStore.serverAmneziaWGI4 = i4
        DataStore.serverAmneziaWGI5 = i5
        DataStore.serverAmneziaWGHeaderProtectionKey = headerProtectionKey
    }

    override fun AmneziaWGBean.serialize() {
        name = DataStore.profileName

        localAddress = DataStore.serverLocalAddress
        privateKey = DataStore.serverPrivateKey

        serverAddress = DataStore.serverAddress.unwrapIDN()
        serverPort = DataStore.serverPort

        peerPublicKey = DataStore.serverCertificates
        peerPreSharedKey = DataStore.serverPassword

        mtu = DataStore.serverMTU
        reserved = DataStore.serverWireGuardReserved
        keepaliveInterval = DataStore.serverWireGuardKeepaliveInterval

        jc = DataStore.serverAmneziaWGJc
        jmin = DataStore.serverAmneziaWGJmin
        jmax = DataStore.serverAmneziaWGJmax
        s1 = DataStore.serverAmneziaWGS1
        s2 = DataStore.serverAmneziaWGS2
        s3 = DataStore.serverAmneziaWGS3
        s4 = DataStore.serverAmneziaWGS4
        h1 = DataStore.serverAmneziaWGH1
        h2 = DataStore.serverAmneziaWGH2
        h3 = DataStore.serverAmneziaWGH3
        h4 = DataStore.serverAmneziaWGH4
        i1 = DataStore.serverAmneziaWGI1
        i2 = DataStore.serverAmneziaWGI2
        i3 = DataStore.serverAmneziaWGI3
        i4 = DataStore.serverAmneziaWGI4
        i5 = DataStore.serverAmneziaWGI5
        headerProtectionKey = DataStore.serverAmneziaWGHeaderProtectionKey
    }

    override fun PreferenceFragmentCompat.createPreferences(
        savedInstanceState: Bundle?,
        rootKey: String?,
    ) {
        addPreferencesFromResource(R.xml.amneziawg_preferences)
        findPreference<EditTextPreference>(Key.SERVER_PORT)!!.apply {
            setOnBindEditTextListener(EditTextPreferenceModifiers.Port)
        }
        findPreference<EditTextPreference>(Key.SERVER_PASSWORD)!!.apply {
            summaryProvider = PasswordSummaryProvider
        }
        findPreference<EditTextPreference>(Key.SERVER_PRIVATE_KEY)!!.apply {
            summaryProvider = PasswordSummaryProvider
        }
        findPreference<EditTextPreference>(Key.SERVER_MTU)!!.apply {
            setOnBindEditTextListener(EditTextPreferenceModifiers.Number)
        }
        findPreference<EditTextPreference>(Key.SERVER_WIREGUARD_KEEPALIVE_INTERVAL)!!.apply {
            setOnBindEditTextListener(EditTextPreferenceModifiers.Number)
        }
        findPreference<EditTextPreference>(Key.SERVER_AMNEZIAWG_JC)!!.apply {
            setOnBindEditTextListener(EditTextPreferenceModifiers.Number)
        }
        findPreference<EditTextPreference>(Key.SERVER_AMNEZIAWG_JMIN)!!.apply {
            setOnBindEditTextListener(EditTextPreferenceModifiers.Number)
        }
        findPreference<EditTextPreference>(Key.SERVER_AMNEZIAWG_JMAX)!!.apply {
            setOnBindEditTextListener(EditTextPreferenceModifiers.Number)
        }
        findPreference<EditTextPreference>(Key.SERVER_AMNEZIAWG_S1)!!.apply {
            setOnBindEditTextListener(EditTextPreferenceModifiers.Number)
        }
        findPreference<EditTextPreference>(Key.SERVER_AMNEZIAWG_S2)!!.apply {
            setOnBindEditTextListener(EditTextPreferenceModifiers.Number)
        }
        findPreference<EditTextPreference>(Key.SERVER_AMNEZIAWG_S3)!!.apply {
            setOnBindEditTextListener(EditTextPreferenceModifiers.Number)
        }
        findPreference<EditTextPreference>(Key.SERVER_AMNEZIAWG_S4)!!.apply {
            setOnBindEditTextListener(EditTextPreferenceModifiers.Number)
        }
    }

}
