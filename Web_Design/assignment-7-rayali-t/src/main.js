import './../css/test.scss';
import {fromEvent} from 'rxjs';

function populateStockData(jsondata, symbolmatch) {
    console.log(jsondata);
    let x;
    jsondata.forEach((row) => {
        if (row.symbol === symbolmatch) {
            const tr = document.createElement("tr");
            for (x in row) {
                const td = document.createElement("td");
                //console.log(row[x]);
                let content = row[x];
                td.textContent = content;
                tr.appendChild(td);
            }
            //const td = document.createElement("td");
            //td.textContent = row.symbol;
            //tr.appendChild(td);
            stockDataBody.appendChild(tr);
        }
    })
}

let xhrFn = (resolve, reject) => {
    const xhr = new XMLHttpRequest();
    let url = "https://api.worldtradingdata.com/api/v1/stock?symbol=SNAP,TWTR,VOD.L&api_token=demo";
    xhr.open("GET", url);
    xhr.onload = () => {
        console.log("test");
        try {
            console.log(xhr.responseText);
            const json = JSON.parse(xhr.responseText);
            var jsondata = json.data;

            let btn = document.getElementById("btnAdd");
            const event$ = fromEvent(btn, "click");
            let subscription = event$.subscribe(e => {
                    //clears out existing table data
                    while (stockDataBody.firstChild) {
                        stockDataBody.removeChild(stockDataBody.firstChild);
                    }
                    console.log("in observable function");
                    let symbolTextNode = document.getElementById("symbolInput");
                    let symbolList = symbolTextNode.value;
                    let symbolArr = symbolList.split(',');
                    for (let i = 0; i < symbolArr.length; i++) {
                        //console.log(symbolArr[i]);
                        let symbol = symbolArr[i];
                        // observer.next(symbol);
                        console.log(symbol);
                        populateStockData(jsondata, symbol);
                    }
                    // observer.next(i);
                }
                )
            ;


            if (resolve)
                resolve();
        } catch (e) {
            console.warn("Cannot load data");
        }
    };
    xhr.onerror
        = () => {
        reject(xhr.statusText)
    };
    xhr.send();

}

let promise = new Promise(xhrFn);
console.log(promise);
promise.then(
    () => {
        console.log('successful promise')
    },
    () => console.log('failed')
);

const stockDataBody = document.querySelector("#stockBody");

let btn = document.getElementById("btnAdd");
const event$ = fromEvent(btn, "click");
let subscription = event$.subscribe(e => {
        console.log("in observable function");
        let symbolTextNode = document.getElementById("symbolInput");
        let symbolList = symbolTextNode.value;
        let symbolArr = symbolList.split(',')
        for (let i = 0; i < symbolArr.length; i++) {
            //console.log(symbolArr[i]);
            let symbol = symbolArr[i];
            // observer.next(symbol);
            console.log(symbol);
        }
        // observer.next(i);
    }
    )
;
subscription.unsubscribe();