
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

var loadCellData = () => {

    $.ajax({
        url : 'api/get_all_cell',
        method : 'GET',
        success : function (data) {
            $("#available_data").html("Wait while loading ...");
            let counter = 0;
            let table = "<p class='location_title'>List of cells</p>";
            table += "<table class = 'table table-striped table-bordered'>";
            table += "<tr>";
            table += "<td>No</td><td>Cell name</td>";
            table += "</tr>";
            $.each(data, function (k, v) {
                counter ++;
                table += "<tr>";
                table += "<td>" + counter + ".</td>";
                table += "<td>" + this.cellName + "<br/><span style='font-size: 12px'><a style='color: #0a4a55' href='#' onclick='loadProvinceDistrict("+ this.id +")'>View popular locations</a> </span></td>";
                table += "</tr>";
            })
            table += "</table>";
            $("#available_data").html(table);

        }, error : function (error, response) {
            alert(error + " " + response);
        }
    });

}

var loadSectorData = () => {

    $.ajax({
        url : 'api/get_all_sector',
        method : 'GET',
        success : function (data) {
            $("#available_data").html("Wait while loading ...");
            let counter = 0;
            let table = "<p class='location_title'>List of sectors</p>";
            table += "<table class = 'table table-striped table-bordered'>";
            table += "<tr>";
            table += "<td>No</td><td>Sector name</td>";
            table += "</tr>";
            $.each(data, function (k, v) {
                counter ++;
                table += "<tr>";
                table += "<td>" + counter + ".</td>";
                table += "<td>" + this.sectorName + "<br/><span style='font-size: 12px'><a style='color: #0a4a55' href='#' onclick='loadProvinceDistrict("+ this.id +")'>View cells</a> </span></td>";
                table += "</tr>";
            })
            table += "</table>";
            $("#available_data").html(table);

        }, error : function (error, response) {
            alert(error + " " + response);
        }
    });

}

var loadProvinceData = () => {

    $.ajax({
        url : 'api/get_all_province',
        method : 'GET',
        success : function (data) {
            $("#available_data").html("Wait while loading ...");
            let counter = 0;
            let table = "<p class='location_title'>List of provinces</p>";
            table += "<table class = 'table table-striped table-bordered'>";
            table += "<tr>";
            table += "<td>No</td><td>Province name</td>";
            table += "</tr>";
            $.each(data, function (k, v) {
                counter ++;
                table += "<tr>";
                table += "<td>" + counter + ".</td>";
                table += "<td>" + this.provinceName + "<br/><span style='font-size: 12px'><a style='color: #0a4a55' href='#' onclick='loadProvinceDistrict("+ this.id +")'>View districts</a> </span></td>";
                table += "</tr>";
            })
            table += "</table>";
            $("#available_data").html(table);

        }, error : function (error, response) {
            alert(error + " " + response);
        }
    });
}

var loadDistrictData = () => {

    $.ajax({
        url : 'api/get_all_district',
        method : 'GET',
        success : function (data) {
            $("#available_data").html("Wait while loading ...");
            let counter = 0;
            let table = "<p class='location_title'>List of districts</p>";
            table += "<table class = 'table table-striped table-bordered'>";
            table += "<tr>";
            table += "<td>No</td><td>District name</td>";
            table += "</tr>";
            $.each(data, function (k, v) {
                counter ++;
                table += "<tr>";
                table += "<td>" + counter + ".</td>";
                table += "<td>" + this.districtName + "<br/><span style='font-size: 12px'><a style='color: #0a4a55' href='#' onclick='loadProvinceDistrict("+ this.id +")'>View sectors</a> </span></td>";
                table += "</tr>";
            })
            table += "</table>";
            $("#available_data").html(table);

        }, error : function (error, response) {
            alert(error + " " + response);
        }
    });

}

var loadProvinceDistrict = (id) => {
    alert(id);
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
            loadProvinceData();
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
            loadDistrictData();
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
            loadSectorData();
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
            loadCellData();
        },
        error : function (err, ex) {
            $("#server_response").html("Error, try again");
        }
    })
}

var loadPopularLocationData = () => {
    $.ajax({
        url : 'api/get_all_popular_location',
        method : 'GET',
        success : function (data) {
            $("#available_data").html("Wait while loading ...");
            let counter = 0;
            let table = "<p class='location_title'>List of popular locations</p>";
            table += "<table class = 'table table-striped table-bordered'>";
            table += "<tr>";
            table += "<td>No</td><td>Location name</td>";
            table += "</tr>";
            $.each(data, function (k, v) {
                counter ++;
                table += "<tr>";
                table += "<td>" + counter + ".</td>";
                table += "<td>" + this.locationName + "</td>";
                table += "</tr>";
            })
            table += "</table>";
            $("#available_data").html(table);

        }, error : function (error, response) {
            alert(error + " " + response);
        }
    });

}

var loadListingTypeData = () => {

    $.ajax({
        url : 'api/get_all_listing_type',
        method : 'GET',
        success : function (data) {
            $("#available_data").html("Wait while loading ...");
            let counter = 0;
            let table = "<p class='location_title'>List of listing types</p>";
            table += "<table class = 'table table-striped table-bordered'>";
            table += "<tr>";
            table += "<td>No</td><td>Listing type</td>";
            table += "</tr>";
            $.each(data, function (k, v) {
                counter ++;
                table += "<tr>";
                table += "<td>" + counter + ".</td>";
                table += "<td>" + this.listingTypeName + "</td>";
                table += "</tr>";
            })
            table += "</table>";
            $("#available_data").html(table);

        }, error : function (error, response) {
            alert(error + " " + response);
        }
    });


}

var loadPropertyTypeData = () => {

    $.ajax({
        url : 'api/get_all_property_type',
        method : 'GET',
        success : function (data) {
            $("#available_data").html("Wait while loading ...");
            let counter = 0;
            let table = "<p class='location_title'>List of property type</p>";
            table += "<table class = 'table table-striped table-bordered'>";
            table += "<tr>";
            table += "<td>No</td><td>Property type</td>";
            table += "</tr>";
            $.each(data, function (k, v) {
                counter ++;
                table += "<tr>";
                table += "<td>" + counter + ".</td>";
                table += "<td>" + this.propertyTypeName + "</td>";
                table += "</tr>";
            })
            table += "</table>";
            $("#available_data").html(table);

        }, error : function (error, response) {
            alert(error + " " + response);
        }
    });

}

var signIn = () => {

}

var signUp = () => {

}

var addListingType = () => {

    var listing_type = $("#listing_type_name").val();
    $.ajax({
        url : "api/add_listing_type",
        method : "post",
        data : {
            'id' : 0,
            'listingTypeName' : listing_type,
        },
        success : function (response) {
            $("#server_response").html(response['responseDescription']);
            loadListingTypeData();
        },
        error : function (err, ex) {
            $("#server_response").html("Error, try again");
        }
    })

}

var addPropertyType = () => {

    var property_type = $("#property_type_name").val();
    $.ajax({
        url : "api/add_property_type",
        method : "post",
        data : {
            'id' : 0,
            'propertyTypeName' : property_type,
        },
        success : function (response) {
            $("#server_response").html(response['responseDescription']);
            loadPropertyTypeData();
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
            loadPopularLocationData();
        },
        error : function (err, ex) {
            $("#server_response").html("Error, try again");
        }
    })
}
