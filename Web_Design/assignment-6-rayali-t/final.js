let body = document.getElementsByTagName('body').item(0);

let createButton = (buttonValue, parent) => {
    let button = document.createElement("button");
    button.innerHTML = `${buttonValue}`;
    button.id = `${buttonValue}`;
    parent.appendChild(button);
}

let boldClick = (event) => {
    event.preventDefault();
    let boldtext;
    let selText;
    let childNode;
    if (window.getSelection()) {
        selText = window.getSelection();
        let element = document.getElementById("text");
        if (selText.rangeCount > 0) {
            let range = selText.getRangeAt(0);

            //let newParent = document.createElement('span');
            let boldtextspan=document.createElement("span");
            boldtextspan.className="bold";
           //1 boldtextspan.textContent=range.toString();
            //range.insertNode(boldtextspan);
            //2 range.deleteContents();
            //3 range.insertNode(boldtextspan);

            var documentFragment = range.extractContents();
            boldtextspan.innerHTML=documentFragment;

     /*       let children = element.childNodes;
            for(let i = 0; i < children.length; i++)
            //for (child in children)
                {
                childNode = children[i];
                let bool = selText.containsNode(childNode, true);
               // if (childNode.nodeName === "#text") {
                    if (bool) {
                       // boldtext = `<span class="bold">${childNode.textContent}</span>`;
                        boldtextspan.textContent=childNode.textContent;
                        console.log("yes");
                        //childNode.insertBefore(boldtextspan);
                        let pNode=children[i].parentNode;
                        //let cNode=boldtext;
                        //pNode.removeChild(children[i]);
                        //pNode.appendChild(boldtextspan);
                        pNode.replaceChild(boldtextspan,children[i]);
                        //var el = document.createElement("span");
                        //.innerHTML = boldtext;
                       //children[i].nodeValue = boldtext;
                        console.log("yes");
                    }
               // }

            }*/
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

let divContent = document.createElement('div');
divContent.id = "text";
divContent.className = "editor";
divContent.innerHTML = "this is line 1.\n this is line 2";
divContent.contentEditable = "true";

body.appendChild(divContent);

