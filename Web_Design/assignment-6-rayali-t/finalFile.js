let body = document.getElementsByTagName('body').item(0);

let createButton = (buttonValue, parent) => {
    let button = document.createElement("button");
    button.innerHTML = `${buttonValue}`;
    button.id = `${buttonValue}`;
    parent.appendChild(button);
}

let boldClick = (event) => {
    event.preventDefault();
    let selText, range, boldtextspan;
    boldtextspan = document.createElement("span");

    if (window.getSelection()) {
        selText = window.getSelection();
        if (selText.rangeCount > 0) {
            range = selText.getRangeAt(0);

            //let documentFragment = range.extractContents();
            //let el = documentFragment.querySelector(".bold");
            //if(el.className==="bold")
            //{el.className="normal";}
            //else{
            //boldtextspan.textContent = range.toString();//1c
            //range.deleteContents();//2c
            //range.insertNode(boldtextspan);//3c
            //*****range.surroundContents(boldtextspan);//}
            /* let documentFragment = range.extractContents();
             let el = documentFragment.querySelector(".bold");
             if(el)
             {e1.className="normal";}*/
            //if()
            /*let isClassBold=boldtextspan.classList.contains("bold");
            if(isClassBold)
            {boldtextspan.classList.remove("bold");
            }*/
            let documentFragment = range.extractContents();
            let children = documentFragment.childNodes;
            let childNode;
            let boldtextspan1;
            //boldtextspan.appendChild(documentFragment);
            // let children = boldtextspan.childNodes;
            var matches = documentFragment.querySelectorAll("span.bold");
            // if (matches.length > 0)
            //{
            //  boldtextspan.classList.remove("bold");
            // matches.classList.remove("bold");


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
                    var nodes = rootNode.childNodes;
                    for (var i = 0, l = nodes.length; i < l; ++i)
                        if (false === eachNode(nodes[i], callback))
                            return;
                }
            }

            //var box = document.getElementById("box");
            eachNode(documentFragment, function (node) {
                if (null != node.textContent) {
                    console.log(node.textContent);
                    if (node.className === "bold") {
                    } else {
                        boldtextspan.appendChild(node);
                    }
                }
            });

            /*  for (let i = 0; i < children.length; i++) {

                  childNode = children[i];
                  if (childNode.className !== "bold") {
                      boldtextspan1 = document.createElement("span");
                      boldtextspan1.classList.add("bold");
                      boldtextspan1.appendChild(childNode);
                      boldtextspan.appendChild(boldtextspan1);

                      while (childNode.chilren) {
                          //  let childChildren=children.childNodes;
                          let childChildren = childNode.chilren;
                          for (let i = 0; i < childChildren[i].length; i++) {
                              let ccNode = childChildren[i];
                              boldtextspan1 = document.createElement("span");
                              boldtextspan1.classList.add("bold");
                              boldtextspan1.appendChild(ccNode);
                              boldtextspan.appendChild(boldtextspan1);
                          }
                          //children=children[i].childNodes;
                      }
                  }


              }*/

            /*   for(let i = 0; i < children.length; i++)
               {
                   childNode = children[i];
                  let childParent=childNode.parentNode;
                  if(childParent.classList.contains("bold"))
                  {
                      childParent.classList.remove("bold");
                  }
                   else if(childNode.classList && childNode.classList.contains("bold"))
                   {

                       //boldtextspan = document.createElement("span");
                       //boldtextspan.appendChild(childNode);
                       childNode.classList.remove("bold");

                   }
                   else
                   {
                       //boldtextspan.appendChild(childNode);
                       boldtextspan.classList.add("bold");
                   }
               }*/
            //}
            //else
            //{
            //  boldtextspan.classList.add("bold");
            //}
            //matches.classList.remove("bold");

            // boldtextspan.appendChild(documentFragment);

            /*for(let i = 0; i < children.length; i++)
            {
                childNode = children[i];
                boldtextspan.appendChild(childNode);
                //childNode.classList.add("bold");
                /*let bool = selText.containsNode(childNode, true);
                if(bool)
                {
                    if(childNode.classList.contains("bold"))
                    {
                        childNode.classList.remove("bold");
                    }
                }*/
            //}
            boldtextspan.className = "bold";
            range.insertNode(boldtextspan);
        }
    }
}

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