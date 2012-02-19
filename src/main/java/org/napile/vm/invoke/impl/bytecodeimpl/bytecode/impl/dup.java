package org.napile.vm.invoke.impl.bytecodeimpl.bytecode.impl;

import java.nio.ByteBuffer;

import org.napile.vm.invoke.impl.bytecodeimpl.bytecode.Instruction;
import org.napile.vm.invoke.impl.bytecodeimpl.InterpreterContext;
import org.napile.vm.objects.objectinfo.impl.ClassObjectInfo;
import org.napile.vm.vm.Vm;

/**
 * @author VISTALL
 * @date 4:52/06.02.2012
 */
public class dup extends Instruction
{
	@Override
	public void parseData(ByteBuffer buffer, boolean wide)
	{

	}

	@Override
	public void call(Vm vm, InterpreterContext context)
	{
		ClassObjectInfo classObjectInfo = (ClassObjectInfo)context.last();

		context.push(classObjectInfo);
		context.push(classObjectInfo);
	}
}
