![banner](https://raw.githubusercontent.com/Waifu-pics/Waifus4J/master/src/main/resources/banner.png)

Official minimal Java wrapper for [waifu.pics](https://waifu.pics).
Refer to [the docs](https://waifu.pics/docs) for available endpoints currently in the API

## Add to project
For Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
```xml
<dependency>
    <groupId>com.github.Waifu-pics</groupId>
    <artifactId>Waifus4J</artifactId>
    <version>master-SNAPSHOT</version>
</dependency>
```

For Gradle
```groovy
allprojects {
    repositories {
		maven { url 'https://jitpack.io' }
	}
}
```
```groovy
dependencies {
    implementation 'com.github.Waifu-pics:Waifus4J:master-SNAPSHOT'
}
```
## Examples
Get a random image from waifu endpoint in `sfw` category
```Java
Waifus4J client = new Waifus4J();
System.out.println(client.getSFWImage("waifu"));
```
the available categories are `sfw`, and `nsfw`. Available endpoints are [here](https://waifu.pics/docs)
