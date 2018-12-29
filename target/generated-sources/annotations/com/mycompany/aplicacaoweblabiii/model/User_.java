package com.mycompany.aplicacaoweblabiii.model;

import com.mycompany.aplicacaoweblabiii.model.Assinatura;
import com.mycompany.aplicacaoweblabiii.model.Post;
import com.mycompany.aplicacaoweblabiii.model.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-25T11:36:10")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> idUser;
    public static volatile SingularAttribute<User, String> password;
    public static volatile CollectionAttribute<User, Post> postCollection;
    public static volatile CollectionAttribute<User, Assinatura> assinaturaCollection;
    public static volatile SingularAttribute<User, Role> idRole;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}