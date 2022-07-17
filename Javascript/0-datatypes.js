// Object Destructuring
// Allows us to extract certain properties from an object

const person = {
    fullName: {
        firstName: 'John',
        lastName: 'Doe'
    },
    // age: 27,
    favColor: 'Blue',
    hobbies: ['Typing', 'Tweeting', 'Traveling', 'Skydiving'],
    favFood: 'Pizza'
}

// Destructuring properties is like defining a new variable
// Instead of this
let person1Age = person.age;

// We can do this
let {age, fullName, hobbies} = person;
console.log(age, fullName, hobbies);

// Alternatively, you can use it to expect certain parameters in a function call
// This is also gets around the ordering of the items in a call
const printPerson = ({age=30, fullName, ...props}) => {
    console.log(fullName.firstName + ' is ' + age + ' years old');
    console.log(props);
}

printPerson(person);

// Array Destructuring
// Array destructure order DOES matter

const numbers = [67, 234, -235, 6];

const [num1, num2] = numbers;

console.log(num1, num2);