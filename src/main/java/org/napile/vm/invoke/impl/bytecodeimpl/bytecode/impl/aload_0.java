package org.napile.vm.invoke.impl.bytecodeimpl.bytecode.impl;

import java.nio.ByteBuffer;

import org.napile.vm.invoke.impl.bytecodeimpl.bytecode.Instruction;
import org.napile.vm.invoke.impl.bytecodeimpl.InterpreterContext;
import org.napile.vm.invoke.impl.bytecodeimpl.StackEntry;
import org.napile.vm.objects.objectinfo.ObjectInfo;
import org.napile.vm.vm.Vm;

/**
 * @author VISTALL
 * @date 4:52/06.02.2012
 */
public class aload_0 extends Instruction
{
	@Override
	public void parseData(ByteBuffer buffer, boolean wide)
	{

	}

	@Override
	public void call(Vm vm, InterpreterContext context)
	{
		StackEntry stackEntry = context.getLastStack();

		ObjectInfo objectInfo = stackEntry.get(0);

		context.push(objectInfo);
	}
}