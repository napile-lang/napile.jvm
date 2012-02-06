/*
 * Copyright (c) 1999, 2005, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.sun.tools.javac.jvm;

public class Mneumonics implements ByteCodes
{
	public final static String[] mnem = new String[ByteCodeCount];

	static
	{
		mnem[nop] = "nop";
		mnem[aconst_null] = "aconst_null";
		mnem[iconst_m1] = "iconst_m1";
		mnem[iconst_0] = "iconst_0";
		mnem[iconst_1] = "iconst_1";
		mnem[iconst_2] = "iconst_2";
		mnem[iconst_3] = "iconst_3";
		mnem[iconst_4] = "iconst_4";
		mnem[iconst_5] = "iconst_5";
		mnem[lconst_0] = "lconst_0";
		mnem[lconst_1] = "lconst_1";
		mnem[fconst_0] = "fconst_0";
		mnem[fconst_1] = "fconst_1";
		mnem[fconst_2] = "fconst_2";
		mnem[dconst_0] = "dconst_0";
		mnem[dconst_1] = "dconst_1";
		mnem[bipush] = "bipush";
		mnem[sipush] = "sipush";
		mnem[ldc1] = "ldc1";
		mnem[ldc2] = "ldc2";
		mnem[ldc2w] = "ldc2w";
		mnem[iload] = "iload";
		mnem[lload] = "lload";
		mnem[fload] = "fload";
		mnem[dload] = "dload";
		mnem[aload] = "aload";
		mnem[iload_0] = "iload_0";
		mnem[lload_0] = "lload_0";
		mnem[fload_0] = "fload_0";
		mnem[dload_0] = "dload_0";
		mnem[aload_0] = "aload_0";
		mnem[iload_1] = "iload_1";
		mnem[lload_1] = "lload_1";
		mnem[fload_1] = "fload_1";
		mnem[dload_1] = "dload_1";
		mnem[aload_1] = "aload_1";
		mnem[iload_2] = "iload_2";
		mnem[lload_2] = "lload_2";
		mnem[fload_2] = "fload_2";
		mnem[dload_2] = "dload_2";
		mnem[aload_2] = "aload_2";
		mnem[iload_3] = "iload_3";
		mnem[lload_3] = "lload_3";
		mnem[fload_3] = "fload_3";
		mnem[dload_3] = "dload_3";
		mnem[aload_3] = "aload_3";
		mnem[iaload] = "iaload";
		mnem[laload] = "laload";
		mnem[faload] = "faload";
		mnem[daload] = "daload";
		mnem[aaload] = "aaload";
		mnem[baload] = "baload";
		mnem[caload] = "caload";
		mnem[saload] = "saload";
		mnem[istore] = "istore";
		mnem[lstore] = "lstore";
		mnem[fstore] = "fstore";
		mnem[dstore] = "dstore";
		mnem[astore] = "astore";
		mnem[istore_0] = "istore_0";
		mnem[lstore_0] = "lstore_0";
		mnem[fstore_0] = "fstore_0";
		mnem[dstore_0] = "dstore_0";
		mnem[astore_0] = "astore_0";
		mnem[istore_1] = "istore_1";
		mnem[lstore_1] = "lstore_1";
		mnem[fstore_1] = "fstore_1";
		mnem[dstore_1] = "dstore_1";
		mnem[astore_1] = "astore_1";
		mnem[istore_2] = "istore_2";
		mnem[lstore_2] = "lstore_2";
		mnem[fstore_2] = "fstore_2";
		mnem[dstore_2] = "dstore_2";
		mnem[astore_2] = "astore_2";
		mnem[istore_3] = "istore_3";
		mnem[lstore_3] = "lstore_3";
		mnem[fstore_3] = "fstore_3";
		mnem[dstore_3] = "dstore_3";
		mnem[astore_3] = "astore_3";
		mnem[iastore] = "iastore";
		mnem[lastore] = "lastore";
		mnem[fastore] = "fastore";
		mnem[dastore] = "dastore";
		mnem[aastore] = "aastore";
		mnem[bastore] = "bastore";
		mnem[castore] = "castore";
		mnem[sastore] = "sastore";
		mnem[pop] = "pop";
		mnem[pop2] = "pop2";
		mnem[dup] = "dup";
		mnem[dup_x1] = "dup_x1";
		mnem[dup_x2] = "dup_x2";
		mnem[dup2] = "dup2";
		mnem[dup2_x1] = "dup2_x1";
		mnem[dup2_x2] = "dup2_x2";
		mnem[swap] = "swap";
		mnem[iadd] = "iadd";
		mnem[ladd] = "ladd";
		mnem[fadd] = "fadd";
		mnem[dadd] = "dadd";
		mnem[isub] = "isub";
		mnem[lsub] = "lsub";
		mnem[fsub] = "fsub";
		mnem[dsub] = "dsub";
		mnem[imul] = "imul";
		mnem[lmul] = "lmul";
		mnem[fmul] = "fmul";
		mnem[dmul] = "dmul";
		mnem[idiv] = "idiv";
		mnem[ldiv] = "ldiv";
		mnem[fdiv] = "fdiv";
		mnem[ddiv] = "ddiv";
		mnem[imod] = "imod";
		mnem[lmod] = "lmod";
		mnem[fmod] = "fmod";
		mnem[dmod] = "dmod";
		mnem[ineg] = "ineg";
		mnem[lneg] = "lneg";
		mnem[fneg] = "fneg";
		mnem[dneg] = "dneg";
		mnem[ishl] = "ishl";
		mnem[lshl] = "lshl";
		mnem[ishr] = "ishr";
		mnem[lshr] = "lshr";
		mnem[iushr] = "iushr";
		mnem[lushr] = "lushr";
		mnem[iand] = "iand";
		mnem[land] = "land";
		mnem[ior] = "ior";
		mnem[lor] = "lor";
		mnem[ixor] = "ixor";
		mnem[lxor] = "lxor";
		mnem[iinc] = "iinc";
		mnem[i2l] = "i2l";
		mnem[i2f] = "i2f";
		mnem[i2d] = "i2d";
		mnem[l2i] = "l2i";
		mnem[l2f] = "l2f";
		mnem[l2d] = "l2d";
		mnem[f2i] = "f2i";
		mnem[f2l] = "f2l";
		mnem[f2d] = "f2d";
		mnem[d2i] = "d2i";
		mnem[d2l] = "d2l";
		mnem[d2f] = "d2f";
		mnem[int2byte] = "int2byte";
		mnem[int2char] = "int2char";
		mnem[int2short] = "int2short";
		mnem[lcmp] = "lcmp";
		mnem[fcmpl] = "fcmpl";
		mnem[fcmpg] = "fcmpg";
		mnem[dcmpl] = "dcmpl";
		mnem[dcmpg] = "dcmpg";
		mnem[ifeq] = "ifeq";
		mnem[ifne] = "ifne";
		mnem[iflt] = "iflt";
		mnem[ifge] = "ifge";
		mnem[ifgt] = "ifgt";
		mnem[ifle] = "ifle";
		mnem[if_icmpeq] = "if_icmpeq";
		mnem[if_icmpne] = "if_icmpne";
		mnem[if_icmplt] = "if_icmplt";
		mnem[if_icmpge] = "if_icmpge";
		mnem[if_icmpgt] = "if_icmpgt";
		mnem[if_icmple] = "if_icmple";
		mnem[if_acmpeq] = "if_acmpeq";
		mnem[if_acmpne] = "if_acmpne";
		mnem[goto_] = "goto_";
		mnem[jsr] = "jsr";
		mnem[ret] = "ret";
		mnem[tableswitch] = "tableswitch";
		mnem[lookupswitch] = "lookupswitch";
		mnem[ireturn] = "ireturn";
		mnem[lreturn] = "lreturn";
		mnem[freturn] = "freturn";
		mnem[dreturn] = "dreturn";
		mnem[areturn] = "areturn";
		mnem[return_] = "return_";
		mnem[getstatic] = "getstatic";
		mnem[putstatic] = "putstatic";
		mnem[getfield] = "getfield";
		mnem[putfield] = "putfield";
		mnem[invokevirtual] = "invokevirtual";
		mnem[invokespecial] = "invokespecial";
		mnem[invokestatic] = "invokestatic";
		mnem[invokeinterface] = "invokeinterface";
		mnem[invokedynamic] = "invokedynamic";
		mnem[new_] = "new_";
		mnem[newarray] = "newarray";
		mnem[anewarray] = "anewarray";
		mnem[arraylength] = "arraylength";
		mnem[athrow] = "athrow";
		mnem[checkcast] = "checkcast";
		mnem[instanceof_] = "instanceof_";
		mnem[monitorenter] = "monitorenter";
		mnem[monitorexit] = "monitorexit";
		mnem[wide] = "wide";
		mnem[multianewarray] = "multianewarray";
		mnem[if_acmp_null] = "if_acmp_null";
		mnem[if_acmp_nonnull] = "if_acmp_nonnull";
		mnem[goto_w] = "goto_w";
		mnem[jsr_w] = "jsr_w";
		mnem[breakpoint] = "breakpoint";
	}
}
