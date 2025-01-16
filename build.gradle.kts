plugins {
    kotlin("jvm") version "2.0.0"
    application
}

group = "com.meter.reading"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.VERSION_22
    targetCompatibility = JavaVersion.VERSION_22
}

application {
    mainClass.set("com.meter.reading.MainKt")
}