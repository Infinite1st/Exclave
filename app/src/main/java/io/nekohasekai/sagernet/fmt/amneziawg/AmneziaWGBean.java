/******************************************************************************
 * Copyright (C) 2021 by nekohasekai <contact-git@sekai.icu>                  *
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

package io.nekohasekai.sagernet.fmt.amneziawg;

import androidx.annotation.NonNull;

import com.esotericsoftware.kryo.io.ByteBufferInput;
import com.esotericsoftware.kryo.io.ByteBufferOutput;

import org.jetbrains.annotations.NotNull;

import io.nekohasekai.sagernet.fmt.AbstractBean;
import io.nekohasekai.sagernet.fmt.KryoConverters;

public class AmneziaWGBean extends AbstractBean {

    public String localAddress;
    public String privateKey;
    public String peerPublicKey;
    public String peerPreSharedKey;
    public Integer mtu;
    public String reserved;
    public Integer keepaliveInterval;

    // AmneziaWG obfuscation parameters
    public Integer jc;
    public Integer jmin;
    public Integer jmax;
    public Integer s1;
    public Integer s2;
    public Integer s3;
    public Integer s4;
    public String h1;
    public String h2;
    public String h3;
    public String h4;
    public String i1;
    public String i2;
    public String i3;
    public String i4;
    public String i5;
    public String headerProtectionKey;

    @Override
    public void initializeDefaultValues() {
        super.initializeDefaultValues();
        if (localAddress == null) localAddress = "";
        if (privateKey == null) privateKey = "";
        if (peerPublicKey == null) peerPublicKey = "";
        if (peerPreSharedKey == null) peerPreSharedKey = "";
        // wireguard default mtu
        if (mtu == null) mtu = 1420;
        if (reserved == null) reserved = "";
        if (keepaliveInterval == null) keepaliveInterval = 0;

        if (jc == null) jc = 0;
        if (jmin == null) jmin = 0;
        if (jmax == null) jmax = 0;
        if (s1 == null) s1 = 0;
        if (s2 == null) s2 = 0;
        if (s3 == null) s3 = 0;
        if (s4 == null) s4 = 0;
        if (h1 == null) h1 = "";
        if (h2 == null) h2 = "";
        if (h3 == null) h3 = "";
        if (h4 == null) h4 = "";
        if (i1 == null) i1 = "";
        if (i2 == null) i2 = "";
        if (i3 == null) i3 = "";
        if (i4 == null) i4 = "";
        if (i5 == null) i5 = "";
        if (headerProtectionKey == null) headerProtectionKey = "";
    }

    @Override
    public void serialize(ByteBufferOutput output) {
        output.writeInt(0);
        super.serialize(output);
        output.writeString(localAddress);
        output.writeString(privateKey);
        output.writeString(peerPublicKey);
        output.writeString(peerPreSharedKey);
        output.writeInt(mtu);
        output.writeString(reserved);
        output.writeInt(keepaliveInterval);
        output.writeInt(jc);
        output.writeInt(jmin);
        output.writeInt(jmax);
        output.writeInt(s1);
        output.writeInt(s2);
        output.writeInt(s3);
        output.writeInt(s4);
        output.writeString(h1);
        output.writeString(h2);
        output.writeString(h3);
        output.writeString(h4);
        output.writeString(i1);
        output.writeString(i2);
        output.writeString(i3);
        output.writeString(i4);
        output.writeString(i5);
        output.writeString(headerProtectionKey);
    }

    @Override
    public void deserialize(ByteBufferInput input) {
        int version = input.readInt();
        super.deserialize(input);
        localAddress = input.readString();
        privateKey = input.readString();
        peerPublicKey = input.readString();
        peerPreSharedKey = input.readString();
        mtu = input.readInt();
        reserved = input.readString();
        keepaliveInterval = input.readInt();
        jc = input.readInt();
        jmin = input.readInt();
        jmax = input.readInt();
        s1 = input.readInt();
        s2 = input.readInt();
        s3 = input.readInt();
        s4 = input.readInt();
        h1 = input.readString();
        h2 = input.readString();
        h3 = input.readString();
        h4 = input.readString();
        i1 = input.readString();
        i2 = input.readString();
        i3 = input.readString();
        i4 = input.readString();
        i5 = input.readString();
        headerProtectionKey = input.readString();
    }

    @Override
    public void applyFeatureSettings(AbstractBean other) {
        if (!(other instanceof AmneziaWGBean bean)) return;
        bean.mtu = mtu;
    }

    @NotNull
    @Override
    public AmneziaWGBean clone() {
        return KryoConverters.deserialize(new AmneziaWGBean(), KryoConverters.serialize(this));
    }

    public static final Creator<AmneziaWGBean> CREATOR = new CREATOR<>() {
        @NonNull
        @Override
        public AmneziaWGBean newInstance() {
            return new AmneziaWGBean();
        }

        @Override
        public AmneziaWGBean[] newArray(int size) {
            return new AmneziaWGBean[size];
        }
    };
}
