# bakery-exam
a simple prepackaging order, you may order based on product code given

product             code  
Vegemite Scroll     VS5
Blueberry Muffin    MB11
Croissant           CF

### Requirements
* Java 8
* Maven 3

### BUILD
* mvn clean package

### Testing (goto where the jar is)

* java -jar bakery-1.0-SNAPSHOT.jar quantity productcode
  - java -jar bakery-1.0-SNAPSHOT.jar 14 MB11
