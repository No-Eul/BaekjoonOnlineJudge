plugins {
	kotlin("jvm") version "1.9.10"
}

group = "dev.noeul.problemsolving.boj"
version = "1.0.0"

repositories {
	mavenCentral()
}

kotlin {
	jvmToolchain(8)
}
