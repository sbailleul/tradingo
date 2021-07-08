import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springBootVersion: String by project
val mediatRVersion: String by project
val logbackVersion: String by project
val elasticSearchAppenderVersion: String by project

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:$springBootVersion")
    implementation(enforcedPlatform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))
    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("io.micrometer:micrometer-registry-prometheus")
    implementation("org.springframework.kafka:spring-kafka")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation ("io.jkratz.springmediatr:spring-mediatr:$mediatRVersion")
    implementation("org.logback-extensions:logback-ext-loggly:$logbackVersion")
    implementation("com.internetitem:logback-elasticsearch-appender:$elasticSearchAppenderVersion")
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}
