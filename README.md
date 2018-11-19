
USER 

Зберегти user

/user/save

JSON

{
  "name": "String",
  "age": "0"
}

Знайти всіх user

/user/getAll

Оновити user

/user/update/{userId}

JSON

{
  "name": "String",
  "age": "0"
}

Видалити user з конкретним id

/user/delete/{userId}

Дістати всіх Users, в яких age більше за якесь значення age

/user/findByAge/{age}

Дістати всіх Users з Articles, в яких color якесь певне значення з enum-а(color)

/user/findByColor/{color}

Дістати унікальні name з Users, в яких більше ніж 3 Articles

/user/findByArticles


Article

Зберегти article

/article/save

JSON

{
  "text": "String",
  "color": "String",
  "userId":"0"
}

Знайти всіх article

/article/getAll

Оновити article

/article/update/{articleId}

JSON

{
  "text": "String",
  "color": "String",
  "userId":"0"
}

Видалити article з конкретним id

/article/delete/{articleId}
