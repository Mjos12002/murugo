
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
    if(property_type === 'Commercial'){
        loadCommercial();
    }
    if(property_type === 'Land'){
        loadLand();
    }

}

function loadLand() {
    $.ajax({
        url : 'land',
        method : 'get',
        success : function (data) {
            $("#property_type_data").html(data);
        }, error : function (error, more) {
            $("#property_type_data").html(error);
        }
    });
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

var loadProvince = function () {
    $.ajax({
        url : 'api/get_all_province',
        method : 'get',
        success : function (data) {
            $.each(data, function (k, v) {
                $("#province_id").append("<option value='"+this.id+"'>" + this.provinceName + "</option>");
            })

        }, error : function (error, more) {
            alert(JSON.stringify(error));
        }
    });
}

var loadDistrict = function () {
    $.ajax({
        url : 'api/get_all_district',
        method : 'get',
        success : function (data) {
            $.each(data, function (k, v) {
                $("#district_id").append("<option value='"+this.id+"'>" + this.districtName + "</option>");
            })

        }, error : function (error, more) {
            alert(JSON.stringify(error));
        }
    });
}

var loadSector = function () {
    $.ajax({
        url : 'api/get_all_sector',
        method : 'get',
        success : function (data) {
            $.each(data, function (k, v) {
                $("#sector_id").append("<option value='"+this.id+"'>" + this.sectorName + "</option>");
            })

        }, error : function (error, more) {
            alert(JSON.stringify(error));
        }
    });
}

var loadCell = function () {
    $.ajax({
        url : 'api/get_all_cell',
        method : 'get',
        success : function (data) {
            $.each(data, function (k, v) {
                $("#cell_id").append("<option value='"+this.id+"'>" + this.cellName + "</option>");
            })

        }, error : function (error, more) {
            alert(JSON.stringify(error));
        }
    });
}

var addProvince = function () {

    var province_name = $("#province_name").val();
    $("#server_response").html("Wait while processing ...");
    $.ajax({
        url : "api/addProvince",
        method : "post",
        data : {
            'id' : 0,
            'provinceName' : province_name,
        },
        success : function (response) {
            $("#server_response").html(response["responseDescription"]);
        },
        error : function (err, ex) {
            $("#server_response").html("Error, try again");
        }
    })
}

var addDistrict = function () {
    $("#server_response").html("Wait while loading ...");
    var district_name = $("#district_name").val();
    var province_id = $("#province_id").val();
    $.ajax({
        url : "api/add_district",
        method : "post",
        data : {
            'id' : 0,
            'districtName' : district_name,
            'provinceID' : province_id
        },
        success : function (response) {
            $("#server_response").html(response["responseDescription"]);
        },
        error : function (err, ex) {
            $("#server_response").html(err);
        }
    })
}

var addSector = function () {
    var sector_name = $("#sector_name").val();
    var district_id = $("#district_id").val();
    $.ajax({
        url : "api/add_sector",
        method : "post",
        data : {
            'id' : 0,
            'sectorName' : sector_name,
            'districtID' : district_id
        },
        success : function (response) {
            $("#server_response").html(response['responseDescription']);
        },
        error : function (err, ex) {
            $("#server_response").html(JSON.stringify(err));
        }
    })
}

var addCell = function () {
    var cell_name = $("#cell_name").val();
    var sector_id = $("#sector_id").val();
    alert(cell_name + " -- " + sector_id);
    $.ajax({
        url : "api/add_cell",
        method : "post",
        data : {
            'id' : 0,
            'cellName' : cell_name,
            'sectorID' : sector_id
        },
        success : function (response) {
            $("#server_response").html(response['responseDescription']);
        },
        error : function (err, ex) {
            $("#server_response").html("Error, try again");
        }
    })
}

var addLocation = function () {
    var location_name = $("#location_name").val();
    var cell_id = $("#cell_id").val();
    $.ajax({
        url : "api/add_location",
        method : "post",
        data : {
            'id' : 0,
            'locationName' : location_name,
            'cellID' : cell_id
        },
        success : function (response) {
            $("#server_response").html(response['responseDescription']);
        },
        error : function (err, ex) {
            $("#server_response").html("Error, try again");
        }
    })
}
