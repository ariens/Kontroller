/** Copyright 2015 BlackBerry, Limited.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License. 
 */

package com.blackberry.bdp.kontroller.resources;

import com.blackberry.bdp.dwauth.ldap.AuthenticationStatus;
import com.blackberry.bdp.dwauth.ldap.User;
import com.blackberry.bdp.kontroller.KontrollerConfiguration;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import io.dropwizard.auth.Auth;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationStatusResource {
	private static final Logger LOG = LoggerFactory.getLogger(KaBoomRunningConfigResource.class);
	private final KontrollerConfiguration config;
	
	public AuthenticationStatusResource(KontrollerConfiguration config) {
		this.config = config;
	}
	
	@GET @Timed @Produces(value = MediaType.APPLICATION_JSON)
	public AuthenticationStatus get(@Auth(required = false) User user) throws Exception {
		AuthenticationStatus status = new AuthenticationStatus();
		if (Optional.fromNullable(user).isPresent()) {
			status.setAuthenticated( true);
			status.setUser(user);
		}
		return status;
	}
}
