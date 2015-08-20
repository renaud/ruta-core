/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.uima.ruta.condition;

import org.apache.uima.cas.CAS;
import org.apache.uima.ruta.engine.RutaTestUtils;
import org.junit.Test;

public class ParseTest {

  @Test
  public void test() {
    
    CAS cas = RutaTestUtils.processTestScript(this.getClass());

    RutaTestUtils.assertAnnotationsEquals(cas, 1, 5, "42", "2", "1", "2", "3");
    RutaTestUtils.assertAnnotationsEquals(cas, 2, 2, "2,1", "2.3");
    RutaTestUtils.assertAnnotationsEquals(cas, 3, 1, "true");
    RutaTestUtils.assertAnnotationsEquals(cas, 4, 5, "A Boolean b that is true", "b = false", "The Number 42",
            "The Double d = 2,1", "Another Double that is 2.3");

    cas.release();
  }
}
