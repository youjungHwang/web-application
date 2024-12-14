plugins {
    id("java")
}

group = "yjh"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("jakarta.servlet:jakarta.servlet-api:5.0.0")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    // Embedded Tomcat
    implementation("org.apache.tomcat.embed:tomcat-embed-core:8.5.42")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:8.5.42")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testImplementation("org.assertj:assertj-core:3.26.3")
}

tasks.test {
    useJUnitPlatform()
}