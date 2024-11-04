plugins {
	id("java")
}

group = "dev.noeul.problemsolving.boj"
version = "1.0.0"

val targetJavaVersion = JavaVersion.VERSION_15
java {
	targetCompatibility = targetJavaVersion
	sourceCompatibility = targetJavaVersion
	if (JavaVersion.current() < targetJavaVersion)
		toolchain.languageVersion.set(JavaLanguageVersion.of(targetJavaVersion.majorVersion.toInt()))
}

tasks.compileJava {
	if (targetJavaVersion >= JavaVersion.VERSION_1_10 || JavaVersion.current().isJava10Compatible)
		options.release.set(targetJavaVersion.majorVersion.toInt())
	options.encoding = "UTF-8"
}
