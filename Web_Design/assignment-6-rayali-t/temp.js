let body = document.getElementsByTagName('body').item(0);

let createButton = (buttonValue, parent) => {
    let button = document.createElement("button");
    button.innerHTML = `${buttonValue}`;
    button.id = `${buttonValue}`;
    parent.appendChild(button);
}

let boldClick = () => {
    let boldtext;
    let normaltext;
    let selText;
    let rangeToSelect;
    //event.preventDefault();
    if (window.getSelection()) {
        selText = window.getSelection();
        let selectionFocusNode=selText.focusNode;
        let selectionFocusNodeParent=selText.focusNode.parentNode;
        //let pp=selectionFocusNodeParent.parentNode;
        if (selectionFocusNode) {
            boldtext = `<span class="bold">${selText.focusNode.textContent}</span>`;
            normaltext = `<span class="normal">${selText.focusNode.textContent}</span>`;
            //rangeToSelect =selText.getRangeAt()
            //let selected= selText.a
            //rangeToSelect = document.createRange();
            //rangeToSelect.selectNode(selText.focusNode);
            /*
                      selection.removeAllRanges ();
                      selection.addRange (rangeToSelect);*/
        }
        //selText.anchorNode.parentElement.innerHTML = boldtext;
        /*let boldNode = document.getElementsByClassName('bold');
        boldNode[i]*/
        //if (selectionFocusNodeParent.isEqualNode(selectionFocusNodeParent.parentNode))
        //{console.log("child = parent");}
        if(selectionFocusNodeParent.className === "bold")
        {console.log("child = parent");
            selText.anchorNode.parentElement.innerHTML = normaltext;
            //  selText.anchorNode.parentElement.innerHTML = boldtext;
        }
        else{  selText.anchorNode.parentElement.innerHTML = boldtext;

        }
        //if(selectionFocusNode.hasChildNodes())
        //{
        /*let nodes=selectionFocusNode.childNodes;
        node[0].isEqualNode(SelectionFocusNode)
        {document.removeChild(node[0]);}*/
        window.alert("Hurray");
        console.log("test");
        //}
        /*if(boldtext.isEqualNode(SelectionFocusNode))
        {alert("true");}*/
//console.log(selText);
//window.alert(selText.toString());
        // window.alert(rangeToSelect);
    }
}

let divToolbar = document.createElement("div");
//let leftAlignButton = document.createElement("button");
//leftAlignButton.innerHTML="Bold";
//divToolbar.appendChild(leftAlignButton);
createButton("Bold", divToolbar);
createButton("Italics", divToolbar);
createButton("Underline", divToolbar);
createButton("Right Align", divToolbar);
createButton("Left align", divToolbar);
createButton("Justify", divToolbar);
body.appendChild(divToolbar);

let boldButton = document.getElementById("Bold");
alert(boldButton);
//boldButton.addEventListener('c')
boldButton.addEventListener("click", boldClick);


let divContent = document.createElement('div');
divContent.id = "text";
divContent.className = "editor";
divContent.innerHTML = "test";
divContent.contentEditable = "true";
//document.getElementById("text").contentEditable="true";
//document.getElementById("text").addEventListener("click",this.contentEditable="true");
//let inputArea= document.createElement("textarea");
//inputArea.className="editor";
//divContent.appendChild(inputArea);
/*let p1 = document.createElement('p');
p1.id = "p1";
p1.innerHTML = "p1";
let p2 = document.createElement('p');
p2.id = "p2";
p2.innerHTML = "p2";
divContent.appendChild(p1);
divContent.appendChild(p2);*/
body.appendChild(divContent);

/*function eachNode(rootNode, callback) {
    if (!callback) {
        var nodes = [];
        eachNode(rootNode, function (node) {
            nodes.push(node);
        });
        return nodes;
    }

    if (false === callback(rootNode))
        return false;

    if (rootNode.hasChildNodes()) {
        var nodes = rootNode.childNodes;
        for (var i = 0, l = nodes.length; i < l; ++i)
            if (false === eachNode(nodes[i], callback))
                return;
    }
}

var box = document.getElementById("text");
eachNode(box, function (node) {
    if (null != node.textContent) {
        console.log(node.textContent);
    }
});*/