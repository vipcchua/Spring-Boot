//  初始位置变量.  =>  Now Part.
Cb.Bs.NP = 'index';

//  初始菜单不存在.   =>  Menu Alive.
Cb.Bs.MA = 0;

//  鼠标移动获取屏幕x值 y值.
Cb.Bs.mMove = function (ev) {
    ev = ev || window.event;
    var mousePos = Cb.Bs.mCoords(ev);
    Cb.Bs.mX = mousePos.x;
    Cb.Bs.mY = mousePos.y;
    // x值  mousePos.x;   y值  mousePos.y;
}
Cb.Bs.mCoords = function (ev) {
    if (ev.pageX || ev.pageY) {
        return { x: ev.pageX, y: ev.pageY };
    }
    return {
        x: ev.clientX + document.body.scrollLeft - document.body.clientLeft,
        y: ev.clientY + document.body.scrollTop - document.body.clientTop
    };
}
document.onmousemove = Cb.Bs.mMove;

//  左键删除出现的菜单.
document.onclick = function () {
    if ($('#menu')[0]) {
        var _m = $('#menu')[0];
        _m.remove();
        Cb.Bs.MA = 0;
    }
}

//  右键生成菜单.
Cb.Bs.RH = function () {
    var _Arg = arguments;
    if (event.button == 2) {
        if (Cb.Bs.MA == 0) {
            Cb.Bs.MA = 1;
        }
        if (Cb.Bs.MA == 1) {
            if ($('#menu')[0]) {
                var _m = $('#menu')[0];
                _m.remove();
            }
            $$('div', { 'id': 'menu', 'style': { 'left': Cb.Bs.mX + 'px', 'top': Cb.Bs.mY + 'px' } }, document.body);
            $$('ul', { 'class': 'menuList' }, $('#menu')[0]);
            switch (_Arg[0]) {
                case 's':
                case 'S':
                    var _i = $$('li', { 'class': 'menuItem' }, $('#menu .menuList')[0]);
                    _i.innerHTML = '创建目录';
                    _i.onclick = function () {
                        Cb.Bs.Prompt('你正在创建新目录, 请输入新目录的名称:', function (_N) {
                            if (_N != '' && _N != null) {
                                Cb.Bs.Confirm('你确定要创建目录 ' + _N + ' 吗?', function (_R) {
                                    if (_R) {
                                        U.CB.Request("pb.addRoot", ([_N, US.userinfo.UserId, Cb.CatalogId, "1"]), function (a) {
                                            var _nI = $$('li', { 'class': 'menuItem' });
                                            _nI.DID = a.value.UserDirectoryID;
                                            $('.supColumn .menuList')[0].insertBefore(_nI, $('.supColumn .menuList')[0].childNodes[0]);
                                            var _nIN = $$('div', { 'class': 'itemName', 'innerHTML': _N, 'tabindex': 0 }, _nI);
                                            _nIN.oncontextmenu = function () {
                                                U.M.StopBubble($('.supColumn')[0].oncontextmenu);
                                                Cb.Bs.RH('C', this);
                                                return false;
                                            }
                                            _nIN.onclick = function () {
                                                if (!this.parentNode.hasClass('chosen')) {
                                                    if ($('.supColumn .menuItem.chosen')[0]) {
                                                        $('.supColumn .menuItem.chosen')[0].removeClass('chosen');
                                                    }
                                                    this.parentNode.addClass('chosen');
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                    break;
                case 'c':
                case 'C':
                    var $i = _Arg[1];
                    var $iD = $i.DID;
                    if ($i.DID == undefined) {
                        $iD = $i.parentNode.DID;
                    }
                    if ($i.isParent($('.supColumn')[0])) {
                        var _iC = $$('li', { 'class': 'menuItem' }, $('#menu .menuList')[0]);
                        _iC.innerHTML = '创建子目录';
                        _iC.onclick = function () {
                            Cb.Bs.Prompt('你正在目录 ' + _oN + ' 下创建子目录, 请输入子目录的名称:', function (_cN) {
                                if (_cN != '' && _cN != null) {
                                    U.CB.Request("pb.addRoot", ([_cN, US.userinfo.UserId, $iD, "1"]), function (a) { });
                                    var _mL, _L;
                                    if (!$i.hasChild('.menuLength')) {
                                        _mL = $$('span', { 'class': 'menuLength', 'innerHTML': '0' }, $i);
                                    }
                                    else {
                                        _mL = $i.child('.menuLength')[0];
                                    }
                                    _L = parseInt(_mL.innerHTML) + 1;
                                    _mL.innerHTML = _L;
                                    _mL.onclick = function () {
                                        Cb.Bs.SSC(this);
                                    }
                                }
                            });
                        }
                    }
                case 't':
                case 'T':
                    var $i = _Arg[1];
                    var $iD = $i.DID;
                    if ($i.DID == undefined) {
                        $iD = $i.parentNode.DID;
                    }
                    var _oN = $i.innerText.replace(/\d+/, '');
                    var _iE = $$('li', { 'class': 'menuItem' }, $('#menu .menuList')[0]);
                    _iE.innerHTML = '编辑目录';
                    _iE.onclick = function () {
                        Cb.Bs.Prompt('你正在修改目录 ' + _oN + ' , 请输入新名称:', function (_nN) {
                            if (_nN != '' && _nN != null) {
                                U.D.SY.XGBKX($iD, _nN, "", function (result) {
                                    if (result != 1) {
                                        Cb.Bs.Alert('修改失败! 发生未知错误请联系管理员解决!');
                                    }
                                    else {
                                        $i.innerHTML = $i.innerHTML.replace(_oN, _nN);
                                        Cb.Bs.Alert('修改成功!');
                                    }
                                });
                            }
                        });
                    }
                    var _iD = $$('li', { 'class': 'menuItem' }, $('#menu .menuList')[0]);
                    _iD.innerHTML = '删除目录';
                    _iD.onclick = function () {
                        Cb.Bs.Confirm("你确定要删除目录 " + _oN + " 吗?", function (R) {
                            if (R) {
                                U.D.SY.SCBK($iD, true, function (result) {
                                    if (result != 1) {
                                        Cb.Bs.Alert('删除失败! 发生未知错误请联系管理员解决!');
                                    }
                                    else {
                                        Cb.Bs.Alert('删除成功!');
                                    }
                                });
                                var DoN = 0;
                                if ($('.s-supColumn')[0]) {
                                    if ($('.articleContainer')[0]) {
                                        $('.articleContainer').fadeIn(700, function () {
                                            DoN++;
                                            if (DoN == 1) {
                                                $('.articleContainer')[0].remove();
                                            }
                                        });
                                    }
                                    $('.s-supColumn').fadeIn(1000, function () {
                                        DoN++;
                                        if (DoN == 1) {
                                            $('.s-supColumn')[0].remove();
                                        }
                                    });
                                }
                                $($i.parentNode).fadeIn(1000, function () {
                                    DoN++;
                                    if (DoN == 1) {
                                        $i.parentNode.remove();
                                    }
                                });
                            }
                        });
                    }
                    break;
                case 'k':
                case 'K':
                    var $i = _Arg[1];
                    var $iD = $i.DID;
                    var _oN = $i.innerText;
                    var _i = $$('li', { 'class': 'menuItem' }, $('#menu .menuList')[0]);
                    _i.innerHTML = '删除子目录';
                    _i.onclick = function () {
                        Cb.Bs.Confirm('你确定要删除目录 ' + _oN + ' 吗?', function (R) {
                            if (R) {
                                U.D.SY.SCBK($iD, true, function (result) {
                                    if (result != 1) {
                                        Cb.Bs.Alert('删除失败! 发生未知错误请联系管理员解决!');
                                    }
                                    else {
                                        Cb.Bs.Alert('删除成功!');
                                        var DoN = 0;
                                        $($i).fadeIn(1000, function () {
                                            DoN++;
                                            if (DoN == 1) {
                                                $i.remove();
                                            }
                                        });
                                        $i.parentNode.previousElementSibling.child('.menuLength')[0].innerText = $i.parentNode.previousElementSibling.child('.menuLength')[0].innerText - 1;
                                        if ($i.parentNode.previousElementSibling.child('.menuLength')[0].innerText == 0) {
                                            $i.parentNode.previousElementSibling.child('.menuLength')[0].remove();
                                            $i.parentNode.remove();
                                        }
                                    }
                                });
                            }
                        });
                    }
                    var _e = $$('li', { 'class': 'menuItem' }, $('#menu .menuList')[0]);
                    _e.innerHTML = '编辑子目录';
                    _e.onclick = function () {
                        Cb.Bs.Prompt('你正在修改目录 ' + _oN + ' , 请输入新名称:', function (_nN) {
                            if (_nN != '' && _nN != null) {
                                U.D.SY.XGBKX($iD, _nN, "", function (result) {
                                    if (result != 1) {
                                        Cb.Bs.Alert('修改失败! 发生未知错误请联系管理员解决!');
                                    }
                                    else {
                                        $i.innerHTML = $i.innerHTML.replace(_oN, _nN);
                                        Cb.Bs.Alert('修改成功!');
                                    }
                                });
                            }
                        });
                    }
                    break;
                case 'a':
                case 'A':
                    var _i = $$('li', { 'class': 'menuItem' }, $('#menu .menuList')[0]);
                    _i.innerHTML = '删除帖子';
                    _i.onclick = function () {
                        Cb.Bs.Confirm("你确定要删除这篇帖子吗?", function (R) {
                            if (R) {
                                var _dI = _Arg[1];
                                if ($('.articleItem.chosen')[0]) {
                                    if (_Arg[1] == $('.articleItem.chosen')[0]) {
                                        _dI = $('.articleItem.chosen')[0];
                                    }
                                }
                                var _cN = _dI.nextSibling;
                                Cb.Bs.DPL(_dI.AID, function (result) {
                                    if (result != 1) {
                                        Cb.Bs.Alert('删除失败! 发生未知错误请联系管理员解决!');
                                    }
                                    else {
                                        Cb.Bs.Alert('删除成功!');
                                    }
                                });
                                var DoN = 0;
                                $(_dI).fadeIn(1000, function () {
                                    DoN++;
                                    if (DoN == 1) {
                                        if (_Arg[1] == $('.articleItem.chosen')[0]) {
                                            U.M.IEVENT(_cN, 'click');
                                        }
                                        _dI.remove();
                                    }
                                });
                            }
                        });
                    }
                    break;
            }
        }
    }
}

//  Login页 => Window.onload.
Cb.Bs.LoginOnload = function () {
    document.onkeydown = function () {     //  判断用户是否按下回车键.
        if (event.keyCode == 13 || event.keyCode == 108) {
            Cb.Bs.Login();
        }
    }
}

//  选中输入框时改变图片地址 , 以达到图片变色的效果
Cb.Bs.LoginChosen = function (e) {
    e.previousElementSibling.src = "/images/Bs/" + e.id + "_selected.png";
}
Cb.Bs.LoginNoChosen = function (e) {
    e.previousElementSibling.src = "/images/Bs/" + e.id + ".png";
}

//  登录.
Cb.Bs.Login = function () {
    var user = $('#user')[0].value;
    var pass = $('#pass')[0].value;
    if (user != "" && user != null && user != undefined) {
        if (pass != "" && pass != null && pass != undefined) {
            Cb.Login(user, pass, function (r) {
                if (r.value == 0) {
                    alert('该账号不存在!');
                    $('#user')[0].value = "";
                    $('#pass')[0].value = "";
                    $('#user')[0].focus();
                    return;
                }
                if (r.value == 1) {
                    alert('账号或者密码错误!请输入正确的账号和密码.');
                    $('#pass')[0].value = "";
                    $('#pass')[0].focus();
                    return;
                }
                else {
                    U.CB.Request("sql", ["ProveQX", 'jrqx', user], function (e) {
                        if (e.value.length > 0) {
                            if (e.value[0].result == 'true') {
                                U.CB.Request("sql", ["UpdateNd", r.value[0][0].UserId, r.value[0][0].UserNickName, r.value[0][0].UserThumbnailImageHead], function (u) { });
                                window.location.href = "/admin/main";
                            }
                        }
                        else {
                            U.CB.Request("sql", ["InsertQX", r.value[0][0].UserId, r.value[0][0].UserName, r.value[0][0].UserNickName, r.value[0][0].UserThumbnailImageHead], function (u) { });
                            alert('你没有进入后台系统的权限! 请和管理员联系认证.');
                            $('#pass')[0].value = "";
                            $('#pass')[0].focus();
                        }
                    });
                }
            }, (["", "", ""]));
        }
        else {
            alert('请输入密码!');
        }
    }
    else {
        alert("请输入账号!");
    }
}

//  返回/刷新操作函数.
Cb.Bs.R = function () {
    if (arguments[0] == '' || arguments[0] == null || arguments[0] == undefined) {
        window.location.href = "/admin/wrong";
    }
    else {
        switch (arguments[0]) {
            case 'Fe':
                Cb.Bs.Confirm("你确定返回前台页面吗?", function (R) {
                    if (R) {
                        window.location.href = "/";
                    }
                });
                break;
            case 'out':
                Cb.Bs.Confirm("你确定登出吗?", function (R) {
                    if (R) {
                        U.U.L.TCUL();
                        window.location.href = "/admin";
                    }
                });
                break;
            case '1473':
                Cb.Bs.Confirm("你确定返回1473吗?", function (R) {
                    if (R) {
                        window.location.href = "http://www.1473.cn";
                    }
                });
                break;
            case 'refresh':
                if (Cb.Bs.NP != 'index') {
                    if ($('.' + Cb.Bs.NP + '-support')[0]) {
                        $('.' + Cb.Bs.NP + '-support')[0].remove();
                    }
                }
                Cb.Bs.GDBNP();
                break;
            default:
                window.location.href = "/admin/wrong";
                break;
        }
    }
}

//  Main页 => Window.onload.
Cb.Bs.MainOnload = function () {
    /*----------------------------------------- 验证用户cookie ----------------------------------------------*/
    if (document.cookie != "" && document.cookie != null && document.cookie != undefined) {
        if (U.M.GetCookie("usestudiosso") != "" && U.M.GetCookie("usestudiosso") != null && U.M.GetCookie("usestudiosso") != undefined) {
            U.CB.Request("UseStudioManage.LoginByCookie", ([U.U.L.GLID().userid, U.U.L.GLID().username, U.U.L.GLID().Loginid, "", 11]), function (a) {
                if (a.value == 0 || a.value == 1) {
                    window.location.href = "/admin/wrong";
                }
                else {
                    U.U.L.SetUserInfo(a.value);
                    var src;
                    US.userinfo.UserThumbnailImageHead.match('q.qlogo.cn') != null ? src = US.userinfo.UserThumbnailImageHead : src = US.fs + US.userinfo.UserThumbnailImageHead;
                    $('.userHead img')[0].attr('src', src);
                    $('.userName').html(US.userinfo.UserNickName);
                    $('#loading').fadeIn(1000);
                }
                U.CB.Request("UseStudioManage.UFIF", ([US.userinfo.UserId]), function (r) {  //  获取用户信息
                    U.CB.Request("sql", ["ProveQX", 'jrqx', r.value[0].UserName], function (e) {
                        if (e.value.length > 0) {
                            if (e.value[0].result == 'false') {
                                window.location.href = "/admin/wrong";
                            }
                        }
                        else {
                            window.location.href = "/admin/wrong";
                        }
                    });
                });
            });
        }
        else {
            window.location.href = "/admin/wrong";
        }
    }
    else {
        window.location.href = "/admin/wrong";
    }
    /*----------------------------------------- 验证用户cookie ----------------------------------------------*/


    /*------------------------------------------ 各种点击事件 -----------------------------------------------*/
    for (var l = 0; l < $('.mainColumn .menuItem').length; l++) {
        $('.mainColumn .menuItem')[l].onclick = function () {
            if (!this.hasClass('chosen')) {
                $('.mainColumn .chosen')[0].removeClass('chosen');
                this.addClass('chosen');
                Cb.Bs.NP = this.attr('name');
                Cb.Bs.GDBNP();
            }
        }
    }

    for (var l = 0; l < $('.hMainColumn .hMenuItem').length; l++) {
        $('.hMainColumn .hMenuItem')[l].onclick = function () {
            if (!this.hasClass('chosen')) {
                $('.hMainColumn .chosen')[0].removeClass('chosen');
                this.addClass('chosen');
                Cb.Bs.NP = this.attr('name');
                Cb.Bs.GDBNP();
            }
        }
    }
    /*------------------------------------------ 各种点击事件 -----------------------------------------------*/
}

//  初始定义克隆项.
Cb.Bs.Cl = { 'xxgl': '', 'sssz': '', 'qxsz': '' };

//  根据NP获取数据.  =>  Get Data By NP.
Cb.Bs.GDBNP = function () {
    for (var m = 0; m < U.M.GTCN($('.support')[0].childNodes).length; m++) {
        U.M.GTCN($('.support')[0].childNodes)[m].style.display = 'none';
    }
    $('.support .top-support')[0].style.display = 'block';
    var DenIED = function () {
        if (!$('.denied-support')[0]) {
            $$('div', { 'class': 'denied-support' }, $('.support')[0]);
            var Alert = $$('div', { 'class': 'alert', 'innerHTML': '你没有该板块的权限! 请和管理员联系获取权限!' }, $('.denied-support')[0]);
        }
        else {
            $('.denied-support')[0].style.display = 'block';
        }
    }
    var NeXT = function () {
        switch (Cb.Bs.NP) {
            case 'index':
                $('.index-support')[0].style.display = 'block';
                break;
            case 'xxgl':
                if (!$('.xxgl-support')[0]) {
                    $$('div', { 'class': 'xxgl-support' }, $('.support')[0]);
                    var _sC = $$('div', { 'class': 'supColumn' }, $('.xxgl-support')[0]);
                    _sC.oncontextmenu = function () {
                        Cb.Bs.RH('S');
                        return false;
                    }
                    $$('ul', { 'class': 'menuList' }, _sC);
                    Cb.SearchSubcatalog(Cb.CatalogId, function (r) {
                        for (var i = 0; i < r.length; i++) {
                            var _I = $$('li', { 'class': 'menuItem' }, $('.supColumn .menuList')[0]);
                            _I.DID = r[i].UserDirectoryID;
                            var _N = $$('div', { 'class': 'itemName', 'innerHTML': r[i].UserDirectoryName, 'tabindex': '0' }, _I);
                            _N.oncontextmenu = function () {
                                U.M.StopBubble(_sC.oncontextmenu);
                                Cb.Bs.RH('C', this);
                                return false;
                            }
                            _N.onclick = function () {
                                if (!this.parentNode.hasClass('chosen')) {
                                    if ($('.supColumn .menuItem.chosen')[0]) {
                                        $('.supColumn .menuItem.chosen')[0].removeClass('chosen');
                                    }
                                    this.parentNode.addClass('chosen');
                                    var that = this;
                                    Cb.GetPublicLog(this.parentNode.DID, function (a) {
                                        if (a.value[0].length > 0) {
                                            that.oncontextmenu = function () {
                                                U.M.StopBubble(_sC.oncontextmenu);
                                                Cb.Bs.RH('T', this);
                                                return false;
                                            }
                                            Cb.Bs.NS = Cb.Bs.NC = that.innerText;
                                            Cb.Bs.NSID = Cb.Bs.NCID = that.parentNode.DID;
                                            Cb.Bs.NA = Cb.Bs.NAID = undefined;
                                            Cb.Bs.GL(a);
                                            if ($('.s-menuItem.chosen')[0]) {
                                                $('.s-menuItem.chosen')[0].removeClass('chosen');
                                            }
                                        }
                                    });
                                }
                            }
                            if (r[i].Next.length > 0) {
                                var _L = $$('span', { 'class': 'menuLength', 'innerHTML': r[i].Next.length, 'onselectstart': 'return false' }, _N);
                                _L.onclick = function () {
                                    Cb.Bs.SSC(this);
                                }
                            }
                            if (i == 0) {
                                U.M.IEVENT(_N, 'click');
                            }
                        }
                    });
                }
                else {
                    $('.xxgl-support')[0].style.display = 'block';
                }
                break;

            case 'sssz':
                if (!$('.sssz-support')[0]) {
                    $$('div', { 'class': 'sssz-support' }, $('.support')[0]);
                    var $sB = $$('div', { 'class': 'supButton' }, $('.sssz-support')[0]);
                    var $S = $$('input', { 'type': 'button', 'class': 'search', 'value': '搜索比赛' }, $sB);
                    $S.onclick = function () {
                        Cb.Bs.Prompt('请输入要搜索比赛的名称关键字,或者输入发起人的名字关键字:', function (_kW) {
                            if (_kW != '' && _kW != null) {
                                $('.matchBody')[0].innerHTML = '';
                                if (!$sB.child('.clean')[0]) {
                                    var $C = $$('input', { 'type': 'button', 'class': 'clean', 'value': '清除查询' }, $sB);
                                    $C.onclick = function () {
                                        $('.matchBody')[0].innerHTML = '';
                                        $('.matchBody')[0].appendChild(Cb.Bs.Cl.sssz);
                                        this.remove();
                                    }
                                }
                                U.CB.Request("sql", ["SelectMatch", _kW], function (e) {
                                    Cb.Bs.CM(e);
                                });
                            }
                        });
                    }
                    var _mH = $$('div', { 'class': 'matchHeader' }, $('.sssz-support')[0]);
                    $$('span', { 'class': 'listName', 'innerHTML': '赛事名称' }, _mH);
                    $$('span', { 'class': 'listName', 'innerHTML': '开始时间' }, _mH);
                    $$('span', { 'class': 'listName', 'innerHTML': '结束时间' }, _mH);
                    $$('span', { 'class': 'listName', 'innerHTML': '发起人' }, _mH);
                    $$('span', { 'class': 'listName', 'innerHTML': '提交时间' }, _mH);
                    $$('span', { 'class': 'listName', 'innerHTML': '状态' }, _mH);
                    var _mB = $$('div', { 'class': 'matchBody' }, $('.sssz-support')[0]);
                    U.CB.Request("sql", ["SelectMatch", '#all'], function (r) {
                        Cb.Bs.CM(r);
                        Cb.Bs.Cl.sssz = $('.matchList')[0].clone(true);
                    });
                }
                else {
                    $('.sssz-support')[0].style.display = 'block';
                }
                break;
            case 'qxsz':
                if (!$('.qxsz-support')[0]) {
                    $$('div', { 'class': 'qxsz-support' }, $('.support')[0]);
                    var $sB = $$('div', { 'class': 'supButton' }, $('.qxsz-support')[0]);
                    var $S = $$('input', { 'type': 'button', 'class': 'search', 'value': '搜索用户' }, $sB);
                    $S.onclick = function () {
                        Cb.Bs.Prompt('请输入要搜索用户的部分信息:', function (_uN) {
                            if (_uN != '' && _uN != null) {
                                $('.listContainer')[0].innerHTML = '';
                                if (!$sB.child('.clean')[0]) {
                                    var $C = $$('input', { 'type': 'button', 'class': 'clean', 'value': '清除查询' }, $sB);
                                    $C.onclick = function () {
                                        $('.listContainer')[0].innerHTML = '';
                                        $('.listContainer')[0].appendChild(Cb.Bs.Cl.qxsz);
                                        this.remove();
                                    }
                                }
                                U.CB.Request("sql", ["SelectQX", _uN], function (e) {
                                    Cb.Bs.CUL(e);
                                    Cb.Bs.Cl.qxsz = $('.userList')[0].clone(true);
                                });
                            }
                        });
                    }
                    var _lH = $$('div', { 'class': 'listHeader' }, $('.qxsz-support')[0]);
                    $$('span', { 'class': 'listName', 'innerHTML': '用户名' }, _lH);
                    $$('span', { 'class': 'listName', 'innerHTML': '用户昵称' }, _lH);
                    $$('span', { 'class': 'listName', 'innerHTML': '进入权限' }, _lH);
                    $$('span', { 'class': 'listName', 'innerHTML': '信息管理' }, _lH);
                    $$('span', { 'class': 'listName', 'innerHTML': '赛事设置' }, _lH);
                    $$('span', { 'class': 'listName', 'innerHTML': '成绩管理' }, _lH);
                    $$('span', { 'class': 'listName', 'innerHTML': '权限设置' }, _lH);
                    $$('span', { 'class': 'listName', 'innerHTML': '报名设置' }, _lH);
                    var _lC = $$('div', { 'class': 'listContainer' }, $('.qxsz-support')[0]);
                    U.CB.Request("sql", ["SelectQX", '#all'], function (r) {
                        Cb.Bs.CUL(r);
                    });
                }
                else {
                    $('.qxsz-support')[0].style.display = 'block';
                }
                break;
        }
    }
    if (Cb.Bs.NP != 'index') {
        U.CB.Request("sql", ["ProveQX", Cb.Bs.NP, US.userinfo.UserName], function (e) {
            if (e.value.length > 0) {
                e.value[0].result != 'true' ? DenIED() : NeXT();
            }
            else {
                window.location.href = "/admin/wrong";
            }
        });
    }
    else {
        NeXT();
    }
}

//  刷出子目录.  => Show SubCatalog.
Cb.Bs.SSC = function ($mL) {
    $mL.toggleClass('open');
    U.M.StopBubble($mL.parentNode.onclick);
    if (!$mL.parentNode.parentNode.child('.s-menuList')[0]) {
        var _sL = $$('ul', { 'class': 's-menuList' }, $mL.parentNode.parentNode);
        Cb.SearchSubcatalog($mL.parentNode.parentNode.DID, function (a) {
            for (var k = 0; k < a.length; k++) {
                var _sI = $$('li', { 'class': 's-menuItem', 'innerHTML': a[k].UserDirectoryName, 'tabindex': '0' }, _sL);
                _sI.DID = a[k].UserDirectoryID;
                _sI.oncontextmenu = function () {
                    U.M.StopBubble($('.supColumn')[0].oncontextmenu);
                    Cb.Bs.RH('K', this);
                    return false;
                }
                _sI.onclick = function () {
                    if (!this.hasClass('chosen')) {
                        Cb.Bs.NS = this.parentNode.previousElementSibling.innerText.replace(/\d+/, '');
                        Cb.Bs.NSID = this.parentNode.parentNode.DID;
                        Cb.Bs.NC = this.innerText;
                        Cb.Bs.NCID = this.DID;
                        if ($('.s-menuItem.chosen')[0]) {
                            $('.s-menuItem.chosen')[0].removeClass('chosen');
                        }
                        this.addClass('chosen');
                        Cb.GetPublicLog(Cb.Bs.NCID, function (e) {
                            Cb.Bs.GL(e);
                            Cb.Bs.Cl.xxgl = $('.articleList')[0].clone(true);
                        });
                    }
                    if ($('.supColumn .menuItem.chosen')[0]) {
                        $('.supColumn .menuItem.chosen')[0].removeClass('chosen');
                    }
                }
            }
            _sL.style.display = 'block';
        });
    }
    else {
        if (!$mL.hasClass('open')) {
            $mL.parentNode.parentNode.child('.s-menuList')[0].style.display = 'none';
        }
        else {
            $mL.parentNode.parentNode.child('.s-menuList')[0].style.display = 'block';
        }
    }
}

//  定义编辑模式变量.
Cb.Bs.EDM = 0;

//  刷出文章列表.
Cb.Bs.GL = function (C) {
    if (!$('.s-supColumn')[0]) {
        $$('div', { 'class': 's-supColumn' }, $('.xxgl-support')[0]);
        $$('div', { 'class': 'supButton' }, $('.s-supColumn')[0]);
        var _aD = $$('input', { 'type': 'button', 'class': 'add', 'value': '添加帖子' }, $('.s-supColumn .supButton')[0]);
        _aD.onclick = function () {
            U.D.SY.FBTZTC(Cb.Bs.NCID, function (a) {
                console.log(a);
            });
        }
        var _sH = $$('input', { 'type': 'button', 'class': 'search', 'value': '搜索帖子' }, $('.s-supColumn .supButton')[0]);
        _sH.onclick = function () {
            Cb.Bs.Prompt('请输入要搜索文章的关键字:', function (_N) {
                if (_N != '' && _N != null) {
                    if (!$('.s-supColumn .supButton .clean')[0]) {
                        var $C = $$('input', { 'type': 'button', 'class': 'clean', 'value': '清除查询' }, $('.s-supColumn .supButton')[0]);
                        $C.onclick = function () {
                            $('.articleList')[0].remove();
                            $('.s-supColumn')[0].appendChild(Cb.Bs.Cl.xxgl);
                            this.remove();
                        }
                    }
                    Cb.SearchPublicLog(_N, Cb.Bs.NCID, function (r) {
                        Cb.Bs.GL(r);
                    });
                }
            });
        }
        $$('ul', { 'class': 'articleList' }, $('.s-supColumn')[0]);
    }
    else {
        $('.articleList')[0].innerHTML = '';
        if ($('.articleContainer')[0]) {
            $('.articleContainer')[0].innerHTML = ''
        }
    }
    if (C.value != '') {
        var $A;
        C.value.length != 1 ? $A = C.value : $A = C.value[0];
        for (var i = 0; i < $A.length; i++) {
            var _aI = $$('li', { 'class': 'articleItem', 'tabindex': '0' }, $('.articleList')[0]);
            _aI.AID = $A[i].ArticleID;
            _aI.oncontextmenu = function () {
                Cb.Bs.RH('A', this);
                return false;
            }
            _aI.onclick = function () {
                Cb.Bs.SA(this);
            }
            var _uH = $$('div', { 'class': 'userHead' }, _aI);
            $$('img', { 'src': US.fs + $A[i].UserThumbnailImageHead }, _uH);
            var _aM = $$('div', { 'class': 'articleMain' }, _aI);
            var _aMPo = $$('div', { 'class': 'mainPartO' }, _aM);
            var _aMPt = $$('div', { 'class': 'mainPartO' }, _aM);
            var _aT = $$('div', { 'class': 'articleTitle', 'innerHTML': $A[i].ArticleTitle }, _aMPo);
            var _aP = $$('div', { 'class': 'articlePublish', 'innerHTML': $A[i].UserNickName + '&nbsp;&nbsp;发布于&nbsp;&nbsp;' + U.MT.GetDT($A[i].ArticleAddTime) }, _aMPo);
            var _aID = $$('div', { 'class': 'articleID', 'innerHTML': $A[i].ArticleID }, _aMPt);
            var _rN = $$('div', { 'class': 'rNumber', 'innerHTML': '回复数&nbsp;&nbsp;<b>' + $A[i].ArticleReplayNumber + '</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;阅读数&nbsp;&nbsp;<b>' + $A[i].AricitleReadNumber + '</b>' }, _aMPt);
            var _rNs = $$('div', { 'class': 'rNumberS', 'innerHTML': '<b class="rp">' + $A[i].ArticleReplayNumber + '</b>&nbsp;/&nbsp;<b class="rd">' + $A[i].AricitleReadNumber + '</b>' }, _aMPt);
            Cb.Bs.Cl.xxgl = $('.articleList')[0].clone(true);
        }
    }
}

//  刷出文章.
Cb.Bs.SA = function ($A) {
    if (!$A.hasClass('chosen')) {
        Cb.Bs.NA = $A.child('.articleTitle')[0].innerText;
        Cb.Bs.NAID = $A.AID;
        if ($('.articleItem.chosen')[0]) {
            $('.articleItem.chosen')[0].removeClass('chosen');
        }
        $A.addClass('chosen');
        if (!$('.articleContainer')[0]) {
            $$('div', { 'class': 'articleContainer' }, $('.xxgl-support')[0]);
        }
        else {
            $('.articleContainer')[0].innerHTML = '';
        }
        Cb.GetLogContent($A.AID, function (c) {
            var _aH = $$('div', { 'class': 'articleHeader' }, $('.articleContainer')[0]);
            var _uH = $$('div', { 'class': 'userHead' }, _aH);
            $$('img', { 'src': US.fs + c.value[0].UserThumbnailImageHead }, _uH);
            var _aM = $$('div', { 'class': 'articleMain' }, _aH);
            var _aT = $$('div', { 'class': 'articleTitle', 'innerHTML': c.value[0].ArticleTitle, 'tabindex': '0' }, _aM);
            var _aO = $$('div', { 'class': 'articleOutline', 'innerHTML': c.value[0].UserNickName + '&nbsp;&nbsp;发布于&nbsp;&nbsp;' + U.MT.GetDT(c.value[0].ArticleAddTime) }, _aM);
            var _aCtr = $$('div', { 'class': 'articleControl' }, _aM);
            var _sR = $$('span', { 'class': 'reply', 'innerHTML': '查看回复' }, _aCtr);
            _sR.onclick = function () {

            }
            var _e = $$('span', { 'class': 'edit', 'innerHTML': '编辑' }, _aCtr);
            _e.onclick = function () {
                var that = this;
                if (Cb.Bs.EDM == 0) {
                    Cb.Bs.EDM = 1;
                    var _oT = $('.articleHeader .articleTitle')[0].innerHTML;
                    var _oC = $('.articleContent')[0].innerHTML;
                    $('.articleHeader .articleTitle')[0].attr('contentEditable', 'true');
                    $('.articleHeader .articleTitle')[0].addClass('edit');
                    $('.articleContent')[0].attr('contentEditable', 'true');
                    $('.articleContent')[0].focus();
                    var sel = window.getSelection();
                    var tempRange = document.createRange();
                    tempRange.setStart($('.articleContent')[0].firstChild, $('.articleContent')[0].firstChild.length);
                    sel.removeAllRanges();
                    sel.addRange(tempRange);
                    that.innerHTML = '完成编辑';
                    var _ex = $$('span', { 'class': 'exitEdit', 'innerHTML': '退出编辑' });
                    $('.articleControl')[0].insertBefore(_ex, $('.articleControl .delete')[0]);
                    _ex.onclick = function () {
                        Cb.Bs.Confirm("你确定退出编辑吗?", function (R) {
                            if (R) {
                                Cb.Bs.EDM = 0;
                                that.innerHTML = '编辑';
                                $('.articleHeader .articleTitle')[0].attr('contentEditable', 'inherit');
                                $('.articleHeader .articleTitle')[0].removeClass('edit');
                                $('.articleHeader .articleTitle')[0].innerHTML = _oT;
                                $('.articleContent')[0].attr('contentEditable', 'inherit');
                                $('.articleContent')[0].innerHTML = _oC;
                                this.remove();
                            }
                        });
                    }
                }
                else if (Cb.Bs.EDM == 1) {
                    Cb.Bs.Confirm("你确定完成编辑吗?", function (R) {
                        if (R) {
                            Cb.Bs.EDM = 0;
                            that.innerHTML = '编辑';
                            $('.articleHeader .articleTitle')[0].attr('contentEditable', 'inherit');
                            $('.articleHeader .articleTitle')[0].removeClass('edit');
                            $('.articleContent')[0].attr('contentEditable', 'inherit');
                            Cb.Bs.EPL(Cb.Bs.NAID, $('.articleHeader .articleTitle')[0].innerHTML, $('.articleContent')[0].innerHTML, function (result) {
                                if (result != 1) {
                                    Cb.Bs.Alert('编辑失败! 发生未知错误请联系管理员解决!');
                                }
                                else {
                                    Cb.Bs.Alert('编辑成功!');
                                }
                            });
                            var _ex = $('.articleControl .exitEdit')[0];
                            _ex.remove();
                        }
                    });
                }
            }
            var _d = $$('span', { 'class': 'delete', 'innerHTML': '删除' }, _aCtr);
            _d.onclick = function () {
                Cb.Bs.Confirm("你确定要删除吗?", function (R) {
                    if (R) {
                        var _dI = $('.articleItem.chosen')[0];
                        var _cN = _dI.nextSibling;
                        Cb.Bs.DPL(Cb.Bs.NAID, function (result) {
                            if (result != 1) {
                                Cb.Bs.Alert('删除失败! 发生未知错误请联系管理员解决!');
                            }
                            else {
                                Cb.Bs.Alert('删除成功!');
                            }
                        });
                        var DoN = 0;
                        $(_dI).fadeIn(1000, function () {
                            DoN++;
                            if (DoN == 1) {
                                _dI.remove();
                                U.M.IEVENT(_cN, 'click');
                            }
                        });
                    }
                });
            }
            var _aC = $$('div', { 'class': 'articleContent', 'innerHTML': c.value[0].ArticleContent }, $('.articleContainer')[0]);
            $$('div', { 'class': 'allReplyContainer' }, $('.articleContainer')[0]);
            Cb.GetLogReply(Cb.Bs.NAID, function (r) {
                var _rH = $$('div', { 'class': 'replyHeader', 'innerHTML': r.value.length + '&nbsp;回复' }, $('.allReplyContainer')[0]);
                _rH.RL = r.value.length;
                var _aR = $$('span', { 'class': 'addReply', 'innerHTML': '添加回复' }, _rH);
                _aR.onclick = function () {
                    Cb.Bs.ALR(({ target: '本文' }));
                }
                var _arC = $$('div', { 'class': 'allReplyContent' }, $('.allReplyContainer')[0]);
                var _rL = $$('ul', { 'class': 'replyList' }, _arC);
                if (r.value.length == 0) {
                    var _nR = $$('li', { 'class': 'noReply' }, _rL);
                    _nR.innerHTML = '还没有人回复.&nbsp;&nbsp;&nbsp;';
                    var _eAR = $$('span', { 'class': 'addReply', 'innerHTML': '添加回复' }, _nR);
                    _eAR.onclick = function () {
                        var R = ({ target: '本文' });
                        Cb.Bs.ALR(R);
                    }
                }
                else {
                    for (var i = 0; i < r.value.length; i++) {
                        var _rI = $$('li', { 'class': 'replyItem' }, _rL);
                        _rI.RID = r.value[i].ReplyID;
                        _rI.RUN = r.value[i].UserNickName;
                        var _rM = $$('div', { 'class': 'replierMain' }, _rI);
                        var _rUH = $$('div', { 'class': 'userHead' }, _rM);
                        var src;
                        r.value[i].UserThumbnailImageHead.match('q.qlogo.cn') != null ? src = r.value[i].UserThumbnailImageHead : src = US.fs + r.value[i].UserThumbnailImageHead;
                        $$('img', { 'src': src }, _rUH);
                        var _rUI = $$('div', { 'class': 'userInfo' }, _rM);
                        var _rUN = $$('span', { 'class': 'userName', 'innerHTML': r.value[i].UserNickName }, _rUI);
                        var _rD = $$('span', { 'class': 'sendDate' }, _rUI);
                        var T;
                        if (r.value[i].ParentUserNickName != null) {
                            _rD.innerHTML = '回复&nbsp;<span class="userName">' + r.value[i].ParentUserNickName + '</span>&nbsp;发表于&nbsp;&nbsp;' + U.MT.GetDT(r.value[i].ReplyAddTime);
                            T = r.value[i].ParentUserNickName;
                        }
                        else {
                            _rD.innerHTML = '回复&nbsp;本文&nbsp;发表于&nbsp;&nbsp;' + U.MT.GetDT(r.value[i].ReplyAddTime);
                            T = '本文';
                        }
                        _rI.R = ({ name: r.value[i].UserNickName, target: r.value[i].UserNickName, reply: '&nbsp;&nbsp;回复&nbsp;&nbsp;<span class="targetName">' + T + '</span>', content: r.value[i].ReplyContent, date: U.MT.GetDT(r.value[i].ReplyAddTime), replyID: r.value[i].ReplyID, targetID: r.value[i].ReplyAddUserID });
                        var _rID = $$('div', { 'class': 'replyID', 'innerHTML': r.value[i].ReplyID }, _rUI);
                        var _rC = $$('div', { 'class': 'replyContainer' }, _rI);
                        var _r = $$('div', { 'class': 'replyContent', 'innerHTML': r.value[i].ReplyContent }, _rC);
                        var $CB = $$('div', { 'class': 'replyControl' }, _rC);
                        var $R = $$('span', { 'class': 'replyButton', 'title': '回复' }, $CB);
                        $R.onclick = function () {
                            var R = this.parentNode.parentNode.parentNode;
                            Cb.Bs.ALR(R.R);
                        }
                        var $D = $$('span', { 'class': 'deleteButton', 'title': '删除' }, $CB);
                        $D.onclick = function () {
                            var R = this.parentNode.parentNode.parentNode;
                            var C = R.parentNode.parentNode.previousElementSibling;
                            Cb.Bs.Confirm("你确定要删除 " + R.RUN + " 的回复吗?", function (Re) {
                                if (Re) {
                                    Cb.Bs.DLR(R.RID, function (result) {
                                        if (result.value != 1) {
                                            Cb.Bs.Alert('删除失败! 发生未知错误请联系管理员解决!');
                                        }
                                        else {
                                            Cb.Bs.Alert('删除成功!');
                                            var DoN = 0;
                                            $(R).fadeIn(1000, function () {
                                                DoN++;
                                                if (DoN == 1) {
                                                    R.remove();
                                                    var L = C.RL - 1;
                                                    if (C.RL == 1) {
                                                        var nR = $$('li', { 'class': 'noReply' }, _rL);
                                                        nR.innerHTML = '还没有人回复.&nbsp;&nbsp;&nbsp;';
                                                        var eAR = $$('span', { 'class': 'addReply', 'innerHTML': '添加回复' }, nR);
                                                        eAR.onclick = function () {
                                                            var R = ({ target: '本文' });
                                                            Cb.Bs.ALR(R);
                                                        }
                                                    }
                                                    C.innerHTML = C.innerHTML.replace(C.RL, L);
                                                    C.RL = L;
                                                    C.child('.addReply')[0].onclick = function () {
                                                        Cb.Bs.ALR(({ target: '本文' }));
                                                    }
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                        }
                    }
                }
            });
        });
    }
}

//  修改文章.
Cb.Bs.EPL = function (id, title, content, callback) {
    U.D.SY.PAPMHTJ(id, title, content, function (a) {
        callback(a);
    });
}

//  删除文章.
Cb.Bs.DPL = function (id, callback) {
    U.D.SY.SCPGBL(id, function (a) {
        callback(a);
    });
}

//  添加回复窗口.
Cb.Bs.ALR = function () {
    var rT = arguments[0];
    if (rT != '' && rT != null && rT != undefined) {
        $$('div', { 'class': 'mask' }, document.body);
        $$('div', { 'id': 'replyDiv' }, $('.mask')[0]);
        $$('div', { 'class': 'replyDivHeader', 'innerHTML': '添加回复' }, $('#replyDiv')[0]);
        var C = $$('span', { 'class': 'close', 'innerHTML': '×' }, $('.replyDivHeader')[0]);
        C.onclick = function () {
            $('#replyDiv').fadeIn(500, function () {
                $('.mask')[0].remove();
            });
        }
        var _rDC = $$('div', { 'class': 'replyDivContainer' }, $('#replyDiv')[0]);
        var _rT = $$('div', { 'class': 'replyTarget' }, _rDC);
        var _rTH = $$('div', { 'class': 'replyTargetHeader', 'innerHTML': '回复对象' }, _rT);
        if (rT.target != '本文') {
            var _rM = $$('div', { 'class': 'replyMain' }, _rT);
            var _uI = $$('div', { 'class': 'userInfo' }, _rM);
            $$('span', { 'class': 'userName', 'innerHTML': rT.name }, _uI);
            _uI.innerHTML += rT.reply;
            var _rD = $$('span', { 'class': 'replyDate', 'innerHTML': rT.date }, _uI);
            $$('div', { 'class': 'replyContent', 'innerHTML': rT.content }, _rM);
        }
        else {
            var _rM = $$('div', { 'class': 'replyArticle', 'innerHTML': '本文' }, _rT);
            $('#replyDiv')[0].addClass('replyArticle');
        }
        var _rC = $$('div', { 'class': 'replyContainer' }, _rDC);
        var _rH = $$('div', { 'class': 'replyHeader', 'innerHTML': '回复内容' }, _rC);
        var $rC = $$('div', { 'class': 'replyContent', 'contenteditable': 'true' }, _rC);
        var _rA = $$('div', { 'class': 'replyAction' }, _rDC);
        var $D = $$('input', { 'type': 'button', 'class': 'done', 'value': '完成回复' }, _rA);
        $D.onclick = function () {
            Cb.AddLogReply(Cb.Bs.NAID, $rC.innerHTML, function (RID) {
                console.log(RID);
                var $RC = $rC.innerHTML;
                Cb.Bs.Alert('回复成功!');
                $('#replyDiv').fadeIn(500, function () {
                    $('.mask')[0].remove();
                    if ($('.noReply')[0]) {
                        $('.noReply')[0].remove();
                    }
                    //$('.replyHeader')[0].innerHTML = $('.replyHeader')[0].innerHTML.replace($('.replyHeader')[0].RL, $('.replyHeader')[0].RL + 1);
                    //$('.replyHeader')[0].RL = $('.replyHeader')[0].RL + 1;
                    //$('.replyHeader')[0].child('.addReply')[0].onclick = function () {
                    //    Cb.Bs.ALR(({ target: '本文' }));
                    //}
                    //var _rI = $$('li', { 'class': 'replyItem' });
                    //$('.replyList')[0].insertBefore(_rI, $('.replyList')[0].child()[0])
                    //_rI.RID = RID;
                    //_rI.RUN = US.userinfo.UserNickName;
                    //var _rM = $$('div', { 'class': 'replierMain' }, _rI);
                    //var _rUH = $$('div', { 'class': 'userHead' }, _rM);
                    //$$('img', { 'src': US.fs + US.userinfo.UserThumbnailImageHead }, _rUH);
                    //var _rUI = $$('div', { 'class': 'userInfo' }, _rM);
                    //var _rUN = $$('span', { 'class': 'userName', 'innerHTML': US.userinfo.UserNickName }, _rUI);
                    //var _rD = $$('span', { 'class': 'sendDate' }, _rUI);
                    //var T;
                    ////if (asdf != null) {
                    ////    _rD.innerHTML = '回复&nbsp;<span class="userName">' + /*asdf*/ + '</span>&nbsp;发表于&nbsp;&nbsp;' + U.MT.GetDT(U.MT.SetDT());
                    ////    T = asdf;
                    ////}
                    ////else {
                    //_rD.innerHTML = '回复&nbsp;本文&nbsp;发表于&nbsp;&nbsp;' + U.MT.GetDT(U.MT.SetDT());
                    //T = '本文';
                    ////}
                    //_rI.R = ({ name: US.userinfo.UserNickName, target: US.userinfo.UserNickName, reply: '&nbsp;&nbsp;回复&nbsp;&nbsp;<span class="targetName">' + T + '</span>', content: $RC, date: U.MT.GetDT(U.MT.SetDT()), replyID: RID, targetID: US.userinfo.UserId });
                    //var _rID = $$('div', { 'class': 'replyID', 'innerHTML': RID }, _rUI);
                    //var _rC = $$('div', { 'class': 'replyContainer' }, _rI);
                    //var _r = $$('div', { 'class': 'replyContent', 'innerHTML': $RC }, _rC);
                    //var $CB = $$('div', { 'class': 'replyControl' }, _rC);
                    //var $R = $$('span', { 'class': 'replyButton', 'title': '回复' }, $CB);
                    //$R.onclick = function () {
                    //    var R = this.parentNode.parentNode.parentNode;
                    //    Cb.Bs.ALR(R.R);
                    //}
                    //var $D = $$('span', { 'class': 'deleteButton', 'title': '删除' }, $CB);
                    //$D.onclick = function () {
                    //    var R = this.parentNode.parentNode.parentNode;
                    //    var C = R.parentNode.parentNode.previousElementSibling;
                    //    if (confirm("你确定要删除 " + R.RUN + " 的回复吗?")) {
                    //        Cb.Bs.DLR(R.RID, function (result) {
                    //            if (result.value != 1) {
                    //                alert('删除失败! 发生未知错误请联系管理员解决!');
                    //            }
                    //            else {
                    //                alert('删除成功!');
                    //                var DoN = 0;
                    //                $(R).fadeIn(1000, function () {
                    //                    DoN++;
                    //                    if (DoN == 1) {
                    //                        R.remove();
                    //                        var L = C.RL - 1;
                    //                        if (C.RL == 1) {
                    //                            var nR = $$('li', { 'class': 'noReply' }, _rL);
                    //                            nR.innerHTML = '还没有人回复.&nbsp;&nbsp;&nbsp;';
                    //                            var eAR = $$('span', { 'class': 'addReply', 'innerHTML': '添加回复' }, nR);
                    //                            eAR.onclick = function () {
                    //                                var R = ({ target: '本文' });
                    //                                Cb.Bs.ALR(R);
                    //                            }
                    //                        }
                    //                        C.innerHTML = C.innerHTML.replace(C.RL, L);
                    //                        C.RL = L;
                    //                        C.child('.addReply')[0].onclick = function () {
                    //                            Cb.Bs.ALR(({ target: '本文' }));
                    //                        }
                    //                    }
                    //                });
                    //            }
                    //        });
                    //    }
                    //}
                });
            });
        }
    }
}

//  删除回复.
Cb.Bs.DLR = function (id, callback) {
    U.D.SY.SCPHFRGBL(id, "", function (a) { callback(a); });
}

//  刷出赛事列表.
Cb.Bs.CM = function (r) {
    var _mL = $$('ul', { 'class': 'matchList' }, $('.matchBody')[0]);
    for (var i = 0; i < r.value.length; i++) {
        var _mI = $$('li', { 'class': 'matchItem' }, _mL);
        _mI.MID = r.value[i].id;
        $$('span', { 'class': 'name', 'innerHTML': r.value[i].name }, _mI);
        $$('span', { 'class': 'name', 'innerHTML': r.value[i].MatchTime }, _mI);
        $$('span', { 'class': 'name', 'innerHTML': r.value[i].deadline }, _mI);
        $$('span', { 'class': 'name', 'innerHTML': r.value[i].sponsor }, _mI);
        $$('span', { 'class': 'name', 'innerHTML': r.value[i].SumbitTime }, _mI);
        var bB = $$('span', { 'class': 'button' }, _mI);
        var B = $$('input', { 'type': 'button' }, bB);
        B.state = r.value[i].struts;
        switch (B.state) {
            case 'true':
                B.className = 'pButton';
                B.value = '已通过';
                break;
            case 'false':
                B.className = 'upButton';
                B.value = '未通过';
                break;
            case 'dead':
                B.className = 'dButton';
                B.value = '已过期';
                break;
        }
        B.onclick = function () {
            var that = this;
            if (this.state != 'dead') {
                if (this.state == 'true') {
                    U.CB.Request("sql", ["ExamineMatch", 'struts', 'false', this.parentNode.parentNode.MID], function (e) {
                        that.value = '未通过';
                        that.state = 'false';
                        that.className = 'upButton';
                    });
                }
                if (this.state == 'false') {
                    U.CB.Request("sql", ["ExamineMatch", 'struts', 'true', this.parentNode.parentNode.MID], function (e) {
                        that.value = '已通过';
                        that.state = 'true';
                        that.className = 'pButton';
                    });
                }
            }
        }
        var _mID = $$('div', { 'class': 'matchID', 'innerHTML': r.value[i].id, 'tabindex': 0 }, _mI);
    }
}

//  刷出用户列表.
Cb.Bs.CUL = function (r) {
    var _uL = $$('ul', { 'class': 'userList' }, $('.listContainer')[0]);
    var UQX = function (E, L, R, I) {
        U.CB.Request("sql", ["UpdateQX", L, R, I], function (e) { });
        E.checked = R;
    }
    for (var i = 0; i < r.value.length; i++) {
        var _uI = $$('li', { 'class': 'userItem' }, _uL);
        _uI.UID = r.value[i].id;
        var _uH = $$('span', { 'class': 'userHead' }, _uI);
        var src;
        r.value[i].userhead.match('q.qlogo.cn') != null ? src = r.value[i].userhead : src = US.fs + r.value[i].userhead;
        $$('img', { 'src': decodeURIComponent(src) }, _uH);
        $$('span', { 'class': 'name', 'innerHTML': r.value[i].username }, _uI);
        $$('span', { 'class': 'name', 'innerHTML': r.value[i].nickname }, _uI);
        var J = $$('span', { 'class': 'checkbox' }, _uI);
        var _J = $$('input', { 'type': 'checkbox' }, J);
        r.value[i].jrqx != 'true' ? _J.checked = false : _J.checked = true;
        _J.onclick = function () {
            var U = this.parentNode.parentNode;
            this.checked != true ? UQX(this, 'jrqx', false, U.UID) : UQX(this, 'jrqx', true, U.UID);
        }
        var X = $$('span', { 'class': 'checkbox' }, _uI);
        var _X = $$('input', { 'type': 'checkbox' }, X);
        r.value[i].xxgl != 'true' ? _X.checked = false : _X.checked = true;
        _X.onclick = function () {
            var U = this.parentNode.parentNode;
            this.checked != true ? UQX(this, 'xxgl', false, U.UID) : UQX(this, 'xxgl', true, U.UID);
        }
        var S = $$('span', { 'class': 'checkbox' }, _uI);
        var _S = $$('input', { 'type': 'checkbox' }, S);
        r.value[i].sssz != 'true' ? _S.checked = false : _S.checked = true;
        _S.onclick = function () {
            var U = this.parentNode.parentNode;
            this.checked != true ? UQX(this, 'sssz', false, U.UID) : UQX(this, 'sssz', true, U.UID);
        }
        var C = $$('span', { 'class': 'checkbox' }, _uI);
        var _C = $$('input', { 'type': 'checkbox' }, C);
        r.value[i].cjgl != 'true' ? _C.checked = false : _C.checked = true;
        _C.onclick = function () {
            var U = this.parentNode.parentNode;
            this.checked != true ? UQX(this, 'cjgl', false, U.UID) : UQX(this, 'cjgl', true, U.UID);
        }
        var Q = $$('span', { 'class': 'checkbox' }, _uI);
        var _Q = $$('input', { 'type': 'checkbox' }, Q);
        r.value[i].qxsz != 'true' ? _Q.checked = false : _Q.checked = true;
        _Q.onclick = function () {
            var U = this.parentNode.parentNode;
            this.checked != true ? UQX(this, 'qxsz', false, U.UID) : UQX(this, 'qxsz', true, U.UID);
        }
        var B = $$('span', { 'class': 'checkbox' }, _uI);
        var _B = $$('input', { 'type': 'checkbox' }, B);
        r.value[i].bmsz != 'true' ? _B.checked = false : _B.checked = true;
        _B.onclick = function () {
            var U = this.parentNode.parentNode;
            this.checked != true ? UQX(this, 'bmsz', false, U.UID) : UQX(this, 'bmsz', true, U.UID);
        }
        var _uID = $$('div', { 'class': 'userID', 'innerHTML': r.value[i].id, 'tabindex': 0, "title": "用户id" }, _uI);
    }
}

//  初始定义对话框不存在.
Cb.Bs.DA = 0;

document.onkeydown = function () {
    if (Cb.Bs.DA == 1) {
        if (event.keyCode == 123) {
            return false;
        }
    }
}

//  弹出攀岩后台专有alert框.
Cb.Bs.Alert = function ($C) {
    if (!$('.mask .confirm-container')[0] && !$('.mask .alert-container')[0] && !$('.mask .prompt-container')[0]) {
        Cb.Bs.DA = 1;
        var _M = $$('div', { 'class': 'mask' }, document.body);
        var _aC = $$('div', { 'class': 'alert-container' }, _M);
        var _aS = $$('div', { 'class': 'alert-section' }, _aC);
        var $aC = $$('div', { 'class': 'alert-content', 'innerHTML': $C }, _aS);
        var _aA = $$('div', { 'class': 'alert-action' }, _aS);
        var _S = $$('span', { 'class': 'sure', 'innerHTML': '确定' }, _aA);
        _S.onclick = function () {
            _M.remove();
            Cb.Bs.DA = 0;
        }
    }
}

//  弹出攀岩后台专有confirm框.
Cb.Bs.Confirm = function ($C, callback) {
    if (!$('.mask .confirm-container')[0] && !$('.mask .alert-container')[0] && !$('.mask .prompt-container')[0]) {
        Cb.Bs.DA = 1;
        var _M = $$('div', { 'class': 'mask' }, document.body);
        var _cC = $$('div', { 'class': 'confirm-container' }, _M);
        var _cS = $$('div', { 'class': 'confirm-section' }, _cC);
        var $cC = $$('div', { 'class': 'confirm-content', 'innerHTML': $C }, _cS);
        var _cA = $$('div', { 'class': 'confirm-action' }, _cS);
        var _S = $$('span', { 'class': 'sure', 'innerHTML': '确定' }, _cA);
        _S.onclick = function () {
            _M.remove();
            Cb.Bs.DA = 0;
            if (callback != '' && callback != null && callback != undefined && typeof callback == 'function') {
                callback(true);
            }
        }
        var _C = $$('span', { 'class': 'cancel', 'innerHTML': '取消' }, _cA);
        _C.onclick = function () {
            _M.remove();
            Cb.Bs.DA = 0;
            if (callback != '' && callback != null && callback != undefined && typeof callback == 'function') {
                callback(false);
            }
        }
    }
}

//  弹出攀岩后台专有prompt框.
Cb.Bs.Prompt = function ($C, callback) {
    if (!$('.mask .confirm-container')[0] && !$('.mask .alert-container')[0] && !$('.mask .prompt-container')[0]) {
        Cb.Bs.DA = 1;
        var _M = $$('div', { 'class': 'mask' }, document.body);
        var _pC = $$('div', { 'class': 'prompt-container' }, _M);
        var _pS = $$('div', { 'class': 'prompt-section' }, _pC);
        var $pC = $$('div', { 'class': 'prompt-content' }, _pS);
        var _pT = $$('div', { 'class': 'prompt-title', 'innerHTML': $C }, $pC);
        var C = $$('input', { 'type': 'text' }, $pC);
        var _pA = $$('div', { 'class': 'prompt-action' }, _pS);
        var _S = $$('span', { 'class': 'sure', 'innerHTML': '确定' }, _pA);
        _S.onclick = function () {
            var R = C.value;
            _M.remove();
            Cb.Bs.DA = 0;
            if (callback != '' && callback != null && callback != undefined && typeof callback == 'function') {
                callback(R);
            }
        }
        var _C = $$('span', { 'class': 'cancel', 'innerHTML': '取消' }, _pA);
        _C.onclick = function () {
            _M.remove();
            Cb.Bs.DA = 0;
            if (callback != '' && callback != null && callback != undefined && typeof callback == 'function') {
                callback(null);
            }
        }
    }
}