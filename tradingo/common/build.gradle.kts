val springBootVersion: String by project
val mediatRVersion: String by project
val javaJwtVersion: String by project
val javaxApiVersion: String by project
plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id ("org.jetbrains.kotlin.plugin.lombok")
    id ("io.freefair.lombok")
}


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:$springBootVersion")
    implementation(enforcedPlatform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))
    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("io.micrometer:micrometer-registry-prometheus")
    implementation("org.logback-extensions:logback-ext-loggly:0.1.2")
    implementation ("io.jkratz.springmediatr:spring-mediatr:$mediatRVersion")
    implementation("com.auth0:java-jwt:$javaJwtVersion")
    implementation("org.apache.commons:commons-text:1.9")
    implementation("javax.xml.bind:jaxb-api:$javaxApiVersion")

}

tasks {
    withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
        enabled = false
    }
}