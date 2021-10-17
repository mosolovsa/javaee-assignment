package com.ssau.laba1.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "malls")
public class MallEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;

    @ManyToMany(targetEntity = StoreEntity.class,
            fetch = FetchType.EAGER)
    @JoinTable(name="relations",
            joinColumns=@JoinColumn(name="mall_id"),
            inverseJoinColumns=@JoinColumn(name="store_id"))
    private Set<StoreEntity> stores = new HashSet<StoreEntity>();

    public MallEntity() {}

//    public MallEntity(long id, String name, String address, Set<StoreEntity> stores) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        setStores(stores);
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<StoreEntity> getStores() {
        return stores;
    }

    public void setStores(Set<StoreEntity> stores) {
        this.stores = stores;
    }
}
