/*
 * Copyright 2010-2012 napile.org
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

package org.napile.vm.classloader;

import java.util.Collection;

import org.napile.asm.resolve.name.FqName;
import org.napile.vm.objects.classinfo.ClassInfo;

/**
 * @author VISTALL
 * @since 14:54/10.02.2012
 */
public interface JClassLoader
{
	void addClassInfo(ClassInfo classInfo);

	ClassInfo forName(FqName name);

	JClassLoader getParent();

	Collection<ClassInfo> getLoadedClasses();
}
