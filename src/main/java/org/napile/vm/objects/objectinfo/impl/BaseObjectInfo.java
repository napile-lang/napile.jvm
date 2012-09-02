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

package org.napile.vm.objects.objectinfo.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.NotNull;
import org.napile.vm.objects.Flags;
import org.napile.vm.objects.classinfo.ClassInfo;
import org.napile.vm.objects.classinfo.FieldInfo;
import org.napile.vm.vm.Vm;
import org.napile.vm.vm.VmUtil;

/**
 * @author VISTALL
 * @date 23:25/15.02.2012
 */
public class BaseObjectInfo
{
	public static final BaseObjectInfo[] EMPTY_ARRAY = new BaseObjectInfo[0];

	private BaseObjectInfo _classObjectInfo; // object for 'java.lang.Class'
	private Map<FieldInfo, BaseObjectInfo> _fields = new HashMap<FieldInfo, BaseObjectInfo>();
	private ClassInfo _classInfo;

	public BaseObjectInfo(ClassInfo classInfo)
	{
		_classInfo = classInfo;

		// hack - removed after remove Vm.NULL_VALUE
		List<FieldInfo> fieldInfos = classInfo == null ? Collections.<FieldInfo>emptyList() : VmUtil.collectAllFields(classInfo);

		for(FieldInfo f : fieldInfos)
		{
			if(Flags.isStatic(f))
				continue;

			_fields.put(f, VmUtil.OBJECT_NULL);
		}
	}

	public ClassInfo getClassInfo()
	{
		return _classInfo;
	}

	public BaseObjectInfo getClassObjectInfo(Vm vm)
	{
		if(_classObjectInfo == null)
			_classObjectInfo = vm.getClassObjectInfo(getClassInfo());

		return _classObjectInfo;
	}

	public BaseObjectInfo getVarValue(@NotNull Vm vm, @NotNull String name)
	{
		FieldInfo fieldInfo = vm.getAnyField(_classInfo, name, true);
		if(fieldInfo == null)
			return null;
		return _fields.get(fieldInfo);
	}

	public Map<FieldInfo, BaseObjectInfo> getFields()
	{
		return _fields;
	}

	@Override
	public String toString()
	{
		return "Object of " + _classInfo.toString();
	}
}