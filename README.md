![banner](https://raw.githubusercontent.com/Waifu-pics/Waifus4J/master/src/main/resources/banner.png)

Official minimal Java wrapper for [waifu.pics](https://waifu.pics).
Refer to [the docs](https://waifu.pics/docs) for available endpoints currently in the API

## Add to project
For Maven
```xml
<dependency>
  <groupId>pics.waifu</groupId>
  <artifactId>waifus4j</artifactId>
  <version>VERSION</version>
  <type>pom</type>
</dependency>
```

For Gradle
```
compile 'pics.waifu:waifus4j:VERSION'
```
## Examples
Get a random image from waifu endpoint in `sfw` category
```Java
Waifus4J client = new Waifus4J();
System.out.println(client.getSFWImage("waifu"));
```
the available categories are `sfw`, and `nsfw`. Available endpoints are [here](https://waifu.pics/docs)
