Role Name
=========

This roles provisions a Spring Boot application.

Requirements
------------

The Spring Boot application must be built using the [Spring Boot Gradle plugin](http://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-gradle-plugin.html) with the `executable` option set to `true` so that the build produces an executable JAR that can be used as a service.

**example build.gradle** 
```
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.3.5.RELEASE")
    }
}

apply plugin: 'java'
apply plugin: 'spring-boot'

repositories {
    mavenCentral()
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.boot:spring-boot-starter-actuator")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

springBoot {
    executable = true
}

```


Role Variables
--------------

The variables that can be used to parametrize this role and a brief description about them are as follows. (For all variables, take a look at [defaults/main.yml](blob/master/defaults/main.yml))

```
# the application id which is used thorugh the role to derive usernames, folders where the application will be installed, and so on
spring_boot_application_id: "springbootapplication"

# the HTTP port the Spring Boot application should listen to
spring_boot_http_port: 8080
```

Dependencies
------------

No dependencies.

Example Playbook
----------------

Including an example of how to use your role (for instance, with variables passed in as parameters) is always nice for users too:

```
hosts: localhost
roles:
- { role: ansible-springboot-role, 
    spring_boot_file_source_local: 'example-application.jar' 
  }
```

License
-------

BSD

Author Information
------------------

Christian Pelster, pelle@pelle.io, https://github.com/pellepelster/ansible-springboot-role
