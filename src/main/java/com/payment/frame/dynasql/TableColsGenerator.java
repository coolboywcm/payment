package com.payment.frame.dynasql;

import com.google.common.base.Charsets;
import org.reflections.Reflections;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * TableColsGenerator
 *
 * @author mysh
 * @since 2016/1/19
 */
public class TableColsGenerator {
	public static void genSingle(String packageName, String dstDir, String dstPackage, String className) throws ClassNotFoundException, IOException {
		try (PrintWriter out = new PrintWriter(
						Files.newOutputStream(Paths.get(dstDir, dstPackage.replace('.', '/'), className + ".java")))) {
			out.println("package " + dstPackage + ";");
			out.println();
			out.println("public abstract class " + className + " {");
			for (Class clazz : new Reflections(packageName).getSubTypesOf(Serializable.class)) {
				String colClassName = clazz.getSimpleName() + "Cols";
				out.println("\tpublic static class " + colClassName + " {");
				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					String fieldName = field.getName();
					if ("serialVersionUID".equals(fieldName)) continue;
					out.println("\t\tpublic final String " + fieldName + " = \"" + CodeUtil.camel2underline(fieldName) + "\";");
				}
				out.println("\t}");
				out.println("\tpublic static final " + colClassName + " " + colClassName + " = new " + colClassName + "();");
				out.println();
			}
			out.println("}");
		}
	}

	public static void gen2Bean(String beanSrcDir, String beanPackage) throws ClassNotFoundException, IOException {

		for (File file : new File(beanSrcDir, beanPackage.replace('.', '/')).listFiles()) {
			if (file.isFile()) {
				String fileName = file.getName();
				Class<?> clazz = Class.forName(beanPackage + "." + fileName.substring(0, fileName.length() - 5));
				String colClassFlag = "public static class " + clazz.getSimpleName() + "Cols";
				if (new String(Files.readAllBytes(file.toPath())).contains(colClassFlag))
					continue;

				List<String> allLines = Files.readAllLines(file.toPath(), Charsets.UTF_8);
				try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
					for (String line : allLines) {
						if ("}".equals(line)) {
							String colClassName = clazz.getSimpleName() + "Cols";
							out.println();
							out.println("\t\tpublic static class " + colClassName + " {");
							Field[] fields = clazz.getDeclaredFields();
							for (Field field : fields) {
								String fieldName = field.getName();
								if ("serialVersionUID".equals(fieldName)) continue;
								out.println("\t\t\tpublic final String " + fieldName + " = \"" + CodeUtil.camel2underline(fieldName) + "\";");
							}
							out.println("\t\t}");
							out.println("\t\tpublic static final " + colClassName + " " + colClassName + " = new " + colClassName + "();");
						}
						out.println(line);
					}
				}
			}
		}
	}
}
