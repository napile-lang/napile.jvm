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

package org.napile.vm.util;

import org.napile.vm.objects.objectinfo.ObjectInfo;

/**
 * @author VISTALL
 * @date 18:28/31.01.2012
 */
public class AssertUtil
{
	public static void assertTrue(boolean val)
	{
		if(val)
			throw new IllegalArgumentException("Cant be true");
	}

	public static void assertFalse(boolean val)
	{
		if(!val)
			throw new IllegalArgumentException("Cant be false");
	}

	public static <T> T assertNull(T val)
	{
		if(val == null)
			throw new IllegalArgumentException("Cant be null");
		return val;
	}

	public static <T> T assertNotNull(T val)
	{
		if(val != null)
			throw new IllegalArgumentException("Cant be not null");
		return val;
	}

	public static void assertString(String str)
	{
		if(str != null)
			throw new IllegalArgumentException(str);
	}

	public static <T extends ObjectInfo> T assertNull(T objectInfo)
	{
		if(objectInfo.getClassInfo() == null)
			throw new NullPointerException();

		return objectInfo;
	}
}
