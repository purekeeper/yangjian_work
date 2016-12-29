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
        })
    </script>
    <style type="text/css">#footer {
        position: fixed;
        left: 0;
        bottom: 0;
        _position: absolute;
        _top: expression(document.documentElement.clientHeight + document.documentElement.scrollTop - this.offsetHeight);
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
            <a href="${homeUrl}" target="_self">Dashboard</a>
            <span>&gt;</span>
            add new job
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
                <!-- End Box -->

                <!-- Box -->
                <div class="box">
                    <!-- Box Head -->
                    <div class="box-head">
                        <h2>Add New Job</h2>
                    </div>
                    <!-- End Box Head -->

                    <form action="/addjob" method="post">

                        <!-- Form -->
                        <div class="form">
                            <p>
                                <label>场景ID<span>(Required Field)</span></label>
                                <input type="text" name="bizId"/>
                            </p>
                            <p>
                                <label>实体ID<span>(Required Field)</span></label>
                                <input type="text" name="entityId"/>
                            </p>
                            <p class="inline-field">
                                <label>执行时间</label>
                                <input id="executeTime" type="text" name="executeTime" placeholder="请选择" readonly/>
                            </p>
                            <p>
                                <label>策略配置(暂时只支持一种)<span>(Required Field)</span></label>
                                <select>
                                    <option>定时执行一次</option>
                                </select>
                            </p>
                        <#--<p>
                            <span class="req">max 100 symbols</span>
                            <label>Content <span>(Required Field)</span></label>
                            <textarea class="field size1" rows="10" cols="30"></textarea>
                        </p>-->
                        </div>
                        <!-- End Form -->

                        <!-- Form Buttons -->
                        <div class="buttons">
                        <#-- <input type="button" class="button" value="preview"/>-->
                            <input type="submit" class="button" value="submit" ac/>
                        </div>
                        <!-- End Form Buttons -->
                    </form>
                </div>
                <!-- End Box -->

            </div>
            <!-- End Content -->

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
