package org.napile.jvm.bytecode.impl;

import java.nio.ByteBuffer;

import org.napile.jvm.bytecode.Instruction;
import org.napile.jvm.vm.VmInterface;

/**
 * @author VISTALL
 * @date 4:52/06.02.2012
 */
public class invokeinterface implements Instruction
{
	@Override
	public void parseData(ByteBuffer buffer, boolean wide)
	{
		buffer.getShort();
		buffer.getShort();
	}

	@Override
	public void call(VmInterface vmInterface)
	{

	}
}