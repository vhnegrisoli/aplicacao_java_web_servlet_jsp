
SELECT 
	u.name				AS "Usuario",
	a.status			AS "Status",
	a.data_inicial			AS "Data de inicio",
	c.description			AS "Descricao da categoria",
	pl.descricao			AS "Descricao do plano",
	REPLACE(pl.preco, '.', ',')
					AS "Preco",
	r.description			AS "Descricao do papel",
	p.published_at			AS "Data de publicacao",
	p.content			AS "Conteudo",
	t.description			AS "Descricao da tag"
FROM USER u 
	LEFT JOIN post p ON u.id_user = p.id_author
	LEFT JOIN tags_has_post tp ON p.id_post = tp.post_id
	LEFT JOIN tags t ON t.id_tags = tp.tags_id
	LEFT JOIN ROLE r ON r.id_role = u.id_role
	LEFT JOIN Assinatura a ON a.id_user = u.id_user
	LEFT JOIN category c ON c.id_category = p.id_category
	LEFT JOIN plano pl ON pl.id_plano = a.id_plano
	LEFT JOIN forma_pgt pg ON pg.id_forma_pgt = a.id_forma_pgt;
	