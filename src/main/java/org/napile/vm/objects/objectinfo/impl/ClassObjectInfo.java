package org.napile.vm.objects.objectinfo.impl;

import java.util.HashMap;
import java.util.Map;

import org.napile.vm.objects.Flags;
import org.napile.vm.objects.classinfo.ClassInfo;
import org.napile.vm.objects.classinfo.FieldInfo;
import org.napile.vm.objects.objectinfo.ObjectInfo;
import org.napile.vm.vm.VmUtil;

/**
 * @author VISTALL
 * @date 23:25/15.02.2012
 */
public class ClassObjectInfo  extends ObjectInfo
{
	private Map<FieldInfo, ObjectInfo> _fields = new HashMap<FieldInfo, ObjectInfo>();
	private ClassInfo _classInfo;

	public ClassObjectInfo(ObjectInfo classObjectInfo, ClassInfo classInfo)
	{
		super(classObjectInfo);
		_classInfo = classInfo;

		FieldInfo[] fieldInfos = VmUtil.collectAllFields(classInfo);

		for(FieldInfo f : fieldInfos)
		{
			if(Flags.isStatic(f))
				continue;

			_fields.put(f, f.getType().nullValue());
		}
	}

	@Override
	public ClassInfo getClassInfo()
	{
		return _classInfo;
	}

	public Map<FieldInfo, ObjectInfo> getFields()
	{
		return _fields;
	}
}
