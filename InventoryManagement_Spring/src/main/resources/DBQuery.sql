

    select * from category;
    
    Insert into item(id, name, catFk, strFk)values(2,'Broom',2,1);
    
    Insert into category(categoryId, name, description, price)values(3,'Canned Food','food in a can', 5.0);
    
    Insert into store(storeId, name, location)values(2,'CBS', '246 someotherplace rd St1 USA 67891');
    
    show create table store
;
    select i.name, i.price, c.name as 'category', c.description, s.name as 'store' from item i join store s on i.strFk = s.id join category c on i.catFk = c.id;
    
    update category set description = 'stuff to clean with' where categoryId = 2