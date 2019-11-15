//Reference:https://www.geeksforgeeks.org/binary-search/

let inputArray = [20,34,54,67,89,100,106];//input array
let elementTobeFound = 20;
let foundAtIndex=binarySearch(inputArray,elementTobeFound,0,inputArray.length-1);//call to binary search function with array as input
if (elementTobeFound == -1)
{
    console.log("Element not found");
}
else
{console.log("Element found at index: "+foundAtIndex);}

/**
 *
 * @param inputArray = sorted list of numbers
 * @param elementTobeFound = the element to be found
 * @param start = start position for search
 * @param end = end position for search
 * @returns {number | undefined|number} = Returns the index at which number is found
 */
function binarySearch(inputArray,elementTobeFound,start,end)
{

    if(end>=start)
    {

        let midIndex=Math.floor((start+end)/2);
        let midVal= inputArray[midIndex];

        if(elementTobeFound == midVal)
        {
            index=midIndex;
            return index;
        }

        if(elementTobeFound < midVal)
        {

            return  binarySearch(inputArray,elementTobeFound,start,midIndex-1);

        }

        if(elementTobeFound > midVal)
        {
            return binarySearch(inputArray,elementTobeFound,midIndex+1,end);
        }

    }
    else

    {
        return -1;
    }
}