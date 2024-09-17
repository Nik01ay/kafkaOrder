plugins {
    id("java")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
        implementation("org.springframework.kafka:spring-kafka:3.2.4")
        testImplementation("org.springframework.kafka:spring-kafka-test:3.2.4")
    implementation(project(":kafka-event"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.0")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

}

tasks.test {
    useJUnitPlatform()
}