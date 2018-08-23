<import resource="classpath:/alfresco/site-webscripts/org/alfresco/share/imports/share-header.lib.js">

model.jsonModel = {
   rootNodeId: "share-header",
   services: getHeaderServices(),
   widgets: [
      {
         id: "SHARE_VERTICAL_LAYOUT",
         name: "alfresco/layout/VerticalWidgets",
         config: 
         {
            widgets: getHeaderModel()
         }
      }
   ]
};


var userMenuWidgets = widgetUtils.findObject(model.jsonModel, "id",
    "HEADER_USER_MENU");
if (userMenuWidgets != null) {

    var logoutWidget = widgetUtils.findObject(model.jsonModel, "id",
        "HEADER_USER_MENU_LOGOUT");

    if (logoutWidget == null) {
        userMenuWidgets.config.widgets.push({
            id: "HEADER_USER_MENU_LOGOUT",
            name: "alfresco/header/AlfMenuItem",
            config: {
                id: "HEADER_USER_MENU_LOGOUT",
                label: "logout.label",
                iconClass: "alf-user-logout-icon",
                publishTopic: "ALF_DOLOGOUT",
            }
        });
    }
}


var myservices = model.jsonModel.services;
for (var i = 0, len = myservices.length; i < len; i++) {
    if (typeof myservices[i] === "string"
        && myservices[i] == "alfresco/services/LogoutService") {
        model.jsonModel.services[i] = {
            name: "share/services/LogoutService",
            config: {
                "casLogout": "https://bbs-pc/cas/logout",
                "paramName": "service",
                "logoutDestination": "http://bbs-pc/share"
            }
        };
    }
}