    function sum() {
        var sum = 0;
        var table = document.getElementById("cartItems");
        for (var i = 1, row; row = table.rows[i]; i++){
            sum = sum + parseInt(row.cells[5].innerHTML);
        }
        total.innerHTML = sum;
    }
    document.addEventListener("DOMContentLoaded", sum);
