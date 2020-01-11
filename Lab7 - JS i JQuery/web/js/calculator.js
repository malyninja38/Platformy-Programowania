var count = 1

function enterClicked() {
	
	var x = parseFloat($("#input")[0].value);                                       // pobiera wartość z pola tekstowego i zmienia na float  ($ wybiera element, # to id, [0] to faktyczna wartość)

	if(isNaN(x)){ alert("This is not a number"); return; } 

	$("#stack").append( element(x));                                             // dodajemy do stosu
	$("#input")[0].value = "";                                                      // pole tekstowe zerujemy

};

function element(value){                                                            // tworzymy element i cały wygląd kalkulatora

	var li = document.createElement("li");                                          // zwraca link (czyli a) - po najechaniu na element stosu zrobi się lapka

	var badge = document.createElement("span");                                     // tworzy kółeczko z numerkiem
	badge.className = "badge";                                                      // dodajemy klasę do elementu
	badge.innerText = count++;                                                      // ustawiamy numerek w kółeczku

	li.appendChild(badge);                                                          // wstawia nowy węzeł do struktury DOM dokumentu HTML
	li.classList = "list-group-item";
	li.innerHTML += value;                                                          // ustawia lub pobiera zbiór zawartych w danym elemencie znaczników razem z ich treścią
	li.setAttribute("value", value);
	
	return li;                                                                       
}

function getValues(){

	if($("#stack").children().length < 2){
		alert("You must have at least two numbers at stack");
		return;
	}

	var x = $("#stack li").last()[0].getAttribute("value");                       // pobiera wartość z pierwszego elementu na stosie (ostatniego jak patrzeć od góry)
	var b = parseFloat(x);                                                        // zmiana na Float
	if(isNaN(b)){ alert(x + " is not a number"); return; }

	$("#stack li").last().remove();                                                         // usuwanie ze stosu
	count--;

	x = $("#stack li").last()[0].getAttribute("value");
	var a = parseFloat(x);
	if(isNaN(a)){ alert(x + " is not a number"); return; }

	$("#stack li").last().remove();
	count--;

	return {"a":a, "b":b}                                                                   // zwraca obiekt	
}

function add(){

	var calculate = getValues();
	var add = calculate.a + calculate.b;
	$("#stack").append( element(add) );
}

function subtract(){

	var calculate = getValues();
	var subtract = calculate.a - calculate.b;
	$("#stack").append( element(subtract) );
}


function multiply(){

	var calculate = getValues();
	var multiply = calculate.a * calculate.b;
	$("#stack").append( element(multiply) );
}


function divide(){

	var calculate = getValues();

	if(calculate.b != 0){
		var divide = calculate.a / calculate.b;
		$("#stack").append(	element(divide) );
	}
	else{
		$("#stack").append(	element(calculate.a) );                             // dodajemy je na nowo, bo wcześniej były usunięte
		$("#stack").append( element(calculate.b) );
		alert("You can't divide by 0");
	}
}


