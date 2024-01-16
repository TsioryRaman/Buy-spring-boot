package com.commerce.buy.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class EntityDto<T> {
    protected T entity;

    public void hydrate()
    {
        for(Field field: this.getClass().getDeclaredFields())
        {
            invokeMethodForArgs(field);
        }
    }

    private void invokeMethodForArgs(Field field)
    {
        try {
            Method method = this.entity.getClass().getDeclaredMethod("set" + field.getName().trim().substring(0,1).toUpperCase() + field.getName().substring(1),field.getType());
            System.out.println("field = " + field.getName());
            field.setAccessible(true);
            method.invoke(this.entity,field.get(this));
            field.setAccessible(false);
        }catch (Exception ignored)
        {

        }
    }

    public void setEntity(T entity)
    {
        this.entity = entity;
    }

    public T getEntity()
    {
        return entity;
    }
}
