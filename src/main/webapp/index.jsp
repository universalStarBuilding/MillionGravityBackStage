<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="jquery-2.2.4.min.js" type="text/javascript"></script>
</head>
<script>
    function loginSystem()
    {
        $.ajax({
            url:"http://localhost:8080/rest/user/web/0",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"get", //传参方式，get 或post
            //传过去的参数，格式为 变量名：变量值
            success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                console.log("this is success! data:"+data,",status="+status);
            },
            error: function(request,status,message){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                //console.log("this is error! request:"+request+",status:"+status+",message:"+message);
                console.log("this is error! request:"+request+",status:"+status+",message:"+message);
                var errrorText = request.responseText;
                var errrorText = eval('(' + errrorText + ')');
                console.log(errrorText[0]["message"]);
            }
        });
//        $.ajax({
//            url:"http://localhost:8080/rest/user/test/aa",
//           // dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
//            type:"get", //传参方式，get 或post
//            //传过去的参数，格式为 变量名：变量值
//            success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
//                console.log("this is success! data:"+data,",status="+status);
//            },
//            error: function(request,status,message){  //若Ajax处理失败后回调函数，msg是返回的错误信息
//                console.log("this is error! request:"+request+",status:"+status+",message:"+message);
//                var errrorText = request.responseText;
//                var errrorText = eval('(' + errrorText + ')');
//                console.log(errrorText[0]["message"]);
//            }
//        });
//        $.ajax({
//            url:"http://localhost:8080/rest/user/test/form",
//            contentType: "application/json; charset=utf-8",
//            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
//            type:"post", //传参方式，get 或post
//            data:JSON.stringify({
//                "email":"1321"
//            }),
//            //传过去的参数，格式为 变量名：变量值
//            success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
//                console.log("this is success! data:"+data,",status="+status);
//            },
//            error: function(request,status,message){  //若Ajax处理失败后回调函数，msg是返回的错误信息
////                console.log(request);
////                console.log("this is error! request:"+request+",status:"+status+",message:"+message);
//                var errrorText = request.responseText;
//                var errrorText = eval('(' + errrorText + ')');
//                console.log(errrorText[0]["message"]);
//            }
//        });
    }
    //获取用户信息
    function getUserInfo()
    {
        $.ajax({
            url:"http://localhost:8080/rest/user/get/1",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"get", //传参方式，get 或post
            //传过去的参数，格式为 变量名：变量值
            success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                console.log("this is success! data:"+data,",status="+status);
                console.log(data);
            },
            error: function(request,status,message){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                console.log("this is error! request:"+request+",status:"+status+",message:"+message);
                console.log(request);
                console.log(request.responseText);
                var json = eval(request.responseText);
                console.log(json.exceptionMsg);
            }
        });
    }
    //修改用户信息
    function updateUserInfo()
    {
        $.ajax({
            url:"http://localhost:8080/rest/user/update",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({
                "userId":"2",
                "realName":"nidaye",
                "nickName":"3",
                "idCardNo":"4",
                "headImg":"3",
                "email":"1321"
            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                console.log("this is success! data:"+data,",status="+status);
            },
            error: function(request,status,message){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                console.log("this is error! request:"+request+",status:"+status+",message:"+message);
                console.log(request.responseText);
            }
        });
    }
    //修改收货地址
    function updatePostAddress()
    {
        $.ajax({
            url:"http://localhost:8080/rest/user/postAddress/update",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({
                "userId":"2",
                "postCode":"4444",
                "postUser":"zs123",
                "mobile":"13127158259",
                "provinceId":"3",
                "countyId":"3",
                "addressDetail":"艾欧尼亚"
            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                alert("Ajax处理已成功：" + text);
                var jsonText=JSON.stringify(text)
                document.write(jsonText);
            },
            error: function(msg){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                alert( "Ajax跳转处理失败");
            }
        });
    }
    //添加收货地址
    function insertPostAddress()
    {
        $.ajax({
            url:"http://localhost:8080/rest/user/postAddress/insert",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({
                "userId":"2",
                "postCode":"3",
                "postUser":"zs123",
                "mobile":"13127158259",
                "provinceId":"3",
                "countyId":"3",
                "addressDetail":"德玛西亚"
            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                alert("Ajax处理已成功：" + text);
                var jsonText=JSON.stringify(text)
                document.write(jsonText);
            },
            error: function(msg){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                alert( "Ajax跳转处理失败");
            }
        });
    }
    //分页查询
    function pageList()
    {
        $.ajax({
            url:"http://localhost:8080/rest/user/postAddress/pageList",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({
                "startPage":"1",
                "rows":"2"
            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                alert("Ajax处理已成功：" + text);
                var jsonText=JSON.stringify(text)
                document.write(jsonText);
            },
            error: function(msg){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                alert( "Ajax跳转处理失败");
            }
        });
    }


    function queryById()
    {
        $.ajax({
            url:"http://localhost:8080/rest/project/msg/queryById",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({

                "startPage":"1",
                "rows":"2"
            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                alert("Ajax处理已成功：" + text);
                var jsonText=JSON.stringify(text)
                document.write(jsonText);
            },
            error: function(msg){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                alert( "Ajax跳转处理失败");
            }
        });
    }

    function queryBy()
    {
        $.ajax({
            url:"http://localhost:8080/rest/project/msg/launchProject/queryBy",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({
                "startPage":"1",
                "rows":"10"
            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                alert("Ajax处理已成功：" + text);
                var jsonText=JSON.stringify(text)
                document.write(jsonText);
            },
            error: function(msg){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                alert( "Ajax跳转处理失败");
            }
        });
    }

    function queryByIdFollow()
    {
        $.ajax({
            url:"http://localhost:8080/rest/project/msg/followProject/queryByIdFollow",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({
                "startPage":"1",
                "rows":"10"
            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                alert("Ajax处理已成功：" + text);
                var jsonText=JSON.stringify(text)
                document.write(jsonText);
            },
            error: function(msg){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                alert( "Ajax跳转处理失败");
            }
        });
    }

    function insert()
    {
        $.ajax({
            url:"http://localhost:8080/rest/project/msg/followProject/insert",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({
                "userId":1,
                "attentionNo":1
            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                alert("Ajax处理已成功：" + text);
                var jsonText=JSON.stringify(text)
                document.write(jsonText);
            },
            error: function(msg){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                alert( "Ajax跳转处理失败");
            }
        });
    }

    function inserts()
    {
        $.ajax({
            url:"http://localhost:8080/rest/project/msg/message/inserts",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({
                "sendId":1,
                "recId":1,
                "messageType":1,
                "title":"aaa",
                "message":"bbb",

            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                alert("Ajax处理已成功：" + text);
                var jsonText=JSON.stringify(text)
                document.write(jsonText);
            },
            error: function(msg){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                alert( "Ajax跳转处理失败");
            }
        });
    }
    function privateLetter()
    {
        $.ajax({
            url:"http://localhost:8080/rest/project/msg/message/privateLetter",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({
                "page":"0",
                "rows":"9",
                "recId":"1",
                "messageType":"0"

            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                alert("Ajax处理已成功：" + text);
                var jsonText=JSON.stringify(text)
                document.write(jsonText);
            },
            error: function(msg){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                console.log(msg);
                alert( "Ajax跳转处理失败");
            }
        });
    }

    function deleteLetter()
    {
        $.ajax({
            url:"http://localhost:8080/rest/project/msg/message/deleteLetter",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({
                "id":"1",

            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                alert("Ajax处理已成功：" + text);
                var jsonText=JSON.stringify(text)
                document.write(jsonText);
            },
            error: function(msg){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                console.log(msg);
                alert( "Ajax跳转处理失败");
            }
        });
    }

    function insertDynamic()
    {
        $.ajax({
            url:"http://localhost:8080/rest/project/msg/dynamic/insertDynamic",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({
                "projectNo":"1",
                "dsclUser":"1",
                "dsclNode":"已上线",
                "ifmtType":"text",
                "ifmtContentDesc":"C盘下的不知道",
                "state":"通过",
                "auditor":"1"
            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                alert("Ajax处理已成功：" + text);
                var jsonText=JSON.stringify(text)
                document.write(jsonText);
            },
            error: function(msg){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                console.log(msg);
                alert( "Ajax跳转处理失败");
            }
        });
    }

    function querysById()
    {
        $.ajax({
            url:"http://localhost:8080/rest/porject/msg/crowdfundComment/queryById",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({
                "topicId":"1",
                "page":"1",
                "rows":"2"
            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                alert("Ajax处理已成功：" + text);
                var jsonText=JSON.stringify(text)
                document.write(jsonText);
            },
            error: function(msg){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                alert( "Ajax跳转处理失败");
            }
        });
    }
    function quartzTest()
    {
        $.ajax({
            url:"http://localhost:8080/rest/porject/msg/crowdfundComment/quartzTest",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({
                "topicId":"1",
                "startPage":"1",
                "rows":"2"
            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                alert("Ajax处理已成功：" + text);
                var jsonText=JSON.stringify(text)
                document.write(jsonText);
            },
            error: function(msg){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                alert( "Ajax跳转处理失败");
            }
        });
    }

    function selectHot()
    {
        $.ajax({
            url:"http://localhost:8080/rest/project/msg/launchProject/selectHot",
            contentType: "application/json; charset=utf-8",
            dataType:"json", //返回的数据类型,text 或者 json数据，建议为json
            type:"post", //传参方式，get 或post
            data:JSON.stringify({
                    "page":"1",
                    "rows":"3",
                    "hot":"1",
                    "hotNum":"2000",
                     "projectState":"funding"
            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                alert("Ajax处理已成功：" + text);
                var jsonText=JSON.stringify(text)
                document.write(jsonText);
            },
            error: function(msg){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                alert( "Ajax跳转处理失败");
            }
        });
    }
        function returnsetSave() {
            $.ajax({
                url: "http://localhost:8080/rest/project/returnset/save",
                contentType: "application/json; charset=utf-8",
                dataType: "json", //返回的数据类型,text 或者 json数据，建议为json
                type: "post", //传参方式，get 或post
                data: JSON.stringify({
                    "projectNo": "002",
                    "price": "500000",
                    "numberLimits": "100",
                    "returnContent": "这是回报内容",
                    "returnType": "goods",
                    "returnImageDesc": "/img/desc/1.img",
                    "returnChannel": "APP",
                    "appPerfScale": "0.99",
                    "remark": "这是备注",
                    "postFlag": "true",
                    "invoiceFlag": "true",
                    "returnDate": "10",
                    "courierFees": "10"
                }),
                //传过去的参数，格式为 变量名：变量值
                success: function (text) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                    alert("Ajax处理已成功：" + text);
                    var jsonText = JSON.stringify(text)
                    document.write(jsonText);
                },
                error: function (msg) {  //若Ajax处理失败后回调函数，msg是返回的错误信息
                    alert("Ajax跳转处理失败");
                }
            });
        }


</script>
<body>
<div id = "error"></div>
    <input type="button" value="测试token" id="testButton" onclick="loginSystem()">
    <input type="button" value="获取用户信息"id="getUserInfo" onclick="getUserInfo()">
    <input type="button" value="修改用户信息"id="updateUserInfo" onclick="updateUserInfo()">
    <input type="button" value="添加收货地址"id="insertPostAddress"onclick="insertPostAddress()">
    <input type="button" value="修改收货地址"id="updatePostAddress" onclick="updatePostAddress()">
    <input type="button" value="分页查询收货地址" onclick="pageList()">
    <input type="button" value="支持" onclick="queryById()">
    <input type="button" value="发起" onclick="queryBy()">
    <input type="button" value="关注" onclick="queryByIdFollow()">
    <input type="button" value="添加关注" onclick="insert()">
    <input type="button" value="添加站内信" onclick="inserts()">
    <input type="button" value="私信列表" onclick="privateLetter()">
    <input type="button" value="删除私信" onclick="deleteLetter()">
    <input type="button" value="项目动态" onclick="insertDynamic()">
    <input type="button" value="项目评论列表" onclick="querysById()">
    <input type="button" value="热门项目列表" onclick="selectHot()">
    <input type="button" value="QuartzTest" onclick="quartzTest()">
    <input type="button" value="添加回报" onclick="returnsetSave()">
</body>
</html>
