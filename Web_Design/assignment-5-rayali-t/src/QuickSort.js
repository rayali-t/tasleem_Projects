//Bachelors notes

let inputArray = [11,9,4,15,2,8,16,7];//input array
let low = 0;//start postion of array
let high =inputArray.length-1;//last position of array
console.log("Input array " + inputArray);
quickSort(inputArray,low,high);
console.log("Sorted Array "+ inputArray);

/**
 *
 * @param inputArray = the numbers to be sorted
 * @param low = start right position
 * @param high = start left position
 * @returns {undefined} = next pivot position
 */
function quickSort(inputArray,low,high)
{
    if(low>=high)
    {return undefined;}
    else
    {
        let p =partition(inputArray,low,high);
        //console.log(inputArray);
        quickSort(inputArray,low,p-1);//recursive call for sorting left part
        quickSort(inputArray,p+1,high);//recursive call for sorting right part
        //console.log(inputArray);
    }
}

function partition(a,low,high)
{
    let p = a[low];//set pivot as the 1st element
    let l = low+1; //left index as next of pivot
    let r = high; //right index as last index of array

    while(true)
    {
        while(p > a[l])//if pivot is greater than a[l] pass
            l++;

        while(p < a[r])// if pivot is less than a[r] pass
            r--;

        if(l<r)// if left index is less than right index swap the elements at respective positions
        {
            t = a[l];
            a[l] = a[r];
            a[r] = t;
        }
        else //swap the element at right index with pivot
        {
            a[low] = a[r];
            a[r] = p;
            break;
        }
    }
    return r;////return the right index as it is the partinioning index
}