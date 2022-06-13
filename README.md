# Openhab3 Java client


This library allows you to manage your openhab3 instance
without tough process of writing java client by yourself


## Installation


## Getting started

### Connecting to Openhab

Connecting to your openhab is simple as it:
```java
var client = new OpenhabClientImpl("http://192.168.0.257:8080", "login", "password");
```

### Change state of an item
```java
client.item().setState("LivingRoom_Light", "OFF");
```
### Get state of an item
```java
client.item().getState("LivingRoom_Light"); //will return "ON" or "OFF"
```

### Listen activly for events
```java
client.event().all().subscribe(event->{
        System.out.println(event);
});
```
