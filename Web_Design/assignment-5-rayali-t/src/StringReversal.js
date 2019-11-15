let inputString = "helloWorld";//initialize input String
let reverseString =getreversedString(inputString);//function call

console.log("Input String: "+ inputString);
console.log("Reversed String "+ reverseString);

/**
 * @param {String} inputString = The String to be reversed
 */
function getreversedString(inputString)
{
    let result="";

    for(j=inputString.length-1;j>=0;j--)
    {result+=inputString[j];
        // console.log(result);
    }
    return result;

}