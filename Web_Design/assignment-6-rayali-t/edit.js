let body = document.getElementsByTagName('body').item(0);

let createButton = (buttonValue, parent) => {
    let button = document.createElement("button");
    button.innerHTML = `${buttonValue}`;
    button.id = `${buttonValue}`;
    parent.appendChild(button);
}

function eachNode(rootNode, callback) {
    /*  if(!callback){
          var nodes = [];
          eachNode(rootNode, function(node){
              nodes.push(node);
          });
          return nodes;
      }*/

    if (false === callback(rootNode))
        return false;

    if (rootNode.hasChildNodes()) {
        let nodes = rootNode.childNodes;
        for (let i = 0, l = nodes.length; i < l; ++i)
            if (false === eachNode(nodes[i], callback))
                return;
    }
}

let boldClick = (event) => {
    event.preventDefault();
    let selText, range, boldtextspan, childNode;
    let flag = true;
    boldtextspan = document.createElement("span");

    if (window.getSelection()) {
        selText = window.getSelection();
        if (selText.rangeCount > 0) {
            range = selText.getRangeAt(0);
            let documentFragment = range.extractContents();
            let matches = documentFragment.querySelectorAll("span.bold");
            //var box = document.getElementById("box");
            eachNode(documentFragment, function (node) {
                if (null != node.textContent) {
                    console.log(node.textContent);
                    if (node.classList === "bold") {
                        node.classList.remove("bold");
                        flag = false;
                    } else {
                        boldtextspan.appendChild(node);
                        // flag = true;
                    }
                }
            });
            for (let i = 0; i < matches.length; i++) {
                childNode = matches[i];
                if (childNode.classList.contains("bold")) {
                    childNode.classList.remove("bold");
                    flag = false;
                }
            }
            if (flag) {
                boldtextspan.className = "bold";
            }
            range.insertNode(boldtextspan);
        }
    }
}

let italicClick = (event) => {
    event.preventDefault();
    let selText, range, boldtextspan;
    boldtextspan = document.createElement("span");

    if (window.getSelection()) {
        selText = window.getSelection();
        if (selText.rangeCount > 0) {
            range = selText.getRangeAt(0);
            let documentFragment = range.extractContents();
            let matches = documentFragment.querySelectorAll("span.italic");
            //var box = document.getElementById("box");
            eachNode(documentFragment, function (node) {
                if (null != node.textContent) {
                    console.log(node.textContent);
                    if (node.className === "italic") {
                    } else {
                        boldtextspan.appendChild(node);
                    }
                }
            });
            boldtextspan.className = "italic";
            range.insertNode(boldtextspan);
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

let divContent = document.createElement('div');
divContent.id = "text";
divContent.className = "editor";
divContent.innerHTML = "this is line 1.<br> this is line 2";
divContent.contentEditable = "true";

body.appendChild(divContent);