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

package org.napile.vm.invoke.impl.nativeimpl;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.napile.asm.io.text.in.type.TypeNodeUtil;
import org.napile.asm.resolve.name.FqName;
import org.napile.asm.resolve.name.Name;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.vm.invoke.impl.bytecodeimpl.InterpreterContext;
import org.napile.vm.invoke.impl.nativeimpl.classes.napile_io_Console;
import org.napile.vm.invoke.impl.nativeimpl.classes.napile_io_File;
import org.napile.vm.invoke.impl.nativeimpl.classes.napile_lang_Any;
import org.napile.vm.invoke.impl.nativeimpl.classes.napile_lang_Array;
import org.napile.vm.invoke.impl.nativeimpl.classes.napile_lang_Byte;
import org.napile.vm.invoke.impl.nativeimpl.classes.napile_lang_Char;
import org.napile.vm.invoke.impl.nativeimpl.classes.napile_lang_Exception;
import org.napile.vm.invoke.impl.nativeimpl.classes.napile_lang_Int;
import org.napile.vm.invoke.impl.nativeimpl.classes.napile_reflect_Class;
import org.napile.vm.objects.classinfo.ClassInfo;
import org.napile.vm.util.AssertUtil;
import org.napile.vm.vm.Vm;
import com.intellij.openapi.util.Comparing;

/**
 * @author VISTALL
 * @date 23:59/16.02.2012
 */
public class NativeWrapper
{
	public static void initAll(Vm vm)
	{
		register(vm, napile_lang_Byte.class);
		register(vm, napile_lang_Int.class);
		register(vm, napile_lang_Char.class);
		register(vm, napile_lang_Any.class);
		register(vm, napile_lang_Array.class);
		register(vm, napile_lang_Exception.class);

		register(vm, napile_reflect_Class.class);

		register(vm, napile_io_Console.class);
		register(vm, napile_io_File.class);
	}

	private static void register(Vm vm, Class<?> clazz)
	{
		for(Method method : clazz.getDeclaredMethods())
		{
			if(!Modifier.isStatic(method.getModifiers()))
				continue;

			NativeImplement nativeImplement = method.getAnnotation(NativeImplement.class);
			if(nativeImplement == null)
				continue;

			AssertUtil.assertTrue(method.getParameterTypes().length != 2 || method.getParameterTypes()[0] != Vm.class || method.getParameterTypes()[1] != InterpreterContext.class);

			final FqName className = new FqName(nativeImplement.className());

			final ClassInfo classInfo = vm.getClass(className);

			List<NativeMethodRef> list = vm.getNativeWrappers().get(classInfo);
			if(list == null)
				vm.getNativeWrappers().put(classInfo, list = new ArrayList<NativeMethodRef>());

			int i = 0;
			TypeNode[] params = new TypeNode[nativeImplement.parameters().length];
			for(String param : nativeImplement.parameters())
				params[i++] = TypeNodeUtil.fromString(param);

			NativeMethodRef methodInfo = new NativeMethodRef(className.child(Name.identifier(nativeImplement.methodName())), params, method);

			list.add(methodInfo);
		}
	}

	public static NativeMethodRef getMethod(Vm vm, ClassInfo classInfo, FqName name, TypeNode[] params)
	{
		List<NativeMethodRef> nativeMethodRefs = vm.getNativeWrappers().get(classInfo);
		if(nativeMethodRefs == null)
			return null;

		for(NativeMethodRef methodInfo : nativeMethodRefs)
		{
			if(!methodInfo.getName().equals(name))
				continue;

			if(!Comparing.equal(methodInfo.getParameters(), params))
				continue;

			return methodInfo;
		}

		return null;
	}
}
