var firstRow = ["Date", "Open Price", "High Price", "Low Price", "Close Price", "Volume"];

function addTableToPage(preciosAcciones, intervalo) {

    if(document.getElementById("tableId") !== null){
        document.getElementById("tableId").remove();
    }
    
    intervalo = String(intervalo).toUpperCase();
    document.getElementById("titleId").innerHTML = intervalo;

    var main = document.getElementById("main");    
    var table = document.createElement("table");

    table.setAttribute("class", "table");
    table.setAttribute("id", "tableId");

    row = document.createElement("tr");

    for (var x in firstRow) {
        var rowItem = document.createElement("th");
        rowItem.innerHTML = firstRow[x];
        row.appendChild(rowItem);
    }

    table.appendChild(row);

    for (var key in preciosAcciones) {
        var row = document.createElement("tr");
        var dateItem = document.createElement("td");
        dateItem.innerHTML = key;
        row.appendChild(dateItem);
        for (var element in preciosAcciones[key]) {
            var rowItem = document.createElement("td");
            rowItem.innerHTML = preciosAcciones[key][element];
            rowItem.innerHTML = preciosAcciones[key][element];
            row.appendChild(rowItem);
        }
        table.appendChild(row);
    }
    main.appendChild(table);
}

function removeOrderById(idOrder) {
    document.getElementById(idOrder).remove();
}

function cargarAcciones(intervalo) {
    axios.get('/acciones/' + intervalo + '/' + document.getElementById("identificador").value)
            .then(function (response) {
                acciones = response.data;
                console.log(acciones);
                for (var key in acciones) {
                    if (String(key).includes("Time Series")) {
                        addTableToPage(acciones[key], intervalo);
                    }
                }
            })
            .catch(function (error) {
                console.log("There is a problem with our servers. We apologize for the inconvince, please try again later" + error);
            });
}

