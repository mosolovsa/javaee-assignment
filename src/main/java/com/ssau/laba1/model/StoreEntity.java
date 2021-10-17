package com.ssau.laba1.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stores")
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany(mappedBy = "stores",
            fetch = FetchType.EAGER)
    private Set<MallEntity> malls = new HashSet<MallEntity>();

    public StoreEntity() {}

//    public StoreEntity(long id, String name, Set<MallEntity> malls) {
//        this.id = id;
//        this.name = name;
////        this.malls = malls;
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

    public Set<MallEntity> getMalls() {
        return malls;
    }

    public void setMalls(Set<MallEntity> malls) {
        this.malls = malls;
    }
}
