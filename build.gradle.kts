import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "love.to.code"
version = "0.0.1"

repositories {
    jcenter()
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

plugins {
    java
    val kotlinVersion = "1.3.61"
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.google.guava:guava:27.0-jre")
    implementation("com.google.inject:guice:4.0")
    testImplementation("junit:junit:4.12")
}
