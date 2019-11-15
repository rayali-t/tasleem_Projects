let body = document.getElementsByTagName('body').item(0);

let createButton = (buttonValue, parent) => {
    let button = document.createElement("button");
    button.innerHTML = `${buttonValue}`;
    button.id = `${buttonValue}`;
    parent.appendChild(button);
}

/*function getSelectionHtml() {
    var sel, range, node;
    if (window.getSelection) {
        sel = window.getSelection();
        if (sel.getRangeAt && sel.rangeCount) {
            range = window.getSelection().getRangeAt(0);

            var html = '<span style="font-weight:bold;">' + range + '</span>';
            range.deleteContents();

            var el = document.createElement("div");
            el.innerHTML = html;
            var frag = document.createDocumentFragment(), node, lastNode;
            while ( (node = el.firstChild) ) {
                lastNode = frag.appendChild(node);
            }
            range.insertNode(frag);
        }
    } else if (document.selection && document.selection.createRange) {
        range = document.selection.createRange();
        range.collapse(false);
        range.pasteHTML(html);
    }

}*/




let boldClick = () => {

    let boldtext;
    let normaltext;
    let selText;
    let rangeToSelect;
    //event.preventDefault();
    if (window.getSelection()) {
        selText = window.getSelection();
        let selectionFocusNode = selText.focusNode;
        let selectionFocusNodeParent = selText.focusNode.parentNode;
        let element = document.getElementById("text");
        let start = 0;
        let end = 0;

        if (selText.rangeCount > 0) {
            let range = selText.getRangeAt(0);
            //range.selectNodeContents(element);
            // boldtext = `<span class="bold">${range.toString()}</span>`;
            //range.textContent=boldtext;
            let preCaretRange = range.cloneRange();
            preCaretRange.selectNodeContents(element);
            preCaretRange.setEnd(range.startContainer, range.startOffset);
            start = preCaretRange.toString().length;
            preCaretRange.setEnd(range.endContainer, range.endOffset);
            end = preCaretRange.toString().length;
            //preCaretRange.setStart(range.startContainer, start);
            //preCaretRange.setEnd(range.endContainer, end);
            //boldtext = `<span class="bold">${preCaretRange.textContent}</span>`;
            console.log("range:" + range + " pc: " + preCaretRange + " start con: " + range.startContainer + "   start: " + start + "end: " + " " + end + "start off " + range.startOffset + " ec " + range.endOffset
                + "pc start : " + preCaretRange.startOffset + " pc eo " + preCaretRange.endOffset);


            // let startNode= range.startContainer;
            //let endNode = range.startContainer;

            //  range.setStart(range.startContainer,start);
            //    range.setEnd(range.endContainer,end);
            //  boldtext = `<span class="bold">${range.toString()}</span>`;
            //window.alert(boldtext);
        }

        /*if (selectionFocusNode) {
            boldtext = `<span class="bold">${selText.focusNode.textContent}</span>`;
            //   normaltext = `<span class="normal">${selText.focusNode.textContent}</span>`;
        }

        if (selectionFocusNodeParent.className === "bold") {
            console.log("child = parent");
        } else {
            selText.anchorNode.parentElement.innerHTML = boldtext;


            window.alert("Hurray");
            console.log("test");

        }*/
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
alert(boldButton);
boldButton.addEventListener("click", boldClick);
//boldButton.addEventListener("click", getSelectionHtml);


let divContent = document.createElement('div');
divContent.id = "text";
divContent.className = "editor";
divContent.innerHTML = "test";
divContent.contentEditable = "true";

body.appendChild(divContent);
