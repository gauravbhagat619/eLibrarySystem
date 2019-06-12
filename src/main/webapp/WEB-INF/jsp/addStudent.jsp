<%-- 
    Document   : addStudent
    Created on : May 25, 2019, 12:40:39 PM
    Author     : Gaurav 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- This taglib is used to use Spring Form-->
<%@taglib prefix="form8" uri="http://www.springframework.org/tags/form" %>

<!-- This taglib is used to use Spring Labels-->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../jsp/common.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
    </head>
    <body>
        <%@include file="../jsp/navLibrarian.jsp"%>
        <h1 style="color:red;text-align:center">Add Student</h1>

        <div class="container">
            ${msg}
            <form8:form commandName="student" method="post" style="width:300px" id="frm8">
                <div class="form-group">
                    <label for="name1">Student Name</label>
                    <form8:input type="text" class="form-control" path="name" placeholder="Student Name"/>
                </div>
                <div class="form-group">
                    <label for="mobile1">Contact Number</label>
                    <form8:input type="text" class="form-control" path="contactno" placeholder="Contact No."/>
                </div>
                <div class="form-group">
                    <label for="state1">State</label>
                    <form8:select class="form-control" path="state.state_id" onchange="getDistrictList()" >
                        <form8:option value="0" label="-Select State-"></form8:option>
                        <form8:options items="${stateList}" itemLabel="state_desc" itemValue="state_id"></form8:options>
                    </form8:select>
                </div>
                <div class="form-group">
                    <label for="district1">District</label>
                    <form8:select class="form-control" path="district.districtId"  onchange="getVillageList()" ></form8:select>
                </div>
                
                <div class="form-group">
                    <label for="village1">Village</label>
                <form8:select class="form-control" path="village.villageId"></form8:select>
                </div>
                <!--                <div class="form-group">
                                    <label for="mobile1">Village</label>
                                    <select class="form-control"></select>
                                </div>-->

                <button type="submit" class="btn btn-primary">Submit</button>


            </form8:form> 

            <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
            <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
            <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
            <script>
                // just for the demos, avoids form submit
                $("#frm8").validate({
                    rules: {
                        name: {
                            required: true,
                        },

                        contactno: {
                            required: true,
                            number: true,
                            minlength: 10,
                            maxlength: 10,
                        },
                    },
                    messages: {
                        name: {
                            required: "Please enter Student Name"
                        },

                        contactno: {
                            required: "Please enter contact number"
                        },
                    },
                });

                function getDistrictList() {
                    var stateId = $("#state\\.state_id").val();
                    $.ajax({
                        url: "getDistrictListByStateId.htm",
                        data: {
                            stateid: stateId,
                        },
                        dataType: "json",
                        success: function (json) {
                            if (json !== null) {
                                $('#district\\.districtId').empty();
                                $('#district\\.districtId').append($("<option></option>").attr("value","").text(""));
                                for (i = 0; i < json.length; i++) {

                                    $('#district\\.districtId').append($("<option></option>").attr("value", json[i].districtId).text(json[i].districtDesc));
                                }
                                $('#district\\.districtId').selectpicker('refresh');

                            }
                        },
                        error: function (e) {
                            alert("Some error occured while getting district id list");
                        }
                    });
                }
                
                function getVillageList() {
                    var districtId = $("#district\\.districtId").val();
                    $.ajax({
                        url: "getVillageListByDistrictId.htm",
                        data: {
                            districtid: districtId,
                        },
                        dataType: "json",
                        success: function (json) {
                            if (json !== null) {
                                $('#village\\.villageId').empty();
                               $('#village\\.villageId').append($("<option></option>").attr("value","").text(""));
                                for (i = 0; i < json.length; i++) {

                                    $('#village\\.villageId').append($("<option></option>").attr("value", json[i].villageId).text(json[i].villageDesc));
                                }
                                $('#village\\.villageId').selectpicker('refresh');

                            }
                        },
                        error: function (e) {
                            alert("Some error occured while getting district id list");
                        }
                    });
                }
            </script>
        </div>
    </body>
</html>
