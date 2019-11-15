let body = document.getElementsByTagName('body').item(0);
//function to crate multiple buttons
let createButton = (buttonValue, parent) => {
    let button = document.createElement("button");
    button.innerHTML = `${buttonValue}`;
    button.id = `${buttonValue}`;
    parent.appendChild(button);
}

//on click of bold
let boldClick = (event) => {
    event.preventDefault();
    let selText, range, boldtextspan;
    boldtextspan = document.createElement("span");
    boldtextspan.className = "bold";
    if (window.getSelection()) {
        selText = window.getSelection();//gets the selection object
        if (selText.rangeCount > 0) {
            range = selText.getRangeAt(0);//gets the range of selected object
            range.surroundContents(boldtextspan);//surround the text object with new node
        }
    }
}

//on click on italic
let italicClick = (event) => {
    event.preventDefault();
    let selText, range, boldtextspan;
    boldtextspan = document.createElement("span");
    boldtextspan.className = "italic";
    if (window.getSelection()) {
        selText = window.getSelection();
        if (selText.rangeCount > 0) {
            range = selText.getRangeAt(0);
            //boldtextspan.textContent = range.toString();
            //range.deleteContents();
            //range.insertNode(boldtextspan);
            range.surroundContents(boldtextspan);
            /* let documentFragment = range.extractContents();
             let el = documentFragment.querySelector(".bold");
             if(el)
             {e1.className="normal";}*/
        }
    }
}

let underLineClick = (event) => {
    event.preventDefault();
    let selText, range, boldtextspan;
    boldtextspan = document.createElement("span");
    boldtextspan.className = "underline";
    if (window.getSelection()) {
        selText = window.getSelection();
        if (selText.rangeCount > 0) {
            range = selText.getRangeAt(0);
            //boldtextspan.textContent = range.toString();
            //range.deleteContents();
            //range.insertNode(boldtextspan);
            range.surroundContents(boldtextspan);
            /* let documentFragment = range.extractContents();
             let el = documentFragment.querySelector(".bold");
             if(el)
             {e1.className="normal";}*/
        }
    }
}

let divToolbar = document.createElement("div");
createButton("Bold", divToolbar);
createButton("Italics", divToolbar);
createButton("Underline", divToolbar);
createButton("Right Align", divToolbar);
createButton("Left align", divToolbar);
createButton("Justify", divToolbar);
body.appendChild(divToolbar);

let boldButton = document.getElementById("Bold");
boldButton.addEventListener("click", boldClick);

let italicButton = document.getElementById("Italics");
italicButton.addEventListener("click", italicClick);

let underLineButton = document.getElementById("Underline");
underLineButton.addEventListener("click", underLineClick);

//let rightAlignButton = document.getElementById("Right Align");
//rightAlignButton.addEventListener("click", rightAlignClick);

let divContent = document.createElement('div');
divContent.id = "text";
divContent.className = "editor";
divContent.innerHTML = "this is line 1.<br> this is line 2";
divContent.contentEditable = "true";

body.appendChild(divContent);