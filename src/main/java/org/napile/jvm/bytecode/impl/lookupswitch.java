package org.napile.jvm.bytecode.impl;

import gnu.trove.map.TIntIntMap;
import gnu.trove.map.hash.TIntIntHashMap;

import java.nio.ByteBuffer;

import org.napile.jvm.bytecode.Instruction;
import org.napile.jvm.vm.VmInterface;

/**
 * @author VISTALL
 * @date 4:52/06.02.2012
 */
public class lookupswitch implements Instruction
{
	private TIntIntMap _values;

	private int _offset;

	@Override
	public void parseData(ByteBuffer buffer, boolean wide)
	{
		int align = ((buffer.position() + 3) & 0x7ffffffc) - buffer.position();
		buffer.position(buffer.position() + align);

		_offset = buffer.getInt();
		int count = buffer.getInt();
		_values = new TIntIntHashMap(count);

		for(int i = 0; i < count; i++)
			_values.put(buffer.getInt(), buffer.getInt());
	}

	@Override
	public void call(VmInterface vmInterface)
	{

	}
}
