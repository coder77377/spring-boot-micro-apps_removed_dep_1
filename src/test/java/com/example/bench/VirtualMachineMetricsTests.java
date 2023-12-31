/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bench;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.system.ApplicationPid;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dave Syer
 *
 */
public class VirtualMachineMetricsTests {

	@Test
	public void vanilla() throws Exception {
		Map<String, Number> metrics = VirtualMachineMetrics.fetch(new ApplicationPid().toString());
		assertThat(metrics).containsKeys("Classes");
		assertThat(VirtualMachineMetrics.heap(metrics)).isGreaterThan(0);
		System.err.println(metrics);
	}

}
