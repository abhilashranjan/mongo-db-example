#mongdb-event
 use users
switched to db users
> db.login.drop()
false
> db.createCollection('login',{capped:true, size:3})
{ "ok" : 1 }
> db.login.insert({"username":"abc"})
> db.login.insert({"username":"abc1"})
> db.login.insert({"username":"abc2"})
> db.login.insert({"username":"abc3"})
> db.login.insert({"username":"abc4"})
> db.login.insert({"username":"abc1"})

