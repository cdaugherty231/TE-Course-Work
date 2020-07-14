/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */

function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;
}

/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */

function multiplyNoUndefined(firstParameter = 0, secondParameter = 0) {
  return firstParameter * secondParameter;
}


 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

/**
 * JSDoc Example
 * 
 * This method takes information about a person and creates a sentence.
 * By default, it joins the list of quirks with a comma.
 * 
 * @param {string} name 
 * @param {number} age 
 * @param {string[]} listOfQuirks 
 * @param {string} separator 
 * @returns {string} the full sentence about the person
 */
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}

function combineStrings(firstParameter, ...allStrings) {
  let result = '';
  for (let s of allStrings) {
    result += firstParameter + s;
  }
  return result;
}


function returnParam(param) {
  return param;
}

function imperativeForEach() {
  let myArray = [1,2,3,4,5];

  for (let n of myArray) {
    logMultiplyByTwo(n);
  }
}

function logMultiplyByTwo(x) {
  console.log(x * 2);
}

function declarativeForEach() {
  let myArray = [1,2,3,4,5];

  myArray.forEach(x => console.log(x * 2));
}




/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {
  return numbersToFilter.filter(num => num % 3 === 0);
}

function mapDemo() {
  let myArray = ['red', 'blue', 'green'];

  return myArray.map(str => str.substring(1));
}

function mapWithObjects() {
  let objArray = [
    {name: 'Steve', bankBalance: 100},
    {name: 'Martha', bankBalance: 500},
    {name: 'TE Student', bankBalance: 10}
  ];

  objArray.map(person => person.bankBalance += 100);

  return objArray.map(person => person.name + " has a balance of " + person.bankBalance);


}


/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {
  return numbersToSum.reduce((sum, num) => sum + num);
}


function smallestNumber(numbers) {
  return numbers.reduce((smallestSoFar, num) => (num < smallestSoFar)? num : smallestSoFar);
}

function shortestString(strings) {
  return strings.reduce((shortestSoFar, str) => (str.length < shortestSoFar.length)? str : shortestSoFar);
}

function reduceWithObjects() {
  let objArray = [
    {name: 'Steve', bankBalance: 100},
    {name: 'Martha', bankBalance: 500},
    {name: 'TE Student', bankBalance: 10}
  ];

  let totalBalance = objArray.reduce((sum, person) => sum + person.bankBalance, 0);

  let allNames = objArray.reduce((allNames, person) => allNames + ' ' + person.name, 'All customers:');

  return allNames;
}