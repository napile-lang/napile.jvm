package org.napile.jvm.bytecode.impl;

import java.nio.ByteBuffer;

import org.napile.jvm.bytecode.Instruction;
import org.napile.jvm.vm.VmInterface;

/**
 * @author VISTALL
 * @date 4:52/06.02.2012
 */
public class newarray implements Instruction
{
	@Override
	public void parseData(ByteBuffer buffer, boolean wide)
	{
		buffer.get();
	}

	@Override
	public void call(VmInterface vmInterface)
	{

	}
}