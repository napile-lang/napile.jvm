package org.napile.vm.invoke.impl.nativeimpl.classes;

import org.napile.asm.lib.NapileLangPackage;
import org.napile.asm.resolve.name.FqName;
import org.napile.asm.tree.members.MethodParameterNode;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.tree.members.types.constructors.ClassTypeNode;
import org.napile.vm.invoke.impl.bytecodeimpl.InterpreterContext;
import org.napile.vm.invoke.impl.nativeimpl.NativeImplement;
import org.napile.vm.objects.BaseObjectInfo;
import org.napile.vm.objects.classinfo.CallParameterInfo;
import org.napile.vm.objects.classinfo.MethodInfo;
import org.napile.vm.vm.VmReflectUtil;
import org.napile.vm.vm.Vm;
import org.napile.vm.vm.VmUtil;

/**
 * @author VISTALL
 * @since 18:44/31.01.13
 */
public class napile_reflect_MethodLike
{
	public static final TypeNode NAPILE_REFLECT_CALL_PARAMETER = new TypeNode(false, new ClassTypeNode(new FqName("napile.reflect.CallParameter")));

	public static final TypeNode NAPILE_LANG_ARRAY__CALL_PARAMETER__ = new TypeNode(false, new ClassTypeNode(NapileLangPackage.ARRAY)).visitArgument(NAPILE_REFLECT_CALL_PARAMETER);

	@NativeImplement(methodName = "getCallParameters", parameters = {})
	public static BaseObjectInfo getCallParameters(Vm vm, InterpreterContext context)
	{
		BaseObjectInfo objectInfo = context.getLastStack().getObjectInfo();
		MethodInfo methodInfo = objectInfo.value();

		BaseObjectInfo array =VmUtil.createArray(vm, context, NAPILE_LANG_ARRAY__CALL_PARAMETER__, methodInfo.getMethodNode().parameters.size());
		BaseObjectInfo[] value = array.value();

		int i = 0;
		for(final MethodParameterNode methodParameterNode : methodInfo.getMethodNode().parameters)
		{
			BaseObjectInfo v = VmReflectUtil.createReflectObject(NAPILE_REFLECT_CALL_PARAMETER, VmUtil.convertToVm(vm, context, null), vm, context, new CallParameterInfo(methodParameterNode));

			value[i] = v;
		}

		return array;
	}
}
