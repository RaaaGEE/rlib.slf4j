# License #
See LICENSE file.

## What is it?
Its simple logging redirect (to SLF4J) library for [RLib](https://github.com/JavaSaBr/RLib).

## How to use

#### Maven
```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>

<dependencies>
	<dependency>
		<groupId>com.github.RaaaGEE</groupId>
		<artifactId>rlib.slf4j</artifactId>
		<version>1.0.0</version>
	</dependency>
</dependencies>
```

#### Gradle
```groovy
repositories {
	maven {
		url 'https://jitpack.io' 
	}
}

dependencies {
	compile 'com.github.RaaaGEE:rlib.slf4j:1.0.0'
}
```