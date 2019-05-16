!(function (window, document) {
    var menu_tree = {
        init: function () {
            var _this = this;
            _this.expnode = [];
            _this.update_menu();
        },
        init_menu: function () {
            var _this = this;
            $.ajax({
                url: '/FineBi/getFrMenu',
                type: 'post',
                async: false,
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    if (data.code == 0) {
                        //渲染子菜单
                        $('#tt').tree({
                            data: data.data,
                            animate: true,
                            onClick: function (node) {
                                var leaf = $('#tree').tree('isLeaf', node.target);
                                if (leaf) {
                                    _this.openTab(node.text, node.url);
                                } else {
                                    var node = $('#tt').tree('find', node.id);
                                    if (node.state == 'closed') {
                                        $('#tt').tree('expand', node.target);
                                    } else {
                                        $('#tt').tree('collapse', node.target);
                                    }
                                }
                            },
                            onBeforeExpand: function (node) {
                                // 将展开节点信息添加至展开数组中
                                _this.expnode.push(node.id.toString());
                            },
                            onBeforeCollapse: function (node) {
                                var i = _this.expnode.indexOf(node.id.toString());
                                if (i >= 0) {
                                    _this.expnode.splice(i, 1);
                                }
                            },
                            onLoadSuccess: function () {
                                var list = [];
                                for (var j = 0; j < _this.expnode.length; j++) {
                                    list.push(_this.expnode[j])
                                }
                                $("#tt").tree("collapseAll");
                                for (var i = 0; i < list.length; i++) {
                                    var node = $('#tt').tree('find', list[i]);
                                    $('#tt').tree('expand', node.target);
                                }
                            },
                            onContextMenu: function (e, node) {
                                var leaf = $('#tree').tree('isLeaf', node.target);
                                e.preventDefault();
                                if (!leaf) {
                                    $('#leaf').menu('show', {
                                        left: e.pageX,
                                        top: e.pageY
                                    });
                                }
                            }
                        });
                    } else {
                        layer.alert(data.msg,
                            {
                                skin: 'layui-layer-lan'
                                , title: '错误'
                                , icon: 5
                                , closeBtn: 0
                                , anim: 6
                                , move: false
                            }
                            , function () {
                                window.location.href = "/user/logout";
                            }
                        );
                        setTimeout(function () {
                            window.location.href = "/user/logout";
                        }, 10000);
                    }
                }
            });
        },

        update_menu: function () {
            var _this = this;
            $.ajax({
                url: '/FineBi/updateAllMenu',
                type: 'post',
                success: function () {
                    _this.init_menu();
                }
            })
        },
        //增加多个面板
        openTab: function (nodetxt, url) {
            if (url) {
                if ($("#manageTab").tabs('exists', nodetxt)) {
                    $("#manageTab").tabs('select', nodetxt);
                } else {
                    var html = '' +
                        '<div title="Iframe" data-options="closable:true,fit:true" style="overflow:hidden;width:100%;height:100%;">' +
                        '<iframe scrolling="yes" frameborder="0" src="' + url + '" style="width:100%;height:100%;"></iframe>' +
                        '</div>';
                    $('#manageTab').tabs('add', {
                        title: nodetxt,
                        content: html,
                        closable: true
                    });
                }
            }
        },
        open_child_tab: function (nodetxt, url) {
            if (url) {
                if ($("#manageTab").tabs('exists', nodetxt)) {
                    $("#manageTab").tabs('close', nodetxt);
                }
                var html = '' +
                    '<div title="Iframe" data-options="closable:true,fit:true" style="overflow:hidden;width:100%;height:100%;">' +
                    '<iframe scrolling="yes" frameborder="0" src="' + url + '" style="width:100%;height:100%;"></iframe>' +
                    '</div>';
                $('#manageTab').tabs('add', {
                    title: nodetxt,
                    content: html,
                    closable: true
                });
            }
        }
    };
    window.menu_tree = menu_tree;
}(window, document));

$(function () {
    //左侧菜单渲染
    //设置用户名
    $.ajax({
        type: "POST",
        url: "/user/getSessionUser",
        dataType: 'json',
        success: function (res) {
            if (res.success) {
                $('#userName').text(res.data.realname);
            }
        }
    });

    var c = $(".easyui-layout");

    var p = c.layout('panel', 'north');  //get the north panel
    var oldHeight = p.panel('panel').outerHeight(); //获得north panel 的原高度
    p.panel('resize', {height: '37px'}); //设置north panel 新高度
    var newHeight = p.panel('panel').outerHeight();
    c.layout('resize', {height: c.height() + newHeight - oldHeight});  //重新设置整个布局的高度

    $('body').addClass('active');
    // 初始化菜单
    menu_tree.init();

});