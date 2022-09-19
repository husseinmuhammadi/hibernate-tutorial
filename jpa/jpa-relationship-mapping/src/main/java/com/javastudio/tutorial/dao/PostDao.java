package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.entity.Post;

import java.util.List;

public class PostDao extends GenericDao<Post> {
    public PostDao() {
        super(EntityManagerProvider.PRIMARY_PERSISTENCE_UNIT, Post.class);
    }

    @Override
    protected List<Post> findAll() {
        return getEntityManager().createQuery("select p from Post p", Post.class).getResultList();
    }
}
