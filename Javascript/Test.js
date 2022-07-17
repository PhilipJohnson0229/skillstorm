var users = {
    'Active User': 'jerrry'
    ,
    'Paused User': 'thisGuy'
    ,
    'Some other user': ''
}

var usersWithName = Object.keys(users).map(function(key) {
var user = users[key];
user.name = key;
return user;
});

const{first, ...rest } = users;
console.log(rest);

