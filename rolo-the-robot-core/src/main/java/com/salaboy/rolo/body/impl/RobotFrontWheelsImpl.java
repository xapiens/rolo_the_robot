/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salaboy.rolo.body.impl;

import com.salaboy.rolo.body.api.RobotFrontWheels;
import com.salaboy.rolo.body.api.RobotMotor;
import com.salaboy.rolo.events.BodyEvent;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author salaboy
 */
public class RobotFrontWheelsImpl implements RobotFrontWheels{
    private String name;
    
    @Inject
    private Event<BodyEvent> messageEvents;
    
    @Inject
    private RobotMotor rightMotor;
    
    @Inject
    private RobotMotor leftMotor;

    public RobotFrontWheelsImpl() {
        this.name = "front-wheels";
        
    }
    
    @PostConstruct
    public void init(){
        rightMotor.setName("motor-right");
        leftMotor.setName("motor-left");
    }

    public RobotFrontWheelsImpl(String name) {
        this.name = name;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public void rotate(String direction, int degrees) {
        messageEvents.fire(new BodyEvent(name+":rotate:2:"+direction+":"+degrees));
    }

    @Override
    public void move(String direction, int distance) {
        messageEvents.fire(new BodyEvent(name+":move:2:"+direction+":"+distance));
    }

    @Override
    public void setWheelsDistance(int distance) {
        messageEvents.fire(new BodyEvent(name+":setDist:1:"+distance));
    }

    @Override
    public void setWheelsDiameter(int diameter) {
        messageEvents.fire(new BodyEvent(name+":setDiam:1:"+diameter));
    }

    @Override
    public String toString() {
        return "RobotFrontWheelsImpl{" + "name=" + name + '}';
    }

    @Override
    public RobotMotor getRightMotor() {
        return rightMotor;
    }

    @Override
    public RobotMotor getLeftMotor() {
        return leftMotor;
    }
    
    
}
