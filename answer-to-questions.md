# Java Frameworks, SOA, REST ve HTTP

## Java Framework'leri

### **Spring framework**

_**Spring**, açık kaynak kodlu bir java framework'üdür. Uygulama geliştirme aşamalarını oldukça kolaylaştırır. Lightweight'dir. İçinde birden çok modül  barındırmakla beraber bunlardan en önemli Core ve Beans'dir ve Dependency Injection gibi SOLID prensibinin temeli olan özelliği sağlar._

_Aşağıda Spring framework'ü ile oluşturulmuş basit bir web aplikasyonu örneği vardır._


``` java
package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
```

### **Hibernate**

_**Hibernate**, Java'da kullanılan nesne odaklı bir nesne ilişkisel eşleme (Object Relational Model)  aracıdır. Basitçe ifade etmek gerekirse , objelerin database'deki kayıtlara nasıl karşılık geldiğini ifade eden bir framework'dür. SQL dilini kullanarak yapacağımız operasyonlar yerine nesneleri kullanırız._

_Örnek bir employee class'ı ve table aşağıdaki şekilde ilişkilendirilir._

``` java
public class employee {
    private int id;
    private String name;
    private String surname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
```

 
``` xml
<?xml version = "1.0" encoding = "utf-8"?>
<!DOCTYPE hibernate-mapping PUBLIC 
"-//Hibernate/Hibernate Mapping DTD//EN"
"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd"> 

<hibernate-mapping>
   <class name = "Employee" table = "EMPLOYEE">
      
      <meta attribute = "class-description">
         This class contains the employee detail. 
      </meta>
      
      <id name = "id" type = "int" column = "id">
         <generator class="native"/>
      </id>
      
      <property name = "name" column = "name" type = "string"/>
      <property name = "surname" column = "surname" type = "string"/>
      
   </class>
</hibernate-mapping>
```

``` sql
create table EMPLOYEE (
   id INT NOT NULL auto_increment,
   name VARCHAR(20) default NULL,
   surname VARCHAR(20) default NULL,
   PRIMARY KEY (id)
);
```

### **Struts**

_**Struts**, servlet ve JSP tabanlı dinamik web aplikasyonları oluşturmak için kullanılan bir framework'dür. MVC (model view framework)'e dayanır. Dizayn temellerini kullanmak için oldukça yararlı bir framework'dür. Geniş bir topluluğa sahiptir._

## SOA

Servis odaklı mimari (SOA), servis adı verilen küçük yazılım bileşenlerini kullanarak uygulama geliştirmeyi amaçlayan bir yazılım geliştirme yaklaşımıdır. Her servis bir amaca odaklanır ve sunar, farklı platform ya da dillerden bağımsız şekilde birbiriyle iletişimde kalabilirler. Bu iletişim yöntemleri için message handler api'leri mevcuttur (Kafka, ZMQ, vs.).

Monolitik mimariye kıyasla iş parçacıklarını olabildiğince küçülttüğü için daha hızlı ve tekrarlanmayan bir yazılım mimarisi oluşur. 

Temel ilkelerine bakarsak aşağıdakileri sayabiliriz: 

* **Birlikte çalışılabilirlik**
* **Gevşek ilişkilendirme**
* **Soyutlama**
* **Ayrıntı düzeyi**

## Web Service

Web servisi, veri aktarımı sürecinin platformdan bağımsız olarak gerçekleşmesini sağlayan yapılardır. HTTP protokolü kullanır. XML ve JSON gibi body formatını kullanabilirler.

Örneğin Java ile geliştirilmiş bir uygulamanın kullanacağı veriyi Python ile geliştirilmiş bir uygulamada istemektedir. Bu durumda web servisleri devremeye girmektedir. Programlama dili bağımsız bir şekilde servisler uygulamalara farklı formatta veri aktarabilirler.

## REST ve RESTful

Rest, Representational State Transfer olarak geçmektedir. Client ve server ilişkisinde HTTP protokülünü kullanarak kolay iletişim kurulmasını amaçlayan mimaridir. Tüm bilgiler endpointler üzerinden elde edilir. Yani bir kullanıcı login olmak istiyorsa, **/login** endpointini kullanacaktır. Yada cihazla ilgili bilgileri almak istiyorsa, **/getInfo** endpointini kullanacaktır. Bu şekilde daha anlamlı ve sade bir yapı amaçlanmaktadır. Response tipi olarak JSON, XML veya HTML dönebilirler. Kullanışlı olmasından dolayı JSON popülerdir. Dil ve platform bağımsızdır. 

RESTful kavramı ise, oluşturulan servis uygulamasının REST prensiplerine uyması anlamına gelir. Bunlar aşağıdaki gibi listelenebilir:

* Stateless
* Cacheable
* Katmanlı yapı
* Uniform interface
* Client-Server yapısı

## SOAP
SOAP, Simple Object Access Protocol anlamına gelir. Genellikle XML formatı ve HTTP methodu kullanır. XML formatına mecbur bıraktığı için REST Kadar esnek yapıya sahip değildir.

## HTTP ve HTTP Methodları

HTTP , TCP/IP Modelinde Aplikasyon katmanında kullanılan bir iletişim protokolüdür. Hypertext Transfer Protocol anlamına gelir ve Client-Server iletişimini belli kurallar çerçevesinde sağlar. Bu kurallar methodlardır. Bazı HTTP Methodları aşağıdaki gibidir.

###### GET
Sorgu yapan metot. Sunucudan veriyi almak için kullanılır. Sorguda belirtilen veriyi sunucudan getirmesini sağlar.

###### POST
Sunucuya veri yazdırmak için kullanılır. Request parametleri hem URL içinde hem de mesaj body'sine eklenebilir.

###### PUT
Sunucuda hali hazırda mevcut olan bir kaynağı güncellemek için kullanılır. POST'dan farkı, PUT'da kaynak mevcuttur ancak POST'da var olmayan bir kaynak iletilebilir.

###### DELETE
Sunucuda herhangi bir kaynağı silmek için kullanılır.

###### PATCH
Sunucuda herhangi bir kaynağın belli bir parametresini değiştirmek için kullanılır.