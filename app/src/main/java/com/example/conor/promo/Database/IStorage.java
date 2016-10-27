package com.example.conor.promo.Database;

/**
 * Created by conor on 25/10/2016.
 */
public interface IStorage {

    void CREATE ();
    Object READ (Object obj);
    void UPDATE (Object obj);
    void DELETE (Object obj);


}
