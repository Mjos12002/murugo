var time = 0;
var loadPropertyData = function () {

    var property_type = $("#property_type").val();
    if(property_type === 'House'){
        loadHouse();
    }
    if(property_type === 'Annex'){
        loadAnnexHouse();
    }

    function loadAnnexHouse(){
        $.ajax({
            url : 'annex',
            method : 'get',
            success : function (data) {
                $("#property_type_data").html(data);
            }, error : function (error, more) {
                $("#property_type_data").html(error);
            }
        });
    }

    function loadHouse(){
        $.ajax({
            url : 'house',
            method : 'get',
            success : function (data) {
                $("#property_type_data").html(data);
            }, error : function (error, more) {
                $("#property_type_data").html(error);
            }
        });
    }



}

