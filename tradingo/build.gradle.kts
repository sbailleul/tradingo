repositories {
    mavenCentral()
}
plugins {
    java
}
subprojects {
    group = "org.tradingo"
    repositories {
        mavenCentral()
        jcenter()
    }
}
