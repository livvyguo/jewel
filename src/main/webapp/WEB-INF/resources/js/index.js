$(document).ready(function () {
    "use strict";
    var myChart = echarts.init(document.getElementById('main'));

    $.get("./projectResources.json?v="+(new Date()).getMilliseconds()).done(function (data) {
        myChart.setOption(data);
    });

    $("#deliveryDate").datepicker({
        format: 'yyyy-mm-dd',
        language:"zh-CN"
    });
    $("#btnAddProject").on("click", function (e) {
        "use strict";
        e.preventDefault();
        if ($.trim($("#name").val()) == '') {
            alert("请输入项目名称");
            return;
        } else if ($.trim($("#deliveryDate").val()) == '') {
            alert("请输入项目交付时间");
            return;
        }
        var name = $("#name").val();
        var type = $("#type").val();
        var deliveryDate = $("#deliveryDate").val();

        $.post("./addProject", {name:name,type:type,deliveryDate:deliveryDate}).done(function (data) {
            "use strict";
            if (data.success) {
                $.get("./projectResources.json?v="+(new Date()).getMilliseconds()).done(function (dd) {
                    myChart.setOption(dd);
                });
            } else {
                alert(data.errMsg);
            }
        })

    });

});
