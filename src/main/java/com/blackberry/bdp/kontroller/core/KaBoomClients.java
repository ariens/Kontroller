/**
 * Copyright 2014 BlackBerry, Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package com.blackberry.bdp.kontroller.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.blackberry.bdp.kaboom.api.KaBoomClient;

import java.util.List;

public class KaBoomClients {

	private long id;
	private List<KaBoomClient> content;

	public KaBoomClients() { }

	public KaBoomClients(long id, List<KaBoomClient> content) {
		super();
		this.id = id;
		this.content = content;
	}

	@JsonProperty
	public long getId() {
		return id;
	}

	@JsonProperty
	public List<KaBoomClient> getContent() {
		return content;
	}
}
