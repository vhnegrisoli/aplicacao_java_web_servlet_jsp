package com.mycompany.aplicacaoweblabiii.model;

import com.mycompany.aplicacaoweblabiii.model.Assinatura;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-25T11:36:10")
@StaticMetamodel(Plano.class)
public class Plano_ { 

    public static volatile SingularAttribute<Plano, String> preco;
    public static volatile CollectionAttribute<Plano, Assinatura> assinaturaCollection;
    public static volatile SingularAttribute<Plano, Integer> idPlano;
    public static volatile SingularAttribute<Plano, String> descricao;

}