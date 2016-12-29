<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <title>Free CSS template by ChocoTemplates.com</title>
    <link rel="stylesheet" href="../../css/style.css" type="text/css" media="all"/>
    <link rel="stylesheet" href="../../js/jedate/skin/jedate.css" type="text/css" media="all"/>
    <script type="text/javascript" src="../../js/jedate/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="../../js/jedate/jquery.jedate.js"></script>
<#--    <script type="text/javascript">

        $('#executeTime').jeDate({
            format: "YYYY-MM-DD",
            isTime: false,
            minDate: "2014-09-19 00:00:00"
        });
    </script>-->
    <script type="text/javascript">
        $(document).ready(function () {
            $('#executeTime').jeDate({
                minDate: "2014-09-19 00:00:00",
                skinCell: "jedatered"
            });
        });

      /*  $(document).ready(function () {
            // 首先计算屏幕高度
            var height = document.body.clientHeight;
            $("#footer").css("top", height)
            // 拖拉事件计算foot div高度
            $(window).scroll(function () {
                var scrollDiff = document.body.scrollTop //  拖拉处的位移
                $("#footer").css("top", height + scrollDiff) // 重计算底部位置
            });
        })*/
    </script>
    <style type="text/css">#footer {
        position:fixed;
        left:0;
        bottom:0;
        _position:absolute;
        _top:expression(document.documentElement.clientHeight + document.documentElement.scrollTop - this.offsetHeight);
    }</style>

</head>
<body>
<!-- Header -->
<div id="header">
    <div class="shell">
        <!-- Logo + Top Nav -->
        <div id="top">
            <h1><a href="#">Job管理后台</a></h1>
            <div id="top-navigation"> Welcome <a href="#"><strong>Administrator</strong></a>
                <span>|</span>
                <a href="#">Help</a>
                <span>|</span>
                <a href="#">Profile Settings</a>
                <span>|</span>
                <a href="#">Log out</a>
            </div>
        </div>
        <!-- End Logo + Top Nav -->

        <!-- Main Nav -->
        <div id="navigation">
            <ul>
                <li><a href="#" class="active"><span>Dashboard</span></a></li>
            <#-- <li><a href="#"><span>New Articles</span></a></li>
             <li><a href="#"><span>User Management</span></a></li>
             <li><a href="#"><span>Photo Gallery</span></a></li>
             <li><a href="#"><span>Products</span></a></li>
             <li><a href="#"><span>Services Control</span></a></li>-->
            </ul>
        </div>
        <!-- End Main Nav -->
    </div>
</div>
<!-- End Header -->

<!-- Container -->
<div id="container">
    <div class="shell">

        <!-- Small Nav -->
        <div class="small-nav">
            <a href="${homeUrl}">Dashboard</a>
            <span>&gt;</span>
            Job Detail
        </div>
        <!-- End Small Nav -->

        <!-- Message OK -->
    <#-- <div class="msg msg-ok">
         <p><strong>Your file was uploaded succesifully!</strong></p>
         <a href="#" class="close">close</a>
     </div>
     <!-- End Message OK &ndash;&gt;

     <!-- Message Error &ndash;&gt;
     <div class="msg msg-error">
         <p><strong>You must select a file to upload first!</strong></p>
         <a href="#" class="close">close</a>
     </div>-->
        <!-- End Message Error -->
        <br/>
        <!-- Main -->
        <div id="main">
            <div class="cl">&nbsp;</div>
            <!-- Content -->
            <div id="content">

                <!-- Box -->
                <div class="box">
                    <!-- Box Head -->
                    <div class="box-head">
                        <h2 class="left">Job</h2>
                        <div class="right">
                            <form name="search" action="/queryjob" method="get">
                                <label>search Job(暂时只支持根据实体id搜索)</label>
                                <input type="text" name="entityId" class="field small-field"/>
                                <input type="submit" class="button" value="search"/>
                            </form>
                        </div>
                    </div>
                    <!-- End Box Head -->

                    <!-- Table -->
                    <div class="table">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <#--    <tr>
                                <th width="13"><input type="checkbox" class="checkbox"/></th>
                                <th>SceneID</th>
                                <th>EntityID</th>
                                <th>ExecuteTime</th>
                                <th>State</th>
                                <th width="110" class="ac">Content Control</th>
                            </tr>-->
                            <tr>
                            <#-- <th width="13"><input type="checkbox" class="checkbox"/></th>-->
                                <th><h3>No</h3></th>
                                <th><h3>BizDesc</h3></th>
                                <th><h3>EntityId</h3></th>
                                <th><h3>ExecuteTime</h3></th>
                                <th><h3>State</h3></th>
                            <#-- <th><h3>wlistTotalJobs</h3></th>-->
                                <th width="110" class="ac"><h3>Action</h3></th>
                            </tr>
                        <#if jobs??>
                            <#setting datetime_format="yyyy-MM-dd HH:mm:ss"/>

                            <#list jobs as job>

                                <tr>
                                <#-- <td><input type="checkbox" class="checkbox"/></td>-->
                                    <td><h3>${job.no}</h3></td>
                                    <td><h3>${job.jobBizId+"_"+job.jobBizDesc}</h3></td>
                                    <td><h3>${job.jobEntityId}</h3></td>
                                    <td><h3>${(job.executeTime*1000)?number_to_datetime}</h3></td>
                                    <td><h3>${job.jobState}</h3></td>
                                <#--                       <td align="center"><h3>${machine.wlistTotalJobs}</td>-->
                                    <td align="center"><a target="_self" href="${job.deleteUrl}"
                                                          class="ico del">delete</a><#--<a href="${job.editUrl}" class="ico edit">edit</a>-->
                                    </td>
                                </tr>
                            </#list >
                        </#if>
                        </table>
                        <!-- Pagging -->
                    <#--<div class="pagging">
                        <div class="left">Showing 1-12 of 44</div>
                        <div class="right">
                            <a href="#">Previous</a>
                            <a href="#">1</a>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <a href="#">4</a>
                            <a href="#">245</a>
                            <span>...</span>
                            <a href="#">Next</a>
                            <a href="#">View all</a>
                        </div>
                    </div>-->

                    </div>
                    <!-- Table -->

                </div>
                <!-- End Box -->

            </div>
            <!-- End Content -->

            <!-- Sidebar -->
            <div id="sidebar">

                <!-- Box -->
                <div class="box">

                    <!-- Box Head -->
                    <div class="box-head">
                        <h2>Management</h2>
                    </div>
                    <!-- End Box Head-->

                    <div class="box-content">
                        <a href="${addJobUrl}" class="add-button"><span>Add new Job</span></a>
                        <div class="cl">&nbsp;</div>

                    <#--<p class="select-all"><input type="checkbox" class="checkbox"/><label>select all</label></p>
                    <p><a href="#">Delete Selected</a></p>-->

                        <!-- Sort -->
                        <div class="sort">
                            <label>Sort by(暂不支持)</label>
                            <select class="field">
                                <option value="">BizId</option>
                            </select>
                            <select class="field">
                                <option value="">ExecuteTime</option>
                            </select>
                            <select class="field">
                                <option value="">EntityId</option>
                            </select>
                        </div>
                        <!-- End Sort -->

                    </div>
                </div>
                <!-- End Box -->
            </div>
            <!-- End Sidebar -->

            <div class="cl">&nbsp;</div>
        </div>
        <!-- Main -->
    </div>
</div>
<!-- End Container -->

<!-- Footer -->
<div id="footer">
    <div class="shell">
        <span class="left">&copy; 2016 - AnJuKe</span>
        <span class="right">
			Design by <a href="http://chocotemplates.com" target="_blank" title="The Sweetest CSS Templates WorldWide">Chocotemplates.com</a>
		</span>
    </div>
</div>
<!-- End Footer -->

</body>

</html>
