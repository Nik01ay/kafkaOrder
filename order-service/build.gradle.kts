plugins {
    id("java")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":order-dto"))
    implementation(project(":kafka-event"))
    implementation(project(":kafka-manager"))

    implementation("org.springframework.kafka:spring-kafka:3.2.4")
    testImplementation("org.springframework.kafka:spring-kafka-test:3.2.4")

    implementation("org.springframework.boot:spring-boot-starter-web:3.3.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.3")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}