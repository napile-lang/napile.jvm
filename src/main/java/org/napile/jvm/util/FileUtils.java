package org.napile.jvm.util;

import java.io.File;

/**
 * @author VISTALL
 * @date 2:57/02.02.2012
 */
public class FileUtils
{
	public static String getFileExtension(File file)
	{
		return getFileExtension(file.getName());
	}

	public static String getFileExtension(String name)
	{
		int dot = name.lastIndexOf('.');
		return name.substring(dot + 1);
	}
}