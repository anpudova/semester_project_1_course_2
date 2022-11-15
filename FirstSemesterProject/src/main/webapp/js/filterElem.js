function funFilter() {
    let inputB, inputC, table, tr, tdB, tdC, txtValueB, txtValueC, i;
    inputB = document.getElementById("input-breed").value.toLowerCase();
    inputC = document.getElementById("input-character").value.toLowerCase();
    table = document.getElementById("table-general");
    tr = table.getElementsByTagName("tr")

    if (inputB !== "all" && inputC !== "all") {
        for (i = 0; i < tr.length; i++) {
            if(tr[i].getElementsByTagName("td")){
                tdB = tr[i].getElementsByTagName("td")[3];
                tdC = tr[i].getElementsByTagName("td")[4];
                if (tdB && tdC) {
                    txtValueB = tdB.textContent || tdB.innerText;
                    txtValueC = tdC.textContent || tdC.innerText;
                    if (txtValueB.toLowerCase().indexOf(inputB) !== -1 && txtValueC.toLowerCase().indexOf(inputC) !== -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    } else if (inputB !== "all") {
        for (i = 0; i < tr.length; i++) {
            if(tr[i].getElementsByTagName("td") && tr[i].getElementsByTagName("td")[3]) {
                tdB = tr[i].getElementsByTagName("td")[3];
                txtValueB = tdB.textContent || tdB.innerText;
                if (txtValueB.toLowerCase().indexOf(inputB) !== -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    } else if (inputC !== "all") {
        for (i = 0; i < tr.length; i++) {
            if(tr[i].getElementsByTagName("td") && tr[i].getElementsByTagName("td")[4]) {
                tdC = tr[i].getElementsByTagName("td")[4];
                txtValueC = tdC.textContent || tdC.innerText;
                if (txtValueC.toLowerCase().indexOf(inputC) !== -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    } else {
        for (i = 0; i < tr.length; i++) {
            tr[i].style.display = "";
        }
    }
}
