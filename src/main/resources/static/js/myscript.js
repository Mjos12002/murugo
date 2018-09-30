var time = 0;
var loadPropertyData = function () {

    var property_type = $("#property_type").val();
    if(property_type === 'House'){
        loadHouse();
    }
    if(property_type === 'Annex' || property_type === 'Apartment'){
        loadAnnexHouse();
    }
    if(property_type === 'Accommodation'){
        loadAccomodation();
    }
    if(property_type === 'commercial'){
        loadCommercial();
    }

}

function loadCommercial() {
    $.ajax({
        url : 'commercial',
        method : 'get',
        success : function (data) {
            $("#property_type_data").html(data);
        }, error : function (error, more) {
            $("#property_type_data").html(error);
        }
    });
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

function loadAccomodation(){
    $.ajax({
        url : 'accommodation',
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

