/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

//    alert("hello");

    $('#myTable').DataTable({
        "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
    }

    );

});



$(document).ready(function () {

 $("#checkAllid").click(function () {
     $('input:checkbox').not(this).prop('checked', this.checked);
 });
 
 });