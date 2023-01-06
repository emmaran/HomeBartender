var myNodelist = document.getElementsByTagName("LI");
var i;
for (i = 0; i < myNodelist.length; i++) {
  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7");
  span.className = "close";
  span.appendChild(txt);
  myNodelist[i].appendChild(span);
}

// Click on a close button to hide the current list item
var close = document.getElementsByClassName("close");
var i;
for (i = 0; i < close.length; i++) {
  close[i].onclick = function() {
    var div = this.parentElement;
    div.style.display = "none";
  }
}

// Add a "checked" symbol when clicking on a list item
var list = document.querySelector('ul');
list.addEventListener('click', function(ev) {
  if (ev.target.tagName === 'LI') {
    ev.target.classList.toggle('checked');
  }
}, false);

// Create a new list item when clicking on the "Add" button
function newElement() {
  var li = document.createElement("li");
  var inputValue = document.getElementById("itemNameInput").value;
  var t = document.createTextNode(inputValue);
  li.appendChild(t);
  li.setAttribute("class", "list-group-item d-flex justify-content-between align-items-center");
  if (inputValue === '') {
    alert("You must write something!");
  } else {
    document.getElementById("list").appendChild(li);
  }
  document.getElementById("itemNameInput").value = "";

  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7");
  span.className = "close";
  span.appendChild(txt);
  li.appendChild(span);

  for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
      var div = this.parentElement;
      div.style.display = "none";
    }
  }
}

//    window.addEventListener("load", function() {
//        var form = document.getElementById('addItem');
//        var ul = document.getElementById('list');
//        var items = ul.getElementsByTagName("li");
//
//        var itemNameInput = document.getElementById('itemName');
//        var addItemBtn = document.getElementById('addItemBtn');
//
//        var listItems = [];
//
//        addItemBtn.onclick = function() {
//            var li = document.createElement("li");
//            var xBtn = document.createElement("button");
//            var itemName = document.getElementById('itemName');
//
//            xBtn.setAttribute("type", "button");
//            xBtn.setAttribute("id", 'removeItemBtn');
//            xBtn.setAttribute("class", "btn-close-sm");
//
//            xBtn.setAttribute("aria-label", "Close");
//
//            li.innerHTML = itemName.value;
//            li.setAttribute("class", "list-group-item d-flex justify-content-between align-items-center");
//            li.setAttribute("id", itemName.value);
//            li.setAttribute("name", itemName.value);
//            li.append(xBtn);
//            ul.append(li);
//
//            listItems.push(itemName.value);
//
//            itemNameInput.value = "";
//
//        }
//
//        var removeItemBtn = document.getElementById('removeItemBtn');
//
//        removeItemBtn.onclick = function() {
//
//                    var currentList = document.getElementById('list');
//
//                    var itemToRemove;
//
//                    var removeItemBtn = document.getElementById("removeItemBtn");
//
//                    for (let i = 0; i < listItems.length; i++) {
//                        var listItemToRemove = currentList.getElementById(listItems[i]);
//
//                        if (listItemToRemove.id === listItems[i]) {
//                            itemToRemove = listItems[i];
//                        }
//
//                    };
//
//                    ul.remove(itemToRemove);
//
//        }
//        -------


//        addItemBtn.addEventListener("click", function() {
//
//            var li = document.createElement("li");
//            var xBtn = document.createElement("button");
//            var itemName = document.getElementById('itemName');
//
//            xBtn.setAttribute("type", "button");
//            xBtn.setAttribute("id", 'removeItemBtn');
//            xBtn.setAttribute("class", "btn-close-sm");
//            xBtn.setAttribute('onclick', 'removeItem()'); // for FF
//
//            xBtn.setAttribute("aria-label", "Close");
//
//            li.innerHTML = itemName.value;
//            li.setAttribute("class", "list-group-item d-flex justify-content-between align-items-center");
//            li.setAttribute("id", itemName.value);
//            li.setAttribute("name", itemName.value);
//            li.append(xBtn);
//            ul.append(li);
//
//            listItems.push(itemName.value);
//
//            itemNameInput.value = "";
//
//        });

//        function removeItem() {
//
//            var itemToRemove = listItems[listItems.length+1];
//
//            var removeItemBtn = document.getElementById("removeItemBtn");
//
//                if (removeItemBtn.name === itemToRemove) {
//                    ul.remove(itemToRemove);
//                };
////            var itemName = document.getElementById('itemName');
////            var item = document.getElementById(itemName.value);
////            ul.remove(item);
//        };

//       ul.addEventListener("click", function() {
//
//               var itemName = document.getElementById("itemName");
//               var item = document.getElementById(itemName.value);
//               ul.parentNode.removeChild(item);
//
////              var itemToRemove = ul.getElementById("itemName");
////              ul.parentNode.removeChild(itemToRemove);
//
//
////            for (var i = 0; i <= listItems.length; i++) {
////                if (listItems[i].innerHTML === removeItemBtn.value) {
////                    listItems.slice(listItems[i]);
////                    var itemToRemove = document.getElementByName(listItems[i]);
////
////                    ul.parentNode.removeChild(itemToRemove);
////                }
//
//
////                for (var j = 0; j <= listItems.length; i++) {
////                    if (removeItemBtn.value === listItems[j]) {
////                        var itemToRemove = removeItemBtn.value;
////                    }
////
////                    if (itemToRemove === ul[i].value) {
////                        listItems.slice(ul[i]);
////                    }
////                }
//       });


//    });





