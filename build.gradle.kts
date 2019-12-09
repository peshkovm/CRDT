plugins {
    java
}

group = "org.eltech.peshkov.master"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
}

dependencies {
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_10
}