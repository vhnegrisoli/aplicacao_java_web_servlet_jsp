package com.mycompany.aplicacaoweblabiii.model;

import com.mycompany.aplicacaoweblabiii.model.FormaPgt;
import com.mycompany.aplicacaoweblabiii.model.Plano;
import com.mycompany.aplicacaoweblabiii.model.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-25T11:36:10")
@StaticMetamodel(Assinatura.class)
public class Assinatura_ { 

    public static volatile SingularAttribute<Assinatura, User> idUser;
    public static volatile SingularAttribute<Assinatura, Integer> desconto;
    public static volatile SingularAttribute<Assinatura, Plano> idPlano;
    public static volatile SingularAttribute<Assinatura, Integer> idAssinatura;
    public static volatile SingularAttribute<Assinatura, Date> dataInicial;
    public static volatile SingularAttribute<Assinatura, FormaPgt> idFormaPgt;
    public static volatile SingularAttribute<Assinatura, Date> dataFinal;
    public static volatile SingularAttribute<Assinatura, String> status;

}