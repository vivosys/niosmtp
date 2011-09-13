/**
* Licensed to niosmtp developers ('niosmtp') under one or more
* contributor license agreements. See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* Selene licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package me.normanmaurer.niosmtp.impl.internal;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.handler.ssl.SslHandler;

/**
 * {@link ChannelPipelineFactory} which is used for SMTPS connections
 * 
 * @author Norman Maurer
 * 
 *
 */
public class SMTPSClientPipelineFactory extends SMTPClientPipelineFactory{

    private final SSLContext context;

    public SMTPSClientPipelineFactory(SSLContext context) {
        this.context = context;
    }
    
    @Override
    public ChannelPipeline getPipeline() throws Exception {
        ChannelPipeline cp = super.getPipeline();
        SSLEngine engine = context.createSSLEngine();
        engine.setUseClientMode(true);
        SslHandler sslHandler = new SslHandler(engine);
        cp.addFirst("sslHandler", sslHandler);
        return cp;
    }

}