package com.mycompany.aplicacaoweblabiii.model;

import com.mycompany.aplicacaoweblabiii.model.Post;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-25T11:36:10")
@StaticMetamodel(Tags.class)
public class Tags_ { 

    public static volatile SingularAttribute<Tags, Integer> idTags;
    public static volatile CollectionAttribute<Tags, Post> postCollection;
    public static volatile SingularAttribute<Tags, String> description;

}