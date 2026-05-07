package edu.kiet;

public class Car {

    Engine engine;   

    Car(Engine engine) {
        this.engine = engine; 
    }

    public void start() {
        engine.run(); 
    }
}