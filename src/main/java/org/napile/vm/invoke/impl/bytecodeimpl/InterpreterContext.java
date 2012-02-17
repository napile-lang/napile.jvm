package org.napile.vm.invoke.impl.bytecodeimpl;

import java.util.ArrayDeque;
import java.util.Deque;

import org.napile.vm.objects.objectinfo.ObjectInfo;
import sun.reflect.Reflection;

/**
 * @author VISTALL
 * @date 19:56/15.02.2012
 */
public class InterpreterContext
{
	private Deque<StackEntry> _stack = new ArrayDeque<StackEntry>();

	private Deque<ObjectInfo> _values = new ArrayDeque<ObjectInfo>(2);

	public InterpreterContext(StackEntry... methodInfo)
	{
		for(StackEntry d : methodInfo)
			_stack.add(d);
	}

	public StackEntry getLastStack()
	{
		return _stack.peekLast();
	}

	public void push(ObjectInfo val)
	{
		StackEntry entry = getLastStack();
		entry.getDebug().add("push: " + val + ": " + Reflection.getCallerClass(2).getSimpleName());
		_values.add(val);
	}

	public ObjectInfo last()
	{
		ObjectInfo v = _values.pollLast();
		StackEntry entry = getLastStack();
		entry.getDebug().add("last: " + v + ": " + Reflection.getCallerClass(2).getSimpleName());
		return v;
	}

	public Deque<StackEntry> getStack()
	{
		return _stack;
	}
}
