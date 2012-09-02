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

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.Modifier;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.compiler.lang.resolve.name.FqName;
import org.napile.vm.objects.classinfo.ClassInfo;
import org.napile.vm.objects.classinfo.FieldInfo;
import org.napile.vm.objects.objectinfo.impl.BaseObjectInfo;

/**
 * @author VISTALL
 * @date 3:03/02.02.2012
 */
public class FieldInfoImpl implements FieldInfo
{
	private List<Modifier> flags = new ArrayList<Modifier>(0);
	private ClassInfo _parent;
	private TypeNode _type;
	private FqName _name;

	private BaseObjectInfo _value;

	public FieldInfoImpl(ClassInfo parent, TypeNode type, FqName name)
	{
		_parent = parent;
		_type = type;
		_name = name;
	}

	@Override
	public ClassInfo getParent()
	{
		return _parent;
	}

	@NotNull
	@Override
	public FqName getName()
	{
		return _name;
	}

	@NotNull
	@Override
	public List<Modifier> getFlags()
	{
		return flags;
	}

	@Override
	public void setValue(BaseObjectInfo value)
	{
		_value = value;
	}

	@Override
	public BaseObjectInfo getValue()
	{
		return _value;
	}

	@Override
	public TypeNode getType()
	{
		return _type;
	}

	@Override
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		b.append(getParent().getName()).append(":");
		b.append(_type.toString()).append(" ");
		b.append(getName());
		return b.toString();
	}
}
