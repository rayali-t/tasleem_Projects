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

let styleButtonClick = (style) => {
    //event.preventDefault();
    let selText, range, boldtextspan, childNode;
    let flag = true;
    boldtextspan = document.createElement("span");

    if (window.getSelection()) {
        selText = window.getSelection();
        if (selText.rangeCount > 0) {
            range = selText.getRangeAt(0);
            let documentFragment = range.extractContents();
            let matches = documentFragment.querySelectorAll(`span.${style}`);
            //var box = document.getElementById("box");
            eachNode(documentFragment, function (node) {
                if (null != node.textContent) {
                    console.log(node.textContent);
                    if (node.classList && node.classList.contains(`${style}`)) {
                        node.classList.remove(`${style}`);
                        flag = false;
                    } else {
                        boldtextspan.appendChild(node);
                        // flag = true;
                    }
                }
            });
            for (let i = 0; i < matches.length; i++) {
                childNode = matches[i];
                if (childNode.classList.contains(`${style}`)) {
                    childNode.classList.remove(`${style}`);
                    flag = false;
                }
            }
            if (flag) {
                boldtextspan.className = `${style}`;
            }
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
boldButton.addEventListener("click", function () {
    styleButtonClick("bold")
});

let italicButton = document.getElementById("Italics");
italicButton.addEventListener("click", function () {
    styleButtonClick("italic")
});

let underlineButton = document.getElementById("Underline");
underlineButton.addEventListener("click", function () {
    styleButtonClick("underline")
});

let rightalighButton = document.getElementById("Right Align");
rightalighButton.addEventListener("click", function () {
    styleButtonClick("rightalign")
});

let leftalighButton = document.getElementById("Left align");
leftalighButton.addEventListener("click", function () {
    styleButtonClick("leftalign")
});

let justifyButton = document.getElementById("Justify");
justifyButton.addEventListener("click", function () {
    styleButtonClick("justify")
});

unload = function () {
    boldButton.removeEventListener("click", function () {
        styleButtonClick("bold")
    });
    italicButton.removeEventListener("click", function () {
        styleButtonClick("italic")
    });
    underlineButton.removeEventListener("click", function () {
        styleButtonClick("underline")
    });
    rightalighButton.removeEventListener("click", function () {
        styleButtonClick("rightalign")
    });
    leftalighButton.removeEventListener("click", function () {
        styleButtonClick("leftalign")
    });
    justifyButton.removeEventListener("click", function () {
        styleButtonClick("justify")
    });
}
body.removeEventListener("onunload", unload());

let divContent = document.createElement('div');
divContent.id = "text";
divContent.className = "editor";
divContent.innerHTML = "this is line 1.<br> this is line 2";
divContent.contentEditable = "true";

body.appendChild(divContent);