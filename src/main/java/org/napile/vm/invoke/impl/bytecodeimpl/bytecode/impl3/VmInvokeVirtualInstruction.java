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

package org.napile.vm.invoke.impl.bytecodeimpl.bytecode.impl3;

import org.napile.asm.resolve.name.FqName;
import org.napile.asm.tree.members.bytecode.impl.InvokeVirtualInstruction;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.vm.invoke.impl.bytecodeimpl.CallPosition;
import org.napile.vm.invoke.impl.bytecodeimpl.InterpreterContext;
import org.napile.vm.invoke.impl.bytecodeimpl.StackEntry;
import org.napile.vm.invoke.impl.bytecodeimpl.bytecode.VmInstruction;
import org.napile.vm.objects.BaseObjectInfo;
import org.napile.vm.objects.classinfo.MethodInfo;
import org.napile.vm.util.AssertUtil;
import org.napile.vm.vm.Vm;
import org.napile.vm.vm.VmUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.ArrayUtil;

/**
 * @author VISTALL
 * @since 19:55/21.09.12
 */
public class VmInvokeVirtualInstruction extends VmInstruction<InvokeVirtualInstruction>
{
	private FqName className;
	private String methodName;
	private TypeNode[] parameterTypes;

	public VmInvokeVirtualInstruction(InvokeVirtualInstruction instruction)
	{
		super(instruction);

		className = instruction.methodRef.method.parent();
		methodName = instruction.methodRef.method.shortName().getName();
		parameterTypes = new TypeNode[instruction.methodRef.parameters.size()];
		for(int i = 0; i < parameterTypes.length; i++)
			parameterTypes[i] = instruction.methodRef.parameters.get(i).returnType;
	}

	@Override
	public int call(Vm vm, InterpreterContext context, int nextIndex)
	{
		BaseObjectInfo[] arguments = new BaseObjectInfo[instruction.methodRef.parameters.size()];
		for(int i = 0; i < arguments.length; i++)
			arguments[i] = context.pop();

		arguments = ArrayUtil.reverseArray(arguments);

		BaseObjectInfo objectInfo = context.pop();
		if(instruction.nullable && objectInfo == VmUtil.convertToVm(vm, context, null))
		{
			context.push(VmUtil.convertToVm(vm, context, null));
			return nextIndex;
		}
		else
		{
			MethodInfo methodInfo = vm.getMethod(objectInfo.getClassInfo(), methodName, true, parameterTypes);

			AssertUtil.assertFalse(methodInfo != null, "Method not found `" + methodName + "` " + className + " parameters " + StringUtil.join(instruction.methodRef.parameters, ", ") + " object: " + objectInfo);

			methodInfo = vm.getMethod(objectInfo.getClassInfo(), methodName, true, parameterTypes);

			StackEntry nextEntry = new StackEntry(objectInfo, methodInfo, arguments, instruction.methodRef.typeArguments);
			nextEntry.position = new CallPosition(this);

			context.getStack().add(nextEntry);

			vm.invoke(context, methodInfo.getInvokeType());

			StackEntry stackEntry = context.getStack().pollLast();
			if(stackEntry == null)
				return BREAK_INDEX;

			for(BaseObjectInfo returnValue : stackEntry.getReturnValues())
				context.push(returnValue);

			int forceIndex = stackEntry.getForceIndex();
			return forceIndex == -2 ? nextIndex : forceIndex;
		}
	}
}
