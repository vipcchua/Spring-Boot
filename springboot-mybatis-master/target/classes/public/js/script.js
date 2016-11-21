(function (root, factory) {
    root.Mb = factory();
})(this, function () {
    var Mb = {};
    Mb.position = 'home';  // 初始化定义位置.
    Mb.url = 'http://10.3.13.212:8080/';
    Mb.cP = function (p) {
        Mb.position = p;
        Mb.gDBP(Mb.position);
    };
    Mb.gDBP = function (p) {
        switch (p) {
            case 'add': gotoAdd(); break;
            case 'view': gotoView(); break;
            default: console.log('default'); break;
        };
    };
    function gotoAdd() {
        var aS = _m('.add-support');
        if (!aS) {
            _M(_m('.support-container')).empty();
            aS = _Create('div', { 'class': 'add-support' }, _m('.support-container'));
        };
        _M(aS).empty();
        var fC = _Create('div', { 'class': 'form-container' }, aS);
        var pG = _Create('ul', { 'class': 'progress', 'innerHTML': '<li class="item-1 active">建立模具档案</li><li class="item-2">上传注塑参数表</li><li class="item-3">产品材料信息</li><li class="item-4">作业指导书</li><li class="item-5">模具维保记录</li>' }, fC);
        createForm();

        function createForm() {
            var F = _M(fC).child('#mould-form.form');
            if (!F) {
                F = _Create('div', { 'id': 'mould-form', 'class': 'form' }, fC);
            } else {
                F.style.cssText = '';
                return;
            };
            _Create('div', { 'class': 'col-1', 'style': 'font-size: 16px; text-align: center; padding: 15px 0;', 'innerHTML': '建立模具档案' }, F);
            var iU = _Create('div', { 'class': 'col-1 img-upload' }, F);
            var uC = _Create('div', { 'class': 'upload-container' }, iU);
            var uD = _Create('div', { 'class': 'upload-drop', 'style': 'text-align: center;', 'innerHTML': '<div style="padding-top: 20px; padding-bottom: 5px;">拖拽Pdf文件或图片到这里</div><span class="icon"></span>' }, uC);
            var imgFileList = [];
            uD.addEventListener('dragover', function (e) { e.preventDefault(); });
            uD.addEventListener('drop', function (e) {
                e.preventDefault();
                var F = e.dataTransfer.files;
                for (var i = 0; i < F.length; i++) {
                    if (F[i].type.match('application/pdf') == null && F[i].type.match('image') == null) {
                        Dialog.Alert('你选择的文件类型不是Pdf文件或者图片! 请重新选择!');
                        return;
                    };
                    if (!imgFileList.length) {
                        _M(uD).removeStyle('text-align').empty();
                    };
                    if (F[i].type.match('application/pdf') != null) {
                        var fP = _Create('div', { 'class': 'file-preview', 'title': '查看文件' }, uD);
                        fP.onclick = function () {
                            pdfView(this);
                        };
                        var fI = _Create('div', { 'class': 'file-pdf' }, fP);
                        var R = new FileReader();
                        R.readAsDataURL(F[i]);
                        R.onload = function (s) {
                            fP.src = this.result;
                        };
                        var fn = _Create('div', { 'class': 'file-name', 'innerText': F[i].name }, fP);
                    } else if (F[i].type.match('image') != null) {
                        var fP = _Create('div', { 'class': 'file-preview', 'title': '查看图片' }, uD);
                        fP.onclick = function () {
                            imgView(_M(this).child('img'));
                        };
                        var fI = _Create('div', { 'class': 'file-img' }, fP);
                        var R = new FileReader();
                        R.readAsDataURL(F[i]);
                        R.onload = function (s) {
                            _Create('img', { 'src': this.result }, fI);
                        };
                        var fn = _Create('div', { 'class': 'file-name', 'innerText': F[i].name }, fP);
                    };
                    imgFileList.push(F[i]);
                };
            });
            var uW = _Create('div', { 'class': 'upload-wrap', 'innerHTML': '<input type="file" class="upload" multiple="multiple" accept="application/pdf, image/*" value="上传文件"><span class="icon"></span>本地上传文件' }, uC);
            _M(uW).child('input[type=file]').onchange = function () {
                var filelist = this.files;
                for (var i = 0; i < filelist.length; i++) {
                    if (filelist[i].type.match('application/pdf') == null && filelist[i].type.match('image') == null) {
                        Dialog.Alert('你选择的文件类型不是Pdf文件或者图片! 请重新选择!');
                        return;
                    };
                    if (!imgFileList.length) {
                        _M(uD).removeStyle('text-align').empty();
                    };
                    if (filelist[i].type.match('application/pdf') != null) {
                        var fP = _Create('div', { 'class': 'file-preview', 'title': '查看文件' }, uD);
                        fP.onclick = function () {
                            pdfView(this);
                        };
                        var fI = _Create('div', { 'class': 'file-pdf' }, fP);
                        var R = new FileReader();
                        R.readAsDataURL(filelist[i]);
                        R.onload = function (s) {
                            fP.src = this.result;
                        };
                        var fn = _Create('div', { 'class': 'file-name', 'innerText': filelist[i].name }, fP);
                    } else if (filelist[i].type.match('image') != null) {
                        var fP = _Create('div', { 'class': 'file-preview', 'title': '查看图片' }, uD);
                        fP.onclick = function () {
                            imgView(_M(this).child('img'));
                        };
                        var fI = _Create('div', { 'class': 'file-img' }, fP);
                        var R = new FileReader();
                        R.readAsDataURL(filelist[i]);
                        R.onload = function (s) {
                            _Create('img', { 'src': this.result }, fI);
                        };
                        var fn = _Create('div', { 'class': 'file-name', 'innerText': filelist[i].name }, fP);
                    };
                    imgFileList.push(filelist[i]);
                };
            };
            var formData = {
                mouldNumber: '模具编号',
                RFID: '电子标签NO',
                productName: '产品名称',
                customerName: '客户名称',
                cavityNumber: '模腔数',
                mouldLife: '模具寿命',
                applicableModels: '适用机型',
                useRequirements: '使用要求',
                status: '状态',
                remarks: '备注'
            };
            for (var item in formData) {
                if (item != 'remarks') {
                    var td = _Create('div', { 'class': 'col-3' }, F);
                    _Create('label', { 'innerHTML': formData[item] + '<input type="text" id="' + item + '" name="' + item + '" placeholder="' + formData[item] + '" />' }, td);
                } else {
                    var td = _Create('div', { 'class': 'col-1' }, F);
                    _Create('label', { 'innerHTML': formData[item] + '<textarea type="text" id="' + item + '" name="' + item + '" placeholder="' + formData[item] + '" spellcheck="false"></textarea>' }, td);
                };
            };
            var fS = _Create('div', { 'class': 'col-1 form-support', 'style': 'text-align: center; padding: 15px 0;' }, F);
            var submit = _Create('input', { 'type': 'button', 'class': 'submit', 'value': '我已确认, 下一步' }, fS);
            submit.onclick = function () {
                //if (!imgFileList.length) {
                //    Dialog.Alert('请添加图片!');
                //    return;
                //};
                //for (var item in formData) {
                //    if (_m('#' + item).value == '' || _m('#' + item).value == null || _m('#' + item).value == undefined) {
                //        Dialog.Alert(formData[item] + ' 的项为空, 请重新填写!');
                //        return;
                //    };
                //};
                //var imgList;
                //new Promise(function (resolve, reject) {
                //    _Ajax({
                //        url: Mb.url + 'uploads',
                //        method: 'post',
                //        postType: 'file',
                //        data: imgFileList,
                //        success: function (r) {
                //            imgList = JSON.parse(r);
                //            resolve();
                //        },
                //        fail: function (error) {
                //            Dialog.Alert('上传图片失败! 请重试!');
                //            return;
                //        }
                //    });
                //}).then(function () {
                //    _Ajax({
                //        url: Mb.url + 'insertmodelinfo',
                //        method: 'post',
                //        postType: 'json',
                //        data: [{
                //            'mouldNumber': _m('#mouldNumber').value,
                //            'RFID': _m('#RFID').value,
                //            'productName': _m('#productName').value,
                //            'customerName': _m('#customerName').value,
                //            'cavityNumber': _m('#cavityNumber').value,
                //            'applicableModels': _m('#applicableModels').value,
                //            'useRequirements': _m('#useRequirements').value,
                //            'mouldLife': _m('#mouldLife').value,
                //            'status': _m('#status').value,
                //            'remarks': _m('#remarks').value,
                //            'photo': JSON.stringify(imgList),
                //        }],
                //        success: function (r) {
                //            Dialog.Alert('新增成功!');
                //            gotoAdd();
                //        },
                //        fail: function (error) {
                //            Dialog.Alert('新增失败! 请重试!');
                //            console.error('error!');
                //        }
                //    });
                //});
                F.style.cssText = 'display: none; opacity: 0; visibility: hidden;';
                uploadForm();
            };
        };

        function uploadForm() {
            !_M(_m('ul.progress .item-2')).hasClass('active') ? _M(_m('ul.progress .item-2')).addClass('active') : {};
            var U = _M(fC).child('#upload-form.form');
            if (!U) {
                U = _Create('div', { 'id': 'upload-form', 'class': 'form' }, fC);
            } else {
                U.style.cssText = '';
                return;
            };
            _Create('div', { 'class': 'col-1', 'style': 'font-size: 16px; text-align: center; padding: 15px 0;', 'innerHTML': '上传注塑参数表' }, U);
            var iU = _Create('div', { 'class': 'col-1 file-upload' }, U);
            var uC = _Create('div', { 'class': 'upload-container' }, iU);
            var uD = _Create('div', { 'class': 'upload-drop', 'style': 'text-align: center;', 'innerHTML': '<div style="padding-top: 200px; padding-bottom: 5px;">拖拽Word文件或图片到这里</div><span class="icon"></span>' }, uC);
            var FileList = [];
            uD.addEventListener('dragover', function (e) { e.preventDefault(); });
            uD.addEventListener('drop', function (e) {
                e.preventDefault();
                var F = e.dataTransfer.files;
                for (var i = 0; i < F.length; i++) {
                    if (F[i].type.match('application/msword') == null && F[i].type.match('application/vnd.openxmlformats-officedocument.wordprocessingml.document') == null && F[i].type.match('image') == null) {
                        Dialog.Alert('你选择的文件类型不是Word文件或者图片! 请重新选择!');
                        return;
                    };
                    if (!FileList.length) {
                        _M(uD).removeStyle('text-align').empty();
                    };
                    if (F[i].type.match('application/msword') != null || F[i].type.match('application/vnd.openxmlformats-officedocument.wordprocessingml.document') != null) {
                        var fP = _Create('div', { 'class': 'file-preview', 'title': '查看文件' }, uD);
                        var fI = _Create('div', { 'class': 'file-word' }, fP);
                        var fn = _Create('div', { 'class': 'file-name', 'innerText': F[i].name }, fP);
                    } else if (F[i].type.match('image') != null) {
                        var fP = _Create('div', { 'class': 'file-preview', 'title': '查看图片' }, uD);
                        fP.onclick = function () {
                            imgView(_M(this).child('img'));
                        };
                        var fI = _Create('div', { 'class': 'file-img' }, fP);
                        var R = new FileReader();
                        R.readAsDataURL(F[i]);
                        R.onload = function (s) {
                            _Create('img', { 'src': this.result }, fI);
                        };
                        var fn = _Create('div', { 'class': 'file-name', 'innerText': F[i].name }, fP);
                    };
                    FileList.push(F[i]);
                };
            });
            var uW = _Create('div', { 'class': 'upload-wrap', 'innerHTML': '<input type="file" class="upload" multiple="multiple" accept="application/msword, application/vnd.openxmlformats-officedocument.wordprocessingml.document, image/*" value="上传图片"><span class="icon"></span>本地上传文件' }, uC);
            _M(uW).child('input[type=file]').onchange = function () {
                var filelist = this.files;
                for (var i = 0; i < filelist.length; i++) {
                    if (filelist[i].type.match('application/msword') == null && filelist[i].type.match('application/vnd.openxmlformats-officedocument.wordprocessingml.document') == null && filelist[i].type.match('image') == null) {
                        Dialog.Alert('你选择的文件类型不是Word文件或者图片! 请重新选择!');
                        return;
                    };
                    if (!FileList.length) {
                        _M(uD).removeStyle('text-align').empty();
                    };
                    if (filelist[i].type.match('application/msword') != null || filelist[i].type.match('application/vnd.openxmlformats-officedocument.wordprocessingml.document') != null) {
                        var fP = _Create('div', { 'class': 'file-preview', 'title': '查看文件' }, uD);
                        var fI = _Create('div', { 'class': 'file-word' }, fP);
                        var fn = _Create('div', { 'class': 'file-name', 'innerText': filelist[i].name }, fP);
                    } else if (filelist[i].type.match('image') != null) {
                        var fP = _Create('div', { 'class': 'file-preview', 'title': '查看图片' }, uD);
                        fP.onclick = function () {
                            imgView(_M(this).child('img'));
                        };
                        var fI = _Create('div', { 'class': 'file-img' }, fP);
                        var R = new FileReader();
                        R.readAsDataURL(filelist[i]);
                        R.onload = function (s) {
                            _Create('img', { 'src': this.result }, fI);
                        };
                        var fn = _Create('div', { 'class': 'file-name', 'innerText': filelist[i].name }, fP);
                    };
                    FileList.push(filelist[i]);
                };
            };
            var fS = _Create('div', { 'class': 'col-1 form-support', 'style': 'text-align: center; padding: 15px 0;' }, U);
            var prev = _Create('input', { 'type': 'button', 'class': 'back-prev', 'value': '返回上一步' }, fS);
            prev.onclick = function () {
                !_M(_m('ul.progress .item-2')).hasClass('active') ? {} : _M(_m('ul.progress .item-2')).removeClass('active');
                U.style.cssText = 'display: none; opacity: 0; visibility: hidden;';
                createForm();
            };
            var submit = _Create('input', { 'type': 'button', 'class': 'submit', 'value': '我已确认, 下一步' }, fS);
            submit.onclick = function () {
                U.style.cssText = 'display: none; opacity: 0; visibility: hidden;';
                materialForm();
            };
        };

        function materialForm() {
            !_M(_m('ul.progress .item-3')).hasClass('active') ? _M(_m('ul.progress .item-3')).addClass('active') : {};
            var M = _M(fC).child('#material-form.form');
            if (!M) {
                M = _Create('div', { 'id': 'material-form', 'class': 'form' }, fC);
            } else {
                M.style.cssText = '';
                return;
            };
            _Create('div', { 'class': 'col-1', 'style': 'font-size: 16px; text-align: center; padding: 15px 0;', 'innerHTML': '上传产品材料信息表' }, M);
            var iU = _Create('div', { 'class': 'col-1 file-upload' }, M);
            var uC = _Create('div', { 'class': 'upload-container' }, iU);
            var uD = _Create('div', { 'class': 'upload-drop', 'style': 'text-align: center;', 'innerHTML': '<div style="padding-top: 200px; padding-bottom: 5px;">拖拽Pdf文件或Word文件到这里</div><span class="icon"></span>' }, uC);
            var FileList = [];
            uD.addEventListener('dragover', function (e) { e.preventDefault(); });
            uD.addEventListener('drop', function (e) {
                e.preventDefault();
                var F = e.dataTransfer.files;
                for (var i = 0; i < F.length; i++) {
                    if (F[i].type.match('application/pdf') == null && F[i].type.match('application/msword') == null && F[i].type.match('application/vnd.openxmlformats-officedocument.wordprocessingml.document') == null) {
                        Dialog.Alert('你选择的文件类型不是Pdf文件或者Word文件! 请重新选择!');
                        return;
                    };
                    if (!FileList.length) {
                        _M(uD).removeStyle('text-align').empty();
                    };
                    if (F[i].type.match('application/pdf') != null) {
                        var fP = _Create('div', { 'class': 'file-preview', 'title': '查看文件' }, uD);
                        fP.onclick = function () {
                            pdfView(this);
                        };
                        var fI = _Create('div', { 'class': 'file-pdf' }, fP);
                        var R = new FileReader();
                        R.readAsDataURL(F[i]);
                        R.onload = function (s) {
                            fP.src = this.result;
                        };
                    } else if (F[i].type.match('application/msword') != null || F[i].type.match('application/vnd.openxmlformats-officedocument.wordprocessingml.document') != null) {
                        var fP = _Create('div', { 'class': 'file-preview', 'title': '查看文件' }, uD);
                        var fI = _Create('div', { 'class': 'file-word' }, fP);
                    };
                    var fn = _Create('div', { 'class': 'file-name', 'innerText': F[i].name }, fP);
                    FileList.push(F[i]);
                };
            });
            var uW = _Create('div', { 'class': 'upload-wrap', 'innerHTML': '<input type="file" class="upload" multiple="multiple" accept="application/msword, application/vnd.openxmlformats-officedocument.wordprocessingml.document" value="上传文件"><span class="icon"></span>本地上传文件' }, uC);
            _M(uW).child('input[type=file]').onchange = function () {
                var filelist = this.files;
                for (var i = 0; i < filelist.length; i++) {
                    if (filelist[i].type.match('application/pdf') == null && filelist[i].type.match('application/msword') == null && filelist[i].type.match('application/vnd.openxmlformats-officedocument.wordprocessingml.document') == null) {
                        Dialog.Alert('你选择的文件类型不是Pdf文件或者Word文件! 请重新选择!');
                        return;
                    };
                    if (!FileList.length) {
                        _M(uD).removeStyle('text-align').empty();
                    };
                    if (filelist[i].type.match('application/pdf') != null) {
                        var fP = _Create('div', { 'class': 'file-preview', 'title': '查看文件' }, uD);
                        fP.onclick = function () {
                            pdfView(this);
                        };
                        var fI = _Create('div', { 'class': 'file-pdf' }, fP);
                        var R = new FileReader();
                        R.readAsDataURL(filelist[i]);
                        R.onload = function (s) {
                            fP.src = this.result;
                        };
                    } else if (filelist[i].type.match('application/msword') != null || filelist[i].type.match('application/vnd.openxmlformats-officedocument.wordprocessingml.document') != null) {
                        var fP = _Create('div', { 'class': 'file-preview', 'title': '查看文件' }, uD);
                        var fI = _Create('div', { 'class': 'file-word' }, fP);
                    };
                    var fn = _Create('div', { 'class': 'file-name', 'innerText': filelist[i].name }, fP);
                    FileList.push(filelist[i]);
                };
            };
            var fS = _Create('div', { 'class': 'col-1 form-support', 'style': 'text-align: center; padding: 15px 0;' }, M);
            var prev = _Create('input', { 'type': 'button', 'class': 'back-prev', 'value': '返回上一步' }, fS);
            prev.onclick = function () {
                !_M(_m('ul.progress .item-3')).hasClass('active') ? {} : _M(_m('ul.progress .item-3')).removeClass('active');
                M.style.cssText = 'display: none; opacity: 0; visibility: hidden;';
                uploadForm();
            };
            var submit = _Create('input', { 'type': 'button', 'class': 'submit', 'value': '我已确认, 下一步' }, fS);
            submit.onclick = function () {
                M.style.cssText = 'display: none; opacity: 0; visibility: hidden;';
                guideForm();
            };
        };

        function guideForm() {
            !_M(_m('ul.progress .item-4')).hasClass('active') ? _M(_m('ul.progress .item-4')).addClass('active') : {};
            var G = _M(fC).child('#guide-form.form');
            if (!G) {
                G = _Create('div', { 'id': 'guide-form', 'class': 'form' }, fC);
            } else {
                G.style.cssText = '';
                return;
            };
            _Create('div', { 'class': 'col-1', 'style': 'font-size: 16px; text-align: center; padding: 15px 0;', 'innerHTML': '上传作业指导书' }, G);
            var iU = _Create('div', { 'class': 'col-1 file-upload' }, G);
            var uC = _Create('div', { 'class': 'upload-container' }, iU);
            var uD = _Create('div', { 'class': 'upload-drop', 'style': 'text-align: center;', 'innerHTML': '<div style="padding-top: 200px; padding-bottom: 5px;">拖拽Word文件到这里</div><span class="icon"></span>' }, uC);
            var FileList = [];
            uD.addEventListener('dragover', function (e) { e.preventDefault(); });
            uD.addEventListener('drop', function (e) {
                e.preventDefault();
                var F = e.dataTransfer.files;
                for (var i = 0; i < F.length; i++) {
                    if (F[i].type.match('application/msword') == null && F[i].type.match('application/vnd.openxmlformats-officedocument.wordprocessingml.document') == null) {
                        Dialog.Alert('你选择的文件类型不是Word文件! 请重新选择!');
                        return;
                    };
                    if (!FileList.length) {
                        _M(uD).removeStyle('text-align').empty();
                    };
                    var fP = _Create('div', { 'class': 'file-preview', 'title': '查看文件' }, uD);
                    var fI = _Create('div', { 'class': 'file-word' }, fP);
                    var fn = _Create('div', { 'class': 'file-name', 'innerText': F[i].name }, fP);
                    FileList.push(F[i]);
                };
            });
            var uW = _Create('div', { 'class': 'upload-wrap', 'innerHTML': '<input type="file" class="upload" multiple="multiple" accept="application/msword, application/vnd.openxmlformats-officedocument.wordprocessingml.document" value="上传文件"><span class="icon"></span>本地上传文件' }, uC);
            _M(uW).child('input[type=file]').onchange = function () {
                var filelist = this.files;
                for (var i = 0; i < filelist.length; i++) {
                    if (filelist[i].type.match('application/msword') == null && filelist[i].type.match('application/vnd.openxmlformats-officedocument.wordprocessingml.document') == null) {
                        Dialog.Alert('你选择的文件类型不是Word文件! 请重新选择!');
                        return;
                    };
                    if (!FileList.length) {
                        _M(uD).removeStyle('text-align').empty();
                    };
                    var fP = _Create('div', { 'class': 'file-preview', 'title': '查看文件' }, uD);
                    var fI = _Create('div', { 'class': 'file-word' }, fP);
                    var fn = _Create('div', { 'class': 'file-name', 'innerText': filelist[i].name }, fP);
                    FileList.push(filelist[i]);
                };
            };
            var fS = _Create('div', { 'class': 'col-1 form-support', 'style': 'text-align: center; padding: 15px 0;' }, G);
            var prev = _Create('input', { 'type': 'button', 'class': 'back-prev', 'value': '返回上一步' }, fS);
            prev.onclick = function () {
                !_M(_m('ul.progress .item-4')).hasClass('active') ? {} : _M(_m('ul.progress .item-4')).removeClass('active');
                G.style.cssText = 'display: none; opacity: 0; visibility: hidden;';
                materialForm();
            };
            var submit = _Create('input', { 'type': 'button', 'class': 'submit', 'value': '我已确认, 下一步' }, fS);
            submit.onclick = function () {
                G.style.cssText = 'display: none; opacity: 0; visibility: hidden;';
                repairForm();
            };
        };

        function repairForm() {
            !_M(_m('ul.progress .item-5')).hasClass('active') ? _M(_m('ul.progress .item-5')).addClass('active') : {};
            var R = _M(fC).child('#repair-form.form');
            if (!R) {
                R = _Create('div', { 'id': 'repair-form', 'class': 'form' }, fC);
            } else {
                R.style.cssText = '';
                return;
            };
            _Create('div', { 'class': 'col-1', 'style': 'font-size: 16px; text-align: center; padding: 15px 0;', 'innerHTML': '上传模具维保记录' }, R);
            var iU = _Create('div', { 'class': 'col-1 file-upload' }, R);
            var uC = _Create('div', { 'class': 'upload-container' }, iU);
            var uD = _Create('div', { 'class': 'upload-drop', 'style': 'text-align: center;', 'innerHTML': '<div style="padding-top: 200px; padding-bottom: 5px;">拖拽Excel文件到这里</div><span class="icon"></span>' }, uC);
            var FileList = [];
            uD.addEventListener('dragover', function (e) { e.preventDefault(); });
            uD.addEventListener('drop', function (e) {
                e.preventDefault();
                var F = e.dataTransfer.files;
                for (var i = 0; i < F.length; i++) {
                    if (F[i].type.match('application/vnd.ms-excel') == null && F[i].type.match('application/vnd.openxmlformats-officedocument.spreadsheetml.sheet') == null) {
                        Dialog.Alert('你选择的文件类型不是Excel文件! 请重新选择!');
                        return;
                    };
                    if (!FileList.length) {
                        _M(uD).removeStyle('text-align').empty();
                    };
                    var fP = _Create('div', { 'class': 'file-preview', 'title': '查看文件' }, uD);
                    var fI = _Create('div', { 'class': 'file-excel' }, fP);
                    var fn = _Create('div', { 'class': 'file-name', 'innerText': F[i].name }, fP);
                    FileList.push(F[i]);
                };
            });
            var uW = _Create('div', { 'class': 'upload-wrap', 'innerHTML': '<input type="file" class="upload" multiple="multiple" accept="application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" value="上传文件"><span class="icon"></span>本地上传文件' }, uC);
            _M(uW).child('input[type=file]').onchange = function () {
                var filelist = this.files;
                for (var i = 0; i < filelist.length; i++) {
                    if (filelist[i].type.match('application/vnd.ms-excel') == null && filelist[i].type.match('application/vnd.openxmlformats-officedocument.spreadsheetml.sheet') == null) {
                        Dialog.Alert('你选择的文件类型不是Excel文件! 请重新选择!');
                        return;
                    };
                    if (!FileList.length) {
                        _M(uD).removeStyle('text-align').empty();
                    };
                    var fP = _Create('div', { 'class': 'file-preview', 'title': '查看文件' }, uD);
                    var fI = _Create('div', { 'class': 'file-excel' }, fP);
                    var fn = _Create('div', { 'class': 'file-name', 'innerText': filelist[i].name }, fP);
                    FileList.push(filelist[i]);
                };
            };
            var fS = _Create('div', { 'class': 'col-1 form-support', 'style': 'text-align: center; padding: 15px 0;' }, R);
            var prev = _Create('input', { 'type': 'button', 'class': 'back-prev', 'value': '返回上一步' }, fS);
            prev.onclick = function () {
                !_M(_m('ul.progress .item-5')).hasClass('active') ? {} : _M(_m('ul.progress .item-5')).removeClass('active');
                R.style.cssText = 'display: none; opacity: 0; visibility: hidden;';
                guideForm();
            };
            var submit = _Create('input', { 'type': 'button', 'class': 'submit', 'value': '我已确认, 下一步' }, fS);
            submit.onclick = function () {
                R.style.cssText = 'display: none; opacity: 0; visibility: hidden;';
            };
        };

        function imgView(e) {
            var M = _m('.mask');
            if (!M) {
                M = _Create('div', { 'class': 'mask' }, document.body);
            };
            if (!e.src) {
                Dialog.Alert('查看图片失败!');
                return;
            };
            var img = _Create('img', { 'src': e.src });
            var viewerWidth = (img.width > 800 ? 800 : img.width);
            var viewer = _Create('div', { 'class': 'img-viewer', 'style': 'width: ' + viewerWidth + 'px;' }, M);
            viewer.appendChild(img);
            var cl = _Create('span', { 'class': 'close' }, viewer);
            cl.onclick = function () {
                _M(M).remove();
            };
            document.onkeydown = function (e) {
                if (e.keyCode == 27) {
                    _M(M).remove();
                    document.onkeydown = function () { };
                };
            };
        };

        function pdfView(e) {
            var M = _m('.mask');
            if (!M) {
                M = _Create('div', { 'class': 'mask' }, document.body);
            };
            if (!e.src) {
                Dialog.Alert('查看文件失败!');
                return;
            };
            var viewer = _Create('div', { 'class': 'pdf-viewer', 'style': 'width: 800px;' }, M);
            _Create('embed', { 'src': e.src, 'type': 'application/pdf', 'title': 'pdf', 'quality': 'high' }, viewer);
            var cl = _Create('span', { 'class': 'close' }, viewer);
            cl.onclick = function () {
                _M(M).remove();
            };
            document.onkeydown = function (e) {
                if (e.keyCode == 27) {
                    _M(M).remove();
                    document.onkeydown = function () { };
                };
            };
        };
    };
    function gotoView() {
        var vS = _m('.view-support');
        if (!vS) {
            _M(_m('.support-container')).empty();
            vS = _Create('div', { 'class': 'view-support' }, _m('.support-container'));
        };
        _M(vS).empty();
        var vC = _Create('div', { 'class': 'view-container' }, vS),
                s = _Create('div', { 'class': 'search-container' }, vC),
               V = _Create('div', { 'class': 'view' }, vC);
        _Create('input', { 'type': 'text' }, s);
        var sbt = _Create('input', { 'class': 'search', 'type': 'button', 'value': '查询' }, s);
        sbt.onclick = function () {

        };
        _Create('div', { 'class': 'view-tr', 'innerHTML': '<div class="view-td">模具编号</div><div class="view-td">电子标签NO</div><div class="view-td">产品名称</div><div class="view-td">客户名称</div><div class="view-td">适用机型</div><div class="view-td">状态</div><div class="view-td"></div>' }, V);
        _Ajax({
            url: Mb.url + 'selectmodelall',
            method: 'get',
            data: '',
            success: function (r) {
                r = JSON.parse(r);
                for (var i = 0; i < r.length; i++) {
                    var tr = _Create('div', { 'class': 'view-tr' }, V);
                    tr.rid = r[i].id;
                    _Create('div', { 'class': 'view-td', 'innerText': r[i].mouldNumber }, tr);
                    _Create('div', { 'class': 'view-td', 'innerText': r[i].rfid }, tr);
                    _Create('div', { 'class': 'view-td', 'innerText': r[i].productName }, tr);
                    _Create('div', { 'class': 'view-td', 'innerText': r[i].customerName }, tr);
                    _Create('div', { 'class': 'view-td', 'innerText': r[i].applicableModels }, tr);
                    _Create('div', { 'class': 'view-td', 'innerText': r[i].status }, tr);
                    var td = _Create('div', { 'class': 'view-td' }, tr);
                    var cbt = _Create('input', { 'class': 'check', 'type': 'button', 'value': '查看' }, td);
                    cbt.onclick = function () {
                        _Ajax({
                            url: Mb.url + 'selectmodeuid',
                            method: 'post',
                            postType: 'json',
                            data: [{
                                id: _M(this).parent('.view-tr')[0].rid
                            }],
                            success: function (_r) {
                                _r = JSON.parse(_r);
                                console.log(_r[0])
                                gotoCheck(_r[0]);
                            },
                            fail: function () {
                                console.log('error');
                            }
                        });
                    };
                    var dbt = _Create('input', { 'class': 'delete', 'type': 'button', 'value': '删除' }, td);
                    dbt.onclick = function () {
                        var that = this;
                        Dialog.Confirm('确定要删除吗?', function (e) {
                            if (e) {
                                _Ajax({
                                    url: Mb.url + 'Dmouldinfo',
                                    method: 'post',
                                    postType: 'json',
                                    data: [{
                                        id: _M(that).parent('.view-tr')[0].rid
                                    }],
                                    success: function (r) {
                                        Dialog.Alert('删除成功!');
                                        _M(_M(that).parent('.view-tr')[0]).remove();
                                    },
                                    fail: function () {
                                        console.log('error');
                                    }
                                });
                            };
                        });
                    };
                };
            },
            fail: function (error) {
                console.error('error!');
            }
        });
        function gotoCheck(c) {
            if (!c) {
                return;
            };
            var aS = _m('.add-support');
            if (!aS) {
                _M(_m('.support-container')).empty();
                aS = _Create('div', { 'class': 'add-support' }, _m('.support-container'));
            };
            _M(aS).empty();
            var fC = _Create('div', { 'class': 'form-container' }, aS),
                   F = _Create('div', { 'class': 'form' }, fC),
                  fS = _Create('div', { 'class': 'form-support' }, fC);
            _Create('div', { 'class': 'form-tr', 'innerHTML': '<div class="form-td">模具信息明细表查看</div>' }, F);
            var formData = {
                mouldNumber: '模具编号',
                rfid: '电子标签NO',
                productName: '产品名称',
                customerName: '客户名称',
                cavityNumber: '模腔数',
                mouldLife: '模具寿命',
                applicableModels: '适用机型',
                useRequirements: '使用要求',
                status: '状态',
                remarks: '备注'
            };
            var tr1 = _Create('div', { 'class': 'form-tr' }, F),
                tr2 = _Create('div', { 'class': 'form-tr' }, F),
                tr3 = _Create('div', { 'class': 'form-tr' }, F),
                tr4 = _Create('div', { 'class': 'form-tr' }, F), i = 0;
            for (var item in formData) {
                var tr = eval('tr' + parseInt(i / 3 + 1));
                if (item != 'remarks') {
                    _Create('div', { 'class': 'form-td', 'innerText': formData[item] }, tr);
                    var td = _Create('div', { 'class': 'form-td', 'innerText': c[item] }, tr);
                } else {
                    _Create('div', { 'class': 'form-td', 'style': 'line-height: 65px;', 'innerText': formData[item] }, tr);
                    var td = _Create('div', { 'class': 'form-td textarea', 'innerText': c[item] }, tr);
                };
                i++;
            };
            var quit = _Create('input', { 'type': 'button', 'class': 'quit', 'value': '返回' }, fS);
            quit.onclick = function () {
                gotoView();
            };
        };
    };

    return Mb;
});

document.onkeydown = function () {
    if (Dialog.DA == 1) {
        if (event.keyCode == 123) {
            return false;
        };
    };
};

//  对话框承载.
var Dialog = {};
// 对话框初始化.
Dialog.DA = 0;
//  弹出模具后台专有alert框.
Dialog.Alert = function (C) {
    if (!_m('.mask .confirm-container') && !_m('.mask .alert-container') && !_m('.mask .prompt-container')) {
        Dialog.DA = 1;
        var M = _Create('div', { 'class': 'mask' }, document.body);
        var aC = _Create('div', { 'class': 'alert-container' }, M);
        var aS = _Create('div', { 'class': 'alert-section' }, aC);
        var ac = _Create('div', { 'class': 'alert-content', 'innerHTML': C }, aS);
        var aA = _Create('div', { 'class': 'alert-action' }, aS);
        var S = _Create('span', { 'class': 'sure', 'innerHTML': '确定' }, aA);
        S.onclick = function () {
            M.remove();
            Dialog.DA = 0;
        };
    };
};
//  弹出模具后台专有confirm框.
Dialog.Confirm = function (C, callback) {
    if (!_m('.mask .confirm-container') && !_m('.mask .alert-container') && !_m('.mask .prompt-container')) {
        Dialog.DA = 1;
        var M = _Create('div', { 'class': 'mask' }, document.body);
        var cC = _Create('div', { 'class': 'confirm-container' }, M);
        var cS = _Create('div', { 'class': 'confirm-section' }, cC);
        var cc = _Create('div', { 'class': 'confirm-content', 'innerHTML': C }, cS);
        var cA = _Create('div', { 'class': 'confirm-action' }, cS);
        var S = _Create('span', { 'class': 'sure', 'innerHTML': '确定' }, cA);
        S.onclick = function () {
            M.remove();
            Dialog.DA = 0;
            if (callback != '' && callback != null && callback != undefined && typeof callback == 'function') {
                callback(true);
            }
        }
        var c = _Create('span', { 'class': 'cancel', 'innerHTML': '取消' }, cA);
        c.onclick = function () {
            M.remove();
            Dialog.DA = 0;
            if (callback != '' && callback != null && callback != undefined && typeof callback == 'function') {
                callback(false);
            };
        };
    };
};
//  弹出模具后台专有prompt框.
Dialog.Prompt = function (C, callback) {
    if (!_m('.mask .confirm-container') && !_m('.mask .alert-container') && !_m('.mask .prompt-container')) {
        Dialog.DA = 1;
        var M = _Create('div', { 'class': 'mask' }, document.body);
        var pC = _Create('div', { 'class': 'prompt-container' }, M);
        var pS = _Create('div', { 'class': 'prompt-section' }, pC);
        var pc = _Create('div', { 'class': 'prompt-content' }, pS);
        var pT = _Create('div', { 'class': 'prompt-title', 'innerHTML': C }, pc);
        var r = _Create('input', { 'type': 'text' }, pc);
        var pA = _Create('div', { 'class': 'prompt-action' }, pS);
        var S = _Create('span', { 'class': 'sure', 'innerHTML': '确定' }, pA);
        S.onclick = function () {
            var R = r.value;
            M.remove();
            Dialog.DA = 0;
            if (callback != '' && callback != null && callback != undefined && typeof callback == 'function') {
                callback(R);
            };
        };
        var c = _Create('span', { 'class': 'cancel', 'innerHTML': '取消' }, pA);
        c.onclick = function () {
            M.remove();
            Dialog.DA = 0;
            if (callback != '' && callback != null && callback != undefined && typeof callback == 'function') {
                callback(null);
            };
        };
    };
};