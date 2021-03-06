/*
 * Copyright (C) 2021 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dagger.hilt.android;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.UsesComponentTestClasses.UsesComponentQualifier;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.testing.TestInstallIn;

/** Replaces a production binding in tests. */
final class TestInstallInModules {
  private TestInstallInModules() {}

  @Module
  @TestInstallIn(components = SingletonComponent.class, replaces = UsesComponentTestModule.class)
  interface TestInstallInModule {
    @Provides
    @UsesComponentQualifier
    static String provideLocalString() {
      return "test_install_in_string";
    }
  }
}
