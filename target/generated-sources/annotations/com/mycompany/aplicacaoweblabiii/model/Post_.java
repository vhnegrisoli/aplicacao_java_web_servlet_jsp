package com.mycompany.aplicacaoweblabiii.model;

import com.mycompany.aplicacaoweblabiii.model.Category;
import com.mycompany.aplicacaoweblabiii.model.Tags;
import com.mycompany.aplicacaoweblabiii.model.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-25T11:36:10")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, Date> createdAt;
    public static volatile SingularAttribute<Post, Date> publishedAt;
    public static volatile CollectionAttribute<Post, Tags> tagsCollection;
    public static volatile SingularAttribute<Post, User> idAuthor;
    public static volatile SingularAttribute<Post, String> content;
    public static volatile SingularAttribute<Post, Category> idCategory;
    public static volatile SingularAttribute<Post, Integer> idPost;

}