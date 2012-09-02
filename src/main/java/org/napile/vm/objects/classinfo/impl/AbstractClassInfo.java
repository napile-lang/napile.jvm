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

package org.napile.vm.objects.classinfo.impl;

import org.napile.vm.objects.classinfo.ClassInfo;
import org.napile.vm.objects.objectinfo.impl.BaseObjectInfo;

/**
 * @author VISTALL
 * @date 19:02/15.02.2012
 */
public abstract class AbstractClassInfo implements ClassInfo
{
	private BaseObjectInfo _nullValue;

	public void setNullValue(BaseObjectInfo nullValue)
	{
		_nullValue = nullValue;
	}

	@Override
	public final BaseObjectInfo nullValue()
	{
		return _nullValue;
	}

	@Override
	public String toString()
	{
		return getName().toString();
	}
}
